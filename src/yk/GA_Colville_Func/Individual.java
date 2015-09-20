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
            variables[i] = -99;
        }
    }

    //Generate random variable
    public void generateVariables() {
        for(int i = 0; i < size(); i++) {
            //If constraint is 10, x value will be between -10 and 10
            x = (int) Math.round(Math.random()*constraint);

            //Randomize between positive and negative number by multiplying with 1 or -1
            x *= Math.floor(Math.random()*2) == 1 ? 1 : -1;

            variables[i] = x;
        }
    }

    //get the constraint value
    public int getConstraint() {
        return constraint;
    }

    //get the size of individual
    public int size() {
        return size;
    }

    //get a particular x value, ex:0 = x1, 1 = x2, 2 = x3, 3 = x4
    public int getVariable(int index) {
        return variables[index];
    }

    //set x value
    public void setVariable(int index, int value) {
        variables[index] = value;
        fitness = 0;
    }

    //Get the global minimum value of this particular individual(combination of x)
    public double getSolution() {
        int x1 = this.variables[0];
        int x2 = this.variables[1];
        int x3 = this.variables[2];
        int x4 = this.variables[3];

        double solution = (100 * (x2 - (x1 * x1)) * (x2 - (x1 * x1))) + ((1 - x1) * (1 - x1)) + 90 * (x4 - (x3 * x3)) * (x4 - (x3 * x3))
                        + ((1 - x3) * (1 - x3)) + 10.1 * (((x2 - 1) * (x2 - 1)) * ((x4 - 1) * (x4 - 1))) + 19.8 * (x2 - 1) * (x4 - 1);

        return solution;
    }

    //Compare the global minimum value with the best global minimum value, 0
    public double getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    //Print out all the x value contained in this object
    public String getVariableList() {
        int x1 = this.variables[0];
        int x2 = this.variables[1];
        int x3 = this.variables[2];
        int x4 = this.variables[3];

        String msg = "(x1, x2, x3, x4) = " + "(" + x1 + ", " + x2 + ", " + x3 + ", " + x4 +")";

        return msg;
    }
}
