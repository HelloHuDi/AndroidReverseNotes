package com.tencent.liteav.basic.e;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.FloatBuffer;

public class h extends g {
    public boolean r;
    private float[] s;
    private int t;

    public h() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.i(66175);
        this.s = new float[16];
        this.r = false;
        this.o = true;
        AppMethodBeat.o(66175);
    }

    public boolean b() {
        AppMethodBeat.i(66176);
        boolean b = super.b();
        this.t = GLES20.glGetUniformLocation(this.a, "textureTransform");
        if (b && GLES20.glGetError() == 0) {
            AppMethodBeat.o(66176);
            return true;
        }
        AppMethodBeat.o(66176);
        return false;
    }

    public void a(float[] fArr) {
        this.s = fArr;
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(66177);
        GLES20.glUseProgram(this.a);
        k();
        if (!m() || this.s == null) {
            AppMethodBeat.o(66177);
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.b);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.d);
        GLES20.glUniformMatrix4fv(this.t, 1, false, this.s, 0);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
            GLES20.glUniform1i(this.c, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.b);
        GLES20.glDisableVertexAttribArray(this.d);
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
        AppMethodBeat.o(66177);
    }
}
