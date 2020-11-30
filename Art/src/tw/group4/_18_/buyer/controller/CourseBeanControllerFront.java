package tw.group4._18_.buyer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._18_.buyer.DAO.CourseBeanServiceFront;
import tw.group4._18_.buyer.model.CourseFront;
import tw.group4.util.IdentityFilter;

@Controller
public class CourseBeanControllerFront {

	@Autowired
	private CourseBeanServiceFront cBeanServiceF;

	@RequestMapping(path = "/18/cSelectAllFront.ctrl", method = RequestMethod.GET)
	public String processActionSelectAllF(Model m) {
		List<CourseFront> selectAllF = cBeanServiceF.selectAllF();
		m.addAttribute("cListF", selectAllF);
//	    String str =   (String) m.getAttribute("Update");
//	    m.addAttribute("end1", str);
//	    System.out.println(str);
		return IdentityFilter.loginID + "18/18_CustomerSelectAll";
	}

	
	
	@RequestMapping(path = "/18/cCourseDetail.ctrl") //網址 
	public String productDetail(Model m, @RequestParam(name = "coId") String coId) {
		// name = "輸入值"
		System.out.println(coId);

		CourseFront cos = cBeanServiceF.selectF(coId);
		m.addAttribute("cfd", cos);
//		System.out.println(courseFront.getCoAct_ImageStr());

		return IdentityFilter.loginID+"18/18_CourseDetail"; // 欲跳之jsp頁面名字
	}

	
	


}
