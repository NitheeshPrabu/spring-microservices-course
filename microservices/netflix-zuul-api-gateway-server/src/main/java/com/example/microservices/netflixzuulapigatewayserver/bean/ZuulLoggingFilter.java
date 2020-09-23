package com.example.microservices.netflixzuulapigatewayserver.bean;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    // Logging, Security, Rate Limiting

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        // indicates whether filter must be executed before (`pre`) or after (`post`) every request,
        // or only for `error` requests
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true; // execute the filter for every request
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
        return null;
    }
}
