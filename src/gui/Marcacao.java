package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.AnimalNaoCadastradoException;
import excecoes.PessoaNaoCadastradoException;
import fachada.FachadaRecepcionista;
import negocio.Cliente;
import negocio.Veterinario;
import negocio.clinica.Procedimento;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class Marcacao extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private FachadaRecepcionista recepcionista;
	private String animal;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	public Marcacao(FachadaRecepcionista r, Cliente c, String a) {
		this.recepcionista = r;
		this.cliente = c; 
		this.animal = a;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 52, 414, 165);
		contentPane.add(list);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCliente(cliente,recepcionista).setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel nomeAnimal = new JLabel(a);
		nomeAnimal.setBounds(10, 11, 207, 14);
		contentPane.add(nomeAnimal);
		
		//adicionando os nomes dos veterinarios na lista INICIO
		DefaultListModel lista = new DefaultListModel<>();
		
		for(Veterinario v : recepcionista.listarVeterinarios()) {	
			lista.addElement(v.getNome() + "                CPF: " +v.getCpf());
		}
						
		list.setModel(lista);
		//FIM
		
		
		textField = new JTextField();
		textField.setBounds(140, 228, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(95, 232, 35, 14);
		contentPane.add(lblData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(335, 8, 89, 20);
		contentPane.add(comboBox);
		
		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(255, 11, 70, 14);
		contentPane.add(lblProcedimento);
		
		try {
			for(Procedimento p : recepcionista.listarProcedimentos()) {
				comboBox.addItem(p.getTipo());
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Não existe procedimentos cadastrados!");
		}
		
		JButton btnMarcar = new JButton("Marcar");
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = list.getSelectedValue().toString();
					String cpf = s.substring(s.indexOf("CPF: ")+5);
					recepcionista.agendarProcedimento(comboBox.getSelectedItem().toString(), LocalDate.now(), animal, cliente.getCpf(), cpf);
					
					new TelaCliente(cliente, recepcionista).setVisible(true);
					dispose();					
				} catch (PessoaNaoCadastradoException e1) {
					JOptionPane.showMessageDialog(null,"ERRO ao pesquisar cliente!");
				} catch (AnimalNaoCadastradoException e1) {
					JOptionPane.showMessageDialog(null,"Nao foi possível marcar a consulta para este animal!");
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Selecione um veterinario!");

				}
			}
		});
		btnMarcar.setBounds(236, 228, 89, 23);
		contentPane.add(btnMarcar);
		
	}
}
