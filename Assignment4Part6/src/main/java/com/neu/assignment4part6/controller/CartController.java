/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.neu.assignment4part6.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pratik Hariya
 */
@Controller
public class CartController {

	private ArrayList<String> books;
	private ArrayList<String> computers;
	private ArrayList<String> musics;
	private ArrayList<String> arrayList;
	private List cartItems;

	public CartController() {
		books = new ArrayList<>();
		books.add("Java Servlet Programming [$29.95]");
		books.add("Oracle Database Programming [$48.95]");
		books.add("System Analysis and Design With UML [$14.95]");
		books.add("Object Oriented Software Engineering [$35.99]");
		books.add("Java Web Services [$27.99]");

		computers = new ArrayList<>();
		computers.add("Apple MacBook Pro With 13.3' Display [$1299.99]");
		computers.add("Asus Laptop with Centrino 2 Black [$949.95]");
		computers.add("HP Pavhon Laptop with Centrino 2 DV7 [$1199.95]");
		computers.add("Toshaba Satellite Laptop with Centrin 2- Copper [$899.99]");
		computers.add("Sony VAIO Laptop with Core 2 Duo Cosmopolitian Pink [$799.99]");

		musics = new ArrayList<>();
		musics.add("I'm going to Tell You a Secret by Madonna [$26.99]");
		musics.add("Baby One More Time by Broken Back [$10.95]");
		musics.add("Justified by Justin Timberlake [$9.97]");
		musics.add("Loose by Nelly Furtado [$13.98]");
		musics.add("Gold Digger by Kanye West [$27.99]");

		cartItems = new ArrayList();
	}

	@RequestMapping(value = "/shopping.htm", method = RequestMethod.POST)
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession(true);
			arrayList = new ArrayList<>();

			String btnClicked = request.getParameter("btnClicked");
			String checked = request.getParameter("check");
			String deleteItem = request.getParameter("checkDel");

			if (deleteItem != null) {
				Object cartlist = session.getAttribute("cartItems");
				if (cartlist.getClass().isArray()) {
					cartItems = Arrays.asList((Object[]) cartlist);
				}

				for (int i = 0; i < cartItems.size(); i++) {
					if (cartItems.get(i).equals(deleteItem))
						cartItems.remove(cartItems.get(i));
				}

				session.setAttribute("cartItems", cartItems);
				return new ModelAndView("viewCart");
			} else {
				if (btnClicked == null) {
					btnClicked = session.getAttribute("buttonClicked").toString();
				}

				if (btnClicked.equalsIgnoreCase("Book")) {
					for (int i = 0; i < books.size(); i++) {
						arrayList.add(books.get(i));
					}
				} else if (btnClicked.equalsIgnoreCase("Music")) {
					for (int i = 0; i < musics.size(); i++) {
						arrayList.add(musics.get(i));
					}
				} else if (btnClicked.equalsIgnoreCase("Computer")) {
					for (int i = 0; i < computers.size(); i++) {
						arrayList.add(computers.get(i));
					}
				}

				if (checked != null) {
					for (int i = 0; i < arrayList.size(); i++) {
						if (arrayList.get(i).contains(checked)) {
							cartItems.add(arrayList.get(i));
						}
					}
				}

				session.setAttribute("visibleArray", arrayList);
				session.setAttribute("buttonClicked", btnClicked);
				session.setAttribute("cartItems", cartItems);

				return new ModelAndView("index");
			}

		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("index");

		} finally {
			// request.logout();
		}
	}

}
