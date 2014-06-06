/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 5/12/14
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Parent {

    public static void doSomething() {
        System.out.println("Parent:: doSomething()");
    }

    public static void main(String[] args) {
        Parent p = new Child();
        //p.doSomething();
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc").intern() ;
        System.out.println("Doing == with literals " + (str1 == str2));

        System.out.println("Doing == with no literals " + (str1 == str3));
        
    }
}

class Child extends Parent {
    public static void doSomething() {
        System.out.println("Children:: doSomething()");

    }
}
