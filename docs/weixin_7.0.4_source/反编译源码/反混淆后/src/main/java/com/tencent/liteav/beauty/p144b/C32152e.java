package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.e */
public class C32152e extends C37361q {
    /* renamed from: A */
    private int f14780A;
    /* renamed from: B */
    private float[] f14781B;
    /* renamed from: x */
    private int f14782x;
    /* renamed from: y */
    private int f14783y;
    /* renamed from: z */
    private int f14784z;

    /* renamed from: c */
    public void mo19881c() {
        AppMethodBeat.m2504i(67050);
        super.mo19881c();
        this.f14782x = GLES20.glGetUniformLocation(mo19894p(), "screenMode");
        this.f14783y = GLES20.glGetUniformLocation(mo19894p(), "screenReplaceColor");
        this.f14784z = GLES20.glGetUniformLocation(mo19894p(), "screenMirrorX");
        this.f14780A = GLES20.glGetUniformLocation(mo19894p(), "screenMirrorY");
        mo52753b(this.f14781B);
        AppMethodBeat.m2505o(67050);
    }

    /* renamed from: b */
    public void mo52753b(float[] fArr) {
        AppMethodBeat.m2504i(67051);
        mo19879b(this.f14783y, new float[]{(float) (((0.2989d * ((double) fArr[0])) + (0.5866d * ((double) fArr[1]))) + (0.1145d * ((double) fArr[2]))), (float) (0.7132d * ((double) (fArr[0] - r0[0]))), (float) (0.5647d * ((double) (fArr[2] - r0[0])))});
        AppMethodBeat.m2505o(67051);
    }
}
