<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>


<%@page language="java"
	import="acme.framework.helpers.PrincipalHelper,acme.framework.roles.Administrator,acme.framework.roles.Authenticated"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.luis-favourite-link"
				action="https://www.justwatch.com/" />
			<acme:menu-suboption
				code="master.menu.anonymous.ernesto-favourite-link"
				action="https://www.twitch.tv/" />
			<acme:menu-separator/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.any" access="hasRole('Any')">
			<acme:menu-suboption code="master.menu.any.user-accounts" action="/any/user-account/list"/>
			<acme:menu-suboption code="master.menu.any.list-blink" action="/any/blink/list"/>
			<acme:menu-suboption code="master.menu.any.list-theory-tutorial" action="/any/theory-tutorial/list"/>
			<acme:menu-suboption code="master.menu.any.list-lab-tutorial" action="/any/lab-tutorial/list"/>
			<acme:menu-suboption code="master.menu.any.list-course" action="/any/course/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.view-configuration" action="/authenticated/configuration/show"/>
			<acme:menu-suboption code="master.menu.authenticated.list-post" action="/authenticated/post/list"/>
		</acme:menu-option>
	</acme:menu-left>

	
	
	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

