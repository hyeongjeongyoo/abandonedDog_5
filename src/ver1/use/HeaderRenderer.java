package ver1.use;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class HeaderRenderer extends JLabel implements TableCellRenderer {
    public HeaderRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
        setBackground(new Color(13, 170, 93));
        setForeground(Color.white);
        setFont(new Font("Noto Sans KR", Font.BOLD, 14)); // 폰트 설정
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
