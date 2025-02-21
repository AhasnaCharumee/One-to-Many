package config;

import entity.Customer;
import entity.IDCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;// session create krl dena factory object eka

    public FactoryConfiguration(){ //hibernate boostrap krnne meken
        Configuration configuration =new Configuration().configure().configure();

        configuration.addAnnotatedClass(Customer.class);//Map wenn one class tika add kranne mehema
        configuration.addAnnotatedClass(IDCard.class);

        sessionFactory= configuration.buildSessionFactory(); //methnin thama session object eka return kranne
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null)?(factoryConfiguration=new FactoryConfiguration()):factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
