package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentatioonSpringAnnotation {
    public static void main(String[] args) {
        // donnaer les package qui va scanner
        ApplicationContext context = new AnnotationConfigApplicationContext("dao" ,"metier");
        // donne moi un bean qui implemente l'interface IMetier
        IMetier metier =context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
