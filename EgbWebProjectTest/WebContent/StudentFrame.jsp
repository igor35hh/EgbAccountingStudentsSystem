<%@ page contentType="text/html; charset=windows-1251" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>List students</title>
	</head>
	<body>
	
	<form action='<c:url value="/edit"/>' method="POST">
	<input type="hidden" name="studentId" value="${student.studentId}"/>
	
	<table>
		<tr>
			<td>Surname:</td><td><input type="text" name="surName" value="${student.surName}"/></td>
		</tr>
		<tr>
			<td>Name:</td><td><input type="text" name="firstName" value="${student.firstName}"/></td>
		</tr>	
		<tr>
			<td>Patronymic:</td><td><input type="text" name="patronymic" value="${student.patronymic}"/></td>
		</tr>
		<tr>
			<td>Data of birth:</td><td><input type="text" name="dataOfBirth" value="${student.dateOfBirth}"/></td>
		</tr>
		<tr>
			<td>Sex:</td>
			<td>
				<c:choose>
					<c:when test="${student.sex==0}">
						<input type="radio" name="sex" value="0" checked>M</input>
						<input type="radio" name="sex" value="1">W</input>
					</c:when>
					<c:otherwise>
						<input type="radio" name="sex" value="0" checked>W</input>
						<input type="radio" name="sex" value="1">M</input>
					</c:otherwise>
				</c:choose>
			</td>		
		</tr>
		
		<tr>
			<td>Group:</td>
			<td>
			<select name="groupId">
				<c:forEach var="group" items="${student.groups}">
					<c:choose>
						<c:when test="${group.groupId==student.groupId}">
							<option value="${group.groupId}"><c:out value="${group.nameGroup}"/></option> 
						</c:when>
						<c:otherwise>
							<option value="${group.groupId}"><c:out value="${group.nameGroup}"/></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			</td>
		</tr> 
		<tr>
			<td>Year on study</td><td><input type="text" name="educationYear" value="${student.educationYear}"/></td>	
		</tr>		
	</table>
	
	<table>
		<tr>
			<td><input type="submit" value="OK" name="OK"/></td>
			<td><input type="submit" value="Cancel" name="Cancel"/></td>	
		</tr>
	</table>
	
	</form>			
	</body>
</html>