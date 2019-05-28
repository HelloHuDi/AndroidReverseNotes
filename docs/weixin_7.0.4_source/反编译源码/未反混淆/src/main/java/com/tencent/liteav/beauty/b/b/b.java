package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b extends g {
    private int r = -1;
    private int s = -1;
    private float[] t = new float[4];
    private String u = "Beauty3Filter";

    public b() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.i(67007);
        AppMethodBeat.o(67007);
    }

    public boolean a() {
        AppMethodBeat.i(67008);
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(14);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        boolean z = this.g;
        AppMethodBeat.o(67008);
        return z;
    }

    public boolean b() {
        AppMethodBeat.i(67009);
        boolean b = super.b();
        this.r = GLES20.glGetUniformLocation(p(), "singleStepOffset");
        this.s = GLES20.glGetUniformLocation(p(), "beautyParams");
        a(5.0f);
        AppMethodBeat.o(67009);
        return b;
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(67010);
        a(this.r, new float[]{2.0f / ((float) i), 2.0f / ((float) i2)});
        AppMethodBeat.o(67010);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67011);
        super.a(i, i2);
        b(i, i2);
        AppMethodBeat.o(67011);
    }

    public void a(float f) {
        AppMethodBeat.i(67012);
        this.t[0] = f;
        b(this.t);
        AppMethodBeat.o(67012);
    }

    public void b(float f) {
        AppMethodBeat.i(67013);
        this.t[1] = f;
        b(this.t);
        AppMethodBeat.o(67013);
    }

    public void c(float f) {
        AppMethodBeat.i(67014);
        this.t[2] = f;
        b(this.t);
        AppMethodBeat.o(67014);
    }

    private void b(float[] fArr) {
        AppMethodBeat.i(67015);
        c(this.s, fArr);
        AppMethodBeat.o(67015);
    }
}
