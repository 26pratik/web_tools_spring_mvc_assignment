/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.neu.assignment4part4.Controller;

import com.neu.assignment4part4.Model.MovieDatabase;
import com.neu.assignment4part4.dao.MovieDatabaseJDBCDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pratik Hariya
 */
public class NewMovieController extends AbstractController {
    
    public NewMovieController() {
    
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        response.setContentType("text/html;charset=UTF-8");
        
        MovieDatabase movieDb = new MovieDatabase();
        
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));
        
        MovieDatabaseJDBCDao databaseJDBCDao = new MovieDatabaseJDBCDao();
        int value = databaseJDBCDao.insertMovie(title, actor, actress, genre, year);
        
        if(value == 1) {
            movieDb.setMovieName(title);
            movieDb.setLeadActor(actor);
            movieDb.setLeadActress(actress);
            movieDb.setGenre(genre);
            movieDb.setLaunchYear(year); 
            
            request.setAttribute("movieDb", movieDb);
        }
        
        return new ModelAndView("success");
    }

}
