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
    <title>Control de Combustible | Entradas</title>

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
            <jsp:param name="opcion" value="entrada"/>
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
                                    <h5 class="m-0 font-weight-bold">Entradas</h5>
                                    <a class="btn btn-default text-right" href="EntradaControlador">
                                        <span class="fa fa-arrow-left"></span>&nbsp;Volver
                                    </a>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <form action="EntradaControlador" method="POST" autocomplete="off">
                                        <input class="form-control" type="hidden" name="id" id="txtId" value="${entrada.id}">
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtFecha">Fecha</label>
                                                    <input class="form-control" type="date" name="fecha" id="txtFecha" value="${entrada.fecha}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="cboAlmacenId">Almac??n</label>
                                                    <select class="form-control" name="almacen_id" id="cboAlmacenId">
                                                        <option value="">--Seleccione una opci??n--</option>
                                                        <c:forEach var="item" items="${almacenes}">
                                                        <option value="${item.id}" <c:if test="${item.id == entrada.almacen_id}">selected</c:if>>${item.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                             <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="cboResponsableId">Responsable</label>
                                                     <select class="form-control" name="responsable_id" id="cboResponsableId">
                                                        <option value="">--Seleccione una opci??n--</option>
                                                        <c:forEach var="item" items="${empleados}">
                                                        <option value="${item.id}" <c:if test="${item.id == entrada.responsable_id}">selected</c:if>>${item.nombres}&nbsp;${item.paterno}&nbsp;${item.materno}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="cboProveedorId">Proveedor</label>
                                                    <select class="form-control" name="proveedor_id" id="cboProveedorId">
                                                        <option value="">--Seleccione una opci??n--</option>
                                                        <c:forEach var="item" items="${proveedores}">
                                                        <option value="${item.id}" <c:if test="${item.id == entrada.proveedor_id}">selected</c:if>>${item.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>   
                                            <div class="col-lg-8">
                                                <div class="form-group">
                                                    <label for="txtObs" class="form-label">Observaci??n</label>
                                                    <textarea class="form-control" name="obs" id="txtObs" rows="3">${entrada.obs}</textarea>
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