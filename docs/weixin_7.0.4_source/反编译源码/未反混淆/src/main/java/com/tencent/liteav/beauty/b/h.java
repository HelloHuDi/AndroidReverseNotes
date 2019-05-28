package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h extends g {
    private int r;
    private float s;

    public h() {
        this(1.2f);
    }

    public h(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }");
        this.s = f;
    }

    public boolean b() {
        AppMethodBeat.i(67035);
        boolean b = super.b();
        this.r = GLES20.glGetUniformLocation(p(), "gamma");
        AppMethodBeat.o(67035);
        return b;
    }

    public void c() {
        AppMethodBeat.i(67036);
        super.c();
        a(this.s);
        AppMethodBeat.o(67036);
    }

    public void a(float f) {
        AppMethodBeat.i(67037);
        this.s = f;
        a(this.r, this.s);
        AppMethodBeat.o(67037);
    }
}
