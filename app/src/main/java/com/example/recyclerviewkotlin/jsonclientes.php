<?php
$server="localhost";
$user="root";
$pass="clave";
$bd="BDFranciscoJMP";

$conexion = mysqli_connect($server, $user, $pass,$bd)
or die("Ha sucedido un error inexperado en la conexion de la base de datos");

$sql = "SELECT * FROM Clientes";
mysqli_set_charset($conexion, "utf8");

if(!$result = mysqli_query($conexion, $sql)) die();

$clientes = array();

while($row = mysqli_fetch_array($result))
{
	$id=$row['id'];
	$nombre=$row['nombre'];
	$apellidos=$row['apellidos'];
	$telefeno=$row['telefono'];
	$clientes[] = array('id'=>$id,'nombre'=>$nombre,'apellidos'=>$apellidos,'telefono'=>$telefono);

}
$close = mysqli_close($conexion) or die("Ha sucedido un error inexperado en la desconexion de la base de datos");

$json_string = json_encode($clientes);

echo $json_string;




?>