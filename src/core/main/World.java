package core.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class World {

    private boolean alive;
    private JFrame frame;
    private  JPanel panel;
    private ArrayList <Bot> botBox;
    public static  int worldWidh = 800;
    public static  int worldHeight = 600;


    public World() {
        this.frame = new JFrame();
        frame.setTitle("core.main.World begin");
        frame.setBounds(100,100,worldWidh,worldHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        this.botBox = new ArrayList<Bot>();
        for (int i = 0;i < 100; i++ ) {
            botBox.add(new Bot());
        }

        this.panel = new JPanel() {
            @Override
            public void paint(Graphics graphics) {
                graphics.setColor(Color.darkGray);
                graphics.fillRect(0,0,frame.getWidth(),frame.getHeight());
                for (Bot bot:botBox) {
                    bot.paint(graphics);
                }
            }
        };
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        frame.add(panel);
        setAlive(true);
        frame.setVisible(true);

    }

    public void setAlive(boolean alive) {
        this.alive = alive;

    }

    public boolean getAlive() {
        return alive;
    }

    public void update() {
        for (Bot bot:botBox) {
            bot.update();
        }
    }

    public void render() {
        panel.repaint();
    }


}
