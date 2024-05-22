import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerApp extends JFrame{

    //Instance var
    private static JPanel taskPanel;

    public TaskManagerApp() {
        setTitle("Task Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 460, 400);

        AddTask addTask = new AddTask();
        JButton addButton = new AddTask().getAddButton();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTask();
            }
        });

        JButton clearButton = new JButton("Clear All");
        clearButton.setBounds(250, 420, 120, 30);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTask();
            }
        });

        addButton.setBounds(120, 420, 120, 30);
        add(scrollPane);
        add(addButton);
        add(clearButton);

        setVisible(true);
        setResizable(false);
    }

    private static void addNewTask() {
        AddTask addTask = new AddTask();
        int result = JOptionPane.showConfirmDialog(null, addTask.getPanel(), "Create New Task", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String taskText = addTask.getTaskTextField().getText();
            if (!taskText.isEmpty()) {
                Task newTask = new Task(taskText, taskPanel);
                taskPanel.add(newTask.getTaskPanel());
                taskPanel.revalidate();
                taskPanel.repaint();
            }
        }
    }

    private static void clearAllTask() {
        taskPanel.removeAll();
        taskPanel.revalidate();
        taskPanel.repaint();
    }
    public static void main(String[] args) {
        new TaskManagerApp();
    }
}