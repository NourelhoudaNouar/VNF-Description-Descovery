import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Component;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;

public class TranscoderIORequest extends JFrame {

	List IVF, IVC, IVR, OVF, OVC, OVR, IIF, IIR, OIF, OIR, IAF, IAC, IAR, OAF, OAC, OAR;
	List SIVF, SIVC, SIVR, SOVF, SOVC, SOVR, SIIF, SIIR, SOIF, SOIR, SIAF, SIAC, SIAR, SOAF, SOAC, SOAR;
	JComboBox comboBox_14, comboBox_15, comboBox_16, comboBox_18, comboBox_19, comboBox_20, comboBox_8, comboBox_9,
			comboBox_11, comboBox_12, comboBox_4, comboBox_5, comboBox_6, comboBox, comboBox_1, comboBox_2;
	Boolean exist, v, a, i, f, c, r, b;

	private JPanel contentPane;
	String[] trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO, trVideoFI, trVideoFO, trVideoCI,
			trVideoCO, trVideoRI, trVideoRO, trImageFI, trImageFO, trImageCI, trImageCO, trImageRI, trImageRO;
	int   trVideoBMxI , trVideoBMxO , trImageBMxI , trImageBMxO , 
			trAudioBMxI, trAudioBMxO ;
	RequestFormulate RF;
	JScrollPane IVFscroll, scrollPane_1;
	JButton button, button_1;
	VikingManag VM = new VikingManag();
	JPanel panel_9, panel_17, panel_13, panel_21, panel_25, panel_29;

	public TranscoderIORequest(Boolean v, Boolean a, Boolean i, Boolean f, Boolean c, Boolean r, Boolean b,
			RequestFormulate RF) throws OWLOntologyCreationException {
		this.v = v;
		this.i = i;
		this.a = a;
		this.f = f;
		this.c = c;
		this.r = r;
		this.b = b;
		this.RF = RF;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 600, 620);
		contentPane.add(tabbedPane);

		/*
		 * if (f==false) { if (v==true) { Component[] com9 = panel_9.getComponents();
		 * for (int p = 0; p < panel_9.getComponents().length; p++) {
		 * com9[p].setEnabled(false); } Component[] com17 = panel_17.getComponents();
		 * for (int p = 0; p < com17.length; p++) { com17[p].setEnabled(false); } } if
		 * (i==true) { Component[] com13 = panel_13.getComponents(); for (int p = 0; p <
		 * com13.length; p++) { com13[p].setEnabled(false); } Component[] com21 =
		 * panel_21.getComponents(); for (int p = 0; p < com21.length; p++) {
		 * com21[p].setEnabled(false); } } if (a==true) { Component[] com25 =
		 * panel_25.getComponents(); for (int p = 0; p < com25.length; p++) {
		 * com25[p].setEnabled(false); } Component[] com29 = panel_29.getComponents();
		 * for (int p = 0; p < com29.length; p++) { com29[p].setEnabled(false); } }
		 * 
		 * }
		 */

	//	if (v == true) {

			System.out.println("video is able " + v);
			JPanel panel = new JPanel();
			tabbedPane.addTab("Video", null, panel, null);
			panel.setLayout(null);

			JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setBounds(10, 11, 565, 562);
			panel.add(tabbedPane_1);

			JPanel panel_3 = new JPanel();
			tabbedPane_1.addTab("Input", null, panel_3, null);
			panel_3.setLayout(null);

			panel_9 = new JPanel();
			panel_9.setLayout(null);
			panel_9.setBorder(
					new TitledBorder(null, "Video Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_9.setBounds(10, 11, 540, 130);
			panel_3.add(panel_9);

			IVFscroll = new JScrollPane();
			IVFscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			IVFscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			IVFscroll.setBounds(12, 30, 166, 78);
			panel_9.add(IVFscroll);

			IVF = new List();
			IVF = VM.getVideoFormat();
			IVFscroll.setViewportView(IVF);

			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(353, 30, 166, 78);
			panel_9.add(scrollPane_1);

			SIVF = new List();
			scrollPane_1.setViewportView(SIVF);

			button = new JButton("Add");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_14.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIVF.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IVF.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIVF.add(IVF.getSelectedItem() + "# " + comboBox_14.getSelectedItem());

						}
					}
					// String a="ana honaaaa";
					// String b="mafhamt walou";
					// String[]ab;

