package gb.exceptions.viewer;
import java.util.Scanner;
public class ViewerContact implements Viewer{

    public String inputString(String prompt){
        try (Scanner scanner = new Scanner(System.in) ){
            System.out.printf(prompt);
            return scanner.next();
        }
    }
}
