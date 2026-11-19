package dam.castellet2627.view;

import java.util.List;
import java.util.Scanner;

import dam.castellet2627.Atleta;
import dam.castellet2627.Esport;

public class View {
    private Scanner scanner = new Scanner(System.in);

    // Форма добавления нового вида спорта
    public Esport EsportForm() {
        System.out.print("Introdueix el nom del nou esport: ");
        String nombre = scanner.nextLine();
        return new Esport(nombre);
    }

    // Форма добавления нового атлета
    public Atleta AtletaForm() {
        System.out.print("Introdueix el nom de l'atleta: ");
        String nombre = scanner.nextLine();
        System.out.print("Introdueix l'ID (codi) de l'esport: ");
        int codDeporte = Integer.parseInt(scanner.nextLine());
        return new Atleta(nombre, codDeporte);
    }

    // Запрос ID спорта для фильтрации атлетов
    public int DemanaEsport() {
        System.out.print("Introdueix l'ID de l'esport del qual vols veure els atletes: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Вывод нумерованного списка видов спорта
    public void LlistaEsports(List<Esport> esports) {
        System.out.println("\n--- LLISTA D'ESPORTS ---");
        for (Esport e : esports) {
            System.out.println(e.getId() + ". " + e.getNombre());
        }
    }

    // Вывод списка атлетов
    public void LlistaAtletes(List<Atleta> atletes) {
        System.out.println("\n--- LLISTA D'ATLETES ---");
        if (atletes.isEmpty()) {
            System.out.println("No hi ha atletes registrats per a aquest esport.");
        } else {
            for (Atleta a : atletes) {
                System.out.println("- " + a.getNombre() + " (Codi Esport: " + a.getCodDeporte() + ")");
            }
        }
    }
}