package com.campus.proyecto_springboot.specification;

import com.campus.proyecto_springboot.model.TipoMovimiento;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class MovimientoSpecification {
    public static Specification<MovimientoSpecification> tipoEs(TipoMovimiento tipo) {
        return (root, query, cb) ->
                tipo == null ? null : cb.equal(root.get("tipo"), tipo);
    }

    public static Specification<MovimientoSpecification> fechaEntre(LocalDate desde, LocalDate hasta) {
        return (root, query, cb) -> {
            if (desde == null && hasta == null) return null;

            if (desde != null && hasta != null)
                return cb.between(root.get("fechaMovimiento"), desde.atStartOfDay(), hasta.atTime(23, 59, 59));

            if (desde != null)
                return cb.greaterThanOrEqualTo(root.get("fechaMovimiento"), desde.atStartOfDay());

            return cb.lessThanOrEqualTo(root.get("fechaMovimiento"), hasta.atTime(23, 59, 59));
        };
    }

    public static Specification<MovimientoSpecification> productoEs(Long productoId) {
        return (root, query, cb) ->
                productoId == null ? null : cb.equal(root.get("producto").get("id"), productoId);
    }
}
