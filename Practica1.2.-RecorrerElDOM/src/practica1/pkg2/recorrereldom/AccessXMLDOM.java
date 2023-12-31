/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.pkg2.recorrereldom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author David
 */
public class AccessXMLDOM {

    Document doc;

//codigo escrito en Practica1
public int abrirXMLaDOM(File f) {
        try {
            System.out.println("Abriendo archivo XML file y generando DOM....");

            //creamos nuevo objeto DocumentBuilder al que apunta la variable factory 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //ignorar comentarios y espacios blancos
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            //DocumentBuilder tiene el método parse que es el que genera DOM en memoria

            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(f);
            // ahora doc apunta al arbol DOM y podemos recorrerlo
            System.out.println("DOM creado con éxito.");
            return 0;//si el método funciona
        } catch (Exception e) {
            System.out.println(e);
            return -1;//if the method aborta en algún punto
        }
    }
//añade el nuevo método
    public void recorreDOMyMuestra() {
        int nlibros = 0;
        String[] datos = new String[3];//lo usamos para la información de cada libro
        Node nodo = null;
        Node root = doc.getFirstChild();
        NodeList nodelist = root.getChildNodes(); //(1)Ver dibujo del árbol
        //recorrer el árbol DOM. El 1er nivel de nodos hijos del raíz
        for (int i = 0; i < nodelist.getLength(); i++) {
            nodo = nodelist.item(i);//node toma el valor de los hijos de raíz
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {//miramos nodos de tipo Element
                Node ntemp = null;
                int contador = 1;
                //sacamos el valor del atributo publicado
                datos[0] = nodo.getAttributes().item(0).getNodeValue();
                //sacamos los valores de los hijos de nodo, Titulo y Autor
                NodeList nl2 = nodo.getChildNodes();//obtenemos lista de hijos (2)
                for (int j = 0; j < nl2.getLength(); j++) {//iteramos en esa lista 
                    ntemp = nl2.item(j);
                    if (ntemp.getNodeType() == Node.ELEMENT_NODE){
                        //para conseguir el texto de titulo y autor, se
                        //puede hacer con getNodeValue(), también con
                        //getTextContent() si es ELEMENT
                        datos[contador] = ntemp.getTextContent();
                        // también datos[contador]=ntemp.getChildNodes().item(0).getNodeValue();		
                        contador++;
                    }
                }
                nlibros++;
                //el array de String datos[] tiene los valores que necesitamos
                System.out.println("\nLibro " + nlibros + ":" + "\n\tFecha de publicación: " + datos[0] + "\n\tAutor: " + datos[2] + "\n\tTítulo: " + datos[1]);
            }

        }
    }
}

