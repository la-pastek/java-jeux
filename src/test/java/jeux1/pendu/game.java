package jeux1.pendu;

import javax.swing.*;

public class game {


    /**
     * @param reponse est un boolean, true s'il a trouvé la bonne lettre
     * @param chanceRestante est un tableau boolean qui indique son nombre de vies
     * @param indiceTab indique l'indice du tableau du nombre de vies qu'il reste au joueur
     * @return retourne un tableau qui indique son nombre de chances restant
     */
    public static boolean[] vieRestant(boolean reponse,boolean []chanceRestante, int indiceTab){
        chanceRestante[indiceTab]= reponse;
        return chanceRestante;
    }

    public static int indiceTab(boolean [] chanceRestante,int indice){
        for (int i = 0; i < chanceRestante.length-1; i++) {
            if (chanceRestante[i]){
                indice++;
            }
        }
        return indice;
    }

    /**
     * @param lettreDuJoueur lettre demander au joueur
     * @param motRechercher le mot que l'on devra trouver qui sera dans un tab char
     * @return si la lettre corrspond ou pas
     */
    public static boolean verificationBonneLettre(char lettreDuJoueur, char []motRechercher){
        boolean bonneLettre=false;
        for (int i = 0; i < motRechercher.length; i++) {
            if (motRechercher[i]==lettreDuJoueur)bonneLettre=true;
        }
        return bonneLettre;
    }
    public static boolean fin(boolean[] chanceRestant){
        int fin =chanceRestant.length;
        return fin == 10;
    }
}
