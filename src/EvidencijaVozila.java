import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaVozila {
    ArrayList<Vozilo> listaVozila = new ArrayList<>();

    public void dodajVozilo(Vozilo vozilo){
        listaVozila.add(vozilo);
    }

    public void prikaziVozila(){
       if(listaVozila.isEmpty()){
           System.out.println("Lista je prazna. Nema vozila.");
       } else {
           for (Vozilo v : listaVozila){
               v.prikaziPodatke();
           }
       }
    }

    public void unosVozila(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Odaberite vrstu vozila: 1 - za odabir unosa automobila, broj 2 za unos motocikla, i ako želite izaći iz programa broj 3");

             int odabranoVozilo = sc.nextInt();
             sc.nextLine();

             if(odabranoVozilo == 3) break;

             Vozilo vozilo = null;

             if(odabranoVozilo == 1){
                 Automobil automobil = new Automobil();
                 automobil.ucitajPodatke();
                 dodajVozilo(automobil);
             } else if (odabranoVozilo == 2) {
                 Motocikl motocikl = new Motocikl();
                 motocikl.ucitajPodatke();
                 dodajVozilo(motocikl);
             } else {
                 System.out.println("Pokušajte ponovo");
             }
        }
    }


    public void spremiPodatkeUDaatoteku(String datoteka){
        try(FileWriter izlaz = new FileWriter(datoteka)){
            for (Vozilo v : listaVozila){
                izlaz.write(v.toString() + '\n');
            }
            System.out.println("Podaci su spremljeni" + datoteka);
        } catch (IOException e) {
            System.out.println("Greška kod spremanja podataka" + e.getMessage());
        }
    }

    public void ucitajPodatkeIzDatoteke(String datoteka){
        try(BufferedReader ulaz = new BufferedReader(new FileReader(datoteka))){
            String znakovi;
            int brojLinije = 0;

            while((znakovi = ulaz.readLine()) != null){
                brojLinije++;
                String[] dijelovi = znakovi.split(",");

                if(dijelovi.length < 4){
                    System.out.println("Preskoci red" + brojLinije + " "+ znakovi);
                    continue;
                }

                try {
                    if(dijelovi[0].equals("Automobil") && dijelovi.length == 5){
                        listaVozila.add(new Automobil(
                                dijelovi[1], dijelovi[2], Integer.parseInt(dijelovi[3]), Integer.parseInt(dijelovi[4])
                        ));
                    } else if (dijelovi[0].equals("Motocikl") && dijelovi.length == 5){
                        listaVozila.add(new Motocikl(
                                dijelovi[1], dijelovi[2], Integer.parseInt(dijelovi[3]), dijelovi[4]
                        ));
                    } else {
                        System.out.println("Nije ok");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Greška format" + brojLinije + znakovi);
                }
            }
            System.out.println("Učitano je" + listaVozila.size() + " vozila iz datoteke" + datoteka);
        } catch (FileNotFoundException e) {
            System.out.println("Greška nije pronađen dokument");
        } catch (IOException e) {
            System.out.println("Greška kod učitavanje datoteke");
        }

    }


}
