package com.calculadoraIP.alonso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Historial extends JFrame {

	private JPanel contentPane;

	
	public Historial(String msj) {
		setTitle("Historial IP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 22, 345, 292);
		contentPane.add(textArea);
		textArea.setText(msj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 319, 273);
		contentPane.add(scrollPane);
		
		
		
		scrollPane.setViewportView(textArea);
		
		setVisible(true);
	}
}
