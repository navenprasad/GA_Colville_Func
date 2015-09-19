package yk.GA_Colville_Func;

public class Main {

    public static void main(String[] args) {
        // Set a candidate solution
        FitnessCalc.setSolution(1,1,1,1);

        // Create an initial population
        // Population myPop = new Population(50, true);

        // Evolve our population until we reach an optimum solution
/*        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }*/

        // Initialize population
        Population pop = new Population(100, true);
        System.out.println("Initial solution: " + pop.getFittest().getFitness());

        // Evolve population for 100 generations
        int generationCount = 0;
        pop = Algorithm.evolvePopulation(pop);

        for (int i = 0; i < 50; i++) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Local Minimum Value: " + pop.getFittest().getFitness());
            pop = Algorithm.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final Outcome:");
        System.out.println(pop.getFittest().getVariableList());
        System.out.println("Global Minimum Value : " + pop.getFittest().getFitness());
        System.out.println("Best global minimum value : " + FitnessCalc.getSolution());
    }
}
