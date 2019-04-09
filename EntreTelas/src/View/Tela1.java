package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Mensagem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela1 extends JFrame {

	private JPanel contentPane;
	private Mensagem mensagem = new Mensagem("Take my Ass");
	private JTextArea textArea;
	private Principal principal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1(new Principal());
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
	public Tela1(Principal principal) {
		this.principal = principal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrincipal = new JLabel("Tela 1");
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setBounds(10, 11, 414, 35);
		contentPane.add(lblPrincipal);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(29, 80, 379, 73);
		contentPane.add(textArea);
		
		textField = new JTextField();		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				principal.getMensagem().setMensagem(textField.getText());
				principal.atualizarMSG();
				atualizarMSG();
			}
		});
		textField.setBounds(29, 175, 379, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		atualizarMSG();
	}

	private void atualizarMSG() {
		textArea.setText(principal.getMensagem().getMensagem());		
	}
}
