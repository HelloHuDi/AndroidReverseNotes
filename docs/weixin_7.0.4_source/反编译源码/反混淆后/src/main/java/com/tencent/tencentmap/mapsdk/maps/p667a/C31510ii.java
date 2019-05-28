package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ii */
public class C31510ii extends C31056if {
    /* renamed from: e */
    private float f14410e = 0.0f;
    /* renamed from: f */
    private float f14411f = 0.0f;
    /* renamed from: g */
    private float f14412g = 0.0f;
    /* renamed from: h */
    private float f14413h = 0.0f;
    /* renamed from: i */
    private float f14414i = 0.0f;

    public C31510ii(float f, float f2, float f3, float f4, float f5) {
        this.f14410e = f;
        this.f14411f = f2;
        this.f14412g = f3;
        this.f14413h = f4;
        this.f14414i = f5;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29509a(float f, Interpolator interpolator) {
        AppMethodBeat.m2504i(99844);
        float interpolation = ((this.f14411f - this.f14410e) * interpolator.getInterpolation(f)) + this.f14410e;
        if (this.f14163d != null) {
            this.f14163d.mo29455a(interpolation, this.f14412g, this.f14413h, this.f14414i);
        }
        AppMethodBeat.m2505o(99844);
    }
}
