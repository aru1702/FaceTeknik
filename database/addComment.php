<?php

 /*
	add comment
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$id = $_POST['id'];
		$idPost = $_POST['idPost'];
		$idUser = $_POST['idUser'];
		$comment = $_POST['comment'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO comment (id, idPost, idUser, comment) VALUES ('$id', '$idPost' ,'$idUser' ,'$comment')";
		
		//Import File Koneksi database
		require_once('connection.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Comment';
		}else{
			echo 'Gagal Menambahkan Comment';
		}
		
		mysqli_close($con);
	}
?>