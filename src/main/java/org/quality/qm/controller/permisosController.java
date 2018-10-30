package org.quality.qm.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.quality.qm.model.Usuarios;

@Named
@ViewScoped
public class permisosController{
    
    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuarios usuario = (Usuarios) context.getExternalContext().getSessionMap().get("Usuario");
            if(usuario==null){
                context.getExternalContext().redirect(context.getExternalContext().getRequestContextPath());
                
            }
        }catch(Exception e){
            
        }
    }
}
