package tables;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

public class Util {
	public static void delete (String tableName, DynamoDB dynamoDB) {
		try {
            Table t = dynamoDB.getTable(tableName);
            t.delete();
			t.waitForDelete();
			System.out.println("Deleted table.");
		} catch (InterruptedException e) {
			System.err.println("Unable to delete table: ");
			System.err.println(e.getMessage());
		} catch (ResourceNotFoundException e) {
			System.err.println("Unable to delete table: ");
			System.err.println(e.getMessage());
		}
	}
	
	public static AmazonDynamoDBClient getClient () {
		return new AmazonDynamoDBClient().withRegion(Regions.US_WEST_2);
	}
}
