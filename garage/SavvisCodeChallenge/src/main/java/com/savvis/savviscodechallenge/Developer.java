package com.savvis.savviscodechallenge;

/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 5/2/14
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Developer extends Employee {

    protected double cost = 1000;

    public Developer() {

    }

    public Developer(Employee e) {
        super(e);
    }

    protected void setCost(double cost) {
        System.out.println("Dev set Cost is called");
        this.cost = cost;
    }
    protected double getCost() {
        return this.cost;
    }

}
