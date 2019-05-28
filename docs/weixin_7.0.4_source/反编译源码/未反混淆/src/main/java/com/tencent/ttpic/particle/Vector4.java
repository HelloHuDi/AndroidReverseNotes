package com.tencent.ttpic.particle;

public class Vector4 {
    public float a;
    public float b;
    public float g;
    public float r;

    public Vector4(float f, float f2, float f3, float f4) {
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.a = f4;
    }

    public void copy(Vector4 vector4) {
        this.r = vector4.r;
        this.g = vector4.g;
        this.b = vector4.b;
        this.a = vector4.a;
    }
}
