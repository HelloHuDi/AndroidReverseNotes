package com.tencent.mm.media.h.b;

import a.l;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import com.tencent.ttpic.gles.GlUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class c extends a {
    protected int eYN = -1;
    private int eZH;
    private int eZI;
    private int eZJ;
    private int eZK;
    private int eZL;

    public c(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        AppMethodBeat.i(13104);
        a aVar = b.fad;
        this.eZH = a.U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        this.eZI = GLES20.glGetAttribLocation(this.eZH, "a_position");
        this.eZJ = GLES20.glGetAttribLocation(this.eZH, "a_texCoord");
        this.eZK = GLES20.glGetUniformLocation(this.eZH, "texture");
        this.eZL = GLES20.glGetUniformLocation(this.eZH, "uMatrix");
        AppMethodBeat.o(13104);
    }

    public final void kb(int i) {
        this.eYN = i;
    }

    /* Access modifiers changed, original: protected */
    public void Vf() {
        AppMethodBeat.i(13102);
        if (this.eYN != -1) {
            GLES20.glUseProgram(this.eZH);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, this.eYN);
            GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
            GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
            GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 10497.0f);
            GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 10497.0f);
            GLES20.glUniform1i(this.eZK, 0);
            GLES20.glUniformMatrix4fv(this.eZL, 1, false, this.eZm, 0);
            this.eZi.position(0);
            GLES20.glVertexAttribPointer(this.eZI, 2, 5126, false, 0, this.eZi);
            GLES20.glEnableVertexAttribArray(this.eZI);
            this.eZh.position(0);
            GLES20.glVertexAttribPointer(this.eZJ, 2, 5126, false, 0, this.eZh);
            GLES20.glEnableVertexAttribArray(this.eZJ);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.eZI);
            GLES20.glDisableVertexAttribArray(this.eZJ);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
            GLES20.glFinish();
        }
        AppMethodBeat.o(13102);
    }

    public void release() {
        AppMethodBeat.i(13103);
        super.release();
        GLES20.glDeleteProgram(this.eZH);
        AppMethodBeat.o(13103);
    }
}
