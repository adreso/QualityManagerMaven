/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quality.qm.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import org.apache.ibatis.session.SqlSession;
import org.quality.qm.model.Usuarios;
import org.quality.qm.model.mybatis.MyBatisUtil;

/**
 *
 * @author facturador
 */
@ManagedBean
@ViewScoped

public class usuariosController {
    private Usuarios usuario;
    private List<Usuarios> lista;
    
    public usuariosController(){
        usuario=new Usuarios();
    }
    
    public Usuarios getUsuario(){
        return usuario;
    }
    
    public void setUsuarios(Usuarios usuario){
        this.usuario=usuario;
    }  

    
    
    
    
    public String guardar() {
        Date today = new Date();
        usuario.setIdusuario(-1);
        usuario.setFechacreacion(today);
        usuario.setFechamodificacion(today);
        SqlSession session = new MyBatisUtil().getSession();
        if (session != null) {
            try {
                session.insert("usuarios.insertarusuarios", usuario);
                session.commit();
                lista=null;
            } finally {
                session.close();
            }
        } else {
            System.out.println("Error");
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Usuario creado"));
        return "index";
    }
    
    public List<Usuarios> getusuarios(){
        //List<Usuarios> lista=null;
        SqlSession session = new MyBatisUtil().getSession();
        if(session!=null){
            try{
                if(lista==null){
                    lista=session.selectList("usuarios.getusuarios");
                }
            }finally{
                session.close();
            }
        }else{
            System.out.print("ERROR");
        }
        
        return lista;
    }
    
    public String login(){
        List<Usuarios> login=null;
        //Usuarios usuario=null;
        String redireccion=null;
        SqlSession session = new MyBatisUtil().getSession();
        if(session!=null){
            try{
                login=session.selectList("usuarios.login",usuario);
                if(!login.isEmpty()){
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", login);
                    redireccion="/view/index";
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales incorrectas", "Credenciales incorrectas"));
                }
            }finally{
                session.close();
            }
        }else{
            System.out.print("Error BD");
        }
        return redireccion;
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sesión cerrada", "Credenciales incorrectas"));
    }
    
}
