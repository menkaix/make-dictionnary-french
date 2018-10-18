package makeDictionnary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;

/***
 * Source files downloaded from here : http://www.gwicks.net/dictionaries.htm
 * @author mendrika
 *
 */


public class DictionnaryMaker {
	
	

	public static void main(String[] args) {
		
		
		try {
			
			BufferedReader reader =  new BufferedReader(new FileReader("francais.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("francais2.txt",true));
			writer.write("[\n");
			String strSource ;
			do {
				strSource = reader.readLine();;
				System.out.println(">" + strSource);
				
				if(strSource != null) {					
					
					String strNormalized = Normalizer.normalize(strSource, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
					
					if(strNormalized.length()>=3 && strNormalized.length()<=7) {									
						
						writer.write("'"+strNormalized+"',");
					}
				}
				
				
			}while (strSource != null);
			
			
			writer.write("]\n");	
			
			reader.close();
			writer.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
