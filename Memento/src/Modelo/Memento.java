/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
/**
 *
 * @author Alan
 */
public class Memento {

    private int numpedido;
    private int idusuario;
    private int idcliente;
    private int cantidad;
    private int numdepaginas;
    private String Nombredeusuario;
    private String Apellidoscliente;
    private String cometarios;
    private String Celularcliente;
    private String Servicio;
    private String Tipodecopia;
    private String Tamaño;
    private String Escala;
    private String Status;
    private Date fechaEmision;
    private Date Fechaentrega;
    private Date Horaemision;
    private Date Horaentrega;
    private String pastafrente;
    private String pastatrasera;
    private String arillo;
    private double total;
    private double Anticipo;
    private double Resto;
    private String Unlado, Amboslados;

    public Memento(int numpedido, int idusuario, int idcliente, int cantidad, int numdepaginas, String Nombredeusuario, String Apellidoscliente, String cometarios, String Celularcliente, String Servicio, String Tipodecopia, String Tamaño, String Escala, String Status, Date fechaEmision, Date Fechaentrega, Date Horaemision, Date Horaentrega, String pastafrente, String pastatrasera, String arillo, double total, double Anticipo, double Resto, String Unlado, String Amboslados) {
        this.numpedido = numpedido;
        this.idusuario = idusuario;
        this.idcliente = idcliente;
        this.cantidad = cantidad;
        this.numdepaginas = numdepaginas;
        this.Nombredeusuario = Nombredeusuario;
        this.Apellidoscliente = Apellidoscliente;
        this.cometarios = cometarios;
        this.Celularcliente = Celularcliente;
        this.Servicio = Servicio;
        this.Tipodecopia = Tipodecopia;
        this.Tamaño = Tamaño;
        this.Escala = Escala;
        this.Status = Status;
        this.fechaEmision = fechaEmision;
        this.Fechaentrega = Fechaentrega;
        this.Horaemision = Horaemision;
        this.Horaentrega = Horaentrega;
        this.pastafrente = pastafrente;
        this.pastatrasera = pastatrasera;
        this.arillo = arillo;
        this.total = total;
        this.Anticipo = Anticipo;
        this.Resto = Resto;
        this.Unlado = Unlado;
        this.Amboslados = Amboslados;
    }

    public int getNumpedido() {
        return numpedido;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getNumdepaginas() {
        return numdepaginas;
    }

    public String getNombredeusuario() {
        return Nombredeusuario;
    }

    public String getApellidoscliente() {
        return Apellidoscliente;
    }

    public String getCometarios() {
        return cometarios;
    }

    public String getCelularcliente() {
        return Celularcliente;
    }

    public String getServicio() {
        return Servicio;
    }

    public String getTipodecopia() {
        return Tipodecopia;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public String getEscala() {
        return Escala;
    }

    public String getStatus() {
        return Status;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFechaentrega() {
        return Fechaentrega;
    }

    public Date getHoraemision() {
        return Horaemision;
    }

    public Date getHoraentrega() {
        return Horaentrega;
    }

    public String getPastafrente() {
        return pastafrente;
    }

    public String getPastatrasera() {
        return pastatrasera;
    }

    public String getArillo() {
        return arillo;
    }

    public double getTotal() {
        return total;
    }

    public double getAnticipo() {
        return Anticipo;
    }

    public double getResto() {
        return Resto;
    }
}
