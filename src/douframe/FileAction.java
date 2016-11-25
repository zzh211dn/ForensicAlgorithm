package douframe;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import pcaa.pcaa;
import kmeanss.kmeanss;
import matrixplot.matrixplot;
import myzoom.myzoom;
import DataPre.DataPre;
import drawPic.*; 

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWComplexity;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class FileAction {
	private File[] files;
	private File fileonly;
	public JFileChooser fileChooser;
	//	private String path ;
	public static String[] waveres = {};

	public static String[] getAbres() {
		return abres;
	}

	public static String filename="";
	public static String[] abres= {};
	public static String[] fwaveres = {};
	public static String[] fabres= {};
	public static String[] waverespart = {};
	public static String[] abrespart= {};

	public static ArrayList<String> getNameList() {
		return nameList;
	}

	public static ArrayList<String> nameList= new ArrayList<>();

	public ArrayList<String[]> getWavelist() {
		return wavelist;
	}

	public ArrayList<String[]> wavelist = new ArrayList<String[]>();
	public static String[] wavejuzheng= {};	
	public static String[] absjuzheng= {};

	public ArrayList<String[]> getAbslist() {
		return abslist;
	}

	public ArrayList<String[]> abslist = new ArrayList<String[]>();
	StringUtils su = new StringUtils();


/*	public void OpenFiles()//打开文件夹
	{
				frame = new JFrame("文件选择");
		fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
		int returnVal = fileChooser.showDialog(new JLabel(), "选择");
		if(returnVal == fileChooser.APPROVE_OPTION)
		{
			File file=fileChooser.getSelectedFile();
			if(file.isDirectory()){
				String path= file.getAbsolutePath();

				files = file.listFiles();
				try {
					//					JOptionPane.showMessageDialog(null, "请等待文件加载完成", "消息提示", JOptionPane.WARNING_MESSAGE);
					for(File s : files)
					{
						nameList.add(s.getAbsolutePath());
						fwaveres  = null;
						fabres = null;
						DataPre p = new DataPre();
						System.out.println(s.getAbsolutePath());
						Object[] res = p.DataPre(2,s.getAbsolutePath());
						String[] wave = res[0].toString().trim().split("    ");
						fwaveres = new String[wave.length-1];
						String[] abs = res[1].toString().trim().split("    ");
						fabres = new String[abs.length-1];

						String content = "";

						for(int i = wave.length-1,j=0;i>0;i--,j++)//第一个数为数据量级 即 乘 e的n次方
						{
							if(wave[i].contains("Column"))
							{

								fwaveres[j] = wave[i].split("Column")[0];
								fwaveres[j] = Float.parseFloat(su.replaceBlank(fwaveres[j]))*1000+"";
								//								System.out.println(fwaveres[j]);
								fabres[j] = abs[i].split("Column")[0];
								fabres[j] =  su.replaceBlank(fabres[j]);
								//								System.out.println(fabres[j]);
							}
							else
							{
								fwaveres[j] = Float.parseFloat(wave[i])*1000+"";
								fabres[j] =  abs[i];
							}
							if(i==1)
							{content = content+fwaveres[j]+","+fabres[j]+",";break;}
							content = content+fwaveres[j]+","+fabres[j]+",\r\n";
						}
						//						System.out.println("ssss");
						WriteTo  wt = new WriteTo();
						wt.writeTo(s.getParentFile().getParentFile().getAbsolutePath()+"\\"+s.getName().replace(".SPA", "")+".csv",content);
					}
					JOptionPane.showMessageDialog(null, "文件加载完成", "消息提示", JOptionPane.WARNING_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					fileChooser = null;
					path = null;
					files = null;
				}
			}
			else if(file.isFile()){
				JOptionPane.showMessageDialog(null, "文件路径错误", "消息提示", JOptionPane.ERROR_MESSAGE);
			}
		}
		上面的代码为原本读取spa文件，现废弃。
	}*/

	public double[][] chooseFeatureFile(String text)
	{
		double[][] featureres  = null;
		fileChooser=new JFileChooser();  
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY ); 
		int returnVal = fileChooser.showDialog(new JLabel(), text); 
		if(returnVal == fileChooser.APPROVE_OPTION)
		{
			File file=fileChooser.getSelectedFile();  
			try
			{	

				BufferedReader read= new BufferedReader(new FileReader(file));
				String temp = "";
				int row = 0;
				ArrayList<String[]> al = new ArrayList<String[]>();
				int collength = 0;
				while((temp = read.readLine())!=null)
				{
					String[]  feature= temp.split(",");
					collength = feature.length;
					al.add(feature);
				}

				featureres=new double[al.size()][collength];
				for(int i = 0;i<al.size();i++)
				{
					for(int j = 0;j<collength;j++)
					{
						featureres[i][j] = Double.parseDouble(al.get(i)[j]);
					}
				}

			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return featureres;
		}
		//		else{
		//			
		//		}
		return null;
	}

	public boolean openSelectFiles(int readTall,int readLength,int startReadRow,int startReadCol,int allLength) {
		fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
		int returnVal = fileChooser.showDialog(new JLabel(), "选择");
		if(returnVal == fileChooser.APPROVE_OPTION)
		{
			File file=fileChooser.getSelectedFile();
			if(file.isDirectory()){
				String path= file.getAbsolutePath();
				files = file.listFiles();
				abslist =new ArrayList<String[]>();
				try {
					for(int i = 0;i<readTall;i++)
					{
						for(int j = 0;j<readLength;j++)
						{
							int fileat = (startReadRow+i-1)*allLength+startReadCol+j;
//							System.out.println(fileat);
//							System.out.println(files[fileat].getName());
							BufferedReader read = new BufferedReader(new FileReader(files[fileat]));
							String tempstr ;
							String[] res = new String[2];
							ArrayList<String> arabres = new ArrayList<String>();
							while((tempstr=read.readLine())!=null)//读没一行，若不为空。
							{
								res=tempstr.split(",");
								arabres.add(res[1]);
							}

							fabres = new String[arabres.size()];
							for(int m = 0;m<arabres.size();m++)
							{

								fabres[i]=arabres.get(i);
							}
							abslist.add(fabres);
						}
					}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					files = null;
					fileChooser = null;

				}
				return true;
			}

		}
		return false;
	}



	public List<String> chooseLabelFile(String text)
	{
		List<String> label  = new ArrayList<>();
		fileChooser=new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY );
		int returnVal = fileChooser.showDialog(new JLabel(), text);
		if(returnVal == fileChooser.APPROVE_OPTION)
		{
			File file=fileChooser.getSelectedFile();
			try
			{
				BufferedReader read= new BufferedReader(new FileReader(file));
				String temp = "";
				while((temp = read.readLine())!=null)
				{
					String  signLabel= temp;
					label.add(signLabel);
				}
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return label;
		}
		return null;
	}

	public ArrayList<String> chooseLabelFile()
	{
		ArrayList<String> al = new ArrayList<String>();
		fileChooser=new JFileChooser();  
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY ); 
		int returnVal = fileChooser.showDialog(new JLabel(), "选择标签集"); 
		if(returnVal == fileChooser.APPROVE_OPTION)
		{
			File file=fileChooser.getSelectedFile(); 
			al.add(file.getParentFile().getAbsolutePath());
			try
			{	
				//				JOptionPane.showMessageDialog(null, "请等待文件加载完成", "消息提示", JOptionPane.WARNING_MESSAGE);
				BufferedReader read= new BufferedReader(new FileReader(file));
				String temp = "";
				while((temp = read.readLine())!=null)
				{
//					System.out.println(temp);
					al.add(temp);
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(al.size());
			return al;
		}
		return null;
	}

	public boolean multyOpenFile()
	{
		fileChooser=new JFileChooser();  
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY ); 
		int returnVal = fileChooser.showDialog(new JLabel(), "选择"); 
		ArrayList<Double[]> multyWaveres = new ArrayList<Double[]>();
		ArrayList<Double[]> multyAbres = new ArrayList<Double[]>();
		Double[] multywaveres = null ;
		Double[] multyabres = null;
		int maxrow = 0;
		if(returnVal == fileChooser.APPROVE_OPTION)
		{
			File[] files =fileChooser.getSelectedFiles();
			for(int i=0;i<files.length;i++)
			{
				BufferedReader read;
				try 
				{
					read = new BufferedReader(new FileReader(files[i]));

					String tempstr ;
					String[] res = new String[2];			
					ArrayList<String> arwaveres = new ArrayList<String>();
					ArrayList<String> arabres = new ArrayList<String>();
					while((tempstr=read.readLine())!=null)//读没一行，若不为空。
					{	
						res=tempstr.split(",");
						arwaveres.add(res[0]);
						arabres.add(res[1]);
					}
					if(arwaveres.size()>maxrow)
						maxrow = arwaveres.size();
					multywaveres = new Double[arwaveres.size()]; 
					multyabres = new Double[arabres.size()]; 
					for(int it = 0;it<arwaveres.size();it++)
					{
						multywaveres[it]=Double.valueOf(arwaveres.get(it));
						multyabres[it]=Double.valueOf(arabres.get(it))*10000;
					}
					multyWaveres.add(multywaveres);
					multyAbres.add(multyabres);
					//										System.out.println("next   "+i);
				}
				catch (Exception e) {
					e.printStackTrace();
				}	
			}
			Double[][] multyW = new Double[maxrow][multyWaveres.size()];
			Double[][] multyA = new Double[maxrow][multyAbres.size()];
			Double maxnum=-1.0;
			Double minnum = multyAbres.get(0)[0];

			Double sum = 0.0;
			int allab = 0;
			for (int n = 0;n<multyWaveres.size();n++)
			{
				for(int m = 0;m<multyWaveres.get(n).length;m++)
				{
					allab++;
					multyW[m][n] =multyWaveres.get(n)[m]; 
					multyA[m][n] =multyAbres.get(n)[m]; 
					sum = sum+multyA[m][n];
					if(multyA[m][n]>maxnum)
						maxnum = multyA[m][n];
					if(minnum>multyA[m][n])
						minnum = multyA[m][n];
				}
			}
			Double average =sum/allab;

			myZoom(multyW,multyA,maxnum/10000,minnum/10000,average/10000);
			return true;
		}

		return true;
	}	

	public boolean myZoom(Double[][] waveres ,Double[][] abres, Double maxnum,
			Double minnum, Double average)
	{
		MWNumericArray waverespartInt = null; // 存放x值的数组
		MWNumericArray abresparttInt = null; // 存放y值的数组
		MWNumericArray wavesfloat = new MWNumericArray(waveres, MWClassID.DOUBLE);
		MWNumericArray abresfloat= new MWNumericArray(abres, MWClassID.DOUBLE);
		try {
			myzoom mz = new myzoom();
			//,maxnum,minnum,average);
			final Double maxnum1 =maxnum;
			final Double minnum1 =minnum;
			final Double average1 =average;
			Thread thread = new Thread(){
				public void run()
				{
					JOptionPane.showMessageDialog(null, "最大值："+maxnum1+"\n最小值："
							+minnum1+"\n平均值："+average1, "数据显示", JOptionPane.INFORMATION_MESSAGE);
				}
			};
			thread.start();
			mz.myzoom(wavesfloat, abresfloat);
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}


		public boolean OpenFile()//打开文件
		{
			fileChooser=new JFileChooser();  
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY );  
			int returnVal = fileChooser.showDialog(new JLabel(), "选择");  
			if(returnVal == fileChooser.APPROVE_OPTION)
			{
				fileonly=fileChooser.getSelectedFile();
				filename=fileonly.getPath();
				try {
					BufferedReader read = new BufferedReader(new FileReader(fileonly));
					String tempstr ;
					String[] res = new String[2];
					//						int i = 0;
					ArrayList<String> arwaveres = new ArrayList<String>();
					ArrayList<String> arabres = new ArrayList<String>();
					while((tempstr=read.readLine())!=null)//读没一行，若不为空。
					{	
						res=tempstr.split(",");
						//					System.out.println(res[0]+"aaaaaa"+res[1]);
						arwaveres.add(res[0]);
						arabres.add(res[1]);
					}
					fwaveres = null;
					fabres = null;
					waveres = new String[arwaveres.size()];
					abres = new String[arwaveres.size()];
					for(int i = 0;i<arwaveres.size();i++)
					{
						waveres[i]=arwaveres.get(i);
						abres[i]=arabres.get(i);
					}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				showData(waveres,abres);
				return true;
			}
			return false;
		}

		public void showData(String[] waveres,String[] abre)
		{
			Object[][] obj = new Object[waveres.length][5]; 
			int m = 1;
			for (int i = 0; i <waveres.length; i++)  
			{  

				for (int j = 0; j < 5; j++)  
				{  
					switch(j)
					{
					case 0: obj[i][0] = fileonly.getName();break;
					case 1: obj[i][1] = m++;break;
					case 2: obj[i][2] = waveres[i];break;
					case 3: obj[i][3] = abres[i];break;
					case 4:   break;//new JCheckBox();break;
					}
				}  
			}		
			String[] columnNames =  { "文件号", "点号", "X轴", "Y轴", "选中"};
			TableColumn column = null;  
			final JTable table = new JTable(obj,columnNames);		

			int colunms = table.getColumnCount();  
			for(int i = 0; i < colunms; i++)  
			{  
				column = table.getColumnModel().getColumn(i);  
				column.setPreferredWidth(300);  
			}  

			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  
			AlgorithmFrame.scroll.setViewportView(table);  
		}
		public void drawPicture(MWNumericArray waveres,MWNumericArray abres)
		{

			try {
				Class1 dp = new Class1();
				dp.drawPic(waveres, abres);
			} catch (MWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void boXingXuanZe(int start, int end)//创建界面选波形
		{
			waverespart = new String[end-start+1];
			abrespart = new String[end-start+1];

			MWNumericArray waverespartInt = null; // 存放x值的数组
			MWNumericArray abresparttInt = null; // 存放y值的数组
			int n = waveres.length;
			int[] dims = { 1, n };
			waverespartInt = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,
					MWComplexity.REAL);
			abresparttInt = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,
					MWComplexity.REAL);

			for(int i = start;i<=end;i++)
			{
				waverespart[i-start] = waveres[i-1];
				abrespart[i-start] = abres[i-1];
				waverespartInt.set(i-start+1,Float.parseFloat(waverespart[i-start])*1000);
				abresparttInt.set(i-start+1 ,Float.parseFloat(abrespart[i-start]));
			}
			showData(waverespart,abrespart);
			drawPicture(waverespartInt,abresparttInt);
			AlgorithmFrame.jf.dispose();
		}

		public void juZhenXuanZe(int index,int row, int col )//创建界面选矩阵
		{
			wavejuzheng = new String[wavelist.size()];
			absjuzheng = new String[wavelist.size()];

			//		MWNumericArray JZwaverespartInt = null; // 存放x值的数组
			MWNumericArray JZabresparttInt = null; // 存放y值的数组
			int n = wavejuzheng.length;
			int[] dims = { 1, n+2 };

			JZabresparttInt = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,
					MWComplexity.REAL);
			JZabresparttInt.set(1,row);
			JZabresparttInt.set(2,col);
			System.out.println(wavelist.size());
			for(int i=0;i<wavelist.size();i++)//前两个数为行列值，第三个数开始为矩阵数值
			{		
				absjuzheng[i] = abslist.get(i)[index];
				JZabresparttInt.set(i+3 ,Float.parseFloat(absjuzheng[i]));
			}
			try {
				matrixplot mp = new matrixplot();
				mp.matrixplot(JZabresparttInt);
				//			AlgorithmFrame.jfjuzheng.dispose();
			} catch (MWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void baoCun(){//创建界面选波形
			JFileChooser fileChooser1;
			fileChooser1=new JFileChooser();  
			fileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
			int returnVal = fileChooser1.showDialog(new JLabel(), "选择");  
			if(returnVal == fileChooser1.APPROVE_OPTION)
			{
				File file=fileChooser1.getSelectedFile();  
				String path1 ;
				String content = "wave,spect,\r\n";
				if(file.isDirectory()){
					path1= file.getAbsolutePath();
					for(int i = 0;i<waveres.length;i++)
					{
						content = content+waveres[i]+","+abres[i]+",\r\n";
					}
					WriteTo  wt = new WriteTo();
					wt.writeTo(path1+"\\"+fileonly.getName()+".csv",content);
					JOptionPane.showMessageDialog(null, "文件保存完成", "消息提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			fileChooser1=null;
		}

		public boolean JuZhenopenFiles() {
			// TODO Auto-generated method stub
			fileChooser=new JFileChooser();  
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
			int returnVal = fileChooser.showDialog(new JLabel(), "选择");  
			if(returnVal == fileChooser.APPROVE_OPTION)
			{
				File file=fileChooser.getSelectedFile();  
				if(file.isDirectory()){
					String path= file.getAbsolutePath();
					files = file.listFiles();
					//draw(path)
					wavelist = new ArrayList<String[]>();
					abslist =new ArrayList<String[]>();
					try {
						for(File s : files)
						{
							if(s.getName().indexOf(".csv") > -1)
							{
								BufferedReader read = new BufferedReader(new FileReader(s));
								String tempstr ;
								String[] res = new String[2];
								//						int i = 0;
								ArrayList<String> arwaveres = new ArrayList<String>();
								ArrayList<String> arabres = new ArrayList<String>();
								while((tempstr=read.readLine())!=null)//读没一行，若不为空。
								{	
									res=tempstr.split(",");

									arwaveres.add(res[0]);
									arabres.add(res[1]);
								}
								fwaveres = null;
								fabres = null;
								fwaveres = new String[arwaveres.size()];
								fabres = new String[arwaveres.size()];
								for(int i = 0;i<arwaveres.size();i++)
								{
									fwaveres[i]=arwaveres.get(i);
									fabres[i]=arabres.get(i);
								}
								wavelist.add(fwaveres);
								abslist.add(fabres);
							}
						}

					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						files = null;
						fileChooser = null;

					}
				}
				return true;
			}
			return false;
		}

		public boolean openFiles(String name) {
			fileChooser=new JFileChooser();  
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
			int returnVal = fileChooser.showDialog(new JLabel(), name);
			if(returnVal == fileChooser.APPROVE_OPTION)
			{
				File file=fileChooser.getSelectedFile();  
				if(file.isDirectory()){
					String path= file.getAbsolutePath();
					files = file.listFiles();
					abslist =new ArrayList<String[]>();
					try {
						for(File s : files)
						{
							if(s.getName().indexOf(".csv") > -1||s.getName().indexOf(".CSV") > -1)
							{
								nameList.add(s.getName());
								BufferedReader read = new BufferedReader(new FileReader(s));
								String tempstr ;
								String[] res = new String[2];
								ArrayList<String> arabres = new ArrayList<String>();
								while((tempstr=read.readLine())!=null)//读没一行，若不为空。
								{	
									res=tempstr.split(",");
									arabres.add(res[1]);
								}
								fabres = new String[arabres.size()];

								System.out.println(arabres.size());

								for(int i = 0;i<arabres.size();i++)
								{
									fabres[i]=arabres.get(i);
								}
								abslist.add(fabres);
							}
						}
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						files = null;
						fileChooser = null;

					}
				}
				return true;
			}
			return false;
		}

		public void PCAhelp(int ws)
		{
			MWNumericArray JZabresparttInt = null; // 存放y值的数组
			int size =  abslist.size();
			int len = abslist.get(0).length;

			int n = size*len;
			int[] dims = { 1, n+2 };
			JZabresparttInt = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,MWComplexity.REAL);
			JZabresparttInt.set(1,ws);
			JZabresparttInt.set(2,size);

			int m = 0;

			for(int i=0;i<size;i++)//前两个数为行列值，第三个数开始为矩阵数值
			{		
				for(int j = 0;j<len;j++)
				{
					JZabresparttInt.set(m+3 ,Float.parseFloat(abslist.get(i)[j]));
					m++;
				}
			}
			try {
				pcaa mp = new pcaa();
				mp.pcaa(4,JZabresparttInt);
				//			AlgorithmFrame.jfjuzheng.dispose();
			} catch (MWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	public void kmeanshelp(int leinum,int row ,int col) {

		MWNumericArray JZabresparttInt = null; // 存放y值的数组
		int size =  abslist.size();
		int len = abslist.get(0).length;
		int n = size*len;
		int[] dims = { 1, n+4 };
		JZabresparttInt = MWNumericArray.newInstance(dims, MWClassID.DOUBLE,
				MWComplexity.REAL);
		JZabresparttInt.set(1,size);
		JZabresparttInt.set(2,leinum);
		JZabresparttInt.set(3,row);
		JZabresparttInt.set(4,col);
		int m = 0;

		for(int i=0;i<size;i++)//前两个数为行列值，第三个数开始为矩阵数值
		{
			for(int j = 0;j<len;j++)
			{
				JZabresparttInt.set(m+5 ,Float.parseFloat(abslist.get(i)[j]));
				m++;
			}
		}
		try {
			kmeanss mp = new kmeanss();
			mp.kmeanss(JZabresparttInt);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

		/*public boolean kmeansopenFiles() {
			fileChooser=new JFileChooser();  
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
			int returnVal = fileChooser.showDialog(new JLabel(), "选择");  
			if(returnVal == fileChooser.APPROVE_OPTION)
			{
				File file=fileChooser.getSelectedFile();  
				if(file.isDirectory()){
					String path= file.getAbsolutePath();
					files = file.listFiles();
					//draw(path)
					abslist =new ArrayList<String[]>();
					try {
						for(File s : files)
						{
							if(s.getName().indexOf(".csv") > -1||s.getName().indexOf(".CSV") > -1)
							{
								BufferedReader read = new BufferedReader(new FileReader(s));
								String tempstr ;
								String[] res = new String[2];
								//						int i = 0;
								//							ArrayList<String> arwaveres = new ArrayList<String>();
								ArrayList<String> arabres = new ArrayList<String>();
								while((tempstr=read.readLine())!=null)//读没一行，若不为空。
								{	
									res=tempstr.split(",");

									//								arwaveres.add(res[0]);
									arabres.add(res[1]);
								}
								//							fwaveres = new String[arwaveres.size()];
								fabres = new String[arabres.size()];
								for(int i = 0;i<arabres.size();i++)
								{
									//								fwaveres[i]=arwaveres.get(i);
									fabres[i]=arabres.get(i);
								}
								//							wavelist.add(fwaveres);
								abslist.add(fabres);
							}
						}
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						files = null;
						fileChooser = null;

					}
				}
				return true;
			}
			return false;
		}*/




	}