package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.PessoaJaCadastradaException;
import fachada.FachadaVeterinario;
import negocio.Endereco;
import util.Datas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTf;
	private JTextField cpfTf;
	private JTextField foneTf;
	private JTextField tipoTf;
	private JTextField numTf;
	private JTextField paisTf;
	private JTextField cepTf;
	private JTextField logradouroTf;
	private JTextField bairroTf;
	private JTextField cidadeTf;
	private JTextField estadoTf;
	private JTextField dnTf;
	private JPasswordField senhaPf;
	private FachadaVeterinario veterinario;


	/**
	 * Create the frame.
	 */
	public CadastroFuncionario(FachadaVeterinario v, int op) {
		this.veterinario = v;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 14, 46, 14);
		contentPane.add(label);
		
		nomeTf = new JTextField();
		nomeTf.setColumns(10);
		nomeTf.setBounds(66, 11, 358, 20);
		contentPane.add(nomeTf);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setBounds(10, 39, 46, 14);
		contentPane.add(label_1);
		
		cpfTf = new JTextField();
		cpfTf.setColumns(10);
		cpfTf.setBounds(66, 36, 86, 20);
		contentPane.add(cpfTf);
		
		JLabel label_2 = new JLabel("Telefone:");
		label_2.setBounds(10, 64, 46, 14);
		contentPane.add(label_2);
		
		foneTf = new JTextField();
		foneTf.setColumns(10);
		foneTf.setBounds(66, 61, 86, 20);
		contentPane.add(foneTf);
		
		JLabel label_3 = new JLabel("Endere\u00E7o:");
		label_3.setBounds(10, 89, 59, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Tipo:");
		label_4.setBounds(10, 109, 46, 14);
		contentPane.add(label_4);
		
		tipoTf = new JTextField();
		tipoTf.setColumns(10);
		tipoTf.setBounds(66, 106, 59, 20);
		contentPane.add(tipoTf);
		
		JLabel label_5 = new JLabel("n\u00BA:");
		label_5.setBounds(10, 134, 46, 14);
		contentPane.add(label_5);
		
		numTf = new JTextField();
		numTf.setColumns(10);
		numTf.setBounds(66, 131, 59, 20);
		contentPane.add(numTf);
		
		JLabel label_6 = new JLabel("CEP:");
		label_6.setBounds(10, 159, 46, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Pa\u00EDs:");
		label_7.setBounds(10, 190, 46, 14);
		contentPane.add(label_7);
		
		paisTf = new JTextField();
		paisTf.setColumns(10);
		paisTf.setBounds(66, 187, 86, 20);
		contentPane.add(paisTf);
		
		cepTf = new JTextField();
		cepTf.setColumns(10);
		cepTf.setBounds(66, 159, 86, 20);
		contentPane.add(cepTf);
		
		JLabel label_8 = new JLabel("Cidade:");
		label_8.setBounds(157, 159, 46, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Bairro:");
		label_9.setBounds(133, 134, 46, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Logradouro:");
		label_10.setBounds(135, 109, 68, 14);
		contentPane.add(label_10);
		
		logradouroTf = new JTextField();
		logradouroTf.setColumns(10);
		logradouroTf.setBounds(213, 106, 211, 20);
		contentPane.add(logradouroTf);
		
		bairroTf = new JTextField();
		bairroTf.setColumns(10);
		bairroTf.setBounds(213, 131, 211, 20);
		contentPane.add(bairroTf);
		
		cidadeTf = new JTextField();
		cidadeTf.setColumns(10);
		cidadeTf.setBounds(213, 156, 99, 20);
		contentPane.add(cidadeTf);
		
		JLabel label_11 = new JLabel("Estado:");
		label_11.setBounds(317, 159, 46, 14);
		contentPane.add(label_11);
		
		estadoTf = new JTextField();
		estadoTf.setColumns(10);
		estadoTf.setBounds(373, 156, 51, 20);
		contentPane.add(estadoTf);
		
		dnTf = new JTextField();
		dnTf.setColumns(10);
		dnTf.setBounds(338, 36, 86, 20);
		contentPane.add(dnTf);
		
		JLabel label_12 = new JLabel("Data de nascimento:");
		label_12.setBounds(229, 39, 99, 14);
		contentPane.add(label_12);
		
		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Endereco end = new Endereco(tipoTf.getText(), logradouroTf.getText(), numTf.getText(), bairroTf.getText(), cepTf.getText(), cidadeTf.getText(), estadoTf.getText(), paisTf.getText());
					
					if(op == 1) {
					veterinario.cadastrarRecepcionista(nomeTf.getText(), cpfTf.getText(), foneTf.getText(),
							Datas.parseDate(dnTf.getText()), senhaPf.getPassword().toString(),end);
					}else if(op == 2) {
						veterinario.cadastrarVeterinario(nomeTf.getText(), cpfTf.getText(), foneTf.getText(),
								Datas.parseDate(dnTf.getText()), senhaPf.getPassword().toString(),end);
					}
					
					new InicioVeterinario(veterinario).setVisible(true);					
					dispose();
				} catch (PessoaJaCadastradaException e1) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado no sistema!");
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Dados invalidos!");
				}
				
			}
		});
		button.setBounds(239, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(335, 227, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Atualizar");
		button_2.setBounds(10, 227, 89, 23);
		contentPane.add(button_2);
		
		senhaPf = new JPasswordField();
		senhaPf.setBounds(213, 61, 211, 20);
		contentPane.add(senhaPf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(162, 64, 46, 14);
		contentPane.add(lblSenha);
	}
}
