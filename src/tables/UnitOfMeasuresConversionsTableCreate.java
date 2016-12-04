package tables;

import java.util.Arrays;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class UnitOfMeasuresConversionsTableCreate {

	public static void create() {
		AmazonDynamoDBClient client = Util.getClient();
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "UnitOfMeasures";
        
        Util.delete(tableName, dynamoDB);

        try {
            System.out.println("Attempting to create table; please wait...");
            Table table = dynamoDB.createTable(tableName,
                Arrays.asList(
                    new KeySchemaElement("fromName", KeyType.HASH),
                    new KeySchemaElement("toName", KeyType.RANGE)),
                    Arrays.asList(
                        new AttributeDefinition("fromName", ScalarAttributeType.S),
                        new AttributeDefinition("toName", ScalarAttributeType.S)), 
                    new ProvisionedThroughput(1L, 1L));
            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

        } catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }

	}

}
