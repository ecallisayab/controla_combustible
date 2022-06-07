        <%@ page contentType="text/html; charset=UTF-8" %>
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon">
                    <i class="fas fa-truck"></i>
                </div>
                <div class="sidebar-brand-text mx-3">CONTROLA COMBUSTIBLE</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuSubmodulos"
                    aria-expanded="true" aria-controls="menuSubmodulos">
                    <i class="fas fa-fw fa-list"></i>
                    <span>Submódulos</span>
                </a>
                <div id="menuSubmodulos" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="AlmacenControlador">Almacenes</a>
                        <a class="collapse-item" href="VehiculoControlador">Vehículos</a>
                        <a class="collapse-item" href="ProveedorControlador">Proveedores</a>
                        <a class="collapse-item" href="EmpleadoControlador">Empleados</a>
                        <a class="collapse-item" href="ItemControlador">Ítems</a>
                        <a class="collapse-item" href="EntradaControlador">Entradas</a>
                        <a class="collapse-item" href="SalidadaControlador">Salidas</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuCatalogos"
                    aria-expanded="true" aria-controls="menuCatalogos">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Catálogos</span>
                </a>
                <div id="menuCatalogos" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="TipoVehiculoControlador">Tipos de vehículo</a>
                        <a class="collapse-item" href="CargoControlador">Cargos</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#menuUsuarios"
                    aria-expanded="true" aria-controls="menuUsuarios">
                    <i class="fas fa-fw fa-user"></i>
                    <span>Usuarios</span>
                </a>
                <div id="menuUsuarios" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="UsuarioControlador">Usuarios</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

        </ul>