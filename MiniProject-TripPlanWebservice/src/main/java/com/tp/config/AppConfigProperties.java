package com.tp.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "content.messages")
@EnableConfigurationProperties
@Data
public class AppConfigProperties {
	
	private Map<String,Map<String,String>> return_messages;

}
