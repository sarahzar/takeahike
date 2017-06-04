<?php
$target_dir = "img/";
if (is_uploaded_file($_FILES['my_file']['tmp_name'])) {
 	$temp = explode(".", $_FILES["my_file"]["name"]);
	$newfilename = round(microtime(true)) . '.' . end($temp);
	$target_file = $target_dir . $newfilename;
	echo $newfilename;
	move_uploaded_file($_FILES["my_file"]["tmp_name"], $target_file);
  	//move_uploaded_file ($_FILES['my_file']['tmp_name'], $_FILES['my_file']['name']);
} else {
  echo "Upload failed!!";
  //echo "filename '". $_FILES['my_file']['tmp_name'] . "'.";
  //print_r($_FILES);
}
?>