					// trVideoFI=new String[] {SIVC.getItems()};

				}
			});
			button.setBounds(219, 15, 89, 23);
			panel_9.add(button);

			button_1 = new JButton("Remove");
			button_1.setBounds(219, 91, 89, 23);
			panel_9.add(button_1);

			comboBox_14 = new JComboBox();
			comboBox_14.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_14.setBounds(202, 53, 128, 23);
			panel_9.add(comboBox_14);
			if (f == false) {

				IVFscroll.setEnabled(false);
				scrollPane_1.setEnabled(false);
				button.setEnabled(false);
				button_1.setEnabled(false);
				comboBox_14.setEnabled(false);
			}
			JPanel panel_10 = new JPanel();
			panel_10.setLayout(null);
			panel_10.setBorder(
					new TitledBorder(null, "Video Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_10.setBounds(10, 164, 540, 130);
			panel_3.add(panel_10);

			JScrollPane IVCscrollpane = new JScrollPane();
			IVCscrollpane.setBounds(12, 22, 166, 78);
			panel_10.add(IVCscrollpane);

			IVC = new List();
			IVC = VM.getVideoCodec();
			IVCscrollpane.setViewportView(IVC);

			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(353, 22, 166, 78);
			panel_10.add(scrollPane_3);

			SIVC = new List();

			scrollPane_3.setViewportView(SIVC);

			JButton button_2 = new JButton("Add");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_15.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIVC.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IVC.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIVC.add(IVC.getSelectedItem() + "# " + comboBox_15.getSelectedItem());

						}
					}
				}
			});
			button_2.setBounds(225, 15, 89, 23);
			panel_10.add(button_2);

			JButton button_3 = new JButton("Remove");
			button_3.setBounds(225, 91, 89, 23);
			panel_10.add(button_3);

			comboBox_15 = new JComboBox();
			comboBox_15.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_15.setBounds(204, 53, 139, 23);
			panel_10.add(comboBox_15);
			if (c == false) {
				comboBox_15.setEnabled(false);
				button_3.setEnabled(false);
				button_2.setEnabled(false);
				scrollPane_3.setEnabled(false);
				panel_10.setEnabled(false);
				IVCscrollpane.setEnabled(false);
			}
			JPanel panel_11 = new JPanel();
			panel_11.setLayout(null);
			panel_11.setBorder(
					new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_11.setBounds(10, 317, 540, 130);
			panel_3.add(panel_11);

			JScrollPane IVRscrollpane = new JScrollPane();
			IVRscrollpane.setBounds(12, 23, 166, 78);

			panel_11.add(IVRscrollpane);

			IVR = new List();
			IVR = VM.getResolution();
			IVRscrollpane.setViewportView(IVR);

			JScrollPane scrollPane_5 = new JScrollPane();
			scrollPane_5.setBounds(353, 23, 166, 78);
			panel_11.add(scrollPane_5);

			SIVR = new List();
			scrollPane_5.setViewportView(SIVR);

			JButton button_4 = new JButton("Add");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_16.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIVR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IVR.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIVR.add(IVR.getSelectedItem() + "# " + comboBox_16.getSelectedItem());

						}
					}
				}
			});
			button_4.setBounds(219, 15, 89, 23);
			panel_11.add(button_4);

			JButton button_5 = new JButton("Remove");
			button_5.setBounds(219, 91, 89, 23);
			panel_11.add(button_5);

			comboBox_16 = new JComboBox();
			comboBox_16.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_16.setBounds(199, 53, 127, 23);
			panel_11.add(comboBox_16);

			if (r == false) {
				panel_11.setEnabled(false);
				comboBox_16.setEnabled(false);
				button_5.setEnabled(false);
				button_4.setEnabled(false);
				scrollPane_5.setEnabled(false);
				IVRscrollpane.setEnabled(false);
			}

		

			JPanel panel_4 = new JPanel();
			tabbedPane_1.addTab("Output", null, panel_4, null);
			panel_4.setLayout(null);

			panel_13 = new JPanel();
			panel_13.setLayout(null);
			panel_13.setBorder(
					new TitledBorder(null, "Video Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_13.setBounds(10, 11, 540, 130);
			panel_4.add(panel_13);

			JScrollPane OVFscrollepane = new JScrollPane();
			OVFscrollepane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			OVFscrollepane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			OVFscrollepane.setBounds(12, 30, 166, 78);
			panel_13.add(OVFscrollepane);

			OVF = new List();
			OVF = VM.getVideoFormat();
			OVFscrollepane.setViewportView(OVF);

			JScrollPane scrollPane_7 = new JScrollPane();
			scrollPane_7.setBounds(353, 30, 166, 78);
			panel_13.add(scrollPane_7);

			SOVF = new List();
			scrollPane_7.setViewportView(SOVF);

			JButton button_6 = new JButton("Add");
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_18.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOVF.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OVF.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOVF.add(OVF.getSelectedItem() + "# " + comboBox_18.getSelectedItem());

						}
					}
				}
			});
			button_6.setBounds(219, 16, 89, 23);
			panel_13.add(button_6);

			JButton button_7 = new JButton("Remove");
			button_7.setBounds(219, 91, 89, 23);
			panel_13.add(button_7);

			comboBox_18 = new JComboBox();
			comboBox_18.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_18.setBounds(198, 55, 128, 20);
			panel_13.add(comboBox_18);

			if (f == false) {
				comboBox_18.setEnabled(false);
				button_7.setEnabled(false);
				button_6.setEnabled(false);
				OVFscrollepane.setEnabled(false);
				panel_4.setEnabled(false);
				scrollPane_7.setEnabled(false);
			}

			JPanel panel_14 = new JPanel();
			panel_14.setLayout(null);
			panel_14.setBorder(
					new TitledBorder(null, "Video Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_14.setBounds(10, 164, 540, 130);
			panel_4.add(panel_14);

			JScrollPane OVCscrollepae = new JScrollPane();
			OVCscrollepae.setBounds(12, 22, 166, 78);
			panel_14.add(OVCscrollepae);

			OVC = new List();
			OVC = VM.getVideoCodec();
			OVCscrollepae.setViewportView(OVC);

			JScrollPane scrollPane_9 = new JScrollPane();
			scrollPane_9.setBounds(353, 22, 166, 78);
			panel_14.add(scrollPane_9);

			SOVC = new List();
			scrollPane_9.setViewportView(SOVC);

			JButton button_8 = new JButton("Add");
			button_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_19.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOVC.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OVC.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOVC.add(OVC.getSelectedItem() + "# " + comboBox_19.getSelectedItem());

						}
					}
				}
			});
			button_8.setBounds(225, 15, 89, 23);
			panel_14.add(button_8);

			JButton button_9 = new JButton("Remove");
			button_9.setBounds(225, 91, 89, 23);
			panel_14.add(button_9);

			comboBox_19 = new JComboBox();
			comboBox_19.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_19.setBounds(198, 53, 136, 23);
			panel_14.add(comboBox_19);

			if (c == false) {
				comboBox_19.setEnabled(false);
				button_9.setEnabled(false);
				button_8.setEnabled(false);
				scrollPane_9.setEnabled(false);
				OVCscrollepae.setEnabled(false);
				panel_14.setEnabled(false);
			}

			JPanel panel_15 = new JPanel();
			panel_15.setLayout(null);
			panel_15.setBorder(
					new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_15.setBounds(10, 317, 540, 130);
			panel_4.add(panel_15);

			JScrollPane OVRscrollpane = new JScrollPane();
			OVRscrollpane.setBounds(12, 23, 166, 78);
			panel_15.add(OVRscrollpane);

			OVR = new List();
			OVR = VM.getResolution();
			OVRscrollpane.setViewportView(OVR);

			JScrollPane scrollPane_11 = new JScrollPane();
			scrollPane_11.setBounds(353, 23, 166, 78);
			panel_15.add(scrollPane_11);

			SOVR = new List();
			scrollPane_11.setViewportView(SOVR);

			JButton button_10 = new JButton("Add");
			button_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_20.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOVR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OVR.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOVR.add(OVR.getSelectedItem() + "# " + comboBox_20.getSelectedItem());

						}
					}
				}
			});
			button_10.setBounds(219, 15, 89, 23);
			panel_15.add(button_10);

			JButton button_11 = new JButton("Remove");
			button_11.setBounds(219, 91, 89, 23);
			panel_15.add(button_11);

			comboBox_20 = new JComboBox();
			comboBox_20.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_20.setBounds(195, 53, 148, 23);
			panel_15.add(comboBox_20);

			if (r == false) {
				comboBox_20.setEnabled(false);
				panel_15.setEnabled(false);
				button_11.setEnabled(false);
				button_10.setEnabled(false);
				scrollPane_11.setEnabled(false);
				OVRscrollpane.setEnabled(false);
			}
			
	//fin video	}

	//	if (i) {
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Image", null, panel_1, null);
			panel_1.setLayout(null);

			JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_2.setBounds(10, 11, 824, 659);
			panel_1.add(tabbedPane_2);

			JPanel panel_5 = new JPanel();
			tabbedPane_2.addTab("Input", null, panel_5, null);
			panel_5.setLayout(null);

			panel_17 = new JPanel();
			panel_17.setLayout(null);
			panel_17.setBorder(
					new TitledBorder(null, "Image Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_17.setBounds(10, 11, 540, 130);
			panel_5.add(panel_17);

			JScrollPane IIFscrollpane = new JScrollPane((Component) null);
			IIFscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			IIFscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			IIFscrollpane.setBounds(12, 30, 166, 78);

			panel_17.add(IIFscrollpane);

			IIF = new List();
			IIF = VM.getImageFormat();
			IIFscrollpane.setViewportView(IIF);

			JScrollPane scrollPane_13 = new JScrollPane();
			scrollPane_13.setBounds(353, 30, 166, 78);
			panel_17.add(scrollPane_13);

			SIIF = new List();
			scrollPane_13.setViewportView(SIIF);

			JButton button_12 = new JButton("Add");
			button_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_8.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIIF.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IIF.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIIF.add(IIF.getSelectedItem() + "# " + comboBox_8.getSelectedItem());

						}
					}
				}
			});
			button_12.setBounds(219, 15, 89, 23);
			panel_17.add(button_12);

			JButton button_13 = new JButton("Remove");
			button_13.setBounds(219, 91, 89, 23);
			panel_17.add(button_13);

			comboBox_8 = new JComboBox();
			comboBox_8.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_8.setBounds(202, 53, 130, 23);
			panel_17.add(comboBox_8);
			if (f == false) {
				comboBox_8.setEnabled(false);
				panel_17.setEnabled(false);
				button_13.setEnabled(false);
				button_12.setEnabled(false);
				scrollPane_13.setEnabled(false);
				IIFscrollpane.setEnabled(false);

			}

			JPanel panel_19 = new JPanel();
			panel_19.setLayout(null);
			panel_19.setBorder(
					new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_19.setBounds(10, 152, 540, 130);
			panel_5.add(panel_19);

			JScrollPane IIRscrollpane = new JScrollPane((Component) null);
			IIRscrollpane.setBounds(12, 23, 166, 78);
			panel_19.add(IIRscrollpane);

			IIR = new List();
			IIR = VM.getResolution();
			IIRscrollpane.setViewportView(IIR);

			JScrollPane scrollPane_17 = new JScrollPane();
			scrollPane_17.setBounds(353, 23, 166, 78);
			panel_19.add(scrollPane_17);

			SIIR = new List();
			scrollPane_17.setViewportView(SIIR);

			JButton button_16 = new JButton("Add");
			button_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_9.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIIR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IIR.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIIR.add(IIR.getSelectedItem() + "# " + comboBox_9.getSelectedItem());

						}
					}

				}
			});
			button_16.setBounds(219, 15, 89, 23);
			panel_19.add(button_16);

			JButton button_17 = new JButton("Remove");
			button_17.setBounds(219, 91, 89, 23);
			panel_19.add(button_17);

			comboBox_9 = new JComboBox();
			comboBox_9.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_9.setBounds(196, 53, 147, 23);
			panel_19.add(comboBox_9);
			if (r == false) {
				comboBox_9.setEnabled(false);
				panel_19.setEnabled(false);
				button_17.setEnabled(false);
				button_16.setEnabled(false);
				scrollPane_17.setEnabled(false);
				IIRscrollpane.setEnabled(false);
			}
		

			JPanel panel_6 = new JPanel();
			tabbedPane_2.addTab("Output", null, panel_6, null);
			panel_6.setLayout(null);

			panel_21 = new JPanel();
			panel_21.setLayout(null);
			panel_21.setBorder(
					new TitledBorder(null, "Image Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_21.setBounds(10, 11, 540, 130);
			panel_6.add(panel_21);

			JScrollPane OIFscrollpane = new JScrollPane((Component) null);
			OIFscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			OIFscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			OIFscrollpane.setBounds(12, 30, 166, 78);
			panel_21.add(OIFscrollpane);

			OIF = new List();
			OIF = VM.getImageFormat();
			OIFscrollpane.setViewportView(OIF);

			JScrollPane scrollPane_19 = new JScrollPane();
			scrollPane_19.setBounds(353, 30, 166, 78);
			panel_21.add(scrollPane_19);

			SOIF = new List();
			scrollPane_19.setViewportView(SOIF);

			JButton button_18 = new JButton("Add");
			button_18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_11.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOIF.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OIF.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOIF.add(OIF.getSelectedItem() + "# " + comboBox_11.getSelectedItem());

						}
					}

				}
			});
			button_18.setBounds(219, 15, 89, 23);
			panel_21.add(button_18);

			JButton button_19 = new JButton("Remove");
			button_19.setBounds(219, 91, 89, 23);
			panel_21.add(button_19);

			comboBox_11 = new JComboBox();
			comboBox_11.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_11.setBounds(188, 53, 138, 23);
			panel_21.add(comboBox_11);

			JPanel panel_23 = new JPanel();
			panel_23.setLayout(null);
			panel_23.setBorder(
					new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_23.setBounds(10, 152, 540, 130);
			panel_6.add(panel_23);

			JScrollPane OIRscrollpane = new JScrollPane((Component) null);
			OIRscrollpane.setBounds(12, 23, 166, 78);
			panel_23.add(OIRscrollpane);

			OIR = new List();
			OIR = VM.getResolution();
			OIRscrollpane.setViewportView(OIR);

			JScrollPane scrollPane_23 = new JScrollPane();
			scrollPane_23.setBounds(353, 23, 166, 78);
			panel_23.add(scrollPane_23);

			SOIR = new List();
			scrollPane_23.setViewportView(SOIR);

			JButton button_22 = new JButton("Add");
			button_22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_12.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOIR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OIR.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOIR.add(OIR.getSelectedItem() + "# " + comboBox_12.getSelectedItem());

						}
					}

				}
			});
			button_22.setBounds(219, 15, 89, 23);
			panel_23.add(button_22);

			JButton button_23 = new JButton("Remove");
			button_23.setBounds(219, 91, 89, 23);
			panel_23.add(button_23);

			comboBox_12 = new JComboBox();
			comboBox_12.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_12.setBounds(188, 53, 142, 23);
			panel_23.add(comboBox_12);
			if (r == false) {
				comboBox_12.setEnabled(false);
				panel_23.setEnabled(false);
				button_23.setEnabled(false);
				button_22.setEnabled(false);
				scrollPane_23.setEnabled(false);
				OIRscrollpane.setEnabled(false);
			}

			

		//fin image}
		//if (a) {
			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("Audio", null, panel_2, null);
			panel_2.setLayout(null);

			JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_3.setBounds(10, 11, 569, 569);
			panel_2.add(tabbedPane_3);

			JPanel panel_7 = new JPanel();
			tabbedPane_3.addTab("Input", null, panel_7, null);
			panel_7.setLayout(null);

			panel_25 = new JPanel();
			panel_25.setLayout(null);
			panel_25.setBorder(
					new TitledBorder(null, "Audio Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_25.setBounds(10, 11, 540, 130);
			panel_7.add(panel_25);

			JScrollPane IAFscrollpane = new JScrollPane((Component) null);
			IAFscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			IAFscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			IAFscrollpane.setBounds(12, 30, 166, 78);
			panel_25.add(IAFscrollpane);

			IAF = new List();
			IAF = VM.getAudioFormat();
			IAFscrollpane.setViewportView(IAF);

			JScrollPane scrollPane_25 = new JScrollPane();
			scrollPane_25.setBounds(353, 30, 166, 78);
			panel_25.add(scrollPane_25);

			SIAF = new List();
			scrollPane_25.setViewportView(SIAF);

			JButton button_24 = new JButton("Add");
			button_24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_4.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIAF.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IAF.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIAF.add(IAF.getSelectedItem() + "# " + comboBox_4.getSelectedItem());

						}
					}

				}
			});
			button_24.setBounds(219, 15, 89, 23);
			panel_25.add(button_24);

			JButton button_25 = new JButton("Remove");
			button_25.setBounds(219, 91, 89, 23);
			panel_25.add(button_25);

			comboBox_4 = new JComboBox();
			comboBox_4.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_4.setBounds(198, 53, 126, 23);
			panel_25.add(comboBox_4);

			if (f == false) {
				panel_25.setEnabled(false);
				comboBox_4.setEnabled(false);
				button_25.setEnabled(false);
				button_24.setEnabled(false);
				scrollPane_25.setEnabled(false);
				IAFscrollpane.setEnabled(false);
			}

			JPanel panel_26 = new JPanel();
			panel_26.setLayout(null);
			panel_26.setBorder(
					new TitledBorder(null, "Audio Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_26.setBounds(10, 164, 540, 130);
			panel_7.add(panel_26);

			JScrollPane IACscrolpane = new JScrollPane((Component) null);
			IACscrolpane.setBounds(12, 22, 166, 78);
			panel_26.add(IACscrolpane);

			IAC = new List();
			IAC = VM.getAudioCodec();
			IACscrolpane.setViewportView(IAC);

			JScrollPane scrollPane_27 = new JScrollPane();
			scrollPane_27.setBounds(353, 22, 166, 78);
			panel_26.add(scrollPane_27);

			SIAC = new List();
			scrollPane_27.setViewportView(SIAC);

			JButton button_26 = new JButton("Add");
			button_26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_5.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIAC.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IAC.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIAC.add(IAC.getSelectedItem() + "# " + comboBox_5.getSelectedItem());

						}
					}

				}
			});
			button_26.setBounds(225, 15, 89, 23);
			panel_26.add(button_26);

			JButton button_27 = new JButton("Remove");
			button_27.setBounds(225, 91, 89, 23);
			panel_26.add(button_27);

			comboBox_5 = new JComboBox();
			comboBox_5.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_5.setBounds(188, 53, 146, 23);
			panel_26.add(comboBox_5);

