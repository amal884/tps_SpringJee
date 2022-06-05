package extention;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2") // avec l'injection autowired on va avoir an exception
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version capteur");
        double temp = 80;
        return temp;
    }
}
