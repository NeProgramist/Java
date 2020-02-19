import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Presenter {
    public List<String> count(ArrayList<String> students) {
        students.remove(0);

        List<String> result = students.stream()
            .map(student -> student.split(","))
            .filter(s -> s[6].equals("FALSE"))
            .map(s -> new String[] {s[0], averageMark(new String[] {s[1], s[2], s[3], s[4], s[5]} )})
            .sorted(comparing(s -> (-1)*Double.parseDouble(s[1])))
            .map(s -> s[0]+","+s[1])
            .collect(Collectors.toList());
        return result.subList(0, (int) (result.size() * 0.4));
    }

    private String averageMark(String[] marks) {
        double result = 0;
        for (String mark: marks) result += Integer.parseInt(mark);
        return Double.toString(result / 5);
    }


}
