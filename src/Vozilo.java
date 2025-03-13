import java.util.Scanner;

public class Vozilo {
    private String registracijskiBroj;
    private String markaVozila;
    private int godinaProizvodnje;

    public Vozilo(String registracijskiBroj, String markaVozila, int godinaProizvodnje) {
        this.registracijskiBroj = registracijskiBroj;
        this.markaVozila = markaVozila;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public void ucitajPodatke(){
        Scanner s = new Scanner(System.in);
        System.out.print("Unesite registracijski broj vozila:");
        this.registracijskiBroj = s.nextLine();

        System.out.println("Unesite marku vozila: ");
        this.markaVozila = s.nextLine();

        System.out.println("Unesite godinu proizvodnje vozila: ");
        this.godinaProizvodnje = s.nextInt();

    }

    public void prikaziPodatke(){
        System.out.println("Vaše vozilo je registracije " + registracijskiBroj + " marke " + markaVozila + " proizveden " + godinaProizvodnje + ". godine");
    }

    public String getRegistracijskiBroj() {
        return registracijskiBroj;
    }

    public String getMarkaVozila() {
        return markaVozila;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setRegistracijskiBroj(String registracijskiBroj) {
        this.registracijskiBroj = registracijskiBroj;
    }

    public void setMarkaVozila(String markaVozila) {
        this.markaVozila = markaVozila;
    }


    public Vozilo(){

    }

    public void setGodinaProizvodnje(int godinaProizvodnje) throws MojaIznimka{
        if (godinaProizvodnje < 0){
            throw new MojaIznimka("Greška, godina ne može biti negativna");
        }
        this.godinaProizvodnje = godinaProizvodnje;
    }
}
