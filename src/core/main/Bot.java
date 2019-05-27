package core.main;

import java.awt.*;
import java.util.Random;

class Bot {

    private   int size, x, y,step,id;
    private Color botColor;
    private static Random rnd = new Random(); //static randomize obj (one for all bots)
    private int [] dna = new int[1000];
    private int currentDnaPosition = 0;

    //bot constructor
    Bot(int id) {
        this.id = id;
        size = 4;
        botColor = Color.orange;
        x = rnd.nextInt(World.worldWidh);
        y  = rnd.nextInt(World.worldHeight);
        step = rnd.nextInt(size-1)+1;

        //generate dna chain
        for (int i=0;i<dna.length-1;i++){
            dna[i] = rnd.nextInt(4);
        }
    }

    //updating bot properties and actions
    void  update() {

        //if end of dna chain reached -> return to the beginning
        if(currentDnaPosition >= dna.length-1) {
            currentDnaPosition = 0;
        }

        //choosing next action
        switch (dna[currentDnaPosition]) {
            case 0: y = y - step; break;
            case 1: y = y + step; break;
            case 2: x = x - step; break;
            case 3: x = x + step; break;
        }

        //check if bot is out of world's borders
        if (y < 0) {
            y = World.worldHeight;
        }
        if (y > World.worldHeight) {
            y = 0;
        }
        if (x < 0) {
            x = World.worldWidh;
        }
        if (x > World.worldWidh) {
            x = 0;
        }

        //increment dna position index
        currentDnaPosition++;
    }

    //bot painting method
    void paint(Graphics graphics) {
        graphics.setColor(botColor);
        graphics.fillRect(x,y,size,size);
        graphics.setColor(Color.GREEN);
        graphics.drawString("bot"+id+" ("+x+","+y+")",x-size,y-size);
    }

    int getCurrentDnaPosition() {
        return dna[currentDnaPosition];
    }

    int getId() {
        return id;
    }
}
