<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Persona</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

</head>
<body>
<form:form action="registrar" method="post" >
    <div class="form-group">
        <fieldset>
            <div>
                <label for="id">Tarea ID</label>
                <form:input path="id" type="text" class="form-control"
                            readonly="true"
                            placeholder="Tarea ID" />
            </div>
            <div>
                <label for="autor">Autor</label>
                <form:input path="autor" type="text" class="form-control"
                            placeholder="Autor" />
            </div>
            <div>
                <label for="inicio">Inicio</label>
                <form:input path="inicio" type="text" class="form-control"
                            placeholder="Inicio" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <form:input path="descripcion" type="text" class="form-control"
                            placeholder="Descripcion" />
            </div>

            <div>
                <input type="submit" class="btn-primary" value="Aceptar" />
            </div>
        </fieldset>
    </div>
</form:form>
</body>
</html>