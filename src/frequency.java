import java.io.*;
import java.util.HashMap;
import java.util.Map;


class Frequency {

    static void CountFreq(String filename) throws FileNotFoundException{
        Map<String, Integer> map = new HashMap<>();
        BufferedReader consoleReader = new BufferedReader(new FileReader(filename));
        try {
            String line;
            while ((line = consoleReader.readLine()) != null) {
                line = line.replaceAll("[.:,/‘’;']", "");
                line = line.trim();
                String[] result = line.split(" ");
                for (String word : result) {
                    if (!word.equals("")) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
            consoleReader.close();
        } catch(IOException error) {
            error.printStackTrace();
        }
        try (FileWriter result = new FileWriter("output.txt", false)) {
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                String s = Integer.toString(pair.getValue());
                result.write(pair.getKey());
                result.write(":");
                result.write(s);
                result.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
