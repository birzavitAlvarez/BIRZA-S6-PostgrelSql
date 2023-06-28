package com.example.BIRZAS6.controller;
import com.example.BIRZAS6.DTO.MonedaDTO;
import com.example.BIRZAS6.entity.Moneda;
import com.example.BIRZAS6.service.MonedaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller	
@CrossOrigin
@RequestMapping(path="/moneda")
public class MonedaController {

    @Autowired
	private MonedaService monedaService;

	// READ ALL
	@GetMapping
	public ResponseEntity<?> readAll(){
		List<Moneda> monedas =monedaService.findAll();
		List<MonedaDTO> monedasDTO=new ArrayList<>();
		for(Moneda moneda: monedas) {
			MonedaDTO monedaDTO=new MonedaDTO (moneda.getCodmon(),moneda.getNommon());
			monedasDTO.add(monedaDTO);
		}
		// Map<String,Object> respuesta=new HashMap<>();
		// respuesta.put("status",200);
		// respuesta.put("data", monedasDTO);
		return ResponseEntity.ok(monedasDTO);//(respuesta)
	}
	// READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id) {
		Optional<Moneda> monedaOptional=monedaService.findById(id);
		if(!monedaOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		MonedaDTO monedaDTO = new MonedaDTO(monedaOptional.get().getCodmon(), monedaOptional.get().getNommon());
		// Map<String, Object> respuesta = new HashMap<>();
		// respuesta.put("status", 200);
		// respuesta.put("data", monedaDTO);
		return ResponseEntity.ok(monedaDTO); //(respuesta)
	}
	// CREATE
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Moneda moneda){
		monedaService.save(moneda);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
	}
	// UPDATE BY ID
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Moneda moneda,@PathVariable Integer id){
		Optional<Moneda> monedaOptional= monedaService.findById(id);
		if(!monedaOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		moneda.setCodmon(id);
		monedaService.save(moneda);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
	}
	// DELETE BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Moneda> monedaOptional= monedaService.findById(id);
		if(!monedaOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		monedaService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);		
	} 
}