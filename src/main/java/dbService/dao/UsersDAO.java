package dbService.dao;

import dbService.datasets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet getUser(String username) throws HibernateException {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UsersDataSet> query = builder.createQuery(UsersDataSet.class);
        Root<UsersDataSet> userRoot = query.from(UsersDataSet.class);

        query.select(userRoot)
                .where(builder.equal(userRoot.get("username"), username));

        List<UsersDataSet> usersList = session.createQuery(query).getResultList();

        if (usersList.isEmpty()) {
            return null;
        } else {
            return usersList.get(0);
        }
    }

    public boolean checkEmail(String email) throws HibernateException {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UsersDataSet> query = builder.createQuery(UsersDataSet.class);
        Root<UsersDataSet> userRoot = query.from(UsersDataSet.class);

        query = query.select(userRoot)
                .where(builder.equal(userRoot.get("email"), email));

        List<UsersDataSet> usersList = session.createQuery(query).getResultList();

        if (usersList.isEmpty()) {
            return false;
        } else {
            return true;
        }


    }

    /*
    public String getPassword(String username) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("username", username)).uniqueResult()).getPassword();
    }
    */

    public long insertUser(String username, String password, String email) throws HibernateException {
        return (Long) session.save(new UsersDataSet(username,password,email));
    }
}