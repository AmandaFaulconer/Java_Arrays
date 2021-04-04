// Array assignment
// Amanda Faulconer

package array_assignment;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Array_assignment {
    
////////////////////////////////////////////////////////////////////////////////
////// TVShows Arraylist ///////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    static void TvShowArray(){
        System.out.println("\n\n-- TV Show ---\n");
        
        //Variables
        Scanner tvshowScan = new Scanner(System.in);
        String Response;
        String Delete;
        String UserAddTv;
        
        //New array list
        ArrayList TvShow = new ArrayList();
        
        //add some to get it started            //If you havent seen any of these - you should!!
        TvShow.add("Narcos");
        TvShow.add("The Good Doctor");
        TvShow.add("Yellowstone");
        TvShow.add("Nailed it");
        TvShow.add("Shitt's Creek");
        TvShow.add("The Crown");
        TvShow.add("The Queens Gambet");
        
        //print the begining list
        for(int c = 0; c < TvShow.size(); c++)
            System.out.println("This is " + TvShow.get(c));
        
        
        // user add to the list
        System.out.println("Would you like to add a tv show to the list? y/n");
        Response = tvshowScan.nextLine().toLowerCase();
        while(Response.equals("y")){
            System.out.println("What tv show would you like to add to the list?");
            UserAddTv = tvshowScan.nextLine();
            System.out.println("Would you like to add the show to the begining or end? b/e");
            Response = tvshowScan.nextLine().toLowerCase();
            switch(Response){
                case "b": {
                    TvShow.add(0, UserAddTv);
                    for (int TvCntr  = 0; TvCntr < TvShow.size(); TvCntr++) {
                        System.out.println("This is " + TvShow.get(TvCntr));                        
                    }
                    break;
                }
                case "e": {
                    TvShow.add(UserAddTv);
                    for(int c = 0; c < TvShow.size(); c++){
                        System.out.println("This is " + TvShow.get(c));
                    }
                    break;
                }
                default: 
                    System.out.println("That was not a choice.");
                    break;
            }
            System.out.println("Would you like to add another tv show? y/n");
            Response = tvshowScan.nextLine().toLowerCase();
        }
        
        // allow the user to remove an item from the list
        System.out.println("Would you like to remove a TvShow from the list? y/n");
        Response = tvshowScan.nextLine().toLowerCase();
        while(Response.equals("y")){
            System.out.println("Which tvShow would you like to remove?");
            Delete = tvshowScan.nextLine();
            TvShow.remove(Delete);
            
            System.out.println("Would you like to remove another tv show? y/n");
            Response = tvshowScan.nextLine().toLowerCase();
        }
        
        //Print the updated list after user has removed and added as they wish
        System.out.println("Update TvShow List");        
        for(int c = 0; c < TvShow.size(); c++)
            System.out.println("This is " + TvShow.get(c));
        
        //allow the user to go back to the main menu
        Menu();
    }
    
////////////////////////////////////////////////////////////////////////////////
//////// MySize Array //////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    //Global Variables for MySize
    static double [][] MySize;   
    static Scanner scanSize = new Scanner(System.in); 
    static int columns = 0;
    static int rows = 0;
    
    static void PrintMySize(){       
    //Print the grid out using two FOR  statements to print 
    //the grid immediately after the user enters the data so 
    //they can see the results.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                System.out.print(MySize[r][c] + " ");
            }
            System.out.println();
        }
}
    
    static void MySize(){
        
        System.out.println("\nEnter the number of columns: ");
        rows = Integer.parseInt(scanSize.nextLine());
        System.out.println("Enter the number of rows: ");
        columns = Integer.parseInt(scanSize.nextLine());       
        MySize = new double[rows][columns];
        System.out.println();
        //Build the array using two for statements
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                System.out.print(MySize[r][c] + " ");
            }
            System.out.println();
        }
        
        int blue = 0;
        double value = 0;
        int b1 = 0;
        int b2 = 0;
        //Allow the user to enter a value into the array
        System.out.println("\nEnter a value into the array you just created\n");
        while(blue < 1){
            System.out.println("Enter value:  ");
            value = Double.parseDouble(scanSize.nextLine());
            System.out.println("What row:   ");
            b1 = Integer.parseInt(scanSize.nextLine()) -1;
            System.out.println("What column: ");
            b2 = Integer.parseInt(scanSize.nextLine()) -1;
            
            try{
                if(b1 <= rows-1 && b2 <= columns-1){
                    System.out.println("Good position\n");
                }
                blue++;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Not a good position");  
                blue++;
                MySize();        
            }
        }
        
        // add input into the array
        MySize[b1][b2] = value;
        PrintMySize();     
        System.out.println();
        MySizeMenu();
}         
 
    static void ClearMySize(){
               
        //Allow the user to clear the array, by filling it in will
        //all zeros.Print the array so the user can see the 
        //results. Present this as an if statement.
        System.out.println("\nYour cleared array is: ");
         if(MySize != null){
            for(double[] d: MySize){
            Arrays.fill(d, 0.0);
            }
        }
         PrintMySize();
         MySizeMenu();
    }

