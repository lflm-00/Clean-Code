package co.com.masivian.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.com.masivian.bd.BDOperations;
import co.com.masivian.dto.BetDTO;
import co.com.masivian.entity.Roulette;


@Service
@Transactional
public class BetsController {
	
	private final Logger log = LoggerFactory.getLogger(BetsController.class);

	BDOperations operacionesBD = new BDOperations();
	
	public Roulette createRoulette (Roulette roulette){
		Connection conexion = null;
		
		return roulette;
	}
	
	public boolean rouletteOpening (Long idRoulette) {
		return true;
	}
	
	public BetDTO BetsNumber(BetDTO betDTO) {
		return betDTO;
	}
	
	public Roulette rouletteClosing (Roulette roulette) {
		return roulette;
	}
	
	public List<Roulette> rouletteList(){
		List<Roulette> roulette = new ArrayList<Roulette>();
		return roulette;
	}
}
