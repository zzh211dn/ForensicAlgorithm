package PicBrowse;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class FileChooser {
	public static JFrame frame;
	public static JPanel conPane;
	public static JFileChooser fileChooser;
	private JPanel scanlePane=new JPanel();
	private static String[] files;
	private static String ParentPath;
	private static String filename;
	private static JLabel label1;
	public static String filePath;
	private int skip=0;
	private static int tag=0;
	private JLabel[] label=new JLabel[5];
	//保存图片的大小
	private static int width=0;
	private static int heigth=0;
	private static ImageIcon ig;
	public void FileChoosercr() {
		frame = new JFrame("文件选择");
		conPane = (JPanel) frame.getContentPane();
		conPane.setLayout(new BorderLayout());
		fileChooser = new JFileChooser();
		//添加FileFilter
		fileChooser.setFileFilter(new ImageFilter());
		//Accept file from file filter.
		fileChooser.addChoosableFileFilter(new ImageFilter());
        fileChooser.setAcceptAllFileFilterUsed(true);
        //Add custom icons for file types.
        fileChooser.setFileView(new ImageFileView());
		//添加文件预览
		fileChooser.setAccessory(new ImagePreview(fileChooser));
		// fileChooser.addActionListener(new FileChooserListener());
		// 选择 确定、取消按钮
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename=fileChooser.getSelectedFile().getName();
			System.out.println(filename);
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
			ig=new ImageIcon(filePath);
			width=ig.getIconWidth();
			heigth=ig.getIconHeight();
			PicBrowseFrame.lab.setIcon(ig);
			//获取文件的父路径
			ParentPath=fileChooser.getSelectedFile().getParent();
			files = fileChooser.getSelectedFile().getParentFile().list();
			//这里加入图片的缩小浏览，采用滚动条
			scanlePane.setBackground(new Color(16712));
			scanlePane.setBounds(0, 0, 800, 20);
			scanlePane.setLayout(new GridLayout(1,8,0,20));
			JButton upPage=new JButton("上一页");
			upPage.addActionListener(new UpPageListener());
			JButton downPage=new JButton("下一页");
			downPage.addActionListener(new DownPageListener());
			scanlePane.add(upPage);
			scanlePane.add(downPage);
			preView();
			
			
			//END
		}
		if (returnVal == JFileChooser.CANCEL_OPTION) {
			frame.dispose();
		}
		// end
		//获取文件的文件路径
		conPane.add(fileChooser);
		frame.pack();
		frame.setLocation(210, 230);
		frame.setVisible(true);
		frame.dispose();
	}
	//查找图片的位置
	private void pointPic() {
		for (int i = 0; i < files.length; i++) {
			if (files[i].equalsIgnoreCase(filename)) {
				tag = i;
				break;
			}
		}
	}
	//这里加入图片的缩小浏览，采用滚动条
	private void preView(){
		int length=tag+5;
		int j=0;
		for(int i=tag;i<length;i++){
			if(new FileNameFilter().acceptfile(files[i])){
				try{
				
					ImageIcon iconScanle=new ImageIcon(ParentPath+"\\"+files[i]);
					ImageIcon scaleIcon = new ImageIcon(new imgVisible().getScaledImage(iconScanle.getImage(),50,50,1));
					label[j]=new JLabel(scaleIcon);
					scanlePane.add(label[j]);
					j++;
					PicBrowseFrame.conPane.add(scanlePane,BorderLayout.SOUTH);
				}catch(java.lang.NullPointerException e){}
		
			}else length+=1;
			
		}
	}
	//图片的缩小浏览的滚动
	private void preViewMove(int tag){
		int length=tag+5;
		int j=0;
		for(int i=tag;i<length;i++){
			if(new FileNameFilter().acceptfile(files[i])){
				try{
					ImageIcon iconScanle=new ImageIcon(ParentPath+"\\"+files[i]);
					ImageIcon scaleIcon = new ImageIcon(new imgVisible().getScaledImage(iconScanle.getImage(),50,50,1));
					label[j].setIcon(scaleIcon);
					scanlePane.add(label[j]);
					j++;
				}catch(java.lang.NullPointerException e){}
			}else length+=1;
		
		}
	}
	//放大图片
	private ImageIcon srcImg;
	public void picUpScanle(){
			srcImg=new ImageIcon(filePath);
			width+=50;
			heigth+=50;
			ImageIcon scaleIcon = new ImageIcon(new imgVisible().getScaledImage(srcImg.getImage(),width,heigth,1));
			PicBrowseFrame.lab.setIcon(scaleIcon);
	}
	//缩小图片
	public void picDownScanle(){
		srcImg=new ImageIcon(filePath);
		width-=50;
		heigth-=50;
		ImageIcon scaleIcon = new ImageIcon(new imgVisible().getScaledImage(srcImg.getImage(),width,heigth,1));
		PicBrowseFrame.lab.setIcon(scaleIcon);
	}
	//上下页的监听事件
	class UpPageListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			tag-=1;
			ImageIcon ig=new ImageIcon(ParentPath+"\\"+files[tag]);
			preViewMove(tag);
			PicBrowseFrame.lab.setIcon(ig);
			filePath=ParentPath+"\\"+files[tag];
			
		}
		
	}
	class DownPageListener implements java.awt.event.ActionListener{
		public void actionPerformed(ActionEvent e){
			tag+=1;
			ImageIcon ig=new ImageIcon(ParentPath+"\\"+files[tag]);
			preViewMove(tag);
			PicBrowseFrame.lab.setIcon(ig);
			filePath=ParentPath+"\\"+files[tag];
		}
			
	}
	//End

}

