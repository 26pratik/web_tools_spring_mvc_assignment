/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.neu.assignment3part7.Controller;

import com.neu.assignment3part7.Model.Books;
import com.neu.assignment3part7.dao.BooksJDBCDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pratik Hariya
 */
public class AddNewBooks extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        int size = Integer.parseInt(String.valueOf(session.getAttribute("size")));

        BooksJDBCDao dao = new BooksJDBCDao();
        Books book;

        for (int i = 1; i <= size; i++) {
            book = new Books();
            book.setIsbn(request.getParameter("isbn" + i));
            book.setTitle(request.getParameter("title" + i));
            book.setAuthors(request.getParameter("authors" + i));
            book.setPrice(Double.parseDouble(String.valueOf(request.getParameter("price" + i))));

            int result = dao.addBook(book);

            if (result == 1)
                return new ModelAndView("success");
        }

        return new ModelAndView();
    }

}
