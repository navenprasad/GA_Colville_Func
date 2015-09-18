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
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return individualList[index];
    }

    public Individual getFittest() {
        Individual fittest = individualList[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int size() {
        return individualList.length;
    }

    public void saveIndividual(int index, Individual individual) {
        individualList[index] = individual;
    }
}
