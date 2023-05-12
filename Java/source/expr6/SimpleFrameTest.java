import java.awt.*;
import javax.swing.*;

/**
 * SimpleFrameTest
 */
// public class SimpleFrameTest extends JFrame {

//   public static void main(String[] args) {
//     EventQueue.invokeLater(
//       new Runnable() {
//         public void run() {
//           SimpleFrameTest frame = new SimpleFrameTest();
//           frame.setBounds(100, 100, 400, 300);
//           frame.getContentPane().setBackground(Color.BLUE);
//           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//           frame.setVisible(true);
//         }
//       }
//     );
//   }
// }

/**
 * SimpleFrameTest
 */
public class SimpleFrameTest extends JFrame{

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            SimpleFrameTest frame = new SimpleFrameTest();
            frame.setBounds(100, 100, 400, 300);
            frame.getContentPane().setBackground(Color.ORANGE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
