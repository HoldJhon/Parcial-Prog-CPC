<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style/css.css" type="text/css">
        <title>Parcial Jhon Molano</title>
    </head>
    <body>
        <form action="Control" method="post">
            <div class="principal">
                <h2>Registro</h2>
                <h4>Ingresa los datos</h4>
                <input type="text" name="txt_nombres" placeholder="Nombre" required>
                <input type="text" name="txt_telefono" placeholder="Telefono" required>
                <input type="email" name="txt_correo" placeholder="Correo" required>
                <input type="password" name="txt_contrasena" placeholder="Contraseña" required>
                <button type="submit" name="btnRegistrar" value="Registrar">Registrar</button>
            </div>
        </form>
    </body>
</html>