package model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.dao.PictureDAO;
import model.entity.Picture;

public class PictureDaoMySqlHibernateImpl implements PictureDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public void add(Picture picture) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(picture);
	}

	@Override
	public void update(Picture picture) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Picture> all() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(long pictureId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Picture getById(long pictureId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Picture getLastPictureByCameraId(long cameraId) {		
		Session session = this.sessionFactory.getCurrentSession();      		
		Criteria cr = session.createCriteria(Picture.class);	
		cr.add(Restrictions.eq("cameraId", cameraId));		
		cr.addOrder(Order.desc("id"));
		cr.setMaxResults(1);
		return (Picture) cr.uniqueResult();
	}

}
