package gui;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.PessoaNaoCadastradoException;
import fachada.FachadaRecepcionista;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioRecepcionista extends JFrame {
	private FachadaRecepcionista recepcionista;
	private JPanel contentPane;
	private JTextField cpfTf;


	/**
	 * Create the frame.
	 */
	public InicioRecepcionista(FachadaRecepcionista r) {		
		this.recepcionista = r;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cpfTf = new JTextField();
		cpfTf.setBounds(147, 31, 130, 20);
		contentPane.add(cpfTf);
		cpfTf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cpfTf.getText().equals("")) {
					try {
						new TelaCliente(recepcionista.pesquisarCliente(cpfTf.getText()),recepcionista).setVisible(true);
						dispose();
					} catch (PessoaNaoCadastradoException e1) {
						JOptionPane.showMessageDialog(null, "Cliente nao cadastrado!");
					}	
				}
				
				else {
					new listaClientes(recepcionista).setVisible(true);
					dispose();
				}
			}
		});
		btnBuscar.setBounds(166, 62, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(166, 164, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroCliente(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(166, 96, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListaVeterinarios(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnAgenda.setBounds(166, 130, 89, 23);
		contentPane.add(btnAgenda);
		
		Label label = new Label("CPF:");
		label.setBounds(77, 29, 62, 22);
		contentPane.add(label);
	}
}
