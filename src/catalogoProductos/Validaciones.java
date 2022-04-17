/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogoProductos;

/**
 *
 * @author Rafaelito
 */
public class Validaciones {

    private static boolean estado;

    @SuppressWarnings("finally")
    public static boolean validarRespuesta(String respuesta) {

        if (!(respuesta.equalsIgnoreCase("si")) && !(respuesta.equalsIgnoreCase("no"))) {
            System.out.println("Respuesta ingresada no valida");
            estado = false;
        } else {
            estado = true;
        }

        return estado;
    }

    public static boolean validaOpcion(int opcion) {
        if (opcion < 1 || opcion > 7) {
            estado = false;
            System.out.println("Valor ingresado no es valido");
        } else {
            estado = true;
        }
        return estado;
    }
    

}
