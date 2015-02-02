<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="taglib.jsp" %>
    <h1>${user.name}</h1>
    
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  		New Blog
	</button>

<!-- Modal -->
<form:form commandName="blog" cssClass="form-horizontal">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">New Blog</h4>
      </div>
      <div class="modal-body">
		
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
		    <div class="col-sm-10">
		      <form:input path="name" cssClass="form-control"/>
		    </div>
		</div>        
		<div class="form-group">
			<label for="url" class="col-sm-2 control-label">URL:</label>
		    <div class="col-sm-10">
		      <form:input path="url" cssClass="form-control"/>
		    </div>
		</div>  

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save"/>
      </div>
    </div>
  </div>
</div>
</form:form> 
   <!--  
    <br/><br/>
    
    <div role="tabpanel">

	  Nav tabs
	  <ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
	    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
	    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
	    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
	  </ul>
	
	  Tab panes
	  <div class="tab-content">
	    <div role="tabpanel" class="tab-pane active" id="home">...</div>
	    <div role="tabpanel" class="tab-pane" id="profile">...</div>
	    <div role="tabpanel" class="tab-pane" id="messages">...</div>
	    <div role="tabpanel" class="tab-pane" id="settings">...</div>
	  </div>
	
	</div> -->
    
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