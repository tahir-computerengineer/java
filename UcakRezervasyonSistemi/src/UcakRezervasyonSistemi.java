public abstract class UcakRezervasyonSistemi {

	// veri tiplerinin tanýmlamalarý yapýlýyor

	private int koltukSayisi;

	// Parametresiz constructor
	private boolean[] koltuklar;

	UcakRezervasyonSistemi() {

	}

	// Parametreli constructor
	UcakRezervasyonSistemi(int koltukSayisi) {

		// koltuk sayýsý kontrolü yapýlýyor, 10' dan az ise set metodu ile 10 yapýlýyor.
		if (koltukSayisi < 10) {

			setKoltukSayisi(10);
			System.out.println("Koltuk sayýsý hatalý. Otamatik olarak 10 yapýldý\n");
		}

		// oluþturulan objeden gelen koltuk sayýsý 10' dan fazla ise uçaðýn koltuk
		// sayýsý o oluyor.
		else {

			this.koltukSayisi = koltukSayisi;
		}

		// koltuk sayýsý uzunluðunda koltuklar dizisi oluþturuluyor
		this.koltuklar = new boolean[this.koltukSayisi];

		// varsayýlan olarak false yani koltuklarýn tamamý boþ olarak atanýyor
		for (int i = 0; i < getKoltuklar().length; i++) {
			getKoltuklar()[i] = false;

		}

	}

	// koltuk sayýsý atamak için set metodu
	public void setKoltukSayisi(int koltukSayisi) {

		this.koltukSayisi = koltukSayisi;

	}

	// koltuk sayýsý almak için get metodu
	public int getKoltukSayisi() {

		return this.koltukSayisi;
	}

	// ekonomi koltuklarýnýn doluluk kontrolü için metod
	public boolean ekonomiDoluMu() {

		boolean ekonomiKoltukDurumu = true;

		for (int i = 5; i < getKoltuklar().length; i++) {
			if (getKoltuklar()[i] == false) {
				ekonomiKoltukDurumu = false;
			}
		}
		return ekonomiKoltukDurumu;
	}

	// ekonomi koltuklarýnýn doluluk kontrolü için metod
	public boolean businessDoluMu() {

		boolean businessKoltukDurumu = true;

		for (int i = 0; i <= 4; i++) {
			if (getKoltuklar()[i] == false) {
				// System.out.print((i+1) + " ");
				businessKoltukDurumu = false;
			}
		}

		return businessKoltukDurumu;
	}

	// uçak koltuklarýnýn doluluk kontrolü için metod
	public boolean ucakDoluMu() {

		boolean ucakKoltukDurumu = true;

		for (int i = 0; i < getKoltuklar().length; i++) {
			if (getKoltuklar()[i] == false) {
				ucakKoltukDurumu = false;
			}
		}

		return ucakKoltukDurumu;

	}

	// boþ koltuklarý yazdýran metod
	public void koltukYazdir(int ucustipi) {

		if (ucustipi == 0) {
			for (int i = 0; i <= 4; i++) {
				if (getKoltuklar()[i] == false) {
					System.out.print(i + 1 + " ");

				}
			}
		} else {
			for (int i = 5; i < getKoltuklar().length; i++) {
				if (getKoltuklar()[i] == false) {
					System.out.print(i + 1 + " ");
				}
			}
		}

		System.out.println();
	}

	// abstract soyut rezervasyonAl metodu
	abstract void rezervasyonAl();

	// koltuklar boolean dizisi uzunluðunu almak için get metodu
	public boolean[] getKoltuklar() {
		return koltuklar;
	}

	// koltuklar boolean dizisinde herhangi bir koltuðun dolu boþ olduðunu öðrenmek için metod
	public boolean getKoltuklar(int i) {
		return this.koltuklar[i - 1];
	}

	// koltuklar boolean dizisine deðer atamak için set metodu
	public void setKoltuklar(boolean[] koltuklar, int i) {
		this.koltuklar = koltuklar;
		//seçilen koltuðun dizi index numarasý için 1 çýkarýldý. 
		this.koltuklar[i - 1] = true;
	}

}
