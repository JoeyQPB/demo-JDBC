package db;

public class DbIntegrity extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DbIntegrity(String msg) {
		super(msg);
	}

}
