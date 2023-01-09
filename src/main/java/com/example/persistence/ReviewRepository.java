package com.example.persistence;


import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.ReviewVO;



public interface ReviewRepository extends JpaRepository<ReviewVO, Integer> {

	//리뷰가져오기용 + 리뷰페이징
	@Query(value = "SELECT *"
			+ " FROM review WHERE ed_id=?1",
			 countQuery = "SELECT count(*) FROM review  WHERE ed_id=?1",
			 nativeQuery=true)
	Page<ReviewVO> getReviewAndPaging(Pageable paging, String re);
   
	
	
	
	//별점평균용
    @Query(value="SELECT ed_id, (ROUND(AVG(star))) AS avg "
    		+ "FROM review "
    		+ "GROUP BY ed_id "
    		+ "ORDER by avg DESC",  nativeQuery=true)
    List<Object[]>avgStar();
    
    
    
   
    //별점높은순 정렬용
    @Query(value=" SELECT e.ed_id AS ed_id, e.ed_title AS ed_title  "
    		+ "  ,e.ed_name AS ed_name,ed_keyword AS ed_keyword,ed_price AS ed_price, r.avg  avg  "
    		+ "  FROM education e JOIN (SELECT ed_id, ROUND(AVG(star)) AS avg FROM review GROUP BY ed_id) r "
    		+ "  ON e.ed_id = r.ed_id "
    		+ "  ORDER BY avg DESC ",
    		countQuery=" SELECT e.ed_id AS ed_id, e.ed_title AS ed_title  "
    	    		+ "  ,e.ed_name AS ed_name,ed_keyword AS ed_keyword,ed_price AS ed_price, r.avg  avg  "
    	    		+ "  FROM education e JOIN (SELECT ed_id, ROUND(AVG(star)) AS avg FROM review GROUP BY ed_id) r   "
    	    		+ "  ON e.ed_id = r.ed_id "
    	    		+ "  ORDER BY avg DESC ",
    		nativeQuery=true)
    Page<Object[]>avgStarDESC(Pageable paging, String orders);
    
    
   
      
}