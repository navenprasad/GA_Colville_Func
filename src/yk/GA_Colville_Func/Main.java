package yk.GA_Colville_Func;

public class Main {

    public static void main(String[] args) {
        // Set a candidate solution
        FitnessCalc.setSolution(1,1,1,1);

        // Initialize population
        Population pop = new Population(500, true);
        System.out.println("Initial solution: " + pop.getFittest().getFitness());

        // Evolve population for the number of generations you set
        int generationCount = 0;
        pop = Algorithm.evolvePopulation(pop);

        for (int i = 0; i < 100; i++) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Local Minimum Value: " + pop.getFittest().getFitness());
            if(pop.getFittest().getFitness() == FitnessCalc.getSolution()) {
                break;
            }
            pop = Algorithm.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Final Outcome:");
        System.out.println("Tournament Size: " + Algorithm.getTournamentSize());
        System.out.println("Mutation Rate: " + Algorithm.getMutationRate());
        System.out.println(pop.getFittest().getVariableList());
        System.out.println("Generation " + generationCount);
        System.out.println("Global Minimum Value result: " + pop.getFittest().getFitness());
        System.out.println("Best Global Minimum Value : " + FitnessCalc.getSolution());
    }
}
