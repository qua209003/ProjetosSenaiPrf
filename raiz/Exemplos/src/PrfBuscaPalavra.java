import java.util.Random;

import javax.swing.JOptionPane;


public class PrfBuscaPalavra {

	public static void main(String[] args) {
		
		int qt = Integer.parseInt(
				JOptionPane.showInputDialog(
						"Digite o tamanho do Caça Palavra")
				);
		
		Random random = new Random(); 
		int[][] mtz = new int[qt][qt];

		String palavra = JOptionPane.showInputDialog(
				"Digite a palavra a ser buscada.").toUpperCase();
		// indice da linha  
		int il = random.nextInt(qt);
		// indice da coluna 
		int ic = random.nextInt(qt-palavra.length());
		
		for (int i = 0; i < palavra.length(); i++) {
			mtz[il][ic+i] = (int) palavra.charAt(i);
		}
		
		char ch = 0;
		for (int l = 0; l < qt; l++) {
			for (int c = 0; c < qt; c++) {
				if(mtz[l][c]==0){
					mtz[l][c] = 65+random.nextInt(23);
				}
				System.out.print((char)mtz[l][c]+" ");
			}
			System.out.println();
		}
	}

}
