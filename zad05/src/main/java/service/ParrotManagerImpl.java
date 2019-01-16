package service;

import domain.HygieneProduct;
import domain.Owner;
import domain.Parrot;
import domain.ParrotStats;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public ParrotStats getParrotStats(String parrotName) {
        return (ParrotStats) sessionFactory.getCurrentSession().getNamedQuery("Parrot.stats").setString("name", parrotName).uniqueResult();
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

    @Override
    public Set<HygieneProduct> getAllParrotHygieneProducts(String parrotName) {
        Parrot p = (Parrot) sessionFactory.getCurrentSession().getNamedQuery("Parrot.byName").setString("name", parrotName).uniqueResult();
        return p.products;
    }
}
