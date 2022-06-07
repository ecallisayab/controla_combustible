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
    <title>Control de combustible | Vehiculo</title>

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
                                    <h4 class="m-0 font-weight-bold">Vehiculo</h4>
                                    <a class="btn btn-default text-right" href="VehiculoControlador">
                                        <span class="fa fa-arrow-left"></span>&nbsp;Volver
                                    </a>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <form action="VehiculoControlador" method="POST" autocomplete="off">
                                        
                                        <input class="form-control" type="hidden" name="id" id="txtId" value="${vehiculo.id}">
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtNombre">Marca</label>
                                                    <input class="form-control" type="text" name="marca" id="txtNombre" value="${vehiculo.marca}" required>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtNombre">Modelo</label>
                                                    <input class="form-control" type="text" name="modelo" id="txtNombre" value="${vehiculo.modelo}" required>
                                                </div>
                                            </div>
                                             <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtNombre">Placa</label>
                                                    <input class="form-control" type="text" name="placa" id="txtNombre" value="${vehiculo.placa}" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                              <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="txtNombre">Tipo de Combustible</label>
                                                    <input class="form-control" type="text" name="tipo_combustible" id="txtNombre" value="${vehiculo.tipo_combustible}" required>
                                                </div>
                                            </div>   
                                            <div class="col-lg-4">
                                                  <label for="tipo_id" class="form-label">Tipo de Vehiculo</label>
                                                    <select class="form-control" name="tipo_id" id="id_seminario">
                                                     <option value="">--Seleccione una opción--</option>
                                                 <c:forEach var="item" items="${tipo_vehiculo}">
                                                   <option value="${item.id}" <c:if test="${item.id == vehiculo.tipo_id}">selected</c:if>>${item.nombre}</option>
                                                 </c:forEach>
                                                </select>
                                             </div>
                                            <div class="col-lg-4">
                                                <div class="form-group">
                                                    <label id="cboEstado">Estado</label>
                                                    <select class="form-control" name="estado" id="cboEstado" required>
                                                        <option value="">--Selecciones una opción--</option>
                                                        <option value="1" <c:if test="${vehiculo.estado == 1}">selected</c:if>>ACTIVADO</option>
                                                        <option value="0" <c:if test="${vehiculo.estado == 0}">selected</c:if>>DESACTIVADO</option>
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