<%@ page contentType="text/html; charset=windows-1251" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>List students</title>
	</head>
	<body>
	
	<form action='<c:url value="/main"/>' method="POST">
	
	<table>
		<tr>
			<td>Year:<input type="text" name="year" value="${form.year}"/><br/></td>
			<td>List groups:
				<select name="groupId">
					<c:forEach var="group" items="${form.groups}">
						<c:choose>
							<c:when test="${group.groupId==form.groupId}">
								<option value="${group.groupId}" selected><c:out value="${group.nameGroup}"/></option>
							</c:when>
							<c:otherwise>
								<option value="${group.groupId}"><c:out value="${group.nameGroup}"/></option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</td>
			<td><input type="submit" name="getList" value="Update"/></td>	
		</tr>	
	</table>
	
	<p/><b>List of students for on parameters:<b><br/>
	<table>
		<tr>
			<th>&nbsp;</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
		</tr>
		<c:forEach var="student" items="${form.students}">
			<tr>
				<td><input type="radio" name="studentId" value="${student.studentId}"></td>
				<td><c:out value="${student.surName}"/></td>
				<td><c:out value="${student.firstName}"/></td>
				<td><c:out value="${student.patronymic}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<table>
		<tr>
			<td><input type="submit" name="Add" value="Add"/></td>
			<td><input type="submit" name="Edit" value="Edit"/></td>
			<td><input type="submit" name="Delete" value="Delete"/></td>	
		</tr>
	</table>
	
	<p/><b>Muve students in group:<b><br/>
	
	<table>
		<tr>
			<td>Year:<input type="text" name="newYear" value="${form.year}"/><br/></td>
			<td>List groups:
				<select name="newGroupId">
					<c:forEach var="group" items="${form.groups}">
						<option value="${group.groupId}"><c:out value="${group.nameGroup}"/></option>
					</c:forEach>
				</select>
			</td>
			<td><input type="submit" name="MoveGroup" value="Move"/></td>	
		</tr>
	</table>
	
	</form>			
	</body>
</html>