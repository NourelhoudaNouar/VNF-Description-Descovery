package visundGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import javax.swing.JLabel;
import java.awt.List;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JComboBox;
import java.awt.TextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TranscoderInputOutput extends JFrame {
	DeveloperSpace ds;
	private JPanel contentPane;
	VikingManip VM;

	List videoFormatList, audioFormatlist, imageFormatList, listaudio, listimage, resolutionlist, videoformat,
			videoresolution, videocodec, formatoutputlist, codecoutputlist, resolutionoutputlist;
	private final List audioresolutionoutput = new List();
	String[] trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO, trVideoFI, trVideoFO, trVideoCI,
			trVideoCO, trVideoRI, trVideoRO, trImageFI, trImageFO, trImageCI, trImageCO, trImageRI, trImageRO;
	int  trVideoBMxI, trVideoBMxO,  trImageBMxI, trImageBMxO,
			 trAudioBMxI, trAudioBMxO;

	public TranscoderInputOutput(DeveloperSpace ds) throws OWLOntologyCreationException {
		this.ds = ds;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\adminnennouar\\eclipse-workspace\\VNFDescription\\imgs\\icon-video-converter.png"));
		setTitle("Transcoder Content Attributs Input/Output");
		VM = new VikingManip();

		audioFormatlist = VM.getAudioFormat();
		imageFormatList = VM.getImageFormat();
		resolutionlist = VM.getResolution();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		videoformat = new List();
		videoformat = VM.getVideoFormat();

		formatoutputlist = new List();
		formatoutputlist = VM.getVideoFormat();

		codecoutputlist = new List();
		codecoutputlist = VM.getVideoCodec();

		resolutionoutputlist = new List();
		resolutionoutputlist = VM.getResolution();
		videocodec = new List();
		videocodec = VM.getVideoCodec();

		videoresolution = new List();
		videoresolution = VM.getResolution();

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel_10 = new JPanel();
		tabbedPane_1.addTab("Video", null, panel_10, null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Input", null, panel, null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Video Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(12, 30, 166, 78);
		panel_2.add(scrollPane);
		scrollPane.setViewportView(videoformat);
		videoformat.setMultipleSelections(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(353, 30, 166, 78);
		panel_2.add(scrollPane_1);

		List selectedvideoformatlist = new List();
		scrollPane_1.setViewportView(selectedvideoformatlist);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Output", null, panel_1, null);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Video Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_6.setBounds(12, 30, 166, 78);
		panel_6.add(scrollPane_6);
		scrollPane_6.setViewportView(formatoutputlist);
		formatoutputlist.setMultipleSelections(true);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(353, 30, 166, 78);
		panel_6.add(scrollPane_7);

		List selectedformatoutput = new List();
		selectedformatoutput.setSize(164, 78);
		scrollPane_7.setViewportView(selectedformatoutput);

		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedformatoutput.add(formatoutputlist.getSelectedItem());
			}
		});
		button.setBounds(219, 28, 89, 23);
		panel_6.add(button);

		JButton button_1 = new JButton("Remove");
		button_1.setBounds(219, 79, 89, 23);
		panel_6.add(button_1);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "Video Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(12, 22, 166, 78);
		panel_7.add(scrollPane_8);
		scrollPane_8.setViewportView(codecoutputlist);
		codecoutputlist.setMultipleSelections(true);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(353, 22, 166, 78);
		panel_7.add(scrollPane_9);

		List selectedcodecoutput = new List();
		scrollPane_9.setViewportView(selectedcodecoutput);
		selectedcodecoutput.setMultipleSelections(true);

		JButton button_2 = new JButton("Add");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedcodecoutput.add(codecoutputlist.getSelectedItem());
			}
		});
		button_2.setBounds(225, 28, 89, 23);
		panel_7.add(button_2);

		JButton button_3 = new JButton("Remove");
		button_3.setBounds(225, 79, 89, 23);
		panel_7.add(button_3);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(12, 23, 166, 78);
		panel_8.add(scrollPane_10);
		scrollPane_10.setViewportView(resolutionoutputlist);

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(353, 23, 166, 78);
		panel_8.add(scrollPane_11);

		List selectedresolutionoutput = new List();
		scrollPane_11.setViewportView(selectedresolutionoutput);

		JButton button_4 = new JButton("Add");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedresolutionoutput.add(resolutionoutputlist.getSelectedItem());
			}
		});
		button_4.setBounds(219, 28, 89, 23);
		panel_8.add(button_4);

		JButton button_5 = new JButton("Remove");
		button_5.setBounds(219, 79, 89, 23);
		panel_8.add(button_5);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(97))
		);
		panel_1.setLayout(gl_panel_1);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(videoformat.getSelectedItem());
				selectedvideoformatlist.add(videoformat.getSelectedItem());

			}
		});
		btnAdd.setBounds(219, 28, 89, 23);
		panel_2.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(219, 79, 89, 23);
		panel_2.add(btnRemove);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Video Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 22, 166, 78);
		panel_3.add(scrollPane_2);
		scrollPane_2.setViewportView(videocodec);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(353, 22, 166, 78);
		panel_3.add(scrollPane_3);

		List selectedvideocodec = new List();
		selectedvideocodec.setLocation(370, 0);
		selectedvideocodec.setSize(164, 78);
		scrollPane_3.setViewportView(selectedvideocodec);

		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedvideocodec.add(videocodec.getSelectedItem());
			}
		});
		btnAdd_1.setBounds(225, 28, 89, 23);
		panel_3.add(btnAdd_1);

		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(225, 79, 89, 23);
		panel_3.add(btnRemove_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(12, 23, 166, 78);
		panel_4.add(scrollPane_4);
		scrollPane_4.setViewportView(videoresolution);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(353, 23, 166, 78);
		panel_4.add(scrollPane_5);

		List selectedvideoresolution = new List();
		selectedvideoresolution.setLocation(0, 16);
		selectedvideoresolution.setSize(164, 93);
		scrollPane_5.setViewportView(selectedvideoresolution);

		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedvideoresolution.add(videoresolution.getSelectedItem());
			}
		});
		btnAdd_2.setBounds(219, 28, 89, 23);
		panel_4.add(btnAdd_2);

		JButton btnRemove_2 = new JButton("Remove");
		btnRemove_2.setBounds(219, 79, 89, 23);
		panel_4.add(btnRemove_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(97))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane)
					.addGap(10))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
		);
		panel_10.setLayout(gl_panel_10);

		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("Image", null, panel_11, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel_12 = new JPanel();
		tabbedPane_2.addTab("Input", null, panel_12, null);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(null, "Image Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		List listImageFormat = VM.getImageFormat();
		JScrollPane imageformatlist = new JScrollPane(listImageFormat);
		imageformatlist.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		imageformatlist.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		// panel_14.setViewportView(imageformatlist);

		JScrollPane imageformat5 = new JScrollPane();

		List imageformatinput = new List();
		imageformat5.setViewportView(imageformatinput);

		JButton button_6 = new JButton("Add");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				imageformatinput.add(listImageFormat.getSelectedItem());
			}
		});

		JButton button_7 = new JButton("Remove");
		List ListImageCodec = VM.getImageCodec();

		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List Listimageresolution = VM.getResolution();
		JScrollPane imageresolutionlist = new JScrollPane(Listimageresolution);

		JScrollPane imageresolution1 = new JScrollPane();

		List imageresolutioninput = new List();
		imageresolution1.setViewportView(imageresolutioninput);

		JButton button_10 = new JButton("Add");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageresolutioninput.add(Listimageresolution.getSelectedItem());
			}
		});

		JButton button_11 = new JButton("Remove");
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_17, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(61)
					.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(panel_17, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(174))
		);
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(6)
					.addComponent(imageformatlist, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_7))
					.addGap(45)
					.addComponent(imageformat5, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(8)
					.addComponent(imageformatlist, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(6)
					.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(8)
					.addComponent(imageformat5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_14.setLayout(gl_panel_14);
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(6)
					.addComponent(imageresolutionlist, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_17.createParallelGroup(Alignment.LEADING)
						.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11))
					.addGap(45)
					.addComponent(imageresolution1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_17.setVerticalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(1)
					.addComponent(imageresolutionlist, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(6)
					.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(1)
					.addComponent(imageresolution1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_17.setLayout(gl_panel_17);
		panel_12.setLayout(gl_panel_12);

		JPanel panel_13 = new JPanel();
		tabbedPane_2.addTab("Output", null, panel_13, null);

		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new TitledBorder(null, "Image Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List ListImageformat = VM.getImageFormat();
		JScrollPane imageformatlist1 = new JScrollPane(ListImageformat);
		imageformatlist1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		imageformatlist1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane imageformat2 = new JScrollPane();

		List imageformatoutput = new List();
		imageformat2.setViewportView(imageformatoutput);

		JButton button_12 = new JButton("Add");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageformatoutput.add(ListImageformat.getSelectedItem());
			}
		});

		JButton button_13 = new JButton("Remove");

		List listImageCodec = VM.getImageCodec();

		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List listresolution = VM.getResolution();
		JScrollPane imageresolutionlist1 = new JScrollPane(listresolution);

		JScrollPane resolution2 = new JScrollPane();

		List imageresolutionoutput = new List();
		resolution2.setViewportView(imageresolutionoutput);

		JButton button_16 = new JButton("Add");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageresolutionoutput.add(listresolution.getSelectedItem());
			}
		});

		JButton button_17 = new JButton("Remove");
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_19, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_21, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(61)
					.addComponent(panel_19, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(panel_21, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(174))
		);
		GroupLayout gl_panel_19 = new GroupLayout(panel_19);
		gl_panel_19.setHorizontalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(6)
					.addComponent(imageformatlist1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_13))
					.addGap(45)
					.addComponent(imageformat2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_19.setVerticalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(8)
					.addComponent(imageformatlist1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(6)
					.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(8)
					.addComponent(imageformat2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_19.setLayout(gl_panel_19);
		GroupLayout gl_panel_21 = new GroupLayout(panel_21);
		gl_panel_21.setHorizontalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_21.createSequentialGroup()
					.addGap(6)
					.addComponent(imageresolutionlist1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_21.createParallelGroup(Alignment.LEADING)
						.addComponent(button_16, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_17))
					.addGap(45)
					.addComponent(resolution2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_21.setVerticalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_21.createSequentialGroup()
					.addGap(1)
					.addComponent(imageresolutionlist1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_21.createSequentialGroup()
					.addGap(6)
					.addComponent(button_16, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_17, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_21.createSequentialGroup()
					.addGap(1)
					.addComponent(resolution2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_21.setLayout(gl_panel_21);
		panel_13.setLayout(gl_panel_13);
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane_2)
					.addGap(10))
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
		);
		panel_11.setLayout(gl_panel_11);

		JPanel panel_18 = new JPanel();
		tabbedPane_1.addTab("Audio", null, panel_18, null);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel_23 = new JPanel();
		tabbedPane_3.addTab("Input", null, panel_23, null);

		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new TitledBorder(null, "Audio Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List listaudioformat = VM.getAudioFormat();
		JScrollPane audioformatlist = new JScrollPane(listaudioformat);
		audioformatlist.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		audioformatlist.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane audioformat2 = new JScrollPane();

		List audioformatinput = new List();
		audioformat2.setViewportView(audioformatinput);

		JButton button_18 = new JButton("Add");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audioformatinput.add(listaudioformat.getSelectedItem());
			}
		});

		JButton button_19 = new JButton("Remove");

		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new TitledBorder(null, "Audio Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List listaudiocodec = VM.getAudioCodec();
		JScrollPane audiocodeclist = new JScrollPane(listaudiocodec);

		JScrollPane audiocodec2 = new JScrollPane();

		List audiocodecinput = new List();
		audiocodec2.setViewportView(audiocodecinput);

		JButton button_20 = new JButton("Add");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audiocodecinput.add(listaudiocodec.getSelectedItem());
			}
		});

		JButton button_21 = new JButton("Remove");

		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List listaudioresolution = VM.getResolution();
		JScrollPane audioresolutionlist = new JScrollPane(listaudioresolution);

		JScrollPane audioresolution2 = new JScrollPane();

		List audioresolutioninput = new List();
		audioresolution2.setViewportView(audioresolutioninput);

		JButton button_22 = new JButton("Add");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audioresolutioninput.add(listaudioresolution.getSelectedItem());
			}
		});

		JButton button_23 = new JButton("Remove");
		GroupLayout gl_panel_23 = new GroupLayout(panel_23);
		gl_panel_23.setHorizontalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_23.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_23.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_25, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_26, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_27, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_panel_23.setVerticalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_23.createSequentialGroup()
					.addGap(23)
					.addComponent(panel_25, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_26, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_27, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(91))
		);
		GroupLayout gl_panel_25 = new GroupLayout(panel_25);
		gl_panel_25.setHorizontalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_25.createSequentialGroup()
					.addGap(6)
					.addComponent(audioformatlist, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_25.createParallelGroup(Alignment.LEADING)
						.addComponent(button_18, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_19))
					.addGap(45)
					.addComponent(audioformat2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_25.setVerticalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_25.createSequentialGroup()
					.addGap(8)
					.addComponent(audioformatlist, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_25.createSequentialGroup()
					.addGap(6)
					.addComponent(button_18, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_19, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_25.createSequentialGroup()
					.addGap(8)
					.addComponent(audioformat2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_25.setLayout(gl_panel_25);
		GroupLayout gl_panel_26 = new GroupLayout(panel_26);
		gl_panel_26.setHorizontalGroup(
			gl_panel_26.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_26.createSequentialGroup()
					.addGap(6)
					.addComponent(audiocodeclist, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_panel_26.createParallelGroup(Alignment.LEADING)
						.addComponent(button_20, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_21))
					.addGap(39)
					.addComponent(audiocodec2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_26.setVerticalGroup(
			gl_panel_26.createParallelGroup(Alignment.LEADING)
				.addComponent(audiocodeclist, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_26.createSequentialGroup()
					.addGap(6)
					.addComponent(button_20, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_21, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addComponent(audiocodec2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
		);
		panel_26.setLayout(gl_panel_26);
		GroupLayout gl_panel_27 = new GroupLayout(panel_27);
		gl_panel_27.setHorizontalGroup(
			gl_panel_27.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_27.createSequentialGroup()
					.addGap(6)
					.addComponent(audioresolutionlist, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_27.createParallelGroup(Alignment.LEADING)
						.addComponent(button_22, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_23))
					.addGap(45)
					.addComponent(audioresolution2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_27.setVerticalGroup(
			gl_panel_27.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_27.createSequentialGroup()
					.addGap(1)
					.addComponent(audioresolutionlist, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_27.createSequentialGroup()
					.addGap(6)
					.addComponent(button_22, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_23, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_27.createSequentialGroup()
					.addGap(1)
					.addComponent(audioresolution2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_27.setLayout(gl_panel_27);
		panel_23.setLayout(gl_panel_23);

		JPanel panel_24 = new JPanel();
		tabbedPane_3.addTab("Output", null, panel_24, null);

		JPanel panel_29 = new JPanel();
		panel_29.setBorder(new TitledBorder(null, "Audio Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List Listaudioformat = VM.getAudioFormat();
		JScrollPane audioformatlist1 = new JScrollPane(Listaudioformat);
		audioformatlist1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		audioformatlist1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane audioformat1 = new JScrollPane();

		List audioformatoutput = new List();
		audioformat1.setViewportView(audioformatoutput);

		JButton button_24 = new JButton("Add");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				audioformatoutput.add(Listaudioformat.getSelectedItem());
			}
		});

		JButton button_25 = new JButton("Remove");

		JPanel panel_30 = new JPanel();
		panel_30.setBorder(new TitledBorder(null, "Audio Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List listaudiocodec1 = VM.getAudioCodec();
		JScrollPane audiocodeclist1 = new JScrollPane(listaudiocodec1);

		JScrollPane audiocodec1 = new JScrollPane();

		List audiocodecoutput = new List();
		audiocodec1.setViewportView(audiocodecoutput);

		JButton button_26 = new JButton("Add");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audiocodecoutput.add(listaudiocodec1.getSelectedItem());
			}
		});

		JButton button_27 = new JButton("Remove");

		JPanel panel_31 = new JPanel();
		panel_31.setBorder(new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List listaudioresolution2 = VM.getResolution();
		JScrollPane audioresolutionlist1 = new JScrollPane(listaudioresolution2);

		JScrollPane audioresolution1 = new JScrollPane();
		audioresolution1.setViewportView(audioresolutionoutput);

		JButton button_28 = new JButton("Add");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audioresolutionoutput.add(listaudioresolution2.getSelectedItem());

			}
		});

		JButton button_29 = new JButton("Remove");
		GroupLayout gl_panel_24 = new GroupLayout(panel_24);
		gl_panel_24.setHorizontalGroup(
			gl_panel_24.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_24.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_24.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_29, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_30, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addComponent(panel_31, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_panel_24.setVerticalGroup(
			gl_panel_24.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_24.createSequentialGroup()
					.addGap(23)
					.addComponent(panel_29, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_30, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(panel_31, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
					.addGap(91))
		);
		GroupLayout gl_panel_29 = new GroupLayout(panel_29);
		gl_panel_29.setHorizontalGroup(
			gl_panel_29.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_29.createSequentialGroup()
					.addGap(6)
					.addComponent(audioformatlist1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_29.createParallelGroup(Alignment.LEADING)
						.addComponent(button_24, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_25))
					.addGap(45)
					.addComponent(audioformat1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_29.setVerticalGroup(
			gl_panel_29.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_29.createSequentialGroup()
					.addGap(8)
					.addComponent(audioformatlist1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_29.createSequentialGroup()
					.addGap(6)
					.addComponent(button_24, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_25, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_29.createSequentialGroup()
					.addGap(8)
					.addComponent(audioformat1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_29.setLayout(gl_panel_29);
		GroupLayout gl_panel_30 = new GroupLayout(panel_30);
		gl_panel_30.setHorizontalGroup(
			gl_panel_30.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_30.createSequentialGroup()
					.addGap(6)
					.addComponent(audiocodeclist1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_panel_30.createParallelGroup(Alignment.LEADING)
						.addComponent(button_26, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_27))
					.addGap(39)
					.addComponent(audiocodec1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_30.setVerticalGroup(
			gl_panel_30.createParallelGroup(Alignment.LEADING)
				.addComponent(audiocodeclist1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_30.createSequentialGroup()
					.addGap(6)
					.addComponent(button_26, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_27, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addComponent(audiocodec1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
		);
		panel_30.setLayout(gl_panel_30);
		GroupLayout gl_panel_31 = new GroupLayout(panel_31);
		gl_panel_31.setHorizontalGroup(
			gl_panel_31.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_31.createSequentialGroup()
					.addGap(6)
					.addComponent(audioresolutionlist1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_31.createParallelGroup(Alignment.LEADING)
						.addComponent(button_28, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_29))
					.addGap(45)
					.addComponent(audioresolution1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_31.setVerticalGroup(
			gl_panel_31.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_31.createSequentialGroup()
					.addGap(1)
					.addComponent(audioresolutionlist1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_31.createSequentialGroup()
					.addGap(6)
					.addComponent(button_28, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_29, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_31.createSequentialGroup()
					.addGap(1)
					.addComponent(audioresolution1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_31.setLayout(gl_panel_31);
		panel_24.setLayout(gl_panel_24);
		GroupLayout gl_panel_18 = new GroupLayout(panel_18);
		gl_panel_18.setHorizontalGroup(
			gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane_3, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_18.setVerticalGroup(
			gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane_3, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
		);
		panel_18.setLayout(gl_panel_18);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if (ds.trvideo.isSelected()) {
					
					if (ds.chckbxFormat.isSelected()) {
						trVideoFI = selectedvideoformatlist.getItems();
						trVideoFO = selectedformatoutput.getItems();
						
					}
					if (ds.chckbxCodec.isSelected()) {
						trVideoCI = selectedvideocodec.getItems();
						trVideoCO = selectedcodecoutput.getItems();
					}
					if (ds.chckbxResolution.isSelected()) {
						trVideoRI = selectedvideoresolution.getItems();
						trVideoRO = selectedresolutionoutput.getItems();
						
					}
					
					
				}
if (ds.traudio.isSelected()) {
					
					if (ds.chckbxFormat.isSelected()) {
						trAudioFI = audioformatinput.getItems();

						trAudioFO = audioformatoutput.getItems();
					}
					if (ds.chckbxCodec.isSelected()) {
						trAudioCI = audiocodecinput.getItems();
						trAudioCO = audiocodecoutput.getItems();
					}
					if (ds.chckbxResolution.isSelected()) {
						trAudioRI = audioresolutioninput.getItems();
						trAudioRO = audioresolutionoutput.getItems();
					}
				
					
				}
if (ds.trimage.isSelected()) {
	
	if (ds.chckbxFormat.isSelected()) {
		trImageFI = imageformatinput.getItems();
		trImageFO = imageformatoutput.getItems();

	}

	if (ds.chckbxResolution.isSelected()) {
		trImageRI = imageresolutioninput.getItems();
		trImageRO = imageresolutionoutput.getItems();
	}
	
	
}
				

				

				// we need to save this information in temporary ontology.
				ds.Developer(trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO, 
						trAudioBMxI, trAudioBMxO, trVideoFI, trVideoFO, trVideoCI, trVideoCO, trVideoRI, trVideoRO,
						 trVideoBMxI, trVideoBMxO, trImageFI,trImageFO ,
						trImageRI, trImageRO,  trImageBMxI, trImageBMxO);

				////////////////
				TranscoderInputOutput.this.dispose();

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(517)
					.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);

		/*
		 * Component[] com = panel_2.getComponents(); // Inside you action event
		 * whereyou want to disable everything // Do // the following for (int a = 0; a
		 * < com.length; a++) { com[a].setEnabled(false); }
		 */

	}
}
