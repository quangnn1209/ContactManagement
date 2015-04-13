<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="shortcut icon" href="<c:url value="/images/favicon.ico"></c:url>">
<script type="text/javascript" charset="utf8" src="./javascript/lib/angular.js"></script>
</head>
<div class="header">
	<tiles:insertAttribute name="header" ignore="true" />
</div>
<div class="body">
	<tiles:insertAttribute name="body" />
</div>
<div class="footer">
	<tiles:insertAttribute name="footer" ignore="true" />
</div>
</html>