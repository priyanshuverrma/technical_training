import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

class StudentFrame extends JFrame {
    public StudentFrame() {
        setTitle("Student Login");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        add(buttonPanel, BorderLayout.CENTER);

        // Add buttons
        JButton timetableButton = createButton("Timetable", "https://1.bp.blogspot.com/-_H20oKI1UtU/X2cnZqY6KuI/AAAAAAAACyQ/OsBE6e--FfAgacud8LPmbkl-LCStwNqJACLcBGAsYHQ/s1527/my-timetable-2-classroom-posters_58258_1.jpg");
        JButton resultButton = createButton("Result", "www.cbse.nic.in");
        JButton attendanceButton = createLinkButton("Attendance", "file:///C:/Users/this%20%20pc/Desktop/PRIYANSHU%20VERMA%20MINOR%20PROJECT/attendance.html");
        JButton complainButton = createLinkButton("Complain", "file:///C:/Users/this%20%20pc/Desktop/PRIYANSHU%20VERMA%20MINOR%20PROJECT/complaint.html");

        buttonPanel.add(timetableButton);
        buttonPanel.add(resultButton);
        buttonPanel.add(attendanceButton);
        buttonPanel.add(complainButton);
    }

    private JButton createButton(String text, final String url) {
        JButton button = new JButton(text);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 16));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!url.isEmpty()) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        return button;
    }

    private JButton createLinkButton(String text, final String url) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLUE);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 16));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!url.isEmpty()) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        return button;
    }
}

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SCHOOL SYSTEM");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);

        // Create a panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("background.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        frame.add(panel);

        // Create a sub-panel for the top buttons and add it to the NORTH position of the main panel
        JPanel topButtonPanel = new JPanel(new GridLayout(1, 2));
        panel.add(topButtonPanel, BorderLayout.NORTH);

        // Create a sub-panel for the bottom buttons and add it to the SOUTH position of the main panel
        JPanel bottomButtonPanel = new JPanel(new GridLayout(1, 2));
        panel.add(bottomButtonPanel, BorderLayout.SOUTH);

        // Create buttons and add ActionListener to handle button click events
        JButton studentButton = createButton("Student Login", Color.RED, new StudentFrame());
        JButton teacherButton = createButton("Teacher Login", Color.DARK_GRAY, new TeacherFrame());
        JButton adminButton = createButton("Admin Login", Color.DARK_GRAY, new AdminFrame());

        topButtonPanel.add(studentButton);
        topButtonPanel.add(teacherButton);
        bottomButtonPanel.add(adminButton);

        // Create a label with big font size and center alignment
        JLabel titleLabel = new JLabel("<html><center><font size=+9>Hello Welcome to XYZ Public School's SMS<br>School Management System</font></center></html>");
        titleLabel.setForeground(Color.BLACK);
        panel.add(titleLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static JButton createButton(String text, Color bgColor, JFrame newFrame) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 20));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(true); // Show the corresponding JFrame when button is clicked
            }
        });

        return button;
    }
}

class TeacherFrame extends JFrame {
    public TeacherFrame() {
        setTitle("Teacher Login");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

        // Create a panel for sections
        JPanel sectionPanel = new JPanel(new GridLayout(1, 2));
        add(sectionPanel, BorderLayout.CENTER);

        // Add buttons for sections
        JButton attendanceButton = createButton("Attendance", "");
        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentListFrame().setVisible(true); // Show the student list frame when attendance button is clicked
            }
        });
        JButton noticeButton = createButton("Notice", "https://dpsrkp.net/category/notices/");

        sectionPanel.add(attendanceButton);
        sectionPanel.add(noticeButton);
    }

    private JButton createButton(String text, final String url) {
        JButton button = new JButton(text);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 16));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!url.isEmpty()) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        return button;
    }
}

class AdminFrame extends JFrame {
    public AdminFrame() {
        setTitle("Admin Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

        // Create a panel for admin login
        JPanel adminPanel = new JPanel(new GridLayout(3, 2));
        add(adminPanel, BorderLayout.CENTER);

        // Add labels and text fields
        JLabel idLabel = new JLabel("Admin ID:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Add buttons
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        adminPanel.add(idLabel);
        adminPanel.add(idField);
        adminPanel.add(passwordLabel);
        adminPanel.add(passwordField);
        adminPanel.add(submitButton);
        adminPanel.add(cancelButton);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform authentication here
                String adminID = idField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // Placeholder authentication
                if (adminID.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose(); // Close the AdminFrame after successful login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid admin ID or password!");
                }
            }
        });

        // Action listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the AdminFrame on cancel
            }
        });
    }
}

class StudentListFrame extends JFrame {
    public StudentListFrame() {
        setTitle("Student List");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add heading for attendance
        JLabel headingLabel = new JLabel("Attendance");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(headingLabel, BorderLayout.NORTH);

        JPanel studentPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(studentPanel);

        ArrayList<String> studentNames = getStudentNames();

        for (String name : studentNames) {
            JCheckBox checkBox = new JCheckBox(name);
            studentPanel.add(checkBox);
        }

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission
                ArrayList<String> presentStudents = new ArrayList<>();
                Component[] components = studentPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            presentStudents.add(checkBox.getText());
                        }
                    }
                }
                System.out.println("Present Students: " + presentStudents);
                // You can perform further actions here, such as saving the data to a file or database.
            }
        });
        mainPanel.add(submitButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private ArrayList<String> getStudentNames() {
        ArrayList<String> studentNames = new ArrayList<>();
        // Add 20 Indian student names
        studentNames.add("Aarav Kumar");
        studentNames.add("Aadya Singh");
        studentNames.add("Advik Sharma");
        studentNames.add("Ananya Patel");
        studentNames.add("Arnav Gupta");
        studentNames.add("Aryan Shah");
        studentNames.add("Ishaan Verma");
        studentNames.add("Kavya Reddy");
        studentNames.add("Neha Desai");
        studentNames.add("Pranav Singh");
        studentNames.add("Rehan Kumar");
        studentNames.add("Riya Sharma");
        studentNames.add("Rohan Patel");
        studentNames.add("Saisha Gupta");
        studentNames.add("Samaira Shah");
        studentNames.add("Samar Verma");
        studentNames.add("Vihaan Reddy");
        studentNames.add("Yash Desai");
        studentNames.add("Zara Singh");
        studentNames.add("Zoya Kumar");

        return studentNames;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentListFrame();
            }
        });
    }
}
