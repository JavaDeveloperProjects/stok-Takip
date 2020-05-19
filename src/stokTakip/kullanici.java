package stokTakip;

public class kullanici {
	private int TC;
	private String adi=null;
	private String soyadi=null;
	private String sifre=null;
	
	public kullanici(int TC,String adi,String soyadi,String sifre)
	{
		this.TC=TC;
		this.adi=adi;
		this.soyadi=soyadi;
		this.sifre=sifre;
	}

	public int getTC() {
		return TC;
	}

	public void setTC(int tC) {
		TC = tC;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	
	

}
