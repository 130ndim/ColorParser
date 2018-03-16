import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> dictionary = new HashMap<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/k-kawakami/colorfulnet/master/example_data/wikipedia-list-of-colors.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while((str = reader.readLine()) != null) {
                dictionary.put(str.toLowerCase(), 0);
            }
            url = new URL("https://raw.githubusercontent.com/fluentpython/example-code/master/attic/sequences/war-and-peace.txt");
            Scanner scanner = new Scanner(url.openStream());
            scanner.useDelimiter("\\Z");
            String[] text = scanner.next().replaceAll("[^a-zA-Z]", " ").toLowerCase().replaceAll("\\s+", " ").split(" ");
            for(String s : text) {
                if(dictionary.containsKey(s)) {
                    int c = dictionary.get(s);
                    dictionary.put(s, c+1);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(String key: dictionary.keySet()) {
            if(dictionary.get(key) != 0) {
                String s = key.substring(0, 1).toUpperCase() + key.substring(1);
                System.out.println(s + ": " + dictionary.get(key));
            }
        }
    }
}
