package com.tencent.map.lib.p822gl.model;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.map.lib.gl.model.e */
public class C45136e {
    /* renamed from: a */
    public float f17864a;
    /* renamed from: b */
    public float f17865b;
    /* renamed from: c */
    public float f17866c;
    /* renamed from: d */
    public float f17867d = 1.0f;

    public C45136e(float f, float f2, float f3) {
        this.f17864a = f;
        this.f17865b = f2;
        this.f17866c = f3;
    }

    /* renamed from: a */
    public C45136e mo72996a(float[] fArr) {
        AppMethodBeat.m2504i(98156);
        r0 = new float[4];
        Matrix.multiplyMV(r0, 0, fArr, 0, new float[]{this.f17864a, this.f17865b, this.f17866c, this.f17867d}, 0);
        C45136e c45136e = new C45136e(r0[0] / r0[3], r0[1] / r0[3], r0[2] / r0[3]);
        AppMethodBeat.m2505o(98156);
        return c45136e;
    }

    public String toString() {
        AppMethodBeat.m2504i(98157);
        String str = this.f17864a + "," + this.f17865b + "," + this.f17866c;
        AppMethodBeat.m2505o(98157);
        return str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C45136e)) {
            return false;
        }
        C45136e c45136e = (C45136e) obj;
        if (this.f17864a == c45136e.f17864a && this.f17865b == c45136e.f17865b && this.f17866c == c45136e.f17866c) {
            return true;
        }
        return false;
    }
}
