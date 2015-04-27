/**
 * 
 * Das Programm ToHex gibt zu einer ganzen Zahl in Dezimaldarstellung
 * ihren Hex-Wert aus. Dabei wird das Divisions-Verfahren rekursive angewendet.
 * 
 * @author Patrick Vesecky
 * @version 1.0
 *
 */
public class ToHex {
	
	
	/**
	 * Konstantendeklaration
	 * @param SECHZEHN ist notwendig für die Division
	 * @param ZEHN, ELF, ZWOELF, ... für die Switchanweisung
	 */
	public static final int SECHZEHN = 16;
	public static final int ZEHN = 10;
	public static final int ELF = 11;
	public static final int ZWOELF = 12;
	public static final int DREIZEHN = 13;
	public static final int VIERZEHN = 14;
	public static final int FUENFZEHN = 15;
	
	
	/**
	 * 
	 * Die Methoden schreibeAufString schreibe Entweder eine Zahl in den Ausgabestring
	 * oder andererseites einen Buchstaben. Mit einem Hilfsstring werden die neuen Zahlen
	 * oder Buchstaben Links in den String angehängt.
	 * 
	 * @param uebergebendeZahl
	 * @param hauptString
	 * 
	 * @return gibt den korrekten HauptString zurück
	 */
	public String schreibeAufString(int uebergebendeZahl, String hauptString){
		String hilfsString = "";
		
		hilfsString = hilfsString + uebergebendeZahl;
		hilfsString = hilfsString + hauptString;
		hauptString = hilfsString;
		
		return hauptString;
	}
	
	
	/**
	 *
	 * * Die Methoden schreibeAufString schreibe Entweder eine Zahl in den Ausgabestring
	 * oder andererseites einen Buchstaben. Mit einem Hilfsstring werden die neuen Zahlen
	 * oder Buchstaben Links in den String angehängt.
	 * 
	 * @param uebergebenderBuchstabe
	 * @param hauptString
	 * 
	 * @return gibt den korrekten HauptString zurück
	 */
	public String schreibeAufString(char uebergebenderBuchstabe, String hauptString){
		String hilfsString = "";
		
		hilfsString = hilfsString + uebergebenderBuchstabe;
		hilfsString = hilfsString + hauptString;
		hauptString = hilfsString;
		
		return hauptString;
	}
	
	
	/**
	 * 
	 * Diese Methode bekommt eine Zahl aus der BerechnungHexZahl an diese Methode weiter und 
	 * diese Entscheidet welche Hexzahl in die Methode schreibeAufString weitergegeben wird.
	 * 
	 * 
	 * @param uebergebendeZahl
	 * @param hauptString
	 * 
	 * @return gibt den korrekten HauptString zurück
	 */
	public String gibtHexZahl(int uebergebendeZahl, String hauptString){
		
			switch(uebergebendeZahl){
	        case ZEHN:
	        	hauptString = schreibeAufString('A', hauptString);
	            break;
	        case ELF:
	        	hauptString = schreibeAufString('B', hauptString);
	            break;
	        case ZWOELF:
	        	hauptString = schreibeAufString('C', hauptString);
	            break;
	        case DREIZEHN:
	        	hauptString = schreibeAufString('D', hauptString);
	            break;
	        case VIERZEHN:
	        	hauptString = schreibeAufString('E', hauptString);
	        	break;
	        case FUENFZEHN:
	        	hauptString = schreibeAufString('F', hauptString);
	        	break;    
	        default:
	        	hauptString = schreibeAufString(uebergebendeZahl, hauptString);
			}
		return hauptString;	
	}
	
	
	/**
	 * 
	 * Diese Methode bekommt aus der Main-Methode eine Zahl übergeben, die diese Methode 
	 * in eine Hex-Zahl umrechnen soll. Intern wird mit der Divisons-Verfahren die Restwerte
	 * an die Methode gib HexZahl weitergegeben. Dachdem die Berechnung fertig ist wird der 
	 * Hauptsting ausgegeben
	 * @param uebergebendeZahl
	 */
	public void berechnungHexZahl(int uebergebendeZahl){
		/**
		 * 
		 * Variablendeklaration und Inistalisierung
		 * 
		 */
		int rest = 1;
		int divisor = 0;
		int dividend = 0;
		String hauptString = "";
		dividend = uebergebendeZahl;
		/**
		 * 
		 * Berechnung des zu übergebenen Wertes(Rest)
		 * für die Methode gibHexZahl
		 * 
		 */
		do{
			divisor = dividend / SECHZEHN;
			rest = dividend - divisor * SECHZEHN;
			hauptString = gibtHexZahl(rest, hauptString);
			dividend = divisor * SECHZEHN / SECHZEHN;	
		}
		while(dividend!=0);
		// Ausgabe des Ergebnisses
		System.out.println("Die Decimalzahl: " + uebergebendeZahl + " ist die Hexadezimalzahl: " + hauptString);
	}
	
	
	/**
	 *
	 * Die Methode main wird vom JVM gestartet und 
     * erzeugt (instantiiert) ein neues ToHex Objekt
     * und ruft direkt die Methode berechnungHexZahl auf
     * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ToHex h = new ToHex();
		h.berechnungHexZahl(78);
	}
}
