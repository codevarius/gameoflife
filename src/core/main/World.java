package core.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class World {

    private boolean alive; // if true -> game continue running / if false -> game over
    private JFrame frame; // app window
    private  JPanel panel; //canvas
    private ArrayList <Bot> botBox; //box of bots
    static  int worldWidth = 800; //app window width
    static  int worldHeight = 600; //app window height


    World() {

        //prepare app window
        this.frame = new JFrame();
        frame.setTitle("core.main.World begin");
        frame.setBounds(100,100, worldWidth,worldHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //load botBox with new bots
        this.botBox = new ArrayList<>();
        int populationSize = 25;
        for (int i = 0; i < populationSize; i++ ) {
            botBox.add(new Bot(i));
        }

        //prepare canvas
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

        //pack all and launch
        frame.add(panel);
        setAlive(true);
        frame.setVisible(true);

    }

    //changes game main state (running or killed)
    private void setAlive(boolean alive) {
        this.alive = alive;

    }

    //get current game status
    boolean getAlive() {
        return alive;
    }

    //update world objects
    void update() {
        for (Bot bot:botBox) {
            bot.update();
        }
    }

    //render world objects
    void render() {
        panel.repaint();
    }

}
