import java.util.Scanner;

public class Automobil extends Vozilo{
    private int brojVrata;

    public Automobil(String registracijskiBroj, String markaVozila, int godinaProizvodnje, int brojVrata) {
        super(registracijskiBroj, markaVozila, godinaProizvodnje);
        this.brojVrata = brojVrata;
    }


    public  Automobil(){
        super();
    }

    @Override
    public void ucitajPodatke() {
        super.ucitajPodatke();
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite broj vrata: ");
        this.brojVrata = sc.nextInt();
        sc.nextLine();

    }

    @Override
    public void prikaziPodatke() {
        //super.prikaziPodatke();
        System.out.println("Vozilo s registracijskom oznakom " + getRegistracijskiBroj() + ", marke " + getMarkaVozila()  + "je iz " + getGodinaProizvodnje() + ". godine i i ma " + getBrojVrata());

    }

    @Override
    public String toString() {
        return "Automobil ima" + getRegistracijskiBroj() + " " + getMarkaVozila() + " " + getGodinaProizvodnje() + " " + getBrojVrata();
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) throws MojaIznimka{
        if (brojVrata < 2 || brojVrata > 6){
            throw new MojaIznimka("Auto ne može imati manje od troje vrata");
        }
        this.brojVrata = brojVrata;
    }
}
