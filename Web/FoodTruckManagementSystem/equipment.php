<?php
require_once 'controller/Controller.php';

session_start();

$c = new Controller();
try{
	
	if (isset($_POST['equipment_name'])){
		$equipmentName = $_POST['equipment_name'];
	}
	if (isset($_POST['equipment_quantity'])){
		$equipmentQuantity = $_POST['equipment_quantity'];
	}

	if (isset($_POST['addEquipment'])) {
		$c->createEquipment($equipmentName, $equipmentQuantity);
	}
	elseif (isset($_POST['removeEquipment'])){
		$c->removeEquipment($equipmentName, $equipmentQuantity);
	}
	$_SESSION["errorEquipment"] = "";
	
} catch (Exception $e){
	$_SESSION["errorEquipment"] = $e->getMessage();
}
?>

<!DOCTYPE html> <html>
	<head>
	<meta http-equiv="refresh" content="0; url=/FoodTruckManagementSystem/inventoryTab.php" />
	</head>
</html>
