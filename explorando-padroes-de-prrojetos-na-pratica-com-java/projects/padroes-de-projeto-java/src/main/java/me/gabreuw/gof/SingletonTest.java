package me.gabreuw.gof;

public class SingletonTest {

    public static void main(String[] args) {
        testLazySingleton();
        testEagerSingleton();
        testLazyHolderSingleton();
    }

    private static void testLazySingleton() {
        LazySingleton lazy = LazySingleton.getInstance();
        System.out.println(lazy);

        lazy = LazySingleton.getInstance();
        System.out.println(lazy);
    }

    private static void testEagerSingleton() {
        EagerSingleton eager = EagerSingleton.getInstance();
        System.out.println(eager);

        eager = EagerSingleton.getInstance();
        System.out.println(eager);
    }

    private static void testLazyHolderSingleton() {
        LazyHolderSingleton lazyHolder = LazyHolderSingleton.getInstance();
        System.out.println(lazyHolder);

        lazyHolder = LazyHolderSingleton.getInstance();
        System.out.println(lazyHolder);
    }

}
