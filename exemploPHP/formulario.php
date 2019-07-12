<html>

<head></head>
    <?php
    $cod = "";
    $nome = "";
    $email = "";
    $senha = "";
    
    
    
    if(isset($_GET['editar'])){
        $cod = $_GET['editar'];
        $conectar = mysqli_connect(
    "localhost","root","","exemplojsf");   
$dados = mysqli_query($conectar,
        "select * from cliente where cod = $cod");
$cliente = mysqli_fetch_array($dados);
        
        $cod = $cliente['cod'];
        $nome = $cliente['nome'];
        $email = $cliente['email'];
        $senha = $cliente['senha'];
    }
    
    ?>
    
    
    <body>    
        <form method="post" >
<input type="hidden" name="cod" 
       value="<?php echo $cod;?>">
        Nome:<input type="text" name="nome"
        value="<?php echo $nome;?>"><br>
        Email:<input type="text" name="email"
        value="<?php echo $email;?>"><br>
        Senha:<input type="password" name="senha"
        value="<?php echo $senha;?>"
                     ><br>        
            <input type="submit" value="Gravar">
            <br><br>
            <a href="index.php">Lista de cliente</a>
        </form>
    </body>
</html>
<?php

if(isset($_POST['nome'])){
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];
    
    $conectar = mysqli_connect(
    "localhost","root","","exemplojsf");   
    
    if($_POST['cod'] == ""){
    
        $sql = "insert into cliente (nome,email,senha) 
        values('$nome','$email','$senha')";
        
    }else{        
        $sql = "update cliente set 
        nome = '$nome',
        email = '$email',
        senha = '$senha'
        where cod = $cod        
        ";  
    }
    
    $conectar->query($sql);
}
    

?>