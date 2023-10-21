package Chapter5Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise3 {
    public static void main(String[] args) {
        ArrayList<Poem> poems = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("poem2.txt"))) {
            String line;
            String name = null;
            String poet = null;

            while ((line = reader.readLine()) != null) {
                if (name == null) {
                    name = line;
                } else {
                    poet = line;
                    Poem poem = new Poem();
                    poem.setName(name);
                    poem.setPoet(poet);
                    poems.add(poem);
                    name = null;
                    poet = null;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }

        for (Poem poem : poems) {
            System.out.println("Poem Name: " + poem.getName());
            System.out.println("Poet: " + poem.getPoet());
            System.out.println();
        }
    }
}

