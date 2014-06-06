package com.savvis.savviscodechallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 5/2/14
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Employee {
    
    protected double cost = 0;

    protected double totalCost = cost;

    protected List<Employee> directReports = new ArrayList<Employee>(5);

    public Employee() {
        setCost(this.cost);
    }

    public Employee(Employee e) {
        setCost(this.cost);
        directReports.add(e);
    }

    protected abstract  double getCost();

    protected abstract void setCost(double cost);



    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }

    protected void addDirectReports(Employee e) {
        this.directReports.add(e);
    }

    public double getTotalCost(){

        return  this.totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


    
    protected double getOverallCost() {
        totalCost = getCost();
        for (Employee e : directReports) {
            System.out.println(" e is "  +e);
            totalCost +=  e.getOverallCost();
        }
        return totalCost;
    }
    
    public String toString() {


        
        StringBuilder sb = new StringBuilder();
        sb.append("Type- " + this.getClass().getName()).append(" ");
        sb.append("self cost " + this.getCost()).append(" ");
        sb.append("Overall cost: ").append(totalCost).append("[").append("directReports=").append(directReports).append("]").toString();
        return  sb.toString();

    }
}
