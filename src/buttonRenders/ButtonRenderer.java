
package buttonRenders;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer(Color c) {
        setOpaque(true);
        setBackground(c); 
        setForeground(Color.WHITE);          
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Edit" : value.toString());
        return this;
    }
}
