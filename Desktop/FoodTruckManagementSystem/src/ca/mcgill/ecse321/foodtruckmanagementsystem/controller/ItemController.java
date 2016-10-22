package ca.mcgill.ecse321.foodtruckmanagementsystem.controller;

import ca.mcgill.ecse321.foodtruckmanagementsystem.model.Equipment;
import ca.mcgill.ecse321.foodtruckmanagementsystem.model.Manager;
import ca.mcgill.ecse321.foodtruckmanagementsystem.model.Supply;
import ca.mcgill.ecse321.foodtruckmanagementsystem.persistence.PersistenceXStream;

public class ItemController {

	public ItemController (){
	}
		
	public void createEquipment(String name, int quantity) throws InvalidInputException{
		String error = "";	
		if ((name == null || name.trim().length() == 0))
			error = error + "Equipment name cannot be empty! ";
		if(quantity == 0)
			error = error + "Equipment quantity cannot be empty or zero! ";
		if (quantity < 0)
			error = error + "Equipment quantity cannot be negative!";
		
		error = error.trim();
		if(error.length() > 0)
			throw new InvalidInputException(error);
		
		
			name = name.toLowerCase();			
			
			boolean isUpdated = false;
			
			Manager m = Manager.getInstance();
	
			for(Equipment equipment : m.getEquipments())
			{
				if(name.equals(equipment.getName()))
				{
					isUpdated = true;
					equipment.setQuantity(equipment.getQuantity() + quantity);
					break;
				}
			}			
			if(!isUpdated)
			{
				m.addEquipment(new Equipment(name, quantity));
			}			
			
			PersistenceXStream.saveToXMLwithXStream(m);
		}
	
	public void removeEquipment(String name, int quantity) throws InvalidInputException{
		String error = "";
		if ((name == null || name.trim().length() == 0))
			error = error + "Equipment name cannot be empty! ";
		if(quantity == 0)
			error = error + "Equipment quantity cannot be empty or zero! ";
		if (quantity < 0)
			error = error + "Equipment quantity cannot be negative!";
		
		error = error.trim();
		if(error.length() > 0)
			throw new InvalidInputException(error);
				
			name = name.toLowerCase();
			
			Manager m = Manager.getInstance();
			
			for(Equipment equipment : m.getEquipments()){
				if(name.equals(equipment.getName())){
					//isUpdated = true;
					if(equipment.getQuantity() - quantity > 0){
						equipment.setQuantity(equipment.getQuantity() - quantity);
					}
					else if (equipment.getQuantity() - quantity < 0){
						error = error + "Cannot remove more than " + equipment.getQuantity() + " " + equipment.getName().toString() + "'s";
					}
					else{
						equipment.delete();
					}
				}
				else{
					//error = error + "Equipment name not found!";
				}
			}
		
		
	}
	
	public void createSupply(String name, int quantity, String unit) throws InvalidInputException{
		String error = "";
		if ((name == null || name.trim().length() == 0)) 
			error = error + "Supply name cannot be empty! ";
		if (quantity == 0)
			error = error + "Supply quantity cannot be empty or zero! ";
		if (quantity < 0) 
			error = error + "Supply quantity cannot be negative! ";
		if ((unit == null || unit.trim().length() == 0))
			error = error + "Supply unit cannot be empty!";
		
		error = error.trim();
		if(error.length() > 0)
			throw new InvalidInputException(error);
		
			name = name.toLowerCase();
			unit = unit.toLowerCase();
			
			boolean isUpdated = false;
			
			Manager m = Manager.getInstance();
	
			for(Supply supply : m.getSupplies())
			{
				if(name.equals(supply.getName()))
				{
					isUpdated = true;
					supply.setQuantity(supply.getQuantity() + quantity);
					break;
				}
			}			
			if(!isUpdated)
			{
				m.addSupply(new Supply(name, quantity, unit));
			}			
			
		PersistenceXStream.saveToXMLwithXStream(m);
	}
	
	public void removeSupply(String name, int quantity) throws InvalidInputException{
		String error ="";
		if ((name == null || name.trim().length() == 0))
			error = error + "Supply name cannot be empty!";
		if(quantity == 0)
			error = error + "Supply quantity cannot be empty or zero!";
		if(quantity < 0)
			error = error + "Supply quantity cannot be a negative!";
		
		error = error.trim();
		if(error.length() > 0)
			throw new InvalidInputException(error);
		
			name = name.toLowerCase();
			
			Manager m = Manager.getInstance();
			
			for(Supply supply : m.getSupplies()){
				if(name.equals(supply.getName())){
					if(supply.getQuantity() - quantity > 0){
						supply.setQuantity(supply.getQuantity() - quantity);
					}
					else if (supply.getQuantity() - quantity < 0){
						error = error + "Cannot remove more than " + supply.getQuantity() + " " + supply.getName().toString() + "'s";
					}
					else{
						//Will delete the given
						supply.delete();
					}
				}
				else{
					//error = error + "Supply name not found!";
				}
			}
		
	}
	
}