if (c==false) {
	comboBox_5.setEnabled(false);
	panel_26.setEnabled(false);
	button_27.setEnabled(false);
	button_26.setEnabled(false);
	IACscrolpane.setEnabled(false);
	scrollPane_27.setEnabled(false);
}			
			
			
			JPanel panel_27 = new JPanel();
			panel_27.setLayout(null);
			panel_27.setBorder(
					new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_27.setBounds(10, 317, 540, 130);
			panel_7.add(panel_27);

			JScrollPane IARscrollpane = new JScrollPane((Component) null);
			IARscrollpane.setBounds(12, 23, 166, 78);
			panel_27.add(IARscrollpane);

			IAR = new List();
			IAR = VM.getResolution();
			IARscrollpane.setViewportView(IAR);

			JScrollPane scrollPane_29 = new JScrollPane();
			scrollPane_29.setBounds(353, 23, 166, 78);
			panel_27.add(scrollPane_29);

			SIAR = new List();
			scrollPane_29.setViewportView(SIAR);

			JButton button_28 = new JButton("Add");
			button_28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (comboBox_6.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIAR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(IAR.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SIAR.add(IAR.getSelectedItem() + "# " + comboBox_6.getSelectedItem());

						}
					}
				}
			});
			button_28.setBounds(219, 15, 89, 23);
			panel_27.add(button_28);

			JButton button_29 = new JButton("Remove");
			button_29.setBounds(219, 91, 89, 23);
			panel_27.add(button_29);

			comboBox_6 = new JComboBox();
			comboBox_6.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_6.setBounds(188, 53, 151, 23);
			panel_27.add(comboBox_6);

