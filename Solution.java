import java.util.*;

public class Solution {

   public static void main(String[] args){
      int cost = 0;
      List<String> result = new ArrayList<>();
      boolean speedy = Boolean.parseBoolean(args[0]);

      for (int i = 1; i < args.length; i++) {
         int dimension = Integer.parseInt(args[i]);
         Parcel parcel = get_parcel_value(dimension);
         int value =  parcel.getParcel();

         int weight = Integer.parseInt(args[i+1]);
         int weight_value = get_weight_value(weight, parcel);
         value += weight_value;
         cost += value;

         result.add(args[i] + ": " + value + "\n");
      }
      if (speedy) {
         result.add("Speedy: " + cost + "\n");
      }

      System.out.println(result + "Total cost: " + (2*cost));
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
      }
      return 0;
   }

   private static Parcel get_parcel_value(int parcel) {
      if (parcel < 10) {
         return Parcel.SMALL;
      }
      if (parcel < 50) {
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
   XL(25);

   private final int parcelCode;

   Parcel(int parcelCode) {
      this.parcelCode = parcelCode;
   }

   public int getParcel() {
      return parcelCode;
   }
}


