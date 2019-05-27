package core.main;

import java.awt.*;
import java.util.Random;

public class Bot {
  private   int size, x, y;
  private Color botColor;
  private static Random rnd = new Random();
  private int [] dna = new int[1000];
  private int currentDnaPosition = 0;



    public Bot() {
        size = 4;
        botColor = Color.orange;
        x = rnd.nextInt(World.worldWidh);
        y  = rnd.nextInt(World.worldHeight);
        for (int i=0;i<dna.length-1;i++){
            dna[i] = rnd.nextInt(4);
        }
    }
    public void  update() {

        if(currentDnaPosition >= dna.length-1) {
            currentDnaPosition = 0;
        }
        switch (dna[currentDnaPosition]) {
            case 0: y = y - 1; break;
            case 1: y = y + 1; break;
            case 2: x = x - 1; break;
            case 3: x = x + 1; break;
        }
        if (y < 0) {
            y = World.worldHeight;
        }
        if (y > World.worldHeight) {
            y = -size;
        }
        if (x < 0) {
            x = World.worldWidh;
        }
        if (x > World.worldWidh) {
            x = -size;
        }
       currentDnaPosition++;

    }
    //отрисовка бота
    public void paint(Graphics graphics) {
        graphics.setColor(botColor);
        graphics.fillRect(x,y,size,size);

    }


}
