package service;

import domain.Parrot;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ParrotManagerImpl implements ParrotManager{
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Parrot> getAllParrots() {
        return sessionFactory.getCurrentSession().getNamedQuery("Parrot.all").list();
    }

    @Override
    public void addParrot(Parrot parrot) {
        sessionFactory.getCurrentSession().persist(parrot);
    }

    @Override
    public Parrot getParrot(int id) {
        return (Parrot) sessionFactory.getCurrentSession().get(Parrot.class,id);
    }

    @Override
    public void removeParrot(int id) {
        Parrot parrot =  getParrot(id);
        sessionFactory.getCurrentSession().delete(parrot);
    }

    @Override
    public Parrot getParrotByName(String parrotName) {
        return (Parrot) sessionFactory.getCurrentSession().getNamedQuery("Parrot.byName").setString("name", parrotName).uniqueResult();
    }

    @Override
    public void removeParrotByName(String parrotName) {
        Parrot parrot = (Parrot) sessionFactory.getCurrentSession().getNamedQuery("Parrot.byName").setString("name", parrotName).uniqueResult();
        sessionFactory.getCurrentSession().delete(parrot);
    }

    @Override
    public List<Parrot> getAllExoticParrots() {
        return sessionFactory.getCurrentSession().getNamedQuery("Parrot.exotic").list();
    }
}
