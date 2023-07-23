import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

class Toy {
    private int id;
    private String name;
    private int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputStrings = { "1,Toy1,3", "2,Toy2,5", "3,Toy3,2" }; // Пример входных строк

        PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        for (String input : inputStrings) {
            String[] parts = input.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int frequency = Integer.parseInt(parts[2]);

            Toy toy = new Toy(id, name, frequency);
            toysQueue.add(toy);
        }

        try {
            FileWriter fileWriter = new FileWriter("output.txt");

            for (int i = 0; i < 10; i++) {
                Toy toy = toysQueue.poll();
                if (toy != null) {
                    String result = "ID: " + toy.getId() + ", Name: " + toy.getName() + ", Frequency: " + toy.getFrequency();
                    System.out.println(result);
                    fileWriter.write(result + "\n");
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
