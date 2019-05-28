package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.d */
public class C16519d extends C8796g {
    /* renamed from: r */
    private float f3518r = 2.0f;
    /* renamed from: s */
    private int f3519s;
    /* renamed from: t */
    private int f3520t;

    C16519d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;  \n \nuniform sampler2D inputImageTexture;  \nvarying highp vec2 textureCoordinate; \nuniform float texelWidthOffset; \nuniform float texelHeightOffset; \nvec2 pos[9]; \n \nvoid main()  \n{  \n\tpos[0] = textureCoordinate + vec2(-texelWidthOffset, -texelHeightOffset); \n\tpos[1] = textureCoordinate + vec2(-texelWidthOffset, 0.0); \n\tpos[2] = textureCoordinate + vec2(-texelWidthOffset, texelHeightOffset); \n\tpos[3] = textureCoordinate + vec2(0.0, -texelHeightOffset); \n\tpos[4] = textureCoordinate + vec2(0.0, 0.0); \n\tpos[5] = textureCoordinate + vec2(0.0, texelHeightOffset); \n\tpos[6] = textureCoordinate + vec2(texelWidthOffset, -texelHeightOffset); \n\tpos[7] = textureCoordinate + vec2(texelWidthOffset, 0.0); \n\tpos[8] = textureCoordinate + vec2(texelWidthOffset, texelHeightOffset); \n\tvec4 fragmentColor = texture2D(inputImageTexture, pos[0]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[1]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[2]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[3]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[4]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[5]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[6]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[7]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[8]);  \n \n\tgl_FragColor = fragmentColor / 9.0;  \n} \n");
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(67052);
        if (super.mo3848b()) {
            this.f3519s = GLES20.glGetUniformLocation(this.f2616a, "texelWidthOffset");
            this.f3520t = GLES20.glGetUniformLocation(this.f2616a, "texelHeightOffset");
            AppMethodBeat.m2505o(67052);
            return true;
        }
        AppMethodBeat.m2505o(67052);
        return false;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(67053);
        super.mo3839a(i, i2);
        mo30452a(this.f3518r);
        AppMethodBeat.m2505o(67053);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo30452a(float f) {
        AppMethodBeat.m2504i(67054);
        this.f3518r = f;
        mo19866a(this.f3519s, this.f3518r / ((float) this.f2620e));
        mo19866a(this.f3520t, this.f3518r / ((float) this.f2621f));
        AppMethodBeat.m2505o(67054);
    }
}
