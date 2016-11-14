package douframe;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTo {

	public void writeTo(String filename, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(filename, false);
			writer.write(content);
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			// System.out.println("appendMethod:IOException");
			e.printStackTrace();
		}
	}
	public void writeToContinue(String filename, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(filename, true);
			writer.write(content);
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			// System.out.println("appendMethod:IOException");
			e.printStackTrace();
		}
	}

	public void writeToContinueNoNewLine(String filename, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(filename, true);
			writer.write(content);
//			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			// System.out.println("appendMethod:IOException");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int value = 32;
		do {

			System.out.print((value & 1)+" , ");
			value >>>= 1;
		} while (value != 0);
	}

}
