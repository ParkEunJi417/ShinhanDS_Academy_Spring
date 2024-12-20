package com.shinhan.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.myapp.vo.MemberDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @WebFilter : Servlet3버전부터 지원
 */

@Slf4j
@WebFilter("*.do")
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청 수행하기 전
		HttpServletRequest req = (HttpServletRequest)request;
		
		// 요청의 주소 얻기
		String contextPath = req.getServletContext().getContextPath();
		String uri = req.getRequestURI();
		uri = uri.substring(contextPath.length());
		
		log.info("contextPath:"+contextPath);
		log.info("요청주소:"+uri);
		
		// 요청주소가 로그인이면 요청대로 수행하고 로그인이 아니면 로그인한건지 체크
		if(!uri.equals("/auth/login.do") && !uri.startsWith("/rest")) {
			HttpSession session = req.getSession();
			MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
			
			if(member == null) {
				log.info("로그인 안함");
				HttpServletResponse res = (HttpServletResponse)response;
				res.sendRedirect(contextPath + "/auth/login.do");
				return;
			}
		}
		
		chain.doFilter(request, response);
		// 요청 수행 후(응답전)
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
