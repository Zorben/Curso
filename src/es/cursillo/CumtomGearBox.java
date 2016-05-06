package es.cursillo;

public class CumtomGearBox implements GearBox {

	@Override
	public void gearUp() {
		System.out.println("subiendo marcha");
	}

	@Override
	public void gearDown() {
		System.out.println("bajando marcha");
	}

	@Override
	public void gearNuetral() {
		System.out.println("punto muerto");
	}

}
