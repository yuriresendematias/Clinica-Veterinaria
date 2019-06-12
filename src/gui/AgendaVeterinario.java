package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.FachadaRecepcionista;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgendaVeterinario extends JFrame {
	private FachadaRecepcionista recepcionista;
	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public AgendaVeterinario(FachadaRecepcionista r) {
		this.recepcionista = r;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 24, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(85, 21, 325, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InicioRecepcionista(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(321, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JList list = new JList();
		list.setBounds(85, 52, 325, 164);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(222, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblProficionais = new JLabel("Proficionais:");
		lblProficionais.setBounds(10, 49, 65, 14);
		contentPane.add(lblProficionais);
	}

}
