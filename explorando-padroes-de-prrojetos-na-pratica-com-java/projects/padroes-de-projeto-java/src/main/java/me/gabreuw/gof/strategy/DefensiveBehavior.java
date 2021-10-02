package me.gabreuw.gof.strategy;

public class DefensiveBehavior implements Behavior {

    @Override
    public void move() {
        System.out.println("Movendo-se defensivamente...");
    }

}
