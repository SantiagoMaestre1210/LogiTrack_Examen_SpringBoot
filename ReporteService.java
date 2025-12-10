package com.campus.proyecto_springboot.service.Reporte;

import com.campus.proyecto_springboot.dto.ResumenGeneralDTO;
import com.campus.proyecto_springboot.model.Producto;
import com.campus.proyecto_springboot.model.TipoMovimiento;

import java.time.LocalDate;
import java.util.List;

public interface ReporteService {
    ResumenGeneralDTO obtenerResumenGeneral();

    Object Movimientos(TipoMovimiento tipo, LocalDate desde, LocalDate hasta, Long productoId);

    List<Producto> filtrarInventario(String nombre, Integer stockMin, Integer stockMax);
}
