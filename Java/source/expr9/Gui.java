import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * TODO: 填充文字w
 */

public class Gui {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem menuItem1, menuItem2,
            menuItem3, menuItem4, menuItem5,
            menuItem6, menuItem7, menuItem8, menuItem9;
    private JTextField textField;

    public Gui() {
        frame = new JFrame("Experiment9");
        frame.setSize(600, 500);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menu1 = new JMenu("成长的我");
        menu2 = new JMenu("温馨一刻");
        menu3 = new JMenu("关于我");
        menuItem1 = new JMenuItem("我的小学");
        menuItem2 = new JMenuItem("我的初中");
        menuItem3 = new JMenuItem("我的高中");
        menuItem4 = new JMenuItem("我的大学");
        menuItem5 = new JMenuItem("儿时玩伴");
        menuItem6 = new JMenuItem("青梅竹马");
        menuItem7 = new JMenuItem("大学室友");
        menuItem9 = new JMenuItem("关于我");
        menuItem8 = new JMenuItem("我的爱好");

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.add(menuItem4);
        menu2.add(menuItem5);
        menu2.add(menuItem6);
        menu2.add(menuItem7);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        textField = new JTextField(20);
        textField.setEditable(false);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(textField, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame schoolFrame = new JFrame("我的小学");
                JTextField schoolField = new JTextField("XXXX");
                schoolField.setEditable(false);
                schoolFrame.getContentPane().add(schoolField, BorderLayout.CENTER);
                schoolFrame.pack();
                schoolFrame.setVisible(true);
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame schoolFrame = new JFrame("我的初中");
                JTextField schoolField = new JTextField("YYYY");
                schoolField.setEditable(false);
                schoolFrame.getContentPane().add(schoolField, BorderLayout.CENTER);
                schoolFrame.pack();
                schoolFrame.setVisible(true);
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame schoolFrame = new JFrame("我的高中");
                JTextField schoolField = new JTextField("ZZZZ");
                schoolField.setEditable(false);
                schoolFrame.getContentPane().add(schoolField, BorderLayout.CENTER);
                schoolFrame.pack();
                schoolFrame.setVisible(true);
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame schoolFrame = new JFrame("我的大学");
                JTextField schoolField = new JTextField("CJLU");
                schoolField.setEditable(false);
                schoolFrame.getContentPane().add(schoolField, BorderLayout.CENTER);
                schoolFrame.pack();
                schoolFrame.setVisible(true);
            }
        });

        menuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame photoFrame = new JFrame("儿时玩伴");
                JLabel photoLabel = new JLabel(new ImageIcon("R.jpg"));
                photoFrame.getContentPane().add(photoLabel, BorderLayout.CENTER);
                photoFrame.pack();
                photoFrame.setVisible(true);
            }
        });

        menuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame photoFrame = new JFrame("青梅竹马");
                JLabel photoLabel = new JLabel(new ImageIcon("R.jpg"));
                photoFrame.getContentPane().add(photoLabel, BorderLayout.CENTER);
                photoFrame.pack();
                photoFrame.setVisible(true);
            }
        });

        menuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame photoFrame = new JFrame("大学室友");
                JLabel photoLabel = new JLabel(new ImageIcon("R.jpg"));
                photoFrame.getContentPane().add(photoLabel, BorderLayout.CENTER);
                photoFrame.pack();
                photoFrame.setVisible(true);
            }
        });

        menu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "姓名：张三\n年龄：25\n职业：软件工程师",
                        "关于我",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu3.add(menuItem9);

        menuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame aboutFrame = new JFrame("关于我");
                JTextField textField;
                textField = new JTextField("About Me Text");
                textField.setEditable(false);
                aboutFrame.getContentPane().add(textField, BorderLayout.CENTER);
                aboutFrame.setSize(500, 500);
                aboutFrame.pack();
                aboutFrame.setVisible(true);
            }
        });

        menu3.add(menuItem8);

        menuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame hobbyFrame = new JFrame("我的爱好");
                JComboBox<String> comboBox;
                JTextField textField;
                // 创建下拉选框
                comboBox = new JComboBox<String>();
                comboBox.addItem("阅读技术书籍");
                comboBox.addItem("编写代码");
                comboBox.addItem("参加编程竞赛");
                comboBox.addItem("学习新技术");
                comboBox.addItem("开发自己的应用程序");

                textField = new JTextField("Pls choose an option...");
                textField.setEditable(false);

                comboBox.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (comboBox.getSelectedItem()
                                .toString().equals("学习新技术")) {
                            textField.setText("恭喜！你回答正确了！!");
                        }
                    }
                });

                hobbyFrame.getContentPane().add(comboBox, BorderLayout.NORTH);
                hobbyFrame.getContentPane().add(textField, BorderLayout.CENTER);
                hobbyFrame.setSize(500, 500);
                hobbyFrame.pack();
                hobbyFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
