
"use strict"

// DOM 加载完毕再执行
$(function() {
	
	function getUsers() {
		$.ajax({
			url: "/users",
			contentType: 'application/json',
			data:{
				"async":true
			},
			success:function(data){
				$("#mainContainer").html(data);
			},
			error:function(){
				console.log("error");
			}
		});
	}
	
	// 获取编辑用户界面
	//$("#rightContainer").on("click",".edit-user",function(){
	$(".edit-user").click(function(){
		$.ajax({
//			var id = $(this).attr("userId");
			url: "/users/edit/" + $(this).attr("userId"),
			//console.log("id"+"$(this).attr("userId")");
			success:function(data){
				$("userFormContainer").html(data);
			},
			error:function(){
				alert("error!");
			}
		});
	});
	
	// 获取添加用户的界面
	$("#addUser").click(function() {
		$.ajax({ 
			 url: "/users/add", 
			 
			 success: function(data){
				 console.log("现在的url是 /users/add");
				 console.log("出入的类容是："+data);
				 $("#userFormContainer").html(data);
		     },
		     error : function(data) {
		    	 toastr.error("error!");
		     }
		 });
	});
	
	// 点击提交按钮
	$("#submitEdit").click(function(){
		$.ajax({
			url: "/users",
			type: 'POST',
			data:$('#userForm').serialize(),
			success:function(data){
				console.log("成功");
				console.log(data);
				getUsers();
				console.log(data);
			},
			error:function(){
				console.log("错误");
			}
		});
	});
	
	$(".delete-user").click(function(){
		$.ajax({
			url:"/users/"+$(this).attr("userId"),
			type: 'DELETE',
			success:function(data){
				console.log(data);
				getUsers();
			},
			error:function(){
				console.log("error");
			}
		});
	});
	
	
});
