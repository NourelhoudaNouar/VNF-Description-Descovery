package visundGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class ImageAttTranscoding extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageAttTranscoding frame = new ImageAttTranscoding();
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
	public ImageAttTranscoding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 565, 434);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Inputs", null, panel, null);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(31, 16, 493, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 147, 77);
		panel_2.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(340, 16, 147, 77);
		panel_2.add(scrollPane_1);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(198, 16, 89, 23);
		panel_2.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(198, 50, 89, 23);
		panel_2.add(btnRemove);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Outputs", null, panel_1, null);
	}

}
