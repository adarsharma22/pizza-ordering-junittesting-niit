package com.jap.pizzaorderingsystem;

import java.util.Scanner;

public class PizzaOrdering {
    public static void main(String[] args) {
        // Make no changes to the main method
        PizzaOrdering pizzaOrdering = new PizzaOrdering();

        String name = "";
        String email = "";
        long phoneNo = 0;
        String address = "";

        // Input customer details
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! Welcome !!!");
        System.out.println("!!! Enter customer details for placing an order !!!");

        System.out.println("Enter your Name");
        name = scanner.next();
        System.out.println("Enter your Email");
        email = scanner.next();
        System.out.println("Enter your ContactNo.");
        phoneNo = scanner.nextLong();
        System.out.println("Enter your Address");
        address = scanner.next();
        scanner.nextLine();
        System.out.println("\n");
        System.out.println("!!! Thank you for providing your details !!!");
        System.out.println("\n");

        // Display main menu and estimate bill based on user's choice
        int totalPizzaBill = 0;
        totalPizzaBill = pizzaOrdering.displayMenuAndCalculateTotalBill(totalPizzaBill);
        System.out.println("\n");
        System.out.println("Total amount : " + totalPizzaBill);
        System.out.println("\n");

        // Estimate discount amount based on total pizza bill and calculate final bill.
        int discountAmount = pizzaOrdering.estimateDiscountAmount(totalPizzaBill);
        int billAfterDiscount = totalPizzaBill - discountAmount;
        System.out.println("\n");

        // Input the type of delivery of order and add delivery fee and tip charge to total bill
        System.out.println("Please enter 1 for Pick up and 2 for delivery");
        int delivery = scanner.nextInt();
        int deliveryCharge = 0;
        int tipCharge = 0;

        if (delivery == 2) {
            deliveryCharge = 100;
            System.out.println("\n");
            System.out.println("Do you want to give tip to Delivery Boy (yes/no)?");
            String tip = scanner.next();
            if ("yes".equals(tip)) {
                System.out.println("Please enter tip amount :");
                tipCharge = scanner.nextInt();
            }
        }

        // Estimate and display final pizza order bill
        int finalBill = pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(deliveryCharge, tipCharge, billAfterDiscount);
        pizzaOrdering.displayFinalBill(name, phoneNo, totalPizzaBill, discountAmount, deliveryCharge, tipCharge, finalBill);
    }


    // Function to display main menu and call respective methods based on user's choice
    // Do not change the method
    public int displayMenuAndCalculateTotalBill(int totalPizzaBill) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the item from the Main Menu");
        System.out.println("\n");

