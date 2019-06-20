package Example;





import java.time.LocalDate;

import Table.DisplayAs;
import Table.Editable;

public class Employee implements Editable {
    public static final String[] DEPT_LIST = {"Admin", "Account", "IT", "Sales"};
    public static final int DEPT_INDEX = 1;
    private String name;
    private String dept;
    private String phone;
    private Boolean fullTime;
    private LocalDate dateOfBirth;

    @DisplayAs(value = "Employee Name", index = 0, editable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DisplayAs(value = "Department", index = DEPT_INDEX, editable = true)
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @DisplayAs(value = "Work Phone", index = 2, editable = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DisplayAs(value = "Full Time", index = 3, editable = true)
    public Boolean getFullTime() {
        return fullTime;
    }

    public void setFullTime(Boolean fullTime) {
        this.fullTime = fullTime;
    }

    @DisplayAs(value = "Date Of Birth", index = 4)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean isEditable() {
        return !dept.equalsIgnoreCase("Admin");
    }
}