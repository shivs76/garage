import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
public class GMailReader {
    public static void main(String args[]) {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imap");
        System.out.println("props set!");
        try {
            Session session = Session.getDefaultInstance(props, null);
            System.out.println("About to get store!");
            Store store = session.getStore("imap");
            System.out.println("Got Store? !" + store);

            store.connect("imap.gmail.com", "shivs_76", "Shiv200699");
            System.out.println(store);

            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
            //Message messages[] = inbox.getMessages();
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);

            int i =0;
            for(Message message:messages)
            {

                Multipart mp = (Multipart)messages[i].getContent();
                Object p = mp.getBodyPart(i).getContent();
                String q = p.toString();//object has the body content
                System.out.println(q);//prints the body
                System.out.println( messages[i].getSubject()+ " \n"+i);i++;
            }


        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.exit(2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
