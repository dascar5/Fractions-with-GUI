import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Forma extends JFrame {

	private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField rz1br,rz1im,rz2br,rz2im;
	private JButton dugmeIzracunaj,dugmeZatvoriFormu;
	
	
	
	public Forma() throws HeadlessException {
		super("Razlomci - kalkulator");
		this.setSize(300,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		Font font = new Font("Times New Roman",Font.BOLD, 16);
		
		l1 = new JLabel("Prvi broj: ");
		l1.setFont(font);
		l1.setPreferredSize(new Dimension(100,20));
		l1.setAlignmentX(LEFT_ALIGNMENT);
		this.add(l1);
		
		rz1br = new JTextField();
		rz1br.setPreferredSize(new Dimension(30,20));
		rz1br.setFont(font);
		this.add(rz1br);
		
		l2 = new JLabel("/");
		l2.setFont(font);
		l2.setPreferredSize(new Dimension(100,20));
		l2.setAlignmentX(CENTER_ALIGNMENT);
		this.add(l2);
		
		rz1im = new JTextField();
		rz1im.setPreferredSize(new Dimension(30,20));
		rz1im.setFont(font);
		this.add(rz1im);
		
		l3 = new JLabel("Drugi broj: ");
		l3.setFont(font);
		l3.setPreferredSize(new Dimension(100,20));
		l3.setAlignmentX(LEFT_ALIGNMENT);
		this.add(l3);
		
		rz2br = new JTextField();
		rz2br.setPreferredSize(new Dimension(30,20));
		rz2br.setFont(font);
		this.add(rz2br);
		
		l4 = new JLabel("/");
		l4.setFont(font);
		l4.setPreferredSize(new Dimension(100,20));
		l4.setAlignmentX(CENTER_ALIGNMENT);
		this.add(l4);
		
		rz2im = new JTextField();
		rz2im.setPreferredSize(new Dimension(30,20));
		rz2im.setFont(font);
		this.add(rz2im);
		
		dugmeIzracunaj = new JButton("Izracunaj");
		dugmeIzracunaj.setFont(font);
		this.add(dugmeIzracunaj);
		dugmeIzracunaj.setPreferredSize(new Dimension(200,30));
		
		dugmeZatvoriFormu = new JButton("Zatvori");
		dugmeZatvoriFormu.setFont(font);
		this.add(dugmeZatvoriFormu);
		dugmeZatvoriFormu.setPreferredSize(new Dimension(200,30));
		
		l5 = new JLabel("Sabiranje");
		l5.setFont(font);
		l5.setPreferredSize(new Dimension(200,50));
		l5.setAlignmentX(LEFT_ALIGNMENT);
		this.add(l5);
		
		l6 = new JLabel("Oduzimanje");
		l6.setFont(font);
		l6.setPreferredSize(new Dimension(200,50));
		l6.setAlignmentX(LEFT_ALIGNMENT);
		this.add(l6);
		
		l7 = new JLabel("Mnozenje");
		l7.setFont(font);
		l7.setPreferredSize(new Dimension(200,50));
		l7.setAlignmentX(LEFT_ALIGNMENT);
		this.add(l7);
		
		l8 = new JLabel("Dijeljenje");
		l8.setFont(font);
		l8.setPreferredSize(new Dimension(200,50));
		l8.setAlignmentX(LEFT_ALIGNMENT);
		this.add(l8);
		
		ObradiDugmad obrada = new ObradiDugmad();
		dugmeIzracunaj.addActionListener(obrada);
		dugmeZatvoriFormu.addActionListener(obrada);
		
	}



	public static void main (String[]args) {
		Forma f = new Forma();
		f.setVisible(true);
	}
	private class ObradiDugmad implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==dugmeIzracunaj) {
				int razlomak1br = Integer.parseInt(rz1br.getText());
				int razlomak1im = Integer.parseInt(rz1im.getText());
				int razlomak2br = Integer.parseInt(rz2br.getText());
				int razlomak2im = Integer.parseInt(rz2im.getText());
				
				Razlomak r1 = new Razlomak(razlomak1br,razlomak1im);
				Razlomak r2 = new Razlomak(razlomak2br,razlomak2im);
				
				Razlomak rezS, rezO, rezM, rezD; //sabiranje, oduzimanje...
				rezS = Razlomak.saberi(r1, r2);
				rezO = Razlomak.oduzmi(r1, r2);
				rezM = Razlomak.pomnozi(r1, r2);
				rezD = Razlomak.podijeli(r1, r2);
				
				l5.setText("Sabiranje: " + rezS);
				l6.setText("Oduzimanje: " + rezO);
				l7.setText("Mnozenje: " + rezM);
				l8.setText("Dijeljenje: " + rezD);
				
				
			}
			if(e.getSource()==dugmeZatvoriFormu) {
				System.exit(EXIT_ON_CLOSE);
			}
		}
	}
}
