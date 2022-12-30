/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utilidades;

import java.lang.reflect.Field;

/**
 *
 * @author Victor
 */
public class Utilidades {
    
    public static Boolean isString(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isPrimitive(Class clase){
        return clase.isPrimitive();
    }
    
    public static Field ObtencionDeAtributo(Class clase, String nombre){
        Field atributo = null;
        for(Field aux : clase.getDeclaredFields()){
            if(nombre.equalsIgnoreCase(aux.getName())){
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
}

