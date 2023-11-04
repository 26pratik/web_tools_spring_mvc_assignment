/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.assignment4Part7.controller;

import com.neu.assignment4Part7.model.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ResultController extends AbstractController {
    
    public ResultController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Result result = (Result)this.getApplicationContext().getBean("id1");
        
        System.out.println(result);
        return new ModelAndView("result", "output", result.getResult("SUCCESS"));
    }
    
}
