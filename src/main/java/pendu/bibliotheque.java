package pendu;

import java.util.ArrayList;
import java.util.List;

public class bibliotheque {


    public static List<char[]> bibli(){
        List<char[]>data=new ArrayList<>();
        String mot="canard";
        char [] canard = mot.toCharArray();

        data.add(canard);
        return data;
    }
}
