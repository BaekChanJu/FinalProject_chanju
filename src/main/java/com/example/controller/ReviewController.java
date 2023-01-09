package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.ReviewVO;
import com.example.service.ReviewService;

@Controller
@RequestMapping("/academy")
public class ReviewController {


   
     @Autowired
     private ReviewService reviewService;

     //리뷰 등록부분 (안되면리퀘스트 매핑으로)
     @GetMapping("/insertRV")
     public String insertRV(ReviewVO vo, @RequestParam String edId) {
        System.out.println("리뷰뷰뷴 : " +   vo);
        
        vo.setReDate(LocalDateTime.now());
        
        reviewService.saveRV(vo);
         return "redirect:/academy/course-details?edId=" + edId;
     }//end of insertRV
     
   
     

     
}
     
     
     