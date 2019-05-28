package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends r {
    private String A = "SmoothVertical";
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int x = -1;
    private float y = 2.0f;
    private float z = 0.5f;

    e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        AppMethodBeat.i(66960);
        if (Build.BRAND.equals("samsung") && Build.MODEL.equals("GT-I9500") && VERSION.RELEASE.equals("4.3")) {
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(15);
        } else {
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(5);
        }
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        boolean z = this.g;
        AppMethodBeat.o(66960);
        return z;
    }

    public boolean b() {
        AppMethodBeat.i(66961);
        super.b();
        q();
        AppMethodBeat.o(66961);
        return true;
    }

    public void a(float f) {
        AppMethodBeat.i(66962);
        this.z = f;
        TXCLog.i(this.A, "setBeautyLevel ".concat(String.valueOf(f)));
        a(this.t, f);
        AppMethodBeat.o(66962);
    }

    public void q() {
        AppMethodBeat.i(66963);
        this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
        this.t = GLES20.glGetUniformLocation(p(), "smoothDegree");
        AppMethodBeat.o(66963);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66964);
        super.a(i, i2);
        if (i > i2) {
            if (i2 < 540) {
                this.y = 2.0f;
            } else {
                this.y = 4.0f;
            }
        } else if (i < 540) {
            this.y = 2.0f;
        } else {
            this.y = 4.0f;
        }
        TXCLog.i(this.A, "m_textureRation " + this.y);
        a(this.r, this.y / ((float) i));
        a(this.s, this.y / ((float) i2));
        AppMethodBeat.o(66964);
    }
}
