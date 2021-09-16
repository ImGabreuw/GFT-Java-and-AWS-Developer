package me.gabreuw.restful.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Log4j2
public class AppFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Entrou no portão do castelo.");

        HttpServletRequest servletRequest = (HttpServletRequest) request;

        Enumeration<String> headerNames = servletRequest.getHeaderNames();
        Map<String, String> headers = Collections.list(headerNames)
                .stream()
                .collect(Collectors.toMap(
                        headerName -> headerName, servletRequest::getHeader)
                );
        String authorization = headers.get("authorization");

        HttpServletResponse servletResponse = (HttpServletResponse) response;

        if (authorization == null) {
            servletResponse.sendError(403, "É necessário informar uma senha!");
            return;
        }

        if (!authorization.equals("TESTE")) {
            servletResponse.sendError(403, "Senha incorreta!");
            return;
        }

        chain.doFilter(request, response);

        log.info("Saiu do portão do castelo!");
    }

}
