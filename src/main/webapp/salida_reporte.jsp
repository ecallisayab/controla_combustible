<%@page import="com.emergentes.utilidades.SesionUsuario"%>
<%
SesionUsuario userSesion = (SesionUsuario) session.getAttribute("controla_combustible");
if(userSesion == null) {
    response.sendRedirect("LoginControlador");
}
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Control de Combustible | Salidas</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
     <style>
        thead {
            background-color: #5c7ad6;
            color: white;
        }
    </style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="META-INF/componentes/menu.jsp">
            <jsp:param name="opcion" value="salida"/>
        </jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="META-INF/componentes/cabecera.jsp">
                    <jsp:param name="" value=""/>
                </jsp:include>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <!--
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    -->
                    
                    <!-- Content Row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- BEGIN::CONTENIDO -->
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h5 class="m-0 font-weight-bold">Reporte de salida</h5>
                                    <a class="btn btn-default text-right" href="SalidaControlador">
                                        <span class="fa fa-left-arrow"></span>&nbsp;Volver
                                    </a>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                                                <span class="text-primary">SALIDA N° ${salida.id}</span>
                                            </h4>
                                            <ul class="list-group mb-3">
                                                <li class="list-group-item d-flex justify-content-between lh-sm">
                                                    <div>
                                                        <h class="my-0">Fecha y Hora</h>
                                                    </div>
                                                    <span class="text-muted">${salida.fecha}&nbsp;${salida.hora}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between lh-sm">
                                                    <div>
                                                        <h class="my-0">Almacén</h>
                                                    </div>
                                                    <span class="text-muted">${salida.almacen}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between lh-sm">
                                                    <div>
                                                        <h class="my-0">Empleado</h>
                                                    </div>
                                                    <span class="text-muted">${salida.empleado}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between lh-sm">
                                                    <div>
                                                        <h class="my-0">Responsable</h>
                                                    </div>
                                                    <span class="text-muted">${salida.responsable}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between lh-sm">
                                                    <div class="text-muted">
                                                        <h class="my-0">Vehículo</h>
                                                    </div>
                                                    <span class="text-muted">${salida.vehiculo}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between lh-sm">
                                                    <div class="text-muted">
                                                        <h class="my-0">Observación</h>
                                                    </div>
                                                    <span class="text-muted">${salida.obs}</span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                                        <span class="text-primary">DETALLE</span>
                                    </h4>
                                    <table class="table table-stripped table-sm">
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>Ítem</th>
                                                <th>Cantidad (litros)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${salida_detalle}">
                                            <tr>
                                                <td class="text-center">${item.id}</td>
                                                <td>${item.item}</td>
                                                <td>${item.cantidad}</td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- END::CONTENIDO -->
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="META-INF/componentes/pie.jsp">
                <jsp:param name="" value=""/>
            </jsp:include>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>