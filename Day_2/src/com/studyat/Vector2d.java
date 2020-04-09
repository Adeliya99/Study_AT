package com.studyat;

public class Vector2d extends AbstractVector2d{

    private double a, b;
    public Vector2d(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Vector2d sumVec(Vector2d x) {
        return new Vector2d(
                this.getA() + x.getA(),
                this.getB() + x.getB()
        );
    }


    public Vector2d subVec(Vector2d x) {
        return new Vector2d(
                this.getA() - x.getA(),
                this.getB() - x.getB()
                );
        }

    public double scalar(Vector2d x) {
       return a * x.getA() + b * x.getB();
    }

    @Override
    public String toString() {
        return "Vector2d{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
