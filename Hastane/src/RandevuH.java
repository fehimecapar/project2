
import java.util.ArrayList;


public class RandevuH extends Hastalar{

    public RandevuH() {
    }

    public RandevuH(ArrayList<String> hasta, ArrayList<Integer> yas, ArrayList<String> soyadı, ArrayList<String> tarih) {
        super(hasta, yas, soyadı, tarih);
    }
    
    @Override
    public void randevu_olustur(String date) {
        super.randevu_olustur(date); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void randevu_al(String date){
         randevu_olustur(date);
        System.out.println("randevunuz oluşturulmaktadır lütfen bekleyiniz");
        //zaman modülü ekle
        System.out.println(date +" tarihine randevunuz ayarlanmıştır lütfen randevunuza vaktinde gelmeye çalışınız....");
    }
    @Override
    public  void hasta_kaydı() {
        super.hasta_kaydı(); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
