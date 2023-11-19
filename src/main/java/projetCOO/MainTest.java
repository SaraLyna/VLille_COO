package projetCOO;

import java.io.IOException;

import projetCOO.Exception.OutOfLimit;
import projetCOO.control.ControlCenter;
import projetCOO.planning.Planning;
import projetCOO.util.Input;
import projetCOO.vlille.Vlille;

public class MainTest {

	public static void main(String[] args) {
		try {
			System.out.print("How many Stations ? ");
			int nbStation = Input.readInt();
			
			ControlCenter controlCenter = new ControlCenter(nbStation);
            Planning planning = new Planning();
            
            
			Vlille vlille = new Vlille(controlCenter);
			vlille.run();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OutOfLimit e) {
			e.printStackTrace();
		}
	}
		

}
