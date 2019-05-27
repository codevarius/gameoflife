package core.main;

public class Main {

    /*
 ______     ______     __    __     ______        ______     ______      __         __     ______   ______
/\  ___\   /\  __ \   /\ "-./  \   /\  ___\      /\  __ \   /\  ___\    /\ \       /\ \   /\  ___\ /\  ___\
\ \ \__ \  \ \  __ \  \ \ \-./\ \  \ \  __\      \ \ \/\ \  \ \  __\    \ \ \____  \ \ \  \ \  __\ \ \  __\
 \ \_____\  \ \_\ \_\  \ \_\ \ \_\  \ \_____\     \ \_____\  \ \_\       \ \_____\  \ \_\  \ \_\    \ \_____\
  \/_____/   \/_/\/_/   \/_/  \/_/   \/_____/      \/_____/   \/_/        \/_____/   \/_/   \/_/     \/_____/

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
                    Thread.sleep(70);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        thread.start(); //launch sub thread

    }
}
