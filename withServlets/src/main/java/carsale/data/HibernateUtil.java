package carsale.data;

import carsale.models.Ads;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory factory;

    //реализация потокобезопасного синглтона.
    private static final HibernateUtil INSTANCE = new HibernateUtil();

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public static SessionFactory getSessionXml() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Ads.class);
        Metadata metadata = sources.getMetadataBuilder().build();
        factory = metadata.getSessionFactoryBuilder().build();

        return factory;
    }


    public static SessionFactory getSessionConf() {
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return factory;
    }


    public static void close() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}

/* неэффективная реализация, производительность теряется при явной синхронизации
   public static SessionFactory getSessionConf() {
        if (factory == null) {
            synchronized (SessionFactory.class) {
                if (factory == null) {
                    try {
                        factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .buildSessionFactory();
                    } catch (HibernateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return factory;
    }
 */
