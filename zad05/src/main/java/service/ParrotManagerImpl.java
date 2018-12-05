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
        return sessionFactory.getCurrentSession().getNamedQuery("Parrot.all")
                .list();
    }

    @Override
    public void addParrot(Parrot parrot) {
        sessionFactory.getCurrentSession().persist(parrot);
    }

    @Override
    public void getParrot(int id) {

    }
}
