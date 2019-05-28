package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b extends r {
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private final String x = "BeautyBlend";

    public b() {
        super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        AppMethodBeat.i(66955);
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(12);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        boolean z = this.g;
        AppMethodBeat.o(66955);
        return z;
    }

    public boolean b() {
        AppMethodBeat.i(66956);
        super.b();
        q();
        AppMethodBeat.o(66956);
        return true;
    }

    public void a(float f) {
        AppMethodBeat.i(66957);
        TXCLog.i("BeautyBlend", "setBrightLevel ".concat(String.valueOf(f)));
        a(this.s, f);
        AppMethodBeat.o(66957);
    }

    public void b(float f) {
        AppMethodBeat.i(66958);
        a(this.t, f / 2.0f);
        AppMethodBeat.o(66958);
    }

    private void q() {
        AppMethodBeat.i(66959);
        this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
        this.r = GLES20.glGetUniformLocation(p(), "contrast");
        this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
        AppMethodBeat.o(66959);
    }
}
