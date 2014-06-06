package com.savvis.savviscodechallenge;
import junit.framework.TestCase;
import org.junit.Test;

public class TestMe extends TestCase {
    
    @Test
    public void testCost() {
        Employee m = new Manager(new Developer());

        Employee e = new Developer();
        e.addDirectReports(new Developer());
        e.addDirectReports(new Developer());
        
        m.addDirectReports(e);
        Employee superManager = new Manager(m);
        System.out.println("Super manager cost is " + superManager.getOverallCost());


        System.out.println("E is " + m.getOverallCost());

       /* m.addDirectReports(new Developer());
        m.addDirectReports(new QATester());
        double d = m.getOverAllCost();
        System.out.println("The total is " + d);

        System.out.println(" m is " + m);*/
    }

   /*// @Test
    public void testCos2t() {
       // Manager m = new Manager(new Developer());
        Employee e = new Developer();
        System.out.println("e.get cost " + e.getCost());
    }*/
}
