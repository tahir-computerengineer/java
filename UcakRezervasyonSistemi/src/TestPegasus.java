import java.util.Scanner;

public class TestPegasus {

    public static void main(String[] args) {

        UcakRezervasyonSistemi pegasusRezervasyonSistemi = new PegasusRezervasyonSistemi(7);

        Scanner input = new Scanner(System.in);

        String inputKey = "c";

        while(inputKey.equals("c")|| inputKey.equals("C")){
            pegasusRezervasyonSistemi.rezervasyonAl();
            System.out.println("\nDevam etmek i�in c'ye, ��kmak i�in herhangi ba�ka bir tu�a bas�n�z");
            inputKey = input.next();
        }
    }
}
