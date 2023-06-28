package com.example.BIRZAS6.controller;
import com.example.BIRZAS6.DTO.CuentaDTO;
import com.example.BIRZAS6.entity.Cuenta;
import com.example.BIRZAS6.service.CuentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller	
@CrossOrigin
@RequestMapping(path="/cuenta")
public class CuentaController {

    @Autowired
	private CuentaService cuentaService;

    //READ ALL
    @GetMapping
	public ResponseEntity <?> readAll(){
		List<Cuenta> cuentas=cuentaService.findAll();
		List<CuentaDTO> cuentasDTO=new ArrayList<>();
		for(Cuenta cuenta: cuentas) {
			CuentaDTO cuentaDTO=new CuentaDTO(cuenta.getCodcue(),
                                              cuenta.getDescue(),
                                              cuenta.getTitcue(),
                                              cuenta.getBanco().getCodban(),
					                          cuenta.getBanco().getNomban(),
                                              cuenta.getMoneda().getCodmon(),
                                              cuenta.getMoneda().getNommon());
			cuentasDTO.add(cuentaDTO);
		}
		//Collections.sort(cuentasDTO, Comparator.comparing(CuentaDTO::getTitcue)); // ORDENAMOS POR TITCUE
		// Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", cuentasDTO);
        return ResponseEntity.ok().body(cuentasDTO);//(respuesta)	
	}
    // READ BY ID
    @GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Cuenta> cuentaOptional = cuentaService.findById(id);
		if(!cuentaOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		CuentaDTO cuentaDTO=new CuentaDTO(cuentaOptional.get().getCodcue(),
                                          cuentaOptional.get().getDescue(),
				                          cuentaOptional.get().getTitcue(),
                                          cuentaOptional.get().getBanco().getCodban(),
				                          cuentaOptional.get().getBanco().getNomban(),
                                          cuentaOptional.get().getMoneda().getCodmon(),
                                          cuentaOptional.get().getMoneda().getNommon());
		// Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", cuentaDTO);
		return ResponseEntity.ok().body(cuentaDTO); //(respuesta)
	}
    // CREATE
    @PostMapping
	public ResponseEntity<?> create(@RequestBody Cuenta cuenta){
		cuentaService.save(cuenta);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}

    /* este es el json para el post para CREATE incluyendo las propiedades que deseo añadir en este caso los codigos
    {
        "descue": "CUENTA DOLARES",
        "titcue": "Anny Monroe",
        "banco": {
            "codban": 3
        },
        "moneda": {
            "codmon": 2
        }
    }
    */
    // UPDATE
    @PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cuenta cuenta,@PathVariable Integer id){
		Optional<Cuenta> cuentaOptional= cuentaService.findById(id);
		if(!cuentaOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cuenta.setCodcue(id);
		cuentaService.save(cuenta);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}

    /*
    {
        "codcue": 3,
        "descue": "CUENTA DOLARES 2",
        "titcue": "Anny Monroe 2",
        "banco": {
            "codban": 1
        },
        "moneda": {
            "codmon": 1
        }
    }
     */

    // DELETE
    @DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Cuenta> cuentaOptional= cuentaService.findById(id);
		if(!cuentaOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cuentaService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);	
	}
}