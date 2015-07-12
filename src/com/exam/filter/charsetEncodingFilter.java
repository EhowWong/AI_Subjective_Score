package com.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 采用filter设置字符集
 * @author 王毅昊
 *
 */
public class charsetEncodingFilter implements Filter {
	
	private String encoding;
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//设置字符集
		request.setCharacterEncoding(encoding);
		
		//继续执行
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.encoding=filterConfig.getInitParameter("encoding");
	}

}
