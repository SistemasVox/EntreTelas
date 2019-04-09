package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Mensagem;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Mensagem mensagem = new Mensagem("Take my Ass");
	private JTextArea textArea;
	private static Principal frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setBounds(10, 11, 414, 35);
		contentPane.add(lblPrincipal);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(29, 80, 379, 73);
		contentPane.add(textArea);
		
		JButton btnTela = new JButton("Tela 1");
		btnTela.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Tela1 tela1 = new Tela1(frame);
				tela1.setVisible(true);				
			}
		});
		btnTela.setBounds(29, 197, 89, 23);
		contentPane.add(btnTela);
		
		JButton btnTela_1 = new JButton("Tela 2");
		btnTela_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela2 tela2 = new Tela2(frame);
				tela2.setVisible(true);		
			}
		});
		btnTela_1.setBounds(319, 197, 89, 23);
		contentPane.add(btnTela_1);
		atualizarMSG();
	}

	public void atualizarMSG() {
		textArea.setText(mensagem.getMensagem());		
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	
}
