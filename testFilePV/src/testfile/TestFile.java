package testfile;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logic.TestFileLogic;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * Class represents the UI of application.
 * 
 * @author  sergiowork
 * @version 0.1
 */
public class TestFile {

	private JFrame frame;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_7;
	private static JLabel lblNewLabel_8;
	private static JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFile window = new TestFile();
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
	public TestFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(400,200,600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Задача");
		
		JLabel lblNmnmn = new JLabel("New label");
		lblNmnmn.setBounds(29, 40, 511, 15);
		frame.getContentPane().add(lblNmnmn);
		lblNmnmn.setText("Задача состоит в том, чтобы найти следующие четыре величины:");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(31, 93, 254, 15);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setText("1. максимальное число в файле");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(29, 138, 251, 15);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setText("2. минимальное число в файле");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(29, 186, 282, 15);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setText("3. медиану");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(29, 238, 282, 15);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setText("4. среднее арифметическое значение");
		
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(29, 322, 542, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(355, 93, 216, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(355, 138, 216, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(355, 186, 216, 15);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(355, 238, 216, 15);
		frame.getContentPane().add(lblNewLabel_8);
		

		JButton btnNewButton = new JButton("Найти");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// START TASK
				long start = System.currentTimeMillis();

				int maxNumber = TestFileLogic.maxNumberInFile(TestFileLogic.getFilePath());
				int minNumber = TestFileLogic.minNumberInFile(TestFileLogic.getFilePath());
				double average = TestFileLogic.averegeInFile(TestFileLogic.getFilePath());
				double median = TestFileLogic.medianInFile(TestFileLogic.getFilePath());

				setTextToLabel(String.valueOf(maxNumber), String.valueOf(minNumber), String.valueOf(median),
						String.valueOf(average));

				int seconds = (int) ((System.currentTimeMillis() - start) / 1000);
				frame.setTitle("Время выполнения = " + String.valueOf(seconds) + " sec");

				System.out.println(TestFileLogic.getFilePath() + "\n" 
						+ "maxNumber= " + String.valueOf(maxNumber) + "    " + "\n" + "minNumber= "
						+ String.valueOf(minNumber) + "    " + "\n" + "median= " + String.valueOf(median) + "    "
						+ "\n" + "average= " + String.valueOf(average));

				System.out.println("time= " + seconds + " sec" + "\n");
				// ENDTASK
				
			}
		});
		
		JButton button = new JButton("Открыть файл");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_5.setText("");
				lblNewLabel_6.setText("");
				lblNewLabel_7.setText("");
				lblNewLabel_8.setText("");
				lblNewLabel_9.setText("");
				frame.setTitle("Задача");
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					TestFileLogic.setFilePath(file.getAbsolutePath());

					if (TestFileLogic.checkFile(TestFileLogic.getFilePath()) == false) {
						btnNewButton.setEnabled(false);
					} else {
						TestFileLogic.setFilePath(file.getAbsolutePath());
						lblNewLabel_9.setText(file.getAbsolutePath());
						btnNewButton.setEnabled(true);
					}
				}
				
			}
		});
		
		button.setBounds(33, 285, 162, 25);
		frame.getContentPane().add(button);
		
		btnNewButton.setBounds(355, 285, 114, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setEnabled(false);
	}
	
	/**
	 * The method sets text of labels.
	 * 
	 * @param maxNumber Maximum number in file.
	 * @param minNumber Minimum number in file.
	 * @param median Median in file.
	 * @param average Average in file.
	 */
	public static void setTextToLabel(String maxNumber, String minNumber, String median, String average) {
		lblNewLabel_5.setText(maxNumber);
		lblNewLabel_6.setText(minNumber);
		lblNewLabel_7.setText(median);
		lblNewLabel_8.setText(average);
	}
}
