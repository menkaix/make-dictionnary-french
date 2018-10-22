package makeDictionnary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.StringTokenizer;
import java.util.WeakHashMap;

/***
 * Source files downloaded from here : http://www.gwicks.net/dictionaries.htm
 * @author mendrika
 *
 */


public class DictionnaryMaker {
	
	

	public static void main(String[] args) {
		
		
		try {
			
			BufferedReader reader =  new BufferedReader(new FileReader("liste_mots_mix.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("liste_mots_mix2.txt",true));
			writer.write("[\n");
			
			WeakHashMap<String, String> dic = new WeakHashMap<>();
			
			String strSource ;
						
			do {
				strSource = reader.readLine();;
				System.out.println(">" + strSource);
				
				if(strSource != null) {					
					
					String strNormalized = Normalizer.normalize(strSource, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
					strNormalized = strNormalized.trim();
					StringTokenizer stk = new StringTokenizer(strNormalized, " '");
					if(stk.countTokens()>=1) {
						strNormalized = stk.nextToken() ; //the first Token
					}
										
					if(strNormalized.length()>=2 && strNormalized.length()<=7 && !dic.containsKey(strNormalized)) {									
						
						dic.put(strNormalized, ""); //avoid doubles
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
