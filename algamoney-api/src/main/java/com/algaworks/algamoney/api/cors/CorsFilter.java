package com.algaworks.algamoney.api.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.algaworks.algamoney.api.config.property.AlgamoneyApiProperty;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	//private String origemPermitida = "http://localhost:3000"; // TODO: Configurar para varios ambientes
	
	@Autowired
	private AlgamoneyApiProperty algamoneyApiProperty;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//enviar sempre, em todas as requisicoes
		resp.setHeader("Access-Control-Allow-Origin", algamoneyApiProperty.getOriginAllowed());
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		
		if("OPTIONS".equals(req.getMethod()) && algamoneyApiProperty.getOriginAllowed().equals(req.getHeader("Origin"))) {
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS");
			resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, HEADER1");
			resp.setHeader("Access-Control-Max-Age", "3600");
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, resp);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}	

	@Override
	public void destroy() {
		
	}
	
	
}
