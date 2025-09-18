package model;

import java.sql.*;
import java.util.*;

public class DBImplementation implements ModelDAO {
	// Prepare statement variables
	private Connection con;
	private PreparedStatement stmt;

	// Prepare SQL Connection variables (with a supressed warning, as it's kind of annoying to see)
	private ResourceBundle configFile;
	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

}
