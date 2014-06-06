/**
 * Created by IntelliJ IDEA.
 * User: s.sankaranarayanan
 * Date: 11/22/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
public class TestGarage {

    public static void main(String[] args) throws Exception {
      /*  System.out.println("This is psvm");
        String emails = "ias-engineering@phaseforward.com,ias-pi@phaseforward.com";
        System.out.println(validateEmails(emails));
        String hashKey = "12345678| aava agent, critical";
        String subbed = hashKey.substring(0,hashKey.indexOf("|"));
        String secondPart = hashKey.substring(hashKey.indexOf("|")+1);
        secondPart = secondPart.replaceFirst(",", "");
        System.out.println(subbed);
        System.out.println(secondPart);*/
        //System.out.println(amybuildLastEventDate("2012-01-01 00:00:00"));
       // showTime();

       /* isP("2112");
        isP("DoNothing");*/
        boo_right();
        
    }

    public static void boo_right() {
        List<Integer> al = new ArrayList<Integer>(5);
        List<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < 10; i++) {
            al.add(i);
            stack.add(i);
        }

        for(int x : al) {
            System.out.println("x is " + x);
        }


    }

    public static void boo_wrong() {
        ArrayList<Integer> al = new ArrayList<Integer>(5);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < 10; i++) {
            al.add(i);
            stack.add(i);
        }

        //al = al.subList(0,3);
        al.addAll(stack);
        System.out.println("The stack is " + stack);


    }

    /*public static boolean isP(String str) {
        boolean isP = false;
        int loops = 0;
        if(str != null) {
            str = str.toLowerCase();

            for (int i = 0; (i < (str.length() + 1)/2); i++) {

                loops ++;
                if(str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                    isP =   true;
                } else {
                    break;
                }
            }
        }
        System.out.println("is " + str + " a palindrome? : " + isP + " looped : " + loops);
        return isP;

    }*/
    
    public static void doNothing() {


        String str1 = "abc";
        String str2 = changeMe(str1);
        System.out.println("is it the same " + (str1 == str2));


        /*HashSet<String> h = new HashSet<String>(10);
        String str = "RAAAHESH" ;
        for(int i = 0; i < str.length(); i++) {
            h.add(str.charAt(i)+"");
        }
        System.out.println("String size " + str.length());
        System.out.println("H size " + h.size());

        Map<Character, Integer> map = new HashMap<Character, Integer>(10);
        for(int i = 0; i < str.length(); i++) {
            Character aChar = str.charAt(i);
            if(!map.containsKey(aChar)) {
                map.put(aChar, 1 );
            } else {
                int count = map.get(aChar);
                map.put(aChar, count + 1);
            }
        }
        System.out.println("The map value " + map);*/
        
    }

    public static void doNothing1() {
        /*String str1 = new String("abc");
        String str2 = changeMe(str1);
        System.out.println("is it the same " + (str1 == str2));
        HashSet<String> h = new HashSet<String>(10);
        String str = "RAAAHESHHH" ;
        for(int i = 0; i < str.length(); i++) {
            h.add(str.charAt(i)+"");
        }
        System.out.println("String size " + str.length());
        System.out.println("H size " + h.size());

        Map<Character, Integer> map = new HashMap<Character, Integer>(10);
        for(int i = 0; i < str.length(); i++) {
            Character aChar = str.charAt(i);
            //System.out.println("aChar " + aChar);
            int count = map.get(aChar);
            map.put(aChar,count++);
        }
        System.out.println("The map value " + map);*/

        try {
            int i = 0;
            int jj = 10;
            int oo = jj/i;
        } catch (Exception jE) {
            throw new ArithmeticException("Some foolish exception");
        }
        finally {
            System.out.println("ahahahah!!!");
            //return;
        }

    }
    
    public static String changeMe(String str) {
        str = "abc";
        return str;
    }
            

    private static void writeToFile(String stringToWrite) {
        File file = new File("C:\\softwares\\event_notifier_errors.csv");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(stringToWrite);
        } catch (IOException jIOE) {
            jIOE.printStackTrace();
        } finally {
            if(bw != null) {
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException j) {
                    j.printStackTrace();
                }
            }
        }
    }


    private static String amybuildLastEventDate(String startTime) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse(startTime);
        
        Calendar cal = new GregorianCalendar();
        cal.setTime(startDate);
        cal.add(Calendar.SECOND, -180);
        return sdf.format(cal.getTime());
    }

    private  String mybuildLastEventDate(String startTime) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse(startTime);

        Calendar cal = new GregorianCalendar();
        cal.setTime(startDate);
        cal.add(Calendar.SECOND, -180);
        return sdf.format(cal.getTime());
    }

    /**
     * Validates a comma separate string of emails
     *
     * @return true if all email addresses are valid, false if any are invalid
     */
    public static boolean validateEmails(String emails)
    {
        if(emails == null)
            return false;

        Pattern p = Pattern.compile("[,]+");
        String[] recipients = null;
        boolean isValid = true;

        //Extract Email Addresses
        recipients = p.split(emails);

        //remove spaces and validate each address
        for (int y = 0; y< recipients.length; y++)
        {
            String tempStr = recipients[y];
            recipients[y] = tempStr.replaceAll(" ","").trim();

            try {
                new InternetAddress(recipients[y]);

                String[] tokens = recipients[y].split("@");
                isValid = tokens.length == 2 &&
                        !"".equals( tokens[0] ) &&
                        !"".equals( tokens[1] );
            }
            catch (AddressException ex)
            {
                //if one address is invalid, return false
                return false;
            }

            //if one false, then return false and do NOT proceed through loop
            if(!isValid)
                return false;
        }

        //return final value which should be true
        return isValid;

    }
    
    
    private static void showTime() {
        long  ltime = 1386319817455L;
        System.out.println(new Date(ltime));
    }


}
