package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.FachadaRecepcionista;
import negocio.Animal;
import negocio.Cliente;
import negocio.Endereco;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.TextField;
import java.time.LocalDate;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {
	private Cliente cliente;
	private FachadaRecepcionista recepcionista;
	private JPanel contentPane;
	
	
	
	

	/**
	 * Create the frame.
	 */
	public TelaCliente(Cliente c, FachadaRecepcionista f) {
		this.cliente = c;
		this.recepcionista = f;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InicioRecepcionista(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(335, 227, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAdicionarAnimal = new JButton("Adicionar Animal");
		btnAdicionarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroAnimal(recepcionista, cliente).setVisible(true);
				dispose();
			}
		});
		btnAdicionarAnimal.setBounds(287, 187, 137, 23);
		contentPane.add(btnAdicionarAnimal);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente tela = new CadastroCliente(recepcionista);
				tela.setCliente(cliente);
				tela.setVisible(true);
				dispose();
			}
		});
		btnAtualizar.setBounds(10, 227, 89, 23);
		contentPane.add(btnAtualizar);
		
		JEditorPane infoCLiente = new JEditorPane();
		infoCLiente.setBounds(10, 36, 241, 180);
		contentPane.add(infoCLiente);
		
		infoCLiente.setText(c.toString());
		infoCLiente.setEditable(false);
		
		JList list_1 = new JList();
		list_1.setBounds(287, 36, 137, 140);
		contentPane.add(list_1);
		
		DefaultListModel lista = new DefaultListModel<>();
		
		for(Animal a : c.getListaAnimais()) {	
			lista.addElement(a.getNome());
		}
		
		list_1.setModel(lista);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		contentPane.add(lblCliente);
		
		JLabel lblListaDeAnimais = new JLabel("Lista de animais:");
		lblListaDeAnimais.setBounds(287, 11, 89, 14);
		contentPane.add(lblListaDeAnimais);
		
		JButton btnMarcarConsulta = new JButton("Agendar");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a= list_1.getSelectedValue().toString();
					System.out.println(a);
					new Marcacao(recepcionista, cliente, a).setVisible(true);
					
					System.out.println("ainda funcionando");
					dispose();
				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Selecione um animal!");
				}
				
			}
		});
		btnMarcarConsulta.setBounds(109, 227, 89, 23);
		contentPane.add(btnMarcarConsulta);
		
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
