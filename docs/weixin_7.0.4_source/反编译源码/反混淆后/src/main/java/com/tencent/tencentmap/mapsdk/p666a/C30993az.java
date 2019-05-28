package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.tencentmap.mapsdk.a.az */
public class C30993az {
    /* renamed from: K */
    protected float f13961K = 1.0f;
    /* renamed from: L */
    protected int f13962L = Color.argb(17, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    /* renamed from: M */
    protected int f13963M = Color.argb(255, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    /* renamed from: N */
    protected float f13964N = 0.0f;
    /* renamed from: O */
    protected boolean f13965O = true;
    /* renamed from: P */
    protected boolean f13966P = false;
    /* renamed from: Q */
    protected int f13967Q = C24347di.f4623c;

    public C30993az() {
        AppMethodBeat.m2504i(100726);
        AppMethodBeat.m2505o(100726);
    }

    /* renamed from: a */
    public void mo29442a(boolean z) {
        this.f13965O = z;
    }

    /* renamed from: D */
    public float mo50172D() {
        return this.f13964N;
    }

    /* renamed from: d */
    public void mo50177d(float f) {
        this.f13961K = f;
        this.f13966P = true;
    }

    /* renamed from: c */
    public void mo50176c(int i) {
        this.f13963M = i;
        this.f13966P = true;
    }

    /* renamed from: d */
    public void mo50178d(int i) {
        this.f13962L = i;
        this.f13966P = true;
    }

    /* renamed from: c */
    public void mo50175c(float f) {
        this.f13964N = f;
        this.f13966P = true;
    }

    /* renamed from: a_ */
    public void mo50174a_(int i) {
        this.f13967Q = i;
        this.f13966P = true;
    }

    /* renamed from: E */
    public int mo50173E() {
        return this.f13967Q;
    }
}
