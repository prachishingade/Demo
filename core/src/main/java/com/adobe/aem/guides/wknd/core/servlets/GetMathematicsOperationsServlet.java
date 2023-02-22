package com.adobe.aem.guides.wknd.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import com.adobe.aem.guides.wknd.core.services.MathematicsOperations;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.granite.rest.Constants;



@Component(service = Servlet.class, property = { "sling.servlet.extensions=json",
		"sling.servlet.selectors=mathsoperations", "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.resourceTypes=/apps/wknd/components/page" })
public class GetMathematicsOperationsServlet extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Reference
	private transient MathematicsOperations mathematicsOperations;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		response.setContentType(Constants.CT_JSON);
		response.setCharacterEncoding("UTF-8");

		int sum = mathematicsOperations.additionsOperation(2, 3);
		try {
			response.setStatus(SlingHttpServletResponse.SC_OK);
			response.getWriter().write("value of sum is: " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
