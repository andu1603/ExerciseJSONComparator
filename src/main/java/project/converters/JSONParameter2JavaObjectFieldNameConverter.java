package project.converters;

public class JSONParameter2JavaObjectFieldNameConverter {

    public static String convert(String name) {
        StringBuilder translation = new StringBuilder();
        while (name.startsWith("_")) {
            name = name.substring(1);
        }
        if (!name.contains("_"))
            return name;
        String[] words = name.split("_");
        translation.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;
            translation.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1));
        }
        return translation.toString();
    }
}
