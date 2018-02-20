/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavapwsperiodictable;

import java.util.Scanner;

/**
 *
 * @author entrar
 */
public class ClientJavaPWSPeriodicTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Elija el servicio a usar: 1 getAtomicNumber \n "
                + "2 getAtomicWight \n 3 getAtoms \n 4 getElementSymbol \n");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTeclado = entradaEscaner.nextLine ();
        switch(entradaTeclado){
            case "1": System.out.println("Introduzca un elemento");
                    entradaEscaner = new Scanner (System.in);
                    entradaTeclado = entradaEscaner.nextLine ();
                    String response2 = getAtomicNumber(entradaTeclado);
                    if (!response2.equals("<NewDataSet />")) {
                        String atomicNumber = parseResponse(response2, "</AtomicNumber>");
                        System.out.println("Element atomic number is: " + atomicNumber);
                    }
                    break;
            case "2": System.out.println("Introduzca un elemento");
                    entradaEscaner = new Scanner (System.in);
                    entradaTeclado = entradaEscaner.nextLine ();
                    System.out.println(getAtomicWeight(entradaTeclado));
                    break;
            case "3":System.out.println(getAtoms());
                    break;
            case "4":System.out.println("Introduzca un elemento");
                    entradaEscaner = new Scanner (System.in);
                    entradaTeclado = entradaEscaner.nextLine ();
                    System.out.println(getElementSymbol(entradaTeclado));
                    break;
            default:System.out.println("Numero incorrecto \n");
                    
        }
    }

    private static String getAtomicNumber(java.lang.String elementName) {
        clientjavapwsperiodictable.Periodictable service = new clientjavapwsperiodictable.Periodictable();
        clientjavapwsperiodictable.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String getAtomicWeight(java.lang.String elementName) {
        clientjavapwsperiodictable.Periodictable service = new clientjavapwsperiodictable.Periodictable();
        clientjavapwsperiodictable.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicWeight(elementName);
    }

    private static String getAtoms() {
        clientjavapwsperiodictable.Periodictable service = new clientjavapwsperiodictable.Periodictable();
        clientjavapwsperiodictable.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtoms();
    }

    private static String getElementSymbol(java.lang.String elementName) {
        clientjavapwsperiodictable.Periodictable service = new clientjavapwsperiodictable.Periodictable();
        clientjavapwsperiodictable.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }
  

    private static String parseResponse(String response, String endTag) {
        String beginTag = endTag.replace("/", "");
        final int from = response.indexOf(beginTag);
        final int to = response.lastIndexOf(endTag);
        final String beginTagAndContent = response.substring(from, to);
        return beginTagAndContent.substring(beginTagAndContent.indexOf(">") + 1);
    }   
    
}
