package examen.controll;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/buscar")
public class controll {
	
	public int[] generador() {
		int[] numeros = {};
		for(int i = 0; i <= 5; i++) {
			Random random = new Random();
			numeros[i] = random.nextInt();
		}
		return numeros;
	}
	
	@GetMapping
	public String service(@RequestParam int identificador) {
		int[] list = generador();
		boolean bandera = false;
		for(int i = 0; i <= list.length; i++) {
			if(list[i] == identificador) {
				bandera = true;
			}
		}
		if(bandera == true) {
			return "El identificar existe dentro de la lista";
		}
		else {
			return "El identificador no existe dentro de la lista";
		}
	}
}
