/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 12/17/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Identifier {
    private  String  name;
    private int age;
    public Identifier(){
        
    }
    
    public Identifier(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean equals(Object o) {
        return true;
    }
    
    public int hashCode(){
        return (age+"'").hashCode();
    }
    
    public String toString(){
        return "name:" + name + ", age:" + age;
    }
}
