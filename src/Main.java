import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static List<Integer> repeatedNumbers = new ArrayList<>();

    public static void main(String[] args) {
        int i = 0;
        while(i++ < 1000)
            System.out.println(randomWithoutRepeatTheSameNumber());
        
    }

    public static int randomWithoutRepeatTheSameNumber() {
        Random rng = new Random();
        AtomicBoolean isRepeated = new AtomicBoolean(false);
        int temp = rng.nextInt(1000);

        repeatedNumbers.forEach(e -> {
            if (e == temp) {
                isRepeated.set(true);
                System.out.println("Found a repeated number: " + e);
            }
        });

        if (isRepeated.get())
            return randomWithoutRepeatTheSameNumber();

        repeatedNumbers.add(temp);
        return temp;
    }
}
