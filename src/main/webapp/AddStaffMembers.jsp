
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>BC | Add Staff</title>
	<link rel="stylesheet" href="css/forms.css">

</head>
<body>
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<div class="container mt-3 rounded-3"  style="background-color: #ececec">
	<h3 class="form-titles text-center pt-4">Add Staff Members</h3>
	<form method="POST" action="AddStaffServlet">
		<div class="d-grid gap-3 card-body pt-2 p-5">
			<div>
				<label class="form-label" for="inputName">User Name</label>
				<input type="text" class="form-control" name="user_name" id="inputName" placeholder="User Name">
			</div>
			<div>
				<label  class="form-label">Email</label>
				<input type="email" class="form-control" name="user_email" id="inputEmail"
					   placeholder="example@gmail.com">
			</div>

			<div>
				<label  class="form-label">Password</label>
				<input type="password" class="form-control" name="pass" id="inputPass" >
			</div>

			<div>
					<label for="inputState" class="form-label">Position</label>
					<select name="staff_role" id="inputState" class="form-select">
						<option selected >Choose...</option>
						<option value="Accountant">Accountant</option>
						<option value="Manager">Manager</option>
						<option value="Supervisor">Supervisor</option>
					</select>
			</div>

			<div>
				<label  class="form-label">Mobile Number</label>
				<input type="number" class="form-control" id="inputNumber" name="mob_num" placeholder="0774322123">
			</div>

			<div class="text-center">
				<button class="btn btn-dark" type="submit">Add Member</button>
			</div>
		</div>
	</form>

</div>
<div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp"/>
</body>
</html>
