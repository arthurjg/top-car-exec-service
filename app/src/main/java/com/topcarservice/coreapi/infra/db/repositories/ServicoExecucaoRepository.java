package com.topcarservice.coreapi.infra.db.repositories;

import org.springframework.stereotype.Repository;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.infra.config.DynamoDbProperties;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class ServicoExecucaoRepository  {
	
	private final DynamoDbTable<ServicoExecucaoEntity> table;
	
	public ServicoExecucaoRepository(DynamoDbEnhancedClient enhancedClient, DynamoDbProperties props) {
        this.table = 
        		enhancedClient.table(props.tableName(), 
        				TableSchema.fromBean(ServicoExecucaoEntity.class));
    }
	
	public ServicoExecucaoEntity save(ServicoExecucaoEntity product) {
        table.putItem(product);
        return product;
    }

}
