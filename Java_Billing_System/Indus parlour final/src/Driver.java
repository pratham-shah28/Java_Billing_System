import java.util.Scanner;
public class Driver {

   public static void main(String[] args) {
       int totalCount, choice, sundae_num = 0, change;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Welcome to Indus Sundae Parlour\nHow many sundaes could you make today? ");
       totalCount = scanner.nextInt();
       scanner.nextLine();
       Sundae[] sundaes = new Sundae[totalCount];
       int sundaeCounter = 0;
       do {
           System.out.println("What do you want to do?\n\t1. Enter a new sundae order\n\t2. Change information of a specific order");
           System.out.println("\t3. Display details of all sundaes of a specific ice cream flavour\n\t4. Statistics on today's sundaes\n\t5. Quit");
           System.out.println("Please enter your choice > ");
           choice = scanner.nextInt();
           scanner.nextLine();
           int scoop;
           String flavor, nut;
           switch (choice) {
           case 1: {
               if(sundaeCounter<totalCount) {
                   System.out.println("How many scoops of ice cream? ");
                   scoop = scanner.nextInt();
                   scanner.nextLine();
                   System.out.println("What flavour? ");
                   flavor = scanner.nextLine();
                   System.out.println("Any nuts? (y for yes anything else for no) ");
                   nut = scanner.nextLine();
                   sundaes[sundaeCounter++] = new Sundae(scoop, flavor, nut);
               }
               else {
                   System.out.println("Sorry we don't have enough ingredeints to make another sundae");
               }
               break;
           }
           case 2: {
               do {
                   System.out.println("Please enter your choice > \n\t Valid sundae numbers are 0 to "+(sundaeCounter-1));
                   sundae_num = scanner.nextInt();
                   if(sundae_num>=0 && sundae_num<=sundaeCounter) {
                       System.out.println("Sundae # "+sundae_num);
                       System.out.println(sundaes[sundae_num].toString());
                       System.out.println("What would you like to change?");
                       System.out.println("1. Ice cream flavour\n2. Number of scoops\n3. Nuts or no nuts\n4. Quit");
                       change = scanner.nextInt();
                       scanner.nextLine();
                       switch (change) {
                       case 1: {
                           System.out.println("New Flavour: ");
                           flavor = scanner.nextLine();
                           sundaes[sundae_num].updateFlavour(flavor);
                           System.out.println("Here is what the sundae looks like now");
                           System.out.println(sundaes[sundae_num].toString());
                           sundae_num = -1;
                           break;
                       }
                       case 2:{
                           System.out.println("How many scoops: ");
                           scoop = scanner.nextInt();
                           scanner.nextLine();
                           sundaes[sundae_num].updateScoops(scoop);
                           System.out.println("Here is what the sundae looks like now");
                           System.out.println(sundaes[sundae_num].toString());
                           sundae_num = -1;
                           break;
                       }
                       case 3:{
                           if(sundaes[sundae_num].getNuts()) {
                               sundaes[sundae_num].updateNuts("n");
                               System.out.println("Nuts removed from sundae");
                           }
                           else {
                               sundaes[sundae_num].updateNuts("y");
                               System.out.println("Nuts added to sundae");
                           }
                           System.out.println("Here is what the sundae looks like now");
                           System.out.println(sundaes[sundae_num].toString());
                           sundae_num = -1;
                           break;
                       }
                       case 4:{
                           sundae_num = -1;
                           break;
                       }
                       default:
                           System.out.println("Sorry, you have entered invalid choice");
                       }
                   }
                   else {
                       System.out.println("Sorry, no such sundae\nDo you want to enter another sundae number of return to the main menu (quit to return)");
                       if(scanner.nextLine()=="quit")
                           sundae_num = -1;                      
                   }
                  
               } while (sundae_num!=-1);
               break;
           }
           case 3: {
               System.out.println("What flavour do you want a list of?\n");
               flavor = scanner.nextLine();
               for(int i=0;i<sundaeCounter;i++) {
                   if(sundaes[i].getFlavour().contentEquals(new StringBuffer(flavor))) {
                       System.out.println("Sundae # "+Integer.toString(i));
                       System.out.println(sundaes[i].toString());
                   }
               }
               break;
           }
           case 4: {
               System.out.println("What information would you like?");
               System.out.println("\t1. List all sundaes sold today");
               System.out.println("\t2. Details of cheapest sundae");
               System.out.println("\t3. Number of sundaes sold today");
               System.out.println("\t4. Number of sundaes with specific # of scoops");
               System.out.println("\t5. Average cost of sundaes");
               System.out.println("\t6. Quit");
               int c = scanner.nextInt();
               scanner.nextLine();
               switch (c) {
               case 1: {
                   for(int i=0;i<sundaeCounter;i++) {
                       System.out.println(sundaes[i].toString());
                   }
                   break;
               }
               case 2: {
                   int cheapest_index = 0;
                   double min = sundaes[0].getCost();
                   for(int k=1;k<sundaeCounter;k++) {
                       if(sundaes[k].getCost()<min) {
                           min = sundaes[k].getCost();
                           cheapest_index = k;
                       }
                   }
                   System.out.println(sundaes[cheapest_index].toString());
                   break;
               }
               case 3: {
                   System.out.println((sundaeCounter-1) + " sundaes sold today");
                   break;
               }
               case 4: {
                   System.out.println("How many scoops? ");
                   scoop = scanner.nextInt();
                   scanner.nextLine();
                   for(int k=1;k<sundaeCounter;k++) {
                       if(sundaes[k].getScoops()==scoop) {
                           System.out.println("Sunday # "+k);
                           System.out.println(sundaes[k].toString());
                       }
                   }
                   break;
               }
               case 5: {
                   double sum = 0;
                   for(int k=0;k<sundaeCounter;k++) {
                           sum += sundaes[k].getCost();
                       }
                   System.out.println("Average price of "+sundaeCounter+" sundaes is ₹"+Double.toString(sum/(sundaeCounter-1)));
                   break;
               }
               case 6: {
                  
                   break;
               }
               default:
                   System.out.println("Sorry, you have entered invalid choice");
               }
              
               break;
           }
           case 5: {
              
               break;
           }
           default:
               System.out.println("Please enter valid choice");
           }
          
       } while (choice!=5);
   }

}