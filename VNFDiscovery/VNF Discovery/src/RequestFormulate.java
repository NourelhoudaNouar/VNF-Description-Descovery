import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import javax.swing.JCheckBox;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Label;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import javax.swing.SpinnerNumberModel;

public class RequestFormulate extends JFrame {

	JScrollPane scrollPane_2, scrollPane_1;
	JPanel contentPane;
	JComboBox comboBox_1, comboBox_5, comboBox_6;
	private JComboBox stdcomboBox;
	private JComboBox techcomboBox;
	private JComboBox opcomboBox;
	List TrOp, TrTech, TrSd, Sdevice, feature;
	VikingManag VM = new VikingManag();
	List selectedTrOp, selectedTrTech, Device, Sfeature, mixop, mixtech, smixop, smixtech, selectedTrSd, cpop, cptech,
			cpstd;
	Boolean exist = false;
	Boolean V = false, A = false, I = false, F = false, R = false, B = false, C = false;
	ArrayList<Pair> TrOplist, TrTechlist, TrSdlist, TrCtlist, TrCtAttlist, devices, features, mxoperation, mxtechnique;
	public String[] trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO, trVideoFI, trVideoFO, trVideoCI,
			trVideoCO, trVideoRI, trVideoRO, trImageFI, trImageFO, trImageCI, trImageCO, trImageRI, trImageRO;
	ArrayList<Pair> MxCtlist, cpoperation, cptechnique, cpstand, cpctlist;
	int trVideoBMxI, trVideoBMxO,  trImageBMxI,
			trImageBMxO,trAudioBMxI, trAudioBMxO;
	String VNFtype, cpmaxsize;
	elementIO TrVFIO, TrVCIO, TrVRIO, TrVBIO, TrIFIO, TrIRIO, TrIBIO;
	elementIO TrAFIO;
	elementIO TrACIO;
	elementIO TrARIO;
	elementIO TrABIO;
	JScrollPane scrollPane;
	JComboBox comboBox_7, comboBox_14;
	ContentAttInputOutput TrAudioIO, TrImageIO, TrVideoIO;
	ContentInputOutput CtIO;
	Transcoder TranscoderReq;
	JCheckBox CtVideo, CtAudio, CtImage;
	JComboBox acomboBox, vcomboBox, icomboBox;
	JComboBox fcomboBox, rcomboBox, ccomboBox;
	JCheckBox CtAttF, CtAttC, CtAttR;
	JCheckBox mxvideo, mximage;
	JSpinner GWFP, GWNFP, GWPref;
	List scpop, scptech, scpstd;
	JCheckBox cpvideo, cpaudio, cpimage;
	JComboBox comboBox_16, comboBox_17, comboBox_18;
	JSpinner cpsize;
	JComboBox cpsizeunti;
	JComboBox comboBox_15;
	String Price,  Memory, Network, Storage, Cpu;

	public RequestFormulate(String vNFtype) throws OWLOntologyCreationException {
		this.VNFtype = vNFtype;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 892, 631);
		contentPane.add(tabbedPane);

		TrOp = VM.getTranscoderOp();
		TrTech = VM.getTranscoderTech();
		TrSd = VM.getTranscoderStand();
		//if (VNFtype == "Transcoder") {
			JPanel panel = new JPanel();
			tabbedPane.addTab("Transcoder", null, panel, null);
			panel.setLayout(null);

			JLabel label = new JLabel("Operation*");
			label.setBounds(48, 79, 64, 14);
			panel.add(label);

			JLabel label_1 = new JLabel("Technique");
			label_1.setBounds(48, 384, 64, 14);
			panel.add(label_1);

			JLabel label_2 = new JLabel("Standard");
			label_2.setBounds(48, 532, 77, 14);
			panel.add(label_2);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(160, 42, 236, 93);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setViewportView(TrOp);

			panel.add(scrollPane);
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(160, 345, 236, 93);
			scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_2.setViewportView(TrTech);