if (r==false) {
	comboBox_6.setEnabled(false);
	panel_27.setEnabled(false);
	button_29.setEnabled(false);
	button_28.setEnabled(false);
	scrollPane_29.setEnabled(false);
	IARscrollpane.setEnabled(false);
	
}

			
			
			JPanel panel_8 = new JPanel();
			tabbedPane_3.addTab("Output", null, panel_8, null);
			panel_8.setLayout(null);

			panel_29 = new JPanel();
			panel_29.setLayout(null);
			panel_29.setBorder(
					new TitledBorder(null, "Audio Format", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_29.setBounds(10, 11, 540, 130);
			panel_8.add(panel_29);

			JScrollPane OAFscrollpane = new JScrollPane((Component) null);
			OAFscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			OAFscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			OAFscrollpane.setBounds(12, 30, 166, 78);
			panel_29.add(OAFscrollpane);

			OAF = new List();
			OAF = VM.getAudioFormat();
			OAFscrollpane.setViewportView(OAF);

			JScrollPane scrollPane_31 = new JScrollPane();
			scrollPane_31.setBounds(353, 30, 166, 78);
			panel_29.add(scrollPane_31);

			SOAF = new List();
			scrollPane_31.setViewportView(SOAF);

			JButton button_30 = new JButton("Add");
			button_30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SIAR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OAF.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOAF.add(OAF.getSelectedItem() + "# " + comboBox.getSelectedItem());

						}
					}

				}
			});
			button_30.setBounds(219, 15, 89, 23);
			panel_29.add(button_30);

			JButton button_31 = new JButton("Remove");
			button_31.setBounds(219, 91, 89, 23);
			panel_29.add(button_31);

			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox.setBounds(202, 53, 124, 23);
			panel_29.add(comboBox);