//Menu to control the MySize Array    
    static void MySizeMenu(){
               
        int choice;
        System.out.println("\nChoose from one of the following options: ");
        System.out.println("\nMySize Menu\n"
                +"\nMySize Options: "
                + "\n1. Build MySize and enter data" 
                + "\n2. Clear MySize Array"
                + "\n3. Repeat the MySize Menu"
                + "\n4. Go back to the main menu"
                + "\n5. End the program"
        );
        choice = Integer.parseInt(scanSize.nextLine());
        switch(choice){
            case 1 -> MySize();
            case 2 -> ClearMySize();
            case 3 -> MySizeMenu();
            case 4 -> Menu();
            case 5 -> {
                System.out.println("Thank you for playing! Have a good day!");
                System.exit(0);
            }
        } 
    }
      
///////////////////////////////
//////// ALNums Array /////////
///////////////////////////////
    
    static ArrayList<Integer> AlNums = new ArrayList<>();
    
    static void AlNumsArray(){
        Scanner numScan = new Scanner(System.in);
        
        String Response;
        int UserNumAdd;
        
        //Allow the user to add a number to the AlNums arraylist
        System.out.println("Would you like to add a number to the AlNums list? y/n");
        Response = numScan.nextLine().toLowerCase();
        while(Response.equals("y")){
            System.out.println("Enter the number you wish to add: ");
            UserNumAdd = Integer.parseInt(numScan.nextLine());
            AlNums.add(UserNumAdd);
            
            System.out.println("Would you like to add another number? y/n");
            Response = numScan.nextLine().toLowerCase();
        }
        
        //show the sum of the list
        System.out.println("--------------------");
        Sum_AlNums();

        
        //show the average of the list
        System.out.println("--------------------");
        int sum = 0;
        int average;
        for(int i = 0; i < AlNums.size(); i++) {
            sum += AlNums.get(i);                     
        } 
        average = sum / AlNums.size();
        System.out.println("Average of the list is:  " + average);
        
        //sort the arraylist
        System.out.println("--------------------");
        Collections.sort(AlNums);
        System.out.println("Your sorted list is: ");
        for(int counter : AlNums){
            System.out.print(counter);
        }
        System.out.println();
        //clear the arraylist
        System.out.println("--------------------");
        if(AlNums != null){
            AlNums.clear();
        }
        System.out.println("Your cleared arrayList: " + AlNums); 
        Menu();
    }
    
    static public int Sum_AlNums(){        
        //Add the numbers in the arraylist to give a sum and show the answer.        
        int sum = 0;        
        for(int num : AlNums) {
            sum = sum+num;            
        }        
        System.out.println("Sum of arraylist is: " + sum);
        return sum;
    }
    
////////////////////////////////////////////////////////////////////////////////
////////// Data Array //////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
        
    static void DataArray(){
        
        //Variables
        Scanner scanData = new Scanner(System.in);
        int UserViewData;
        String User_Data_Choice;
        int choice = 0;

        //You are given the following dataset:        
        int [][] SampleData = {{4,88,31,656,5,224},
                              {555,343,3,43,52,211},
                              {63,44,33,32,53,367},
                              {57,87,34,22,54,29},
                              {15,25,35,45,55,65},
                              {815,367,36,222,56,21}};

        //Allow the user to print out the data as a grid with columns 
        //Column Headings
//??How to give the rows labels like the columns
        System.out.println("Col 1" + "\t  " + "Col 2" + "\t  " 
                + "Col 3" + "\t  " + "Col 4" + "\t  " + "Col 5" 
                + "\t  " + "Col 6");
        //Print the sample data
        for(int c = 0; c < SampleData.length; c++){ 
            for (int r = 0; r < 6; r++){             
                System.out.print(SampleData[c][r] + "\t  ");
            }
            System.out.println();
        }    

        //Allow the user to pick a row or column to view. 
        while(choice < 1){
            System.out.println("Would you like to view a row (r) or column (c) "
                    + "or go to the main menu (m)?");
            User_Data_Choice = scanData.nextLine().toLowerCase();
            if(User_Data_Choice.equals("r")){
                System.out.println("Which row would you like to view? ");
                UserViewData = Integer.parseInt(scanData.nextLine());
                System.out.println("Row " + UserViewData + " contains the following data: ");
                for (int i = 0; i < 6; i++) {
                    System.out.println(SampleData[UserViewData-1][i] + " ");
                }
            }
            if(User_Data_Choice.equals("c")){
//??How to view a column?
                System.out.println("Which column would you like to view? ");
                UserViewData = Integer.parseInt(scanData.nextLine());
            }
            if(User_Data_Choice.equals("m")){
                Menu();
            }
            else{
                choice = 1;
            }
        }
        Menu();
    }
    
