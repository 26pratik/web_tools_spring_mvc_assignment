/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.neu.assignment4part4.Controller;

import com.neu.assignment4part4.Model.MovieDatabase;
import com.neu.assignment4part4.dao.MovieDatabaseJDBCDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pratik Hariya
 */
public class SearchMoviesController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String option = request.getParameter("search");
        String value = request.getParameter("searchType");
        
        List<MovieDatabase> movies = new ArrayList<>();
        MovieDatabaseJDBCDao databaseJDBCDao = new MovieDatabaseJDBCDao();
        databaseJDBCDao.searchMovies(movies, value, option);
        
        return new ModelAndView("MovieResults", "movies", movies);
    }

}
    