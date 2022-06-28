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
    <title>Control de Combustible | Entradas detalle</title>

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
            <jsp:param name="opcion" value="vehiculo"/>
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
                                    <h5 class="m-0 font-weight-bold">Detalle de entrada</h5>
                                    <a class="btn btn-default text-right" href="EntradaControlador">
                                        <span class="fa fa-arrow-left"></span>&nbsp;Volver
                                    </a>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <table class="table table-stripped table-sm">
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>N° de Entrada</th>
                                                <th>Nombre de Ítem</th>
                                                <th>Cantidad (litros)</th>
                                                <th>Precio Unitario (Bs.)</th>
                                                <th>N° de Factura</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${entrada_detalle}">
                                            <tr>
                                                <td class="text-center">${item.id}</td>
                                                <td>ENTRADA # ${item.entrada_id}</td>
                                                <td>${item.item}</td>
                                                <td class="text-right">${item.cantidad}</td>
                                                <td class="text-right">${item.precio_unit}</td>
                                                <td class="text-right">${item.nro_factura}</td>
                                                <td>
                                                    <div class="btn-group " role="group" aria-label="Button group with nested dropdown">
                                                      <div class="btn-group btn-group-sm" role="group">
                                                        <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                          Acciones
                                                        </button>
                                                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                                            <a class="dropdown-item" href="EntradaDetalleControlador?accion=editar&id=${item.id}" title="Editar"><span class="fa fa-edit"></span>&nbsp;Editar</a>
                                                            <a class="dropdown-item" href="EntradaDetalleControlador?accion=eliminar&id=${item.id}" title="Eliminar"><span class="fa fa-trash"></span>&nbsp;Eliminar</a>
                                                        </div>
                                                      </div>
                                                    </div>
                                                </td>
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