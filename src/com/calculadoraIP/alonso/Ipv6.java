package com.calculadoraIP.alonso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Ipv6 extends JFrame {

	private JPanel contentPane;
	private JTextField txtIp;
	private JLabel lblResult;

	
	/**
	 * Create the frame.
	 */
	public Ipv6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIp = new JTextField();
		txtIp.setBounds(72, 44, 286, 30);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		JButton btnNewButton = new JButton("verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ip6c ip6 = new Ip6c();
				
				ip6.setIpstr(txtIp.getText());
				
				String result = ip6.verificarIP(ip6);
				
				lblResult.setText(result);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(173, 85, 89, 23);
		contentPane.add(btnNewButton);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResult.setBounds(46, 152, 346, 30);
		contentPane.add(lblResult);
		
		setVisible(true);
	}
}
