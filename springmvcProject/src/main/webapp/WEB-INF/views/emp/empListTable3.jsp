<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<fmt:setLocale value="en_US"/>

<table class="table table-striped table-bordered table-hover">
			<tr>
			    <td>순서</td>
				<td>직원번호</td>
				<td>fname</td>
				<td>salary</td>
				<td>job_id</td>
				<td>department_name</td>
				<td>city</td>
				<td>country_name</td>
			</tr>
			<c:forEach items="${empDatas}" var="emp" varStatus="status">
				<tr>
				    <td>
				       ${status.count}
				       <c:if test="${status.first}">첫번째</c:if>
				       <c:if test="${status.last}">마지막</c:if>
				       <c:if test="${status.count mod 2 == 0 }">짝수</c:if>
				    </td>
					<td><a href="${path}/emp/detail.do?empid=${emp['EMPLOYEE_ID']}">${emp['EMPLOYEE_ID']}</a>
					</td>
					<td><a href="${path}/emp/detail.do?empid=${emp['EMPLOYEE_ID']}">${emp['FIRST_NAME']}</a>
					</td>
					<td>${emp["SALARY"]}</td>
					<td>${emp["JOB_ID"]}</td>
					<td>${emp["DEPARTMENT_NAME"]}</td>
					<td>${emp["CITY"]}</td>
					<td>${emp["COUNTRY_NAME"]}</td>
				</tr>
			</c:forEach>
		</table>