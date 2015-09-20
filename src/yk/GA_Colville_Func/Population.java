package yk.GA_Colville_Func;

/**
 * Created by yk on 18/9/2015.
 */
public class Population {

    Individual[] individualList;

    //Contructor
    // Create a population
    public Population(int populationSize, boolean initialise) {
        individualList = new Individual[populationSize];

        // Initialise population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateVariables();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return individualList[index];
    }

    //Compare each individual in the population to get the fittest individual
    public Individual getFittest() {
        Individual fittest = individualList[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() > getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }

        return fittest;
    }

    //get the population size
    public int size() {
        return individualList.length;
    }

    //save the individual into population followed given by index
    public void saveIndividual(int index, Individual individual) {
        individualList[index] = individual;
    }
}
