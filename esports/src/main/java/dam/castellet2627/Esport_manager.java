package dam.castellet2627;

import java.util.List;
import java.util.Scanner;

import dam.castellet2627.view.View;

public class Esport_manager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        EsportDAO esportDAO = new EsportDAO();
        AtletaDAO atletaDAO = new AtletaDAO();

        int opcio = 0;

        do {
            System.out.println("\n===== GESTIÓ D'ESPORTS I ATLETES =====");
            System.out.println("1. Afegir un esport");
            System.out.println("2. Afegir un atleta (PreparedStatement)");
            System.out.println("3. Llistar tots els esports");
            System.out.println("4. Llistar atletes per esport");
            System.out.println("5. Sortir");
            System.out.print("Tria una opció: ");

            try {
                opcio = Integer.parseInt(scanner.nextLine());

                switch (opcio) {
                    case 1:
                        Esport nouEsport = view.EsportForm();
                        esportDAO.add(nouEsport);
                        break;

                    case 2:
                        EsportFormAction(view, esportDAO, atletaDAO);
                        break;

                    case 3:
                        List<Esport> esports = esportDAO.getAll();
                        view.LlistaEsports(esports);
                        break;

                    case 4:
                        // Сначала выводим список видов спорта, чтобы пользователь видел ID
                        List<Esport> esportsList = esportDAO.getAll();
                        view.LlistaEsports(esportsList);
                        
                        // Запрашиваем ID спорта и выводим его атлетов
                        int esportId = view.DemanaEsport();
                        List<Atleta> atletesByEsport = atletaDAO.getAtletesByEsport(esportId);
                        view.LlistaAtletes(atletesByEsport);
                        break;

                    case 5:
                        System.out.println("Fins a reveure!");
                        break;

                    default:
                        System.out.println("Opció no vàlida. Torna a provar.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcio != 5);
        
        scanner.close();
    }

    private static void EsportFormAction(View view, EsportDAO esportDAO, AtletaDAO atletaDAO) {
        // Показываем список доступных видов спорта, чтобы знать ID для атлета
        List<Esport> esports = esportDAO.getAll();
        view.LlistaEsports(esports);
        
        Atleta nouAtleta = view.AtletaForm();
        atletaDAO.add(nouAtleta);
    }
}