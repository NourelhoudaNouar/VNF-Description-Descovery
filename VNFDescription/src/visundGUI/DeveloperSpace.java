package visundGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Scrollbar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Button;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import VikingMan.vikingM;

import javax.swing.Box;
import java.awt.Toolkit;
import java.awt.Label;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DeveloperSpace extends JFrame {

	private JPanel contentPane;
	private JTextField vnfname;
	private JTextField vnfversion;
	static String dvname, dvmail;
	static String developerrole;
	static String developeremail;
	String providername;
	static OWLOntology viking;
	static OWLDataFactory df;
	static OWLOntologyManager manager;
	static IRI vikingIRI;
	static OWLReasonerFactory reasonerFactory;
	static OWLReasoner reasoner;
	public List opList;
	String[] trOp, trTech, trStand, CmOp, CmTech, CmStand, MxOp, MxTech, device, feature;
	boolean trVideoCt, trAudioCt, trImageCt, CmVideoCt, CmAudioCt, CmImageCt, MxVideoCt, MxAudioCt, MxImageCt, trfromat,
			trcodec, trresolution, trbitrate;
	double price;
	int vnfcpu ;
	int vnfstorage , vnfmemory ;
	int vnfnetwork;
	String CmMaxSize = null, version = null, sizeunt = null, crcy = null, vnfcpuunit = null, vnfnetworkunit = null,
			vnfstorageunit = null, vnfmemoryunit = null, depurl = null, vnfurl = null;
	List techList, l1, listfeature;
	List standList;
	String vnfnm = null;
	List mixOp;
	List mixTech;
	List CompOp;
	List CompTech;
	List CompStand;
	List troplist;
	static List list;
	TranscodingOperation to;
	public List selectedOp;
	public JScrollPane scrollPane_2;
	public JPanel transcoderPanel;
	String TrContentVideo = null;
	String TrContentAudio = null;
	String TrContentImage = null;
	String dsc = null, vnfverion = null, vnfcreatedate = null;
	TranscoderInputOutput trIO;
	JCheckBox chckbxTranscoder, chckbxMixer, chckbxCompressor;
	JCheckBox chckbxCodec;
	JCheckBox chckbxFormat;
	JCheckBox chckbxResolution;
	JCheckBox trvideo, traudio, trimage;
	List selectedMixOp;
	List selectedCompTech, selectedCompStand, selectedMixTech;
	JPanel mixerPanel, compressorPanel, vnfProfilePanel, deploymentPanel, NFPpanel;
	File deployementFile;
	private JTextField deployementurl;
	String trvnfnm = null, cmvnfnm = null, mxvnfnm = null;
	JDateChooser dateChooser;
	Boolean v, a, i, f, c, r, b;
	JButton btnNewButton_8;
	public String[] trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO, trVideoFI, trVideoFO, trVideoCI,
			trVideoCO, trVideoRI, trVideoRO, trImageFI, trImageFO, trImageRI, trImageRO;
	int trVideoBMxI, trVideoBMxO,  trImageBMxI,
			trImageBMxO,  trAudioBMxI, trAudioBMxO;
	private JTextField VNFpackage;
	// static VikingManip VM;

	/*
	 * Launch the application.
	 * 
	 * @throws OWLOntologyCreationException
	 */

	/*
	 * public static void main(String[] args) throws OWLOntologyCreationException {
	 * 
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * DeveloperSpace frame = new DeveloperSpace(dvname, dvmail);
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 * 
	 * @param developeremail
	 * @param developerrole
	 * @param developername
	 * @throws OWLOntologyCreationException
	 * @wbp.parser.constructor
	 */
	public DeveloperSpace(String dvname, String email) throws OWLOntologyCreationException {
		// super();
		setResizable(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\adminnennouar\\eclipse-workspace\\VNFDescription\\imgs\\dev.png"));
		vikingM vikingmg = new vikingM();
		vikingmg.VikingM();
		// setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 11, 76, 67);
		ImageIcon devimg = new ImageIcon("C:\\Users\\adminnennouar\\Downloads\\backup_10-18-2018\\VNFDescription\\imgs\\dev.png");
		Image imagedev=devimg.getImage();
		imagedev = imagedev.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), imagedev.SCALE_SMOOTH);
		devimg = new ImageIcon(imagedev);
		lblNewLabel.setIcon(devimg);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(128, 22, 46, 14);
		contentPane.add(lblName);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(128, 47, 46, 14);
		contentPane.add(lblEmail);

		JLabel devname = new JLabel("");
		devname.setText(dvname);
		devname.setBounds(170, 22, 113, 14);

		contentPane.add(devname);

		JLabel devemail = new JLabel("");
		devemail.setText(email);
		devemail.setBounds(170, 47, 113, 14);
		contentPane.add(devemail);

		JLabel label = new JLabel("");
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setBounds(117, 11, 426, 67);
		contentPane.add(label);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 89, 593, 537);
		contentPane.add(tabbedPane);

		vnfProfilePanel = new JPanel();
		tabbedPane.addTab("VNF Profile", null, vnfProfilePanel, null);

		JLabel lblVnfName = new JLabel("VNF name*");

		JLabel lblDescription = new JLabel("Description");

		JLabel lblVersion = new JLabel("Version*");

		JLabel lblNewLabel_1 = new JLabel("Type*");

		vnfname = new JTextField();
		vnfname.setColumns(10);

		vnfversion = new JTextField();
		vnfversion.setColumns(10);

		chckbxTranscoder = new JCheckBox("Transcoder");

		VikingManip VM = new VikingManip();
		// scrollPane_1.setViewportView(tranOpList);

		opList = new List();
		opList = VM.getTranscoderOp();

		// JList<String> TranscoderTechList = null;
		// TranscoderTechList = VM.getTranscoderTech();
		techList = new List();
		techList = VM.getTranscoderTech();
		standList = new List();
		standList = VM.getTranscoderStand();

		chckbxMixer = new JCheckBox("Mixer");
		transcoderPanel = new JPanel();
		tabbedPane.addTab("Transcoder", null, transcoderPanel, null);

		JLabel lblOperation = new JLabel("Operation*");

		JLabel lblTechnique = new JLabel("Technique");

		JLabel lblStandard = new JLabel("Standard");

		// JList tranOpList = new JList();
		// tranOpList = VM.getTranscoderOp();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		opList.setMultipleSelections(true);
		scrollPane_1.setViewportView(opList);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		selectedOp = new List();
		selectedOp.setMultipleSelections(true);
		scrollPane_2.setViewportView(selectedOp);
		JScrollPane scrollPane_3 = new JScrollPane(techList);
		techList.setMultipleSelections(true);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		List selectedTech = new List();
		scrollPane_4.setViewportView(selectedTech);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_5.setViewportView(standList);
		standList.setMultipleSelections(true);
		standList.setMultipleSelections(true);
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		List selectedStand = new List();
		scrollPane_6.setViewportView(selectedStand);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (String string : opList.getSelectedItems()) {
					boolean result = Arrays.stream(selectedOp.getItems()).anyMatch(string::equals);
					if (!result) {
					
						selectedOp.add(string);
						if (string=="Transmuxing") {
							chckbxFormat.setSelected(true);
						}else if (string=="Transcoding") {
							chckbxCodec.setSelected(true);
						}else if (string=="Transsizing") {
							chckbxResolution.setSelected(true);
						}
					}

				}
				
				

			}
		});

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (String string : techList.getSelectedItems()) {
					boolean result = Arrays.stream(selectedTech.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedTech.add(string);
					}

				}

			}
		});

		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String string : standList.getSelectedItems()) {
					boolean result = Arrays.stream(selectedStand.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedStand.add(string);
					}

				}
			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Content*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setLayout(null);

		trvideo = new JCheckBox("Video");

		/*
		 * trvideo.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * TrContentVideo = null; trvideo.setSelected(false); //
		 * chckbxFormat.setSelected(false); int lenght = selectedOp.getItems().length;
		 * 
		 * if (lenght == 0) { JOptionPane optionpane = new
		 * JOptionPane("you must select at least one Operation",
		 * JOptionPane.ERROR_MESSAGE); JDialog dialog =
		 * optionpane.createDialog("Select Operation"); dialog.setAlwaysOnTop(true);
		 * dialog.setVisible(true);
		 * 
		 * 
		 * 
		 * 
		 * } else { TrContentVideo = "Video"; VM.setTranscodingContent(vnfnm, "Video");
		 * try { trIO = new VideoAttTranscoder(); } catch (OWLOntologyCreationException
		 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * trIO.setVisible(true); }
		 * 
		 * } });
		 */

		trvideo.setBounds(66, 16, 97, 23);
		panel_5.add(trvideo);

		traudio = new JCheckBox("Audio");
		traudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (traudio.isSelected()) {
					TrContentAudio = "Audio";

				} else {
					TrContentAudio = null;

				}
			}
		});
		traudio.setBounds(229, 16, 97, 23);
		panel_5.add(traudio);

		trimage = new JCheckBox("Image");
		trimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (trimage.isSelected()) {
					TrContentImage = "Image";

				} else {
					TrContentImage = null;

				}
			}
		});
		trimage.setBounds(392, 16, 97, 23);
		panel_5.add(trimage);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "Content Attributes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setLayout(null);

		chckbxFormat = new JCheckBox("Format");
		chckbxFormat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					boolean result = Arrays.stream(selectedOp.getItems()).anyMatch("Transmuxing"::equals);
					if (!result) {
						selectedOp.add("Transmuxing");
					}

				
				
				

			}
		});
		chckbxFormat.setBounds(28, 25, 97, 23);
		panel_6.add(chckbxFormat);

		chckbxCodec = new JCheckBox("Codec");
		chckbxCodec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean result = Arrays.stream(selectedOp.getItems()).anyMatch("Transcoding"::equals);
				if (!result) {
					selectedOp.add("Transcoding");
				}
				
				
			}
		});
		chckbxCodec.setBounds(153, 25, 97, 23);
		panel_6.add(chckbxCodec);

		chckbxResolution = new JCheckBox("Resolution");
		chckbxResolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = Arrays.stream(selectedOp.getItems()).anyMatch("Transsizing"::equals);
				if (!result) {
					selectedOp.add("Transsizing");
				}
				
			}
		});
		chckbxResolution.setBounds(278, 25, 97, 23);
		panel_6.add(chckbxResolution);

		JButton btnSetInputoutput = new JButton("Set Input/Output");
		btnSetInputoutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((trvideo.isSelected() || traudio.isSelected() || trimage.isSelected())
						&& ( chckbxCodec.isSelected() || chckbxFormat.isSelected()
								|| chckbxResolution.isSelected())) {
					try {

						// DeveloperSpace ds;
						trIO = new TranscoderInputOutput(DeveloperSpace.this);

					} catch (OWLOntologyCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					trIO.setVisible(true);

				} else {
					JOptionPane optionpane = new JOptionPane(
							"you must select at least one Content and one Content attributs ",
							JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionpane.createDialog("Select Content and Content Attributs");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
			}

		});
		btnSetInputoutput.setBounds(381, 25, 145, 23);
		panel_6.add(btnSetInputoutput);

		JButton btnRemove = new JButton("Remove");

		JButton btnRemove_1 = new JButton("Remove");

		JButton btnRemove_2 = new JButton("Remove");
		GroupLayout gl_transcoderPanel = new GroupLayout(transcoderPanel);
		gl_transcoderPanel.setHorizontalGroup(
			gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_transcoderPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addComponent(lblOperation, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove))
							.addGap(10)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addComponent(lblTechnique, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove_1))
							.addGap(9)
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addComponent(lblStandard, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove_2))
							.addGap(9)
							.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
		);
		gl_transcoderPanel.setVerticalGroup(
			gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_transcoderPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addGap(37)
							.addComponent(lblOperation, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addGap(16)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(lblTechnique, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_transcoderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(lblStandard, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_transcoderPanel.createSequentialGroup()
							.addGap(31)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
		);
		transcoderPanel.setLayout(gl_transcoderPanel);

		mixOp = new List();
		mixOp = VM.getMixOp();

		mixTech = new List();
		mixTech = VM.getMixTech();

		chckbxCompressor = new JCheckBox("Compressor");
		compressorPanel = new JPanel();
		tabbedPane.addTab("Compressor", null, compressorPanel, null);

		JLabel lblOperation_2 = new JLabel("Operation*");

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_11.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		CompOp = new List();
		CompOp = VM.getCompOp();
		CompOp.setMultipleSelections(true);
		scrollPane_11.setViewportView(CompOp);

		JScrollPane scrollPane_12 = new JScrollPane();

		List selectedCompOp = new List();
		scrollPane_12.setViewportView(selectedCompOp);

		CompTech = new List();
		CompTech = VM.getCompTech();

		CompStand = new List();
		CompStand = VM.getCompStand();

		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (String string : CompOp.getSelectedItems()) {
					boolean result = Arrays.stream(selectedCompOp.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedCompOp.add(string);
					}

				}

			}
		});

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "Content*", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JCheckBox cmvd = new JCheckBox("Video");
		cmvd.setBounds(6, 16, 97, 23);
		panel_8.add(cmvd);

		JCheckBox cmaud = new JCheckBox("Audio");
		cmaud.setBounds(182, 16, 97, 23);
		panel_8.add(cmaud);

		JCheckBox cmim = new JCheckBox("Image");
		cmim.setBounds(350, 16, 97, 23);
		panel_8.add(cmim);

		JButton btnRemove_4 = new JButton("Remove");
		btnRemove_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblMaxSize = new JLabel("Max Size");

		JLabel lblNewLabel_3 = new JLabel("Technique");

		JLabel lblStandard_1 = new JLabel("Standard");

		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_13.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_13.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_13.setViewportView(CompTech);
		CompTech.setMultipleSelections(true);

		JScrollPane scrollPane_14 = new JScrollPane();

		selectedCompTech = new List();

		scrollPane_14.setViewportView(selectedCompTech);

		JScrollPane scrollPane_15 = new JScrollPane();
		scrollPane_15.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_15.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_15.setViewportView(CompStand);
		CompStand.setMultipleSelections(true);
		JScrollPane scrollPane_16 = new JScrollPane();

		selectedCompStand = new List();
		scrollPane_16.setViewportView(selectedCompStand);

		JButton btnNewButton_6 = new JButton("Add");

		JButton btnNewButton_7 = new JButton("Add");

		JButton btnRemove_5 = new JButton("Remove");

		JButton btnRemove_6 = new JButton("Remove");

		JSpinner maxsize = new JSpinner();

		JLabel lblUnit_1 = new JLabel("Unit");

		JComboBox sizeunit = new JComboBox();
		sizeunit.setModel(new DefaultComboBoxModel(new String[] { "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB" }));
		GroupLayout gl_compressorPanel = new GroupLayout(compressorPanel);
		gl_compressorPanel.setHorizontalGroup(
			gl_compressorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_compressorPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addComponent(lblOperation_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(scrollPane_11, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove_4))
							.addGap(10)
							.addComponent(scrollPane_12, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(scrollPane_13, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove_5))
							.addGap(10)
							.addComponent(scrollPane_14, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addComponent(lblStandard_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(scrollPane_15, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_7, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove_6))
							.addGap(10)
							.addComponent(scrollPane_16, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addComponent(lblMaxSize, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(maxsize, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_compressorPanel.createSequentialGroup()
									.addGap(35)
									.addComponent(sizeunit, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblUnit_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
		);
		gl_compressorPanel.setVerticalGroup(
			gl_compressorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_compressorPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(lblOperation_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_11, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(16)
							.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_12, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_13, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(14)
							.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_14, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(lblStandard_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_15, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(btnNewButton_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_16, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_compressorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblMaxSize, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(maxsize, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(sizeunit, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_compressorPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblUnit_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
		);
		compressorPanel.setLayout(gl_compressorPanel);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (String string : CompStand.getSelectedItems()) {
					boolean result = Arrays.stream(selectedCompStand.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedCompStand.add(string);
					}
				}

			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (String string : CompTech.getSelectedItems()) {
					boolean result = Arrays.stream(selectedCompTech.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedCompTech.add(string);
					}
				}
			}
		});

		JLabel lblCreatedOn = new JLabel("Created on*");

		JTextArea vnddesc = new JTextArea(10, 20);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if a VNF has at least one type

				if (!(chckbxTranscoder.isSelected()) && !(chckbxMixer.isSelected())
						&& !(chckbxCompressor.isSelected())) {
					// display error message to select a vnf type
					JOptionPane optionpane = new JOptionPane("you must select at least one VNF type",
							JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionpane.createDialog("Select VNF type");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);

				} else {
					btnNewButton_8.setEnabled(true);
					if (chckbxTranscoder.isSelected()) {
						selectedOp.removeAll();
						selectedTech.removeAll();
						selectedStand.removeAll();

						tabbedPane.addTab("Transcoder", null, transcoderPanel, null);
						/*
						 * try { VM.setVnfIndividualTypeTr(vnfnm, "Transcoder"); } catch
						 * (OWLOntologyStorageException e1) { // TODO Auto-generated catch block
						 * e1.printStackTrace(); }
						 */

						// panel_2.setEnabled(false);

					} else {
						tabbedPane.remove(transcoderPanel);

					}
					if (chckbxMixer.isSelected()) {
						selectedMixOp.removeAll();
						selectedMixTech.removeAll();
						tabbedPane.addTab("Mixer", null, mixerPanel, null);
						/*
						 * try { VM.setVnfIndividualTypeMx(vnfnm, "Mixer"); } catch
						 * (OWLOntologyStorageException e1) { // TODO Auto-generated catch block
						 * e1.printStackTrace(); }
						 */

					} else {
						tabbedPane.remove(mixerPanel);

					}

					if (chckbxCompressor.isSelected()) {
						selectedCompOp.removeAll();
						selectedCompTech.removeAll();
						selectedCompStand.removeAll();
						tabbedPane.addTab("Compressor", null, compressorPanel, null);
						/*
						 * try { VM.setVnfIndividualTypeCp(vnfnm, "Compressor"); } catch
						 * (OWLOntologyStorageException e1) { // TODO Auto-generated catch block
						 * e1.printStackTrace(); }
						 */
					} else {
						tabbedPane.remove(compressorPanel);

					}
					tabbedPane.addTab("Deployement description", null, deploymentPanel, null);
					tabbedPane.addTab("Non-Functional Properties", null, NFPpanel, null);

				}

			}

		});

		dateChooser = new JDateChooser();
		
		JLabel lblProvider = new JLabel("Provider*");
		
		JComboBox providercomcobox = new JComboBox();
		mixerPanel = new JPanel();
		List providers=new List();
		providers=VM.getProvider();
		providercomcobox.setModel(new DefaultComboBoxModel(providers.getItems()));
		GroupLayout gl_vnfProfilePanel = new GroupLayout(vnfProfilePanel);
		gl_vnfProfilePanel.setHorizontalGroup(
			gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(78)
							.addComponent(vnfname, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addComponent(lblVnfName, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(173)))
					.addGap(319))
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addComponent(lblDescription, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(173))
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(78)
							.addComponent(vnddesc, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
					.addGap(319))
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblVersion, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(vnfversion, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(320))
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(78)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCreatedOn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(chckbxTranscoder, GroupLayout.PREFERRED_SIZE, 97, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(chckbxMixer, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(chckbxCompressor, GroupLayout.PREFERRED_SIZE, 97, Short.MAX_VALUE)
					.addGap(163))
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblProvider, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(providercomcobox, 0, 189, Short.MAX_VALUE)
					.addGap(311))
				.addGroup(Alignment.TRAILING, gl_vnfProfilePanel.createSequentialGroup()
					.addGap(472)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		gl_vnfProfilePanel.setVerticalGroup(
			gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_vnfProfilePanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(vnfname, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblVnfName, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
							.addGap(3)))
					.addGap(8)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
							.addGap(29))
						.addComponent(vnddesc, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblVersion, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(vnfversion, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
					.addGap(25)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCreatedOn, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
							.addGap(5))
						.addComponent(chckbxTranscoder, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxMixer, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxCompressor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_vnfProfilePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vnfProfilePanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblProvider, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(providercomcobox, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
					.addGap(143)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		vnfProfilePanel.setLayout(gl_vnfProfilePanel);

		tabbedPane.addTab("Mixer", null, mixerPanel, null);

		JLabel lblOperation_1 = new JLabel("Operation*");

		JLabel lblTechnique_1 = new JLabel("Technique");

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_7.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_7.setViewportView(mixOp);
		mixOp.setMultipleSelections(true);

		JScrollPane scrollPane_8 = new JScrollPane();

		selectedMixOp = new List();
		scrollPane_8.setViewportView(selectedMixOp);
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_9.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_9.setViewportView(mixTech);
		mixTech.setMultipleSelections(true);

		JScrollPane scrollPane_10 = new JScrollPane();

		selectedMixTech = new List();
		scrollPane_10.setViewportView(selectedMixTech);

		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (String string : mixOp.getSelectedItems()) {
					boolean result = Arrays.stream(selectedMixOp.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedMixOp.add(string);
					}
				}
			}
		});

		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (String string : mixTech.getSelectedItems()) {
					boolean result = Arrays.stream(selectedMixTech.getItems()).anyMatch(string::equals);
					if (!result) {
						selectedMixTech.add(string);
					}
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JCheckBox mxvideo = new JCheckBox("Video");
		mxvideo.setBounds(120, 16, 97, 23);
		panel.add(mxvideo);

		JCheckBox mximage = new JCheckBox("Image");
		mximage.setBounds(337, 16, 97, 23);
		panel.add(mximage);

		JButton btnRemove_3 = new JButton("Remove");

		JButton button_2 = new JButton("Remove");
		GroupLayout gl_mixerPanel = new GroupLayout(mixerPanel);
		gl_mixerPanel.setHorizontalGroup(
			gl_mixerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mixerPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_mixerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mixerPanel.createSequentialGroup()
							.addComponent(lblOperation_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addGroup(gl_mixerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_mixerPanel.createSequentialGroup()
									.addGap(1)
									.addComponent(btnRemove_3)))
							.addGap(10)
							.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_mixerPanel.createSequentialGroup()
							.addComponent(lblTechnique_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(scrollPane_9, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_mixerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2))
							.addGap(10)
							.addComponent(scrollPane_10, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
		);
		gl_mixerPanel.setVerticalGroup(
			gl_mixerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mixerPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_mixerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mixerPanel.createSequentialGroup()
							.addGap(54)
							.addComponent(lblOperation_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_mixerPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_mixerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mixerPanel.createSequentialGroup()
							.addGap(38)
							.addComponent(lblTechnique_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_9, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_mixerPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_10, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
		);
		mixerPanel.setLayout(gl_mixerPanel);

		NFPpanel = new JPanel();
		tabbedPane.addTab("Non-Functional Properties", null, NFPpanel, null);

		JLabel lblDevice = new JLabel("Device");
		lblDevice.setBackground(new Color(240, 240, 240));
		l1 = new List();
		l1 = VM.getdevice();
		JScrollPane supporteddevices = new JScrollPane();
		supporteddevices.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		supporteddevices.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		

		supporteddevices.setViewportView(l1);
l1.setMultipleSelections(true);
		JScrollPane scrollPane = new JScrollPane();

		List selecteddevices = new List();
		scrollPane.setViewportView(selecteddevices);

		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (String string : l1.getSelectedItems()) {
					boolean result = Arrays.stream(selecteddevices.getItems()).anyMatch(string::equals);
					if (!result) {
						selecteddevices.add(string);
					}
				}
				
			}
		});

		JButton btnRemove_7 = new JButton("Remove");
		listfeature= new List();
		listfeature = VM.getfeature();
		JScrollPane scrollPane_17 = new JScrollPane();
		scrollPane_17.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_17.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_17.setViewportView(listfeature);
		listfeature.setMultipleSelections(true);

		JScrollPane scrollPane_18 = new JScrollPane();

		List selectefeature = new List();
		scrollPane_18.setViewportView(selectefeature);

		JButton button_4 = new JButton("Add");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (String string : listfeature.getSelectedItems()) {
					boolean result = Arrays.stream(selectefeature.getItems()).anyMatch(string::equals);
					if (!result) {
						selectefeature.add(string);
					}
				}
				
			}
		});

		JButton button_5 = new JButton("Remove");

		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBackground(new Color(240, 240, 240));

		JSpinner cost = new JSpinner();
		cost.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

		JComboBox currency = new JComboBox();
		currency.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR ", ""}));
		
		JLabel lblFeature = new JLabel("Feature");
		lblFeature.setBackground(SystemColor.menu);
		
		JLabel lblProposedCost = new JLabel("Proposed Cost");
		lblProposedCost.setBackground(SystemColor.menu);
		GroupLayout gl_NFPpanel = new GroupLayout(NFPpanel);
		gl_NFPpanel.setHorizontalGroup(
			gl_NFPpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NFPpanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_NFPpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addComponent(lblDevice, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(supporteddevices, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_NFPpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove_7))
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addComponent(lblFeature, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(scrollPane_17, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_NFPpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_5))
							.addGap(10)
							.addComponent(scrollPane_18, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addComponent(lblProposedCost, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(cost, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(lblCurrency, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(currency, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
		);
		gl_NFPpanel.setVerticalGroup(
			gl_NFPpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NFPpanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_NFPpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblDevice, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(supporteddevices, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(20)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnRemove_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_NFPpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(42)
							.addComponent(lblFeature, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_17, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(20)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_18, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(76)
					.addGroup(gl_NFPpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblProposedCost, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(cost, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblCurrency, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_NFPpanel.createSequentialGroup()
							.addGap(2)
							.addComponent(currency, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
		);
		NFPpanel.setLayout(gl_NFPpanel);

		deploymentPanel = new JPanel();
		tabbedPane.addTab("Deployment description", null, deploymentPanel, null);

		JLabel lblDeployementDescription = new JLabel("Deployment description URL*");

		deployementurl = new JTextField();
		deployementurl.setColumns(10);
		final JFrame frame = new JFrame();

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(
				new TitledBorder(null, "Deployment requirements", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setLayout(null);

		JLabel lblCpu = new JLabel("Number of CPU*");
		lblCpu.setBounds(6, 54, 120, 14);
		panel_10.add(lblCpu);

		JLabel lblMemory = new JLabel("Memory*");
		lblMemory.setBounds(6, 104, 57, 14);
		panel_10.add(lblMemory);

		JLabel lblNetwork = new JLabel("Network* ");
		lblNetwork.setBounds(6, 163, 57, 14);
		panel_10.add(lblNetwork);

		JLabel lblStorage = new JLabel("Storage*");
		lblStorage.setBounds(6, 228, 72, 14);
		panel_10.add(lblStorage);

		JSpinner cpu = new JSpinner();
		cpu.setBounds(127, 49, 72, 23);
		panel_10.add(cpu);

		JSpinner memory = new JSpinner();
		memory.setBounds(127, 99, 72, 23);
		panel_10.add(memory);

		JSpinner network = new JSpinner();
		network.setBounds(127, 158, 72, 23);
		panel_10.add(network);

		JSpinner storage = new JSpinner();
		storage.setBounds(127, 223, 72, 23);
		panel_10.add(storage);

		JLabel label_3 = new JLabel("Unit");
		label_3.setBounds(260, 104, 46, 14);
		panel_10.add(label_3);

		JLabel label_4 = new JLabel("Unit");
		label_4.setBounds(260, 163, 46, 14);
		panel_10.add(label_4);

		JLabel label_5 = new JLabel("Unit");
		label_5.setBounds(260, 228, 46, 14);
		panel_10.add(label_5);

		JComboBox memoryunit = new JComboBox();
		memoryunit.setModel(new DefaultComboBoxModel(new String[] {"KB", "MB", "GB", "TB"}));
		memoryunit.setBounds(335, 102, 57, 23);
		panel_10.add(memoryunit);

		JComboBox networkunit = new JComboBox();
		networkunit.setModel(new DefaultComboBoxModel(new String[] { "kbps", "MBPS", "GBPS", "TBPS" }));
		networkunit.setBounds(335, 161, 57, 23);
		panel_10.add(networkunit);

		JComboBox storageunit = new JComboBox();
		storageunit.setModel(new DefaultComboBoxModel(new String[] {"KB", "MB", "GB", "TB"}));
		storageunit.setBounds(335, 226, 57, 23);
		panel_10.add(storageunit);

		JLabel lblVnfPackage = new JLabel("VNF package URL*");

		VNFpackage = new JTextField();
		VNFpackage.setColumns(10);
		GroupLayout gl_deploymentPanel = new GroupLayout(deploymentPanel);
		gl_deploymentPanel.setHorizontalGroup(
			gl_deploymentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deploymentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDeployementDescription, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(deployementurl, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_deploymentPanel.createSequentialGroup()
					.addGap(4)
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_deploymentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblVnfPackage, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(VNFpackage, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
		);
		gl_deploymentPanel.setVerticalGroup(
			gl_deploymentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deploymentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_deploymentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_deploymentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDeployementDescription, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(deployementurl, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(gl_deploymentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_deploymentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblVnfPackage, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(VNFpackage, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
		);
		deploymentPanel.setLayout(gl_deploymentPanel);

		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(444, 43, 89, 23);
		contentPane.add(btnProfile);

		btnNewButton_8 = new JButton("Finish");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				providername=providercomcobox.getSelectedItem().toString();
				vnfnm = vnfname.getText();
				vnfnm = vnfnm.replaceAll(" ", "_").toLowerCase();
				dsc = vnddesc.getText();
				version = vnfversion.getText();
				vnfcreatedate = dateChooser.getDateFormatString();
				depurl = deployementurl.getText();
				vnfcpu = (int)cpu.getValue();
				vnfnetwork = (int) network.getValue();
				vnfstorage = (int) storage.getValue();
				vnfmemory = (int) memory.getValue();
				vnfnetworkunit = networkunit.getSelectedItem().toString();
				vnfstorageunit = storageunit.getSelectedItem().toString();
				vnfmemoryunit = memoryunit.getSelectedItem().toString();
				vnfurl = VNFpackage.getText();

				if (vnfnm.isEmpty() || version.isEmpty()
						|| (!chckbxMixer.isSelected() & !chckbxTranscoder.isSelected() & !chckbxCompressor.isSelected())
						|| depurl.isEmpty() || vnfcpu==0 || vnfnetwork==0 || vnfstorage==0
						|| vnfmemory==0 || vnfurl.isEmpty()) {
					JOptionPane optionpane = new JOptionPane("you must enter all required information ",
							JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionpane.createDialog("enter all required information,please");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				} else {
					try {
						VM.setVnfIndividual(vnfnm,providername);
						VM.setVNFIDDataProperty(vnfnm, (vnfnm + (int) (Math.random() * 14563)));
						VM.setVNFVersionDataProperty(vnfnm, version);
					} catch (OWLOntologyStorageException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (!dsc.isEmpty()) {
						try {
							VM.setVNFdescDataProperty(vnfverion, dsc);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					if (!vnfcreatedate.isEmpty()) {
						try {
							VM.setVNFdateDataProperty(vnfnm, vnfcreatedate);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					if (chckbxTranscoder.isSelected()) {
						try {
							trvnfnm = "Tr_" + vnfnm;
							VM.setVnfIndividualTypeTr(trvnfnm);
							VM.setVNFistypeoftr(vnfnm, trvnfnm);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						trOp = selectedOp.getItems();
						trTech = selectedTech.getItems();
						trStand = selectedStand.getItems();
						trVideoCt = trvideo.isSelected();
						trAudioCt = traudio.isSelected();
						trImageCt = trimage.isSelected();
						trfromat = chckbxFormat.isSelected();
						trcodec = chckbxCodec.isSelected();
						trresolution = chckbxResolution.isSelected();
						////////////////////

						///////////////////////
						try {
							for (String i : trTech) {
								VM.setTranscoderTech(trvnfnm, i);
								System.out.println("test the arraystring " + i);
							}
							for (String i : trOp) {
								VM.setTranscoderOp(trvnfnm, i);
							}
							for (String i : trStand) {
								VM.setTranscoderStand(trvnfnm, i);
							}
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (trVideoCt) {
							try {
								VM.setVideoContent(trvnfnm, "Video");
							} catch (OWLOntologyStorageException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (trfromat) {

								for (String i : trVideoFI) {
									try {
										VM.setTrVideoFormatI(trvnfnm, trVideoFI);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trVideoFO) {
									try {
										VM.setTrVideoFormatO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							if (trcodec) {
								for (String i : trVideoCI) {
									try {
										VM.setTrVideoCodecI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trVideoCO) {
									try {
										VM.setTrVideoCodecO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							if (trresolution) {
								for (String i : trVideoRI) {
									try {
										VM.setTrVideoResolutionI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trVideoRO) {
									try {
										VM.setTrVideoResolutionO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							

						}
						////////////////////////////////

						if (trAudioCt) {
							try {
								VM.setAudioContent(trvnfnm);
							} catch (OWLOntologyStorageException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (trfromat) {

								for (String i : trAudioFI) {
									try {
										System.out.println("trvideoFI before just saving " + i);
										VM.setTrAudioFormatI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trAudioFO) {
									try {
										VM.setTrAudioFormatO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							if (trcodec) {
								for (String i : trAudioCI) {
									try {
										VM.setTrAudioCodecI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trAudioCO) {
									try {
										VM.setTrAudioCodecO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							if (trresolution) {
								for (String i : trAudioRI) {
									try {
										VM.setTrAudioResolutionI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trAudioRO) {
									try {
										VM.setTrAudioResolutionO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						

						}
						////////////////////////////////////////////////////////////
						if (trImageCt) {
							try {
								VM.setImageContent(trvnfnm);
							} catch (OWLOntologyStorageException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (trfromat) {

								for (String i : trImageFI) {
									try {
										System.out.println("trvideoFI before just saving " + i);
										VM.setTrImageFormatI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trImageFO) {
									try {
										VM.setTrImageFormatO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}

							if (trresolution) {
								for (String i : trImageRI) {
									try {
										VM.setTrImageResolutionI(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

								for (String i : trImageRO) {
									try {
										VM.setTrImageResolutionO(trvnfnm, i);
									} catch (OWLOntologyStorageException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							

						}
					}
				}

				if (chckbxCompressor.isSelected()) {

					CmOp = selectedCompOp.getItems();
					CmTech = selectedCompTech.getItems();
					CmStand = selectedCompStand.getItems();
					CmVideoCt = cmvd.isSelected();
					CmImageCt = cmim.isSelected();
					CmAudioCt = cmaud.isSelected();
					CmMaxSize = maxsize.getValue().toString();
					sizeunt = sizeunit.getSelectedItem().toString();
					System.out.println("the max size of the compressor is " + CmMaxSize + sizeunt);
					cmvnfnm = "Cm_" + vnfnm;
					try {
						VM.setVnfIndividualTypeCp("Cm_" + vnfnm);
						VM.setVNFistypeofCp(vnfnm, "Cm_" + vnfnm);
					} catch (OWLOntologyStorageException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (String i : CmOp) {
						try {
							VM.setCompOp(cmvnfnm, i);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					for (String i : CmTech) {

						try {
							VM.setCompTech(cmvnfnm, i);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for (String i : CmStand) {
						try {
							VM.setCompStand(cmvnfnm, i);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if (CmVideoCt) {
						try {
							VM.setVideoContent(cmvnfnm, "Video");
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if (CmAudioCt) {
						try {
							VM.setAudioContent(cmvnfnm);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if (CmImageCt) {
						try {
							VM.setImageContent(cmvnfnm);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if (!CmMaxSize.isEmpty()) {
						try {
							VM.setCompMaxSizeind(CmMaxSize + sizeunt);
							VM.setCompMaxSize(cmvnfnm, CmMaxSize + sizeunt);
						} catch (OWLOntologyStorageException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
				if (chckbxMixer.isSelected()) {
					mxvnfnm = "Mx_" + vnfnm;
					try {
						VM.setVnfIndividualTypeMx("Mx_" + vnfnm);
						VM.setVNFistypeofmx(vnfnm, "Mx_" + vnfnm);
					} catch (OWLOntologyStorageException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MxOp = selectedMixOp.getItems();
					MxTech = selectedMixTech.getItems();
					MxVideoCt = mxvideo.isSelected();
					MxImageCt = mximage.isSelected();
					for (String i : MxOp) {

						try {
							VM.setMixOp(mxvnfnm, i);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for (String i : MxTech) {

						try {
							VM.setMixTech(mxvnfnm, i);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (MxVideoCt) {
						try {
							VM.setVideoContent(mxvnfnm, "Video");
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if (MxImageCt) {
						try {
							VM.setImageContent(mxvnfnm);
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
				device = selecteddevices.getItems();
				for (String i : device) {
					try {
						VM.setdevice(vnfnm, i);
					} catch (OWLOntologyStorageException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				feature = selectefeature.getItems();
				for (String i : feature) {
					try {
						VM.setfeature(vnfnm, i);
					} catch (OWLOntologyStorageException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				price = Double.parseDouble(cost.getValue().toString());
				crcy = currency.getSelectedItem().toString();

				if (price!=0 && !crcy.isEmpty()) {
					try {
						VM.setpropasedprice(vnfnm, price, crcy);
					} catch (OWLOntologyStorageException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				try {
					VM.setVNFdeployementdescription(vnfnm, vnfnetwork , vnfnetworkunit, vnfcpu,
							vnfmemory ,vnfmemoryunit, vnfstorage , vnfstorageunit, depurl, vnfurl);
				} catch (OWLOntologyStorageException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Your VNF descriptor is well stored on https://https://w3id.org/laas.iot/viking", "VNF description process: ", JOptionPane.INFORMATION_MESSAGE);
				//setVisible(false);
				System.exit(0); // stop program
				frame.dispose(); // close window
				frame.setVisible(false); // hide window

			}
		});
		btnNewButton_8.setEnabled(false);
		btnNewButton_8.setBounds(534, 637, 89, 23);
		contentPane.add(btnNewButton_8);

		setTitle("Developer Space");
	}

	public void Developer(String[] trAudioFI, String[] trAudioFO, String[] trAudioCI, String[] trAudioCO,
			String[] trAudioRI, String[] trAudioRO,  int trAudioBMxI,
			int trAudioBMxO, String[] trVideoFI, String[] trVideoFO, String[] trVideoCI, String[] trVideoCO,
			String[] trVideoRI, String[] trVideoRO,int trVideoBMxI,
			int trVideoBMxO, String[] trImageFI, String[] trImageFO, String[] trImageRI, String[] trImageRO,
			 int trImageBMxI, int trImageBMxO) {
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
		this.trImageRI = trImageRI;
		this.trImageBMxI = trImageBMxI;

		this.trImageFO = trImageFO;
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

	/*
	 * public void savetrIO(String[] trAudioFI,String[] trAudioFO, String[]
	 * trAudioCI,String[] trAudioCO,String[] trAudioRI, String[]trAudioRO, String
	 * trAudioBMnI, String trAudioBMnO, String trAudioBMxI, String trAudioBMxO,
	 * String[] trVideoFI, String[] trVideoFO,String[] trVideoCI,String[]
	 * trVideoCO,String[] trVideoRI,String[] trVideoRO,String trVideoBMnI,String
	 * trVideoBMnO,String trVideoBMxI,String trVideoBMxO, String[]
	 * trImageFI,String[] trImageFO,String[] trImageCI,String[] trImageCO,String[]
	 * trImageRI,String[] trImageRO,String trImageBMnI,String trImageBMnO,String
	 * trImageBMxI,String trImageBMxO) {
	 * 
	 * this.trVideoFI = trVideoFI; this.trVideoCI = trVideoCI; this.trVideoRI =
	 * trVideoRI; this.trVideoBMnI = trVideoBMnI; this.trVideoBMxI = trVideoBMxI;
	 * 
	 * this.trVideoFO = trVideoFO; this.trVideoFO = trVideoFO; this.trVideoRO =
	 * trVideoRO; this.trVideoBMnO = trVideoBMnO; this.trVideoBMxO = trVideoBMxO;
	 * 
	 * this.trImageFI = trImageFI; this.trImageCI = trImageCI; this.trImageRI =
	 * trImageRI; this.trImageBMnI = trImageBMnI; this.trImageBMxI = trImageBMxI;
	 * 
	 * this.trImageFO = trImageFO; this.trImageCO = trImageCO; this.trImageRO =
	 * trImageRO; this.trImageBMnO = trImageBMnO; this.trImageBMxO = trImageBMxO;
	 * 
	 * this.trAudioFI = trAudioFI; this.trAudioCI = trAudioCI; this.trAudioRI =
	 * trAudioRI; this.trAudioBMnI = trAudioBMnI; this.trAudioBMxI = trAudioBMxI;
	 * 
	 * this.trAudioFO = trAudioFO; this.trAudioCO = trAudioCO ; this.trAudioRO =
	 * trAudioRO; this.trAudioBMnO = trAudioBMnO; this.trAudioBMxO = trAudioBMxO ;
	 * System.out.println("c bn");
	 * 
	 * 
	 * }
	 */
	public void afficher(List troplist) {
		System.out.println("the new " + troplist.getItem(1));
		selectedOp = troplist;
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		// scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(84, 11, 206, 93);
		transcoderPanel.add(scrollPane_2);

		// selectedOp = new List();
		scrollPane_2.setViewportView(troplist);
	}
}
