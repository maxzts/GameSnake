import javax.swing.*;
import java.awt.*;

//count and displays your score
public class ScorePanel extends JPanel {
    private static final int SCORE_WIDTH = 150;
    private int score = 0;
    private JLabel scoreLabel = new JLabel("Your score:");
    private JLabel actualScore = new JLabel("0");
    private JLabel speedLvl = new JLabel("Speed lvl:");
    private JLabel actualSpeedLvl = new JLabel(String.valueOf(LaunchGame.LEVEL));

    public ScorePanel() {
        this.add(scoreLabel);
        this.add(actualScore);
        this.add(speedLvl);
        this.add(actualSpeedLvl);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(SCORE_WIDTH,GameWindow.WINDOW_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void incScore(int inc) {
        score += inc;
        actualScore.setText(Integer.toString(score));
    }

    public void incLevel(int inc) {
        LaunchGame.LEVEL += inc;
        actualSpeedLvl.setText(Integer.toString(LaunchGame.LEVEL));
    }

    public int getScore() {
        return score;
    }

    public void reloadPanel() {
        score = 0;
        actualScore.setText(Integer.toString(score));
        actualSpeedLvl.setText(Integer.toString(LaunchGame.LEVEL));
    }
}