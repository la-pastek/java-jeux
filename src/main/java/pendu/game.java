package jeux1.pendu;

import javax.swing.*;
import java.io.*;

public class game {

    /**
     * @param reponse est un boolean, true s'il a trouvé la bonne lettre
     * @param vieRestante est un tableau boolean qui indique son nombre de vies
     * @param indiceTab indique l'indice du tableau du nombre de vies qu'il reste au joueur
     * @return retourne un tableau qui indique son nombre de chances restant
     */
    public static boolean[] vieRestant(boolean reponse,boolean []vieRestante, int indiceTab){
        vieRestante[indiceTab]= reponse;
        return vieRestante;
    }

    /**
     *
     * @param chanceRestante les vie qu'il reste a utilisateur
     * @param indice indique qu'il doit passer passer a la case suivante si le joeur a perdu une vie
     * ( a rentré une mauvaise lettre )
     * @return l'indice
     */
    public static int indiceError(boolean reponse){
        int indice =0;
            if (!reponse){ indice =1;}
        return indice;
    }

    public static int indiceDeLettre(char [] motRechercher, char lettre){
        int indice=11;
        for (int i = 0; i < motRechercher.length; i++) {
            if (motRechercher[i]==lettre){
                 return indice=i;
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
    public static boolean fin(int indiceError){
        return indiceError != 10;
    }
}
