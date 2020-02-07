<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>蓝源Eloan-P2P平台</title>
		<#include "common/links-tpl.ftl" />
		<link type="text/css" rel="stylesheet" href="/css/account.css" />
		<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
		<script>
			$(function(){
				//AJAX提交表单
				$("#userInfoForm").ajaxForm(function(){
					$.messager.confirm("提示","修改成功!",function(){
						window.location.reload();
					})
				})
			})
		</script>		
	</head>
	<body>
		<!-- 网页顶部导航 -->
		<#include "common/head-tpl.ftl" />
		
		<#assign currentNav="personal"/>
		<!-- 网页导航 -->
		<#include "common/navbar-tpl.ftl" />
		
		<div class="container">
			<div class="row">
				<!--导航菜单-->
				<div class="col-sm-3">
					<#assign currentMenu="userInfo" />
					<#include "common/leftmenu-tpl.ftl" />
				</div>
				<!-- 功能页面 -->
				<div class="col-sm-9">
					<div class="panel panel-default">
						<div class="panel-heading">
							个人资料
						</div>
						<form id="userInfoForm" class="form-horizontal" action="/basicInfo_save.do" method="post" style="width: 700px;">
							<div class="form-group">
								<label class="col-sm-4 control-label">
									用户名
								</label>
								<div class="col-sm-8">
									<p class="form-control-static">${logininfo.username}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">
									真实姓名
								</label>
								<div class="col-sm-8">
									<p class="form-control-static">
										<#if (userinfo.isRealAuth)>
											${userinfo.realName}
										<#else>
											未认证
											<a href="/realAuth.do">[马上认证]</a>
										</#if>
									</p>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">
									身份证号码
								</label>
								<div class="col-sm-8">
									<p class="form-control-static">	
										<#if (userinfo.isRealAuth)>
											${userinfo.idNumber}
										<#else>
											未认证
											<a href="/realAuth.do">[马上认证]</a>
										</#if>
									</p>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">
									手机号码
								</label>
								<div class="col-sm-8">
									<label style="width: 250px;" class="form-control">${(userinfo.phoneNumber)!''}</label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">
									个人学历
								</label>
								<div class="col-sm-8">
									<select class="form-control" id="educationBackground" name="educationBackground.id" style="width: 180px" autocomplate="off">
										<#list educationBackgrounds as item>
											<option value="${item.id}">${item.title}</option>
										</#list>
									</select>
									<script type="text/javascript">
										$("#educationBackground option[value=${(userinfo.educationBackground.id)!-1}]").attr("selected",true);
									</script>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">
									月收入
								</label>
								<div class="col-sm-8">
									<select class="form-control" id="incomeGrade" name="incomeGrade.id" style="width: 180px" autocomplate="off" >
										<#list incomeGrades as item>
											<option value="${item.id}">${item.title}</option>
										</#list>
									</select>
									<script type="text/javascript">
										$("#incomeGrade option[value=${(userinfo.incomeGrade.id)!-1}]").attr("selected",true);
									</script>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">
									婚姻情况
								</label>
								<div class="col-sm-8">
									<select class="form-control" id="marriage" name="marriage.id" style="width: 180px" autocomplate="off">
										<#list marriages as item>
											<option value="${item.id}">${item.title}</option>
										</#list>
									</select>
									<script type="text/javascript">
										$("#marriage option[value=${(userinfo.marriage.id)!-1}]").attr("selected",true);
									</script>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">
									子女情况
								</label>
								<div class="col-sm-8">
									<select class="form-control" id="kidCount" name="kidCount.id" style="width: 180px" autocomplate="off">
										<#list kidCounts as item>
											<option value="${item.id}">${item.title}</option>
										</#list>
									</select>
									<script type="text/javascript">
										$("#kidCount option[value=${(userinfo.kidCount.id)!-1}]").attr("selected",true);
									</script>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">
									住房条件
								</label>
								<div class="col-sm-8">
									<select class="form-control" id="houseCondition" name="houseCondition.id" style="width: 180px" autocomplate="off">
										<#list houseConditions as item>
											<option value="${item.id}">${item.title}</option>
										</#list>
									</select>
									<script type="text/javascript">
										$("#houseCondition option[value=${(userinfo.houseCondition.id)!-1}]").attr("selected",true);
									</script>
								</div>
							</div>
							
							<div class="form-group">
								<button id="submitBtn" type="submit" class="btn btn-primary col-sm-offset-5" data-loading-text="数据保存中" autocomplate="off">
									保存数据
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>		
		
		<#include "common/footer-tpl.ftl" />
	</body>
</html>