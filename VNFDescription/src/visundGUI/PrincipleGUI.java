package visundGUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class PrincipleGUI {

	private JFrame frame;
	private JFrame frame_1;
	private JTextField username;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipleGUI window = new PrincipleGUI();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipleGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1 = new JFrame();
		frame_1.setBounds(100, 100, 450, 300);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);

		JLabel lblwelcomeimg = new JLabel("");
		lblwelcomeimg.setBounds(10, 54, 134, 127);
		System.out.println(System.getProperty("java.class.path"));
		ImageIcon vnfimg = new ImageIcon("C:\\Users\\adminnennouar\\Downloads\\backup_10-18-2018\\VNFDescription\\imgs\\VNF.png");
		Image imagevnf=vnfimg.getImage();
		imagevnf = imagevnf.getScaledInstance(lblwelcomeimg.getWidth(), lblwelcomeimg.getHeight(), imagevnf.SCALE_SMOOTH);
		vnfimg = new ImageIcon(imagevnf);
		lblwelcomeimg.setIcon(vnfimg);

		frame_1.getContentPane().add(lblwelcomeimg);

		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(154, 54, 76, 20);
		frame_1.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(154, 92, 67, 20);
		frame_1.getContentPane().add(lblPassword);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(154, 132, 31, 20);
		frame_1.getContentPane().add(lblRole);

		username = new JTextField();
		username.setBounds(246, 51, 146, 26);
		frame_1.getContentPane().add(username);
		username.setColumns(10);

		JRadioButton rdbtnDeveloper = new JRadioButton("Developer");
		buttonGroup.add(rdbtnDeveloper);
		rdbtnDeveloper.setBounds(246, 128, 103, 29);
		frame_1.getContentPane().add(rdbtnDeveloper);

		JRadioButton rdbtnProvider = new JRadioButton("Provider");
		buttonGroup.add(rdbtnProvider);
		rdbtnProvider.setBounds(246, 154, 91, 29);
		frame_1.getContentPane().add(rdbtnProvider);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = username.getText();
				String psw = new String(passwordField.getPassword());
				String role = "";
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while (bg.hasMoreElements()) {
					JRadioButton jrb = (JRadioButton) bg.nextElement();
					if (jrb.isSelected()) {
						role = jrb.getText();
					}

				}
				try {
					Login lg = new Login(uname, psw, role, (int) (Math.random() * 14563));
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(335, 209, 71, 29);
		frame_1.getContentPane().add(btnLogin);

		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(195, 209, 139, 29);
		frame_1.getContentPane().add(btnCreateAccount);

		passwordField = new JPasswordField();
		passwordField.setBounds(246, 89, 146, 26);
		frame_1.getContentPane().add(passwordField);
	}
}
