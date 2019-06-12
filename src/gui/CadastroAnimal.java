package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.PessoaNaoCadastradoException;
import fachada.FachadaRecepcionista;
import negocio.Cliente;
import util.Datas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CadastroAnimal extends JFrame {

	private JPanel contentPane;
	private FachadaRecepcionista recepcionista;
	private Cliente cliente;
	private JTextField nomeAnimalTf;
	private JTextField racaAnimalTf;
	private JTextField dnAnimalTf;


	/**
	 * Create the frame.
	 */
	public CadastroAnimal(FachadaRecepcionista r, Cliente c) {
		this.recepcionista = r;
		this.cliente = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 32, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a:");
		lblRaa.setBounds(10, 60, 46, 14);
		contentPane.add(lblRaa);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(223, 60, 105, 14);
		contentPane.add(lblDataDeNascimento);
		
		nomeAnimalTf = new JTextField();
		nomeAnimalTf.setBounds(48, 29, 376, 20);
		contentPane.add(nomeAnimalTf);
		nomeAnimalTf.setColumns(10);
		
		racaAnimalTf = new JTextField();
		racaAnimalTf.setBounds(48, 57, 86, 20);
		contentPane.add(racaAnimalTf);
		racaAnimalTf.setColumns(10);
		
		dnAnimalTf = new JTextField();
		dnAnimalTf.setBounds(338, 57, 86, 20);
		contentPane.add(dnAnimalTf);
		dnAnimalTf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LocalDate data = Datas.parseDate(dnAnimalTf.getText());
					recepcionista.cadastrarAnimal(cliente.getCpf(), nomeAnimalTf.getText(), racaAnimalTf.getText(), data);
					
					new TelaCliente(cliente, recepcionista).setVisible(true);
					dispose();
			
				} catch (PessoaNaoCadastradoException e1) {
					JOptionPane.showMessageDialog(null,"Cliente nao esta cadastrado no sistema!");
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Dados invalidos!");
				}
			}
		});
		btnCadastrar.setBounds(239, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCliente(cliente, recepcionista).setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
