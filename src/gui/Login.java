package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.PessoaNaoCadastradoException;
import fachada.FachadaRecepcionista;
import fachada.FachadaVeterinario;
import fachada.Ifachada;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField loginTf;
	private JPasswordField senhaPf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ifachada r;
				
				try {
					r = new FachadaRecepcionista();
					r = r.login(loginTf.getText(), senhaPf.getText());
					new InicioRecepcionista((FachadaRecepcionista)r).setVisible(true);
					dispose();
				}
				catch(PessoaNaoCadastradoException ex) {
						try {
							r = new FachadaVeterinario();
							r = r.login(loginTf.getText(), senhaPf.getText());
							//JOptionPane.showMessageDialog(null, "Login veterinario!");
							new InicioVeterinario((FachadaVeterinario)r).setVisible(true);
							dispose();
						} catch (PessoaNaoCadastradoException e1) {
							JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
						}	
				}
			}				
		}
		);
		btnLogin.setBounds(165, 148, 89, 23);
		contentPane.add(btnLogin);
		
		loginTf = new JTextField();
		loginTf.setBounds(113, 72, 191, 20);
		contentPane.add(loginTf);
		loginTf.setColumns(10);
		
		senhaPf = new JPasswordField();
		senhaPf.setBounds(113, 103, 191, 20);
		contentPane.add(senhaPf);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(165, 182, 89, 23);
		contentPane.add(btnNewButton);
	}
}