////////////////////////////////////////////////////////////////////////////////
//////// Program Menu //////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
    
    static void Menu(){
        //allow the user to go through the entire program as they wish. 
        int choice;
      
        Scanner myScan = new Scanner(System.in);
        System.out.println("Choose from one of the following options: ");
        System.out.println("\nMain Menu\n"     
                + "\n1. Go to the TvShow Array" 
                + "\n2. Go to the MySize Menu"
                + "\n3. Go to the AlNums Array"
                + "\n4. Data Array"
                + "\n5. Repeat Menu"
                + "\n6. End the program"
                + "\nMake a choice: ");
        choice = Integer.parseInt(myScan.nextLine());
        
        switch(choice){
            case 1 -> TvShowArray();
            case 2 -> MySizeMenu();
            case 3 -> AlNumsArray();
            case 4 -> DataArray();
            case 5 -> Menu();
            case 6 -> {
                System.out.println("Thank you for playing! Have a good day!");
                System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) {
        
    ////////////////////////////////////////////////////////////////////////////
    ///////// Larry Array //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
 
    //Create an arry called Larry that will hold the datatype double.
        System.out.println("1. Larry Array");
        double [] Larry;
        Larry = new double[4];
        Larry[0] = 1;
        Larry[1] = 2;
        Larry[2] = 3;
        Larry[3] = 4;
        for(int i = 0; i < Larry.length; i++){
            System.out.print(Larry[i] + ", ");
        }
        System.out.println("\n------------\n");        

    ////////////////////////////////////////////////////////////////////////////
    ///////// Curly Array //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////  

    //Create an array called Curly that will hold the datetype int.
        System.out.println("2. Curly Array");
        int Curly [] = {1,2,3,4};
        //Curly = new int[4];
        for (int i = 0; i < Curly.length; i++){
            System.out.println(i + " " + Curly[i]);
        }
        System.out.println("\n---------------\n");        

    ////////////////////////////////////////////////////////////////////////////
    ////////// Moe Array ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    

    //Create an array called Moe that will 
    //hold the datatype int and has the  following 
    //values - 80,40, 30,20, 10, 100, 60 
        System.out.println("3. Moe Array w/ data");
        int [] Moe = {80, 40, 30, 20, 10, 100, 60};
        for (int nums = 0; nums < Moe.length; nums++){
            System.out.print(Moe[nums] + ", ");
        }
        System.out.println("\n------------------\n");        
        //Using arry.sort command, sort Moe and display the results.
        System.out.println("\n4. Moe in order");
        int [] MoeOrder = {80, 40, 30, 20, 10, 100, 60};
        Arrays.sort(MoeOrder);
        for (int nums = 0; nums < MoeOrder.length; nums++){
            System.out.print(MoeOrder[nums] + ", ");
        }
        System.out.println("\n-----------------\n");         
    
    ////////////////////////////////////////////////////////////////////////////
    ////// Bugs Bunny Array ////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////// 
    
    //Create an array call BugsBunny that holds the following integers.
    //{10,20} {11,21} {15,25} {17,28}. (This is a grid) 
    //Display this information using two for statements.         
        System.out.println("5. BugsBunny Array\n");
        
        // declare the array
        // Grid 4 by 2
        double[][] BugsBunny; 
        
        // variables for the grid
        int Colcntr = 0;
        int ColStop = 2;
        int Rowcntr = 0;
        int RowStop = 4;
        
        BugsBunny = new double [4][2];        
        // 10 | 20  -- 00,01
        // 11 | 21  -- 10,11
        // 15 | 25  -- 20,21
        // 17 | 28  -- 30,31
        
        // enter the information
        BugsBunny [0][0] = 10;
        BugsBunny [0][1] = 20;
        BugsBunny [1][0] = 11;
        BugsBunny [1][1] = 21;
        BugsBunny [2][0] = 15;
        BugsBunny [2][1] = 25;
        BugsBunny [3][0] = 17;
        BugsBunny [3][1] = 28;
        
        System.out.println("While loop for BugsBunny array");
        // while loops to control the array
        while (Rowcntr < RowStop){
            while (Colcntr < ColStop) {
                System.out.print(BugsBunny[Rowcntr][Colcntr] + " ");
                Colcntr++;
            }
            Colcntr = 0;
            System.out.println();
            Rowcntr++;
        }
        System.out.println("\nFor loop for BugsBunny array");
        
        // for loop to contol the array 
        double myValue;
        
        for (int row = 0; row < 4; row++){
            for(int col = 0; col < 2; col++){
                myValue = BugsBunny[row][col];
                System.out.print(myValue + " ");
            }
            System.out.println();
        }        
        System.out.println("\n--------------------------\n");        
       
        System.out.println("Menu for remaining\n");

        // Call the main menu which will run you 
        // through the remaining questions
        Menu();    
    }
    
} // end of public class