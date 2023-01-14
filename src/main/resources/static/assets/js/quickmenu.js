
//퀵메뉴용
$(document).ready(function(){
   //스크롤이벤트
  var currentPosition = parseInt($(".quickmenu").css("top"));
    $(window).scroll(function() {
   //속도애니메이트 
   var position = $(window).scrollTop(); 
      $(".quickmenu").stop().animate({"top":position+currentPosition+"px"},500);
      
      
         
      //퀵메뉴 클릭시 채팅방 오픈
      
   $(function(){
      
   
      // 버튼이 눌렸을 때
      $('.quickmenu').on('click',function(){
         //alert('0');
         alert($('#memberId').text());
      
      
      
       
         var url = 'http://127.0.0.48:5000/?id=' + $('#memberId').text();
         window.open(url,'width=20','height=60');
         
      
      
      
	//<!-- 세션에서 찾는방법 -->
	//<div><span id='memberId' th:text='${session["member"]}'>}</span>님로그인성공</div>
      });
      
      
   });

   
      
  });
});
