package lol;

import lol.crud.EntityManagerStudentDao;
import lol.crud.GroupDao;
import lol.crud.StudentDao;
import lol.entities.Group;
import lol.entities.Student;
import org.hibernate.SessionFactory;

import java.util.List;

public class HibernateSessionService {
    private final GroupDao groupDao;
    private final StudentDao studentDao;

    public HibernateSessionService() {
        SessionFactory sessionFactory = HibernateConfiguration.getFactory();
        studentDao = new EntityManagerStudentDao(sessionFactory);
        groupDao = new GroupDao(sessionFactory);
    }

    public void exec() {
        Student student = studentDao.findById(1L);
        List<Student> students = studentDao.findAll();

        Group group = groupDao.findById(1L);

        Student newStudent = new Student();
        newStudent.setName("Захар");
        newStudent.setSurname("Литвинчук");
        newStudent.setGroup(group);
        studentDao.save(newStudent);
    }
}
