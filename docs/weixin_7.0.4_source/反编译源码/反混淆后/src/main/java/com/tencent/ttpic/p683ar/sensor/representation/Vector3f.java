package com.tencent.ttpic.p683ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.ttpic.ar.sensor.representation.Vector3f */
public class Vector3f {
    protected float[] points;

    public Vector3f(float f, float f2, float f3) {
        AppMethodBeat.m2504i(81729);
        this.points = new float[3];
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        AppMethodBeat.m2505o(81729);
    }

    public Vector3f(float f) {
        AppMethodBeat.m2504i(81730);
        this.points = new float[3];
        this.points[0] = f;
        this.points[1] = f;
        this.points[2] = f;
        AppMethodBeat.m2505o(81730);
    }

    public Vector3f() {
        AppMethodBeat.m2504i(81731);
        this.points = new float[3];
        AppMethodBeat.m2505o(81731);
    }

    public Vector3f(Vector3f vector3f) {
        AppMethodBeat.m2504i(81732);
        this.points = new float[3];
        this.points[0] = vector3f.points[0];
        this.points[1] = vector3f.points[1];
        this.points[2] = vector3f.points[2];
        AppMethodBeat.m2505o(81732);
    }

    public Vector3f(Vector4f vector4f) {
        AppMethodBeat.m2504i(81733);
        this.points = new float[3];
        if (vector4f.mo71102w() != 0.0f) {
            this.points[0] = vector4f.mo71104x() / vector4f.mo71102w();
            this.points[1] = vector4f.mo71106y() / vector4f.mo71102w();
            this.points[2] = vector4f.mo71108z() / vector4f.mo71102w();
            AppMethodBeat.m2505o(81733);
            return;
        }
        this.points[0] = vector4f.mo71104x();
        this.points[1] = vector4f.mo71106y();
        this.points[2] = vector4f.mo71108z();
        AppMethodBeat.m2505o(81733);
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
        AppMethodBeat.m2504i(81734);
        double sqrt = Math.sqrt((double) (((this.points[0] * this.points[0]) + (this.points[1] * this.points[1])) + (this.points[2] * this.points[2])));
        this.points[0] = (float) (((double) this.points[0]) / sqrt);
        this.points[1] = (float) (((double) this.points[1]) / sqrt);
        this.points[2] = (float) (((double) this.points[2]) / sqrt);
        AppMethodBeat.m2505o(81734);
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

    /* renamed from: x */
    public float mo75741x() {
        return this.points[0];
    }

    /* renamed from: y */
    public float mo75743y() {
        return this.points[1];
    }

    /* renamed from: z */
    public float mo75745z() {
        return this.points[2];
    }

    /* renamed from: x */
    public void mo75742x(float f) {
        this.points[0] = f;
    }

    /* renamed from: y */
    public void mo75744y(float f) {
        this.points[1] = f;
    }

    /* renamed from: z */
    public void mo75746z(float f) {
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
        AppMethodBeat.m2504i(81735);
        vector3f2.setX((this.points[1] * vector3f.points[2]) - (this.points[2] * vector3f.points[1]));
        vector3f2.setY((this.points[2] * vector3f.points[0]) - (this.points[0] * vector3f.points[2]));
        vector3f2.setZ((this.points[0] * vector3f.points[1]) - (this.points[1] * vector3f.points[0]));
        AppMethodBeat.m2505o(81735);
    }

    public float getLength() {
        AppMethodBeat.m2504i(81736);
        float sqrt = (float) Math.sqrt((double) (((this.points[0] * this.points[0]) + (this.points[1] * this.points[1])) + (this.points[2] * this.points[2])));
        AppMethodBeat.m2505o(81736);
        return sqrt;
    }

    public String toString() {
        AppMethodBeat.m2504i(81737);
        String str = "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
        AppMethodBeat.m2505o(81737);
        return str;
    }

    public void set(Vector3f vector3f) {
        AppMethodBeat.m2504i(81738);
        set(vector3f.points);
        AppMethodBeat.m2505o(81738);
    }

    public void set(float[] fArr) {
        AppMethodBeat.m2504i(81739);
        System.arraycopy(fArr, 0, this.points, 0, 3);
        AppMethodBeat.m2505o(81739);
    }
}
