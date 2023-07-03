import java.util.List;

public class MemoryControl {
//Kullanıcı, telefonların 
	//toplam depolama alanını kontrol edebilmeli ve mevcut boş alanı görüntüleyebilmelidir.

	public static void checkStorage(List<Phone> phoneList, int id) {
	    // İlgili telefonu bulun
	    Phone phone = PhoneManagement.findPhoneByID(phoneList, id);

	    // Telefon bulunamadıysa hata mesajı verin ve işlemi sonlandırın
	    if (phone == null) {
	        System.out.println("Telefon bulunamadı.");
	        return;
	    }

	    // Bellek miktarını alın
	    String memory = phone.getMemory();
 	     memory= memory.toUpperCase();

	    int memorySize=0;
	    // Bellek miktarını kontrol edin ve uygun işlemi gerçekleştirin
	    if (memory.endsWith("GB")) {
	        // GB olarak belirtilmiş bellek miktarını alın
	         memorySize = Integer.parseInt(memory.substring(0, memory.length() - 2));

	        // Sonucu ekrana yazdırın
	        System.out.println("Telefonun bellek alanı: " + memorySize + "GB");
	    } else if (memory.endsWith("MB")) {
	        // MB olarak belirtilmiş bellek miktarını GB'ye çevirin
	         memorySize = Integer.parseInt(memory.substring(0, memory.length() - 2)) / 1024;

	        // Sonucu ekrana yazdırın
	        System.out.println("Telefonun bellek alanı: " + memorySize + "GB");
	    } else {
	        // Geçersiz bellek formatı, hata mesajı verin veya gerekli işlemi yapın
	        System.out.println("Geçersiz bellek formatı: " + memory);
	    }
	    
	    // Mevcut boş alanı hesaplamak için toplam depolama alanından kullanılan alanı çıkarın
	    float usedStorage = phone.usageMemory;
	    float freeStorage = memorySize - usedStorage;

	    // Sonucu ekrana yazdırın
	    System.out.println("Total storage: " + memorySize + "GB");
	    System.out.println("Used storage: " + usedStorage + "GB");
	    System.out.println("Free storage: " + freeStorage + "GB");
	}

	
}
