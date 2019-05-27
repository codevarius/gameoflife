package core.main;

public class Main {

    /*
    * Recent changes on 27.05.2019:
    *   1. Added supporting comments
    *   2. Bot move distance was referenced to var 'step'
    */

    //top edge of app
    public static void main(String[] args) {

        //making sub thread to place and run world in it
        Thread thread = new Thread(() -> {
            World world = new World();

            //lifecycle
            while (world.getAlive()) {
                world.update();
                world.render();

                //pause thread
                try {
                    Thread.sleep(50);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        thread.start(); //launch sub thread

    }
}
