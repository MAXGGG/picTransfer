package picTransfer;
// Made by Max Yin, contributed by Andrew Choi.
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
			int HEIGHT_BASE = 5;
			int WIDTH_BASE = 3;
			int number_of_chars_row =height/HEIGHT_BASE;
			int number_of_chars_column =width/WIDTH_BASE;
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
					for (int i = 0 + HEIGHT_BASE * row_no; i <HEIGHT_BASE+HEIGHT_BASE * row_no; i++) {

						for (int j = 0 + WIDTH_BASE * column_no; j < WIDTH_BASE + WIDTH_BASE * column_no; j++) {
							blackness_area[row_no][column_no] = blackness[i][j]
									+ blackness_area[row_no][column_no];
							
						}
					}
					blackness_area[row_no][column_no] = blackness_area[row_no][column_no]/15;
					
					if(blackness_area[row_no][column_no]>110){
						brightness[row_no][column_no] = 9;
					}else if(blackness_area[row_no][column_no]<=110&&blackness_area[row_no][column_no]>98){
						brightness[row_no][column_no] = 8;
					}else if(blackness_area[row_no][column_no]<=98&&blackness_area[row_no][column_no]>86){
						brightness[row_no][column_no] = 7;
					}else if(blackness_area[row_no][column_no]<=86&&blackness_area[row_no][column_no]>74){
						brightness[row_no][column_no] = 6;
					}else if(blackness_area[row_no][column_no]<=74&&blackness_area[row_no][column_no]>62){
						brightness[row_no][column_no] = 5;
					}else if(blackness_area[row_no][column_no]<=62&&blackness_area[row_no][column_no]>50){
						brightness[row_no][column_no] = 4;
					}else if(blackness_area[row_no][column_no]<=50&&blackness_area[row_no][column_no]>38){
						brightness[row_no][column_no] = 3;
					}else if(blackness_area[row_no][column_no]<=38&&blackness_area[row_no][column_no]>26){
						brightness[row_no][column_no] = 2;
					}else if(blackness_area[row_no][column_no]<=26&&blackness_area[row_no][column_no]>14){
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
