package tr.edu.medipol.yazilimaraclari.webservis;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciWebServisi {
	
	public record Ogrenci(String adSoyad, String numara) {};
	

	private static final List<Ogrenci> OGRENCI_LISTESI = new ArrayList<>();
	
	
	@GetMapping("/")
	public List<Ogrenci> listele(){
		return OGRENCI_LISTESI;
	}
	
	@GetMapping("/{no}")
	public Ogrenci bul(@PathVariable String no){
		for(Ogrenci ogrenci: OGRENCI_LISTESI) {
			if(ogrenci.numara().equals(no)) {
				return ogrenci;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{no}")
	public boolean sil(@PathVariable String no) {
		Ogrenci ogrenci = bul(no);
		if(ogrenci != null) {
			OGRENCI_LISTESI.remove(ogrenci);
			return true;
		}
		return false;
	}
	
	@PostMapping("/")
	public Ogrenci ekle( @RequestBody Ogrenci ogrenci) {
		OGRENCI_LISTESI.add(ogrenci);
		return ogrenci;
		
	}
}

