package stokTakip;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.TextArea;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class stokTest {

	static database ekle=new database();
	
	private JFrame frame;
	private JTextField urunkodu;
	private JTextField urunadi;
	private JTextField urunfiyati;
	private JTextField urunmiktari;
	private JTextField guncelisim;
	private JTextField guncelkod;
	private JTextField guncelmiktar;
	private JTextField guncelfiyat;
	private JRadioButton rdbtnIsimIle;
	private JRadioButton rdbtnKodIle;
	private JTextField urunismii;
	private JTextField urunkoduu;
	private JLabel lblrnnIsmi;
	private JLabel lblrnKodu;
	private JTextField kullaniciadi;
	private JTextField kullanicisifre;
	private JTextField yoneticiisim;
	private JTextField yoneticisifre;
	private JPanel panelilk;
	private JPanel panelguncelle;
	private JPanel panelsecim;
	private JPanel panelurunekle;
	private JPanel panel_1;//arama
	private JPanel panelkullanici;
	private JPanel panelkullanicigiris;
	private JPanel sonraki;//arama
	private JTextField kulisim;
	private JTextField kulsoyisim;
	private JTextField kulid;
	private JTextField kulsifre;
	private JButton btnKullancGncelle;
	private JButton btnKullancEkle;
	private JButton btnKullancSil;
	private JRadioButton rdbtnfiyatguncelle;
	private JRadioButton rdbtnmiktarguncelle;
	private JRadioButton rdbtnrnIsmiIle;
	private JRadioButton rdbtnrnKoduIle;
	private JTextArea textArea;
	private JButton kullanicigiris ;
	private JButton yoneticigiris;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stokTest window = new stokTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public stokTest()   {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize()  {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
																											//KULLANICI iþlemleri PANELÝÝÝÝÝÝÝÝ
		panelkullanici = new JPanel();
		panelkullanici.setSize(691, 463);
		frame.getContentPane().add(panelkullanici, BorderLayout.CENTER);
		panelkullanici.setLayout(null);
		panelkullanici.setVisible(false);
		
		JLabel lblKullancIlemleri = new JLabel("KULLANICI \u0130\u015ELEMLER\u0130");
		lblKullancIlemleri.setForeground(new Color(0, 0, 153));
		lblKullancIlemleri.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 24));
		lblKullancIlemleri.setBounds(213, 11, 289, 29);
		panelkullanici.add(lblKullancIlemleri);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 67, 167, 136);
		panelkullanici.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnKullancEkle = new JRadioButton("Kullan\u0131c\u0131 Ekle");
		rdbtnKullancEkle.setForeground(new Color(255, 0, 0));
		rdbtnKullancEkle.setBounds(6, 7, 143, 23);
		panel_2.add(rdbtnKullancEkle);
		rdbtnKullancEkle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				kulisim.setVisible(true);
				kulsoyisim.setVisible(true);
				kulid.setVisible(true);
				kulsifre.setVisible(true);
				//btnKullancGncelle.setVisible(false);
				kulisim.setText("");
				kulsoyisim.setText("");
				kulid.setText("");
				kulsifre.setText("");
				
				btnKullancSil.setVisible(false);
				btnKullancEkle.setVisible(true);
				btnKullancGncelle.setVisible(false);
				
			}
		});
		
		JRadioButton rdbtnKullancGncelle = new JRadioButton("Þifre Güncelle");
		rdbtnKullancGncelle.setForeground(new Color(255, 0, 0));
		rdbtnKullancGncelle.setBounds(6, 48, 143, 23);
		panel_2.add(rdbtnKullancGncelle);
		rdbtnKullancGncelle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				kulisim.setVisible(true);
				kulsoyisim.setVisible(true);
				kulid.setVisible(true);
				kulsifre.setVisible(true);
				
				kulisim.setText("");
				kulsoyisim.setText("");
				kulid.setText("");
				kulsifre.setText("");
				
				btnKullancGncelle.setVisible(true);
				btnKullancSil.setVisible(false);
				btnKullancEkle.setVisible(false);
			}
		});
		
		JRadioButton rdbtnKullancSil = new JRadioButton("Kullan\u0131c\u0131 Sil");
		rdbtnKullancSil.setForeground(new Color(255, 0, 0));
		rdbtnKullancSil.setBounds(6, 93, 143, 23);
		panel_2.add(rdbtnKullancSil);
		rdbtnKullancSil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				kulisim.setVisible(true);
				kulsoyisim.setVisible(true);
				kulid.setVisible(true);
				kulsifre.setVisible(false);
				
				kulisim.setText("");
				kulsoyisim.setText("");
				kulid.setText("");
				kulsifre.setText("");
				
				btnKullancSil.setVisible(true);
				btnKullancGncelle.setVisible(false);
				btnKullancEkle.setVisible(false);
				
			}
		});
		
		JLabel lblIsim = new JLabel("\u0130sim:");
		lblIsim.setForeground(new Color(255, 0, 0));
		lblIsim.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIsim.setBounds(260, 67, 85, 20);
		panelkullanici.add(lblIsim);
		
		JLabel lblSoyisim = new JLabel("Soyisim:");
		lblSoyisim.setForeground(Color.RED);
		lblSoyisim.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSoyisim.setBounds(260, 98, 85, 20);
		panelkullanici.add(lblSoyisim);
		
		JLabel lblId = new JLabel("TC:");
		lblId.setForeground(Color.RED);
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblId.setBounds(260, 129, 85, 20);
		panelkullanici.add(lblId);
		
		JLabel lblSifre = new JLabel("Sifre:");
		lblSifre.setForeground(Color.RED);
		lblSifre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSifre.setBounds(260, 160, 85, 20);
		panelkullanici.add(lblSifre);
		
		kulisim = new JTextField();
		kulisim.setBounds(355, 69, 86, 20);
		panelkullanici.add(kulisim);
		kulisim.setColumns(10);
		kulisim.setVisible(false);
		
		kulsoyisim = new JTextField();
		kulsoyisim.setColumns(10);
		kulsoyisim.setBounds(355, 100, 86, 20);
		panelkullanici.add(kulsoyisim);
		kulsoyisim.setVisible(false);
		
		kulid = new JTextField();
		kulid.setColumns(10);
		kulid.setBounds(355, 131, 86, 20);
		panelkullanici.add(kulid);
		kulid.setVisible(false);
		
		kulsifre = new JTextField();
		kulsifre.setColumns(10);
		kulsifre.setBounds(355, 162, 86, 20);
		panelkullanici.add(kulsifre);
		kulsifre.setVisible(false);
		
		btnKullancEkle = new JButton("Kullan\u0131c\u0131 Ekle");
		btnKullancEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kadi=null,ksoyadi=null,ksifre=null;
				int kTC=-1;
				kadi=kulisim.getText();
				ksoyadi=kulsoyisim.getText();
				ksifre=kulsifre.getText();
				kTC=Integer.parseInt(kulid.getText());
				
				try {
					ekle.kullaniciEkle(kadi, ksoyadi, ksifre, kTC);
					JOptionPane.showMessageDialog(null, "Kullanýcý eklendi..","Baþarýlý ekleme", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnKullancEkle.setForeground(new Color(0, 0, 51));
		btnKullancEkle.setBackground(new Color(255, 255, 204));
		btnKullancEkle.setBounds(529, 67, 125, 23);
		panelkullanici.add(btnKullancEkle);
		
		btnKullancGncelle = new JButton("Þifre Güncelle");
		btnKullancGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kadi=null,ksoyadi=null,ksifre=null;
				int kTC=-1;
				kadi=kulisim.getText();
				ksoyadi=kulsoyisim.getText();
				ksifre=kulsifre.getText();
				kTC=Integer.parseInt(kulid.getText());
				
				try {
					ekle.kullaniciGuncelle(kadi, ksoyadi, ksifre, kTC);
					JOptionPane.showMessageDialog(null, "Þifre Baþarýyla Güncellendi..","Güncelleme Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnKullancGncelle.setForeground(new Color(0, 0, 51));
		btnKullancGncelle.setBackground(new Color(255, 255, 204));
		btnKullancGncelle.setBounds(529, 113, 125, 23);
		panelkullanici.add(btnKullancGncelle);
		
		btnKullancSil = new JButton("Kullan\u0131c\u0131 Sil");
		btnKullancSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kadi=null,ksoyadi=null;
				int kTC=-1;
				kadi=kulisim.getText();
				ksoyadi=kulsoyisim.getText();
				kTC=Integer.parseInt(kulid.getText());
				
				try {
					ekle.kullaniciSil(kadi, ksoyadi, kTC);
					JOptionPane.showMessageDialog(null, "Kullanýcý silindi..","Silindi", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnKullancSil.setForeground(new Color(0, 0, 51));
		btnKullancSil.setBackground(new Color(255, 255, 204));
		btnKullancSil.setBounds(529, 161, 125, 23);
		panelkullanici.add(btnKullancSil);
		
		ButtonGroup btnGroupkullanici=new ButtonGroup();
		btnGroupkullanici.add(rdbtnKullancEkle);
		btnGroupkullanici.add(rdbtnKullancGncelle);
		btnGroupkullanici.add(rdbtnKullancSil);
		
		JButton btnNewButton = new JButton("T\u00DCM KULLANICILARI L\u0130STELE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gelen=null;
				try {
					gelen=ekle.kullaniciListele();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				textArea.setText(gelen);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(35, 229, 596, 23);
		panelkullanici.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(35, 271, 596, 169);
		panelkullanici.add(textArea);
		
		
		
		
		
		//////////																				//GÝRÝÞ PANELÝÝÝÝÝÝÝ
		
		panelilk = new JPanel();
		panelilk.setBounds(0, 0, 691, 462);
		frame.getContentPane().add(panelilk, BorderLayout.CENTER);
		panelilk.setLayout(null);
		
		panelkullanicigiris = new JPanel();
		panelkullanicigiris.setBackground(new Color(0, 102, 102));
		panelkullanicigiris.setBounds(0, 0, 345, 462);
		panelilk.add(panelkullanicigiris);
		panelkullanicigiris.setLayout(null);
		
		
		JLabel lblKullancGirii = new JLabel("KULLANICI G\u0130R\u0130\u015E\u0130");
		lblKullancGirii.setForeground(new Color(255, 0, 0));
		lblKullancGirii.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblKullancGirii.setBounds(58, 49, 251, 44);
		panelkullanicigiris.add(lblKullancGirii);
		
		JLabel lblIsim1 = new JLabel("\u0130sim:");
		lblIsim1.setForeground(new Color(255, 102, 0));
		lblIsim1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIsim1.setBounds(42, 185, 58, 23);
		panelkullanicigiris.add(lblIsim1);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setForeground(new Color(255, 102, 0));
		lblifre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblifre.setBounds(42, 228, 58, 23);
		panelkullanicigiris.add(lblifre);
		
		kullaniciadi = new JTextField();
		kullaniciadi.setBounds(123, 188, 86, 20);
		panelkullanicigiris.add(kullaniciadi);
		kullaniciadi.setColumns(10);
		
		
		kullanicisifre = new JTextField();
		kullanicisifre.setColumns(10);
		kullanicisifre.setBounds(123, 231, 86, 20);
		panelkullanicigiris.add(kullanicisifre);
		
		kullanicigiris = new JButton("Giri\u015F Yap");
		kullanicigiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekle.baglanti();
					ekle.kullaniciListele();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				String ad=null,sifre=null;
				String deger="Y";
				ad=kullaniciadi.getText();
				sifre=kullanicisifre.getText();
				
					try {
					
						deger=ekle.giriskosul(deger, ad, sifre);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				if(deger=="D")
				{
					panelilk.setVisible(false);
					panelsecim.setVisible(true);
					btnKullancGncelle.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Yanlýþ kullanýcý adý veya þifre..","Hatalý Giriþ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		kullanicigiris.setForeground(new Color(204, 0, 0));
		kullanicigiris.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		kullanicigiris.setBackground(new Color(255, 255, 255));
		kullanicigiris.setBounds(120, 293, 89, 23);
		panelkullanicigiris.add(kullanicigiris);
		
		JPanel panelyonetici = new JPanel();
		panelyonetici.setBackground(new Color(102, 153, 255));
		panelyonetici.setBounds(345, 0, 346, 462);
		panelilk.add(panelyonetici);
		panelyonetici.setLayout(null);
		
		JLabel lblYneticiGirii = new JLabel("Y\u00D6NET\u0130C\u0130 G\u0130R\u0130\u015E\u0130");
		lblYneticiGirii.setForeground(new Color(255, 0, 0));
		lblYneticiGirii.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblYneticiGirii.setBounds(63, 56, 241, 28);
		panelyonetici.add(lblYneticiGirii);
		
		JLabel label = new JLabel("\u0130sim:");
		label.setForeground(new Color(0, 255, 204));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(46, 184, 58, 23);
		panelyonetici.add(label);
		
		JLabel label_1 = new JLabel("\u015Eifre:");
		label_1.setForeground(new Color(0, 255, 204));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(46, 218, 58, 23);
		panelyonetici.add(label_1);
		
		yoneticiisim = new JTextField();
		yoneticiisim.setColumns(10);
		yoneticiisim.setBounds(113, 187, 86, 20);
		panelyonetici.add(yoneticiisim);
		
		yoneticisifre = new JTextField();
		yoneticisifre.setColumns(10);
		yoneticisifre.setBounds(113, 221, 86, 20);
		panelyonetici.add(yoneticisifre);
		
		yoneticigiris = new JButton("Giri\u015F Yap");
		yoneticigiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekle.baglanti();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				String ad=null,sifre=null;
				String deger="Y";
				ad=yoneticiisim.getText();
				sifre=yoneticisifre.getText();
				
					try {
						
						deger=ekle.giriskosulyonetici(deger, ad, sifre);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				if(deger=="D")
				{
					panelilk.setVisible(false);
					panelsecim.setVisible(true);
					btnKullancGncelle.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Yanlýþ kullanýcý adý veya þifre..","Hatalý Giriþ", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		yoneticigiris.setForeground(new Color(204, 0, 0));
		yoneticigiris.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		yoneticigiris.setBackground(Color.WHITE);
		yoneticigiris.setBounds(110, 281, 89, 23);
		panelyonetici.add(yoneticigiris);
		
		
		
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////SEÇÝM PANELÝÝÝÝÝÝÝÝÝÝÝÝÝÝÝ
		
		panelsecim = new JPanel();
		panelsecim.setBounds(0, 0, 690, 463);
		panelsecim.setBackground(new Color(153, 255, 255));
		frame.getContentPane().add(panelsecim);
		panelsecim.setLayout(null);
		panelsecim.setVisible(false);

		JButton btnurunekle = new JButton("\u00DCR\u00DCN EKLE");
		btnurunekle.setForeground(new Color(139, 0, 0));
		btnurunekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekle.baglanti();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				panelsecim.setVisible(false);
				panelurunekle.setVisible(true);
			}
		});
		btnurunekle.setBounds(36, 192, 164, 63);
		panelsecim.add(btnurunekle);

		JButton btnurungor = new JButton("\u00DCR\u00DCNLER\u0130 L\u0130STELE");
		btnurungor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekle.baglanti();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				panelsecim.setVisible(false);
				sonraki.setVisible(true);
			}
		});
		btnurungor.setForeground(new Color(139, 0, 0));
		btnurungor.setBounds(270, 192, 164, 63);
		panelsecim.add(btnurungor);

		JButton btnurunguncelle = new JButton("\u00DCR\u00DCN G\u00DCNCELLE");
		btnurunguncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekle.baglanti();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				panelsecim.setVisible(false);
				panelguncelle.setVisible(true);
			}
		});
		btnurunguncelle.setForeground(new Color(139, 0, 0));
		btnurunguncelle.setBounds(490, 192, 164, 63);
		panelsecim.add(btnurunguncelle);

		JLabel lblYapmakIstediginizIlemi = new JLabel("YAPMAK \u0130STED\u0130G\u0130N\u0130Z \u0130\u015ELEM\u0130 SE\u00C7\u0130N\u0130Z...");
		lblYapmakIstediginizIlemi.setForeground(new Color(210, 105, 30));
		lblYapmakIstediginizIlemi.setBounds(248, 57, 359, 40);
		panelsecim.add(lblYapmakIstediginizIlemi);

		btnKullancGncelle = new JButton("KULLANICI \u0130\u015ELEMLER\u0130");
		btnKullancGncelle.setBounds(270, 313, 164, 63);
		panelsecim.add(btnKullancGncelle);
		btnKullancGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekle.baglanti();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				panelsecim.setVisible(false);
				panelkullanici.setVisible(true);
			}
		});
		btnKullancGncelle.setForeground(new Color(255, 102, 0));
		
		
		
							
		
		
		
																								//PANEL GÜNCELLEEEEEEE
		panelguncelle = new JPanel();
		panelguncelle.setSize(691, 463);
		frame.getContentPane().add(panelguncelle, BorderLayout.CENTER);
		panelguncelle.setLayout(null);
		panelguncelle.setVisible(false);
		
		JLabel lblrnGncellemekIin = new JLabel("\u00DCR\u00DCN\u00DC G\u00DCNCELLEMEK \u0130\u00C7\u0130N GEREKL\u0130 B\u0130LG\u0130LER\u0130 G\u0130R\u0130N\u0130Z");
		lblrnGncellemekIin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblrnGncellemekIin.setForeground(Color.RED);
		lblrnGncellemekIin.setBackground(Color.WHITE);
		lblrnGncellemekIin.setBounds(38, 11, 613, 35);
		panelguncelle.add(lblrnGncellemekIin);
		
		JLabel lblrnnIsmi = new JLabel("\u00DCr\u00FCn\u00FCn ismi:");
		lblrnnIsmi.setBounds(227, 180, 125, 23);
		panelguncelle.add(lblrnnIsmi);
		
		JLabel lblrnnKodu = new JLabel("\u00DCr\u00FCn\u00FCn Kodu:");
		lblrnnKodu.setBounds(227, 235, 125, 23);
		panelguncelle.add(lblrnnKodu);
		
		guncelisim = new JTextField();
		guncelisim.setBounds(320, 181, 121, 20);
		panelguncelle.add(guncelisim);
		guncelisim.setColumns(10);
		guncelisim.setVisible(false);
		
		guncelkod = new JTextField();
		guncelkod.setBounds(320, 236, 121, 20);
		panelguncelle.add(guncelkod);
		guncelkod.setColumns(10);
		guncelkod.setVisible(false);
		
		JButton btnguncelle = new JButton("G\u00DCNCELLE");
		btnguncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean fiyat=false,miktar=false,isimle=false,kodla=false;
				fiyat=rdbtnfiyatguncelle.isSelected();
				miktar=rdbtnmiktarguncelle.isSelected();
				isimle=rdbtnrnIsmiIle.isSelected();
				kodla=rdbtnrnKoduIle.isSelected();
				double fiyatal = -1,miktaral = -1;
				String isim=null,kod=null;
				
				if(fiyat==true && isimle==true)
				{
					
					isim=guncelisim.getText();
					fiyatal=Double.parseDouble(guncelfiyat.getText());
					
				}
				else if(fiyat==true && kodla==true)
				{
					
					kod=guncelkod.getText();
					fiyatal=Double.parseDouble(guncelfiyat.getText());
					
				}
				else if(miktar==true && isimle==true)
				{
					
					isim=guncelisim.getText();
					miktaral=Double.parseDouble(guncelmiktar.getText());
					
				}
				else if(miktar==true && kodla==true)
				{
					
					kod=guncelkod.getText();
					miktaral=Double.parseDouble(guncelmiktar.getText());
					
				}
				else
					System.out.println("seçim yap");
				try {
					ekle.urunguncelle(isim,kod,fiyatal,miktaral);
					JOptionPane.showMessageDialog(null, "Ürün güncellendi..","Güncelleme", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnguncelle.setBounds(530, 203, 151, 46);
		panelguncelle.add(btnguncelle);
		
		JLabel lblrnnMiktar = new JLabel("\u00DCr\u00FCn\u00FCn Miktar\u0131:");
		lblrnnMiktar.setBounds(227, 287, 125, 23);
		panelguncelle.add(lblrnnMiktar);
		
		guncelmiktar = new JTextField();
		guncelmiktar.setColumns(10);
		guncelmiktar.setBounds(320, 288, 121, 20);
		panelguncelle.add(guncelmiktar);
		guncelmiktar.setVisible(false);
		
		JLabel lblrnnFiyat = new JLabel("\u00DCr\u00FCn\u00FCn Fiyat\u0131:");
		lblrnnFiyat.setBounds(227, 335, 125, 23);
		panelguncelle.add(lblrnnFiyat);
		
		guncelfiyat = new JTextField();
		guncelfiyat.setColumns(10);
		guncelfiyat.setBounds(320, 336, 121, 20);
		panelguncelle.add(guncelfiyat);
		guncelfiyat.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 180, 183, 116);
		panelguncelle.add(panel);
		panel.setLayout(null);
		
		rdbtnfiyatguncelle = new JRadioButton("\u00DCr\u00FCn\u00FCn Fiyat\u0131n\u0131 G\u00FCncelle:");
		rdbtnfiyatguncelle.setBounds(0, 24, 183, 23);
		panel.add(rdbtnfiyatguncelle);
		rdbtnfiyatguncelle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guncelisim.setText("");
				guncelkod.setText("");
				guncelmiktar.setText("");
				guncelfiyat.setText("");
				guncelisim.setVisible(false);
				guncelkod.setVisible(false);
				guncelmiktar.setVisible(false);
				guncelfiyat.setVisible(true);
			}
		});
		
		rdbtnmiktarguncelle = new JRadioButton("\u00DCr\u00FCn\u00FCn Miktar\u0131n\u0131 G\u00FCncelle:");
		rdbtnmiktarguncelle.setBounds(0, 69, 183, 23);
		panel.add(rdbtnmiktarguncelle);
		rdbtnmiktarguncelle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guncelisim.setText("");
				guncelkod.setText("");
				guncelmiktar.setText("");
				guncelfiyat.setText("");
				guncelisim.setVisible(false);
				guncelkod.setVisible(false);
				guncelmiktar.setVisible(true);
				guncelfiyat.setVisible(false);
			}
		});
		ButtonGroup btnGroup=new ButtonGroup();
		btnGroup.add(rdbtnmiktarguncelle);
		btnGroup.add(rdbtnfiyatguncelle);
		
		
		rdbtnrnIsmiIle = new JRadioButton("\u00DCr\u00FCn ismi ile:");
		rdbtnrnIsmiIle.setBounds(227, 125, 109, 23);
		panelguncelle.add(rdbtnrnIsmiIle);
		rdbtnrnIsmiIle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guncelisim.setText("");
				guncelkod.setText("");
				guncelmiktar.setText("");
				guncelfiyat.setText("");
				guncelisim.setVisible(true);
				guncelkod.setVisible(false);
				
			}
		});
		
		rdbtnrnKoduIle = new JRadioButton("\u00DCr\u00FCn kodu ile:");
		rdbtnrnKoduIle.setBounds(332, 125, 109, 23);
		panelguncelle.add(rdbtnrnKoduIle);
		rdbtnrnKoduIle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guncelisim.setText("");
				guncelkod.setText("");
				guncelmiktar.setText("");
				guncelfiyat.setText("");
				guncelisim.setVisible(false);
				guncelkod.setVisible(true);
			}
		});
		ButtonGroup btnGroup2=new ButtonGroup();
		btnGroup2.add(rdbtnrnKoduIle);
		btnGroup2.add(rdbtnrnIsmiIle);
		
		
															////////////////////////////////////PANEL ARAMAAAAAAAAAAAAAAAAAAAAA
		
		
		sonraki = new JPanel();
		sonraki.setLocation(0, 0);
		sonraki.setSize(691, 463);
		frame.getContentPane().add(sonraki, BorderLayout.CENTER);
		sonraki.setLayout(null);
		sonraki.setVisible(false);
		
		JLabel lblrnAramakIin = new JLabel("\u00DCR\u00DCN ARAMAK \u0130\u00C7\u0130N GEREKL\u0130 YERLER\u0130 DOLDUR...");
		lblrnAramakIin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblrnAramakIin.setForeground(new Color(102, 0, 0));
		lblrnAramakIin.setBounds(84, 11, 553, 36);
		sonraki.add(lblrnAramakIin);
		
		panel_1 = new JPanel();
		panel_1.setBounds(159, 58, 347, 36);
		sonraki.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnrnIsmiIle1 = new JRadioButton("\u00DCr\u00FCn ismi ile:");
		rdbtnrnIsmiIle1.setBounds(6, 7, 109, 23);
		panel_1.add(rdbtnrnIsmiIle1);
		rdbtnrnIsmiIle1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				urunismii.setVisible(true);
				urunkoduu.setVisible(false);
			}
		});
		
		JRadioButton rdbtnrnKoduIle1 = new JRadioButton("\u00DCr\u00FCn kodu ile:");
		rdbtnrnKoduIle1.setBounds(212, 7, 109, 23);
		panel_1.add(rdbtnrnKoduIle1);
		rdbtnrnKoduIle1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				urunkoduu.setVisible(true);
				urunismii.setVisible(false);
			}
		});
		ButtonGroup btnGroup21=new ButtonGroup();
		btnGroup21.add(rdbtnrnKoduIle1);
		btnGroup21.add(rdbtnrnIsmiIle1);
		
		lblrnnIsmi = new JLabel("\u00DCr\u00FCn\u00FCn ismi:");
		lblrnnIsmi.setBounds(84, 130, 95, 14);
		sonraki.add(lblrnnIsmi);
		
		urunismii = new JTextField();
		urunismii.setBounds(158, 127, 86, 20);
		sonraki.add(urunismii);
		urunismii.setColumns(10);
		urunismii.setVisible(false);
		
		lblrnKodu = new JLabel("\u00DCr\u00FCn kodu:");
		lblrnKodu.setBounds(375, 130, 86, 14);
		sonraki.add(lblrnKodu);
		
		urunkoduu = new JTextField();
		urunkoduu.setBounds(446, 127, 86, 20);
		sonraki.add(urunkoduu);
		urunkoduu.setColumns(10);
		urunkoduu.setVisible(false);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(84, 210, 519, 30);
		sonraki.add(textArea1);
		
		JButton btnurunbul = new JButton("\u00DCr\u00FCn\u00FC bul");
		btnurunbul.setForeground(Color.RED);
		btnurunbul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gelen=null;
				boolean kod=false,isim=false;
				kod=rdbtnrnKoduIle1.isSelected();
				isim=rdbtnrnIsmiIle1.isSelected();
				String gisim=null,gkod=null;
				
				if(isim==true)
				{
					gisim=urunismii.getText();
				}
				else if(kod==true)
				{
					gkod=urunkoduu.getText();
				}
				try {
					gelen=ekle.urunarama(gisim, gkod);
					JOptionPane.showMessageDialog(null, "Ürün bulundu..","Bulundu", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				textArea1.setText(gelen);
			}
		});
		btnurunbul.setBounds(271, 177, 105, 23);
		sonraki.add(btnurunbul);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 290, 517, 150);
		sonraki.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JButton btnrnleriListele = new JButton("\u00DCr\u00FCnleri Listele");
		btnrnleriListele.setForeground(Color.RED);
		btnrnleriListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String yaz=null;
				try {
					ekle.baglanti();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					yaz=ekle.tumurunler();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textArea_1.setText(yaz);
			}
		});
		btnrnleriListele.setBounds(252, 251, 147, 23);
		sonraki.add(btnrnleriListele);
		
		
		
		

		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////PANEL ÜRÜN EKLEMEEEEE
		
		panelurunekle = new JPanel();
		panelurunekle.setSize(691, 463);
		frame.getContentPane().add(panelurunekle, BorderLayout.CENTER);
		panelurunekle.setLayout(null);
		panelurunekle.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("\u00DCR\u00DCN EKLEMEK \u0130\u00C7\u0130N ALANLARI DOLDUR...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setToolTipText("\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(77, 11, 584, 69);
		panelurunekle.add(lblNewLabel);
		
		JLabel lblrnKodu = new JLabel("\u00DCR\u00DCN KODU:");
		lblrnKodu.setBounds(35, 91, 85, 21);
		panelurunekle.add(lblrnKodu);
		
		urunkodu = new JTextField();
		urunkodu.setBounds(130, 91, 127, 20);
		panelurunekle.add(urunkodu);
		urunkodu.setColumns(10);
		
		JLabel lblrnAd = new JLabel("\u00DCR\u00DCN ADI:");
		lblrnAd.setBounds(35, 154, 85, 21);
		panelurunekle.add(lblrnAd);
		
		urunadi = new JTextField();
		urunadi.setColumns(10);
		urunadi.setBounds(130, 154, 127, 20);
		panelurunekle.add(urunadi);
		
		JLabel lblrnTr = new JLabel("\u00DCR\u00DCN T\u00DCR\u00DC:");
		lblrnTr.setBounds(35, 210, 85, 21);
		panelurunekle.add(lblrnTr);
		
		JLabel lblrnFiyat = new JLabel("\u00DCR\u00DCN F\u0130YATI:");
		lblrnFiyat.setBounds(35, 265, 85, 27);
		panelurunekle.add(lblrnFiyat);
		
		urunfiyati = new JTextField();
		urunfiyati.setColumns(10);
		urunfiyati.setBounds(130, 268, 127, 20);
		panelurunekle.add(urunfiyati);
		
		JLabel lblrnMiktar = new JLabel("\u00DCR\u00DCN M\u0130KTARI:");
		lblrnMiktar.setBounds(35, 328, 85, 21);
		panelurunekle.add(lblrnMiktar);
		
		urunmiktari = new JTextField();
		urunmiktari.setColumns(10);
		urunmiktari.setBounds(130, 328, 127, 20);
		panelurunekle.add(urunmiktari);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SE\u00C7\u0130N\u0130Z", "GIDA", "IÇECEK", "MEYVE", "SEBZE"}));
		comboBox.setBounds(130, 210, 127, 20);
		panelurunekle.add(comboBox);
		
		JButton btnurunuekle = new JButton("\u00DCR\u00DCN\u00DC EKLE");
		btnurunuekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adi=urunadi.getText();
				Double miktar=Double.parseDouble(urunmiktari.getText());
				Double fiyat=Double.parseDouble(urunfiyati.getText());
				String kod=urunkodu.getText();
				String tur=(String) comboBox.getSelectedItem();
				try {
					
					ekle.urunekle(adi, miktar, fiyat, kod,tur);
					JOptionPane.showMessageDialog(null, "Ürün baþarýyla eklendi..","Eklendi", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		});
		btnurunuekle.setBackground(SystemColor.activeCaptionBorder);
		btnurunuekle.setForeground(Color.BLUE);
		btnurunuekle.setBounds(375, 186, 230, 106);
		panelurunekle.add(btnurunuekle);
		
	}
}
