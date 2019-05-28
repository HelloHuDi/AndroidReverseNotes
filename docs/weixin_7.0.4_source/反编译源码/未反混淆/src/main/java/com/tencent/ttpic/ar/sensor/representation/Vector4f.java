package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Vector4f {
    protected float[] points = new float[]{0.0f, 0.0f, 0.0f, 0.0f};

    public Vector4f(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(81740);
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        this.points[3] = f4;
        AppMethodBeat.o(81740);
    }

    public Vector4f() {
        AppMethodBeat.i(81741);
        this.points[0] = 0.0f;
        this.points[1] = 0.0f;
        this.points[2] = 0.0f;
        this.points[3] = 0.0f;
        AppMethodBeat.o(81741);
    }

    public Vector4f(Vector3f vector3f, float f) {
        AppMethodBeat.i(81742);
        this.points[0] = vector3f.x();
        this.points[1] = vector3f.y();
        this.points[2] = vector3f.z();
        this.points[3] = f;
        AppMethodBeat.o(81742);
    }

    public float[] array() {
        return this.points;
    }

    public void copyVec4(Vector4f vector4f) {
        this.points[0] = vector4f.points[0];
        this.points[1] = vector4f.points[1];
        this.points[2] = vector4f.points[2];
        this.points[3] = vector4f.points[3];
    }

    public void add(Vector4f vector4f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector4f.points[0];
        fArr = this.points;
        fArr[1] = fArr[1] + vector4f.points[1];
        fArr = this.points;
        fArr[2] = fArr[2] + vector4f.points[2];
        fArr = this.points;
        fArr[3] = fArr[3] + vector4f.points[3];
    }

    public void add(Vector3f vector3f, float f) {
        AppMethodBeat.i(81743);
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector3f.x();
        fArr = this.points;
        fArr[1] = fArr[1] + vector3f.y();
        fArr = this.points;
        fArr[2] = fArr[2] + vector3f.z();
        fArr = this.points;
        fArr[3] = fArr[3] + f;
        AppMethodBeat.o(81743);
    }

    public void subtract(Vector4f vector4f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] - vector4f.points[0];
        fArr = this.points;
        fArr[1] = fArr[1] - vector4f.points[1];
        fArr = this.points;
        fArr[2] = fArr[2] - vector4f.points[2];
        fArr = this.points;
        fArr[3] = fArr[3] - vector4f.points[3];
    }

    public void subtract(Vector4f vector4f, Vector4f vector4f2) {
        AppMethodBeat.i(81744);
        vector4f2.setXYZW(this.points[0] - vector4f.points[0], this.points[1] - vector4f.points[1], this.points[2] - vector4f.points[2], this.points[3] - vector4f.points[3]);
        AppMethodBeat.o(81744);
    }

    public void subdivide(Vector4f vector4f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] / vector4f.points[0];
        fArr = this.points;
        fArr[1] = fArr[1] / vector4f.points[1];
        fArr = this.points;
        fArr[2] = fArr[2] / vector4f.points[2];
        fArr = this.points;
        fArr[3] = fArr[3] / vector4f.points[3];
    }

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        fArr = this.points;
        fArr[1] = fArr[1] * f;
        fArr = this.points;
        fArr[2] = fArr[2] * f;
        fArr = this.points;
        fArr[3] = fArr[3] * f;
    }

    public float dotProduct(Vector4f vector4f) {
        return (((this.points[0] * vector4f.points[0]) + (this.points[1] * vector4f.points[1])) + (this.points[2] * vector4f.points[2])) + (this.points[3] * vector4f.points[3]);
    }

    public void lerp(Vector4f vector4f, Vector4f vector4f2, float f) {
        vector4f2.points[0] = (this.points[0] * (1.0f * f)) + (vector4f.points[0] * f);
        vector4f2.points[1] = (this.points[1] * (1.0f * f)) + (vector4f.points[1] * f);
        vector4f2.points[2] = (this.points[2] * (1.0f * f)) + (vector4f.points[2] * f);
        vector4f2.points[3] = (this.points[3] * (1.0f * f)) + (vector4f.points[3] * f);
    }

    public void normalize() {
        AppMethodBeat.i(81745);
        if (this.points[3] == 0.0f) {
            AppMethodBeat.o(81745);
            return;
        }
        float[] fArr = this.points;
        fArr[0] = fArr[0] / this.points[3];
        fArr = this.points;
        fArr[1] = fArr[1] / this.points[3];
        fArr = this.points;
        fArr[2] = fArr[2] / this.points[3];
        double sqrt = Math.sqrt((double) (((this.points[0] * this.points[0]) + (this.points[1] * this.points[1])) + (this.points[2] * this.points[2])));
        this.points[0] = (float) (((double) this.points[0]) / sqrt);
        this.points[1] = (float) (((double) this.points[1]) / sqrt);
        this.points[2] = (float) (((double) this.points[2]) / sqrt);
        AppMethodBeat.o(81745);
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

    public float getW() {
        return this.points[3];
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

    public void setW(float f) {
        this.points[3] = f;
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

    public float w() {
        return this.points[3];
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

    public void w(float f) {
        this.points[3] = f;
    }

    public void setXYZW(float f, float f2, float f3, float f4) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        this.points[3] = f4;
    }

    public boolean compareTo(Vector4f vector4f) {
        if (this.points[0] == vector4f.points[0] && this.points[1] == vector4f.points[1] && this.points[2] == vector4f.points[2] && this.points[3] == vector4f.points[3]) {
            return true;
        }
        return false;
    }

    public void copyFromV3f(Vector3f vector3f, float f) {
        AppMethodBeat.i(81746);
        this.points[0] = vector3f.x();
        this.points[1] = vector3f.y();
        this.points[2] = vector3f.z();
        this.points[3] = f;
        AppMethodBeat.o(81746);
    }

    public String toString() {
        AppMethodBeat.i(81747);
        String str = "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2] + " W:" + this.points[3];
        AppMethodBeat.o(81747);
        return str;
    }
}
