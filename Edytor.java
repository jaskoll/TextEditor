import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Edytor extends JFrame implements ActionListener, KeyListener{
	JMenu[] menu = {new JMenu("Plik"), new JMenu("Pomoc"), new JMenu("Edycja")};
	JMenuItem[] items = { new JMenuItem("Otwórz"), 
						  new JMenuItem("Zapisz"), new JMenuItem("WyjdŸ"), new JMenuItem("Opis"), new JMenuItem("Autor"), 
						  new JMenuItem("Kopiuj"), new JMenuItem("Wklej"), new JMenuItem("Wytnij")
						};
	JPanel panel=new JPanel();
	JButton wczytaj = new JButton("Otwórz");
	JButton zapisz = new JButton("Zapisz");
	JButton autor = new JButton("Autor");
	String rodzaj[] = {"Times New Roman", "Arial", "Calibri", "Verdana"};
	String rozmiar[] = {"12", "14", "16", "18"};
	String kolory[] = {"Czarny", "Czerwony", "Niebieski", "¯ó³ty"};
	JComboBox<String> czcionka = new JComboBox<>(rodzaj);
	JComboBox<String> wielkosc = new JComboBox<>(rozmiar);
	JComboBox<String> kolor = new JComboBox<>(kolory);
	JTextArea pole_tekstowe = new JTextArea(20,20);
	JScrollPane pole_tekstowe1 = new JScrollPane(pole_tekstowe);
	private static final long serialVersionUID = 1L;

	Edytor(){
		super("Edytor tekstowy");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < items.length; i++)
	      	items[i].addActionListener(this);
			menu[0].add(items[0]);
			menu[0].add(items[1]);
			menu[0].add(items[2]);
			menu[1].add(items[3]);
			menu[1].add(items[4]);
			menu[2].add(items[5]);
			menu[2].add(items[6]);
			menu[2].add(items[7]);
		JMenuBar menubar = new JMenuBar();
		      for (int i = 0; i < menu.length; i++)
		      menubar.add(menu[i]);
		      setJMenuBar(menubar);	
		      
		
		panel.setLayout(null);
		pole_tekstowe.setLineWrap(true);
		
		panel.setFocusable(true);
		
		
		
		panel.add(wczytaj);
		wczytaj.addActionListener(this);
		
		panel.add(zapisz);
		zapisz.addActionListener(this);
		panel.add(autor);
		autor.addActionListener(this);
		panel.add(pole_tekstowe1);
		panel.add(czcionka);
		czcionka.addActionListener(this);
		czcionka.setSelectedIndex(0);
		panel.add(wielkosc);
		wielkosc.addActionListener(this);
		wielkosc.setSelectedIndex(0);
		panel.add(kolor);
		kolor.addActionListener(this);
		kolor.setSelectedIndex(0);
		panel.addKeyListener(this);
		
	    
		
		
		
		pole_tekstowe1.setBounds(10, 40, 565, 450);
		autor.setBounds(10, 10, 70, 20);
		zapisz.setBounds(90, 10, 80, 20);
		wczytaj.setBounds(180, 10, 80, 20);
		czcionka.setBounds(270, 10, 140, 20);
		wielkosc.setBounds(420, 10, 50, 20);
		kolor.setBounds(480, 10, 100, 20);
		
		
		setContentPane(panel);
		setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo=e.getSource();
		
		int t = czcionka.getSelectedIndex();
        int t1 = wielkosc.getSelectedIndex();
        int t2 = kolor.getSelectedIndex();

       if(zrodlo==zapisz){
			zapisz();
			
		}
		if(zrodlo==wczytaj){
			wczytaj();
			
		}
		if(zrodlo==autor){
			JOptionPane.showMessageDialog(this, "Jakub Jaskó³a");
			
		}
		if(zrodlo==items[0]){
			wczytaj();
		}
		if(zrodlo==items[1]){
			zapisz();
		}
		if(zrodlo==items[2]){
			System.exit(0);
		}
		if(zrodlo==items[3]){
			JOptionPane.showMessageDialog(this, " OPIS PROGRAMU \n Skróty klawiszowe: \n ALT+S - Zapis do pliku\n ALT+O - Otwieranie pliku\n(Skróty dzia³aj¹ po odpaleniu programu, ale kiedy klikniemy ju¿ w pole tekstowe focus ustawia siê na polu tekstowym,\n focus wraca po nacisnieciu jakiegos buttona)");
		}
		if(zrodlo==items[4]){
			JOptionPane.showMessageDialog(this, "Jakub Jaskó³a");
		}
		if(zrodlo==items[5]){
			pole_tekstowe.copy();
		}
		if(zrodlo==items[6]){
			pole_tekstowe.paste();
		}
		if(zrodlo==items[7]){
			pole_tekstowe.cut();
		}
		if(t==0){
			Font timesNewRomanFont = new Font("Times New Roman", Font.PLAIN, 14);
            pole_tekstowe.setFont(timesNewRomanFont);
       }  
        if(t==1) {
        	Font arialFont = new Font("Arial", Font.PLAIN, 14);
            pole_tekstowe.setFont(arialFont);
        }
        if(t==2) {
        	Font calibriFont = new Font("Calibri", Font.PLAIN, 14);
            pole_tekstowe.setFont(calibriFont);
        }
        if(t==3) {
        	Font verdanaFont = new Font("Verdana", Font.PLAIN, 14);
            pole_tekstowe.setFont(verdanaFont);
        }
        if(t1==0){
        	Font f = pole_tekstowe.getFont();
            pole_tekstowe.setFont(f.deriveFont(12.0f));
        }
        if(t1==1){
        	Font f = pole_tekstowe.getFont();
            pole_tekstowe.setFont(f.deriveFont(14.0f));
        }
        
        if(t1==2){
        	Font f = pole_tekstowe.getFont();
            pole_tekstowe.setFont(f.deriveFont(16.0f));
        }
        if(t1==3){
        	Font f = pole_tekstowe.getFont();
            pole_tekstowe.setFont(f.deriveFont(18.0f));
        }
        if(t2==0){
        	Font f = pole_tekstowe.getFont();
        	pole_tekstowe.setFont(f);
        	pole_tekstowe.setForeground(Color.BLACK);
        }
        if(t2==1){
        	Font f = pole_tekstowe.getFont();
        	pole_tekstowe.setFont(f);
        	pole_tekstowe.setForeground(Color.RED);
        }
        
        if(t2==2){
        	Font f = pole_tekstowe.getFont();
        	pole_tekstowe.setFont(f);
        	pole_tekstowe.setForeground(Color.BLUE);
        }
        if(t2==3){
        	Font f = pole_tekstowe.getFont();
        	pole_tekstowe.setFont(f);
        	pole_tekstowe.setForeground(Color.YELLOW);
        }
        panel.requestFocus();
	}
	
	

		public void wczytaj(){
			JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);
            String tekst = "";
            File plik = fc.getSelectedFile();
            String linia;
            
            try {
                BufferedReader br = new BufferedReader(new FileReader(plik));
                do {
                	 linia = br.readLine();
                    if (linia != null)
                        tekst += linia + "\n";
                } while (linia != null);
                br.close();
                pole_tekstowe.setText(tekst);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
		}
		
		public void zapisz(){
			 String linia;
             
             JFileChooser fc = new JFileChooser();
             fc.showSaveDialog(null);
             linia = pole_tekstowe.getText();
             File plik = fc.getSelectedFile();

             try {
                 BufferedWriter bw = new BufferedWriter(new FileWriter(plik+".txt"));
                 bw.write(linia);
                 bw.flush();
                 bw.close();

             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
			
			
			
		}

		@Override
		public void keyPressed(KeyEvent kevt) {
			if(kevt.getKeyChar()=='s') {
				  if(kevt.isAltDown()){
					  
					  zapisz();
				  }
			}
			if(kevt.getKeyChar()=='o') {
					  if(kevt.isAltDown()){
						  wczytaj();
					  }  
				  
				  
			}
			
			
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyTyped(KeyEvent kevt) {
			
			
		}	
	

public static void main(String[] args) {
	new Edytor();
	
}


}
	












