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
				<td>급여</td>
				<td>부서이름</td>
				<td>도시</td>
				<td>나라</td>
				<td>직책</td>
				<td>직책id</td>
			</tr>
			<c:forEach items="${empDatas}" var="emp" varStatus="status">
				<tr>
				    <td>
				       ${status.count}
				       <c:if test="${status.first}">첫번째</c:if>
				       <c:if test="${status.last}">마지막</c:if>
				       <c:if test="${status.count mod 2 == 0 }">짝수</c:if>
				    </td>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.employee_id}</a>
					</td>
					<td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.first_name}</a>
					</td>
					<td>${emp.salary}</td>
					<td>${emp.department_name}</td>
					<td>${emp.city}</td>
					<td>${emp.country_name}</td>
					<td>${emp.job_title}</td>
					<td>${emp.job_id}</td>
				</tr>
			</c:forEach>
		</table>