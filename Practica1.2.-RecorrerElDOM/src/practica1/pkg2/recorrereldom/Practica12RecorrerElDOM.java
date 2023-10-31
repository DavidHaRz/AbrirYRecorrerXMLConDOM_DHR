/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1.pkg2.recorrereldom;

import java.io.File;

/**
 *
 * @author David
 */
public class Practica12RecorrerElDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccessXMLDOM a = new AccessXMLDOM();
        File f = new File("./archivos/Libros.xml");//necesitamos Libros.xml en la ruta correcta

        a.abrirXMLaDOM(f);
        
        a.recorreDOMyMuestra();
    }
    
}
