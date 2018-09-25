<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<div class="container">

    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr class="info">
                <th>ID</th>
                <th>Autor</th>
                <th>Inicio</th>
                <th>Descripcion</th>

                <th colspan="2">Acción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tareas}" var="tarea">
                <tr class="active">
                    <td><c:out value="${tarea.id}" /></td>
                    <td><c:out value="${tarea.autor}" /></td>
                    <td><c:out value="${tarea.inicio}" /></td>
                    <td><c:out value="${tarea.descripcion}" /></td>
                    <td><a href="irEditar?id=<c:out value="${tarea.id }"/>">Actualizar</a></td>
                    <td><a href="remover?id=<c:out value="${tarea.id }"/>">Eliminar</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br />

    <div class="row">
        <div class="col-sm-1">
            <form method="get" action="irRegistrar">
                <button class="btn btn-primary">Agregar</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>