import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EvidencijaVozila evidencija = new EvidencijaVozila();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Odaberite: ");
            System.out.println("1 za unos vozila ");
            System.out.println("2 za prikaz vozila");
            System.out.println("3 za spremanje vozila u datoteku");
            System.out.println("4 za ucitavanje vozila u datoteku ");
            System.out.println("5 za izlaz");

            int odabir = sc.nextInt();
            sc.nextLine();

            switch (odabir){
                case 1:
                    evidencija.unosVozila();
                    break;

                case 2:
                    evidencija.prikaziVozila();
                    break;
                case 3:
                    evidencija.spremiPodatkeUDaatoteku("vozila.txt");
                    break;
                case 4:
                    evidencija.ucitajPodatkeIzDatoteke("vozila.txt");
                    break;
                case 5:
                    System.out.println("Izlaz");
                    return;
            }

        }
    }
}
