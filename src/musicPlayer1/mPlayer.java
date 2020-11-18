package musicPlayer1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class mPlayer {
	JFrame window = new JFrame("MP3 MUSIC PLAYER");
	private JFrame frame;
    MP3 song;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mPlayer window = new mPlayer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public mPlayer() {
		initialize();
		song = null;
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 931, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblMyMpPlayer = new JLabel(" MP3 Player");
		lblMyMpPlayer.setBackground(new Color(152, 251, 152));
		lblMyMpPlayer.setForeground(new Color(139, 0, 0));
		lblMyMpPlayer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblMyMpPlayer.setBounds(10, 11, 172, 48);
		frame.getContentPane().add(lblMyMpPlayer);
		
		JButton openButton = new JButton("ADD");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				File selectedFile =fileChooser.getSelectedFile();
				
			     song = new MP3(selectedFile.getAbsolutePath());
				
			}
		});
		openButton.setBackground(Color.PINK);
		openButton.setBounds(371, 174, 109, 68);
		frame.getContentPane().add(openButton);
		
		
		JButton playButton = new JButton("PLAY");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				song.play();}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		playButton.setBackground(Color.LIGHT_GRAY);
		playButton.setBounds(490, 174, 109, 68);
		frame.getContentPane().add(playButton);
		
		JButton stopButton = new JButton("STOP");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				song.close();
			}
		});
		stopButton.setBackground(SystemColor.activeCaption);
		stopButton.setBounds(609, 174, 114, 68);
		frame.getContentPane().add(stopButton);
		 
		 
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(179, 11, 67, 48);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		Image img1 = new ImageIcon(this.getClass().getResource("/music.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(10, 70, 172, 220);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PAUSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setBounds(761, 174, 109, 68);
		frame.getContentPane().add(btnNewButton);
	}
}