if (f==false) {
	comboBox.setEnabled(false);
	panel_29.setEnabled(false);
	button_31.setEnabled(false);
	button_30.setEnabled(false);
	scrollPane_31.setEnabled(false);
	OAFscrollpane.setEnabled(false);
	
}			
			
			JPanel panel_30 = new JPanel();
			panel_30.setLayout(null);
			panel_30.setBorder(
					new TitledBorder(null, "Audio Codec", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_30.setBounds(10, 164, 540, 130);
			panel_8.add(panel_30);

			JScrollPane OACscrollpane = new JScrollPane((Component) null);
			OACscrollpane.setBounds(12, 22, 166, 78);
			panel_30.add(OACscrollpane);

			OAC = new List();
			OAC = VM.getAudioCodec();
			OACscrollpane.setViewportView(OAC);

			JScrollPane scrollPane_33 = new JScrollPane();
			scrollPane_33.setBounds(353, 22, 166, 78);
			panel_30.add(scrollPane_33);

			SOAC = new List();
			scrollPane_33.setViewportView(SOAC);

			JButton button_32 = new JButton("Add");
			button_32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_1.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOAC.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OAC.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOAC.add(OAC.getSelectedItem() + "# " + comboBox_1.getSelectedItem());

						}
					}
				}
			});
			button_32.setBounds(225, 15, 89, 23);
			panel_30.add(button_32);

			JButton button_33 = new JButton("Remove");
			button_33.setBounds(225, 91, 89, 23);
			panel_30.add(button_33);

			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_1.setBounds(203, 53, 128, 23);
			panel_30.add(comboBox_1);
