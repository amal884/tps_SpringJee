package presentation;

import extention.DaoImpl2;
import metier.MetierImpl;

public class presentation {
    public static void main(String[] args) {
        /* injection des dependances par instanciation statique  c,a,d l'utilisation du new */
        DaoImpl2 dao  = new DaoImpl2();
        MetierImpl metier = new MetierImpl(dao);
        //metier.setDao(dao);
        System.out.println("Resultat"+metier.calcul());
    }
}
