
"use strict"

// DOM 加载完毕再执行
$(function() {

	// 菜单事件
	$("a").click(function() {
		var url1 = "users";
		console.log("现在的url是："+url1);
		
	//	alert(url);
		// 先移除其他的点击样式，再添加当前的点击样式
		$(".list-group .list-group-item").removeClass("active");
		$(this).addClass("active"); 

		// 加载其他模块的页面到右侧工作区
		$.ajax({
			url: url1,
			success: function(data){
				console.log(data);
				$("#rightContainer").html(data);
			},
			error: function(){
				alert("error");
			}
		}); 
	});
});
