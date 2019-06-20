package Table;



import javax.swing.*;
import java.awt.*;

public class JCheckBoxWithIcon extends JCheckBox {
    private Image image;
    private int iconWidth;

    public void setCheckBoxIcon(ImageIcon imageIcon) {
        this.image = imageIcon == null ? null : imageIcon.getImage();
        Icon icon = UIManager.getIcon("CheckBox.icon");
        iconWidth = icon.getIconWidth();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            if (getWidth() > image.getWidth(null) + 8) {
                g.drawImage(image, 2 + (getWidth() + iconWidth) / 2, 0, this);
            }
        }
    }
}
