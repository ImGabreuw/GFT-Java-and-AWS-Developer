package me.gabreuw.gof.singleton;

public class LazyHolderSingleton {

    private static class InstanceHolder {
        public static LazyHolderSingleton instance = new LazyHolderSingleton();
    }

    private LazyHolderSingleton() {}

    public static LazyHolderSingleton getInstance() {
        return InstanceHolder.instance;
    }

}
