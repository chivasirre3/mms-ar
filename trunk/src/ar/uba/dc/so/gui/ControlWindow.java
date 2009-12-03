package ar.uba.dc.so.gui;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JLabel;

import ar.uba.dc.so.gui.component.ComboBoxOption;
import ar.uba.dc.so.gui.component.IntegerTextField;
import ar.uba.dc.so.simulator.CmdLineMode;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import java.awt.Color;

public class ControlWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox jMemoryTypeComboBox = null;
	private JTextField jMemorySizeTextField = null;
	private JLabel jLabel = null;
	private JLabel jMemoryTypeLabel = null;
	private IntegerTextField jTimeToSimulateTextField = null;
	private JLabel jTimeToSimulateLabel = null;
	private JComboBox jAlgorithmComboBox = null;
	private JLabel jAlgorithmLabel = null;
	private JTextField jProcessFileTextField = null;
	private JButton jFileChooseButton = null;
	private JLabel jProcessFileLabel = null;
	private JPanel jProgressPanel = null;
	private JSplitPane jSplitPane = null;
	private JButton jStartSimulationButton = null;
	private JButton jStopSimulationButton = null;
	private JProgressBar jProgressBar = null;
	private JLabel jInfoLabel = null;

	/**
	 * This is the default constructor
	 */
	public ControlWindow() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("Memory Simulator (Control Window)");
		this.setResizable(false);
		this.setBounds(new Rectangle(300, 0, 370, 254));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jProcessFileLabel = new JLabel();
			jProcessFileLabel.setBounds(new Rectangle(7, 102, 155, 16));
			jProcessFileLabel.setText("Processes File");
			jAlgorithmLabel = new JLabel();
			jAlgorithmLabel.setBounds(new Rectangle(223, 4, 76, 16));
			jAlgorithmLabel.setText("Algorithm");
			jTimeToSimulateLabel = new JLabel();
			jTimeToSimulateLabel.setBounds(new Rectangle(7, 78, 165, 16));
			jTimeToSimulateLabel.setText("Time to Simulate (seconds)");
			jMemoryTypeLabel = new JLabel();
			jMemoryTypeLabel.setBounds(new Rectangle(7, 3, 87, 16));
			jMemoryTypeLabel.setText("Memory Type");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(6, 52, 107, 16));
			jLabel.setText("Memory size (KB)");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJMemoryTypeComboBox(), null);
			jContentPane.add(getJMemorySizeTextField(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jMemoryTypeLabel, null);
			jContentPane.add(getJTimeToSimulateTextField(), null);
			jContentPane.add(jTimeToSimulateLabel, null);
			jContentPane.add(getJAlgorithmComboBox(), null);
			jContentPane.add(jAlgorithmLabel, null);
			jContentPane.add(getJProcessFileTextField(), null);
			jContentPane.add(getJFileChooseButton(), null);
			jContentPane.add(jProcessFileLabel, null);
			jContentPane.add(getJProgressPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jMemoryTypeComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJMemoryTypeComboBox() {
		if (jMemoryTypeComboBox == null) {
			jMemoryTypeComboBox = new JComboBox();
			jMemoryTypeComboBox.setBounds(new Rectangle(6, 23, 196, 21));
			
			jMemoryTypeComboBox.addItem(new ComboBoxOption<Integer>("", 0));
			jMemoryTypeComboBox.addItem(new ComboBoxOption<Integer>("Simple Contiguous", 1));
			jMemoryTypeComboBox.addItem(new ComboBoxOption<Integer>("Swapping", 2));
			jMemoryTypeComboBox.addItem(new ComboBoxOption<Integer>("Fixed Partition", 3));
			jMemoryTypeComboBox.addItem(new ComboBoxOption<Integer>("Variable Partition", -1));
		}
		return jMemoryTypeComboBox;
	}

	/**
	 * This method initializes jMemorySizeTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJMemorySizeTextField() {
		if (jMemorySizeTextField == null) {
			jMemorySizeTextField = new IntegerTextField();
			jMemorySizeTextField.setBounds(new Rectangle(115, 50, 21, 20));
		}
		return jMemorySizeTextField;
	}

	/**
	 * This method initializes jTimeToSimulateTextField	
	 * 	
	 * @return ar.uba.dc.so.gui.component.IntegerTextField	
	 */
	private IntegerTextField getJTimeToSimulateTextField() {
		if (jTimeToSimulateTextField == null) {
			jTimeToSimulateTextField = new IntegerTextField();
			jTimeToSimulateTextField.setBounds(new Rectangle(171, 77, 22, 20));
		}
		return jTimeToSimulateTextField;
	}

	/**
	 * This method initializes jAlgorithmComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJAlgorithmComboBox() {
		if (jAlgorithmComboBox == null) {
			jAlgorithmComboBox = new JComboBox();
			jAlgorithmComboBox.setBounds(new Rectangle(220, 22, 131, 21));
			
			jAlgorithmComboBox.addItem(new ComboBoxOption<Integer>("First Free Zone", 4));
			jAlgorithmComboBox.addItem(new ComboBoxOption<Integer>("Best Zone", 5));
			jAlgorithmComboBox.addItem(new ComboBoxOption<Integer>("Worst Zone", 6));
			jAlgorithmComboBox.addItem(new ComboBoxOption<Integer>("First Free Zone (compactation)", 7));
			jAlgorithmComboBox.addItem(new ComboBoxOption<Integer>("Best Zone (compactation)", 8));
			jAlgorithmComboBox.addItem(new ComboBoxOption<Integer>("Worst Zone (compactation)", 9));
		}
		return jAlgorithmComboBox;
	}

	/**
	 * This method initializes jProcessFileTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJProcessFileTextField() {
		if (jProcessFileTextField == null) {
			jProcessFileTextField = new JTextField();
			jProcessFileTextField.setBounds(new Rectangle(7, 119, 207, 20));
			jProcessFileTextField.setEnabled(false);
		}
		return jProcessFileTextField;
	}

	/**
	 * This method initializes jFileChooseButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJFileChooseButton() {
		if (jFileChooseButton == null) {
			jFileChooseButton = new JButton();
			jFileChooseButton.setBounds(new Rectangle(214, 119, 82, 20));
			jFileChooseButton.setText("Choose");
			final JFileChooser fc = new JFileChooser();
			jFileChooseButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int retVal = fc.showOpenDialog(ControlWindow.this);
					
					if(retVal == JFileChooser.APPROVE_OPTION) {
						File processFile = fc.getSelectedFile();
						jProcessFileTextField.setText(processFile.getAbsolutePath());
					}
				}
			});
		}
		return jFileChooseButton;
	}

	/**
	 * This method initializes jProgressPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJProgressPanel() {
		if (jProgressPanel == null) {
			jInfoLabel = new JLabel();
			jInfoLabel.setText("Status: simulating; Fragmentation index: 2%");
			jProgressPanel = new JPanel();
			jProgressPanel.setLayout(new BorderLayout());
			jProgressPanel.setBounds(new Rectangle(4, 150, 355, 79));
			jProgressPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			jProgressPanel.add(getJSplitPane(), BorderLayout.NORTH);
			jProgressPanel.add(getJProgressBar(), BorderLayout.CENTER);
			jProgressPanel.add(jInfoLabel, BorderLayout.SOUTH);
		}
		return jProgressPanel;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setLeftComponent(getJStartSimulationButton());
			jSplitPane.setRightComponent(getJStopSimulationButton());
			jSplitPane.setDividerLocation(170);
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jStartSimulationButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJStartSimulationButton() {
		if (jStartSimulationButton == null) {
			jStartSimulationButton = new JButton();
			jStartSimulationButton.setText("Start");
			jStartSimulationButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Integer memoryType = ((ComboBoxOption<Integer>) jMemoryTypeComboBox.getSelectedItem()).getValue();
					if(memoryType == 0)
						return;
					else if (memoryType == -1) {
						memoryType = ((ComboBoxOption<Integer>) jAlgorithmComboBox.getSelectedItem()).getValue();
					}
					
					Integer memorySizeInKb = Integer.parseInt(jMemorySizeTextField.getText());
					Integer runForInSeconds = Integer.parseInt(jTimeToSimulateTextField.getText());
					String processesFile = jProcessFileTextField.getText();
					Integer fixedPartitionSizeInKb = 1;
					
					try {
						CmdLineMode.run(memoryType, memorySizeInKb, fixedPartitionSizeInKb, runForInSeconds, processesFile);
					}
					catch (Exception ex) {
						System.err.println(ex);
					}
				}
			});
		}
		return jStartSimulationButton;
	}

	/**
	 * This method initializes jStopSimulationButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJStopSimulationButton() {
		if (jStopSimulationButton == null) {
			jStopSimulationButton = new JButton();
			jStopSimulationButton.setText("Stop");
		}
		return jStopSimulationButton;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setValue(50);
			jProgressBar.setForeground(new Color(51, 51, 255));
		}
		return jProgressBar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"