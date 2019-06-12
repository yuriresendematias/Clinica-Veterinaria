package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.PessoaNaoCadastradoException;
import fachada.FachadaRecepcionista;
import negocio.Cliente;
import negocio.Veterinario;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaVeterinarios extends JFrame {
	private FachadaRecepcionista recepcionista;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ListaVeterinarios(FachadaRecepcionista r) {
		this.recepcionista = r;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		list.setBounds(85, 11, 325, 205);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Avan\u00E7ar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = list.getSelectedValue().toString();
					String cpf = s.substring(s.indexOf("CPF: ")+5);
					new AgendaVeterinario(recepcionista, cpf).setVisible(true);;
					dispose();				
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"ERRO ao pesquisar cliente!");
				}
				//ir para agenda do veterinario (uma lista com os procedimentos marcados)
			}
		});
		btnNewButton.setBounds(222, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblProficionais = new JLabel("Proficionais:");
		lblProficionais.setBounds(10, 12, 65, 14);
		contentPane.add(lblProficionais);
		
		
		//adicionando os nomes dos veterinarios na lista INICIO
		DefaultListModel lista = new DefaultListModel<>();
		
		
		for(Veterinario v : r.listarVeterinarios()) {	
				lista.addElement(v.getNome() + "                CPF: " +v.getCpf());
		}
				
		list.setModel(lista);
		//FIM
	}

}
