package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    // couplage faible
   //@Autowired // demander a spring au moment ou tu vas instancier la classe metierIml cherche moi
    // parmi les objets que tu a deja creer si tu trouve un   objet de type IDao tu va l'injecter dand cette variavle
  private IDao dao ;
    // injection en utilisant un constructeur avec parametres

// spring va faire l'injection via le constructeur
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double temp=dao.getData();
        double res = temp*2;
        return res;
    }
// injecter dans la variable dao un objet d'une classe qui impelemente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
