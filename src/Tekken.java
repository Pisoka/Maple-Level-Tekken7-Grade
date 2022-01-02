import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import java.util.StringTokenizer;



public class Tekken {
	
	public static void main(String[] args) throws IOException {
		
		
		float level = 238				;
		float exp= (float) 70.561					;
		
		
		
		
		
		
		
		
		Scanner s = new Scanner(new File("text.txt"));
		
		int index = 0;
		float a[][] = new float[50][3];
		
		while (s.hasNext()) {
			String Line = s.nextLine();
			StringTokenizer st = new StringTokenizer(Line);
			
			a[index][0] = Float.parseFloat(st.nextToken());
			a[index][1] = Float.parseFloat(st.nextToken());
			a[index][2] = Float.parseFloat(st.nextToken());
			
			index++;
			
			
			
			}
		
		
		
		//Scanner s2 = new Scanner(System.in);
		//float level = s2.nextFloat();
		//float exp = s2.nextFloat();
		exp *= 0.01;
		
		
		//int find_index = Arrays.asList(a).indexOf(level);
		int find_index = (int)level - 200;
		
		float percent = (a[find_index-1][2]+a[find_index][1]*exp) /a[49][2] *100;
		//System.out.println(percent);
		
		Scanner s3 = new Scanner(new File("text2.txt"));
		float score[] = new float[34];
		float score2[] = new float[34];
		float total = 0;
		index =0;
		while (s3.hasNext()) {
			
			score[index] = Float.parseFloat(s3.nextLine());
			
			total = total + score[index];
			score2[index] = total;
			index++;
			}

		float grade_score = (float) (percent* 0.01 * total);
		index =0;
		float result_percent =0;
		while(true)
		{
			
			
			if(grade_score >= score2[index] && grade_score < score2[index+1] )
			{
				result_percent = (grade_score - score2[index]) / (score2[index+1] -score2[index])*100;
				
				Image image = null;
		        try {
		        	File sourceimage = new File(index + ".png");
					image = ImageIO.read(sourceimage);
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        
		        JFrame frame = new JFrame();
		        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		        frame.setSize(300, 300);
		        frame.setLocation(1600,700);
		        JLabel label = new JLabel(new ImageIcon(image));
		        frame.add(label);
		        frame.setVisible(true);

		        // 250~ 400 구간에서 300값이 있다 
		        // 최소값을 다 빼주면  0~ 50  ~150 
		        // 33.33%  150
				/*
				File sourceimage = new File(index + ".png");
				Image image = ImageIO.read(sourceimage);
				System.out.println(index);
				
				*/
		        
		        break;
			}
			
			else
				index++;
		}
		
		System.out.printf("%.1f", result_percent); //240 44.44 26.2
		//   점수 / total = percent   
		//  점수 = percent * total 
		//System.exit(0);
	}

}
