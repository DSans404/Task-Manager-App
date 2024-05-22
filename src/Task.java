import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Task {
    private JPanel taskPanel;
    private JCheckBox checkBox;
    private JLabel taskLabel;
    private JPanel parentPanel;

    public Task(String taskText, JPanel parentPanel) {
        this.parentPanel = parentPanel;
        taskPanel = new JPanel();
        taskPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        checkBox = new JCheckBox();
        taskLabel = new JLabel(taskText);

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTaskStatus();
                moveCompletedTaskToEnd();
            }
        });

        taskPanel.add(checkBox);
        taskPanel.add(taskLabel);

        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        popupMenu.add("Rename").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renameTask();
            }
        });

        taskPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(taskPanel, e.getX(), e.getY());
                }
            }
        });
    }

    private void updateTaskStatus() {
        if (checkBox.isSelected()) {
            taskLabel.setForeground(Color.GRAY);
            taskLabel.setFont(new Font(taskLabel.getFont().getName(), Font.ITALIC, taskLabel.getFont().getSize()));
        } else {
            taskLabel.setForeground(Color.BLACK);
            taskLabel.setFont(new Font(taskLabel.getFont().getName(), Font.PLAIN, taskLabel.getFont().getSize()));
        }
    }

    private void moveCompletedTaskToEnd() {
        if (checkBox.isSelected()) {
            parentPanel.remove(checkBox);
            parentPanel.add(taskPanel);
            parentPanel.revalidate();
            parentPanel.repaint();
        }
    }

    private void renameTask() {
        String newTaskText = JOptionPane.showInputDialog(null, "Enter New Task Name: ", taskLabel.getText());
        if (newTaskText != null && !newTaskText.isEmpty()) {
            taskLabel.setText(newTaskText);
        }
    }

    private void deleteTask() {
        parentPanel.remove(taskPanel);
        parentPanel.revalidate();
        parentPanel.repaint();
    }

    public JPanel getTaskPanel() {
        return taskPanel;
    }
}
