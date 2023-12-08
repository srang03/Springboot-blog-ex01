<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="container">
<h2>User Join</h2>
  <form action="#" method="post"> 

        <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
    
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" name="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    
    <div class="form-group form-check">
      <label class="form-check-label">
           <input type="checkbox" name="remember" class="form-check-input"> <span>Remember me</span>
      </label>
 
    </div>
    
       
    
     <button id="btn-login" class="btn btn-primary">로그인</button>
  </form>

	</div>
	 

<script src="/js/user.js">
</script>
<%@ include file="../layout/footer.jsp" %>