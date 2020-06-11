package you;

import com.opencsv.CSVReader;
import java.util.*;
import java.io.Reader;
import java.nio.file.*;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        try {
            List<String[]> thing = oneByOneExample();
            System.out.println(thing.get(0)[1] + " <-- Header"); // header at index 0
            System.out.println(thing.get(1)[1]);
            System.out.println(thing.get(2)[1]);
            System.out.println(thing.get(3)[1]);

            for (int i = 0; i < thing.get(0).length; i++) {
                System.out.println(thing.get(0)[i]);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static List<String[]> oneByOne(Reader reader) throws Exception {
        List<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        reader.close();
        csvReader.close();
        return list;
    }

    public static List<String[]> oneByOneExample() throws Exception {

        Reader reader = Files.newBufferedReader(Paths.get("/Users/johnkelly/projects/lol/data/test_data.csv"));
        // Reader reader =
        // Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("csv/test_data.csv").toURI()));

        return oneByOne(reader);
    }
}
