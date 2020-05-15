import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String path = "students.csv";
    public static void main(String[] str) {
        Model model = new Model();
        Presenter presenter = new Presenter();
        ArrayList<String> data = model.readFile(path);

        ArrayList<String> result = new ArrayList<String> (presenter.count(data));
        model.createFile(result);

    }
}
