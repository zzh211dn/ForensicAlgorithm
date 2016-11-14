package PicBrowse;
import java.io.*;
import java.net.URL;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
public class imgVisible{
	//return an ImageIcon or null
	public ImageIcon createImage(String path){
		URL imgUrl=getClass().getResource(path);
		if(imgUrl!=null){
			return new ImageIcon(imgUrl);
		}else{
			System.out.println("Not Found "+imgUrl);
			return null;
		}
	}
	//Picture is blowed up and down 
	public Image getScaledImage(Image srcImg, int w, int h,int S){
		int scale=S;
        BufferedImage resizedImg = new BufferedImage(w*scale,h*scale, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w*scale, h*scale, null);
	    g2.dispose();
//	    PicBrowseFrame.
	    return resizedImg;
    }
	// copy picture to others
	public void PicCopy(String path1,String path2){
		try{
			FileInputStream in=new FileInputStream(path1);
			FileOutputStream out=new FileOutputStream(path2);
			int ch=in.read();
			while(ch!=-1){
				out.write(ch);
				ch=in.read();
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// copy picture to others
	public void PicMove(String path1,String path2){
		PicCopy(path1,path2);
		try{
			String cmd="del "+path1;
			System.out.println(cmd);
			Process P=Runtime.getRuntime().exec(cmd);
		}catch(Exception e){}
	}
	//get files absort path
	
}
