package yk.GA_Colville_Func;

import java.util.Vector;

/**
 * Created by yk on 18/9/2015.
 */
public class Algorithm {

    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // Keep our best individual
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual parent1 = tournamentSelection(pop);
            Individual parent2 = tournamentSelection(pop);
            Individual newIndiv = crossover(parent1, parent2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    private static Individual crossover(Individual parent1, Individual parent2) {
        Individual child = new Individual();

        int startPos = (int) (Math.random() * parent1.size());
        int endPos = (int) (Math.random() * parent1.size());

        // Loop through genes
        for (int i = 0; i < child.size(); i++) {
            // Crossover
            if(startPos < endPos && i > startPos && i < endPos) {
                child.setVariable(i, parent1.getVariable(i));
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setVariable(i, parent1.getVariable(i));
                }
            }
        }

        for(int i = 0; i < parent2.size(); i++) {
            int marker = -99;
            if(child.getVariable(i) == marker) {
                child.setVariable(i, parent2.getVariable(i));
            }
        }

        return child;
    }

    // Mutate an individual
    private static void mutate(Individual indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Create random gene
                int x = (int) Math.round(Math.random()*indiv.getConstraint());
                x *= Math.floor(Math.random()*2) == 1 ? 1 : -1;

                indiv.setVariable(i, x);
            }
        }
    }

    // Select individuals for crossover
    private static Individual tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false);

        Vector<Integer> prevRandomId = new Vector<Integer>();
        boolean check = true;
        int count = 0;

        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize + count; i++) {
            int randomId = (int) (Math.random() * pop.size());
            //To make sure the selected randomId is not repetitive
            int ii = 0;
            while(ii < prevRandomId.size()) {
                int temp = prevRandomId.get(ii);
                ii++;
                if(randomId != temp) {
                    check = true;
                } else {
                    count++;
                    check = false;
                    break;
                }
            }

            if (check) {
                prevRandomId.add(randomId);
                tournament.saveIndividual(i - count, pop.getIndividual(randomId));
            }
        }
        prevRandomId.removeAllElements();
        // Get the fittest
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}
