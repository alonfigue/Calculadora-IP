package com.calculadoraIP.alonso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("IPv4");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Ipv4();
			}
		});
		btnNewButton.setBounds(92, 73, 89, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("IPv6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//new Ipv6();
			}
		});
		btnNewButton_1.setBackground(new Color(106, 90, 205));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(252, 73, 89, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Historial");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DB db = DB.getInstances();
				String query = "SELECT * FROM ip4";
				ResultSet rs = db.dbStatementimp(query);
				String msj = new String();
				
				try {
					while (rs.next()) {
						msj += "\n\n Id # "+rs.getString(1)+"\n Fecha: "+rs.getString(10)+"\n IP: "+rs.getString(2)+"\n Mascara de Subred: "+rs.getString(3)+"\n Tipo: "+rs.getString(4)+"\n Clase: "+rs.getString(5)+"\n Red: "+rs.getString(6)+"\n Broadcast: "+rs.getString(7)+"\n Rango de IP: "+rs.getString(8)+"\n Hosts: "+rs.getString(9)+".\n";
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
	                try {
	                   
	                    rs.close();
	                    
	                } catch (SQLException a2) {
	                	a2.printStackTrace();
	                }
				}
				Historial hist = new Historial(msj);
			}
		});
		btnNewButton_2.setBounds(173, 169, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Calculadora IP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(164, 11, 128, 35);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
	}
}
