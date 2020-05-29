package com.rohandsouza.chatapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JLabel lblIpAddress;
	private JLabel lblPortDesc;
	private JTextField txtPort;
	private JLabel lblAddressDesc;
	private JLabel lbleg_1;

	public Login() {
		setLocation(0, -56);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 380);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(55, 41, 183, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setForeground(new Color(240, 248, 255));
		lblName.setBackground(new Color(100, 149, 237));
		lblName.setBounds(120, 16, 54, 20);
		contentPane.add(lblName);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(55, 115, 183, 26);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblIpAddress = new JLabel("Ip Address");
		lblIpAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIpAddress.setForeground(new Color(240, 248, 255));
		lblIpAddress.setBounds(103, 91, 87, 20);
		contentPane.add(lblIpAddress);
		
		lblPortDesc = new JLabel("Port");
		lblPortDesc.setForeground(new Color(240, 248, 255));
		lblPortDesc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPortDesc.setBounds(129, 182, 35, 20);
		contentPane.add(lblPortDesc);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(55, 208, 183, 26);
		contentPane.add(txtPort);
		
		lblAddressDesc = new JLabel("(eg: 192.168.0.2)");
		lblAddressDesc.setBounds(80, 145, 133, 20);
		contentPane.add(lblAddressDesc);
		
		lbleg_1 = new JLabel("(eg: 8192)");
		lbleg_1.setBounds(109, 239, 76, 20);
		contentPane.add(lbleg_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setForeground(new Color(0, 139, 139));
		btnLogin.setBackground(Color.RED);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
			}
		});
		btnLogin.setBounds(89, 295, 115, 29);
		contentPane.add(btnLogin);
	}
	
	private void login(String name, String address, int port)
	{
		dispose();
		new ClientWindow(name, address, port);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
