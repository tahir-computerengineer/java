import java.util.Scanner;

public class TestTHY {

    public static void main(String[] args) {

        UcakRezervasyonSistemi thyRezervasyonSistemi = new THYRezervasyonSistemi(5);

		        
        Scanner input = new Scanner(System.in);
         
               

        String inputKey = "c";

        while(inputKey.equals("c") || inputKey.equals("C")){
            thyRezervasyonSistemi.rezervasyonAl();
            System.out.println("\nDevam etmek i�in c'ye, ��kmak i�in herhangi ba�ka bir tu�a bas�n�z");
            inputKey = input.next();            
            
        }
  
    }
}
