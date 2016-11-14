package PicBrowse;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class PicBrowseFrame extends JFrame{
	private static JFrame frame=new JFrame("Picture Browse");//顶层容器
	public static JPanel conPane;
	private static JMenuItem tempItem;
	public  static JLabel lab;
	FileChooser FileCh=new FileChooser();
	public  PicBrowseFrame(){
		frame.setResizable(false);
		conPane=(JPanel)frame.getContentPane();
		conPane.setLocation(200, 300);
		conPane.setLayout(new BorderLayout());
		JMenuBar menuBar=new JMenuBar();
		frame.setJMenuBar(menuBar);
		//文件菜单
		JMenu File=new JMenu("File");
		menuBar.add(File);
		tempItem=new JMenuItem("Load");
		tempItem.addActionListener(new LoadListener());
		File.add(tempItem);
		tempItem=new JMenuItem("Load From URL");
		tempItem.addActionListener(new LoadUrlListener());
		File.add(tempItem);
		tempItem=new JMenuItem("Exit");
		tempItem.addActionListener(new ExitListener());
		File.add(tempItem);
		//文件菜单END
		//编辑菜单
		JMenu Edit=new JMenu("Edit");
		menuBar.add(Edit);
		tempItem=new JMenuItem("CopyTo");
		tempItem.addActionListener(new CopyListener());
		Edit.add(tempItem);
		tempItem=new JMenuItem("MoveTo");
		tempItem.addActionListener(new MoveListener());
		Edit.add(tempItem);
		//编辑菜单END
		//缩放菜单
		JMenu Scanle=new JMenu("Scanle");
		menuBar.add(Scanle);
		tempItem=new JMenuItem("Blow Up");
		tempItem.addActionListener(new UpListener());
		Scanle.add(tempItem);
		tempItem=new JMenuItem("Blow Down");
		tempItem.addActionListener(new DownListener());
		Scanle.add(tempItem);
		//缩放菜单END
		//HELP
		JMenu help=new JMenu("Help");
		menuBar.add(help);
		tempItem=new JMenuItem("about");
		help.add(tempItem);
		//END
		//显示图片
		JPanel imgPane=new JPanel();
		imgPane.setLayout(new BorderLayout());
		ImageIcon icon=new imgVisible ().createImage("");
		//ImageIcon scaleIcon = new ImageIcon(new imgVisible ().getScaledImage(icon.getImage(),icon.getIconWidth(),icon.getIconHeight(),2));
		lab=new JLabel(icon);
		imgPane.add(lab);
		conPane.add(imgPane,BorderLayout.CENTER);
		//END
		frame.setMinimumSize(new Dimension(800,600));
		frame.setLocation(60, 80);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		System.out.print("start here");
		new PicBrowseFrame();
	}
	//文件菜单的监听事件
	//Load Listener
	class LoadListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			FileCh.FileChoosercr();	
		}		
	}
	//Load URL Listener
	class LoadUrlListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			String path="https://inventory.sun.com/RegistrationWeb/nbgf/default/en_US/images/loginheader.jpg";
			ImageIcon icon=new imgVisible ().createImage(path);
			JLabel label1=new JLabel(icon);
		}		
	}
	//Exit Listener
	class ExitListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}		
	}
	//End
	//编辑菜单的监听事件
	class CopyListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser saveFile=new JFileChooser();
			int result=saveFile.showSaveDialog(frame);
			String savePath=saveFile.getSelectedFile().getAbsolutePath();
			if(result==JFileChooser.APPROVE_OPTION){
				new imgVisible().PicCopy(FileChooser.filePath, savePath);
				
			}else{
			}
		}		
	}
	//Exit Listener
	class MoveListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser saveFile=new JFileChooser();
			int result=saveFile.showSaveDialog(frame);
			String savePath=saveFile.getSelectedFile().getAbsolutePath();
			if(result==JFileChooser.APPROVE_OPTION){
				new imgVisible().PicMove(FileChooser.filePath, savePath);
				
			}else{
			}
		}		
	}
	//END
	//缩放菜单的监听事件
	class UpListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			FileCh.picUpScanle();
		}		
	}
	//Exit Listener
	class DownListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			FileCh.picDownScanle();
		}		
	}
	//END
}

