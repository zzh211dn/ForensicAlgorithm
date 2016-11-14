package SVM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SVMFileReadertest {
	String filename;
	BufferedReader br;
	
	public SVMFileReadertest(String filename) {
		
		File file = new File(filename);
		try {
			file = new File(file.getCanonicalPath());
			//System.out.println();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			 br = new BufferedReader(new InputStreamReader(fis));
			
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public SVMDatatest getSVMData(int lines,int length) {
		String strs[];
		String s1[];
		double x[][] = new double[lines][length];
		//int y[] = new int[lines];
		for (int i = 0; i < lines; i++) {
			try {
				strs = br.readLine().split(" ");
			//	y[i]=(int)Double.parseDouble(strs[0]);
			//	s1 = strs[1].split(" ");
				for (int j = 0; j < strs.length; j++)
				x[i][j]=Double.parseDouble(strs[j]);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new SVMDatatest(x);
	}

	public void printData(SVMDatatest Data) {
		double x[][]=Data.getX();
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++)
				System.out.print(x[i][j]+" ");
			    System.out.println();}
	}
	
	public static void main(String[] args) {
		
		SVMFileReadertest reader = new SVMFileReadertest(".\\src\\lib\\SimplifiedSMO\\heart_scale2");
		//SVMDatatest Data=reader.getSVMData(24);
	//	reader.printData(Data);
		//printDataLen(svmData);
	}
	
}
