/**
 * @author Finn Mueller
 * @id 11934549
 */

public class HausverwaltungClient {

	public static void main(String[] args) {
		try{
			if (args.length > 1) {
				Hausverwaltung hausverwaltung = new Hausverwaltung(args[0]);
				String part1 = args[1];

				switch(part1){
					case "list":
						if (args.length == 2) {
							hausverwaltung.printAll();
						}

						if (args.length == 3) {
							hausverwaltung.printById(Integer.parseInt(args[2]));
						}
						break;
					case "delete":
						int i = Integer.parseInt(args[2]);
						hausverwaltung.delete(i);
						break;
					case "oldest":
						for(int f :hausverwaltung.oldest()){
							System.out.println("Id: " + f);
						}

						break;
					case "meancosts":
						System.out.println(hausverwaltung.meancosts());
						break;
					case "add":
						if(args[2].equals("EW")){
							try{
								hausverwaltung.add(new EigentumsWohnung(Integer.parseInt(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), args[9],
										Integer.parseInt(args[10]), Integer.parseInt(args[11]), Double.parseDouble(args[12]), Double.parseDouble(args[13])));
							}
							catch(Exception e){
								System.out.println(e.getMessage());
							}
						}
						try{
							if(args[2].equals("MW")){
								hausverwaltung.add(new MietWohnung(Integer.parseInt(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), args[9],
										Integer.parseInt(args[10]), Integer.parseInt(args[11]), Double.parseDouble(args[12]), Integer.parseInt(args[13])));
							}
						} catch(NumberFormatException e){
							System.out.println("Error: Parameter ungueltig.");
						}
						break;
					case "count":
						if(args.length > 2) {
							if (args[2].equals("EW")) {
								System.out.println(hausverwaltung.count("EW"));
							}

							if (args[2].equals("MW")) {
								System.out.println(hausverwaltung.count("MW"));
							}
						}
						else {
							System.out.println(hausverwaltung.count());
						}
						break;
					default:
						throw new IllegalArgumentException("Error: Parameter ungueltig.");
				}
			}
			else{
				throw new IllegalArgumentException("Error: Parameter ungueltig.");
			}
		} catch (Exception e){
			System.out.println("Error: Parameter ungueltig.");
		}
	}
}
