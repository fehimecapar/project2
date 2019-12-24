
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Doktor {
    
    
    public ArrayList<String> doktor_adı=new ArrayList<String>() ;//doktorun adını soyadını ve tıbbi birimini tutan linkedlist.
    public ArrayList<String> doktor_soyadı=new ArrayList<String>() ;
    public ArrayList<String> doktor_unvanı=new ArrayList<String>() ;
    public static ArrayList<String> tarih=new ArrayList<String>();
    public Doktor()
    {    }

    public Doktor(ArrayList<String> doktor,ArrayList<String> doktor_soyadı,ArrayList<String> doktor_unvanı,ArrayList<String> birimler,ArrayList<String> tarih) {//overrideeee.....
        this.doktor_adı = doktor_adı;
        this.doktor_soyadı=doktor_soyadı;
        this.doktor_unvanı=doktor_unvanı;
        this.tarih=tarih;
    }

    public void doktorlar(){
        doktor_adı.add("HALİL");
         doktor_soyadı.add("BOYUNSUZ");
         doktor_unvanı.add("NÖROLOJİ");
         doktor_adı.add("MEHMET");
         doktor_soyadı.add("GÜR");
         doktor_unvanı.add("GÖĞÜS HASTALIKLARI");
         doktor_adı.add("CANAN");
         doktor_soyadı.add("KARATAY");
         doktor_unvanı.add("KBB");
         doktor_adı.add("EMİN");
         doktor_soyadı.add("YILMAZ");
         doktor_unvanı.add("ÇOCUK CERRAHİ");
         doktor_adı.add("NESRİN");
         doktor_soyadı.add("GÜMÜŞ");
         doktor_unvanı.add("ÇOCUK ALLERJİSİ");
         doktor_adı.add("İSMAİL");
         doktor_soyadı.add("SAPMAZ");
         doktor_unvanı.add("DERMATOLOJİ");
         doktor_adı.add("SEVDA");
         doktor_soyadı.add("BİLEN");
         doktor_unvanı.add("KARDİYOLOJİ");
        
    }
    public void doktorlar(String ad,String soyad,String unvan)
     { 
         
         doktor_adı.add(ad);
         doktor_soyadı.add(soyad);
         doktor_unvanı.add(unvan);
         
         FileWriter writer=null;
      try {
            writer=new FileWriter("dosya2.txt");//filewriterla bir stringi direkt olduğu gibi yazabiliriz...
           /* writer.write("fehime çapar\n");
            writer.write("mehmet genç\n");
            writer.write("bahar çapar\n");*/
            for(int i =0; i<doktor_adı.size();i++)
            { writer.write(doktor_adı.get(i)+" "+doktor_soyadı.get(i)+" "+doktor_unvanı.get(i)+"\n"); //girilen arrayList elemanlarının alt alta yazılmasını sağlar.
               }
        } catch (IOException ex) {
            System.out.println("IOException oluştu...");
        }
        finally{
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.out.println("dosya kapatılırken bir hata oluştu");
                }
            }
        } }
    
    public void doktor_goruntule() {
        
      System.out.println("# hastanemizin doktor kadrosu #");
      Tablo1 tb1=new Tablo1();
      tb1.goster();
      FileInputStream fis=null;
        
        try {
            fis=new FileInputStream("dosya2.txt");
            
            int deger;
            String s="";
            int say=0;
            fis.skip(0);//dosyanın başlangıç karakterini 0 yerine 5 yaptım...
            while((deger=fis.read()) != -1){
                s += (char) deger;
          
            }
            System.out.println("dosya içeriği "+s);
       } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundExcption oluştu...");
        } catch (IOException ex) {
            System.out.println("dosya okunurken bir hata oluştu...");
        }
        finally{
            try {
                if(fis != null)
                { fis.close();}
                
            } catch (IOException ex) {
                System.out.println("dosya kapatılırken bir hata oluştu...");
            }
        }
      
      
      
    }
    
     public void randevu_al(int index)
     {
         //doktorlar();
        for(int i=0;i<(doktor_adı.size());i++)
        {
            if(i==(index-1))
            { System.out.println(doktor_adı.get(i)+" "+doktor_soyadı.get(i)+" adlı doktor için randevunuz oluşturulmuştur"); }
        }
     }

   public void randevu_al(String date)
   {
      tarih.add(date);
     
    }
    
}
