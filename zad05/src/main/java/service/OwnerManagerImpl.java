package service;

import domain.Owner;
import domain.Parrot;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OwnerManagerImpl implements OwnerManager {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOwner(Owner owner) {
        sessionFactory.getCurrentSession().persist(owner);
    }

    @Override
    public List<Parrot> getOwnersParrots(String firstName, String lastName) {
        Owner o = (Owner) sessionFactory.getCurrentSession().getNamedQuery("Parrot.getOwners").setString("firstName", firstName).setString("lastName",lastName).uniqueResult();
        return o.getParrots();
    }
}
