package yk.GA_Colville_Func;

/**
 * Created by yk on 18/9/2015.
 */
public class FitnessCalc {
    static double solution;

    //Calculate the global minimum value given x1, x2, x3, x4
    static void setSolution(int x1, int x2, int x3, int x4) {
        solution = (100 * (x2 - (x1 * x1)) * (x2 - (x1 * x1))) + ((1 - x1) * (1 - x1)) + 90 * (x4 - (x3 * x3)) * (x4 - (x3 * x3))
                + ((1 - x3) * (1 - x3)) + 10.1 * (((x2 - 1) * (x2 - 1)) * ((x4 - 1) * (x4 - 1))) + 19.8 * (x2 - 1) * (x4 - 1);
    }

    //get the best global minimum value
    static double getSolution() {
        return solution;
    }

    // Calculate individuals fitness by comparing it to our candidate solution
    static double getFitness(Individual individual) {
        double fitness = Math.abs(individual.getSolution() - solution);
        return fitness;
    }
}
