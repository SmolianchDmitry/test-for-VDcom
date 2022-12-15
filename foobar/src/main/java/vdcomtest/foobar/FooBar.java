package vdcomtest.foobar;

public class FooBar {
    public static void main(String[] args) {

        int n = WorkWithDataEntry.getNumberGreaterZero();
        String[] result = ArrayFooBarBuilder.build1(n);
        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        result = ArrayFooBarBuilder.build2(n);
        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        result = ArrayFooBarBuilder.build3(n);
        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
