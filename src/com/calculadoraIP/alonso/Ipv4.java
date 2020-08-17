package com.calculadoraIP.alonso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ipv4 extends JFrame {

	private JPanel contentPane;
	private JTextField octeto1;
	private JTextField octeto2;
	private JTextField octeto3;
	private JTextField octeto4;
	private JLabel lblMascaraDeSubred;
	private JLabel lblTipoRed;
	private JLabel lblClase;
	private JButton btnNewButton;
	private JLabel lblTr;
	private JLabel lblError;
	private JLabel lblCls;
	private JLabel mascaraDecimal;
	private JLabel lblRed;
	private JLabel redD;
	private JLabel lblBroadcast;
	private JLabel BroadD;
	private JLabel lblRango;
	private JLabel rang;
	private JLabel lblHosts;
	private JLabel lblRedes;
	private JLabel redes_1;
	private JLabel prefijo;
	private JTextField hosts_1;
	
	/**
	 * Create the frame.
	 */
	public Ipv4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		octeto1 = new JTextField();
		octeto1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		octeto1.setBounds(171, 36, 58, 29);
		contentPane.add(octeto1);
		octeto1.setColumns(10);
		
		octeto2 = new JTextField();
		octeto2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		octeto2.setColumns(10);
		octeto2.setBounds(239, 36, 58, 29);
		contentPane.add(octeto2);
		
		octeto3 = new JTextField();
		octeto3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		octeto3.setColumns(10);
		octeto3.setBounds(307, 36, 58, 29);
		contentPane.add(octeto3);
		
		octeto4 = new JTextField();
		octeto4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		octeto4.setColumns(10);
		octeto4.setBounds(375, 36, 58, 29);
		contentPane.add(octeto4);
		
		JLabel lblDireccionIP = new JLabel("Direccion IP");
		lblDireccionIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccionIP.setBounds(10, 39, 139, 23);
		contentPane.add(lblDireccionIP);
		
		lblMascaraDeSubred = new JLabel("Mascara de Subred");
		lblMascaraDeSubred.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMascaraDeSubred.setBounds(10, 92, 139, 23);
		contentPane.add(lblMascaraDeSubred);
		
		lblTipoRed = new JLabel("Tipo de Red");
		lblTipoRed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoRed.setBounds(10, 168, 111, 29);
		contentPane.add(lblTipoRed);
		
		lblClase = new JLabel("Clase");
		lblClase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClase.setBounds(10, 214, 111, 29);
		contentPane.add(lblClase);
		
		btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String error = "";
				
				
				
				
				
				Ip4c ip = new Ip4c();
				if (octeto1.getText().isEmpty() || octeto2.getText().isEmpty() || octeto3.getText().isEmpty() || octeto4.getText().isEmpty()) {
					error="Direccion Ip Incorrecta";
				}
				else {
					int oct1 = Integer.parseInt(octeto1.getText());
					int oct2 = Integer.parseInt(octeto2.getText());
					int oct3 = Integer.parseInt(octeto3.getText());
					int oct4 = Integer.parseInt(octeto4.getText());
					
							
					ip.setOct1(oct1);
					ip.setOct2(oct2);
					ip.setOct3(oct3);
					ip.setOct4(oct4);
				}
				
				/*
				if (!prefijo.getText().isEmpty()) {
					
					
					int pre = Integer.parseInt(prefijo.getText());
					
											
					ip.setPre(pre);
					
					
										
				}
				else if (prefijo.getText().isEmpty()) {
					error = "Mascara de subred no introducida";
					lblError.setForeground(new Color(0, 0, 255));
				}
				
				*/
				int host = Integer.parseInt(hosts_1.getText());
				int pre = 0;
			
				if(hosts_1.getText().isEmpty()) {
					error = "coloque la cantidad de hosts requeridos";
				}
				else if(host == 0 || host > 2147483646) {
					error = "coloque un numero de hosts valido";
				}
				else if(host == 1 ) {
					pre = 32;
					ip.setPre(32);
				}
				else if(host == 2 ) {
					pre = 30;
					ip.setPre(30);
				}
				else if(host < 7 ) {
					pre = 29;
					ip.setPre(29);
				}
				else if(host < 15 ) {
					pre = 28;
					ip.setPre(28);
				}
				else if(host < 31 ) {
					pre = 27;
					ip.setPre(27);
				}
				else if(host < 63 ) {
					pre = 26;
					ip.setPre(26);
				}
				else if(host < 127 ) {
					pre = 25;
					ip.setPre(25);
				}
				else if(host < 255 ) {
					pre = 24;
					ip.setPre(24);
				}
				else if(host < 511 ) {
					pre = 23;
					ip.setPre(23);
				}
				else if(host < 1023 ) {
					pre = 22;
					ip.setPre(22);
				}
				else if(host < 2047 ) {
					pre = 21;
					ip.setPre(21);
				}
				else if(host < 4095 ) {
					pre = 20;
					ip.setPre(20);
				}
				else if(host < 8191 ) {
					pre = 19;
					ip.setPre(19);
				}
				else if(host < 16383 ) {
					pre = 18;
					ip.setPre(18);
				}
				else if(host < 32767 ) {
					pre = 17;
					ip.setPre(17);
				}
				else if(host < 65535 ) {
					pre = 16;
					ip.setPre(16);
				}
				else if(host < 131071 ) {
					pre = 15;
					ip.setPre(15);
				}
				else if(host < 26243 ) {
					pre = 14;
					ip.setPre(14);
				}
				else if(host < 524287 ) {
					pre = 13;
					ip.setPre(13);
				}
				else if(host < 1048575 ) {
					pre = 12;
					ip.setPre(12);
				}
				else if(host < 2097151 ) {
					pre = 11;
					ip.setPre(11);
				}
				else if(host < 4194303 ) {
					pre = 10;
					ip.setPre(10);
				}
				else if(host < 8388607 ) {
					pre = 9;
					ip.setPre(9);
				}
				else if(host < 16777215 ) {
					pre = 8;
					ip.setPre(8);
				}
				else if(host < 33554431 ) {
					pre = 7;
					ip.setPre(7);
				}
				else if(host < 67108863 ) {
					pre = 6;
					ip.setPre(6);
				}
				else if(host < 134217727 ) {
					pre = 5;
					ip.setPre(5);
				}
				else if(host < 268435455 ) {
					pre = 4;
					ip.setPre(4);
				}
				else if(host < 536870911 ) {
					pre = 3;
					ip.setPre(3);
				}
				else if(host < 107374823 ) {
					pre = 2;
					ip.setPre(2);
				}
				else if(host < 2147483647 ) {
					pre = 1;
					ip.setPre(1);
				}
				
				
			
				
				ArrayList tipoIp = new ArrayList();
				tipoIp = ip.tipoIp(ip);
								
				lblTr.setText(tipoIp.get(0).toString());
				lblCls.setText(tipoIp.get(1).toString());
				mascaraDecimal.setText(tipoIp.get(4).toString());
				redD.setText(tipoIp.get(3).toString());
				BroadD.setText(tipoIp.get(5).toString());
				rang.setText(tipoIp.get(6).toString());
				redes_1.setText(tipoIp.get(8).toString());
				prefijo.setText(Integer.toString(pre));
				
				String er =tipoIp.get(2).toString();
				if (!er.isEmpty()) {
					error = er;
				}
				lblError.setText(error);
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(441, 50, 104, 41);
		contentPane.add(btnNewButton);
		
		lblTr = new JLabel("");
		lblTr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTr.setBounds(171, 171, 314, 23);
		contentPane.add(lblTr);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setBounds(171, 11, 276, 14);
		contentPane.add(lblError);
		
		lblCls = new JLabel("");
		lblCls.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCls.setBounds(171, 214, 314, 23);
		contentPane.add(lblCls);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 95, 15, 17);
		contentPane.add(lblNewLabel);
		
		mascaraDecimal = new JLabel("");
		mascaraDecimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mascaraDecimal.setBounds(171, 128, 314, 29);
		contentPane.add(mascaraDecimal);
		
		lblRed = new JLabel("Red");
		lblRed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRed.setBounds(10, 254, 111, 29);
		contentPane.add(lblRed);
		
		redD = new JLabel("");
		redD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		redD.setBounds(171, 254, 314, 23);
		contentPane.add(redD);
		
		lblBroadcast = new JLabel("Broadcast");
		lblBroadcast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBroadcast.setBounds(10, 298, 111, 29);
		contentPane.add(lblBroadcast);
		
		BroadD = new JLabel("");
		BroadD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BroadD.setBounds(171, 298, 314, 23);
		contentPane.add(BroadD);
		
		lblRango = new JLabel("Rango");
		lblRango.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRango.setBounds(10, 338, 111, 29);
		contentPane.add(lblRango);
		
		rang = new JLabel("");
		rang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rang.setBounds(171, 338, 314, 23);
		contentPane.add(rang);
		
		lblHosts = new JLabel("Hosts");
		lblHosts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHosts.setBounds(39, 393, 111, 29);
		contentPane.add(lblHosts);
		
		lblRedes = new JLabel("Redes");
		lblRedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRedes.setBounds(307, 393, 111, 29);
		contentPane.add(lblRedes);
		
		redes_1 = new JLabel("");
		redes_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		redes_1.setBounds(360, 393, 94, 23);
		contentPane.add(redes_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(158, 108, 28, 0);
		contentPane.add(label);
		
		prefijo = new JLabel("");
		prefijo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prefijo.setBounds(171, 92, 46, 25);
		contentPane.add(prefijo);
		
		hosts_1 = new JTextField();
		hosts_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hosts_1.setBounds(100, 393, 169, 26);
		contentPane.add(hosts_1);
		hosts_1.setColumns(10);
		
		setVisible(true);
	}
}
