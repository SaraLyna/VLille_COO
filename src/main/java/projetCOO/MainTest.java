package projetCOO;

import java.io.IOException;

import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.util.Input;
import projetCOO.vlille.Vlille;

public class MainTest {

	public static void main(String[] args) {
		try {
			System.out.print("How many Stations ? ");
			int nbStation = Input.readInt();
			Vlille vlille = new Vlille(new ControlCenter(nbStation));
			vlille.run();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OutOfLimit e) {
			e.printStackTrace();
		}
	}
		

}
