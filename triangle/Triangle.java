/*
 * Person.java        1.1 7/03/2016
 *
 * Copyright 2010-2012 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *                     Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */



/**
 * Modelizes a triangle. The triangle has 3 sides.
 */
public class Triangle {
    /** The triangle's side1 */
    private double side1;
    /** The triangle's side2 */
    private double side2;
    /** The triangle's side3 */
    private double side3;
    

    // Constructors

    public Triangle() {
        this.side1 = 3;
        this.side2 = 4;
        this.side3 = 5;
    }
    
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    //methods
    public double perimeter() {
        return side1 + side2 + side3;
    }
    
    public double area() {
        double semiperimeter = this.perimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
    }
}
