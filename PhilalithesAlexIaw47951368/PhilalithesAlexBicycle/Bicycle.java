/*
 * Bicycle.java
 * 
 * Copyright 2010-2012 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */


/**
 * Modelizes a bicycle.
 * 
 * A bicycle has a model, rear and front sprockets that may be changed if the bicycle is moving and can be accelerated
 * or braked. The minimum rear and front sprockets have number 1. The second rear and front sprockets have number 2 and
 * so on.
 */
public class Bicycle {

    /** The bicycle's model. */
    private String model;
    /** The engaged front sprocket. */
    private int frontSprocket;
    /** The engaged rear sprocket. */
    private int rearSprocket;
    /** The number of front sprockets the bicyle has. */
    private final int nFrontSprockets;
    /** The number of rear sprockets the bicyle has. */
    private final int nRearSprockets;
    /** The bicycle's speed in km/h. */
    private double v;
    /** The maximum speed of the bicycle */
    private final static int VMAX = 100;
    /** Increment of the bicycle speed */
    private final static int DV = 5;

    /**
     * Constructor by default. Creates a stopped mountain bike with 3 front sprockets, 7 rear sprockets and with the
     * first front and rear sprockets engaged.
     */
    public Bicycle() {
        this.model = "Mountain bike";
        this.frontSprocket = 3;
        this.rearSprocket = 3;
        this.nFrontSprockets = 3;
        this.nRearSprockets = 7;
        this.v = 0;
    }

    /**
     * Constructor. Creates a mountain bike with the first rear sprocket engaged and the last front sprocket engaged
     * 
     * @param nFrontSprockets The number of front sprockets of the bicycle.
     * @param nRearSprockets the number of rear sprockets of the bicycle..
     * @param v The bicycle's speed in km/h.
     */
    public Bicycle(int nFrontSprockets, int nRearSprockets, double v) {
        this.model = "Mountain bike";
        this.nFrontSprockets = nFrontSprockets;
        if (nRearSprockets <= 3) {
            this.nRearSprockets = nRearSprockets;
        } else {
            this.nRearSprockets = 3;
        }
        this.frontSprocket = nFrontSprockets;
        this.rearSprocket = 1;
        this.v = v;
    }

    /**
     * Constructor.
     * 
     * @param model The bicycle's model.
     * @param frontSprocket The engaged front sprocket.
     * @param rearSprocket The rear front sprocket.
     * @param nFrontSprockets The number of front sprockets the bicyle has.
     * @param nRearSprockets The number of rear sprockets the bicyle has.
     * @param v The bicycle's speed in km/h.
     */
    public Bicycle(String model, int frontSprocket, int rearSprocket, int nFrontSprockets, int nRearSprockets, double v) {
        this.model = model;
        
        this.nFrontSprockets = nFrontSprockets;
        if (nRearSprockets <= 3) {
            this.nRearSprockets = nRearSprockets;
        } else {
            this.nRearSprockets = 3;
        }
        if (frontSprocket < 1) {
            this.frontSprocket = 1;
        } else if (frontSprocket > nFrontSprockets) {
            this.frontSprocket = this.nFrontSprockets;
        } else {
            this.frontSprocket = frontSprocket;
        }
        if (frontSprocket < 1) {
            this.rearSprocket = 1;
        } else if (frontSprocket > nRearSprockets) {
            this.rearSprocket = this.nRearSprockets;
        } else {
            this.rearSprocket = rearSprocket;
        }
        this.v = v;
    }

    /**
     * Changes the engaged front sprocket. Increases or decreases the front sprocket by 1. The bicycle can't be stopped.
     * 
     * @param n A number that indicates if the front sprocket must be increased or decreased. If n is positive the front
     *        sprocket will be increased. If n is negative the front sprocket will be decreased. If n is 0, the front
     *        sprocket won't be changed.
     * @return true if the front sprocket is changed, false otherwise.
     */
    public boolean changeFrontSprocket(int n) {
        boolean isChanged = true;
        if (this.frontSprocket < this.nFrontSprockets && n > 0 && this.v > 0) {
            this.frontSprocket++;
        } else if (this.frontSprocket > 1 && n < 0 && this.v > 0) {
            this.frontSprocket--;
        } else {
            isChanged = false;
        }
        return isChanged;
    }

