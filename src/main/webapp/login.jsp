<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Control de combustible | Login</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <style>
      :root {
        --input-padding-x: .75rem;
        --input-padding-y: .75rem;
      }

      html,
      body {
        height: 100%;
      }

      body {
        display: -ms-flexbox;
        display: -webkit-box;
        display: flex;
        -ms-flex-align: center;
        -ms-flex-pack: center;
        -webkit-box-align: center;
        align-items: center;
        -webkit-box-pack: center;
        justify-content: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        width: 100%;
        max-width: 420px;
        padding: 15px;
        margin: 0 auto;
      }
    </style>
</head>

<body>
    <form class="form-signin" action="LoginControlador" method="POST" autocomplete="off">
        <div class="text-center mb-4">
            <img class="mb-4" src="img/combustible.svg" alt="" width="" height="100">
            <h1 class="h3 mb-3 font-weight-normal">Controla Combustible</h1>
        </div>

        <div class="form-group">
            <label for="txtUsuario">Usuario</label>
            <input class="form-control" type="text" name="usuario" id="txtUsuario" placeholder="Usuario" required autofocus>
        </div>

        <div class="form-group">
            <label for="txtContrasena">Contraseña</label>
            <input class="form-control" type="password" name="contrasena" id="txtContrasena" placeholder="Contraseña" required>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
    </form>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>