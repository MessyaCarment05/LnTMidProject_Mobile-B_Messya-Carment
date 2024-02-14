package midproject;
import java.util.*;
public class Motorcycle extends Kendaraan {

	private int helm;
	Scanner sc = new Scanner(System.in);
	public Motorcycle(String brand, String name, String license, int topSpeed, int gas, int wheel, String type, int helm) {
		super(brand, name, license, topSpeed, gas, wheel, type);
		this.helm=helm;
	}
	
	public int getHelm() {
		return helm;
	}

	public void setHelm(int helm) {
		this.helm = helm;
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
		System.out.println("Helm : " + getHelm());
		System.out.println(super.getName() + " is standing!");
		int price;
		System.out.print("Input helm price : ");
		price=sc.nextInt();
		sc.nextLine();
		System.out.println("Price : " + price);

	}

}
