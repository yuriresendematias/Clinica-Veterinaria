package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.FachadaRecepcionista;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {
	private FachadaRecepcionista recepcionista;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Create the frame.
	 */
	public CadastroCliente(FachadaRecepcionista r) {
		recepcionista = r;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 29, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 54, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(229, 54, 99, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 79, 46, 14);
		contentPane.add(lblTelefone);
		
		textField = new JTextField();
		textField.setBounds(66, 26, 358, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 51, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(338, 51, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 76, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 117, 59, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(213, 148, 211, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(213, 117, 211, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 120, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(135, 120, 68, 14);
		contentPane.add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(135, 151, 46, 14);
		contentPane.add(lblBairro);
		
		textField_7 = new JTextField();
		textField_7.setBounds(66, 179, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 176, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblN = new JLabel("n\u00BA:");
		lblN.setBounds(10, 151, 46, 14);
		contentPane.add(lblN);
		
		textField_8 = new JTextField();
		textField_8.setBounds(66, 148, 59, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(213, 79, 59, 14);
		contentPane.add(lblEndereo);
		
		textField_9 = new JTextField();
		textField_9.setBounds(213, 179, 99, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(373, 179, 51, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(66, 210, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(162, 182, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(317, 179, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setBounds(10, 213, 46, 14);
		contentPane.add(lblPais);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(239, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InicioRecepcionista(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
