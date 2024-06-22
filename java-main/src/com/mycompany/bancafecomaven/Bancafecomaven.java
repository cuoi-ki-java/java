/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancafecomaven;

import com.mycompany.bancafecomaven.daos.hahahaDAO;
import com.mycompany.bancafecomaven.models.hahaha;
import java.util.List;

/**
 *
 * @author This PC
 */
public class Bancafecomaven {

    public static void main(String[] args) {
      Dangki dk=new Dangki();
      dk.setVisible(true);
     hahaha hhh=new hahaha("khunglong","1234567890","khunglongbaochua","klog");
     hahahaDAO.insert(hhh);
     List<hahaha> HahahaList=hahahaDAO.list();
        for(hahaha Hahaha:HahahaList){
            System.out.println(Hahaha);
        }
    }
}
