import java.util.Scanner;

class Sundae{
   private int scoops;
   private String flavour;
   private boolean nuts;
   private double cost;
   private static int sundaeCount = 0;
  
   public Sundae() {
       scoops = 0;
       flavour = "";
       cost = 0;
       nuts = false;
       sundaeCount++;
   }
  
   public Sundae(int s, String f, String nut) {
       scoops = s;
       flavour = f;
       if(nut=="y")
           nuts = true;
       else
           nuts = false;
       calcCost();
       sundaeCount++;
   }
  
   public Sundae(Sundae s) {
       this.flavour = s.getFlavour();
       this.scoops = s.getScoops();
       this.nuts = s.getNuts();
       calcCost();
       sundaeCount++;
   }
   public int getScoops() {
       return scoops;
   }
   public String getFlavour() {
       return flavour;
   }
   public boolean getNuts() {
       return nuts;
   }
   public double getCost() {
       return cost;
   }
   public int getSundaeCount() {
       return sundaeCount;
   }
   public void updateScoops(int s) {
       scoops = s;
       updateCost();
   }
   public void updateFlavour(String f) {
       flavour = f;
   }
   public void updateNuts(String n) {
       if(n=="y")
           nuts = true;
       else
           nuts = false;
       updateCost();
   }
   public void updateCost() {
       calcCost();
   }
   private void calcCost() {
       cost = scoops*23;
       if(nuts)
           cost= cost + 7;
   }
   public String toString() {
       String message = "\nSundae with "+Integer.toString(scoops)+" scoops of "+flavour;
       if(nuts)
           message += " with nuts";
       message += " for a cost of: ₹"+Double.toString(cost);
       //System.out.println(message);
       return message;
   }
   public boolean equals(Sundae s) {
       if(this.scoops==s.getScoops() && this.flavour==s.getFlavour() && this.nuts == s.getNuts())
           return true;
       else
           return false;
   }
  
}

