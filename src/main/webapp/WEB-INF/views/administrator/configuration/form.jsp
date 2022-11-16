<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<acme:form>
	<acme:input-textbox code="administrator.configuration.configuration.form.label.currency" path="currency"/>
	<acme:input-textbox code="administrator.configuration.configuration.form.label.acceptedCurrencies" path="acceptedCurrencies"/>
	
	
	<acme:input-textbox code="administrator.configuration.configuration.form.label.spmamRecords" path="spamRecords"/>
	
</acme:form>