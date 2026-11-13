package com.topcarservice.coreapi.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.dynamodb")
public record DynamoDbProperties(String tableName, String region, String endpoint) {
}
