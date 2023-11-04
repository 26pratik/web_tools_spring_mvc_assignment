/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.assignment4Part9.controller;

import com.neu.assignment4Part9.model.Result;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController{

    Result result;

    @RequestMapping(value = "/result.htm", method = RequestMethod.GET)
    public String handleRequestInternal(HttpServletRequest request, Result res) throws Exception{
        request.setAttribute("output", res);
        return "result";
    }    

    
}
