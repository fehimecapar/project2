
import java.util.ArrayList;


public class RandevuD extends Doktor{

    public RandevuD() {
    }

    public RandevuD(ArrayList<String> doktor_adı,ArrayList<String> doktor_soyadı,ArrayList<String> doktor_unvanı ,ArrayList<String> birimler, ArrayList<String> tarih) {
        super(doktor_adı, doktor_soyadı,doktor_unvanı, birimler, tarih);
    }
    
    @Override
    public void doktorlar() {
        super.doktorlar();
    }

    @Override
    public void doktor_goruntule() {
        super.doktor_goruntule(); 
    }
    
    

    @Override
    public void randevu_al(String date) {
        super.randevu_al(date); //To change body of generated methods, choose Tools | Templates.
        System.out.println(date+" tarihi için randevunuz oluşturulmuştur.....");
    }
    
    
}
