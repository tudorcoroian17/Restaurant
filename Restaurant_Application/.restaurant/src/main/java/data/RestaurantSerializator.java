package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import businessLogic.Restaurant;

public class RestaurantSerializator {

	public static void serialize(Restaurant restaurant) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Restaurant.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(restaurant);
			out.close();
			fileOut.close();
			System.out.println("Data was serialized successfully. Check \"Restaurant.ser\".");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Restaurant deserialize() {
		Restaurant restaurant;
		try {
			FileInputStream fileIn = new FileInputStream("Restaurant.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			restaurant = (Restaurant) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Data was deserialized successfully.");
			return restaurant;
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file \"Restaurant.ser\".");
			restaurant = new Restaurant();
			serialize(restaurant);
			e.printStackTrace();
			return restaurant;
		} catch (IOException e) {
			System.out.println("Problem encountered with the input file.");
			restaurant = new Restaurant();
			serialize(restaurant);
			e.printStackTrace();
			return restaurant;
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find class Restaurant.");
			e.printStackTrace();
			return null;
		}
	}
}
