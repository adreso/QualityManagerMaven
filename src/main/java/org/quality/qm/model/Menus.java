/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quality.qm.model;

/**
 *
 * @author Andrés
 */
public class Menus {
    private int idmenu;
    private String nombre;
    private boolean tipo;
    private int mainmenu;
    private String url;
    private int nivel;
    private boolean estado;
    private String icono;

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
    

    public Menus() {
    }

    public Menus(int idmenu, String nombre, boolean tipo, int mainmenu, String url, boolean estado, int nivel, String icono) {
        this.idmenu = idmenu;
        this.nombre = nombre;
        this.tipo = tipo;
        this.mainmenu = mainmenu;
        this.url = url;
        this.estado = estado;
        this.nivel=nivel;
        this.icono=icono;
    }

    public Menus(String nombre, boolean tipo, int mainmenu, String url, boolean estado,int nivel,String icono) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.mainmenu = mainmenu;
        this.url = url;
        this.estado = estado;
        this.nivel=nivel;
        this.icono=icono;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public int getMainmenu() {
        return mainmenu;
    }

    public void setMainmenu(int mainmenu) {
        this.mainmenu = mainmenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
