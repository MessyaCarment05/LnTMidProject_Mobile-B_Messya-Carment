package midproject;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainMenu {
	ArrayList<Kendaraan> kendaraan = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public MainMenu()
	{
		int stay=0;
		int input;
		while (stay==0)
		{
			System.out.println("ChipiChapa");
			System.out.println("1. Input Kendaraan");
			System.out.println("2. View Kendaraan");
			System.out.println("3. Exit");
			System.out.print(">> ");
			input=sc.nextInt();
			sc.nextLine();
			if(input==1)
			{
				inputKendaraan();
				System.out.println("ENTER to return");
				sc.nextLine();
			}
			else if (input==2)
			{
				viewKendaraan();
				System.out.println("ENTER to return");
				sc.nextLine();
			}
			else if (input==3)
			{
				System.out.println("Thank you !!");
				stay=1;
			}
			else
			{
				continue;
			}
		}
	}
	private void inputKendaraan()
	{
		String typeKendaraan;
		String brand;
		String name;
		String license;
		int speed;
		int gas;
		int wheel;
		String type;
		int entertainment;
		int helm;
		System.out.print("Input type [Car | Motorcycle]: ");
		typeKendaraan=sc.nextLine();
		while(!typeKendaraan.equals("Car") && !typeKendaraan.equals("Motorcycle"))
		{
			System.out.print("Input type [Car | Motorcycle]: ");
			typeKendaraan=sc.nextLine();
		}
		System.out.print("Input brand [>= 5] : ");
		brand=sc.nextLine();
		while(brand.length()<5)
		{
			System.out.print("Input brand [>= 5] : ");
			brand=sc.nextLine();
		}
		System.out.print("Input name [>= 5] : ");
		name=sc.nextLine();
		while(name.length()<5)
		{
			System.out.print("Input name [>= 5] : ");
			name=sc.nextLine();
		}
		System.out.print("Input license: ");
		license=sc.nextLine();
		while(checkLicense(license)==false)
		{
			System.out.print("Input license: ");
			license=sc.nextLine();
		}
		System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
		speed=sc.nextInt();
		while(speed<100 || speed>250)
		{
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			speed=sc.nextInt();
		}
		sc.nextLine();
		System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
		gas=sc.nextInt();
		while(gas<30|| gas>60)
		{
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
			gas=sc.nextInt();
		}
		sc.nextLine();
		if(typeKendaraan.equals("Car"))
		{
			System.out.print("Input [4 <= wheel <= 6] : ");
			wheel=sc.nextInt();
			while(wheel<4 || wheel>6)
			{
				System.out.print("Input [4 <= wheel <= 6] : ");
				wheel=sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Input type [SUV | Supercar | Minivan] : ");
			type=sc.nextLine();
			while(!type.equals("SUV") &&!type.equals("Supercar") &&!type.equals("Minivan"))
			{
				System.out.print("Input type [SUV | Supercar | Minivan] : ");
				type=sc.nextLine();
			}
			System.out.print("Input entertainment system amount[>= 1] : ");
			entertainment=sc.nextInt();
			while(entertainment<1)
			{
				System.out.print("Input entertainment system amount[>= 1] : ");
				entertainment=sc.nextInt();
			}
			sc.nextLine();
			kendaraan.add(new Car(brand, name, license, speed, gas, wheel, type, entertainment));
		}
		else if (typeKendaraan.equals("Motorcycle"))
		{
			System.out.print("Input [2 <= wheel <= 3] : ");
			wheel=sc.nextInt();
			while(wheel<2 || wheel>3)
			{
				System.out.print("Input [2 <= wheel <= 3] : ");
				wheel=sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Input type [Automatic | Manual] : ");
			type=sc.nextLine();
			while(!type.equals("Automatic") &&!type.equals("Manual"))
			{
				System.out.print("Input type [Automatic | Manual] : ");
				type=sc.nextLine();
			}
			System.out.print("Input helm amount[>= 1] : ");
			helm=sc.nextInt();
			while(helm<1)
			{
				System.out.print("Input helm amount[>= 1] : ");
				helm=sc.nextInt();
			}
			sc.nextLine();
			kendaraan.add(new Motorcycle(brand, name, license, speed, gas, wheel, type, helm));
		}
		
	}
	private boolean checkLicense(String licenseNumber)
	{
		String license="^[A-Z]{1}[ ]{1}[0-9]{1,4}[ ]{1}[A-Z]{1,3}$";
		Pattern pattern=Pattern.compile(license);
		Matcher matcher=pattern.matcher(licenseNumber);
		return matcher.matches();
	}
	private void viewKendaraan()
	{
		System.out.println("===========================================");
		System.out.println(String.format("| %-3s | %-10s | %-20s |", "No", "Type", "Name"));
		System.out.println("===========================================");
																	 
		for (int i=0; i<kendaraan.size(); i++)
		{
			System.out.printf("| %-3d | %-10s | %-20s |\n", i+1, kendaraan.get(i).getType(), kendaraan.get(i).getName());
			System.out.println("===========================================");
		}
		if (kendaraan.size()==0)
		{
			System.out.println("===========================================");
			return;
		}
		int input;		
		System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]: ");
		input=sc.nextInt();
		if (input==0)
		{
			return;
		}
		while (input>kendaraan.size())
		{
			System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]: ");
			input=sc.nextInt();
		}
		sc.nextLine();
		kendaraan.get(input-1).viewDetail();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainMenu();
	}

}
