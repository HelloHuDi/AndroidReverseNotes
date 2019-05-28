package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.n */
public class C45106n extends C8796g {
    /* renamed from: C */
    private static float[] f17773C = new float[]{0.1826f, 0.6142f, 0.062f, -0.1006f, -0.3386f, 0.4392f, 0.4392f, -0.3989f, -0.0403f};
    /* renamed from: D */
    private static float[] f17774D = new float[]{0.256816f, 0.504154f, 0.0979137f, -0.148246f, -0.29102f, 0.439266f, 0.439271f, -0.367833f, -0.071438f};
    /* renamed from: E */
    private static float[] f17775E = new float[]{0.0625f, 0.5f, 0.5f};
    /* renamed from: A */
    private String f17776A = "RGBA2I420Filter";
    /* renamed from: B */
    private int f17777B = 1;
    /* renamed from: r */
    private int f17778r = -1;
    /* renamed from: s */
    private int f17779s = -1;
    /* renamed from: t */
    private int f17780t = -1;
    /* renamed from: u */
    private int f17781u = -1;
    /* renamed from: v */
    private int f17782v = -1;
    /* renamed from: w */
    private int f17783w = -1;
    /* renamed from: x */
    private int f17784x = -1;
    /* renamed from: y */
    private int f17785y = -1;
    /* renamed from: z */
    private int f17786z = -1;

    public C45106n(int i) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.f17777B = i;
    }

    /* renamed from: a */
    public boolean mo19876a() {
        boolean a;
        AppMethodBeat.m2504i(67003);
        if (1 == this.f17777B) {
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(8);
            TXCLog.m15677i(this.f17776A, "RGB-->I420 init!");
        } else if (3 == this.f17777B) {
            TXCLog.m15677i(this.f17776A, "RGB-->NV21 init!");
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(11);
        } else if (2 == this.f17777B) {
            TXCLog.m15677i(this.f17776A, "RGBA Format init!");
            a = super.mo19876a();
            AppMethodBeat.m2505o(67003);
            return a;
        } else {
            TXCLog.m15677i(this.f17776A, "don't support format " + this.f17777B + " use default I420");
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(8);
        }
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        a = this.f2622g;
        AppMethodBeat.m2505o(67003);
        return a;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(67004);
        super.mo3848b();
        this.f17778r = GLES20.glGetUniformLocation(this.f2616a, "width");
        this.f17779s = GLES20.glGetUniformLocation(this.f2616a, "height");
        AppMethodBeat.m2505o(67004);
        return true;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(67005);
        if (i <= 0 || i2 <= 0) {
            TXCLog.m15676e(this.f17776A, "width or height is error!");
            AppMethodBeat.m2505o(67005);
            return;
        }
        super.mo3839a(i, i2);
        TXCLog.m15677i(this.f17776A, "RGBA2I420Filter width " + i + " height " + i2);
        mo19866a(this.f17778r, (float) i);
        mo19866a(this.f17779s, (float) i2);
        AppMethodBeat.m2505o(67005);
    }

    /* renamed from: c */
    public void mo19881c() {
        AppMethodBeat.m2504i(67006);
        super.mo19881c();
        AppMethodBeat.m2505o(67006);
    }
}
