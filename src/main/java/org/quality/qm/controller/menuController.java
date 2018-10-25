/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quality.qm.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.quality.qm.model.Menus;
import org.quality.qm.model.mybatis.MyBatisUtil;

/**
 *
 * @author Andrés
 */
@ManagedBean
@RequestScoped
public class menuController {

    private MenuModel model;
    private Menus  menu;

    public Menus getMenu() {
        return menu;
    }

    public void setMenu(Menus menu) {
        this.menu = menu;
    }
    
    public void init(){
        model=new DefaultMenuModel();
        this.getModel();
        this.getmenus();
    }
    
    public MenuModel getModel() {
        return model;
    }
    
    public List<Menus> getmenus(){
        List<Menus> lista=null;
        SqlSession session = new MyBatisUtil().getSession();
        if(session!=null){
            try{
                lista=session.selectList("menus.getmenus");
            }finally{
                session.close();
            }
        }else{
            System.out.print("ERROR");
        }
        return lista;
    }
    
    public menuController() {
        List<Menus> g=this.getmenus();
        model = new DefaultMenuModel();
        for(int i=0;i<g.size();i++){
            if(g.get(i).isTipo() && g.get(i).getNivel()==1){
                DefaultSubMenu sNivel1=new DefaultSubMenu(g.get(i).getNombre());
                sNivel1.setIcon(g.get(i).getIcono());
                for (int j = 0; j < g.size(); j++) {
                    if(g.get(j).isTipo() && g.get(j).getNivel()==2 && g.get(j).getMainmenu()==g.get(i).getIdmenu()){
                        DefaultSubMenu sNivel2=new DefaultSubMenu(g.get(j).getNombre());
                        sNivel2.setIcon(g.get(j).getIcono());
                        sNivel1.addElement(sNivel2);
                        for (int k = 0; k < g.size(); k++) {
                            if(g.get(k).getNivel()==3 && g.get(k).getMainmenu()==g.get(j).getIdmenu()){
                                DefaultMenuItem itemLevel3=new DefaultMenuItem(g.get(k).getNombre());
                                itemLevel3.setIcon(g.get(k).getIcono());
                                itemLevel3.setOutcome(g.get(k).getUrl());
                                itemLevel3.setAjax(true);
                                sNivel2.addElement(itemLevel3);
                            }
                        }
                    }else if(!g.get(j).isTipo() && g.get(j).getNivel()==2 && g.get(j).getMainmenu()==g.get(i).getIdmenu()){
                        DefaultMenuItem itemLevel2=new DefaultMenuItem(g.get(j).getNombre());
                        itemLevel2.setIcon(g.get(j).getIcono());                               
                        itemLevel2.setOutcome(g.get(j).getUrl());
                        itemLevel2.setAjax(true);
                        sNivel1.addElement(itemLevel2);
                    }
                }
            model.addElement(sNivel1);
            }else if(!g.get(i).isTipo() && g.get(i).getNivel()==1){
                DefaultMenuItem itemLevel1=new DefaultMenuItem(g.get(i).getNombre());
                itemLevel1.setIcon(g.get(i).getIcono());
                itemLevel1.setOutcome(g.get(i).getUrl());
                itemLevel1.setAjax(true);
                model.addElement(itemLevel1);
            }
        }
    }
}
