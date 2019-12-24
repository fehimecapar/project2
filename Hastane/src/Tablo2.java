
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Tablo2 implements Tablolar{
    
    private String kullanıcı_adı="root";
    private String password="";
    private String db_ismi="tabloiki";
    private String host="localHost";
    private int port=3306;
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedstatement=null;
    public Tablo2(){
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?UseUnicode=true&characterEncoding=utf-8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver bulunamadı");
        }
        try {
            con=DriverManager.getConnection(url, kullanıcı_adı, password);
            
        } catch (SQLException ex) {
            System.out.println("bağlantı başarısız...");
        }
        
    }

    @Override
    public void goster() {
        String sorgu="Select * From hastabilgileri2 ";
         try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);//içine aldığı sorguyu çalıştırır.
            while(rs.next())//daha okuyacak değer var mı diye sorar.
            {
                int id=rs.getInt("id");
                String ad=rs.getString("ad");
                String soyad=rs.getString("soyad");
                int yaş=rs.getInt("yas");
                System.out.println("id : "+id+" ad : "+ad+" soyad : "+soyad+" yas: "+yaş);
            }
            
        } catch (SQLException ex) {
            System.out.println("hata var...");
        }
         }

    @Override
    public void sil(int id) {
        String sorgu="Delete from hastabilgileri2 where id = ?";
        try {
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setInt(1,id);
            preparedstatement.executeUpdate(); 
        } catch (SQLException ex) {
            System.out.println("hatalı bir işlem girdiniz...");
        }
        
      
    }
    
    
    public void sil(String ad,String soyad){
        String sorgu="Delete from hastabilgileri2 where ad like ? and soyad like ?";
        try {
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setString(1,ad);
            preparedstatement.setString(2,soyad);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Tablo2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ekle(String ad,String soyad,int yaş){
        try {
            statement=con.createStatement();
            String sorgu="Insert Into hastabilgileri2 (ad,soyad,yas) VALUES("+"'"+ad+"',"+"'"+soyad+"',"+"'"+yaş+"')";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("hatalı bir işlem gerçekleştirdiniz...");
        }
    }

  /* public static void main(String[] args) {
        Tablo2 b=new Tablo2(); 
       Scanner s=new Scanner(System.in);
        System.out.println("ad:");
        String ad=s.nextLine();
        System.out.println("soyad:");
        String soyad=s.nextLine();
         System.out.println("yas:");
        int yas=s.nextInt();
        b.ekle(ad, soyad, yas);
        b.sil(ad, soyad);

   }*/
    
}
