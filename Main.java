package com.company;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	String nombre_P, apellido,nombre_doc, genero, mes,resp;
	int hora, tel, opcion, id, dia;
	boolean salir=false;
	Scanner  sc = new Scanner(System.in);

        HashMap<String, String> agenda_paciente = new HashMap<>();
        HashMap<String ,  Integer> agenda_doctor = new HashMap<>();

        System.out.println("Bienvenido al sistema de agendacion de citas del hospital");

	do {
        System.out.println("Que desea hacer");
        System.out.println("1) Añadir paciente");
        System.out.println("2) Añadir doctor");
        System.out.println("3) Agendar cita");
        System.out.println("4) Listar  pacientes");
        System.out.println("5) Salir");


        try {
            System.out.println("Seleccione una de las opciones");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre");
                    nombre_P = sc.next().toLowerCase().trim();
                    System.out.println("Ingrese apellido");
                    apellido = sc.next().toLowerCase().trim();
                    System.out.println("Ingrese genero");
                    genero = sc.next().toLowerCase().trim();
                    if(!agenda_paciente.containsKey(nombre_P)){
                        agenda_paciente.put(nombre_P.toLowerCase().trim(),apellido);
                        System.out.println("Se ha añadido correctamente\n");
                    }else{
                        System.out.println("Ya existe el paciente\n");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese nombre");
                    nombre_doc= sc.next().toLowerCase().trim();
                    System.out.println("Ingrese el ID");
                    id = sc.nextInt();
                    if(!agenda_doctor.containsKey(nombre_doc)){
                        agenda_doctor.put(nombre_doc.toLowerCase().trim(),id);
                        System.out.println("Se ha añadido correctamente\n");
                    }else{
                        System.out.println("Ya existe el paciente\n");
                    }

                    break;

                case 3:
                    System.out.println("Que dia?");
                    dia =  sc.nextInt();
                    System.out.println("Que mes?");
                    mes  = sc.next();
                    System.out.println("Los doctores dsponibles son los siguientes");
                    System.out.println("ID Nombre");
                    if(agenda_doctor.entrySet().isEmpty()){
                        System.out.println("No hay doctores\n");
                    }else {
                        for (Map.Entry<String, Integer> entry : agenda_doctor.entrySet()) {
                            System.out.println(entry.getKey() +" "+  entry.getValue());
                        }
                    }
                    System.out.println("Que doctor selecciona");
                    resp = sc.next();
                    if(!agenda_doctor.containsKey(resp)) {
                        System.out.println("Doctor asignado\n");
                    }else{
                        System.out.println("Doctor no encontrado");
                    }

                    break;

                case 4:
                    if(agenda_paciente.entrySet().isEmpty()){
                        System.out.println("No hay pacientes\n");
                    }else {
                        for (Map.Entry<String, String> entry : agenda_paciente.entrySet()) {
                            System.out.println("Nombre: " + entry.getKey() + " Apellido: " + entry.getValue());
                        }
                    }
                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Resuesta no valida, intentelo de nuevo\n");
            }

        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número valido");
            sc.next();

        }

    }while (!salir) ;

    }
}
