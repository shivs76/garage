package com.savvis.savviscodechallenge;

/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 5/2/14
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Manager extends Employee {

    protected double cost = 300;

    public Manager(){

    }

    public Manager(Employee e) {
        super(e);
    }

   protected void setCost(double cost) {
        System.out.println("Mgr set Cost is called");
        this.cost = cost;
    }
    protected double getCost() {
        return this.cost;
    }
}
