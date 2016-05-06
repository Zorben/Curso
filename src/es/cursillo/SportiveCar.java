package es.cursillo;

import java.sql.SQLException;

public class SportiveCar implements Vehicle {

	@Override
	public void addGearBox(GearBox gearBox) throws SQLException {
		SQLException sqlException = new SQLException();
		throw sqlException;
	}

}
