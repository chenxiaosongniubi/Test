package com.example.a.exception;

/**
 * Created by a on 2017/3/30.
 */

public class Test {
    //try  catch finally

    /**
     * 1.try catch finally 均不能单独使用
     * 2.try catch | try catch finally | try finally
     * 3.作用域的问题，匹配catch的顺序是依次的
     *
     * @param args
     */
    public static void main(String[] args) {
        int temp = 100;
        try {

//            int[] a = {1, 2, 3};
//            int x = a[3];
//            String s=null;
//            s.length();

//            int c=10,d=0;
//            int e=c/d;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
            e.printStackTrace();
            temp=200;

        }catch (NullPointerException e){
            System.out.println("空指针异常");
        }catch (ArithmeticException e){
            System.out.println("算数异常");
        }
        finally {
            System.out.println("都要执行");
        }

        System.out.println("end");
    }
}
