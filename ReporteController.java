package com.campus.proyecto_springboot.controller;

import com.campus.proyecto_springboot.dto.ResumenGeneralDTO;
import com.campus.proyecto_springboot.model.MovimientoInventario;
import com.campus.proyecto_springboot.model.Producto;
import com.campus.proyecto_springboot.model.TipoMovimiento;
import com.campus.proyecto_springboot.service.MovimientoInventario.MovimientoInventarioServiceImpl;
import com.campus.proyecto_springboot.service.Reporte.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor

public class ReporteController {

    private final ReporteService reportService;

    // --------------------------
    // INVENTARIO
    // --------------------------
    @GetMapping("/inventario")
    public ResponseEntity<List<Producto>> filtrarInventario(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer stockMin,
            @RequestParam(required = false) Integer stockMax
    ) {
        return ResponseEntity.ok(reportService.filtrarInventario(nombre, stockMin, stockMax));
    }

    // --------------------------
    // MOVIMIENTOS
    // --------------------------
    @GetMapping("/movimientos")
    public ResponseEntity<List<MovimientoInventarioServiceImpl>> filtrarMovimientos(
            @RequestParam(required = false) TipoMovimiento tipo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
            @RequestParam(required = false) Long productoId
    ) {
        return ResponseEntity.ok((List<MovimientoInventarioServiceImpl>) reportService.Movimientos(tipo, desde, hasta, productoId));
    }
}