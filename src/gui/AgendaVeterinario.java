package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import fachada.FachadaRecepcionista;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AgendaVeterinario extends JFrame {

	private JPanel contentPane;
	private FachadaRecepcionista recepcionista;
	private JTextField dataTf;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public AgendaVeterinario(FachadaRecepcionista f, String cpfVeterinario) {
		this.recepcionista = f;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgenda = new JLabel("Agenda:");
		lblAgenda.setBounds(10, 17, 46, 14);
		contentPane.add(lblAgenda);
		
		JButton btnNewButton = new JButton("Remarcar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Dados invalidos!");
				}
			}
		});
		btnNewButton.setBounds(230, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InicioRecepcionista(recepcionista).setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(335, 227, 89, 23);
		contentPane.add(btnSair);
		
		dataTf = new JTextField();
		dataTf.setBounds(338, 14, 86, 20);
		contentPane.add(dataTf);
		dataTf.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(283, 17, 36, 14);
		contentPane.add(lblData);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemover.setBounds(131, 227, 89, 23);
		contentPane.add(btnRemover);
		
		table = new JTable();
		table.setBounds(10, 42, 414, 174);
		contentPane.add(table);
		
		TableColumn c = new TableColumn();
		c.setIdentifier("Nome");
		table.addColumn(c);
		c.setIdentifier("Procedimento");
		table.addColumn(c);
		c.setIdentifier("Data");
		table.addColumn(c);

	}

}
