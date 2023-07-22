package pendu;

import java.util.Arrays;

public class view {

    public static void vieView(int indice){
        int affiche=10;
        System.out.println();
        for (int i = 0; i < 10-indice; i++) {
            System.out.print("<3 ");
            affiche=i;
        }
        System.out.print(": "+(affiche+1));
    }

    public static void motView(char [] motCacher,boolean verificationLettre,int indiceDuchar,char lettre){
    if(verificationLettre){
        motCacher[indiceDuchar]=lettre;
    }
        System.out.println();
        for (int i = 0; i <motCacher.length ; i++) {
            System.out.print(" "+motCacher[i]);
        }
    }
}
