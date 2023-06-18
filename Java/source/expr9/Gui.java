import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {
  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu menu1, menu2, menu3;
  private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8, menuItem9;
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

    menuItem1.addActionListener(new SchoolActionListener("我的小学", "Prmary School of Baima"));
    menuItem2.addActionListener(new SchoolActionListener("我的初中", "Junior High of Baima"));
    menuItem3.addActionListener(new SchoolActionListener("我的高中", "Mein Kampf Senior High de Baima"));
    menuItem4.addActionListener(new SchoolActionListener("我的大学", "CJLU"));
    menuItem5.addActionListener(new PhotoActionListener("儿时玩伴", "R.jpg"));
    menuItem6.addActionListener(new PhotoActionListener("青梅竹马", "love.jpg"));
    menuItem7.addActionListener(new PhotoActionListener("大学室友", "R.jpg"));
    menuItem9.addActionListener(new AboutMeActionListener());

    menu3.add(menuItem9);
    menu3.add(menuItem8);

    menuItem8.addActionListener(new HobbyActionListener());

  }

  public static void main(String[] args) {
    Gui gui = new Gui();
  }

  private class SchoolActionListener implements ActionListener {
    private String schoolName;
    private String schoolInfo;

    public SchoolActionListener(String name, String info) {
      schoolName = name;
      schoolInfo = info;
    }

    public void actionPerformed(ActionEvent e) {
      JFrame schoolFrame = new JFrame(schoolName);
      JTextField schoolField = new JTextField(schoolInfo);
      schoolField.setEditable(false);
      schoolFrame.getContentPane().add(schoolField, BorderLayout.CENTER);
      schoolFrame.pack();
      schoolFrame.setVisible(true);
    }
  }

  private class PhotoActionListener implements ActionListener {
    private String photoTitle;
    private String path;

    public PhotoActionListener(String title, String path) {
      photoTitle = title;
      this.path = path;
    }

    public void actionPerformed(ActionEvent e) {
      JFrame photoFrame = new JFrame(photoTitle);
      JLabel photoLabel = new JLabel(new ImageIcon(path));
      photoFrame.getContentPane().add(photoLabel, BorderLayout.CENTER);
      photoFrame.pack();
      photoFrame.setVisible(true);
    }
  }

  private class AboutMeActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(
        frame,
        "姓名：李康峰\n年龄：18\n职业：학생",
        "关于我",
        JOptionPane.INFORMATION_MESSAGE
      );
    }
  }

  private class HobbyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFrame hobbyFrame = new JFrame("我的爱好");
      JComboBox<String> comboBox;
      JTextField textField;
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
          if (comboBox.getSelectedItem().toString().equals("学习新技术")) {
            textField.setText("恭喜！你回答正确了！");
          }
        }
      });

      hobbyFrame.getContentPane().add(comboBox, BorderLayout.NORTH);
      hobbyFrame.getContentPane().add(textField, BorderLayout.CENTER);
      hobbyFrame.setSize(1000, 1000);
      hobbyFrame.pack();
      hobbyFrame.setVisible(true);
    }
  }
}
