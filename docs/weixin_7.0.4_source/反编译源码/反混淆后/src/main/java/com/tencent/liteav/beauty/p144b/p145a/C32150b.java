package com.tencent.liteav.beauty.p144b.p145a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.p144b.C25653r;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.a.b */
public class C32150b extends C25653r {
    /* renamed from: r */
    private int f14772r = -1;
    /* renamed from: s */
    private int f14773s = -1;
    /* renamed from: t */
    private int f14774t = -1;
    /* renamed from: x */
    private final String f14775x = "BeautyBlend";

    public C32150b() {
        super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    /* renamed from: a */
    public boolean mo19876a() {
        AppMethodBeat.m2504i(66955);
        NativeLoad.getInstance();
        this.f2616a = NativeLoad.nativeLoadGLProgram(12);
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        boolean z = this.f2622g;
        AppMethodBeat.m2505o(66955);
        return z;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66956);
        super.mo3848b();
        m52328q();
        AppMethodBeat.m2505o(66956);
        return true;
    }

    /* renamed from: a */
    public void mo52747a(float f) {
        AppMethodBeat.m2504i(66957);
        TXCLog.m15677i("BeautyBlend", "setBrightLevel ".concat(String.valueOf(f)));
        mo19866a(this.f14773s, f);
        AppMethodBeat.m2505o(66957);
    }

    /* renamed from: b */
    public void mo52748b(float f) {
        AppMethodBeat.m2504i(66958);
        mo19866a(this.f14774t, f / 2.0f);
        AppMethodBeat.m2505o(66958);
    }

    /* renamed from: q */
    private void m52328q() {
        AppMethodBeat.m2504i(66959);
        this.f14773s = GLES20.glGetUniformLocation(mo19894p(), "whiteDegree");
        this.f14772r = GLES20.glGetUniformLocation(mo19894p(), "contrast");
        this.f14774t = GLES20.glGetUniformLocation(mo19894p(), "ruddyDegree");
        AppMethodBeat.m2505o(66959);
    }
}
