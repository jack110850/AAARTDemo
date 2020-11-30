//package tw.group4._18_.buyer.DAO;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tw.group4._18_.buyer.model.CourseOrders;
//import tw.group4._18_.seller.model.Course;
//
//@Service("CourseOrderService")
//public class CourseOrderService {
//	
//	private CourseOrderDAO coDAO;
//	
//	public CourseOrderService() {
//		
//	}
//
//	@Autowired
//	public CourseOrderService(CourseOrderDAO coDAO) {
//		this.coDAO = coDAO;
//	}
//	
//	
//	public CourseOrders insertOrder(CourseOrders co) {
//		return coDAO.insertOrder(co);
//
//	}
//	
//	public CourseOrders selectOrder(int coOrderNo) {
//		return coDAO.selectcoOrder(coOrderNo);
//	}
//	
//	public List<Course> customerSelectAll() {
//		return coDAO.customerSelectAll();
//	}
//	
//	public List<CourseOrders> coOrder(String userId){
//		return coDAO.getcoOrderById(userId);
//	}
//	
//	public CourseOrders deleteOrder(CourseOrders co) {
//		return coDAO.deleteOrder(co);
//
//	}
//	
//}
