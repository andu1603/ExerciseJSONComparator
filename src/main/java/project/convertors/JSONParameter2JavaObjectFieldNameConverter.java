package project.convertors;

public class JSONParameter2JavaObjectFieldNameConverter {

    public static String convert(String name) {
        StringBuilder translation = new StringBuilder();
        if(name.startsWith("_")){
            name=name.substring(1);
        }
        if(!name.contains("_"))
            return name;
        String[] words = name.split("_");
        translation.append(words[0]);
        for (int i=1;i<words.length;i++){
            translation.append(words[i].substring(0,1).toUpperCase())
                    .append(words[i].substring(1));
        }
        return translation.toString();
    }
}
