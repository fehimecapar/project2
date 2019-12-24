
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tablo3 implements Tablolar{
    
    private String user_name="root";
    private String password="";
    private String db_ismi="tabloüç";
    private String host="localHost";
    private int port=3306;
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedstatement=null;
    String kisi;
    
    Tablo3(){
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?UseUnicode=true&characterEncoding=utf-8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver bulunamadı");
        }
        try {
            con=DriverManager.getConnection(url, user_name, password);
            
        } catch (SQLException ex) {
            System.out.println("bağlantı başarısız");
        }
    }

    @Override
    public void goster() {
        try {
            String sorgu="Select * From randevu ";
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);//içine aldığı sorguyu çalıştırır.
            while(rs.next())//daha okuyacak değer var mı diye sorar.
            {
                int id=rs.getInt("id");
                String ad=rs.getString("ad");
                String soyad=rs.getString("soyad");
                String randevu_aldıgı_birim=rs.getString("birim");
                String randevu_aldıgı_doktor=rs.getString("doktor");
                String randevu_tarihi=rs.getString("tarih");
                System.out.println("id : "+id+" ad : "+ad+" soyad : "+soyad+" randevu aldıgı birim : "+randevu_aldıgı_birim+" randevu aldıgı doktor : "+randevu_aldıgı_doktor+" randevu tarihi : "+randevu_tarihi);
  }
        } catch (SQLException ex) {
            System.out.println("hata var...");}
        
    }
    
   @Override
    public void sil(int id){
        String sorgu="Delete from randevu where id = ? ";
        try {
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setInt(1,id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("hatalı işlem");
        }
        
        
    }  
    
    public void sil(String ad,String soyad){
        String sorgu="Delete from randevu where ad like ? and soyad like ?";
        try {
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setString(1,ad);
            preparedstatement.setString(2,soyad);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Tablo3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void ekle(String ad,String soyad,String birim,String doktor,String tarih){//hatalı işlem değerini döndürüyo...
       
        try {
            statement=con.createStatement();
            String sorgu="Insert Into randevu (ad,soyad,birim,doktor,tarih) VALUES("+"'"+ad+"',"+"'"+soyad+"',"+"'"+birim+"',"+"'"+doktor+"',"+"'"+tarih+"')";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(Tablo3.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
    }
    
        public void secili_hasta_goruntule(){
            String sorgu="Select * From randevu where id = ?";
        try {
            Scanner s=new Scanner(System.in);
            System.out.println("lütfen görüntülenecek hastanın id bilgisini giriniz : ");
            int id=s.nextInt();
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setInt(1,id);
           ResultSet rs = preparedstatement.executeQuery();
           while(rs.next()){
               String adı=rs.getString("ad");
               String soyad=rs.getString("soyad");
               String birim=rs.getString("birim");
               String doktor=rs.getString("doktor");
               String tarih=rs.getString("tarih");
               System.out.println("adı : "+adı+" soyad : "+soyad+" randevu aldıgı birim : "+birim+" randevu aldıgı doktor : "+doktor+" randevu tarihi : "+tarih);
               
           }
            
        } catch (SQLException ex) {
                    }
        }
        public String secili_hasta_goruntule(String ad , String soyad)
        {
            String sorgu="Select * From randevu where ad like ? and soyad like ?";
        try {
           
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setString(1,ad);
            preparedstatement.setString(2,soyad);
           ResultSet rs = preparedstatement.executeQuery();
           while(rs.next()){
               String adı=rs.getString("ad");
               String soyadı=rs.getString("soyad");
               String birim=rs.getString("birim");
               String doktor=rs.getString("doktor");
               String tarih=rs.getString("tarih");
               kisi= "adı : "+adı+" soyad : "+soyadı+" randevu aldıgı birim : "+birim+" randevu aldıgı doktor : "+doktor+" randevu tarihi : "+tarih;
               System.out.println("adı : "+adı+" soyad : "+soyadı+" randevu aldıgı birim : "+birim+" randevu aldıgı doktor : "+doktor+" randevu tarihi : "+tarih);
           }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(Tablo3.class.getName()).log(Level.SEVERE, null, ex);
        }return kisi;
            
        }
   /*  public static void main(String[] args) {
        Tablo3 b=new Tablo3();
        Scanner s=new Scanner(System.in);
         System.out.println("ad");
         String ad=s.nextLine();
         System.out.println("soyad");
         String soyad=s.nextLine();
        /* System.out.println("birim");
         String birim=s.nextLine();
         System.out.println("doktor");
         String doktor=s.nextLine();
         System.out.println("tarih");
         String tarih=s.nextLine();
         b.ekle(ad, soyad, birim, doktor, tarih);
         b.secili_hasta_goruntule(ad, soyad);
     
     }*/
    
}
