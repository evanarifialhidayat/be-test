import java.util.Iterator;
import java.util.List;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.File;


public class Main{
    public static void main(final String[] array) {
        	
        if (array.length == 0) {
            System.out.println("ERROR: Missing program argument for input file path. Usage: java -cp . Main <file>");
            return;
        }
        if(!array[0].contains(".txt")) {
        	System.out.println("please check parameter 1 extention '.txt'");
        }
        
        final File file = new File(array[0]);
        if (!file.exists()) {
            System.out.println("ERROR: File [" + file.getAbsolutePath() + "] not found.");
            return;
        }
        try {
            final List sortedList = new SinarmasCafeB().getSortedList((List)Files.readAllLines(file.toPath(), StandardCharsets.UTF_8),array[1],array[2]);
            if (sortedList != null) {
                final Iterator<String> iterator = sortedList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}