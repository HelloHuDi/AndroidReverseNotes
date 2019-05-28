package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class t extends s {
    protected float u;

    public boolean b() {
        AppMethodBeat.i(67043);
        if (super.b() && GLES20.glGetError() == 0) {
            AppMethodBeat.o(67043);
            return true;
        }
        AppMethodBeat.o(67043);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void s() {
        AppMethodBeat.i(67044);
        float r = r();
        g gVar = (g) this.r.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(gVar.p(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(gVar.p(), "texelHeightOffset");
        gVar.a(glGetUniformLocation, r / ((float) this.e));
        gVar.a(glGetUniformLocation2, 0.0f);
        r = q();
        gVar = (g) this.r.get(1);
        glGetUniformLocation = GLES20.glGetUniformLocation(gVar.p(), "texelWidthOffset");
        glGetUniformLocation2 = GLES20.glGetUniformLocation(gVar.p(), "texelHeightOffset");
        gVar.a(glGetUniformLocation, 0.0f);
        gVar.a(glGetUniformLocation2, r / ((float) this.f));
        AppMethodBeat.o(67044);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67045);
        super.a(i, i2);
        s();
        AppMethodBeat.o(67045);
    }

    public float q() {
        return this.u;
    }

    public float r() {
        return this.u;
    }
}
