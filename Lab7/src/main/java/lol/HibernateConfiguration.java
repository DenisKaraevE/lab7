package lol;

import lol.entities.Group;
import lol.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Objects;
import java.util.Properties;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    private HibernateConfiguration() {}

    public static SessionFactory getFactory() {
        if (Objects.nonNull(sessionFactory)) {
            return sessionFactory;
        }

        Properties properties = ApplicationProperties.getInstance().getProperties();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();

        try {
            MetadataSources metadataSources = new MetadataSources(registry);

            metadataSources.addAnnotatedClass(Student.class);
            metadataSources.addAnnotatedClass(Group.class);

            SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
            HibernateConfiguration.sessionFactory = sessionFactory;

            return sessionFactory;
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
    }
}
