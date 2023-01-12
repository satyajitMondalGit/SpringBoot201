package com.mindtree.movie.booking.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class SwaggerCcntroller {

	
	 @ApiIgnore
	    @RequestMapping(value="/")
	    public void redirect(HttpServletResponse response) throws IOException {
	        response.sendRedirect("/swagger-ui.html");
	    }
}
