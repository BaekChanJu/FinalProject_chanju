package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.EducationVO;
import com.example.service.SearchService;

@Controller
@RequestMapping("/academy")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	
    @GetMapping("/temp")
    public String search(String keyword, Model model) {
    
    	System.out.println("[SearchController] : /academy/temp 요청 :" + keyword );
        List<EducationVO> list = searchService.search(keyword);
        model.addAttribute("academyList", list);
 
        return "/academy/course-sidebar";
    }


	
	

}
