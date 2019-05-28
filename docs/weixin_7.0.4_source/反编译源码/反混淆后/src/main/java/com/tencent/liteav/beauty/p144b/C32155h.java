package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.h */
public class C32155h extends C8796g {
    /* renamed from: r */
    private int f14801r;
    /* renamed from: s */
    private float f14802s;

    public C32155h() {
        this(1.2f);
    }

    public C32155h(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }");
        this.f14802s = f;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(67035);
        boolean b = super.mo3848b();
        this.f14801r = GLES20.glGetUniformLocation(mo19894p(), "gamma");
        AppMethodBeat.m2505o(67035);
        return b;
    }

    /* renamed from: c */
    public void mo19881c() {
        AppMethodBeat.m2504i(67036);
        super.mo19881c();
        mo52754a(this.f14802s);
        AppMethodBeat.m2505o(67036);
    }

    /* renamed from: a */
    public void mo52754a(float f) {
        AppMethodBeat.m2504i(67037);
        this.f14802s = f;
        mo19866a(this.f14801r, this.f14802s);
        AppMethodBeat.m2505o(67037);
    }
}