        int input = 0;
        do {
            System.out.format("%10s %30s", "Srno", "Item Category\n");
            System.out.format("%10s %30s", "1", "Pizza\n");
            System.out.format("%10s %30s", "2", "Garlic Bread\n");
            System.out.format("%10s %30s", "3", "Beverages\n");
            System.out.println();
            System.out.println("Enter your Choice of item");
            int choiceForItems = scanner.nextInt();

            if (choiceForItems == 1) {
                System.out.println("Please enter the number of pizza you want to order :");
                int noOfPizza = scanner.nextInt();
                totalPizzaBill = displayPizzaChoicesAndCalculateTotalBill(noOfPizza, totalPizzaBill);
            } // End of pizza

            else if (choiceForItems == 2) {
                totalPizzaBill = displayBreadChoiceAndCalculateBill(totalPizzaBill);
            }// End of breads

            else if (choiceForItems == 3) {
                totalPizzaBill = displayDrinksChoicesAndCalculateBill(totalPizzaBill);
            } // End of drinks

            System.out.println("\n");
            System.out.println("Your total Pizza Bill :" + totalPizzaBill);
            System.out.println("\n");
            System.out.println("Do you want to place another order enter 1 to continue or 0 to exit");
            input = scanner.nextInt();

        } while (input == 1);
        return totalPizzaBill;
    }


    public int displayPizzaChoicesAndCalculateTotalBill(int noOfPizza, int totalPizzaBill) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < noOfPizza; i++) {
            // Call the method displayPizzaChoices() to display pizza choices
            displayPizzaChoices();
            // accept the choice of pizza from user
            System.out.println("Enter your pizza choice");
            int pizzaChoice =scanner.nextInt();
            // accept the size of the pizza
            System.out.println("Enter Size of Pizza (L for Large, M for Medium, R for Regular) :");
            String pizzaSize=scanner.next();
            // Call the method calculateBillBasedOnPizzaChoiceAndSize(totalPizzaBill, pizzaChoice, pizzaSize)
            // to calculate total bill amount based on pizza choice and size
            totalPizzaBill = calculateBillBasedOnPizzaChoiceAndSize(totalPizzaBill,pizzaChoice,pizzaSize);

            // Accept the choice of crust from user
            System.out.println("Do you want to choose Crust of your choice (yes/no)?");
            String choiceOfCrust = scanner.next();
            // Call method displayCrustChoicesAndEstimatePrice(choiceOfCrust) to display the crust choice
            // and returns cost based on crust choice
            int costOfCrust = displayCrustChoicesAndEstimatePrice(choiceOfCrust);
            System.out.println("\n");

            // Accept the choice of extra toppings from user
            System.out.println("Do you want to choose extra Toppings (yes/no)?");
            String choiceOfToppings =scanner.next();
            // Call method displayToppingsAndEstimatePrice(choiceOfToppings) to display the choice of toppings
            // and returns the cost of the toppings based on toppings choice
            int costOfToppings = displayToppingsAndEstimatePrice(choiceOfToppings);

            // Call method calculateBillWithCrustAndToppings(totalPizzaBill, costOfCrust, costOfToppings)
            // to calculate the total cost of the pizza
            totalPizzaBill = calculateBillWithCrustAndToppings(totalPizzaBill,costOfCrust,costOfToppings);
        }
        // return the total amount
        return totalPizzaBill;
    }

    // Function displays choices of pizza
    public void displayPizzaChoices() {
        System.out.format("%10s %30s %30s %30s %30s", "Srno", "Pizza","Regular","Medium","Large\n");
        System.out.format("%10s %30s %30s %30s %30s", "1", " African Peri Peri Veg","NA","350","450\n");
        System.out.format("%10s %30s %30s %30s %30s", "2", " Barbecue Veg","NA","300","400\n");
        System.out.format("%10s %30s %30s %30s %30s", "3", " Jamaican Jerk Veg","250","350","450\n");
        System.out.format("%10s %30s %30s %30s %30s", "4", "What-a-pizza Exotic","200","300","400\n");
        System.out.format("%10s %30s %30s %30s %30s", "5", " English Cheddar and Veggies","175","375","500\n");
        System.out.println();
        // Use System.out.format to display the menu in a tabular format

    }

    // Function calculates total pizza bill based on choice of pizza and its size
    public int calculateBillBasedOnPizzaChoiceAndSize(int totalPizzaBill, int pizzaChoice, String pizzaSize) {
        // write logic to calculate the cost of pizza based on pizza choice and size
        // return the cost calculated
        if(pizzaChoice==1 && pizzaSize.equals("R")){
            System.out.println("NA");
        } else if (pizzaChoice==1 && pizzaSize.equals("M")) {
            totalPizzaBill=totalPizzaBill+350;
        }else if (pizzaChoice==1 && pizzaSize.equals("L")) {
            totalPizzaBill=totalPizzaBill+450;
        }else if(pizzaChoice==2 && pizzaSize.equals("R")){
            System.out.println("NA");
        } else if (pizzaChoice==2 && pizzaSize.equals("M")) {
            totalPizzaBill=totalPizzaBill+300;
        }else if (pizzaChoice==2 && pizzaSize.equals("L")) {
            totalPizzaBill=totalPizzaBill+400;
        }else if(pizzaChoice==3 && pizzaSize.equals("R")){
            totalPizzaBill=totalPizzaBill+250;
        } else if (pizzaChoice==3 && pizzaSize.equals("M")) {
            totalPizzaBill=totalPizzaBill+350;
        }else if (pizzaChoice==3 && pizzaSize.equals("L")) {
            totalPizzaBill=totalPizzaBill+450;
        }else if(pizzaChoice==4 && pizzaSize.equals("R")){
            totalPizzaBill=totalPizzaBill+200;
        } else if (pizzaChoice==4 && pizzaSize.equals("M")) {
            totalPizzaBill=totalPizzaBill+300;
        }else if (pizzaChoice==4 && pizzaSize.equals("L")) {
            totalPizzaBill=totalPizzaBill+400;
        }else if(pizzaChoice==5 && pizzaSize.equals("R")){
            totalPizzaBill=totalPizzaBill+175;
        } else if (pizzaChoice==5 && pizzaSize.equals("M")) {
            totalPizzaBill=totalPizzaBill+375;
        }else if (pizzaChoice==5 && pizzaSize.equals("L")) {
            totalPizzaBill=totalPizzaBill+500;
        }else{
            totalPizzaBill=0;
        }

        return totalPizzaBill;
    }

    // Function displays choices of crusts and calls method to estimate cost of crust
    public int displayCrustChoicesAndEstimatePrice(String choiceOfCrust) {
        Scanner scanner=new Scanner(System.in);
        if(choiceOfCrust=="no"){
            return 0;
        }else if (choiceOfCrust.equals("yes")){
            System.out.format("%10s %30s %30s", "Srno", "Crust","Price\n");
            System.out.format("%10s %30s %30s", "1","Wheat Thin Crust", "60\n");
            System.out.format("%10s %30s %30s", "2"," Fresh Pan Base", "80\n");
            System.out.format("%10s %30s %30s", "3","Hand Tossed","70\n");
            System.out.println();


            // need to be print the table
        }
        System.out.println("Enter Crust Choice");
        int crustChoice=scanner.nextInt();
        int result1=estimatePriceOfCrust(crustChoice);

        //Call method estimatePriceOfCrust(crustChoice) to estimate the cost and return the cost

        return result1;
    }

    // Function estimates cost of crust based on user's choice of crust
    public int estimatePriceOfCrust(int crustChoice) {
        int billcrust=0;
        if(crustChoice==1){
            billcrust=billcrust+60;
        } else if (crustChoice==2) {
            billcrust=billcrust+80;
        } else if (crustChoice==3){
            billcrust=billcrust+70;
        }else{
            billcrust= 0;
        }
        //write logic to calculate the estimated price based on choice of crust
        // return the estimated price
        return billcrust;
    }

    // Function displays choices of toppings ans calls method to estimate price of topping
    public int displayToppingsAndEstimatePrice(String choiceOfToppings) {
        Scanner scanner=new Scanner(System.in);
        if(choiceOfToppings.equals("no")){
            return 0;
        } else if(choiceOfToppings.equals("yes")){
            System.out.format("%10s %30s %30s", "S.No.","Toppings"," Price (in Rupees)\n");
            System.out.format("%10s %30s %30s", "1","Extra Cheese", "80\n");
            System.out.format("%10s %30s %30s", "2","Veg Toppings","120\n");
            System.out.println();
            //print the menu of toppings
        }
        System.out.println("Enter Toppings");
        int toppingsChoice=scanner.nextInt();
        int result2=estimatePriceOfToppings(toppingsChoice);
        // Call method estimatePriceOfToppings(int toppingsChoice) to estimate the cost and return the cost
        return result2;
    }

    // Function estimates cost of toppings based on user's choice of toppings
    public int estimatePriceOfToppings(int toppingsChoice) {
        int tprice=0;
        if(toppingsChoice==1){
            tprice=tprice+80;
        } else if (toppingsChoice==2) {
            tprice=tprice+120;
        }else{
            tprice=0;
        }
        //write logic to calculate the estimated price based on choice of toppings
        // return the estimated price
        return tprice;
    }

    // Function calculates total pizza bill by adding cost of crust and toppings
    public int calculateBillWithCrustAndToppings(int totalPizzaBill, int costOfCrust, int costOfToppings) {
        int result3=0;
        System.out.println(totalPizzaBill);
        result3=totalPizzaBill+costOfCrust+costOfToppings;
        return result3;
    }

    // Function displays choices of bread and calls method to calculates total bill
    public int displayBreadChoiceAndCalculateBill(int totalPizzaBill) {
        Scanner scanner=new Scanner(System.in);
        System.out.format("%10s %30s %30s", "S.No."," Bread "," Price (in Rupees)\n");
        System.out.format("%10s %30s %30s", "1"," Stuffed Garlic Bread ", "90\n");
        System.out.format("%10s %30s %30s", "2","Plain Garlic Bread Sticks","80\n");
        System.out.println();
        // display the choice of breads
        System.out.println("Enter the bread choice");
        int breadChoice=scanner.nextInt();
        int breadPrice=calculateBillBasedOnChoiceOfBread(breadChoice,totalPizzaBill);
        // Call the method calculateBillBasedOnChoiceOfBread(breadChoice, totalPizzaBill) to calculate total cost
        // return the total bill amount
        return breadPrice;
    }

    // Function estimates cost of bread based on user's choice and adds it to the total pizza bill
    public int calculateBillBasedOnChoiceOfBread(int breadChoice, int totalPizzaBill) {
        int result4=0;
        if(breadChoice==1){
            result4=result4+90;
        } else if (breadChoice==2) {
            result4=result4+80;
        }else{
            result4=0;
        }
        // write logic to calculate the cost of bread based on choice and add it to the total pizza bill amount
        // return the cost calculated

        return result4;
    }

    // Function displays choices of drinks and calls method to calculates total bill
    public int displayDrinksChoicesAndCalculateBill(int totalPizzaBill) {
        Scanner scanner=new Scanner(System.in);
        System.out.format("%10s %30s %30s", "S.No.","  Beverage "," Price (in Rupees)\n");
        System.out.format("%10s %30s %30s", "1","  Pepsi", "60\n");
        System.out.format("%10s %30s %30s", "2","Coke","60\n");
        System.out.println();
        //display the choice of drinks
        System.out.println("Enter the Drinks Choice");
        int drinksChoice=scanner.nextInt();
        int drinkprice=calculateBillBasedOnDrinksChoice(drinksChoice,totalPizzaBill);
        //Call the method calculateBillBasedOnDrinksChoice(drinksChoice, totalPizzaBill) to calculate total cost
        // return the cost calculated;

        return drinkprice;
    }

    // Function estimates cost of drink based on user's choice and adds it to the total pizza bill
    public int calculateBillBasedOnDrinksChoice(int drinksChoice, int totalPizzaBill) {
        int result5=0;
        if(drinksChoice==1){
            result5=result5+60;
        } else if (drinksChoice==2) {
            result5=result5+60;
        }else{
            result5=0;
        }
        // write logic to calculate the cost of drinks based on choice and add it to the total pizza bill amount
        // return the cost calculated

        return result5;
    }

    // Function calculates discount amount based on total pizza bill
    // Do not change the method
    public int estimateDiscountAmount(int totalPizzaBill) {
        int discount = 0;
        int discountamount = 0;

        if (totalPizzaBill >= 500 && totalPizzaBill < 1000) {
            discount = 5;
            discountamount = (totalPizzaBill * discount) / 100;

        } else if (totalPizzaBill >= 1000 && totalPizzaBill < 1500) {
            discount = 10;
            discountamount = (totalPizzaBill * discount) / 100;
        }
        return discountamount;
    }

    // Function calculates final bill by adding delivery fee and tip charge to total bill
    // Do not change the method
    public int calculateFinalBillBasedOnDeliveryChargeAndTipCharge(int deliveryCharge, int tipCharge, int finalBill) {
        return finalBill + deliveryCharge + tipCharge;
    }

    // Function displays final bill with all necessary details to customer
    // Do not change the method
    public void displayFinalBill(String name, long phoneNo, int totalPizzaBill, int discountAmount, int deliveryCharge, int tipCharge, int finalBill) {
        System.out.println("--------------------------------------------------------");
        System.out.println(" !!! BILL REPORT !!!");
        System.out.println(" Customer Name     : " + name + " \n");
        System.out.println(" Contact No.       : " + phoneNo + " \n");
        System.out.println(" Total Amount      : " + totalPizzaBill + " \n");
        System.out.println(" Discount Applied  : " + "- " + discountAmount + " \n");
        System.out.println(" Delivery Fee      : " + "+ " + deliveryCharge + " \n");
        System.out.println(" Tip               : " + "+ " + tipCharge + " \n");
        System.out.println(" Total Amount      : " + finalBill + " \n");
        System.out.println("--------------------------------------------------------");
    }
}
