package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.FachadaRecepcionista;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listaClientes extends JFrame {
	private FachadaRecepcionista recepcionista;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public listaClientes(FachadaRecepcionista r) {
		this.recepcionista = r;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 48, 414, 162);
		contentPane.add(list);
		
		JLabel lblListaDeClientes = new JLabel("Lista de clientes:");
		lblListaDeClientes.setBounds(10, 21, 206, 14);
		contentPane.add(lblListaDeClientes);
		
		JButton btnNewButton = new JButton("Avan\u00E7ar");
		btnNewButton.setBounds(239, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InicioRecepcionista(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
