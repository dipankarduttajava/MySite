<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
   <%@include file="taglib.jsp" %>
    
    
    <table class="table table table-striped table-hover table-bordered">
    	<thead>
    		<tr>
    			<th>User Name</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${users}" var="row">
    			<tr>
    				
    				<td>
    					<a href='<spring:url value="/users/${row.id}.html"/>'>${row.name}</a>
    					
    				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>