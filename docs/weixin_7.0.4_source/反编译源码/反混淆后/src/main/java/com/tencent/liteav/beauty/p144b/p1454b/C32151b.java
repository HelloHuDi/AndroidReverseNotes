package com.tencent.liteav.beauty.p144b.p1454b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.b.b */
public class C32151b extends C8796g {
    /* renamed from: r */
    private int f14776r = -1;
    /* renamed from: s */
    private int f14777s = -1;
    /* renamed from: t */
    private float[] f14778t = new float[4];
    /* renamed from: u */
    private String f14779u = "Beauty3Filter";

    public C32151b() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.m2504i(67007);
        AppMethodBeat.m2505o(67007);
    }

    /* renamed from: a */
    public boolean mo19876a() {
        AppMethodBeat.m2504i(67008);
        NativeLoad.getInstance();
        this.f2616a = NativeLoad.nativeLoadGLProgram(14);
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        boolean z = this.f2622g;
        AppMethodBeat.m2505o(67008);
        return z;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(67009);
        boolean b = super.mo3848b();
        this.f14776r = GLES20.glGetUniformLocation(mo19894p(), "singleStepOffset");
        this.f14777s = GLES20.glGetUniformLocation(mo19894p(), "beautyParams");
        mo52749a(5.0f);
        AppMethodBeat.m2505o(67009);
        return b;
    }

    /* renamed from: b */
    public void mo52751b(int i, int i2) {
        AppMethodBeat.m2504i(67010);
        mo19870a(this.f14776r, new float[]{2.0f / ((float) i), 2.0f / ((float) i2)});
        AppMethodBeat.m2505o(67010);
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(67011);
        super.mo3839a(i, i2);
        mo52751b(i, i2);
        AppMethodBeat.m2505o(67011);
    }

    /* renamed from: a */
    public void mo52749a(float f) {
        AppMethodBeat.m2504i(67012);
        this.f14778t[0] = f;
        m52333b(this.f14778t);
        AppMethodBeat.m2505o(67012);
    }

    /* renamed from: b */
    public void mo52750b(float f) {
        AppMethodBeat.m2504i(67013);
        this.f14778t[1] = f;
        m52333b(this.f14778t);
        AppMethodBeat.m2505o(67013);
    }

    /* renamed from: c */
    public void mo52752c(float f) {
        AppMethodBeat.m2504i(67014);
        this.f14778t[2] = f;
        m52333b(this.f14778t);
        AppMethodBeat.m2505o(67014);
    }

    /* renamed from: b */
    private void m52333b(float[] fArr) {
        AppMethodBeat.m2504i(67015);
        mo19882c(this.f14777s, fArr);
        AppMethodBeat.m2505o(67015);
    }
}
