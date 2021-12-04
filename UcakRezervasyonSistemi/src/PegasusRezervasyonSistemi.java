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

		System.out.println("Pegasus Rezevasyon Sistemine hoþ geldiniz!");

		// ilk olarak ucakDoluMu metodu ile uçaktaki boþ koltuk durumu kontrol ediliyor
		if (ucakDoluMu() == false) {

			System.out.println("Business class uçmak için 0'a basýnýz, ekonomi class uçmak için 1'e basýnýz:");
			// kullanýdan koltuk seçimini alýyoruz
			Scanner input = new Scanner(System.in);

			int ucusTipi = input.nextInt();
			int secilenKoltuk;
			// seçilen uçuþ tipine göre if koþulu ile program dallanýyor
			// business sýnýfý rezervasyonu iþlemleri baþlýyor
			if (ucusTipi == 0) {

				// businessDoluMu metodu ile business class boþ koltuklarý kontrol ediyoruz.
				if (businessDoluMu() == false) {

					System.out.println("Aþaðýdaki boþ koltuklardan birini seçiniz:");
					koltukYazdir(ucusTipi);
					secilenKoltuk = input.nextInt();

					// kullanýcýnýn girdiði koltuk numarasýnýn doðru sýnýfta olup olmadýðýný ve
					// seçilen o sýnýftaki koltuðun daha önce rezerve edilip edilmediðini kontrol ediliyor
					if (secilenKoltuk < 1 || secilenKoltuk > 5 || getKoltuklar(secilenKoltuk) == true) {

						while ((secilenKoltuk < 1 || secilenKoltuk > 5) || getKoltuklar(secilenKoltuk) == true) {
							System.out.println("Yanlýþ koltuk numarasý girildi, tekrar giriniz: ");
							secilenKoltuk = input.nextInt();
						}

					}
					// koltuk rezervasyonu yapýlýyor
					if (secilenKoltuk >= 1 && secilenKoltuk <= 5) {

						setKoltuklar(getKoltuklar(), secilenKoltuk);

						System.out.println("Koltuk No: " + secilenKoltuk + " adýnýza rezerve edildi!");
						System.out.println("Ýyi uçuþlar!");

					}
				}

				else {

					System.out.println("Malesef business koltuklarýmýz dolu! Rezervasyon alamýyoruz!");
				}

			}

			// ekonomi sýnýfý rezervasyonu iþlemleri baþlýyor
			else if (ucusTipi == 1) {

				if (ekonomiDoluMu() == false) {

					// Math.random metodu ile ekonomi sýnýfýn koltuklarýndan rasgele seçim yapýlýyor

					secilenKoltuk = (int) (Math.random() * ((getKoltukSayisi() - 5) + 1) + 5);

					// rasgele seçilen koltuðun daha önce rezerve edilip edilmediði kontrol ediliyor
					while (getKoltuklar(secilenKoltuk) == true) {
						secilenKoltuk = (int) (Math.random() * ((getKoltukSayisi() - 5) + 1) + 5);
					}
					// koltuk rezervasyonu yapýlýyor
					if (secilenKoltuk >= 5 && secilenKoltuk <= getKoltukSayisi()) {

						setKoltuklar(getKoltuklar(), secilenKoltuk);
						System.out.println("Koltuk No: " + secilenKoltuk + " adýnýza rezerve edildi!");
						System.out.println("Ýyi uçuþlar!");

					}
				}

				else {

					System.out.println("Malesef ekonomi koltuklarýmýz dolu! Rezervasyon alamýyoruz!");
				}

			}

		}

		else {

			System.out.println("Malesef uçak dolu, rezervasyon alamýyoruz!");
		}

	}

}
