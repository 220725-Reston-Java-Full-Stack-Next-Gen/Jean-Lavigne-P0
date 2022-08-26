package com.jean.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class Frontcontroller extends HttpServlet{

	private static Logger LOGGER = Logger.getLogger(Frontcontroller.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//we use URI rewriting to better manage the navigation of our HTTP requests as they come to the FrontController
		final String URI = req.getRequestURI().replace("/FoundationalProject/", "");
		
		LOGGER.info("User trying to access endpoint: " + URI);
		
		switch(URI) {
			case "register":
				LOGGER.info("User is registering for a new user account...");
				RequestHelper.processRegistration(req, resp);
				break;
			case "login":
				LOGGER.info("User is logging booting up...");
				RequestHelper.processLogin(req, resp);
				break;
			case "logout":
				LOGGER.info("User is logging out beep boop bam...");
				RequestHelper.processLogout(req, resp);
				break;
			case "searching by unsername":
				LOGGER.info("User is trying to srach by username...");
				RequestHelper.processSearchByUsername(req, resp);
				break;
			case "accounts/new":
				LOGGER.info("User is trying to make a new bank account...");
				RequestHelper.processAddeNewReimbursement(req, resp);
				break;
			default:
				LOGGER.warn("No path present: " + URI);
				break;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//we use URI rewriting to better manage the naviagation of our HTTP requests as they come to the FrontController
		final String URI = req.getRequestURI().replace("/FakeProject1Scraper/", "");
		
		LOGGER.info("User trying to access endpoint: " + URI);
		
		switch(URI) {
			case "users":
				LOGGER.info("User is searching by username...");
				RequestHelper.processSearchByUsername(req, resp);
				break;
			default:
				LOGGER.warn("No path present: " + URI);
				break;
		}
	}
}
