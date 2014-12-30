<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="taglib.jsp" %>
    <h1>${user.name}</h1>
    
    <c:forEach items="${user.blogs}" var="row">
    	<h1>${row.name}</h1>
    	<p>${row.url}</p>
    	
    	<table class="table table table-striped table-hover table-bordered">
    		<thead>
    			<tr>
    				<th>Title</th>
    				<th>Link</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach items="${row.items}" var="item">
    				<tr>
    					<td>${item.title}</td>
    					<td>${item.link}</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    </c:forEach>