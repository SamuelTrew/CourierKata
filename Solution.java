import java.util.*;

public class Solution {

   public static void main(String[] args){
      int cost = 0;
      List<String> result = new ArrayList<>();

      for (int i = 0; i < args.length; i++) {
         int value =  get_parcel_value(Integer.parseInt(args[i])).getParcel();
         cost += value;

         result.add(args[i] + ": " + value + "\n");
      }

      System.out.println(result + "Total cost: " + cost);
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


