<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Painel Centro Cirúrgico</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<p>
		<img height="50" width="50"
			src="http://www.df.gov.br/wp-conteudo/uploads/2015/10/Bandeira_do_Distrito_Federal_Brasil.png">
		Hospital Regional de Taguatinga|Secretaria de Estado de Saúde do
		Distrito Federal| Pacientes no Centro Cirúgico DD/MM/YYYY HH:MI
	</p>
	<table class="table table-striped">
		<thead>
			<tr>
				<th width="40%">Nome do Paciente</th>
				<th width="20%">Status</th>
				<th width="10%">Início Previsto</th>
				<th width="10%">Início Cirúrgia</th>
				<th width="10%">Fim Cirúrgia</th>
				<th width="10%">Saída Previsto</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>John</td>
				<td class="table-warning" >Pré-Operatório</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
			</tr>
			<tr>
				<td>Mary</td>
				<td class="table-danger" >Em sala cirúrgica</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
			</tr>
			<tr>
				<td>July</td>
				<td class="table-success" >Em recuperação</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
			</tr>
			<tr>
				<td>Mac</td>
				<td class="table-primary" >Transferido</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
				<td>HH:MI</td>
			</tr>
		</tbody>
	</table>
	
	<%
	Painel p new Painel();
	out.print("Teste de JSP");
	%>
</body>
</html>