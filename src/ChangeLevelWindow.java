import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChangeLevelWindow {
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel("Your start level - " + LaunchGame.LEVEL);
    private JLabel changeLabel = new JLabel("Write number to change level");
    JTextField level = new JTextField();

    ChangeLevelWindow() {
        JPanel panel = new JPanel();
        label.setBounds(50, 50, 300, 30);
        changeLabel.setBounds(50, 100, 300, 30);
        level.setBounds(150, 150, 100, 30);
        panel.add(label);
        panel.add(changeLabel);
        panel.add(level);
        level.addKeyListener(new ChangeLevelListener(level));
        frame.pack();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setResizable(false);
        frame.setLocation(600, 100);
        frame.setVisible(true);
    }


    public class ChangeLevelListener implements KeyListener {
        JTextField level;
        public ChangeLevelListener(JTextField level) {
            this.level = level;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (level.getText().matches("[-+]?\\d+") && Integer.parseInt(level.getText()) > 0 && Integer.parseInt(level.getText()) < 8) {
                    LaunchGame.LEVEL = Integer.parseInt(level.getText());
                    System.out.println(LaunchGame.LEVEL);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new GameWindow().setUpGame();
                        }
                    });
                    thread.start();
                    frame.setVisible(false);
                }
            }
        }
        public void keyReleased(KeyEvent e) { }
        public void keyTyped(KeyEvent e) { }
    }
}
