
public class ordinalTest{
   public static String getOrdinalNumber(int num){
     int n=0;
     if(num<=20){
       if(num == 1) return num+"st";
       if(num == 2) return num+"nd";
       if(num == 3) return num+"rd";
       if(num >=4 || num ==0) return num+"th";
     }
     if(num>20){
       n = num%10;
     }
     return (num/10)+getOrdinalNumber(n);

  }

  public static void main(String[] args){
    System.out.println(getOrdinalNumber(1));
    System.out.println(getOrdinalNumber(2));
    System.out.println(getOrdinalNumber(3));
    System.out.println(getOrdinalNumber(4));
    System.out.println(getOrdinalNumber(10));
    System.out.println(getOrdinalNumber(11));
    System.out.println(getOrdinalNumber(22));
    System.out.println(getOrdinalNumber(23));
    System.out.println(getOrdinalNumber(41));
    System.out.println(getOrdinalNumber(50));
    System.out.println(getOrdinalNumber(121));
  }
}
