package com.example;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class iSurvivor {

	private JFrame frame;
	private JTextField ServerPort;
	BufferedImage cellimg;
	BufferedImage playerimg;
	int gt=0;
	/*Casas: [Index] [Informações]
	*0=indice componente
	*2=tipocasa
	*3=level construção
	*4=loot ativo
	*5=quantialoot
	*/
	private int[][] tabuleiro=new int[50][6];
	Tabuleiro tab;
	cartas baralho;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iSurvivor window = new iSurvivor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public iSurvivor() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1552, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Servidor porta:");
		lblNewLabel.setBounds(1431, 11, 95, 14);
		frame.getContentPane().add(lblNewLabel);
		
		ServerPort = new JTextField();
		ServerPort.setBounds(1431, 34, 86, 20);
		frame.getContentPane().add(ServerPort);
		ServerPort.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBounds(23, 52, 773, 552);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {50, 50, 50, 50, 50, 50, 50, 50,50, 50, 50, 50,50};
		gbl_panel.rowHeights = new int[] {50, 50, 50, 50,50, 50, 50, 50,50, 50};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		 cellimg = ImageIO.read(this.getClass().getResource("imgs/cell.png"));
		 playerimg = ImageIO.read(this.getClass().getResource("imgs/player.png"));
	

		/*Exemplos de criando grid manualmente
		JLabel lb1 = new JLabel(new ImageIcon(cellimg));
		GridBagConstraints gbc_lb1 = new GridBagConstraints();
		gbc_lb1.insets = new Insets(0, 0, 5, 5);
		gbc_lb1.gridx = 0;
		gbc_lb1.gridy = 0;
		
		
		panel.add(lb1, gbc_lb1);
		
		JLabel lb2 = new JLabel(new ImageIcon(cellimg));
		GridBagConstraints gbc_lb2 = new GridBagConstraints();
		gbc_lb2.insets = new Insets(0, 0, 5, 5);
		gbc_lb2.gridx =1;
		gbc_lb2.gridy = 0;
		
		panel.add(lb2, gbc_lb2);
		
		*/
		
		/*GridBagConstraints(int gridx, int gridy,
                              int gridwidth, int gridheight,
                              double weightx, double weighty,
                              int anchor, int fill,
                              Insets insets, int ipadx, int ipady)*/
		//panel.add((new JLabel(new ImageIcon(cellimg)) ),(new GridBagConstraints(GridBagConstraints.RELATIVE,GridBagConstraints.RELATIVE,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,(new Insets(0, 0, 5, 5)),0,0)));
		for(int j=0;j<=10;j++) {
			for(int i=0;i<=13;i++) {
				if(i==0||j==0||i==13||j==10) { //Cria só o campo dos cantos
					panel.add((new JLabel(new ImageIcon(cellimg)) ),(new GridBagConstraints(i,j,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,(new Insets(0, 0, 5, 5)),0,0)));
					
				
				}
			}
		}
		//side
		int count=0;
		for(int i=13;i>=0;i--) {
			tabuleiro[count][0]=i;
			count++;
		}
		tabuleiro[14][0]=14;
		count=15;
		for(int i=18;i<=30;i=i+2) {
			tabuleiro[count][0]=i;
			count++;
		}
		//count=22;
		//tabuleiro[22][0]=32;
		for(int i=32;i<=45;i++) {
			tabuleiro[i-10][0]=i;
		}
		
		tabuleiro[43][0]=15;
		count=42;
		for(int i=19;i<=31;i=i+2) {
			tabuleiro[count][0]=i;
			count--;
		}
		
		//Coloca o tabuleiro gerado na classe apropriada tab
		tab=new Tabuleiro(this.tabuleiro);
		baralho=new cartas();
		
		//Teste
	/*	int a= tab.getTipo(7);
		if(a>0){
			int card=baralho.randomPullNum(a);
			lblNewLabel.setText(baralho.printCard(card));
		}

	*/	
		
		
		
		JButton btnRodarDado = new JButton("Rodar Dado");
		btnRodarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	 Codigo de andar 1 casa
				Component temp = panel.getComponent(tabuleiro[gt][0]);
				((JLabel) temp).setIcon(new ImageIcon(cellimg));
				gt=gt+1;
				if(gt>43) {
					gt=0;
				}
				temp = panel.getComponent(tabuleiro[gt][0]);
				((JLabel) temp).setIcon(new ImageIcon(playerimg));*/
				Component temp = panel.getComponent(tabuleiro[gt][0]);
				((JLabel) temp).setIcon(new ImageIcon(cellimg));
				gt=gt+((int)(Math.random() * 6) + 1); //Roda dado de 1 a 6
				if(gt>43) {
					gt=gt-43; //Caso passe da casa 43, então reduz 43 ao valor, simulando começar novamente pela casa 0
				}
				temp = panel.getComponent(tabuleiro[gt][0]); //Reposiciona jogador
				((JLabel) temp).setIcon(new ImageIcon(playerimg));

			}
		});
		btnRodarDado.setBounds(1256, 173, 261, 23);
		frame.getContentPane().add(btnRodarDado);
	}
}
