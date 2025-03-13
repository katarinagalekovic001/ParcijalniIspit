import java.util.Scanner;

public class Motocikl extends Vozilo {
    private String tipMotora;

    public Motocikl(String registracijskiBroj, String markaVozila, int godinaProizvodnje, String tipMotora) {
        super(registracijskiBroj, markaVozila, godinaProizvodnje);
        this.tipMotora = tipMotora;
    }

    public Motocikl(){
        super();
    }
    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }


    @Override
    public void ucitajPodatke() {
        super.ucitajPodatke();
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite tip motora");
        this.tipMotora = sc.nextLine();
    }

    @Override
    public void prikaziPodatke() {
       // super.prikaziPodatke();
        System.out.println("Vozilo s registracijskom oznakom " + getRegistracijskiBroj() + ", marke " + getMarkaVozila()  + "je iz " + getGodinaProizvodnje() + ". godine i ima " + getTipMotora());
    }

    @Override
    public String toString() {
        return "Motocikl ima " + getRegistracijskiBroj() + ", " + getMarkaVozila() + ", " + getGodinaProizvodnje() + " i " +  getTipMotora();

    }
}
