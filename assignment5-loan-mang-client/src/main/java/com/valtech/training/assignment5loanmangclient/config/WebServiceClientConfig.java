package com.valtech.training.assignment5loanmangclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.assignment5loanmang.webservices.LoanServiceWS;

@Configuration
public class WebServiceClientConfig {

	@Bean
	public LoanServiceWS createLoanService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.assignment5loanmang.training.valtech.com/", "LoanServiceWSImpl"));
		proxy.setAddress("http://localhost:8080/services/loanService");
		return proxy.create(LoanServiceWS.class);
	}
}
