
import java.util.ArrayList;
import java.util.Scanner;


public class Recete {
    ArrayList<String> recete = new ArrayList<String>();
    

    public Recete() {
    }

    public Recete(ArrayList<String>recete) {
        this.recete=recete;
    }
 public void recete_yaz(String hasta_adı,String hasta_soyadı,String recet )      
    {
        recete.add(recet);
        System.out.println(hasta_adı+" "+hasta_soyadı+" için yazılan reçete ----> "+recet);

    }
}