			panel.add(scrollPane_2);
			JScrollPane scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(160, 493, 236, 93);
			scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_4.setViewportView(TrSd);
			panel.add(scrollPane_4);

			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 148, 361, 169);
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(null, "Content*", TitledBorder.LEADING, TitledBorder.TOP, null));
			panel.add(panel_3);

			CtVideo = new JCheckBox("Video");
			CtVideo.setBounds(12, 25, 67, 23);
			panel_3.add(CtVideo);

			CtAudio = new JCheckBox("Audio");
			CtAudio.setBounds(12, 73, 67, 23);
			panel_3.add(CtAudio);

			CtImage = new JCheckBox("Image");
			CtImage.setBounds(12, 121, 67, 23);
			panel_3.add(CtImage);

			vcomboBox = new JComboBox();
			vcomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			vcomboBox.setBounds(91, 25, 138, 23);
			panel_3.add(vcomboBox);

			acomboBox = new JComboBox();
			acomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			acomboBox.setBounds(91, 73, 138, 23);
			panel_3.add(acomboBox);

			icomboBox = new JComboBox();
			icomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			icomboBox.setBounds(91, 121, 138, 23);
			panel_3.add(icomboBox);

			JPanel panel_4 = new JPanel();
			panel_4.setBounds(381, 148, 494, 169);
			panel_4.setLayout(null);
			panel_4.setBorder(
					new TitledBorder(null, "Content Attributes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.add(panel_4);

			CtAttF = new JCheckBox("Format");
			CtAttF.setBounds(6, 19, 97, 23);
			panel_4.add(CtAttF);

			CtAttC = new JCheckBox("Codec");
			CtAttC.setBounds(6, 77, 97, 23);
			panel_4.add(CtAttC);

			CtAttR = new JCheckBox("Resolution");
			CtAttR.setBounds(6, 48, 97, 23);
			panel_4.add(CtAttR);

			JButton button_3 = new JButton("Set Input/Output");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (CtVideo.isSelected()) {
						V = true;
					} else {
						V = false;
					}
					if (CtAudio.isSelected()) {
						A = true;

					} else {
						A = false;
					}
					if (CtImage.isSelected()) {
						I = true;

					} else {
						I = false;
					}
					
					if (CtAttC.isSelected()) {
						C = true;

					} else {
						C = false;
					}
					if (CtAttR.isSelected()) {
						R = true;

					} else {
						R = false;
					}
					if (CtAttF.isSelected()) {
						F = true;

					} else {
						F = false;
					}

					if ((CtVideo.isSelected() || CtImage.isSelected() || CtAudio.isSelected()) && ( CtAttC.isSelected() || CtAttF.isSelected() || CtAttR.isSelected())) {
						try {
							// System.out.println(V + " " + A + " " + I);
							TranscoderIORequest TrIOreq = new TranscoderIORequest(V, A, I, F, C, R, B,
									RequestFormulate.this);
							TrIOreq.setVisible(true);
						} catch (OWLOntologyCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {

						JOptionPane optionpane = new JOptionPane(
								"you must select at least one Content and one Content attributs ",
								JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select Content and Content Attributs");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}

					/*
					 * ArrayList<Pair> property=new ArrayList<Pair>(); property.add(new
					 * Pair("Video","A")); property.add(new Pair("Image","B")); property.add(new
					 * Pair("Audio","C")); Pair p=property.get(0); System.out.println(p.element);
					 */
				}
			});
			button_3.setBounds(355, 135, 135, 23);
			panel_4.add(button_3);

			fcomboBox = new JComboBox();
			fcomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			fcomboBox.setBounds(104, 20, 138, 23);
			panel_4.add(fcomboBox);

			rcomboBox = new JComboBox();
			rcomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			rcomboBox.setBounds(104, 47, 138, 23);
			panel_4.add(rcomboBox);

			ccomboBox = new JComboBox();
			ccomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			ccomboBox.setBounds(104, 78, 138, 23);
			panel_4.add(ccomboBox);

			JPanel panel_9 = new JPanel();
			panel_9.setBounds(444, 366, 138, 79);
			panel.add(panel_9);
			panel_9.setLayout(null);

			JButton btnAdd = new JButton("Add");
			btnAdd.setBounds(25, 0, 89, 23);
			panel_9.add(btnAdd);

			techcomboBox = new JComboBox();
			techcomboBox.setBounds(0, 30, 138, 23);
			panel_9.add(techcomboBox);
			techcomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

			JButton btnRemove_1 = new JButton("Remove");
			btnRemove_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (selectedTrTech.getItemCount() != 0) {
						selectedTrTech.remove(selectedTrTech.getSelectedItem());
					}
				}
			});
			btnRemove_1.setBounds(25, 56, 89, 23);
			panel_9.add(btnRemove_1);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (techcomboBox.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {
						exist = false;
						for (String s : selectedTrTech.getItems()) {
							if (s.equals(TrTech.getSelectedItem() + "# " + techcomboBox.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							selectedTrTech.add(TrTech.getSelectedItem() + "# " + techcomboBox.getSelectedItem());

						}
					}
				}

			});

			JPanel panel_8 = new JPanel();
			panel_8.setBounds(444, 42, 138, 93);
			panel.add(panel_8);
			panel_8.setLayout(null);

			opcomboBox = new JComboBox();
			opcomboBox.setBounds(0, 30, 138, 23);
			panel_8.add(opcomboBox);
			opcomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

			JButton btnAdd_1 = new JButton("Add");
			btnAdd_1.setBounds(23, 0, 93, 23);
			panel_8.add(btnAdd_1);

			JButton btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (selectedTrOp.getItemCount() != 0) {
						selectedTrOp.remove(selectedTrOp.getSelectedItem());
					}

				}
			});
			btnRemove.setBounds(23, 59, 89, 23);
			panel_8.add(btnRemove);
			btnAdd_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (opcomboBox.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : selectedTrOp.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(TrOp.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							selectedTrOp.add(TrOp.getSelectedItem() + "# " + opcomboBox.getSelectedItem());
							if (TrOp.getSelectedItem().equals("Transcoding")) {
								CtAttC.setSelected(true);
								ccomboBox.setSelectedItem(opcomboBox.getSelectedItem());

							}
							if (TrOp.getSelectedItem().equals("Transsizing")) {
								CtAttR.setSelected(true);
								rcomboBox.setSelectedItem(opcomboBox.getSelectedItem());

							}
							if (TrOp.getSelectedItem().equals("Transmuxing")) {
								CtAttF.setSelected(true);
								fcomboBox.setSelectedItem(opcomboBox.getSelectedItem());

							}
							

						}
					}
				}
			});

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(630, 42, 236, 93);
			panel.add(scrollPane_1);

			selectedTrOp = new List();
			scrollPane_1.setViewportView(selectedTrOp);

			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(630, 345, 236, 93);
			panel.add(scrollPane_3);

			selectedTrTech = new List();
			scrollPane_3.setViewportView(selectedTrTech);

			JScrollPane scrollPane_5 = new JScrollPane();
			scrollPane_5.setBounds(630, 493, 236, 93);
			panel.add(scrollPane_5);

			selectedTrSd = new List();
			scrollPane_5.setViewportView(selectedTrSd);

			JPanel panel_10 = new JPanel();
			panel_10.setBounds(453, 512, 138, 80);
			panel.add(panel_10);
			panel_10.setLayout(null);

			stdcomboBox = new JComboBox();
			stdcomboBox.setBounds(0, 30, 138, 23);
			panel_10.add(stdcomboBox);
			stdcomboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

			JButton button = new JButton("Add");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (stdcomboBox.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : selectedTrSd.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(TrSd.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							selectedTrSd.add(TrSd.getSelectedItem() + "# " + stdcomboBox.getSelectedItem());

						}
					}

				}
			});
			button.setBounds(25, 0, 89, 23);
			panel_10.add(button);

			JButton btnRemove_2 = new JButton("Remove");
			btnRemove_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (selectedTrSd.getItemCount() != 0) {
						selectedTrSd.remove(selectedTrSd.getSelectedItem());
					}
				}
			});
			btnRemove_2.setBounds(25, 57, 89, 23);
			panel_10.add(btnRemove_2);

			/////////////////////////////////

			/////////////////////////////////
		//} else if (VNFtype == "Mixer") {
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Mixer", null, panel_1, null);
			panel_1.setLayout(null);

			JLabel label_8 = new JLabel("Operation*");
			label_8.setBounds(10, 75, 61, 14);
			panel_1.add(label_8);

			JScrollPane scrollPane_9 = new JScrollPane();
			scrollPane_9.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane_9.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_9.setBounds(138, 42, 236, 93);
			panel_1.add(scrollPane_9);

			JPanel panel_13 = new JPanel();
			panel_13.setBounds(423, 324, 138, 94);
			panel_1.add(panel_13);
			panel_13.setLayout(null);
			JComboBox comboBox_3 = new JComboBox();
			comboBox_3.setBounds(0, 35, 138, 23);
			panel_13.add(comboBox_3);
			comboBox_3.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

			JButton button_15 = new JButton("Add");
			button_15.setBounds(25, 6, 89, 23);
			panel_13.add(button_15);

			JButton button_16 = new JButton("Remove");
			button_16.setBounds(25, 64, 89, 23);
			panel_13.add(button_16);
			button_15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_3.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : smixtech.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(mixtech.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							smixtech.add(mixtech.getSelectedItem() + "# " + comboBox_3.getSelectedItem());

						}
					}
				}
			});

			JPanel panel_12 = new JPanel();
			panel_12.setBounds(423, 42, 138, 85);
			panel_1.add(panel_12);
			panel_12.setLayout(null);

			JComboBox comboBox_4 = new JComboBox();
			comboBox_4.setBounds(0, 31, 138, 23);
			panel_12.add(comboBox_4);
			comboBox_4.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

			JButton button_14 = new JButton("Remove");
			button_14.setBounds(25, 58, 89, 23);
			panel_12.add(button_14);

			JButton button_13 = new JButton("Add");
			button_13.setBounds(25, 4, 89, 23);
			panel_12.add(button_13);
			button_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (comboBox_4.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : smixop.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(mixop.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							smixop.add(mixop.getSelectedItem() + "# " + comboBox_4.getSelectedItem());

						}
					}
				}
			});

			mixop = new List();
			mixop = VM.getMixOp();
			scrollPane_9.setViewportView(mixop);

			JPanel panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBorder(new TitledBorder(null, "Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_6.setBounds(10, 164, 551, 93);
			panel_1.add(panel_6);

			mxvideo = new JCheckBox("Video");
			mxvideo.setBounds(18, 16, 97, 23);
			panel_6.add(mxvideo);

			mximage = new JCheckBox("Image");
			mximage.setBounds(18, 63, 97, 23);
			panel_6.add(mximage);

			comboBox_7 = new JComboBox();
			comboBox_7.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_7.setBounds(128, 17, 145, 22);
			panel_6.add(comboBox_7);

			comboBox_14 = new JComboBox();
			comboBox_14.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_14.setBounds(128, 64, 145, 18);
			panel_6.add(comboBox_14);

			JLabel label_9 = new JLabel("Technique");
			label_9.setBounds(10, 364, 61, 14);
			panel_1.add(label_9);

			JScrollPane scrollPane_10 = new JScrollPane();
			scrollPane_10.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane_10.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_10.setBounds(138, 325, 236, 93);
			panel_1.add(scrollPane_10);

			mixtech = new List();
			mixtech = VM.getMixTech();
			scrollPane_10.setViewportView(mixtech);

			JScrollPane scrollPane_12 = new JScrollPane();
			scrollPane_12.setBounds(630, 42, 236, 93);
			panel_1.add(scrollPane_12);

			smixop = new List();
			scrollPane_12.setViewportView(smixop);

			JScrollPane scrollPane_15 = new JScrollPane();
			scrollPane_15.setBounds(630, 325, 236, 93);
			panel_1.add(scrollPane_15);
			smixtech = new List();
			scrollPane_15.setViewportView(smixtech);
	//	} else if (VNFtype == "Compressor") {

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("Compressor", null, panel_2, null);
			panel_2.setLayout(null);

			JLabel label_3 = new JLabel("Operation*");
			label_3.setBounds(20, 73, 61, 14);
			panel_2.add(label_3);

			JScrollPane scrollPane_6 = new JScrollPane();
			scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_6.setBounds(107, 42, 236, 93);
			panel_2.add(scrollPane_6);

			cpop = new List();
			cpop = VM.getCompOp();
			scrollPane_6.setViewportView(cpop);

			JButton button_7 = new JButton("Add");

			button_7.setBounds(428, 38, 89, 23);
			panel_2.add(button_7);

			JButton button_8 = new JButton("Remove");
			button_8.setBounds(428, 108, 89, 23);
			panel_2.add(button_8);

			JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBorder(new TitledBorder(null, "Content*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(20, 154, 556, 140);
			panel_2.add(panel_5);

			cpvideo = new JCheckBox("Video");
			cpvideo.setBounds(6, 17, 97, 23);
			panel_5.add(cpvideo);

			cpaudio = new JCheckBox("Audio");
			cpaudio.setBounds(6, 57, 97, 23);
			panel_5.add(cpaudio);

			cpimage = new JCheckBox("Image");
			cpimage.setBounds(6, 97, 97, 23);
			panel_5.add(cpimage);

			comboBox_16 = new JComboBox();
			comboBox_16.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_16.setBounds(213, 17, 138, 23);
			panel_5.add(comboBox_16);

			comboBox_17 = new JComboBox();
			comboBox_17.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_17.setBounds(213, 55, 138, 22);
			panel_5.add(comboBox_17);

			comboBox_18 = new JComboBox();
			comboBox_18.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_18.setBounds(213, 96, 138, 20);
			panel_5.add(comboBox_18);

			JScrollPane scrollPane_7 = new JScrollPane();
			scrollPane_7.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane_7.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_7.setBounds(107, 324, 236, 93);
			panel_2.add(scrollPane_7);

			cptech = new List();
			cptech = VM.getCompTech();
			scrollPane_7.setViewportView(cptech);

			JLabel label_4 = new JLabel("Technique");
			label_4.setBounds(20, 360, 61, 14);
			panel_2.add(label_4);

			JButton button_9 = new JButton("Add");

			button_9.setBounds(453, 329, 89, 23);
			panel_2.add(button_9);

			JButton button_10 = new JButton("Remove");
			button_10.setBounds(453, 393, 89, 23);
			panel_2.add(button_10);

			JButton button_11 = new JButton("Add");

			button_11.setBounds(453, 448, 89, 23);
			panel_2.add(button_11);

			JButton button_12 = new JButton("Remove");
			button_12.setBounds(453, 514, 89, 23);
			panel_2.add(button_12);

			JScrollPane scrollPane_8 = new JScrollPane();
			scrollPane_8.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane_8.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_8.setBounds(107, 439, 236, 93);
			panel_2.add(scrollPane_8);

			cpstd = new List();
			cpstd = VM.getCompStand();
			scrollPane_8.setViewportView(cpstd);

			JLabel label_5 = new JLabel("Standard");
			label_5.setBounds(20, 473, 61, 14);
			panel_2.add(label_5);

			JLabel label_6 = new JLabel("Max Size");
			label_6.setBounds(20, 573, 77, 14);
			panel_2.add(label_6);

			cpsize = new JSpinner();
			cpsize.setBounds(107, 569, 77, 23);
			panel_2.add(cpsize);

			JLabel label_7 = new JLabel("Unit");
			label_7.setBounds(248, 573, 46, 14);
			panel_2.add(label_7);

			cpsizeunti = new JComboBox();
			cpsizeunti.setModel(
					new DefaultComboBoxModel(new String[] { "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB" }));
			cpsizeunti.setBounds(283, 569, 89, 23);
			panel_2.add(cpsizeunti);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(630, 42, 236, 93);
			panel_2.add(scrollPane);

			scpop = new List();
			scrollPane.setViewportView(scpop);

			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(630, 329, 236, 93);
			panel_2.add(scrollPane_1);

			scptech = new List();
			scrollPane_1.setViewportView(scptech);

			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(630, 439, 236, 93);
			panel_2.add(scrollPane_2);

			scpstd = new List();
			scrollPane_2.setViewportView(scpstd);

			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_1.setBounds(403, 69, 138, 23);
			panel_2.add(comboBox_1);

			comboBox_5 = new JComboBox();
			comboBox_5.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_5.setBounds(428, 362, 138, 23);
			panel_2.add(comboBox_5);

			comboBox_6 = new JComboBox();
			comboBox_6.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_6.setBounds(428, 483, 138, 23);
			panel_2.add(comboBox_6);

			comboBox_15 = new JComboBox();
			comboBox_15.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_15.setBounds(428, 570, 139, 22);
			panel_2.add(comboBox_15);

			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_1.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : scpop.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(cpop.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							scpop.add(cpop.getSelectedItem() + "# " + comboBox_1.getSelectedItem());

						}
					}
				}
			});
			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_5.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : scptech.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(cptech.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							scptech.add(cptech.getSelectedItem() + "# " + comboBox_5.getSelectedItem());

						}
					}
				}
			});
			button_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_6.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : scpstd.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							// System.out.println(part1);
							if (part1.equals(cpstd.getSelectedItem())) {
								exist = true;
							}
						}
						if (exist == false) {
							scpstd.add(cpstd.getSelectedItem() + "# " + comboBox_6.getSelectedItem());

						}
					}
				}
			});
	//	}
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("Non-Functional Properties", null, panel_11, null);
		panel_11.setLayout(null);
		Device = new List();
		Device = VM.getdevice();

		feature = new List();
		feature = VM.getfeature();
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(433, 45, 138, 90);
		panel_11.add(panel_14);
		panel_14.setLayout(null);
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(0, 33, 138, 23);
		panel_14.add(comboBox_8);
		comboBox_8.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

		JButton button_1 = new JButton("Add");
		button_1.setBounds(25, 5, 89, 23);
		panel_14.add(button_1);

		JButton button_2 = new JButton("Remove");
		button_2.setBounds(25, 61, 89, 23);
		panel_14.add(button_2);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox_8.getSelectedItem().toString().equals("Choose Preference")
						|| Device.getSelectedItem() == null) {
					JOptionPane optionpane = new JOptionPane(
							"you must select a prefernece for the choosing property or a Proprety",
							JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionpane.createDialog("Select a preference");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				} else {

					exist = false;
					for (String s : Sdevice.getItems()) {
						String[] parts = s.split("#");
						String part1 = parts[0];
						String part2 = parts[1];
						// System.out.println(part1);
						if (part1.equals(Device.getSelectedItem())) {
							exist = true;
						}
					}
					if (exist == false) {
						Sdevice.add(Device.getSelectedItem() + "# " + comboBox_8.getSelectedItem());

					}
				}

			}
		});
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(433, 150, 138, 93);
		panel_11.add(panel_15);
		panel_15.setLayout(null);

		JComboBox comboBox_118 = new JComboBox();
		comboBox_118.setBounds(0, 35, 138, 23);
		panel_15.add(comboBox_118);
		comboBox_118.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));

		JButton button_4 = new JButton("Add");
		button_4.setBounds(25, 6, 89, 23);
		panel_15.add(button_4);

		JButton button_5 = new JButton("Remove");
		button_5.setBounds(25, 64, 89, 23);
		panel_15.add(button_5);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox_118.getSelectedItem().toString().equals("Choose Preference")
						|| feature.getSelectedItem() == null) {
					JOptionPane optionpane = new JOptionPane(
							"you must select a prefernece for the choosing property or a Proprety",
							JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionpane.createDialog("Select a preference");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				} else {

					exist = false;
					for (String s : Sfeature.getItems()) {
						String[] parts = s.split("#");
						String part1 = parts[0];
						String part2 = parts[1];
						// System.out.println(part1);
						if (part1.equals(feature.getSelectedItem())) {
							exist = true;
						}
					}
					if (exist == false) {
						Sfeature.add(feature.getSelectedItem() + "# " + comboBox_118.getSelectedItem());

					}
				}
			}
		});

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
		comboBox_10.setBounds(307, 319, 138, 23);
		panel_11.add(comboBox_10);

		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
		comboBox_11.setBounds(307, 427, 138, 23);
		panel_11.add(comboBox_11);

		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
		comboBox_12.setBounds(307, 486, 138, 23);
		panel_11.add(comboBox_12);

		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
		comboBox_13.setBounds(307, 551, 138, 23);
		panel_11.add(comboBox_13);

		JLabel label_10 = new JLabel("Device");
		label_10.setBounds(40, 83, 77, 14);
		panel_11.add(label_10);

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_11.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_11.setBounds(157, 44, 236, 93);
		panel_11.add(scrollPane_11);
		scrollPane_11.setViewportView(Device);

		Label label_11 = new Label("Feature");
		label_11.setBounds(40, 180, 66, 22);
		panel_11.add(label_11);

		JScrollPane scrollpanefeature = new JScrollPane();
		scrollpanefeature.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollpanefeature.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpanefeature.setBounds(157, 150, 236, 93);
		panel_11.add(scrollpanefeature);
		scrollpanefeature.setViewportView(feature);

		Label label_12 = new Label("Proposed Cost");
		label_12.setBounds(40, 319, 91, 22);
		panel_11.add(label_12);

		JSpinner price = new JSpinner();
		price.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		price.setBounds(157, 319, 85, 23);
		panel_11.add(price);

		JLabel lblEuro = new JLabel("Euro");
		lblEuro.setBounds(252, 323, 41, 14);
		panel_11.add(lblEuro);

		JLabel label_14 = new JLabel("Number of CPU");
		label_14.setBounds(40, 381, 87, 14);
		panel_11.add(label_14);

		JSpinner cpu = new JSpinner();
		cpu.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cpu.setBounds(157, 377, 85, 23);
		panel_11.add(cpu);

		JLabel label_15 = new JLabel("Memory");
		label_15.setBounds(40, 431, 57, 14);
		panel_11.add(label_15);

		JSpinner memory = new JSpinner();
		memory.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		memory.setBounds(157, 427, 85, 23);
		panel_11.add(memory);

		JLabel lblKb = new JLabel("KB");
		lblKb.setBounds(252, 431, 41, 14);
		panel_11.add(lblKb);

		JLabel lblKbps = new JLabel("Kbps");
		lblKbps.setBounds(252, 490, 41, 14);
		panel_11.add(lblKbps);

		JSpinner network = new JSpinner();
		network.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		network.setBounds(157, 486, 85, 23);
		panel_11.add(network);

		JLabel label_18 = new JLabel("Network ");
		label_18.setBounds(40, 490, 57, 14);
		panel_11.add(label_18);

		JLabel label_19 = new JLabel("Storage");
		label_19.setBounds(40, 555, 72, 14);
		panel_11.add(label_19);

		JSpinner storage = new JSpinner();
		storage.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		storage.setBounds(157, 551, 85, 23);
		panel_11.add(storage);

		JLabel lblKb_1 = new JLabel("KB");
		lblKb_1.setBounds(252, 555, 41, 14);
		panel_11.add(lblKb_1);

		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_13.setBounds(611, 44, 236, 93);
		panel_11.add(scrollPane_13);

		Sdevice = new List();
		scrollPane_13.setViewportView(Sdevice);

		JScrollPane scrollPane_14 = new JScrollPane();
		scrollPane_14.setBounds(611, 150, 236, 93);
		panel_11.add(scrollPane_14);

		Sfeature = new List();
		scrollPane_14.setViewportView(Sfeature);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
		comboBox_2.setBounds(307, 377, 138, 23);
		panel_11.add(comboBox_2);
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Preference", null, panel_7, null);
		panel_7.setLayout(null);

		JLabel lblFunctionalProperties = new JLabel("Functional Properties");
		lblFunctionalProperties.setBounds(10, 29, 162, 23);
		panel_7.add(lblFunctionalProperties);

		JLabel lblNonfunctionalProperties = new JLabel("Non-Functional Properties");
		lblNonfunctionalProperties.setBounds(10, 84, 153, 23);
		panel_7.add(lblNonfunctionalProperties);
		JLabel lblPreferences = new JLabel("Preferences");
		lblPreferences.setBounds(10, 138, 162, 23);
		panel_7.add(lblPreferences);

		GWFP = new JSpinner();
		GWFP.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		GWFP.setBounds(214, 29, 79, 23);
		panel_7.add(GWFP);

		GWNFP = new JSpinner();
		GWNFP.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		GWNFP.setBounds(214, 84, 79, 23);
		panel_7.add(GWNFP);

		GWPref = new JSpinner();
		GWPref.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		GWPref.setBounds(214, 138, 79, 23);
		panel_7.add(GWPref);

		// TrOp.setMultipleMode(true);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/////////// ************Preferences*********///////////////////
				int Gwfp = (int) GWFP.getValue();
				int Gwnfp = (int) GWNFP.getValue();
				int Gwpref = (int) GWPref.getValue();
				// System.out.println("GWFP " + Gwfp + " Gwnfp " + Gwnfp + " Gwpref " + Gwpref);
				////////// *****Non Functional Properties**********//////////////////
				
				
				
				
				
				
				
				
				
				///////////////////////////////
				Price = price.getValue().toString() + " " + "# "
						+ comboBox_10.getSelectedItem();
				Cpu = cpu.getValue().toString() + "# " + comboBox_2.getSelectedItem();
				Memory = memory.getValue().toString() + " " + "# "
						+ comboBox_11.getSelectedItem();
				Network = network.getValue().toString() + " " + "# "
						+ comboBox_12.getSelectedItem();
				Storage = storage.getValue().toString() + " " + "# "
						+ comboBox_13.getSelectedItem();

				devices = new ArrayList<Pair>();
				for (String s : Sdevice.getItems()) {
					String[] parts = s.split("# ");
					String part1 = parts[0];
					String part2 = parts[1];
					devices.add(new Pair(part1, part2));
				}
				features = new ArrayList<Pair>();
				for (String s : Sfeature.getItems()) {
					String[] parts = s.split("# ");
					String part1 = parts[0];
					String part2 = parts[1];
					features.add(new Pair(part1, part2));
				}

				/////////////// ********Transcoder*/////////////////////////////////

				//if (VNFtype == "Transcoder") {

					TrOplist = new ArrayList<Pair>();
					for (String s : selectedTrOp.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						TrOplist.add(new Pair(part1, part2));
					}

					for (int j = 0; j < TrOplist.size(); j++) {
						// System.out.println("////////////////////");
						Pair p = TrOplist.get(j);
						// System.out.println(p.prop);
						// System.out.println(p.pref);
					}

					TrTechlist = new ArrayList<Pair>();
					for (String s : selectedTrTech.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						TrTechlist.add(new Pair(part1, part2));
					}

					for (int j = 0; j < TrTechlist.size(); j++) {
						// System.out.println("////////////////////");
						Pair p = TrTechlist.get(j);
						// System.out.println(p.prop);
						// System.out.println(p.pref);
					}

					TrSdlist = new ArrayList<Pair>();
					for (String s : selectedTrSd.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						TrSdlist.add(new Pair(part1, part2));
					}

					for (int j = 0; j < TrSdlist.size(); j++) {
						// System.out.println("////////////////////");
						Pair p = TrSdlist.get(j);
						// System.out.println(p.prop);
						// System.out.println(p.pref);
					}

					TrCtlist = new ArrayList<Pair>();
					if (CtVideo.isSelected()) {
						TrCtlist.add(new Pair("Video", vcomboBox.getSelectedItem().toString()));
					}
					if (CtAudio.isSelected()) {
						TrCtlist.add(new Pair("Audio", acomboBox.getSelectedItem().toString()));
					}
					if (CtImage.isSelected()) {
						TrCtlist.add(new Pair("Image", icomboBox.getSelectedItem().toString()));
					}

					TrCtAttlist = new ArrayList<Pair>();
					if (CtAttF.isSelected()) {
						TrCtAttlist.add(new Pair("Format", fcomboBox.getSelectedItem().toString()));
					}

					if (CtAttR.isSelected()) {
						TrCtAttlist.add(new Pair("Resolution", rcomboBox.getSelectedItem().toString()));
					}
					
					if (CtAttC.isSelected()) {
						TrCtAttlist.add(new Pair("Codec", ccomboBox.getSelectedItem().toString()));
					}
					// ArrayList<ArrayList<Pair>> Transcoder= new ArrayList<ArrayList<Pair>>();
					// Transcoder.add(TrOplist);
					TrVFIO = new elementIO(trVideoFI, trVideoFO);
					TrVCIO = new elementIO(trVideoCI, trVideoCO);
					TrVRIO = new elementIO(trVideoRI, trVideoRO);
					
					/////// ******the inputs and outputs of the Video******////////
					TrVideoIO = new ContentAttInputOutput(TrVFIO, TrVCIO, TrVRIO, TrVBIO);
					//////////////////////// Image///////////////////////////////

					TrIFIO = new elementIO(trImageFI, trImageFO);
					TrIRIO = new elementIO(trImageRI, trImageRO);
					
					/////// ******the inputs and outputs of the Image******////////
					TrImageIO = new ContentAttInputOutput(TrIFIO, null, TrIRIO, TrIBIO);
					////////////////////////// Audio//////////////////////////////////

					TrAFIO = new elementIO(trAudioFI, trAudioFO);
					TrACIO = new elementIO(trAudioCI, trAudioCO);
					TrARIO = new elementIO(trAudioRI, trAudioRO);
					
					/////// ******the inputs and outputs of the Audio******////////
					TrAudioIO = new ContentAttInputOutput(TrAFIO, TrACIO, TrARIO, TrABIO);
					//////////////////////////////////////////////////////

					CtIO = new ContentInputOutput(TrAudioIO, TrImageIO, TrVideoIO);
					TranscoderReq = new Transcoder(TrOplist, TrTechlist, TrSdlist, TrCtlist, TrCtAttlist, CtIO);
					for (int i = 0; i < TranscoderReq.TrOplist.size(); i++) {
						Pair p = TranscoderReq.TrOplist.get(i);
						// System.out.println(" the transcoder operations requested are : " + p.prop);
					}

					TrPropCalWeights CW = new TrPropCalWeights(V, A, I, F, C, R, B, TranscoderReq, devices, features,
							Price, Cpu, Memory, Network, Storage, Gwfp, Gwnfp, Gwpref);
				//} else if (VNFtype == "Mixer") {

					mxoperation = new ArrayList<Pair>();
					for (String s : smixop.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						mxoperation.add(new Pair(part1, part2));
					}
					mxtechnique = new ArrayList<Pair>();
					for (String s : smixtech.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						mxtechnique.add(new Pair(part1, part2));
					}

					MxCtlist = new ArrayList<Pair>();
					if (mxvideo.isSelected()) {
						MxCtlist.add(new Pair("Video", comboBox_7.getSelectedItem().toString()));
					}
					if (mximage.isSelected()) {
						MxCtlist.add(new Pair("Image", comboBox_14.getSelectedItem().toString()));
					}

					MxPropCalWeights Mxwght = new MxPropCalWeights(mxtechnique, mxoperation, MxCtlist, devices,
							features, Price, Cpu, Memory, Network, Storage, Gwfp, Gwnfp, Gwpref);
					
				//} else if (VNFtype == "Compressor") {
					cpoperation = new ArrayList<Pair>();
					for (String s : scpop.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						cpoperation.add(new Pair(part1, part2));
					}
					cptechnique = new ArrayList<Pair>();
					for (String s : scptech.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						cptechnique.add(new Pair(part1, part2));
					}
					cpstand = new ArrayList<Pair>();
					for (String s : scpstd.getItems()) {
						String[] parts = s.split("# ");
						String part1 = parts[0];
						String part2 = parts[1];
						cpstand.add(new Pair(part1, part2));
					}
					cpctlist = new ArrayList<Pair>();
					if (cpvideo.isSelected()) {
						cpctlist.add(new Pair("Video", comboBox_16.getSelectedItem().toString()));
					}
					if (cpaudio.isSelected()) {
						cpctlist.add(new Pair("Audio", comboBox_17.getSelectedItem().toString()));
					}
					if (cpimage.isSelected()) {
						cpctlist.add(new Pair("Image", comboBox_18.getSelectedItem().toString()));
					}
					cpmaxsize = cpsize.getValue().toString() + " " + cpsizeunti.getSelectedItem().toString() + " # "
							+ comboBox_15.getSelectedItem();

				}

			//}
		});
		btnFinish.setBounds(813, 653, 89, 23);
		contentPane.add(btnFinish);

	}

	public void TrIO(String[] trAudioFI, String[] trAudioFO, String[] trAudioCI, String[] trAudioCO, String[] trAudioRI,
			String[] trAudioRO, String[] trVideoFI, String[] trVideoFO, String[] trVideoCI, String[] trVideoCO, String[] trVideoRI,
			String[] trVideoRO,  String[] trImageFI, String[] trImageFO, String[] trImageCI, String[] trImageCO, String[] trImageRI,
			String[] trImageRO) {
		// savedata(trVideoFI);
		this.trVideoFI = trVideoFI;
		this.trVideoCI = trVideoCI;
		this.trVideoRI = trVideoRI;
		this.trVideoBMxI = trVideoBMxI;

		this.trVideoFO = trVideoFO;
		this.trVideoCO = trVideoCO;
		this.trVideoRO = trVideoRO;
		this.trVideoBMxO = trVideoBMxO;

		this.trImageFI = trImageFI;
		this.trImageCI = trImageCI;
		this.trImageRI = trImageRI;
		this.trImageBMxI = trImageBMxI;

		this.trImageFO = trImageFO;
		this.trImageCO = trImageCO;
		this.trImageRO = trImageRO;
		this.trImageBMxO = trImageBMxO;

		this.trAudioFI = trAudioFI;
		this.trAudioCI = trAudioCI;
		this.trAudioRI = trAudioRI;
		this.trAudioBMxI = trAudioBMxI;

		this.trAudioFO = trAudioFO;
		this.trAudioCO = trAudioCO;
		this.trAudioRO = trAudioRO;
		this.trAudioBMxO = trAudioBMxO;

	}
}
