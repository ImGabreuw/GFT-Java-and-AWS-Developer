package me.gabreuw.gof.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        Behavior normal = new NormalBehavior();
        Behavior defensive = new DefensiveBehavior();
        Behavior aggressive = new AggressiveBehavior();

        Robot robot = new Robot();

        robot.setBehavior(normal);
        robot.move();

        robot.setBehavior(defensive);
        robot.move();

        robot.setBehavior(aggressive);
        robot.move();
    }

}
