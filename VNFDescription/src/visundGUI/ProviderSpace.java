package visundGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.Box;

public class ProviderSpace extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List vnfs;
	String prvname,prvemail;
	public ProviderSpace(String name2, String string) {
		this.prvname=name2;
		this.prvemail=string;
		VikingManip VM=new VikingManip();
		vnfs=VM.getnotvalidatevnf();
		for (int j = 0; j < vnfs.countItems(); j++) {
			System.out.println("the vnfs are: "+vnfs.getItem(j));
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("New label");

		Image primg = new ImageIcon(this.getClass().getResource("/service provider.png")).getImage();
		primg = primg.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), primg.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(primg));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(6, 16, 59, 14);
		panel.add(lblName);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 41, 46, 14);
		panel.add(lblEmail);

		JLabel name = new JLabel(prvname);
		name.setBounds(75, 16, 178, 14);
		panel.add(name);

		JLabel email = new JLabel(prvemail);
		email.setBounds(75, 41, 178, 14);
		panel.add(email);

		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setBounds(288, 37, 89, 23);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0", "VNF name", "Validation", "View Details"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		for (int j = 0; j < vnfs.countItems(); j++) {
			System.out.println("the vnfs are: "+vnfs.getItem(j));
			model.addRow(new Object[]{j,vnfs.getItem(j), null, null});
		}
		scrollPane.setViewportView(table);
				
		JButton btnNewButton_1 = new JButton("Details");
		
		JButton btnNewButton_2 = new JButton("Edit");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(326, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
			
	}
}
