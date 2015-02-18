<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>       
	<div>
		<tiles:insertAttribute name="body" />
	</div>
</body>
</html>
