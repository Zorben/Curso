package es.cursillo;

import java.sql.SQLException;

public class VehicleBuilder {

	public static void main(String[] args) throws SQLException {
		Vehicle vehicle = new SportiveCar();
		GearBox box = new CumtomGearBox();
		VehicleBuilder vehicleBuilder = new VehicleBuilder();
		vehicleBuilder.buildMotorCar(vehicle, box);
	}

	public void buildMotorCar(Vehicle vehicle, GearBox box) throws SQLException {
		box.gearNuetral();
		box.gearUp();
		box.gearDown();
		box.gearNuetral();
		vehicle.addGearBox(box);
	}

}
