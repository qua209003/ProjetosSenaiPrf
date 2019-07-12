<?php

$nome = "Luiz Felipe";

echo "Teste se o PHP ta ok. $nome info na variavel";

// função do php para fazer a conexão com BD
$conectar = mysqli_connect(
    "localhost","root","","exemplojsf");   
//função para fazer o consulta no BD
$dados = mysqli_query($conectar,
                      "select * from cliente");

while($cliente = mysqli_fetch_array($dados)):

echo "$cliente[nome] - $cliente[email] - $cliente[senha] <a href='formulario.php?editar=$cliente[cod]' >editar</a><br>";

endwhile;
?>
<br>
<br>
<a href="formulario.php">Formulario</a>
