package com.tencent.liteav.beauty.p144b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C32144i;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.beauty.b.l */
public class C16521l extends C8796g {
    /* renamed from: A */
    private int f3530A;
    /* renamed from: B */
    private float[] f3531B;
    /* renamed from: C */
    private int f3532C;
    /* renamed from: D */
    private float[] f3533D;
    /* renamed from: r */
    private float f3534r;
    /* renamed from: s */
    private Bitmap f3535s;
    /* renamed from: t */
    private int f3536t;
    /* renamed from: u */
    private int f3537u;
    /* renamed from: v */
    private float f3538v;
    /* renamed from: w */
    private Bitmap f3539w;
    /* renamed from: x */
    private int f3540x;
    /* renamed from: y */
    private int f3541y;
    /* renamed from: z */
    private float f3542z;

    public C16521l(float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture 1\n uniform sampler2D inputImageTexture3; // lookup texture 2\n \n \n uniform lowp vec3 v3_params;\n uniform lowp vec2 v2_texs;\n \n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1;\n     lowp vec4 newColor2;\n     if(textureCoordinate.x <= v3_params.x) { \n       if(v2_texs.x == 1.0) { \n         newColor1 = texture2D(inputImageTexture2, texPos1);\n         newColor2 = texture2D(inputImageTexture2, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.y);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     } else {\n       if(v2_texs.y == 1.0) { \n         newColor1 = texture2D(inputImageTexture3, texPos1);\n         newColor2 = texture2D(inputImageTexture3, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.z);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     }\n }");
        AppMethodBeat.m2504i(66939);
        this.f3531B = new float[3];
        this.f3533D = new float[2];
        this.f3534r = f;
        this.f3535s = bitmap;
        this.f3539w = bitmap2;
        this.f3538v = f2;
        this.f3542z = f3;
        AppMethodBeat.m2505o(66939);
    }

    public C16521l(String str, String str2) {
        super(str, str2);
        this.f3537u = -1;
        this.f3541y = -1;
    }

    public C16521l() {
        this.f3537u = -1;
        this.f3541y = -1;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66940);
        this.f3536t = GLES20.glGetUniformLocation(mo19894p(), "inputImageTexture2");
        this.f3540x = GLES20.glGetUniformLocation(mo19894p(), "inputImageTexture3");
        this.f3530A = GLES20.glGetUniformLocation(mo19894p(), "v3_params");
        this.f3532C = GLES20.glGetUniformLocation(mo19894p(), "v2_texs");
        boolean b = super.mo3848b();
        AppMethodBeat.m2505o(66940);
        return b;
    }

    /* renamed from: c */
    public void mo19881c() {
        AppMethodBeat.m2504i(66941);
        super.mo19881c();
        mo30457a(this.f3534r, this.f3535s, this.f3538v, this.f3539w, this.f3542z);
        AppMethodBeat.m2505o(66941);
    }

    /* renamed from: a */
    public void mo30457a(float f, final Bitmap bitmap, float f2, final Bitmap bitmap2, float f3) {
        AppMethodBeat.m2504i(66942);
        mo30456a(f, f2, f3);
        mo19872a((Runnable) new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66918);
                C16521l.this.f3535s = bitmap;
                C16521l.this.f3539w = bitmap2;
                if (bitmap != null) {
                    C16521l.this.f3537u = C32144i.m52314a(bitmap, C16521l.this.f3537u, false);
                    C16521l.this.f3533D[0] = 1.0f;
                } else {
                    if (C16521l.this.f3537u != -1) {
                        GLES20.glDeleteTextures(1, new int[]{C16521l.this.f3537u}, 0);
                    }
                    C16521l.this.f3537u = -1;
                    C16521l.this.f3533D[0] = 0.0f;
                }
                if (bitmap2 != null) {
                    C16521l.this.f3541y = C32144i.m52314a(bitmap2, C16521l.this.f3541y, false);
                    C16521l.this.f3533D[1] = 1.0f;
                    AppMethodBeat.m2505o(66918);
                    return;
                }
                if (C16521l.this.f3541y != -1) {
                    GLES20.glDeleteTextures(1, new int[]{C16521l.this.f3541y}, 0);
                }
                C16521l.this.f3541y = -1;
                C16521l.this.f3533D[1] = 0.0f;
                AppMethodBeat.m2505o(66918);
            }
        });
        AppMethodBeat.m2505o(66942);
    }

    /* renamed from: a */
    public void mo30455a(float f) {
        AppMethodBeat.m2504i(66943);
        mo30456a(this.f3534r, f, 0.0f);
        AppMethodBeat.m2505o(66943);
    }

    /* renamed from: a */
    public void mo30456a(float f, float f2, float f3) {
        this.f3534r = f;
        this.f3538v = f2;
        this.f3542z = f3;
        this.f3531B[0] = this.f3534r;
        this.f3531B[1] = this.f3538v;
        this.f3531B[2] = this.f3542z;
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66944);
        super.mo3844e();
        GLES20.glDeleteTextures(2, new int[]{this.f3537u, this.f3541y}, 0);
        this.f3537u = -1;
        this.f3541y = -1;
        AppMethodBeat.m2505o(66944);
    }

    /* renamed from: i */
    public void mo19887i() {
        AppMethodBeat.m2504i(66945);
        if (this.f3537u != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f3537u);
            GLES20.glUniform1i(this.f3536t, 3);
        }
        if (this.f3541y != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.f3541y);
            GLES20.glUniform1i(this.f3540x, 4);
        }
        GLES20.glUniform2fv(this.f3532C, 1, FloatBuffer.wrap(this.f3533D));
        GLES20.glUniform3fv(this.f3530A, 1, FloatBuffer.wrap(this.f3531B));
        AppMethodBeat.m2505o(66945);
    }

    /* renamed from: j */
    public void mo19888j() {
        AppMethodBeat.m2504i(66946);
        if (this.f3537u != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
        if (this.f3541y != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
        AppMethodBeat.m2505o(66946);
    }
}
