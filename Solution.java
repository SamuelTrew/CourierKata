import java.util.*;

public class Solution {

   private static List<Integer> small = new ArrayList<>();
   private static List<Integer> medium = new ArrayList<>();
   private static List<Integer> mixed = new ArrayList<>();
   private static int discount = 0;

   public static void main(String[] args){
      int cost = 0;
      List<String> result = new ArrayList<>();
      boolean speedy = Boolean.parseBoolean(args[0]);

      for (int i = 1; i < args.length; i+=2) {
         int dimension = 0;
         Parcel parcel = Parcel.DEFAULT;
         if (args[i] == "heavy") {
            parcel = Parcel.HEAVY;
         } else {
            dimension = Integer.parseInt(args[i]);
            parcel = get_parcel_value(dimension);
         }
         int value =  parcel.getParcel();

         int weight = Integer.parseInt(args[i+1]);
         int weight_value = get_weight_value(weight, parcel);
         if (weight_value < 0) {
            weight_value = 0;
         }

         value += weight_value;
         cost += value;

         result.add(args[i] + ": " + value + "\n");
      }
      if (speedy) {
         result.add("Speedy: " + cost + "\n");
      }

      Collections.sort(small);
      Collections.sort(medium);
      Collections.sort(mixed);

      calc_discount();

      result.add("Discount: -" + discount + "\n");
      System.out.println(result + "Total cost: " + (2*cost));
   }

   private static void calc_discount() {
      for (int i = 0; i < small.size(); i++) {
         if (i % 4 == 0) {
            discount += small.get(i);
         }
      }
      for (int i = 0; i < medium.size(); i++) {
         if (i % 3 == 0) {
            discount += medium.get(i);
         }
      }
      for (int i = 0; i < mixed.size(); i++) {
         if (i % 5 == 0 && mixed.get(i) >= 50) {
            discount += mixed.get(i);
         }
      }
   }

   private static int get_weight_value(int weight, Parcel parcel) {
      switch(parcel) {
         case SMALL:
            return (weight - 1) * 2;
         case MEDIUM:
            return (weight - 3) * 2;
         case LARGE:
            return (weight - 6) * 2;
         case XL:
            return (weight - 10) * 2;
         case HEAVY:
            return (weight - 50);
      }
      return 0;
   }

   private static Parcel get_parcel_value(int parcel) {
      mixed.add(parcel);
      if (parcel < 10) {
         small.add(parcel);
         return Parcel.SMALL;
      }
      if (parcel < 50) {
         medium.add(parcel);
         return Parcel.MEDIUM;
      }
      if (parcel < 100) {
         return Parcel.LARGE;
      }
      return Parcel.XL;
   }
}

enum Parcel {
   DEFAULT(0),
   SMALL(3),
   MEDIUM(8),
   LARGE(15),
   XL(25),
   HEAVY(50);

   private final int parcelCode;

   Parcel(int parcelCode) {
      this.parcelCode = parcelCode;
   }

   public int getParcel() {
      return parcelCode;
   }
}


