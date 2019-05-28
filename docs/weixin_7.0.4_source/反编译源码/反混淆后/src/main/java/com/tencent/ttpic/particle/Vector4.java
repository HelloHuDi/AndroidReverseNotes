package com.tencent.ttpic.particle;

public class Vector4 {
    /* renamed from: a */
    public float f4887a;
    /* renamed from: b */
    public float f4888b;
    /* renamed from: g */
    public float f4889g;
    /* renamed from: r */
    public float f4890r;

    public Vector4(float f, float f2, float f3, float f4) {
        this.f4890r = f;
        this.f4889g = f2;
        this.f4888b = f3;
        this.f4887a = f4;
    }

    public void copy(Vector4 vector4) {
        this.f4890r = vector4.f4890r;
        this.f4889g = vector4.f4889g;
        this.f4888b = vector4.f4888b;
        this.f4887a = vector4.f4887a;
    }
}
