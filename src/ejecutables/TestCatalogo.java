package ejecutables;

import catalogoProductos.Categorias;
import catalogoProductos.Productos;
import catalogoProductos.Validaciones;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestCatalogo {

    private static boolean estado;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int opcion;
    private static String respuesta;

    private static ArrayList<Categorias> listaCategoria = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        menuInicial();

    }

    private static void menuInicial() throws Exception {

        System.out.println("\t\tCatalogo de Productos");
        System.out.println("\t\t---------------------");

        System.out.println("\n1.- Agregar nueva Categoria.");
        System.out.println("2.- Agregar nuevo Producto.");
        System.out.println("3.- Listar Categorias.");
        System.out.println("4.- Listar productos de Categoria.");
        System.out.println("5.- Eliminar Categoria.");
        System.out.println("6.- Eliminar Producto de Categoria");
        System.out.println("7.- Salir");
        do {

            System.out.print("\nIngrese Opcion entre 1 y 7 :");
            opcion = Integer.parseInt(bf.readLine());
            estado = Validaciones.validaOpcion(opcion);

        } while (estado == false);
        menuCatalogo(opcion);

    }

    private static void menuCatalogo(int opcion) throws Exception {

        switch (opcion) {
            case 1 ->
                agregarCategoria();
            case 2 ->
                agregarProducto();
            case 3 ->
                listarCategorias();
            case 4 ->
                listarProductosCategoria();
            case 5 ->
                eliminarCategoria();
            case 6 ->
                eliminarProductos();
            default ->
                System.exit(0);

        }

    }

    private static void agregarCategoria() throws Exception {

        String nombreCategoria;
        do {
            System.out.print("Ingresa nueva Categoria :");
            nombreCategoria = bf.readLine();
            if (!(nombreCategoria.equals(""))) {
                if (!listaCategoria.isEmpty()) {
                    for (int i = 0; i < listaCategoria.size(); i++) {
                        if (listaCategoria.get(i).getNombreCategoria().equalsIgnoreCase(nombreCategoria)) {
                            System.out.println("nombre de Categoria ya existe");
                            estado = true;
                            break;

                        } else {
                            estado = false;
                        }
                    }
                    if (estado == false) {
                        listaCategoria.add(new Categorias(nombreCategoria));
                        System.out.println("Categoria Agregada Correctamente");
                    }
                } else {

                    listaCategoria.add(new Categorias(nombreCategoria));
                    System.out.println("Categoria Agregada Correctamente");

                }

            } else {

                System.out.println("No ha ingresado Ningun Valor");

            }
            do {
                System.out.print("Desea ingresar otra Categoria si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);
        } while (respuesta.equalsIgnoreCase("si"));
        menuInicial();
    }

    private static void agregarProducto() throws Exception {

        do {
            String nombreProducto;
            int precio;
            String descripcion;
            int i = 1;
            do {
                for (Categorias categoria : listaCategoria) {
                    System.out.println(i + ".- " + categoria.getNombreCategoria());
                    i++;
                }
                System.out.print("Ingrese numero de categoria de producto :");
                opcion = Integer.parseInt(bf.readLine());
                estado = validarLista(opcion);
            } while (estado == false);
            System.out.print("Ingrese el nombre del Producto :");
            nombreProducto = bf.readLine();
            do {
                System.out.print("Ingrese precio de Producto :");
                precio = Integer.parseInt(bf.readLine());
                if (precio < 1) {
                    System.out.println("Precio ingresado no es valido!");
                    estado = false;
                }

            } while (estado == false);
            System.out.print("Ingrese Descripcion de Producto :");
            descripcion = bf.readLine();
            Productos producto = new Productos(nombreProducto, precio, descripcion);
            listaCategoria.get(opcion - 1).agregarProductoLista(producto);

            do {
                System.out.print("Desea ingresar otro Producto si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);
        } while (respuesta.equalsIgnoreCase("si"));
        menuInicial();
    }

    private static boolean validarLista(int opcion) {
        if (opcion < 1 || listaCategoria.size() < opcion) {
            estado = false;
            System.out.println("Valor ingresado no es valido");
        } else {
            estado = true;
        }
        return estado;
    }

    private static void listarCategorias() throws Exception {

        int i = 1;
        System.out.println("\t\tLista de Categorias");
        do {

            for (Categorias categoria : listaCategoria) {
                System.out.println(i + ".- " + categoria.getNombreCategoria());
                i++;
            }
        } while (estado == false);
        TimeUnit.SECONDS.sleep(2);
        menuInicial();

    }

    private static void listarProductosCategoria() throws Exception {

        int i = 1;
        do {
            System.out.println("\t\tLista de Categorias");
            for (Categorias categoria : listaCategoria) {
                System.out.println(i + ".- " + categoria.getNombreCategoria());
                i++;
            }
            System.out.print("Ingrese numero de categoria de producto :");
            opcion = Integer.parseInt(bf.readLine());
            estado = validarLista(opcion);

        } while (estado == false);
        int j = 1;
        System.out.printf("\n\t\tLista de productos de Categoria \"%s\"%n", listaCategoria.get(opcion - 1).getNombreCategoria());
        for (Productos producto : listaCategoria.get(opcion - 1).getListaProductos()) {
            System.out.println(j + ".- " + producto.getNombre());
            j++;
        }

        menuInicial();

    }

    private static void eliminarCategoria() throws Exception {
        do {
            int i = 1;
            do {
                System.out.println("\t\tLista de Categorias de Productos");
                for (Categorias categoria : listaCategoria) {
                    System.out.println(i + ".- " + categoria.getNombreCategoria());
                    i++;
                }
                System.out.print("\nIngrese numero de categoria de producto a eliminar :");
                opcion = Integer.parseInt(bf.readLine());
                estado = validarLista(opcion);
                listaCategoria.remove(opcion - 1);
                System.out.println("Categoria eliminada correctamente");
            } while (estado == false);
            do {
                System.out.print("Desea eliminar otra Categoria si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);
        } while (respuesta.equalsIgnoreCase("si"));
        menuInicial();
    }

    private static void eliminarProductos() throws Exception {
        do {
            int i = 1;
            do {
                for (Categorias categoria : listaCategoria) {
                    System.out.println(i + ".- " + categoria.getNombreCategoria());
                    i++;
                }
                System.out.print("Ingrese numero de categoria de producto :");
                opcion = Integer.parseInt(bf.readLine());
                estado = validarLista(opcion);

            } while (estado == false);
            int j = 0;
            System.out.printf("\n\t\tLista de Productos de categorias \"%s\"%n", listaCategoria.get(opcion - 1).getNombreCategoria());
            for (Productos producto : listaCategoria.get(opcion - 1).getListaProductos()) {
                System.out.println(j + ".- " + producto.getNombre());
                j++;
            }
            do {
                System.out.print("\nIngrese numero de producto a eliminar :");
                int opcion2 = Integer.parseInt(bf.readLine());
                estado = validarLista(opcion2);
                listaCategoria.get(opcion - 1).getListaProductos().remove(opcion2 - 1);
                System.out.println("Producto eliminado correctamente");
            } while (estado == false);
            do {
                System.out.print("Desea Eliminar otro Producto si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);
        } while (respuesta.equalsIgnoreCase("si"));
        menuInicial();

    }


}
