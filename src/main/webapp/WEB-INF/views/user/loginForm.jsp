<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="container">
<h2>User Join</h2>
  <form>

        <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
    
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    

  </form>
     <button id="btn-login" class="btn btn-primary">로그인</button>
	</div>
	 

<script src="/js/user.js">
</script>
<%@ include file="../layout/footer.jsp" %>