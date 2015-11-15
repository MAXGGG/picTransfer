package picTransfer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class Pixel {
	BufferedImage image;
	int width;
	int height;
	double[][] blackness;
	double[][] blackness_area;
	int[][] brightness;

	public int[][] GetBlackness(String file_name) {
		try {
			File input = new File(file_name);
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			blackness = new double[height][width];
			blackness_area = new double[height][width];
			int number_of_chars_row = height/8;
			int number_of_chars_column = width/5;
			int count = 0;
			brightness = new int[number_of_chars_row][number_of_chars_column];

			for (int i = 0; i < height; i++) {

				for (int j = 0; j < width; j++) {

					count++;
					Color c = new Color(image.getRGB(j, i));
					blackness[i][j] = 0.0722*c.getBlue() + 0.7125*c.getGreen() + 0.2126*c.getRed();
				}
			}

			for (int row_no = 0; row_no < number_of_chars_row; row_no++) {
				
				for (int column_no = 0; column_no < number_of_chars_column; column_no++) {
					for (int i = 0 + 8 * row_no; i <8+8 * row_no; i++) {

						for (int j = 0 + 5 * column_no; j < 5 + 5 * column_no; j++) {
							blackness_area[row_no][column_no] = blackness[i][j]
									+ blackness_area[row_no][column_no];
							
						}
					}
					blackness_area[row_no][column_no] = blackness_area[row_no][column_no]/40;
					System.out.println(blackness_area[row_no][column_no]);
					if(blackness_area[row_no][column_no]>9000/40){
						brightness[row_no][column_no] = 9;
					}else if(blackness_area[row_no][column_no]<=9000/40&&blackness_area[row_no][column_no]>8000/40){
						brightness[row_no][column_no] = 8;
					}else if(blackness_area[row_no][column_no]<=8000/40&&blackness_area[row_no][column_no]>7000/40){
						brightness[row_no][column_no] = 7;
					}else if(blackness_area[row_no][column_no]<=7000/40&&blackness_area[row_no][column_no]>6000/40){
						brightness[row_no][column_no] = 6;
					}else if(blackness_area[row_no][column_no]<=6000/40&&blackness_area[row_no][column_no]>5000/40){
						brightness[row_no][column_no] = 5;
					}else if(blackness_area[row_no][column_no]<=5000/40&&blackness_area[row_no][column_no]>4000/40){
						brightness[row_no][column_no] = 4;
					}else if(blackness_area[row_no][column_no]<=4000/40&&blackness_area[row_no][column_no]>3000/40){
						brightness[row_no][column_no] = 3;
					}else if(blackness_area[row_no][column_no]<=3000/40&&blackness_area[row_no][column_no]>2000/40){
						brightness[row_no][column_no] = 2;
					}else if(blackness_area[row_no][column_no]<=2000/40&&blackness_area[row_no][column_no]>1000/40){
						brightness[row_no][column_no] = 1;
					}else{
						brightness[row_no][column_no] = 0;
					}
				}

			}
		} catch (Exception e) {
		}
		return brightness;
	}

}
