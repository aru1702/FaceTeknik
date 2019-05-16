<?php

 /*
	add user
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$email = $_POST['email'];
		$password = $_POST['password'];
		
		//Pembuatan Syntax SQL
		$sql = "SELECT email, password FROM user WHERE email = $email and password = $password)";
		
		//Import File Koneksi database
		require_once('connection.php');
		
		//Mendapatkan Hasil
		$r = mysqli_query($con,$sql);
		
		//Membuat Array Kosong 
		$result = array();
		
		while($row = mysqli_fetch_array($r)){
			
			//Memasukkan data kedalam Array Kosong yang telah dibuat 
			array_push($result,array(
				"email"=>$row['email'],
				"password"=>$row['password']
			));
		}
		
		//Menampilkan Array dalam Format JSON
		echo json_encode(array('result'=>$result));
		
		mysqli_close($con);
	}
?>