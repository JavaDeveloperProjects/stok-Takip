package stokTakip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class database {
	private List<urun> urunlistesi;
	private List<kullanici> kbilgileri;
	
	private String kullaniciadi="root";
	private String parola="";
	private String host="127.0.0.1";
	private String datab="stoksistemi";
	private int port=3306;
	private Connection con=null;
	
	public void baglanti() throws ClassNotFoundException, SQLException 
	{
		String url="jdbc:mysql://"+this.host+":"+this.port+"/"+this.datab;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,kullaniciadi,parola);
		this.urunlistesi=new ArrayList<urun>();
		this.kbilgileri=new ArrayList<kullanici>();
		
		
		
	}
	
	public void urunekle(String adi,Double miktar,Double fiyat,String kod,String tur) throws SQLException
	{
		adi="'"+adi+"'";
		tur="'"+tur+"'";
		kod="'"+kod+"'";
		
		String sorgu="insert into stokurun(kodu,adi,turu,miktari,fiyati)"+"values("+kod+","+adi+","+tur+","+miktar+","+fiyat+")";
		Statement sta=(Statement)con.createStatement();
		int executeUpdate=sta.executeUpdate(sorgu);
	}
	public void urunguncelle(String isim,String kod,double fiyat,double miktar) throws SQLException
	{
		
		String sorgu=null;
		if(isim!=null&&fiyat>=0)
		{
			isim="'"+isim+"'";
			sorgu="UPDATE stokurun SET fiyati="+fiyat+"WHERE adi="+isim;
		}
		else if(isim!=null&&miktar>=0)
		{
			isim="'"+isim+"'";
			sorgu="UPDATE stokurun SET miktari="+miktar+"WHERE adi="+isim;
		}
		else if(kod!=null&&fiyat>=0)
		{
			kod="'"+kod+"'";
			sorgu="UPDATE stokurun SET fiyati="+fiyat+"WHERE kodu="+kod;
		}
		else if(kod!=null&&miktar>=0)
		{
			kod="'"+kod+"'";
			sorgu="UPDATE stokurun SET miktari="+miktar+"WHERE kodu="+kod;
		}
		
		
		Statement sta=(Statement)con.createStatement();
		int executeUpdate=sta.executeUpdate(sorgu);
		
	}
	public String urunarama(String isim,String kod) throws SQLException
	{
		String sorgu=null;
		String cekilen=null;
		String sorgutoplam="Select adi From stokurun";
		int toplamsatir=0;
		
		Statement sta=(Statement)con.createStatement();
		
		if(isim!=null) 
		{
			isim="'"+isim+"'";
			sorgu="Select * from stokurun where adi="+isim;
		}
		else if(kod!=null)
		{
			kod="'"+kod+"'";
			sorgu="Select * from stokurun where kodu="+kod;
		}
		
		ResultSet rs2=sta.executeQuery(sorgu);
		while(rs2.next()) {
            
            cekilen="isim:"+rs2.getString("adi")+"-kodu:"+rs2.getString("kodu")+"-turu:"+rs2.getString("turu")+
            		"-fiyat:"+rs2.getString("fiyati")+"-miktar:"+rs2.getString("miktari");
        }
		return cekilen;
	}
	
	public void kullaniciEkle(String adi,String soyadi,String sifre,int TC) throws SQLException
	{
		adi="'"+adi+"'";
		soyadi="'"+soyadi+"'";
		sifre="'"+sifre+"'";
		
		String sorgu="insert into kullanicilar(adi,soyadi,sifre,TC)"+"values("+adi+","+soyadi+","+sifre+","+TC+")";
		Statement sta=(Statement)con.createStatement();
		int executeUpdate=sta.executeUpdate(sorgu);
	}
	public void kullaniciGuncelle(String adi,String soyadi,String sifre,int TC) throws SQLException
	{
		adi="'"+adi+"'";
		soyadi="'"+soyadi+"'";
		sifre="'"+sifre+"'";
		
		String sorgu="UPDATE kullanicilar SET sifre="+sifre+"WHERE TC="+TC;
		Statement sta=(Statement)con.createStatement();
		int executeUpdate=sta.executeUpdate(sorgu);
		
	}
	public void kullaniciSil(String adi,String soyadi,int TC) throws SQLException
	{
		adi="'"+adi+"'";
		soyadi="'"+soyadi+"'";
		
		String sorgu="DELETE FROM kullanicilar WHERE TC="+TC;
		Statement sta=(Statement)con.createStatement();
		int executeUpdate=sta.executeUpdate(sorgu);
		
	}
	public String kullaniciListele() throws SQLException 
	{
		
		String sorgutoplam="Select id From kullanicilar";
		int toplamsatir=0;
		
		Statement sta=(Statement)con.createStatement();
		
		ResultSet rs=sta.executeQuery(sorgutoplam);
		while(rs.next()) {
			toplamsatir++;
        }
		String sorgu2="Select * From kullanicilar";
		String cekilen="";
		ResultSet rs2=sta.executeQuery(sorgu2);
		while(rs2.next()) {
            cekilen=cekilen+"Isim:"+rs2.getString("adi")+"-Soyisim:"+rs2.getString("soyadi")+
            		"-TC:"+rs2.getInt("TC")+"-ID:"+rs2.getInt("id")+"\n";
            kbilgileri.add(new kullanici(rs2.getInt("TC"),rs2.getString("adi"),rs2.getString("soyadi"),rs2.getString("sifre")));
            
        }
		
		return cekilen;
	}
	
	public String tumurunler() throws SQLException
	{
		String output="";
		String sorgu="Select * From stokurun";
		
		
		Statement sta=(Statement)con.createStatement();	
		ResultSet rs=sta.executeQuery(sorgu);
		
		while(rs.next())
		{
			output=output+"Ürün Adý:"+rs.getString("adi")+"-Ürün Kodu:"+rs.getString("kodu")+"-Ürün Turu:"+rs.getString("turu")+
            		"-Ürün Fiyatý:"+rs.getString("fiyati")+"-Ürün Miktarý:"+rs.getString("miktari")+"\n";
		}
		
		
		return output;
	}
	
	public String giriskosul(String deger,String ad,String sifre) throws SQLException
	{
		for(int i=0;i<kbilgileri.size();i++)
		{
			if(kbilgileri.get(i).getAdi().equalsIgnoreCase(ad) && kbilgileri.get(i).getSifre().equalsIgnoreCase(sifre))
			{
				deger="D";
			}
		}
		return deger;
	}
	public String giriskosulyonetici(String deger,String ad,String sifre) throws SQLException
	{
		String sorgu="Select * From yonetici";
		
		
		Statement sta=(Statement)con.createStatement();	
		ResultSet rs=sta.executeQuery(sorgu);
		
		while(rs.next())
		{  
			if(rs.getString("adi").equalsIgnoreCase(ad)&&rs.getString("sifre").equalsIgnoreCase(sifre))
			{
				deger="D";
				
			}
		}
		
		return deger;
	}
}
