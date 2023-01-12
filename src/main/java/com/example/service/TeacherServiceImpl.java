package com.example.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.MemberVO;
import com.example.domain.TeacherVO;
import com.example.persistence.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	
	 @Autowired
	 private TeacherRepository teacherRepository;
	 

	 
	 //전체정보 얻기용
	 public TeacherVO findAll(TeacherVO tvo) {
	      return  teacherRepository.findById(tvo.getTeacherId()).get();
	   }
	 
	 
	 
	 
	 //선생님 등록
	// 회원가입
		@Override
		public void insertTutor(TeacherVO tvo) {
			teacherRepository.save(tvo);
		}

	 
	
	 
}
