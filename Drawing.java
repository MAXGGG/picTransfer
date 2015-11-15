package picTransfer;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Drawing {
	public static void main(String[] args) {
		try {
			String content = "";
			Pixel pixel = new Pixel();
			int[][] brightness = pixel.GetBlackness();
			for(int[]a:brightness){
				for(int b:a){
					if(b!=0){
					System.out.println(b);}
					if(b==9){
						content = content+" ";
					}else if(b==8){
						content = content+".";
					}else if(b==7){
						content = content+":";
					}else if(b==6){
						content = content+"-";
					}else if(b==5){
						content = content+"=";
					}else if(b==4){
						content = content+"+";
					}else if(b==3){
						content = content+"*";
					}else if(b==2){
						content = content+"#";
					}else if(b==1){
						content = content+"%";
					}else if(b==0){
						content = content+"@";
					}
				}
				content=content+"\n";
			}
			

			File file = new File("/Users/Yin/Documents/Development/workspace/picTransfer/filename.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}