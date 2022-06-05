package dao;

import org.springframework.stereotype.Component;

@Component("dao") // au demmarage a chaque fois qu'il trouve une classe qui commance par l'annotaion component
//il va l'instancier et lui donner comme nom dao
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        /*
        se connetcter a BDD pour recuperer la temperature
        */
        System.out.println("versionn de base de donnes ");
        double temp=Math.random()*40;
        return temp;
    }
}
