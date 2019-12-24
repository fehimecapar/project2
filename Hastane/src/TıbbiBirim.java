
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fehime
 */
public class TıbbiBirim {
     private static ArrayList<String> birimler =new ArrayList<String>();
      public TıbbiBirim(){
          
      }
    public TıbbiBirim(ArrayList<String> birimler) {
        this.birimler=birimler;
    }
      public  void birimleri_goster()
    {
        birimler.add("1-Nöroloji");
        birimler.add("2-Göğüs Hastalıkları");
        birimler.add("3-KBB");
        birimler.add("4-Çocuk cerrahisi");
        birimler.add("5-Çocuk Allerjisi");
        birimler.add("6-Deri ve Zührevi Hastalıkları(Dermatoloji)");
        birimler.add("7-Kardiyoloji");  
        for(int i=0;i<birimler.size();i++)
        {
            System.out.println(birimler.get(i));
        }
    }
}
