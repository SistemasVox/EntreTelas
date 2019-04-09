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

public class Tela2 extends JFrame {

	private JPanel contentPane;
	private Mensagem mensagem = new Mensagem("Take my Ass");
	private JTextArea textArea;
	private Principal principal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2 frame = new Tela2(new Principal());
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
	public Tela2(Principal principal) {
		this.principal = principal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrincipal = new JLabel("Tela 2");
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
		
		JButton btnAtualizarMensagem = new JButton("Mudar MSG");
		btnAtualizarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.getMensagem().setMensagem(JOptionPane.showInputDialog("Qual nova Mensagem?"));
				principal.atualizarMSG();
				JOptionPane.showMessageDialog(null, "Verifique se mudou na principal");
			}
		});
		btnAtualizarMensagem.setBounds(29, 165, 136, 23);
		contentPane.add(btnAtualizarMensagem);
		
		JButton btnVerOBjeto = new JButton("Atualizar Obj");
		btnVerOBjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarMSG();
			}
		});
		btnVerOBjeto.setBounds(293, 164, 115, 23);
		contentPane.add(btnVerOBjeto);
		atualizarMSG();
	}

	private void atualizarMSG() {
		textArea.setText(principal.getMensagem().getMensagem());		
	}
}
