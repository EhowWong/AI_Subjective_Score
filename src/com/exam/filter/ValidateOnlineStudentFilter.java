package com.exam.filter;

import java.io.IOException;  

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.domain.Student;

public class ValidateOnlineStudentFilter implements Filter {

	@Override
	public void destroy() {  
		
	}    
  
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {    
		   
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		Student s = (Student)request.getSession().getAttribute("onlineStudent");
		if(s==null) {
			response.sendRedirect("../studentLoginAgainInput"); 
		}else { 
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
