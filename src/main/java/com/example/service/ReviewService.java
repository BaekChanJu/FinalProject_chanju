package com.example.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.domain.ReviewVO;

public interface ReviewService {
   
   
    public void saveRV (ReviewVO vo);
    

    public  List<Object[]> avgStar();
    

    //Page<ReviewVO> a(Pageable paging, String temp_ed_id);

    
    public  List<Object[]> avgStarvc();
}