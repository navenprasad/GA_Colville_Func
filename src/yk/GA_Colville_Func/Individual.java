package yk.GA_Colville_Func;

/**
 * Created by yk on 18/9/2015.
 */
public class Individual {
    //value variable
    private int x;
    private double fitness = 0;

    //number of variable
    private int size = 4;
    private int[] variables = new int[size()];

    //Constraints
    private int constraint = 10;

    public Individual() {
        for(int i = 0; i < size(); i++) {
            variables[i] = size + 100;
        }
    }

    //Generate random variable
    public void generateIndividual() {
        for(int i = 0; i < size(); i++) {
            x = (int) Math.round(Math.random()*constraint);
            //Randomize between positive and negative number by multiplying with 1 or -1
            x *= Math.floor(Math.random()*2) == 1 ? 1 : -1;

            variables[i] = x;
        }
    }

    public int getConstraint() {
        return constraint;
    }

    public int size() {
        return size;
    }

    public int getVariable(int index) {
        return variables[index];
    }

    public void setVariable(int index, int value) {
        variables[index] = value;
        fitness = 0;
    }

    public double getSolution() {
        int x1 = variables[0];
        int x2 = variables[1];
        int x3 = variables[2];
        int x4 = variables[3];

        double solution = (100 * (x2 - (x1 * x1)) * (x2 - (x1 * x1))) + ((1 - x1) * (1 - x1)) + 90 * (x4 - (x3 * x3)) * (x4 - (x3 * x3))
                        + ((1 - x3) * (1 - x3)) + 10.1 * (((x2 - 1) * (x2 - 1)) * ((x4 - 1) * (x4 - 1))) + 19.8 * (x2 - 1) * (x4 - 1);

        return solution;
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }
}
