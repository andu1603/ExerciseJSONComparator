package project.printers;

import java.util.List;
import java.util.Map;

public class MapListConsolePrinter {

    public static void print(Map<String, List<String>> output) {
        output.forEach((key, valueList) -> {
            System.out.println(key);
            for (String value : valueList)
                System.out.println('\t' + value);
        });
    }
}
