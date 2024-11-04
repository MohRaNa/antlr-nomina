package com.example.nomina.controller;

import org.antlr.v4.runtime.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class NominaController {

    @PostMapping("/calcular")
    public SalarioResponse calcular(@RequestBody SalarioRequest request) throws Exception {
        float salarioBase = request.getSalarioBase();
        float horasTrabajadas = request.getHorasTrabajadas();
        float tasaImpuestos = request.getTasaImpuestos();
        float deducciones = request.getDeducciones();

        float salarioBruto = salarioBase * horasTrabajadas;
        float impuestos = salarioBruto * (tasaImpuestos / 100);
        float salarioNeto = salarioBruto - impuestos - deducciones;

        return new SalarioResponse(salarioBruto, impuestos, deducciones, salarioNeto);
    }
}

class SalarioRequest {
    private float salarioBase;
    private float horasTrabajadas;
    private float tasaImpuestos;
    private float deducciones;

    // Getters y setters
    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public float getTasaImpuestos() {
        return tasaImpuestos;
    }

    public void setTasaImpuestos(float tasaImpuestos) {
        this.tasaImpuestos = tasaImpuestos;
    }

    public float getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(float deducciones) {
        this.deducciones = deducciones;
    }
}

class SalarioResponse {
    private float salarioBruto;
    private float impuestos;
    private float deducciones;
    private float salarioNeto;

    public SalarioResponse(float salarioBruto, float impuestos, float deducciones, float salarioNeto) {
        this.salarioBruto = salarioBruto;
        this.impuestos = impuestos;
        this.deducciones = deducciones;
        this.salarioNeto = salarioNeto;
    }

    // Getters y setters
    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public float getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(float deducciones) {
        this.deducciones = deducciones;
    }

    public float getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(float salarioNeto) {
        this.salarioNeto = salarioNeto;
    }
}
