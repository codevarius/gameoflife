package core.main;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                World world = new World();
                while (world.getAlive()) {
                    world.update();
                    world.render();
                    try {
                        Thread.sleep(50);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        });

        thread.start();

    }
}
