import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;



import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.event.ActionEvent;

public class ListVNFDs {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	VikingManag VM=new VikingManag();
	RequestFormulate RF;
	ArrayList<String> VNFDTr,VNFDMx,VNFDCp;
	String VNFtype="";
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListVNFDs window = new ListVNFDs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListVNFDs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "VNF Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 649, 65);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton TrRadioB = new JRadioButton("Transcoder");
		buttonGroup_1.add(TrRadioB);
		TrRadioB.setBounds(12, 16, 109, 23);
		panel.add(TrRadioB);
		
		JRadioButton MxRadioB = new JRadioButton("Mixer");
		buttonGroup_1.add(MxRadioB);
		MxRadioB.setBounds(133, 16, 109, 23);
		panel.add(MxRadioB);
		
		JRadioButton CpRadioB = new JRadioButton("Compressor");
		buttonGroup_1.add(CpRadioB);
		CpRadioB.setBounds(254, 16, 109, 23);
		panel.add(CpRadioB);
		
		
	
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				if (TrRadioB.isSelected()) {
					 try {
							VNFDTr = VM.VNFDTrType();
						} catch (OWLOntologyCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					for (String s : VNFDTr) {
						model.addRow(new Object[]{s, "Transcoder", null, null});
						
					}
						
				}
				if (MxRadioB.isSelected()) {
					
					
					 try {
							VNFDMx = VM.VNFDMxType();
						} catch (OWLOntologyCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					for (String s : VNFDMx) {
						model.addRow(new Object[]{s, "Mixer", null, null});
					
					}
						
				}
				if (CpRadioB.isSelected()) {
					
					
					 try {
							VNFDCp = VM.VNFDCpType();
						} catch (OWLOntologyCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					for (String s : VNFDCp) {
						model.addRow(new Object[]{s, "Compressor", null, null});
						
					}
						
				}
			
			}
		});
		btnSearch.setBounds(375, 16, 89, 23);
		panel.add(btnSearch);
		
		JButton btnAdvancedSearching = new JButton("Personlize Request");
		btnAdvancedSearching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!TrRadioB.isSelected() && !MxRadioB.isSelected() && !CpRadioB.isSelected()) {
					JOptionPane optionpane = new JOptionPane("you must select a VNF Type",
							JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionpane.createDialog("Select a VNF type");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}else {
				
				
					if (TrRadioB.isSelected()) {
						VNFtype="Transcoder";
						
					}
					else if (MxRadioB.isSelected()) {
						VNFtype="Mixer";
					}
					else if (CpRadioB.isSelected()) {
						VNFtype="Compressor";
					}
					
				
					try {
						//System.out.println("the vnf type is "+ VNFtype);
						RF=new RequestFormulate(VNFtype);
					} catch (OWLOntologyCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//formulate the user request
				
				RF.setVisible(true);
				
			}}
		});
		btnAdvancedSearching.setBounds(476, 16, 157, 23);
		panel.add(btnAdvancedSearching);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 628, 290);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"VNF name", "Type", "developed by", "released on"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(76);
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
			 try {
					VNFDTr = VM.VNFDTrType();
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			for (String s : VNFDTr) {
				model.addRow(new Object[]{s, "Transcoder", null, null});
				
			}
				
		
			
			
			 try {
					VNFDMx = VM.VNFDMxType();
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			for (String s : VNFDMx) {
				model.addRow(new Object[]{s, "Mixer", null, null});
			
			}
				
		
		
			
			
			 try {
					VNFDCp = VM.VNFDCpType();
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			for (String s : VNFDCp) {
				model.addRow(new Object[]{s, "Compressor", null, null});
				
			}
				
		
	
	}
}
