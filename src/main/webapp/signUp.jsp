<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style/css.css" type="text/css">
        <title>Registro</title>
    </head>
    <body>
        <form action="Control" method="post">
            <div class="principal">
                <h2>Registro</h2>
                <h4>Ingresa los datos</h4>
                <input type="text" placeholder="Nombre" name="txt_nombres" required>
                <input type="text" placeholder="Telefono" name="txt_telefono" required>
                <input type="email" placeholder="Correo" name="txt_correo" required>
                <input type="password" placeholder="Contraseña" name="txt_contrasena" required>
                <button type="submit" value="SignUp" name="btnSignUp">Registrar</button>
            </div>
        </form>
    </body>
</html>