if (c==false) {
	comboBox_1.setEnabled(false);
	panel_30.setEnabled(false);
	button_33.setEnabled(false);
	button_32.setEnabled(false);
	scrollPane_33.setEnabled(false);
	 OACscrollpane.setEnabled(false);
	
}
			JPanel panel_31 = new JPanel();
			panel_31.setLayout(null);
			panel_31.setBorder(
					new TitledBorder(null, "Resolution", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_31.setBounds(10, 317, 540, 130);
			panel_8.add(panel_31);

			JScrollPane OARscrollpane = new JScrollPane((Component) null);
			OARscrollpane.setBounds(12, 23, 166, 78);
			panel_31.add(OARscrollpane);

			OAR = new List();
			OAR = VM.getResolution();
			OARscrollpane.setViewportView(OAR);

			JScrollPane scrollPane_35 = new JScrollPane();
			scrollPane_35.setBounds(353, 23, 166, 78);
			panel_31.add(scrollPane_35);

			SOAR = new List();
			scrollPane_35.setViewportView(SOAR);

			JButton button_34 = new JButton("Add");
			button_34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox_2.getSelectedItem().toString().equals("Choose Preference")) {
						JOptionPane optionpane = new JOptionPane(
								"you must select a prefernece for the choosing property", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionpane.createDialog("Select a preference");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					} else {

						exist = false;
						for (String s : SOAR.getItems()) {
							String[] parts = s.split("#");
							String part1 = parts[0];
							String part2 = parts[1];
							System.out.println(part1);
							if (part1.equals(OAR.getSelectedItem().toString())) {
								exist = true;
							}
						}
						if (exist == false) {
							SOAR.add(OAR.getSelectedItem() + "# " + comboBox_2.getSelectedItem());

						}
					}
				}
			});
			button_34.setBounds(219, 15, 89, 23);
			panel_31.add(button_34);

			JButton button_35 = new JButton("Remove");
			button_35.setBounds(219, 91, 89, 23);
			panel_31.add(button_35);

			comboBox_2 = new JComboBox();
			comboBox_2.setModel(new DefaultComboBoxModel(
					new String[] { "Choose Preference", "A- Mandatory", "B- Preferable", "C- Optional" }));
			comboBox_2.setBounds(202, 53, 124, 23);
			panel_31.add(comboBox_2);
