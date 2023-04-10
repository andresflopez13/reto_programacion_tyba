package co.com.tyba.reto.data;

import co.com.tyba.reto.model.Persona;
import co.com.tyba.reto.model.Producto;
import co.com.tyba.reto.model.TipoDocumento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivosCsv {

    public void escribirArchivoPersonas(ArrayList<Persona> personas){
        String directorio = System.getProperty("user.dir")+"recursos";
        File file = new File(directorio + "/personas.csv");
        try (FileWriter fileWriter = new FileWriter(file)){
            for (Persona persona : personas){
                fileWriter.write(persona.toCSV() + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException("Se ha produccido un error al escribir el archivo",e);
        }
    }

    public ArrayList<Persona> leerArchivoPersonas(){
        ArrayList<Persona> personas = new ArrayList<>();
        Persona persona;
        String [] datos;
        try (Scanner scannerFile = new Scanner(new File("./src/co/com/tyba/reto/resources/personas.csv"))){
            while (scannerFile.hasNextLine()){
             datos = scannerFile.nextLine().split(";");
             persona = new Persona(datos[0],datos[1],datos[2],datos[3],Double.parseDouble(datos[4]));
             personas.add(persona);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Se ha produccido un error al leer el archivo de personas",e);
        }
        System.out.println("Listado de personas cargadas correctamente....");
        return personas;
    }

    public  ArrayList<Producto> leerArchivoProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto;
        String [] datos;
        try (Scanner scannerFile = new Scanner(new File("./src/co/com/tyba/reto/resources/productos.csv"))){
            while (scannerFile.hasNextLine()){
                datos = scannerFile.nextLine().split(";");
                producto = new Producto(datos[0],Double.parseDouble(datos[1]),Double.parseDouble(datos[2]),
                        Float.parseFloat(datos[3]), datos[4]);
                productos.add(producto);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Se ha produccido un error al leer el archivo de productos",e);
        }
        System.out.println("Productos cargados correctamente....");
        return productos;
    }

    public  ArrayList<TipoDocumento> leerArchivoTiposDocumentos(){
        ArrayList<TipoDocumento> tiposDocumentos = new ArrayList<>();
        TipoDocumento tipoDocumento;
        String [] datos;
        try (Scanner scannerFile = new Scanner(new File("./src/co/com/tyba/reto/resources/tiposDocumentos.csv")
        )){
            while (scannerFile.hasNextLine()){
                datos = scannerFile.nextLine().split(";");
                tipoDocumento = new TipoDocumento(datos[0],Boolean.parseBoolean(datos[1]));
                tiposDocumentos.add(tipoDocumento);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Se ha produccido un error al leer el archivo de tipos de documentos",e);
        }
        System.out.println("Tipos de documentos cargados correctamente....");
        return tiposDocumentos;
    }
}
