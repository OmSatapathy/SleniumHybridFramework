package uiapi.NationsBenefits;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyApiDetails {

	@Test
	public void verifyDummyJson() {
		Response res = RestAssured.given().contentType("application/json").when().get("https://dummyjson.com/products")
				.andReturn();

		int code = res.getStatusCode();
		Assert.assertEquals(code, 200);
		long responseTime = res.getTime();
		System.out.println(responseTime + " ms");

		JSONObject jObj = new JSONObject(res.asString());
		JSONArray products = jObj.getJSONArray("products");

		for (Object item : products) {
		    JSONObject product = (JSONObject) item;
		    if (product.isNull("category")) {
		        throw new AssertionError("not null values" + product.getInt("id"));
		    }
		}

		// Retrive 3 product from "groceries"
		
		JSONArray groceryProducts = new JSONArray();
		int count = 0;

		for (int i = 0; i < products.length(); i++) {
		    JSONObject product = products.getJSONObject(i);
		    if (product.getString("category").equalsIgnoreCase("groceries")) {
		        groceryProducts.put(product);
		        count++; 
		        if (count == 3) { 
		            break;
		        }
		    }
		}
		
		//None of these products should have a price greater than $5
		
		for (int i = 0; i < groceryProducts.length(); i++) {
		    JSONObject groceryProduct = groceryProducts.getJSONObject(i); 
		    double price = groceryProduct.getDouble("price"); 
		    
		    if (price > 5) { 
		       System.out.println("price is high"+ price);
		    }
		}
	}
}
