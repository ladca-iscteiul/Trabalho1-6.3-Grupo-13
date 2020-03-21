package pt.iscte.lei.es2.Trabalho1_6._Grupo_13;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
		
		private final static int PRIVATE_KEY_FOR_NUM_KEYS = 240; //1 to 255
		private final static int PRIVATE_KEY_FOR_KEYS = 69; //1 to 255
		
		
		public static void main(String[] args) {
			
			String input = args[0];
			
			byte[] bytes_input = input.getBytes();
			int size = bytes_input.length; 
			
			int bytes_per_key = ((byte)(bytes_input[0] - PRIVATE_KEY_FOR_NUM_KEYS));
			byte[] bytes_output = new byte[(bytes_per_key + size/(bytes_per_key + 1)) - 1];
			
			int current_key=0;
			int aux = bytes_per_key;
			int aux_index = 1;
			for(int i=1; i < size; i++) {
				
				if( aux == bytes_per_key) {
					current_key = (byte) (bytes_input[i] - PRIVATE_KEY_FOR_KEYS);
					aux = 0;
					aux_index++;
					continue;
				}
				bytes_output[i - aux_index] = (byte) (bytes_input[i] - current_key);
				aux++;
				
			}
			
			System.out.println(new String(bytes_output));
		}

}
