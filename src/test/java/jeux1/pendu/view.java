package jeux1.pendu;

public class view {

    public static void vieView(boolean[] vieRestant, int indice){
        for (int i = 0; i < vieRestant.length; i++) {
            if (vieRestant[i]){
                System.out.print("<3 ");
            }
        }
        System.out.print(": "+indice);
    }
}
