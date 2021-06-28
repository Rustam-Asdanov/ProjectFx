package sample;

public class Example {
    public static void main(String[] args){
        System.out.println(getResult(3));
    }

    /**
     *    !5 = 5*4*3*2*1
     *    !6 = 6*5*4*3*2*1
     *    !1 = 1
     *    !0 = 1
     *    !2 = 2*1
     *    !3 = 3*2*1
     */

    public static int getResult(int num){
        if(num==1 || num==0) return 1;
//        return num * 1;
        return num * getResult(num-1);
    }

    public static int getResult1(int num){
        if(num==1 || num==0) return 1;
        return num * getResult2(num-1);
    }

    public static int getResult2(int num){
         return 1;
    }
}
