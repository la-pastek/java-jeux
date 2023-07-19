package jeux1.pendu;

import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        boolean[] vie =new boolean[10];
        Arrays.fill(vie, true);
        int indice;
        Scanner cla = new Scanner(System.in);

        while (game.fin(vie)){
            indice= game.indiceTab(vie,0);
            System.out.println();
            System.out.println("entre une lettre");
            char lettre = cla.next().charAt(0);
            boolean reponse =game.verificationBonneLettre(lettre,bibliotheque.bibli().get(0));
            view.vieView(game.vieRestant(reponse, vie, indice),indice);
            }

        }
}
