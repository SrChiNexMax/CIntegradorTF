package com.utp.integrador.IntegradorFinal.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLiquidacion;

    private Timestamp fechaVenta;

    @Column(precision = 12, scale=2)
    private BigDecimal total;

}
