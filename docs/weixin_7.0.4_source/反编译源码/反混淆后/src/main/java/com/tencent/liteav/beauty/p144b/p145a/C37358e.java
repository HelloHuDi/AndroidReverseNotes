package com.tencent.liteav.beauty.p144b.p145a;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.p144b.C25653r;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.a.e */
public class C37358e extends C25653r {
    /* renamed from: A */
    private String f15892A = "SmoothVertical";
    /* renamed from: r */
    private int f15893r = -1;
    /* renamed from: s */
    private int f15894s = -1;
    /* renamed from: t */
    private int f15895t = -1;
    /* renamed from: x */
    private int f15896x = -1;
    /* renamed from: y */
    private float f15897y = 2.0f;
    /* renamed from: z */
    private float f15898z = 0.5f;

    C37358e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    /* renamed from: a */
    public boolean mo19876a() {
        AppMethodBeat.m2504i(66960);
        if (Build.BRAND.equals("samsung") && Build.MODEL.equals("GT-I9500") && VERSION.RELEASE.equals("4.3")) {
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(15);
        } else {
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(5);
        }
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        boolean z = this.f2622g;
        AppMethodBeat.m2505o(66960);
        return z;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66961);
        super.mo3848b();
        mo60124q();
        AppMethodBeat.m2505o(66961);
        return true;
    }

    /* renamed from: a */
    public void mo60123a(float f) {
        AppMethodBeat.m2504i(66962);
        this.f15898z = f;
        TXCLog.m15677i(this.f15892A, "setBeautyLevel ".concat(String.valueOf(f)));
        mo19866a(this.f15895t, f);
        AppMethodBeat.m2505o(66962);
    }

    /* renamed from: q */
    public void mo60124q() {
        AppMethodBeat.m2504i(66963);
        this.f15893r = GLES20.glGetUniformLocation(mo19894p(), "texelWidthOffset");
        this.f15894s = GLES20.glGetUniformLocation(mo19894p(), "texelHeightOffset");
        this.f15895t = GLES20.glGetUniformLocation(mo19894p(), "smoothDegree");
        AppMethodBeat.m2505o(66963);
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66964);
        super.mo3839a(i, i2);
        if (i > i2) {
            if (i2 < 540) {
                this.f15897y = 2.0f;
            } else {
                this.f15897y = 4.0f;
            }
        } else if (i < 540) {
            this.f15897y = 2.0f;
        } else {
            this.f15897y = 4.0f;
        }
        TXCLog.m15677i(this.f15892A, "m_textureRation " + this.f15897y);
        mo19866a(this.f15893r, this.f15897y / ((float) i));
        mo19866a(this.f15894s, this.f15897y / ((float) i2));
        AppMethodBeat.m2505o(66964);
    }
}
