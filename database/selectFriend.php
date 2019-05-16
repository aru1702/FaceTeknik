<?php 

 /*
 
 penulis:	Muhammad Irsyad Thoyib
 proyek:	FaceTeknik
 
 */

	//Import File Koneksi Database
	require_once('connection.php');
	
	//Membuat SQL Query
	$sql = "SELECT idUser, userName, bio FROM friendlist INNER JOIN user ON friendlist.idUser = user.id;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan data kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"idUser"=>$row['idUser'],
			"userName"=>$row['userName'],
			"bio"=>$row['bio']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>