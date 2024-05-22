import javax.swing.*;
import java.awt.*;

public class AddTask {
    private JPanel panel;
    private JTextField taskTextField;
    private JButton addButton;

    public AddTask() {
        panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Task: ");
        label.setBounds(10, 10, 50, 20);

        taskTextField = new JTextField();
        taskTextField.setBounds(70, 10, 200, 20);

        ImageIcon icon = new ImageIcon("images/add.png");
        Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        addButton = new JButton("Add Task", scaledIcon);
        addButton.setBounds(10, 40, 120, 30);

        addButton.setMargin(new Insets(0,0,0,0));
        addButton.setFocusPainted(false);

        panel.add(label);
        panel.add(taskTextField);
        panel.add(addButton);
    }

    public JPanel getPanel() {
        return panel;
    }
    public JTextField getTaskTextField() {
        return taskTextField;
    }
    public JButton getAddButton() {
        return addButton;
    }
}
