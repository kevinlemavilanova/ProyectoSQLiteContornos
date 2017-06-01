/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitebd;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Menu {

    public static void main(String args[]) {

        String ruta = JOptionPane.showInputDialog("Introduce la ruta de la base de datos");
        BaseDatos bd = new BaseDatos(ruta);
        Boolean seguir = true;

        if (bd.connect()) {
            System.out.println("Conectado");
            String option = JOptionPane.showInputDialog("Seleccione un opcion: "
                    + "\n a. Insertar"
                    + "\n b. Borrar"
                    + "\n c. Modificar"
                    + "\n d. Salir"
            );
            switch (option) {
                case "a":
                    System.out.println(bd.insertar("id1", "placa", 132.5f) + " registros insertados correctamente");
                    break;
                case "b":
                    System.out.println(bd.borrar("id1") + " registros borrados correctamente");
                    break;
                case "c":
                    System.out.println(bd.update("id1", 120.0f, "base") + " registros borrados correctamente");
                    break;
                case "d":
                    seguir = false;
                    break;
            }
            while (seguir == true);
        } else {
            System.err.println("No se ha podido conectar a la base de datos");
        }
    }
}
