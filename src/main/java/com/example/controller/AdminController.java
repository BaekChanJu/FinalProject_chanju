package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.AnnouncementVO;
import com.example.domain.EducationVO;
import com.example.domain.TeacherVO;
import com.example.persistence.TeacherRepository;
import com.example.service.AnnouncementService;
import com.example.service.EducationService;
import com.example.service.TeacherService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EducationService eduService;

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private  TeacherRepository teacherRepository;

	//경호
	//	//상품등록 페이지로 이동
	//	@RequestMapping("/academyRegister")
	//	public String itemRegister() {	
	//		return "admin/academyRegister";
	//	}
	//경호
	//상품목록 페이지로 이동
	@RequestMapping("/academyList")
	public String itemList(Model m) {	
		List<EducationVO> list = eduService.selectAllAcademy();
		m.addAttribute("result", list);
		return "admin/academyList";
	}

	//경주
	//관리자에 공지 목록띄움
	@RequestMapping("/announcement_m")
	public String annoList(Model m) {	
		List<AnnouncementVO> list = announcementService.selectAllAnnouncement();
		m.addAttribute("result", list);
		return "admin/announcement_m";
	}

	//경주
	//공지상세 페이지띄우기
	@RequestMapping("/announcementModify")
	public void getAnnouncement(AnnouncementVO vo, Model m) {
		m.addAttribute("anno", announcementService.getAnnouncement(vo));

	}

	//경주 
	//공지 등록하기
	@RequestMapping("/announcementInsertReal")
	public String announcementInsert(AnnouncementVO vo) {
		System.out.println("1");
		System.out.println("AD ID: " + vo.getAdId());
		announcementService.announcementInsert(vo);
		System.out.println("2");
		return "redirect:announcement_m";
	}	

	//경주
	//공지내용 삭제하기
	@RequestMapping("/announcementDelete")
	public String deleteAnnouncement(AnnouncementVO vo) {
		announcementService.announcementDelete(vo);
		return "redirect:announcement_m";
	}

	//경주
	//공지내용 수정하기
	@RequestMapping("announcementUpdate")
	public String updateAnnouncement(AnnouncementVO vo) {
		announcementService.announcementUpdate(vo);
		return "redirect:announcement_m";
	}




	//찬주 선생리스트 가져오기 
	@GetMapping("/teacherlist")
	public String getTeacher(Model m) {
		List<TeacherVO> result =  teacherService.AllTeacher();
		m.addAttribute("teacherlist", result);

		return "/admin/teacherlist";
	}//end of getTeacher




	//찬주 선생 승인여부 페이지 아이디값 가져와 나오게하기
	//선생님 상세페이지
	@GetMapping("/teacherRegister")
	public String getTeacherRegister(Model m, Integer teacherId) {

		//아이디 값 기준으로 등록한 선생님정보 가져오기 위함
		TeacherVO result = teacherRepository.findByTeacherId(teacherId);
		m.addAttribute("teacherRegister", result);

		return "/admin/teacherRegister";

	}// end of getTeacherRegister

	
	
	//선생 승인여부 수정
	@PostMapping("/teacherUpdate")
	public String teacherUpdate(TeacherVO tvo) {
		
		System.out.println("수정대상 : "+tvo);
		teacherService.updateTeacher(tvo);
		
		return "redirect:/admin/teacherlist";
	}
	

	


}