    /**
     * Changes the engaged rear sprocket. Increases or decreases the rear sprocket by 1. The bicycle can't be stopped.
     * 
     * @param n A number that indicates if the rear sprocket must be increased or decreased. If n is positive the rear
     *        sprocket will be increased. If n is negative the rear sprocket will be decreased. If n is 0, the rear
     *        sprocket won't be changed.
     * @return true if the rear sprocket is changed, false otherwise.
     */
    public boolean changeRearSprocket(int num) {
        boolean isChanged = true;
        if (rearSprocket < nRearSprockets && num > 0 && v > 0) {
            rearSprocket++;
        } else if (rearSprocket > 1 && num < 0 && v > 0) {
            rearSprocket--;
        } else {
            isChanged = false;
        }
        return isChanged;
    }

    /**
     * Accelerates the bicycle.
     */
    public void accelerate() {
        double newV = this.v + Bicycle.DV;
        if (newV > Bicycle.VMAX)
            newV = Bicycle.VMAX;
        this.v = newV;
    }

    /**
     * Decreases the velocity of the bicycle.
     */
    public void brake() {
        double newV = this.v - Bicycle.DV;
        if (newV < 0)
            newV = 0;
        this.v = newV;
    }

    // Setter and getters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model.trim();
    }

    public int getRearSprocket() {
        return rearSprocket;
    }

    //modificat
    public void setRearSprocket(int rearSprocket) {
        if (rearSprocket >= 1 && rearSprocket <= this.nRearSprockets){
            this.rearSprocket = rearSprocket;
        }
    }

    public int getFrontSprocket() {
        return frontSprocket;
    }

    //modificat
    public void setFrontSprocket(int frontSprocket) {
        if (frontSprocket >= 1 && frontSprocket <= this.nFrontSprockets){
            this.frontSprocket = frontSprocket;
        }
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }
    
    //metode nou stop
    public void stop() {
        this.v = 0;
    }
    
    //metode nou slowDown
    public boolean slowDown() {
        boolean hasChanged = false;
        if (this.frontSprocket != 1) { //si no tenim el plat més petit
            while (this.rearSprocket < this.nRearSprockets - 1) { //fins que tinguem el segon pinyó més gran
                this.changeRearSprocket(1); //pujem pinyó
            }
            while (this.frontSprocket > 1) { //fins que tenim el plat més petit
                this.changeFrontSprocket(-1); //baixem plat
            }
            hasChanged = true;
        } else { //si tenim el plat més petit
            while (this.rearSprocket < this.nRearSprockets) { //fins que tinguem el pinyó més gran
                this.changeRearSprocket(1);//pujem pinyó
            }
            hasChanged = true;
        }
        return hasChanged;
    }
    
    //metode nou speedUp
    public boolean speedUp() {
        boolean hasChanged = false;
        if (this.frontSprocket != this.nFrontSprockets) {  //si no tenim el plat més gran
            while (this.rearSprocket > 2) { //fins que tinguem el segon pinyó més petit
                this.changeRearSprocket(-1); //baixem pinyó
            }
            while (this.frontSprocket > this.nFrontSprockets) { //fins que tenim el plat més gran
                this.changeFrontSprocket(1); //pujem plat
            }
            hasChanged = true;
        } else { //si tenim el plat més gran
            while (this.rearSprocket < 1) { //fins que tinguem el pinyó més petit
                this.changeRearSprocket(-1); //baixem pinyó
            }
            hasChanged = true;
        }
        return hasChanged;
    }
}
