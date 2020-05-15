import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Model {
    private String newFilePath = "raiting.csv";
    public ArrayList<String> readFile(String path) {
        ArrayList<String> inf = new ArrayList<String>();
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                inf.add(data);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("there is some kind of error " + e);
        }
        return inf;
    }

    public void createFile(ArrayList<String> data) {
        try {
            String minMark = data.get(data.size()-1).split(",")[1];
            new File(newFilePath).createNewFile();
            FileWriter writer = new FileWriter(newFilePath);
            for (String str : data) {
                writer.write(str + "\n");
            }
            writer.write("Minimal average mark for grant is " + minMark);
            writer.close();
        }
        catch (IOException e) {
            System.out.println("there is some kind of error: " + e);
        }

    }
}
