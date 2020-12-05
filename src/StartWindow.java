import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartWindow {
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel("Click Enter to continue like an user");
    private JTextField login = new JTextField();
    private JTextField password = new JTextField();
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");

    StartWindow() {
        JPanel panel = new JPanel();
        label.setBounds(50, 50, 300, 30);
        loginLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setBounds(50, 150, 100, 30);
        login.setBounds(150, 100, 100, 30);
        password.setBounds(150, 150, 100, 30);
        panel.add(label);
        panel.add(loginLabel);
        panel.add(login);
        panel.add(password);
        panel.add(passwordLabel);
        frame.pack();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        login.addKeyListener(new NextWindowListener(login, password, frame));
        password.addKeyListener(new NextWindowListener(login, password, frame));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 400);
        frame.setResizable(false);
        frame.setLocation(600, 100);
        frame.setVisible(true);
    }

    public class NextWindowListener implements KeyListener {
        JTextField login, password;
        JFrame frame;
        public NextWindowListener(JTextField login, JTextField password, JFrame frame) {
            this.login = login;
            this.password = password;
            this.frame = frame;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (login.getText().equals("admin") && password.getText().equals("admin")) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new ChangeLevelWindow();
                        }
                    });
                    thread.start();
                    frame.setVisible(false);
                    frame.setVisible(false);
                } else {
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
