package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.PessoaJaCadastradaException;
import excecoes.PessoaNaoCadastradoException;
import fachada.FachadaRecepcionista;
import negocio.Cliente;
import negocio.Endereco;
import util.Datas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Formatter;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {
	private FachadaRecepcionista recepcionista;
	private Cliente cliente;
	private JPanel contentPane;
	private JTextField nomeCLienteTf;
	private JTextField cpfTf;
	private JTextField dnTf;
	private JTextField foneTf;
	private JTextField tipoTf;
	private JTextField bairroTf;
	private JTextField logradouroTf;
	private JTextField cepTf;
	private JTextField numTf;
	private JTextField cidadeTf;
	private JTextField estadoTf;
	private JTextField paisTf;

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
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 39, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(229, 39, 99, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 64, 46, 14);
		contentPane.add(lblTelefone);
		
		nomeCLienteTf = new JTextField();
		nomeCLienteTf.setBounds(66, 11, 358, 20);
		contentPane.add(nomeCLienteTf);
		nomeCLienteTf.setColumns(10);
		
		cpfTf = new JTextField();
		cpfTf.setBounds(66, 36, 86, 20);
		contentPane.add(cpfTf);
		cpfTf.setColumns(10);
		
		dnTf = new JTextField();
		dnTf.setBounds(338, 36, 86, 20);
		contentPane.add(dnTf);
		dnTf.setColumns(10);
		
		foneTf = new JTextField();
		foneTf.setBounds(66, 61, 86, 20);
		contentPane.add(foneTf);
		foneTf.setColumns(10);
		
		tipoTf = new JTextField();
		tipoTf.setBounds(66, 106, 59, 20);
		contentPane.add(tipoTf);
		tipoTf.setColumns(10);
		
		bairroTf = new JTextField();
		bairroTf.setBounds(213, 137, 211, 20);
		contentPane.add(bairroTf);
		bairroTf.setColumns(10);
		
		logradouroTf = new JTextField();
		logradouroTf.setBounds(213, 106, 211, 20);
		contentPane.add(logradouroTf);
		logradouroTf.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 109, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(135, 109, 68, 14);
		contentPane.add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(135, 140, 46, 14);
		contentPane.add(lblBairro);
		
		cepTf = new JTextField();
		cepTf.setBounds(66, 168, 86, 20);
		contentPane.add(cepTf);
		cepTf.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 165, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblN = new JLabel("n\u00BA:");
		lblN.setBounds(10, 140, 46, 14);
		contentPane.add(lblN);
		
		numTf = new JTextField();
		numTf.setBounds(66, 137, 59, 20);
		contentPane.add(numTf);
		numTf.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 92, 59, 14);
		contentPane.add(lblEndereo);
		
		cidadeTf = new JTextField();
		cidadeTf.setBounds(213, 168, 99, 20);
		contentPane.add(cidadeTf);
		cidadeTf.setColumns(10);
		
		estadoTf = new JTextField();
		estadoTf.setBounds(373, 168, 51, 20);
		contentPane.add(estadoTf);
		estadoTf.setColumns(10);
		
		paisTf = new JTextField();
		paisTf.setBounds(66, 199, 86, 20);
		contentPane.add(paisTf);
		paisTf.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(162, 171, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(317, 168, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setBounds(10, 202, 46, 14);
		contentPane.add(lblPais);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					recepcionista.cadastrarCliente(nomeCLienteTf.getText(), cpfTf.getText(), foneTf.getText(),
							Datas.parseDate(dnTf.getText()), tipoTf.getText(), logradouroTf.getText(), numTf.getText(), bairroTf.getText(), cepTf.getText(), cidadeTf.getText(), estadoTf.getText(), paisTf.getText());
					
					new InicioRecepcionista(recepcionista).setVisible(true);
					dispose();
				} catch (PessoaJaCadastradaException e1) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado no sistema!");
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Dados invalidos!");
				}
				
			
			}
		});
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
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cliente == null) {
					btnAtualizar.setEnabled(false);
				}else {
					Endereco end = new Endereco(tipoTf.getText(), logradouroTf.getText(),
											numTf.getText(), bairroTf.getText(), cepTf.getText(),
											cidadeTf.getText(), estadoTf.getText(), paisTf.getText());
							
					Cliente novo;
					try {
						novo = recepcionista.pesquisarCliente(cpfTf.getText());
						novo.setEnd(end);
						novo.setNome(nomeCLienteTf.getText());
						novo.setTelefone(foneTf.getText());
						
						recepcionista.atualizarCliente(novo);
						
						new TelaCliente(novo, recepcionista).setVisible(true);
						dispose();
						
						
					} catch (PessoaNaoCadastradoException e1) {
						JOptionPane.showMessageDialog(null, "Nao foi possível efetuar a atualização!\nO cliente nao esta cadastrado no sistema!");
					}
					
				}
			}
		});
		btnAtualizar.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtualizar);
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
		LocalDate data = cliente.getDataNascimento();
		Endereco e = cliente.getEnd();
		
		this.nomeCLienteTf.setText(cliente.getNome());
		
		this.cpfTf.setText(cliente.getCpf());
		this.cpfTf.setEditable(false);		
		
		this.dnTf.setText(Datas.parseDate(cliente.getDataNascimento()));
		this.dnTf.setEditable(false);
		
		this.foneTf.setText(cliente.getTelefone());
		this.tipoTf.setText(e.getTipo());
		this.logradouroTf.setText(e.getNome());
		this.numTf.setText(e.getNum());
		this.cepTf.setText(e.getCep());
		this.bairroTf.setText(e.getBairro());
		this.cidadeTf.setText(e.getCidade());
		this.estadoTf.setText(e.getEstado());
		this.paisTf.setText(e.getPais());

	}
}
