package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.t */
public class C31253t extends C25654s {
    /* renamed from: u */
    protected float f14392u;

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(67043);
        if (super.mo3848b() && GLES20.glGetError() == 0) {
            AppMethodBeat.m2505o(67043);
            return true;
        }
        AppMethodBeat.m2505o(67043);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: s */
    public void mo51220s() {
        AppMethodBeat.m2504i(67044);
        float r = mo51219r();
        C8796g c8796g = (C8796g) this.f14796r.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(c8796g.mo19894p(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(c8796g.mo19894p(), "texelHeightOffset");
        c8796g.mo19866a(glGetUniformLocation, r / ((float) this.f2620e));
        c8796g.mo19866a(glGetUniformLocation2, 0.0f);
        r = mo51218q();
        c8796g = (C8796g) this.f14796r.get(1);
        glGetUniformLocation = GLES20.glGetUniformLocation(c8796g.mo19894p(), "texelWidthOffset");
        glGetUniformLocation2 = GLES20.glGetUniformLocation(c8796g.mo19894p(), "texelHeightOffset");
        c8796g.mo19866a(glGetUniformLocation, 0.0f);
        c8796g.mo19866a(glGetUniformLocation2, r / ((float) this.f2621f));
        AppMethodBeat.m2505o(67044);
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(67045);
        super.mo3839a(i, i2);
        mo51220s();
        AppMethodBeat.m2505o(67045);
    }

    /* renamed from: q */
    public float mo51218q() {
        return this.f14392u;
    }

    /* renamed from: r */
    public float mo51219r() {
        return this.f14392u;
    }
}
