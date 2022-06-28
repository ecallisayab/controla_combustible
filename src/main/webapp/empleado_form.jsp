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
    <title>Control de Combustible | Empleados</title>

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
        <!-- Revisar -->
        <jsp:include page="META-INF/componentes/menu.jsp">
            <jsp:param name="opcion" value="empleado"/>
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
                                    <h5 class="m-0 font-weight-bold">Empleados</h5>
                                    <a class="btn btn-default text-right" href="EmpleadoControlador">
                                        <span class="fa fa-arrow-left"></span>&nbsp;Volver
                                    </a>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <form action="EmpleadoControlador" method="POST" autocomplete="off">
                                        
                                        <input class="form-control" type="hidden" name="id" id="txtId" value="${empleado.id}">
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtNombre">Nombre</label>
                                                    <input class="form-control" type="text" name="nombres" id="txtNombre" value="${empleado.nombres}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtPaterno">Apellido paterno</label>
                                                    <input class="form-control" type="text" name="paterno" id="txtPaterno" value="${empleado.paterno}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtMaterno">Apellido materno</label>
                                                    <input class="form-control" type="text" name="materno" id="txtMaterno" value="${empleado.materno}" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                             <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtCi">CI</label>
                                                    <input class="form-control" type="number" name="ci" id="txtCi" value="${empleado.ci}" required>
                                                </div>
                                            </div>   
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtFechaNac">Fecha de nacimiento</label>
                                                    <input class="form-control" type="date" name="fecha_nac" id="txtFechaNac" value="${empleado.fecha_nac}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtTelefono">Teléfono</label>
                                                    <input class="form-control" type="number" name="telefono" id="txtTelefono" value="${empleado.telefono}" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row"> 
                                            <div class="col-lg-4">
                                                  <label for="cboTipoCargoId" class="form-label">Tipo de Cargo</label>
                                                    <select class="form-control" name="cargo_id" id="cboTipoCargoId">
                                                    <option value="">--Seleccione una opción--</option>
                                                 <c:forEach var="item" items="${tipo_cargo}">
                                                   <option value="${item.id}" <c:if test="${item.id == empleado.cargo_id}">selected</c:if>>${item.nombre}</option>
                                                 </c:forEach>
                                                </select>
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