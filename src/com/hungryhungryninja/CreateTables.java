package com.hungryhungryninja;

public class CreateTables {

	public static void main(String[] args) {
		// Create all of the tables 
		tables.IngredientsTableCreate.create();
		tables.IdTableCreate.create();
		tables.MealsTableCreate.create();
		tables.RecipesTableCreate.create();
		tables.UnitOfMeasuresTableCreate.create();
		tables.UnitOfMeasuresConversionsTableCreate.create();
	}

}
