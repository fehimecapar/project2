
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Hastalar {
    
    public static ArrayList<String> hasta_adı = new ArrayList<String>();
    public static ArrayList<String> soyadı=new ArrayList<String>();
  
    public static ArrayList<Integer> yas=new ArrayList<Integer>();
    
    public static ArrayList<String> tarih=new ArrayList<String>();
    
    
   
   public Hastalar()
   { }

    public Hastalar(ArrayList<String> hasta, ArrayList<Integer> yas,ArrayList<String> soyadı, ArrayList<String> tarih) {
        this.hasta_adı = hasta;
        this.yas = yas;
        this.soyadı=soyadı;
        this.tarih=tarih;
    }
     
  public static void hasta_kaydı_al(String hastaa_adı,String soyad, int yas_bilgisi)
  {
      
      hasta_adı.add(hastaa_adı);
      soyadı.add(soyad);
      yas.add(yas_bilgisi);
      FileWriter writer=null;
      try {
            writer=new FileWriter("dosya1.txt");
           
            for(int i =0; i<hasta_adı.size();i++)
            { writer.write(hasta_adı.get(i)+" "+soyadı.get(i)+" "+yas.get(i)+"\n"); //girilen arrayList elemanlarının alt alta yazılmasını sağlar.
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
        }
      
      
     
 } 
  
 
  

  public void hasta_kaydı()
          
  {
      System.out.println("# HASTANEMİZİN HASTA KAYDI #");
            Tablo2 tb2=new Tablo2();
            tb2.goster();
            FileInputStream fis=null;
        
        try {
            fis=new FileInputStream("dosya1.txt");
            
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
  
      public void randevu_olustur(String date)
    {
        tarih.add(date);
        //System.out.println(tarih.size());
    }
    
      public void hasta_yas_ortalaması()
      {
          int toplam=0;
          for(int i=0;i<yas.size();i++)
          {
              toplam+=yas.get(i);
          }
          System.out.println("hastanedeki hastaların yaş ortalaması= "+toplam/yas.size());
      }
    
}
