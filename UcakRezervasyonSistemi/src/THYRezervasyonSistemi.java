import java.util.Scanner;

public class THYRezervasyonSistemi extends UcakRezervasyonSistemi {

	// Parametresiz constructor
	public THYRezervasyonSistemi() {
		// TODO Auto-generated constructor stub
	}

	// Parametreli constructor
	public THYRezervasyonSistemi(int koltukSayisi) {
		super(koltukSayisi);

	}

	// rezervasyonAl metodu, UcakRezervasyonSistemi' ndeki abstract metodu override ediyor

	@Override
	void rezervasyonAl() {
		// TODO Auto-generated method stub

		System.out.println("THY Rezevasyon Sistemine hoþ geldiniz!");

		// ilk olarak ucakDoluMu metodu ile uçaktaki boþ koltuk durumu kontrol ediliyor

		if (ucakDoluMu() == false) {

			System.out.println("Business class uçmak için 0'a basýnýz, ekonomi class uçmak için 1'e basýnýz:");

			Scanner input = new Scanner(System.in);

			int ucusTipi = input.nextInt();

			int secilenKoltuk;

			// seçilen uçuþ tipine göre if koþulu ile program dallanýyor
			// business sýnýfý rezervasyonu iþlemleri baþlýyor
			if (ucusTipi == 0) {

				// businessDoluMu metodu ile business class boþ koltuklarý kontrol ediliyor
				if (businessDoluMu() == false) {

					System.out.println("Aþaðýdaki boþ koltuklardan birini seçiniz:");

					// koltuklarý yazdýrmak için bir void metod tanýmlandý
					koltukYazdir(ucusTipi);

					// kullanýcýdan koltuk numarasýný alýnýyor
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

				// ekonomiDoluMu metodu ile business class boþ koltuklarý kontrol ediliyor
				if (ekonomiDoluMu() == false) {

					System.out.println("Aþaðýdaki boþ koltuklardan birini seçiniz:");
					koltukYazdir(ucusTipi);
					secilenKoltuk = input.nextInt();

					// kullanýcýnýn girdiði koltuk numarasýnýn doðru sýnýfta olup olmadýðýný ve
					// seçilen o sýnýftaki koltuðun daha önce rezerve edilip edilmediðini kontrol ediliyor
					if (secilenKoltuk < 5 || secilenKoltuk > getKoltukSayisi() || getKoltuklar(secilenKoltuk) == true) {

						while (secilenKoltuk < 5 || secilenKoltuk > getKoltukSayisi()
								|| getKoltuklar(secilenKoltuk) == true) {
							System.out.println("Yanlýþ koltuk numarasý girildi, tekrar giriniz: ");
							secilenKoltuk = input.nextInt();
						}

					}

					// koltuk rezervasyonu yapýlýyor
					if (secilenKoltuk >= 5 && secilenKoltuk <= getKoltukSayisi()) {

						setKoltuklar(getKoltuklar(), secilenKoltuk);
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
