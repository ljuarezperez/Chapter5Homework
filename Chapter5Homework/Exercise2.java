package Chapter5Homework;

import java.io.FileWriter;
import java.io.IOException;

public class Exercise2 {
    public static void main(String[] args) {
        Poem poem1 = new Poem();
        poem1.setName("Doing Homework");
        poem1.setPoet("Larry Juarez");

        Poem poem2 = new Poem();
        poem2.setName("I suck at homework");
        poem2.setPoet("Larry Juarez");

        Poem poem3 = new Poem();
        poem3.setName("Have a good day");
        poem3.setPoet("Larry Juarez");

        Poem[] poems = { poem1, poem2, poem3 };

        try (FileWriter writer = new FileWriter("poems.txt")) {
            for (Poem poem : poems) {
                writer.write(poem.getName() + "\n");
                writer.write(poem.getPoet() + "\n");
                writer.write("\n");
            }
            System.out.println("Poem information has been written to 'poems.txt'.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

