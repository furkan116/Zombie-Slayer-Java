public class ZombieCounter {

    private int killedZombies = 0;
    private int inRoomZombies = 0;

    public synchronized void zombieEntered() {

        inRoomZombies += 1;
    }

    public synchronized void zombieKilled() {

        killedZombies += 1;
        inRoomZombies -= 1;
    }

    public synchronized boolean tooManyZombiesInTheRoom() {

        if (getInTheRoomCount() >= 100) {
            return true;
        }

        return false;
     }

    public synchronized boolean killed100Zombies() {

        if (getKilledCount() > 100) {
            return true;
        }

        return false;
     }

    public synchronized boolean zombiesExist() {

        if (inRoomZombies > 0) {
            return true;
        }

        return false;
    }

    public synchronized int getKilledCount() {
        return killedZombies;
     }

    public synchronized int getInTheRoomCount() {
        return inRoomZombies;
     }
}
