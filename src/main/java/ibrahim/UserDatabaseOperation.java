package ibrahim;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Customer;

public class UserDatabaseOperation {
  private Session session;

  public UserDatabaseOperation(Session session) {
    this.session = session;
  }

  public <T> void createEntity(T entity) {
    Transaction transaction = session.beginTransaction();
    session.save(entity);
    transaction.commit();
  }

  public <T> T getEntity(Class<T> clazz, Long id) {
    return session.get(clazz, id);
  }

  public <T> void updateEntity(T entity) {
    Transaction transaction = session.beginTransaction();
    session.update(entity);
    transaction.commit();
  }

  public <T> void deleteEntity(T entity) {
    Transaction transaction = session.beginTransaction();
    session.delete(entity);
    transaction.commit();
  }

  public <T> List<T> getAllEntities(Class<T> clazz) {
    return session.createQuery("from " + clazz.getName(), clazz).list();
  }

public Customer read(Long id) {
	// TODO 
	return null;
}
}