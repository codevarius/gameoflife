package core.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class World {

    private boolean alive;
    private JFrame frame;
    private  JPanel panel;
    private ArrayList <Bot> botBox;
    static  int worldWidh = 800;
    static  int worldHeight = 600;


    World() {
        this.frame = new JFrame();
        frame.setTitle("core.main.World begin");
        frame.setBounds(100,100,worldWidh,worldHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        this.botBox = new ArrayList<>();
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

    private void setAlive(boolean alive) {
        this.alive = alive;

    }

    boolean getAlive() {
        return alive;
    }

    void update() {
        for (Bot bot:botBox) {
            bot.update();
        }
    }

    void render() {
        panel.repaint();
    }


}