if (r==false) {
	comboBox_2.setEnabled(false);
	comboBox_2.setEnabled(false);
	button_35.setEnabled(false);
	button_34.setEnabled(false);
	scrollPane_35.setEnabled(false);
	OARscrollpane.setEnabled(false);
	
}
			
		//fin audio}
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (v == true) {

					trVideoFI = SIVF.getItems();
					trVideoFO = SOVF.getItems();

					trVideoRI = SIVR.getItems();
					trVideoRO = SOVR.getItems();

					trVideoCI = SIVC.getItems();
					trVideoCO = SOVC.getItems();

					
				}
				if (i == true) {

					trImageFI = SIIF.getItems();
					trImageFO = SOIF.getItems();

					trImageRI = SIIR.getItems();
					trImageRO = SOIR.getItems();

					

				}
				if (a == true) {

					trAudioFI = SIAF.getItems();
					trAudioFO = SOAF.getItems();

					trAudioRI = SIAR.getItems();
					trAudioRO = SOAR.getItems();

					trAudioCI = SIAC.getItems();
					trAudioCO = SOAC.getItems();
					

				}

				RF.TrIO(trAudioFI, trAudioFO, trAudioCI, trAudioCO, trAudioRI, trAudioRO,
						 trVideoFI, trVideoFO, trVideoCI, trVideoCO, trVideoRI, trVideoRO,  trImageFI, trImageFO, trImageCI, trImageCO,
						trImageRI, trImageRO);

				TranscoderIORequest.this.dispose();

			}
		});
		btnFinish.setBounds(516, 636, 89, 23);
		contentPane.add(btnFinish);
	}
}
