public abstract class UcakRezervasyonSistemi {

	// veri tiplerinin tan�mlamalar� yap�l�yor

	private int koltukSayisi;

	// Parametresiz constructor
	private boolean[] koltuklar;

	UcakRezervasyonSistemi() {

	}

	// Parametreli constructor
	UcakRezervasyonSistemi(int koltukSayisi) {

		// koltuk say�s� kontrol� yap�l�yor, 10' dan az ise set metodu ile 10 yap�l�yor.
		if (koltukSayisi < 10) {

			setKoltukSayisi(10);
			System.out.println("Koltuk say�s� hatal�. Otamatik olarak 10 yap�ld�\n");
		}

		// olu�turulan objeden gelen koltuk say�s� 10' dan fazla ise u�a��n koltuk
		// say�s� o oluyor.
		else {

			this.koltukSayisi = koltukSayisi;
		}

		// koltuk say�s� uzunlu�unda koltuklar dizisi olu�turuluyor
		this.koltuklar = new boolean[this.koltukSayisi];

		// varsay�lan olarak false yani koltuklar�n tamam� bo� olarak atan�yor
		for (int i = 0; i < getKoltuklar().length; i++) {
			getKoltuklar()[i] = false;

		}

	}

	// koltuk say�s� atamak i�in set metodu
	public void setKoltukSayisi(int koltukSayisi) {

		this.koltukSayisi = koltukSayisi;

	}

	// koltuk say�s� almak i�in get metodu
	public int getKoltukSayisi() {

		return this.koltukSayisi;
	}

	// ekonomi koltuklar�n�n doluluk kontrol� i�in metod
	public boolean ekonomiDoluMu() {

		boolean ekonomiKoltukDurumu = true;

		for (int i = 5; i < getKoltuklar().length; i++) {
			if (getKoltuklar()[i] == false) {
				ekonomiKoltukDurumu = false;
			}
		}
		return ekonomiKoltukDurumu;
	}

	// ekonomi koltuklar�n�n doluluk kontrol� i�in metod
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

	// u�ak koltuklar�n�n doluluk kontrol� i�in metod
	public boolean ucakDoluMu() {

		boolean ucakKoltukDurumu = true;

		for (int i = 0; i < getKoltuklar().length; i++) {
			if (getKoltuklar()[i] == false) {
				ucakKoltukDurumu = false;
			}
		}

		return ucakKoltukDurumu;

	}

	// bo� koltuklar� yazd�ran metod
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

	// koltuklar boolean dizisi uzunlu�unu almak i�in get metodu
	public boolean[] getKoltuklar() {
		return koltuklar;
	}

	// koltuklar boolean dizisinde herhangi bir koltu�un dolu bo� oldu�unu ��renmek i�in metod
	public boolean getKoltuklar(int i) {
		return this.koltuklar[i - 1];
	}

	// koltuklar boolean dizisine de�er atamak i�in set metodu
	public void setKoltuklar(boolean[] koltuklar, int i) {
		this.koltuklar = koltuklar;
		//se�ilen koltu�un dizi index numaras� i�in 1 ��kar�ld�. 
		this.koltuklar[i - 1] = true;
	}

}
