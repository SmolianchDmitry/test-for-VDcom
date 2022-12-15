package vdcomtest.foobar;

public class ArrayFooBarBuilder {

    public static String[] build1(int n){
        String[] result = new String[n];
        for (int i = 1; i <= n; i++){
            if(((i % 3) == 0) && ((i % 5) == 0))
                result[i - 1] = "FooBar";
            if(((i % 3) == 0) && ((i % 5) != 0))
                result[i - 1] = "Foo";
            if(((i % 3) != 0) && ((i % 5) == 0))
                result[i - 1] = "Bar";
            if(((i % 3) != 0) && ((i % 5) != 0))
                result[i - 1] = String.valueOf(i);
        }
        return result;
    }

    public static String[] build2(int n){
        String[] result = new String[n];
        int foo = 1;
        int bar = 1;
        for (int i = 1; i <= n; i++){
            if((foo != 3) && (bar != 5)) {
                result[i - 1] = String.valueOf(i);
            }
            if((foo == 3) && (bar == 5)) {

                result[i - 1] = "FooBar";
                foo = 0;
                bar = 0;
            }
            if((foo == 3) && (bar != 5)) {
                result[i - 1] = "Foo";
                foo = 0;
            }
            if((foo != 3) && (bar == 5)) {
                result[i - 1] = "Bar";
                bar = 0;
            }

            foo++;
            bar++;
        }
        return result;
    }

    public static String[] build3(int n){
        String[] result = new String[n];
        for (int i = 1; i <= n; i++){
                result[i - 1] = String.valueOf(i);
        }
        for (int i = 5; i <= n; i += 5){
            result[i - 1] = "Bar";
        }
        for (int i = 3; i <= n; i += 3){
            result[i - 1] = "Foo";
        }
        for(int i = 15; i <= n; i += 15){
            result[i - 1] = "FooBar";
        }
        return result;
    }
}
