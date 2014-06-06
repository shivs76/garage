import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 12/17/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdentifierTest {

    public static void main(String[] args) {
        /*Set<Identifier> set = new HashSet<Identifier>(10);
        Identifier i1 = new Identifier("Joe", 23);
        Identifier  i2 = new Identifier("Ben", 23);
        set.add(i1);
        set.add(i2);
        System.out.println("The identifier Set is " + set);*/
        computePercentile();

    }

    protected static  void computePercentile() {
        int numPoints = 204;//data.size();
        double rawRank = ( 1- 95/100.0d) * numPoints;
        System.out.println("Raw is " + rawRank);
        double rank = (Math.floor(rawRank * 100000.0d))/100000.0d;	//  Avoids rounding issue
        System.out.println("Rank is " + rank);
        int upperPointIndex = (int)Math.ceil(rank) - 1;
        System.out.println("Upper is " + upperPointIndex);

    }


}
