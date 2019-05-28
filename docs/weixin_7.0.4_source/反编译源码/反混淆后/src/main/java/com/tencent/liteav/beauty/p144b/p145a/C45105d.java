package com.tencent.liteav.beauty.p144b.p145a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.a.d */
public class C45105d extends C8796g {
    /* renamed from: r */
    private int f17769r = -1;
    /* renamed from: s */
    private int f17770s = -1;
    /* renamed from: t */
    private float f17771t = 4.0f;
    /* renamed from: u */
    private String f17772u = "SmoothHorizontal";

    C45105d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    /* renamed from: a */
    public boolean mo19876a() {
        AppMethodBeat.m2504i(66951);
        NativeLoad.getInstance();
        this.f2616a = NativeLoad.nativeLoadGLProgram(13);
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        boolean z = this.f2622g;
        AppMethodBeat.m2505o(66951);
        return z;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66952);
        super.mo3848b();
        mo72888q();
        AppMethodBeat.m2505o(66952);
        return true;
    }

    /* renamed from: q */
    public void mo72888q() {
        AppMethodBeat.m2504i(66953);
        this.f17769r = GLES20.glGetUniformLocation(mo19894p(), "texelWidthOffset");
        this.f17770s = GLES20.glGetUniformLocation(mo19894p(), "texelHeightOffset");
        AppMethodBeat.m2505o(66953);
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66954);
        super.mo3839a(i, i2);
        if (i > i2) {
            if (i2 < 540) {
                this.f17771t = 2.0f;
            } else {
                this.f17771t = 4.0f;
            }
        } else if (i < 540) {
            this.f17771t = 2.0f;
        } else {
            this.f17771t = 4.0f;
        }
        TXCLog.m15677i(this.f17772u, "m_textureRation " + this.f17771t);
        mo19866a(this.f17769r, this.f17771t / ((float) i));
        mo19866a(this.f17770s, this.f17771t / ((float) i2));
        AppMethodBeat.m2505o(66954);
    }
}
