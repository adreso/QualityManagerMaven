/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quality.qm.model;

import java.util.Date;

/**
 *
 * @author facturador
 */
public class Usuarios {

    private int idusuario;
    private String username;
    private String password;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int grupo;
    private int idtercero;
    private boolean estado;

    public Usuarios() {
    }
    
    
    public Usuarios(String username, String password, Date fechacreacion, Date fechamodificacion, int grupo, int idtercero, boolean estado) {
        this.username = username;
        this.password = password;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.grupo = grupo;
        this.idtercero = idtercero;
        this.estado = estado;
    }
    
    
    public Usuarios(int idusuario, String username, String password, Date fechacreacion, Date fechamodificacion, int grupo, int idtercero, boolean estado) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.grupo = grupo;
        this.idtercero = idtercero;
        this.estado = estado;
    }
    
    
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(int idtercero) {
        this.idtercero = idtercero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
