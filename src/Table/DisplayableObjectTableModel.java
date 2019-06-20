package Table;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DisplayableObjectTableModel<T> extends ObjectTableModel<T> {
    private Map<Integer, ColumnInfo> columnInfoMap;

    public DisplayableObjectTableModel(Class<T> tClass) {
        init(tClass);
    }

    private void init(Class<T> tClass) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(tClass);
            this.columnInfoMap = new HashMap<>();
            for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
                Method m = pd.getReadMethod();
                DisplayAs displayAs = m.getAnnotation(DisplayAs.class);
                if (displayAs == null) {
                    continue;
                }
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.displayName = displayAs.value();
                columnInfo.index = displayAs.index();
                columnInfo.editable = displayAs.editable();
                if (displayAs.editable()) {
                    columnInfo.setterMethod = pd.getWriteMethod();
                }
                columnInfo.getterMethod = m;
                columnInfo.propertyName = pd.getName();
                columnInfoMap.put(columnInfo.index, columnInfo);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getValueAt(T t, int columnIndex) {
        try {
            return columnInfoMap.get(columnIndex)
                    .getterMethod.invoke(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getColumnCount() {
        return columnInfoMap.size();
    }

    @Override
    public String getColumnName(int column) {
        ColumnInfo columnInfo = columnInfoMap.get(column);
        if (columnInfo == null) {
            throw new RuntimeException("No column found for index " + column);
        }
        return columnInfo.displayName;
    }
    public Class<?> getColumnClass(int columnIndex) {
        ColumnInfo columnInfo = columnInfoMap.get(columnIndex);
        return columnInfo.getterMethod.getReturnType();
    }

    @Override
    public String getFieldName(int column) {
        ColumnInfo columnInfo = columnInfoMap.get(column);
        return columnInfo.propertyName;
    }

    @Override
    public boolean isColumnEditable(int columnIndex) {
        ColumnInfo columnInfo = columnInfoMap.get(columnIndex);
        return columnInfo.editable;
    }

    @Override
    public boolean setObjectFieldValue(T t, int column, Object value) {
        ColumnInfo columnInfo = columnInfoMap.get(column);
        try {
            if (columnInfo.setterMethod != null) {
                columnInfo.setterMethod.invoke(t, value);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private static class ColumnInfo {
        private Method setterMethod;
        private Method getterMethod;
        private int index;
        private String displayName;
        private String propertyName;
        private boolean editable;
    }
}
