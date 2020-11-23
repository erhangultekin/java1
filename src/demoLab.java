/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoLab;

/**
 *
 * @author Erdur
 */
public class demoLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Round things
		Set round = new Set<String>();
		// Green things
		Set green = new Set<String>();

		// Add some data to both sets
		round.add("peas");
		round.add("ball");
		round.add("pie");
		round.add("grapes");

		green.add("peas");
		green.add("grapes");
		green.add("garden hose");
		green.add("grass");

		System.out.println("Contents of set 'round': ");
		round.output();
		System.out.println("Contents of set 'green': ");
		green.output();
		System.out.println();

		System.out.println("ball in set 'round'? " +
			round.contains("ball"));
		System.out.println("ball in set 'green'? " +
			green.contains("ball"));

		System.out.println("ball and peas in same set? " +
			((round.contains("ball") && (round.contains("peas"))) ||
			 (green.contains("ball") && (green.contains("peas")))));

		System.out.println("pie and grass in same set? " +
			((round.contains("pie") && (round.contains("grass"))) ||
			 (green.contains("pie") && (green.contains("grass")))));

		System.out.print("Union of 'green' and 'round': ");
		round.union(green).output();

		System.out.print("Intersection of 'green' and 'round': ");
		round.intersection(green).output();
                System.out.println("Round kümesinin Green kümesinden farkı");
                round.Fark(green).output();

    }
    
}
