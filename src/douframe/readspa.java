package douframe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.RandomAccessFile;

public class readspa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path="C:\\Users\\fish123\\Desktop\\nnnn\\小脑2\\xiaonao0508.spa";
//		FileInputStream  f = new FileInputStream(path);
	
		try{
//			BufferedReader bufr = new BufferedReader(new FileInputStream(f));
			RandomAccessFile in=new RandomAccessFile(path,"r");
			Integer find234 = Integer.parseInt("234",16);
			in.seek(find234);
			byte[] data = new byte[4];
			in.read(data);
			System.out.println(Integer.parseInt(new String(data),16));			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
