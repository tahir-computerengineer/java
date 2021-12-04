import java.util.Scanner;

public class PegasusRezervasyonSistemi extends UcakRezervasyonSistemi {

	// Parametresiz constructor
	public PegasusRezervasyonSistemi() {
		// TODO Auto-generated constructor stub
	}

	// Parametreli constructor
	public PegasusRezervasyonSistemi(int koltukSayisi) {
		super(koltukSayisi);
	}

	// rezervasyonAl metodu, UcakRezervasyonSistemi' ndeki abstract metodu override ediyor

	@Override
	void rezervasyonAl() {
		// TODO Auto-generated method stub

		System.out.println("Pegasus Rezevasyon Sistemine ho� geldiniz!");

		// ilk olarak ucakDoluMu metodu ile u�aktaki bo� koltuk durumu kontrol ediliyor
		if (ucakDoluMu() == false) {

			System.out.println("Business class u�mak i�in 0'a bas�n�z, ekonomi class u�mak i�in 1'e bas�n�z:");
			// kullan�dan koltuk se�imini al�yoruz
			Scanner input = new Scanner(System.in);

			int ucusTipi = input.nextInt();
			int secilenKoltuk;
			// se�ilen u�u� tipine g�re if ko�ulu ile program dallan�yor
			// business s�n�f� rezervasyonu i�lemleri ba�l�yor
			if (ucusTipi == 0) {

				// businessDoluMu metodu ile business class bo� koltuklar� kontrol ediyoruz.
				if (businessDoluMu() == false) {

					System.out.println("A�a��daki bo� koltuklardan birini se�iniz:");
					koltukYazdir(ucusTipi);
					secilenKoltuk = input.nextInt();

					// kullan�c�n�n girdi�i koltuk numaras�n�n do�ru s�n�fta olup olmad���n� ve
					// se�ilen o s�n�ftaki koltu�un daha �nce rezerve edilip edilmedi�ini kontrol ediliyor
					if (secilenKoltuk < 1 || secilenKoltuk > 5 || getKoltuklar(secilenKoltuk) == true) {

						while ((secilenKoltuk < 1 || secilenKoltuk > 5) || getKoltuklar(secilenKoltuk) == true) {
							System.out.println("Yanl�� koltuk numaras� girildi, tekrar giriniz: ");
							secilenKoltuk = input.nextInt();
						}

					}
					// koltuk rezervasyonu yap�l�yor
					if (secilenKoltuk >= 1 && secilenKoltuk <= 5) {

						setKoltuklar(getKoltuklar(), secilenKoltuk);

						System.out.println("Koltuk No: " + secilenKoltuk + " ad�n�za rezerve edildi!");
						System.out.println("�yi u�u�lar!");

					}
				}

				else {

					System.out.println("Malesef business koltuklar�m�z dolu! Rezervasyon alam�yoruz!");
				}

			}

			// ekonomi s�n�f� rezervasyonu i�lemleri ba�l�yor
			else if (ucusTipi == 1) {

				if (ekonomiDoluMu() == false) {

					// Math.random metodu ile ekonomi s�n�f�n koltuklar�ndan rasgele se�im yap�l�yor

					secilenKoltuk = (int) (Math.random() * ((getKoltukSayisi() - 5) + 1) + 5);

					// rasgele se�ilen koltu�un daha �nce rezerve edilip edilmedi�i kontrol ediliyor
					while (getKoltuklar(secilenKoltuk) == true) {
						secilenKoltuk = (int) (Math.random() * ((getKoltukSayisi() - 5) + 1) + 5);
					}
					// koltuk rezervasyonu yap�l�yor
					if (secilenKoltuk >= 5 && secilenKoltuk <= getKoltukSayisi()) {

						setKoltuklar(getKoltuklar(), secilenKoltuk);
						System.out.println("Koltuk No: " + secilenKoltuk + " ad�n�za rezerve edildi!");
						System.out.println("�yi u�u�lar!");

					}
				}

				else {

					System.out.println("Malesef ekonomi koltuklar�m�z dolu! Rezervasyon alam�yoruz!");
				}

			}

		}

		else {

			System.out.println("Malesef u�ak dolu, rezervasyon alam�yoruz!");
		}

	}

}
