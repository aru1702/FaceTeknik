<?php

 /*
	add notification
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$id = $_POST['id'];
		$idPost = $_POST['idPost'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO notification (id, idPost) VALUES ('$id',' $idPost')";
		
		//Import File Koneksi database
		require_once('connection.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Notification';
		}else{
			echo 'Gagal Menambahkan Notification';
		}
		
		mysqli_close($con);
	}
?>