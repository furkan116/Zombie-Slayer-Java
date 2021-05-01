import java.util.Random;

public class DoorMan extends Thread{

    Random r = new Random();
    ZombieCounter zombieCounter;

    @Override
    public void run() {

        while (!zombieCounter.killed100Zombies() && !zombieCounter.tooManyZombiesInTheRoom()) {
            try {
                if (r.nextInt(2) == 1) {
                    zombieCounter.zombieEntered();
                }
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public DoorMan(ZombieCounter zombieCounter) {
        this.zombieCounter = zombieCounter;
    }

}
