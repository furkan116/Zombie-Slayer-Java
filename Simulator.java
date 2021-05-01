import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ZombieCounter zombieCounter = new ZombieCounter();

        int doorNumber;

        System.out.print("Please enter Doorman Number: ");
        doorNumber = scanner.nextInt();
        Slayer slay = new Slayer(zombieCounter);

        slay.start();

        for (int i = 0; i < doorNumber; i++) {

            DoorMan door = new DoorMan(zombieCounter);

            try {
                door.start();
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            slay.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (zombieCounter.killed100Zombies()) {
            System.out.println("Win");
        }

        if (zombieCounter.tooManyZombiesInTheRoom()) {
            System.out.println("Lose");
        }
    }
}
