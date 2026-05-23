package com.example.scrrenmatch.ScreenMatch;

import com.example.scrrenmatch.ScreenMatch.pratica.PraticaStream;
import com.example.scrrenmatch.ScreenMatch.principal.Principal;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication {

	public static void main(String[] args) {
		Principal principal = new Principal();
		// principal.exibeMenu();
		PraticaStream praticaStream = new PraticaStream();
		praticaStream.listarPares();
		praticaStream.converteMaiuscula();
		praticaStream.multiplaImpares();
		praticaStream.removeDuplicata();
		praticaStream.extraiPrimo();
		praticaStream.extraiProduto();
	}


}
