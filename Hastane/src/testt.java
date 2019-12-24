
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

 class Lab{
      public ArrayList<String> lab_tarihi=new ArrayList<String>();
    public String[] birim = new String[2];

    public Lab() {
    }
    public Lab(ArrayList<String> lab_tarihi,String[] birim) {
        
        this.lab_tarihi=lab_tarihi;
        this.birim=birim;
        
    }
    public void lab_bilg(){
        birim[0]="check-up";
        birim[1]="tahlil ünitesi";
        System.out.println("# hastanemizde hizmet veren laboratuvar birimlerimiz #");
        for(int i=0;i<birim.length;i++)
        {
            System.out.println(birim[i]);
        }
    }
    
    public void lab_randevu_al()
    {
       Scanner s=new Scanner(System.in);
       s.nextLine();
       System.out.println("lütfen randevu tarihi giriniz");
       String date=s.nextLine();
       lab_tarihi.add(date);
        System.out.println("randevunuz oluşturuluyor........\n"
                + date+"\n"+
                "lütfen randevunuza vaktinde gelmeye çalışınız....");
 }
}
public class testt {
    public static void main(String[] args) {
        TıbbiBirim t= new TıbbiBirim();
        Doktor d =new Doktor(); 
        RandevuD rd=new RandevuD();
        Hastalar h = new Hastalar();
        RandevuH rh= new RandevuH();
        Recete r= new Recete();
        Lab lb=new Lab();
        Tablo1 tb1 = new Tablo1();
        Tablo2 tb2 = new Tablo2();
        Tablo3 tb3 = new Tablo3();
        System.out.println("hastanemizde görev yapan doktorlar ve birimleri");
        tb1.goster();
        
        Scanner s=new Scanner(System.in);
        String hastane_islemleri="a-HASTA İŞLEMLERİ\n"
                               + "b-DOKTOR İŞLEMLERİ";
        System.out.println(hastane_islemleri);
        System.out.print("lütfen hasta ya da doktor işlemi seçiniz : ");
        String secim2=s.nextLine();
        while(true){
        if(secim2.equals("a")){
            String hasta_islemleri="1-RANDEVU ALMA İŞLEMLERİ\n"
                             + "2-HASTA BİLGİSİ GÖRÜNTÜLEME\n"
                             + "3-HASTA KAYDI SİLME\n"
                             + "0-ÇIKIŞ İŞLEMİ";
            
        
         while(true){
             System.out.println(hasta_islemleri);
            System.out.print("lütfen yapmak istediğiniz işlem değerini giriniz : ");
            int secim=s.nextInt();
            if(secim==0){
                System.out.println("işlemden çıkış yapılıyor...");
                break;
            }
            else if(secim==1){
                  System.out.print("lütfen hastanın yaşını giriniz : ");
                  int yas=s.nextInt();
                  s.nextLine();
                  System.out.print("lütfen hastanın adını giriniz : ");
                  String ad=s.nextLine();
                  System.out.print("lütfen hastanın soyadını giriniz : ");
                  String soyad=s.nextLine();
                  System.out.print("lütfen randevu almak istediğiniz birimi giriniz:");
                  String birim=s.nextLine();
                  System.out.print("lütfen randevu almak istediğiniz doktorun adını ve soyadını giriniz:");
                  String doktor_ad=s.nextLine();
                  System.out.print("lütfen hangi tarihte randevu almak istediğinizi giriniz");
                  String date=s.nextLine();
        
                  
                  h.hasta_kaydı_al(ad,soyad,yas);
                  rh.randevu_olustur(date);
                  rh.randevu_al(date);
                  d.randevu_al(date);
                  rd.randevu_al(date);
                  
                  tb2.ekle(ad, soyad, yas);
                  tb3.ekle(ad, soyad, birim, doktor_ad,date);
                  
            }
            else if(secim==2){
                System.out.println("#hastanemizde hizmet gören hastaların listesi#");
                tb2.goster();
                tb3.secili_hasta_goruntule();
                
                
                System.out.println("#hastanemizde hizmet gören hastaların randevu bilgileri#");
                tb3.goster();
                s.nextLine();
                h.hasta_kaydı();
                
            }
            else if(secim==3)
            {
              Scanner b=new Scanner(System.in);
              System.out.println("bilgilerini silmek istediğiniz hastanın id numarasını giriniz...");
              int id=b.nextInt();
                tb2.sil(id);
                tb3.sil(id);
                
            }
            else{
                System.out.println("geçersiz bir işlem değeri girdiniz...");
                break;
            }
   }
        }
        else if(secim2.equals("b")){
            String personel_işlemleri="1-doktor bilgisi görüntüle\n"
                                + "2-yeni doktor kaydı alımı\n"
                                + "3-doktor kaydı silme\n"
                                + "0-ÇIKIŞ İŞLEMİ";
            
         while(true){
             System.out.println(personel_işlemleri);
            System.out.print("lütfen bir işlem seçiniz");
            int islem2=s.nextInt();
            if(islem2==0)
            {
                System.out.println("sistemden çıkılıyor");
                break;
            }
            else if(islem2==1)
            {
                tb1.goster();
                d.doktor_goruntule();//hata verdi
            }
            else if(islem2==2)
            {
                Scanner c=new Scanner(System.in);
                System.out.print("yeni doktorun adı : ");
                String d_adı=c.nextLine();
                System.out.print("yeni doktorun soyadı : ");
                String d_soyad=c.nextLine();
                System.out.print("yeni doktorun tıbbi birimi : ");
                String unvan=c.nextLine();
                d.doktorlar(d_adı, d_soyad, unvan);
                tb1.ekle(d_adı, d_soyad, unvan);
                s.nextLine();
            }
            else if(islem2==3)
            {
                Scanner a=new Scanner(System.in);
                System.out.println("lütefen bilgilerini silmek istediğiniz doktorun id numarasını biriniz");
                int id=a.nextInt();
                tb1.sil(id);//doktorun bilgilerini silen fonksiyon...
            }
            else{
                System.out.println("geçersiz bir işlem girdiniz...");
                break;
            }
        }}
        break;
        
}
       // h.hasta_yas_ortalaması();
       /* lb.lab_bilg();
        lb.lab_randevu_al();*/
    
    }
}
