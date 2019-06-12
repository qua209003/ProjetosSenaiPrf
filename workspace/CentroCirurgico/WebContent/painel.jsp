<!DOCTYPE html>
<%@page import="org.senai.cntrCirurgico.modelo.Painel"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Painel Centro Cir�rgico</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<p>
		<img height="50" width="50"
			src="http://www.df.gov.br/wp-conteudo/uploads/2015/10/Bandeira_do_Distrito_Federal_Brasil.png">
		Hospital Regional de Taguatinga|Secretaria de Estado de Sa�de do
		Distrito Federal| Pacientes no Centro Cir�gico DD/MM/YYYY HH:MI
	</p>
	<table class="table table-striped">
		<thead>
			<tr>
				<th width="40%">Nome do Paciente</th>
				<th width="20%">Status</th>
				<th width="10%">In�cio Previsto</th>
				<th width="10%">In�cio Cir�rgia</th>
				<th width="10%">Fim Cir�rgia</th>
				<th width="10%">Sa�da Previsto</th>
			</tr>
		</thead>
		<tbody>
		
		<script>
		
		function prepararEditar(cod){
			//alert("editar "+cod);
			window.location.replace('gerenciarPainel.jsp?cod='+cod);
		}
		
		</script>
		
			<%
				Painel painel = new Painel();
				for (Painel p : painel.getLista()) {
					out.print("<tr onclick='prepararEditar("+p.getCod()+")'>");
					//out.print("<td>" + p.getCod()+"</td>");
					out.print("<td>" + p.getNomeCompleto() + "</td>");
					out.print("<td class='"+p.getCorStatus()+"'>" + p.getStatus() + "</td>");
					out.print("<td>" + p.getIniPrevisto() + "</td>");
					out.print("<td>" + p.getIniCirurgia() + "</td>");
					out.print("<td>" + p.getFimCirurgia() + "</td>");
					out.print("<td>" + p.getSaidaPrevista() + "</td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>


</body>
</html>