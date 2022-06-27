package com.samer.ms.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class LocalFilter implements GlobalFilter{

	private Logger logger=LoggerFactory.getLogger(LocalFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		logger.info("Path of the log received->{}",exchange.getRequest().getPath());
		logger.info("Path of the log received->{}",exchange.getRequest().getBody());
		logger.info("Path of the log received->{}",exchange.getRequest().getHeaders());
		logger.info("Path of the log received->{}",exchange.getRequest().getQueryParams());
		
		return chain.filter(exchange);
	}
	

}
