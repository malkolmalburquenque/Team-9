<?php
require_once 'controller/Controller.php'; 
session_start();

$c = new Controller();
$staffStartTime = array();
$staffEndTime= array();
try {
$staffName = NULL;
if (isset($_POST['staffMemberSpinner'])) {
$staffName= $_POST['staffMemberSpinner'];
}
// Start time and End time for 7 days 

// Monday
if (isset($_POST['start_time1'])){ //start time 
	$staffStartTime[0] = $_POST['start_time1'];
}
if (isset($_POST['end_time1'])){ //end time
	$staffEndTime[0] = $_POST['end_time1'];
}
// Tuesday
if (isset($_POST['start_time2'])){ //start time 
	$staffStartTime[1] = $_POST['start_time2'];
}
if (isset($_POST['end_time2'])){ //end time
	$staffEndTime[1] = $_POST['end_time2'];
}
//	Wednesday
if (isset($_POST['start_time3'])){ //start time 
	$staffStartTime[2] = $_POST['start_time3'];
}
if (isset($_POST['end_time3'])){ //end time
	$staffEndTime[2] = $_POST['end_time3'];
}
// Thurday
if (isset($_POST['start_time4'])){ //start time 
	$staffEndTime[3] = $_POST['start_time4'];
}
if (isset($_POST['end_time4'])){ //end time
	$staffEndTime[3] = $_POST['end_time4'];
}
//	Friday
if (isset($_POST['start_time5'])){ //start time 
	$staffStartTime[4] = $_POST['start_time5'];
}
if (isset($_POST['end_time5'])){ //end time
	$staffEndTime[4] = $_POST['end_time5'];
}

// Saturday
if (isset($_POST['start_time6'])){ //start time 
	$staffStartTime[5] = $_POST['start_time6'];
}
if (isset($_POST['end_time6'])){ //end time
	$staffEndTime[5] = $_POST['end_time6'];
}

// Sunday
if (isset($_POST['start_time7'])){ //start time 
	$staffStartTime[6] = $_POST['start_time7'];
}
if (isset($_POST['end_time7'])){ //end time
	$staffEndTime[6] = $_POST['end_time7'];
}

if (isset($_POST['editStaffSchedule'])) {	
	echo "Monday ".$staffStartTime[0] ;
	echo " Tueday:".$staffStartTime[1];
	// $c->addTimeStaffMember($staffName, $staffStartTime, $staffEndTime);
	// $_SESSION ["successStaff"] = "Successfully save ".$staffName."'s' new weekly schedule!";

	$_SESSION["errorStaff"] = "";
}
elseif (isset($_POST['removeStaff'])) {
	$c->removeStaffMember($staffName);
	$_SESSION ["successStaff"] = "Successfully remove ".$staffName." from staff list!";
}
	
} catch (Exception $e){ 
	$_SESSION["errorStaff"] = $e->getMessage();
}

$_SESSION["errorStaff"] = "";

?>

<!DOCTYPE html> <html>
	<head>
	<meta http-equiv="refresh" content="0; url=/FoodTruckManagementSystem/staffTab.php" />
	</head>
</html>