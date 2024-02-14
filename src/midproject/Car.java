package midproject;

public class Car extends Kendaraan {
	private int entertainment;
	
	

	


	public Car(String brand, String name, String license, int topSpeed, int gas, int wheel, String type, int entertainment) {
		super(brand, name, license, topSpeed, gas, wheel, type);
		this.entertainment=entertainment;
	}



	public int getEntertainment() {
		return entertainment;
	}



	public void setEntertainment(int entertainment) {
		this.entertainment = entertainment;
	}



	@Override
	public void viewDetail() {
		// TODO Auto-generated method stub
		System.out.println("Brand : " + super.getBrand());
		System.out.println("Name : " + super.getName());
		System.out.println("License Plate: " +super.getLicense());
		System.out.println("Type : " +super.getType());
		System.out.println("Gas Capacity : " + super.getGas());
		System.out.println("Top Speed : " + super.getTopSpeed());
		System.out.println("Wheel(s) : " + super.getWheel());
		System.out.println("Entertainment System : " + getEntertainment());
		System.out.println("Turning on entertainment system...");
		if (super.getType().equals("Supercar"))
		{
			System.out.println("Boosting!");
		}
			

	}

}
