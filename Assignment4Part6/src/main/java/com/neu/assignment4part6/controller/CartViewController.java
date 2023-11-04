/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.neu.assignment4part6.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pratik Hariya
 */
@Controller
public class CartViewController {
	
	public CartViewController() {
	}
	
	@RequestMapping(value="cartview.htm")
	protected ModelAndView handleRequestInternal(
		HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		return new ModelAndView("viewCart");
	}
	
}
