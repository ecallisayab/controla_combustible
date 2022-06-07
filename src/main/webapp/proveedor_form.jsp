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
    <title>Control de Combustible | Proveedores</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="META-INF/componentes/menu.jsp">
            <jsp:param name="opcion" value="proveedores"/>
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
                                    <h5 class="m-0 font-weight-bold">Proveedores</h5>
                                    <a class="btn btn-default text-right" href="ProveedorControlador">
                                        <span class="fa fa-arrow-left"></span>&nbsp;Volver
                                    </a>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <form action="ProveedorControlador" method="POST" autocomplete="off">
                                        <input class="form-control" type="hidden" name="id" id="txtId" value="${proveedor.id}">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label id="txtNombre">Nombre</label>
                                                    <input class="form-control" type="text" name="nombre" id="txtNombre" value="${proveedor.nombre}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="form-group">
                                                    <label id="txtFono1">Teléfono (línea 1)</label>
                                                    <input class="form-control" type="number" name="fono_1" id="txtFono1" value="${proveedor.fono1}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="form-group">
                                                    <label id="txtFono2">Teléfono (línea 2)</label>
                                                    <input class="form-control" type="number" name="fono_2" id="txtFono2" value="${proveedor.fono2}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label id="txtDireccion">Dirección</label>
                                                    <input class="form-control" type="text" name="direccion" id="txtDireccion" value="${proveedor.direccion}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="form-group">
                                                    <label id="txtCorreo">Correo electrónico</label>
                                                    <input class="form-control" type="email" name="correo" id="txtCorreo" value="${proveedor.correo}">
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="form-group">
                                                    <label id="txtNit">NIT</label>
                                                    <input class="form-control" type="text" name="nit" id="txtNit" value="${proveedor.nit}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtRepLegal">Representante legal</label>
                                                    <input class="form-control" type="text" name="rep_legal" id="txtRepLegal" value="${proveedor.rep_legal}">
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="form-group">
                                                    <label id="txtRepFono">Teléfono representante</label>
                                                    <input class="form-control" type="number" name="rep_fono" id="txtRepFono" value="${proveedor.rep_fono}">
                                                </div>
                                            </div>
                                            <div class="col-lg-5">
                                                <div class="form-group">
                                                    <label id="txtRepDireccion">Dirección representante</label>
                                                    <input class="form-control" type="text" name="rep_direccion" id="txtRepDireccion" value="${proveedor.rep_direccion}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label id="txtObs">Observación</label>
                                                    <textarea class="form-control" name="obs" id="txtObs" rows="3">${proveedor.obs}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="form-group">
                                                    <button class="btn btn-primary" type="submit" id="btnGuardar">Guardar</button>
                                                    <button class="btn btn-secondary" type="reset" id="btnCancelar">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
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