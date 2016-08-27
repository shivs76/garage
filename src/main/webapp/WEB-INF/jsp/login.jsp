<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
  <link rel="stylesheet" href="css1/bootstrap.min.css">
  <link rel="stylesheet" href="css1/bootstrap-theme.min.css">
  <link rel="stylesheet" href="css1/main.css"></link>
  <link rel="stylesheet" href="css1/jquery_popup3.css"></link>
  
  <script src="js1/jquery.min.js"></script>
  <script src="js1/bootstrap.min.js"></script>
</head>
<body onload='document.loginForm.username.focus();'>
   <div id="header-wrapper">
   </div>
 <div class="container">
    <div style = "min-height:80%;">
        <div id="logindiv">
				    <form name='loginForm' class='loginform'
				      action="<c:url value='/j_spring_security_check' />" method='POST' id="login" >
				      <h3 style="color:#000000;font-weight:bold !important;">Login Form</h3>
				       <c:if test="${not empty error}">
                  <div class="error">${error}</div>
                </c:if>
              <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
              </c:if>
				      <label style="color:#000000; font-weight:bold !important;">User Name : </label>
              <br/>
              <input type="text" id="username" name="username" placeholder="User Name"/><br/>
              <br/>
              <label style="color:#000000; font-weight:bold !important;">Password : </label>
              <br/>
              <input type="password" id="password" name="password" placeholder="********"/><br/>
              <br/>
              <input type="submit" id="loginbtn" value="Login" class="btn btn-primary"/>
              <br/>
				    </form>
      </div>
    </div>   
 </div>
<div id="footer-wrapper" class="bottom_margin"></div>
  <div id="company-logos">
    <!-- <div class="container clearfix"> -->
          <a href="http://www.centurylink.com/" title="CenturyLink" target="_blank">
         <img class="century-logo right" src="images/centurylink-logo-footer.png" height="24" alt="CenturyLink">
      </a>
    <!-- </div> -->
  </div>
</body>
</html>