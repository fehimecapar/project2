
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Tablo1 implements Tablolar{
    
    private String user_name="root";
    private String password="";
    private String db_ismi="tablobir";
    private String host="localHost";
    private int port=3306;
    private Connection con=null;
    private Statement statement=null;//veritabanında işlem yapmamı sağlar.
    private PreparedStatement preparedstatement=null;
     public Tablo1(){
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?UseUnicode=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver bulunamadı");
        }
        try{
            con=DriverManager.getConnection(url, user_name, password);
            
            
        }catch(SQLException ex){
            System.out.println("bağlantı başarısız...");
        }
        
    }
    
     
    @Override
    public void goster() {
        String sorgu="Select * From saglıkpersonelleri ";
         try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);//içine aldığı sorguyu çalıştırır.
            while(rs.next())//daha okuyacak değer var mı diye sorar.
            {
                int id=rs.getInt("id");
                String ad=rs.getString("ad");
                String soyad=rs.getString("soyad");
                String tıbbi_birim=rs.getString("unvan");
                System.out.println("id : "+id+" ad : "+ad+" soyad : "+soyad+" tıbbi birim : "+tıbbi_birim);
            }
            
        } catch (SQLException ex) {
            System.out.println("hata var...");
        }
    }

    
    public void ekle(String ad,String soyad,String tıbbi_birim) {
        
        try {
            statement=con.createStatement();
            
            String sorgu="Insert Into saglıkpersonelleri (ad,soyad,unvan) VALUES("+"'"+ad+"',"+"'"+soyad+"',"+"'"+tıbbi_birim+"')";
            statement.executeUpdate(sorgu);
          } catch (SQLException ex) {
            System.out.println("hatalı bir işlem yaptınız...");
        }
        
    }

    
    @Override
    public void sil(int id) {//silme işlemini değer göndererek gerçekleştiremedim...
         String sorgu = "Delete from saglıkpersonelleri where id = ?";
         
        try {
             preparedstatement=con.prepareStatement(sorgu);
             preparedstatement.setInt(1,id);
             preparedstatement.executeUpdate();
            
     } catch (SQLException ex) {
            System.out.println("işlem gerçekleştirilemedi");
        }
    }
    
 /*  public static void main(String[] args) {
        Tablo1 b=new Tablo1(); }*/
    
    
    
    
    
}
