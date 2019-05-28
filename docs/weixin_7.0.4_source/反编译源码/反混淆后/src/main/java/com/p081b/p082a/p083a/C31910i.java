package com.p081b.p082a.p083a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.b.a.a.i */
final class C31910i {
    static C31910i bDs;
    float bDA;
    boolean bDB = false;
    double bDt;
    double bDu;
    float bDv;
    float bDw;
    float bDx;
    float bDy;
    float bDz;

    C31910i() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo52024a(double d, double d2, float f, float f2, float f3, float f4) {
        double d3;
        AppMethodBeat.m2504i(55678);
        float[] fArr = new float[1];
        if (d2 > 179.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d, d2, d, d2 + d3, fArr);
        this.bDA = fArr[0];
        if (d > 89.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d3 + d, d2, d, d2, fArr);
        this.bDz = fArr[0];
        this.bDt = d;
        this.bDu = d2;
        this.bDv = f2;
        this.bDw = f3;
        this.bDy = f;
        this.bDx = f4;
        this.bDB = true;
        AppMethodBeat.m2505o(55678);
    }
}
