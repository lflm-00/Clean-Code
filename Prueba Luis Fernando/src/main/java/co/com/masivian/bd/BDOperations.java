package co.com.masivian.bd;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import lombok.Data;

@Data
public class BDOperations implements Serializable{

	private PreparedStatement statement;
	
	
}
