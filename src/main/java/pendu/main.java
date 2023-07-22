package pendu;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        boolean[] vie =new boolean[10];
        Arrays.fill(vie, true);
        char[] motCacher =new char[bibliotheque.bibli().get(0).length];
        Arrays.fill(motCacher,'_');
        int indiceError=0; // indique l'indice du tableau qui est basé sur le tab vie

        Scanner cla = new Scanner(System.in);

        while (game.fin(indiceError)){
            view.vieView(indiceError);
            System.out.println();
            System.out.println("entre une lettre");
            char lettre= cla.next().charAt(0);
            boolean reponse= game.verificationBonneLettre(lettre,bibliotheque.bibli().get(0));
            if (game.indiceError(reponse)==1){indiceError++;}
            int indiceLettre = game.indiceDeLettre(bibliotheque.bibli().get(0),lettre);// permet d'afficher la bonne lettre qui a ete trouver
            view.motView(motCacher,reponse,indiceLettre,lettre);
            }
        }
}
