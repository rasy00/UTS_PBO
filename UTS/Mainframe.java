package UTS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;

public class Mainframe extends JFrame {
	
	// deklaration object yang dibutuhkan
		private JPanel contentPane = new JPanel();
		private JPanel panel = new JPanel();
		private	JRadioButton motorRadio = new JRadioButton("Motor");
		private	JRadioButton mobilRadio = new JRadioButton("Mobil");
		private	JLabel lblNopol = new JLabel("Nomor Polisi : ");
		private	JTextField nopolField = new JTextField();
		private JLabel lblType = new JLabel("Type           : ");
		private JButton kendaraanIn = new JButton("Masuk");
		private JButton KendaraanOut = new JButton("Keluar");
		private JButton showTable = new JButton("Daftar Parkir");
		private Parkir obj = new Parkir();
		private Table frame = new Table(obj.field);
	/**
	 * Create the frame.
	 */
	public Mainframe() {
		setResizable(false);
		setTitle("Parkir");
		setBackground(new Color(0, 102, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 450, 300);
	
		// setup contentpane
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// setup panel
		panel.setBackground(Color.GRAY);
		panel.setBounds(6, 6, 438, 106);
		panel.setLayout(null);
		
		// setup label untuk nopol
		lblNopol.setBounds(16, 17, 102, 18);
		lblNopol.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		// setup textfield nopol
		nopolField.setToolTipText("Masukan nomor polisi kendaraan ...");
		nopolField.setBounds(116, 11, 269, 32);
		nopolField.setColumns(10);
		
		
		// setup label untuk type
		lblType.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblType.setBounds(16, 60, 102, 18);
		
		// setup untuk radio button (movil dan motor)
		mobilRadio.setBounds(120, 59, 80, 23);
		motorRadio.setBounds(190, 59, 80, 23);
		kendaraanIn.setBackground(new Color(153, 255, 102));
		// set default radio 
		mobilRadio.setSelected(true);
		
		// setup button
		kendaraanIn.setBounds(10, 134, 428, 46);
		KendaraanOut.setBounds(10, 180, 428, 46);
		showTable.setBounds(10, 226, 428, 46);
		
		
		// me-add objek yang dibutuhkan kedalam panel	
		panel.add(lblType);
		panel.add(lblNopol);
		panel.add(nopolField);
		panel.add(mobilRadio);
		panel.add(motorRadio);
		
		// me-add panel ke container
		contentPane.add(panel);
		contentPane.add(KendaraanOut);
		contentPane.add(kendaraanIn);		
		contentPane.add(showTable);
		evHandler();
	}
	
	
	// ========== Method untuk Action Handling ===============
	protected void evHandler() {
		mobilRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				motorRadio.setSelected(false);
			}
		});
		motorRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mobilRadio.setSelected(false);
			}
		});	

		kendaraanIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nopol = nopolField.getText().equals("")? "Undifined" : nopolField.getText();
				String type = mobilRadio.isSelected()?"mobil":motorRadio.isSelected()?"motor":null;
				if(obj.tambahData(nopol, type) && !(nopol.toLowerCase().equals("undifined"))){
					JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
				}else{
					JOptionPane.showMessageDialog(null, "Data tidak berhasil ditambahkan!");
				}
			}
		});

		KendaraanOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nopol = nopolField.getText();
				String type = mobilRadio.isSelected()?"mobil":motorRadio.isSelected()?"motor":null;
				int [] dt = obj.keluar(nopol, type);
				if(dt[0] != 0){
					Kendaraan that = obj.search(nopol, type);
					String[] keluar = that.generateTime();
					JOptionPane.showMessageDialog(null, "========= Invoice =========\n"+
														"Nomor Polisi : "+that.nopol+
														"\nType		  : "+that.type+
														"\nMasuk	: "+that.tglMasuk+" "+that.jamMasuk+
														"\nKeluar	: "+keluar[0]+" "+keluar[1]+
														"\nDurasi	:"+dt[1]+" jam, "+dt[2]+" menit"+
														"\nTarif		: Rp."+dt[0]+
														"\n========================");
					obj.deleteData(nopol, type);
				}else{
					JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
				}
				
			}
		});

		showTable.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// memperbarui tabel
				frame = new Table(obj.field);
				frame.setBounds(200, 100, 350, 400);
				frame.setVisible(true);
			}
		});
		
		
	}
}
