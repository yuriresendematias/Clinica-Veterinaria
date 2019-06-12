package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.FachadaVeterinario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioVeterinario extends JFrame {

	private JPanel contentPane;
	private FachadaVeterinario veterinario;

	/**
	 * Create the frame.
	 */
	public InicioVeterinario(FachadaVeterinario v) {
		this.veterinario = v;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovoRecepcionista = new JButton("Novo recepcionista");
		btnNovoRecepcionista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroFuncionario(veterinario, 1).setVisible(true);
				dispose();
			}
		});
		btnNovoRecepcionista.setBounds(150, 104, 125, 23);
		contentPane.add(btnNovoRecepcionista);
		
		JButton btnNovoVeterinario = new JButton("Novo Veterinario");
		btnNovoVeterinario.setBounds(150, 138, 125, 23);
		contentPane.add(btnNovoVeterinario);
		
		JButton btnNovoProcedimento = new JButton("Novo procedimento");
		btnNovoProcedimento.setBounds(150, 172, 125, 23);
		contentPane.add(btnNovoProcedimento);
		
		JButton btnNewButton = new JButton("Agenda");
		btnNewButton.setBounds(150, 70, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(150, 206, 125, 23);
		contentPane.add(btnNewButton_1);
	}

}
