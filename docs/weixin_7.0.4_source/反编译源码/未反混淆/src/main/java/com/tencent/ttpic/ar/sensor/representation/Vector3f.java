package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Vector3f {
    protected float[] points;

    public Vector3f(float f, float f2, float f3) {
        AppMethodBeat.i(81729);
        this.points = new float[3];
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        AppMethodBeat.o(81729);
    }

    public Vector3f(float f) {
        AppMethodBeat.i(81730);
        this.points = new float[3];
        this.points[0] = f;
        this.points[1] = f;
        this.points[2] = f;
        AppMethodBeat.o(81730);
    }

    public Vector3f() {
        AppMethodBeat.i(81731);
        this.points = new float[3];
        AppMethodBeat.o(81731);
    }

    public Vector3f(Vector3f vector3f) {
        AppMethodBeat.i(81732);
        this.points = new float[3];
        this.points[0] = vector3f.points[0];
        this.points[1] = vector3f.points[1];
        this.points[2] = vector3f.points[2];
        AppMethodBeat.o(81732);
    }

    public Vector3f(Vector4f vector4f) {
        AppMethodBeat.i(81733);
        this.points = new float[3];
        if (vector4f.w() != 0.0f) {
            this.points[0] = vector4f.x() / vector4f.w();
            this.points[1] = vector4f.y() / vector4f.w();
            this.points[2] = vector4f.z() / vector4f.w();
            AppMethodBeat.o(81733);
            return;
        }
        this.points[0] = vector4f.x();
        this.points[1] = vector4f.y();
        this.points[2] = vector4f.z();
        AppMethodBeat.o(81733);
    }

    public float[] toArray() {
        return this.points;
    }

    public void add(Vector3f vector3f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector3f.points[0];
        fArr = this.points;
        fArr[1] = fArr[1] + vector3f.points[1];
        fArr = this.points;
        fArr[2] = fArr[2] + vector3f.points[2];
    }

    public void add(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + f;
        fArr = this.points;
        fArr[1] = fArr[1] + f;
        fArr = this.points;
        fArr[2] = fArr[2] + f;
    }

    public void subtract(Vector3f vector3f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] - vector3f.points[0];
        fArr = this.points;
        fArr[1] = fArr[1] - vector3f.points[1];
        fArr = this.points;
        fArr[2] = fArr[2] - vector3f.points[2];
    }

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        fArr = this.points;
        fArr[1] = fArr[1] * f;
        fArr = this.points;
        fArr[2] = fArr[2] * f;
    }

    public void normalize() {
        AppMethodBeat.i(81734);
        double sqrt = Math.sqrt((double) (((this.points[0] * this.points[0]) + (this.points[1] * this.points[1])) + (this.points[2] * this.points[2])));
        this.points[0] = (float) (((double) this.points[0]) / sqrt);
        this.points[1] = (float) (((double) this.points[1]) / sqrt);
        this.points[2] = (float) (((double) this.points[2]) / sqrt);
        AppMethodBeat.o(81734);
    }

    public float getX() {
        return this.points[0];
    }

    public float getY() {
        return this.points[1];
    }

    public float getZ() {
        return this.points[2];
    }

    public void setX(float f) {
        this.points[0] = f;
    }

    public void setY(float f) {
        this.points[1] = f;
    }

    public void setZ(float f) {
        this.points[2] = f;
    }

    public float x() {
        return this.points[0];
    }

    public float y() {
        return this.points[1];
    }

    public float z() {
        return this.points[2];
    }

    public void x(float f) {
        this.points[0] = f;
    }

    public void y(float f) {
        this.points[1] = f;
    }

    public void z(float f) {
        this.points[2] = f;
    }

    public void setXYZ(float f, float f2, float f3) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
    }

    public float dotProduct(Vector3f vector3f) {
        return ((this.points[0] * vector3f.points[0]) + (this.points[1] * vector3f.points[1])) + (this.points[2] * vector3f.points[2]);
    }

    public void crossProduct(Vector3f vector3f, Vector3f vector3f2) {
        AppMethodBeat.i(81735);
        vector3f2.setX((this.points[1] * vector3f.points[2]) - (this.points[2] * vector3f.points[1]));
        vector3f2.setY((this.points[2] * vector3f.points[0]) - (this.points[0] * vector3f.points[2]));
        vector3f2.setZ((this.points[0] * vector3f.points[1]) - (this.points[1] * vector3f.points[0]));
        AppMethodBeat.o(81735);
    }

    public float getLength() {
        AppMethodBeat.i(81736);
        float sqrt = (float) Math.sqrt((double) (((this.points[0] * this.points[0]) + (this.points[1] * this.points[1])) + (this.points[2] * this.points[2])));
        AppMethodBeat.o(81736);
        return sqrt;
    }

    public String toString() {
        AppMethodBeat.i(81737);
        String str = "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
        AppMethodBeat.o(81737);
        return str;
    }

    public void set(Vector3f vector3f) {
        AppMethodBeat.i(81738);
        set(vector3f.points);
        AppMethodBeat.o(81738);
    }

    public void set(float[] fArr) {
        AppMethodBeat.i(81739);
        System.arraycopy(fArr, 0, this.points, 0, 3);
        AppMethodBeat.o(81739);
    }
}
