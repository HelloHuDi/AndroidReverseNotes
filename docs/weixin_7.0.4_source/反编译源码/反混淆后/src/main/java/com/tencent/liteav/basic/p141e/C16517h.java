package com.tencent.liteav.basic.p141e;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.basic.e.h */
public class C16517h extends C8796g {
    /* renamed from: r */
    public boolean f3515r;
    /* renamed from: s */
    private float[] f3516s;
    /* renamed from: t */
    private int f3517t;

    public C16517h() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.m2504i(66175);
        this.f3516s = new float[16];
        this.f3515r = false;
        this.f2630o = true;
        AppMethodBeat.m2505o(66175);
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66176);
        boolean b = super.mo3848b();
        this.f3517t = GLES20.glGetUniformLocation(this.f2616a, "textureTransform");
        if (b && GLES20.glGetError() == 0) {
            AppMethodBeat.m2505o(66176);
            return true;
        }
        AppMethodBeat.m2505o(66176);
        return false;
    }

    /* renamed from: a */
    public void mo19874a(float[] fArr) {
        this.f3516s = fArr;
    }

    /* renamed from: a */
    public void mo19869a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.m2504i(66177);
        GLES20.glUseProgram(this.f2616a);
        mo19889k();
        if (!mo19891m() || this.f3516s == null) {
            AppMethodBeat.m2505o(66177);
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f2617b, 2, 5126, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f2617b);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f2619d, 2, 5126, false, 0, floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.f2619d);
        GLES20.glUniformMatrix4fv(this.f3517t, 1, false, this.f3516s, 0);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
            GLES20.glUniform1i(this.f2618c, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f2617b);
        GLES20.glDisableVertexAttribArray(this.f2619d);
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
        AppMethodBeat.m2505o(66177);
    }
}
