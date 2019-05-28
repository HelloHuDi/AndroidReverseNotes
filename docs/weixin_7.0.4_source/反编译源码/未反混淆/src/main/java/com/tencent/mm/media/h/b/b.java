package com.tencent.mm.media.h.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020!H\u0014J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001aJ\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u001f*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "blendTextureScaleType", "(IIIIIII)V", "TAG", "", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTexture", "blendProgramId", "blendTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "renderImpl", "", "setBlendBitmap", "bitmap", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class b extends a {
    private final String TAG;
    private int eYQ;
    private int eZA;
    private int eZB;
    private int eZC;
    private int eZD;
    private final FloatBuffer eZE;
    private FloatBuffer eZF;
    private final int eZG;
    private int eZr;
    private int eZs;
    public Bitmap eZt;
    private int eZu;
    private int eZv;
    private int eZw;
    private int eZx;
    private int eZy;
    private int eZz;

    private b(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        AppMethodBeat.i(13101);
        this.eZG = 1;
        this.TAG = "MircoMsg.GLTextureRenderProcBlend";
        this.eZE = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.i.b.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZF = asFloatBuffer;
        this.eZr = i;
        this.eZs = i2;
        a aVar = com.tencent.mm.media.i.b.fad;
        this.eZu = a.Vh();
        aVar = com.tencent.mm.media.i.b.fad;
        this.eZv = a.U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            if (useNormalVideoTexture == 1) {\n                videoColor = texture2D(videoNormalTexture, v_texCoord);\n            } else {\n                videoColor = texture2D(videoExternalTexture, v_texCoord);\n            }\n            if (videoColor.a != 1.0) {\n                videoColor.a = 0.0;\n            }\n            if (hasEmojiTexture == 1) {\n                gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n            } else {\n                gl_FragColor = videoColor;\n            }\n        }\n        ");
        this.eZw = GLES20.glGetAttribLocation(this.eZv, "a_position");
        this.eZx = GLES20.glGetAttribLocation(this.eZv, "a_texCoord");
        this.eZy = GLES20.glGetUniformLocation(this.eZv, "videoExternalTexture");
        this.eZz = GLES20.glGetUniformLocation(this.eZv, "videoNormalTexture");
        this.eZA = GLES20.glGetUniformLocation(this.eZv, "emojiTexture");
        this.eZB = GLES20.glGetUniformLocation(this.eZv, "hasEmojiTexture");
        this.eZD = GLES20.glGetUniformLocation(this.eZv, "uMatrix");
        this.eZC = GLES20.glGetUniformLocation(this.eZv, "useNormalVideoTexture");
        this.eZF.position(0);
        this.eZF.put(com.tencent.mm.media.i.b.eZZ);
        this.eZF.position(0);
        AppMethodBeat.o(13101);
    }

    public /* synthetic */ b(int i, int i2, int i3, int i4, int i5, int i6, byte b) {
        this(i, i2, i3, i4, i5, i6);
    }

    public final void kb(int i) {
        this.eYQ = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Vf() {
        AppMethodBeat.i(13100);
        long yz = bo.yz();
        GLES20.glUseProgram(this.eZv);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, this.eYQ);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 10497.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 10497.0f);
        GLES20.glUniform1i(this.eZy, 0);
        GLES20.glUniform1i(this.eZz, 2);
        if (this.eZt != null) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.eZu);
            GLUtils.texImage2D(3553, 0, this.eZt, 0);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
        }
        GLES20.glUniform1i(this.eZA, 1);
        this.eZi.position(0);
        GLES20.glVertexAttribPointer(this.eZw, 2, 5126, false, 0, this.eZi);
        GLES20.glEnableVertexAttribArray(this.eZw);
        this.eZh.position(0);
        this.eZF.position(0);
        GLES20.glVertexAttribPointer(this.eZx, 2, 5126, false, 0, this.eZF);
        GLES20.glEnableVertexAttribArray(this.eZx);
        GLES20.glUniformMatrix4fv(this.eZD, 1, false, this.eZm, 0);
        if (this.eZt != null) {
            GLES20.glUniform1i(this.eZB, 1);
        } else {
            GLES20.glUniform1i(this.eZB, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.eZw);
        GLES20.glDisableVertexAttribArray(this.eZx);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
        GLES20.glFinish();
        GLES20.glUseProgram(0);
        this.eZt = null;
        ab.i(this.TAG, "draw frame used " + bo.az(yz) + "ms");
        AppMethodBeat.o(13100);
    }
}
