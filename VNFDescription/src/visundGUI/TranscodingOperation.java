package visundGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Button;

public class TranscodingOperation extends JFrame {

	List opList;
	List list_2;
	List list;
	private JPanel contentPane;
	DeveloperSpace developers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranscodingOperation frame = new TranscodingOperation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws OWLOntologyCreationException
	 */
	public TranscodingOperation() throws OWLOntologyCreationException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		opList = new List();
		VikingManip VM = new VikingManip();
		// list_1 = new List();
		list_2 = VM.getTranscoderOp();

		JLabel lblOperation = new JLabel("Operation :");
		lblOperation.setBounds(10, 55, 55, 14);
		contentPane.add(lblOperation);

		JButton btnAdd = new JButton("Add");

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//developers = new DeveloperSpace();
				// developers.affichertroplist();

				// TrOp.add(opList.getSelectedItem());
			}
		});
		btnAdd.setBounds(506, 162, 89, 23);
		contentPane.add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list_2);
		scrollPane.setBounds(67, 24, 176, 110);
		// scrollPane.setViewportView(opList);
		// scrollPane.setViewportView(list_2);
		contentPane.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(419, 24, 176, 110);
		contentPane.add(scrollPane_1);

		list = new List();
		scrollPane_1.setViewportView(list);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				list.add(list_2.getSelectedItem());

			}
		});
		btnSelect.setBounds(292, 51, 89, 23);
		contentPane.add(btnSelect);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.remove(list.getSelectedIndex());
			}
		});
		btnRemove.setBounds(292, 95, 89, 23);
		contentPane.add(btnRemove);
	}
}
