public class Slayer extends Thread{

    ZombieCounter zombieCounter;

    @Override
    public void run() {

        while (!zombieCounter.killed100Zombies() && !zombieCounter.tooManyZombiesInTheRoom()) {
            try {
                if (zombieCounter.zombiesExist()) {
                    zombieCounter.zombieKilled();
                }
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Slayer(ZombieCounter zombieCounter) {
        this.zombieCounter = zombieCounter;
    }

}
