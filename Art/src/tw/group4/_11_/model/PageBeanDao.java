package tw.group4._11_.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import oracle.net.aso.l;

@Repository
public class PageBeanDao {
	private SessionFactory sessionFactory;
	private int page = 0;
	private int pageSize = 10;
	private int totalPage = 1;
	
	@Autowired
	public PageBeanDao(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<UserSABean> selectPage(int page){
		Session session = sessionFactory.getCurrentSession();
		String count = "Select count (sa.id_SA) From UserSABean sa";
		Query countQuery = session.createQuery(count);
		Long countSaPage = (Long) countQuery.uniqueResult();
		
		Query<UserSABean> query = session.createQuery("From UserSABean sa Order by id_SA",UserSABean.class);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<UserSABean> list = query.list();
		
		return list;
	}
	
	public int selectCount() {
		Session session = sessionFactory.getCurrentSession();
		int count = 0;
		String sql = "select count(*) From UserSABean";
		Query<UserSABean> query = session.createQuery(sql);
		
		List<UserSABean> list = query.list();
		
		for (int i = 0; i < list.size(); i++) {
			count++;
		}
		
		return count;
	}
	
	public int getTotlePage(){
		
		Session session = sessionFactory.getCurrentSession();
		String count = "Select count (sa.id_SA) From UserSABean sa";
		Query countQuery = session.createQuery(count);
		Long countSaPage = (Long) countQuery.uniqueResult();
		
		if ((countSaPage % pageSize) != 0) {
			totalPage = (int) (Math.floor(countSaPage/pageSize));
		} else {
			totalPage = (int) (Math.ceil(countSaPage/pageSize));
		}
		
		return totalPage;
	}
	
	public int getPages(String query) {
		Session session = sessionFactory.getCurrentSession();
		String count = "Select count (sa.id_SA) From UserSABean sa FROM UserSABean WHERE theme_SA like %"+query+"% Or classification_SA like %"+query+"% Order by ID_SA";
		Query countQuery = session.createQuery(count);
		Long countSaPage = (Long) countQuery.uniqueResult();
		
		if ((countSaPage % pageSize) != 0) {
			totalPage = (int) (Math.floor(countSaPage/pageSize));
		} else {
			totalPage = (int) (Math.ceil(countSaPage/pageSize));
		}
		return totalPage;
	}
	
//	public List<UserSABean> selectPageItem(){
//		Session session = sessionFactory.getCurrentSession();
//		String count = "Select count (sa.id_SA) From UserSABean sa";
//		Query countQuery = session.createQuery(count);
//		Query<UserSABean> query = session.createQuery("From UserSABean sa Order By sa.id_SA",UserSABean.class);
//		
//		List<UserSABean> list = query.list();
//		return list;
//	}
//	
//	public List<UserSABean> selectUserSearch(){
//		Session session = sessionFactory.getCurrentSession();
//		String count = "Select count (sa.id_SA) From UserSABean sa";
//		Query countQuery = session.createQuery(count);
//		Query<UserSABean> query = session.createQuery("From UserSABean sa Order By sa.id_SA",UserSABean.class);
//		
//		List<UserSABean> list = query.list();
//		return list;
//	}
	
}
