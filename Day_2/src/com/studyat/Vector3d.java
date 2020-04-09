package com.studyat;

public class Vector3d extends AbstractVector3d {
    private double a, b, c;

    public Vector3d(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public Vector3d sumVec(Vector3d x) {
        return new Vector3d(
                this.getA() + x.getA(),
                this.getB() + x.getB(),
                this.getC() + x.getC()
        );
    }

    public Vector3d subVec(Vector3d x) {
        return new Vector3d(
                this.getA() - x.getA(),
                this.getB() - x.getB(),
                this.getC() - x.getC()
        );
    }

    public double scalar(Vector3d x) {
        return a * x.getA() + b * x.getB() + c * x.getC();
    }

    public Vector3d vector(Vector3d x) {
        return new Vector3d(b * x.c - c * x.b, c * x.a - a * x.c, a * x.b - b * x.a);
    }

    @Override
    public String toString() {
        return "Vector3d{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
