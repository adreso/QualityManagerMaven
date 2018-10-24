/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quality.qm.model.mybatis.mappers;

import java.util.List;
import org.quality.qm.model.Usuarios;

/**
 *
 * @author facturador
 */
public interface usuariosMapper {
    void insertarUsuarios(Usuarios usuario);
    List<Usuarios> getusuarios();
}
