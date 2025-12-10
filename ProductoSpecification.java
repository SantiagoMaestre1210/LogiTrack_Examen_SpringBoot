package com.campus.proyecto_springboot.specification;

import com.campus.proyecto_springboot.model.Producto;
import org.springframework.data.jpa.domain.Specification;

public class ProductoSpecification {
    public static Specification<Producto> nombreContiene(String nombre) {
        return (root, query, cb) ->
                nombre == null ? null : cb.like(cb.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%");
    }

    public static Specification<Producto> stockEntre(Integer min, Integer max) {
        return (root, query, cb) -> {
            if (min == null && max == null) return null;
            if (min != null && max != null)
                return cb.between(root.get("stock"), min, max);
            if (min != null)
                return cb.greaterThanOrEqualTo(root.get("stock"), min);
            return cb.lessThanOrEqualTo(root.get("stock"), max);
        };
    }
}
