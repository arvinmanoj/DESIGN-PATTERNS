/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranfood;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ramis
 */
public class RanFood {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);
    static MealBuilder mealBuilder = MealBuilder.getMealBuilder();
    static List<Meal> meals = new ArrayList<>();
     public static void main(String[] args) {
      while(true){
          System.out.println("Welcome to Fast Food Management");
          System.out.println("Create a Meal Press 1 ");
          System.out.println("Show all Meals Press 2 ");
          System.out.println("Clone Meal Press 3 ");
          System.out.println("Exit Press anything else");
          String input = scan.next();
          if(input.equals("1")){
              meals.add(createMeal());
          }
          else if(input.equals("2")){
              showMeal();
          }
          else if(input.equals("3")){
              cloneMeal();
          }
          else
              break;
        }
    }

    private static Meal createMeal() {
        do
        {
        System.out.println("Vegetarian Meal - 1");
        System.out.println("Non-Vegetarian Meal - 2");
        String input = scan.next();
        if(input.equals("1"))
        {
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
        return vegMeal;
        }
        else if(input.equals("2"))
        {
                    Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
            return nonVegMeal;
        }
        }while(true);
    }

    private static void showMeal() {
        System.out.println("-----------------------------------------");
        double cost = 0;
        for (int i = 0; i < meals.size(); i++) {
            System.out.println("MEAL #"+i);
            meals.get(i).showItems();
            cost += meals.get(i).getCost();
        }
        System.out.println("Total Cost: "+cost);
        System.out.println("-----------------------------------------");
    }

    private static void cloneMeal() {
        showMeal();
        String input = scan.next();
        try{
           meals.add((Meal) meals.get(Integer.parseInt(input)).clone());
        }
        catch(Exception e)
                {
            
        }
    }

}

