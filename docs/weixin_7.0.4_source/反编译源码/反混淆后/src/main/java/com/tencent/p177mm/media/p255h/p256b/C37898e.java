package com.tencent.p177mm.media.p255h.p256b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p867i.C42175b;
import com.tencent.p177mm.media.p867i.C42175b.C26386a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureId", "yBuffer", "yTextureId", "yuvProgramId", "getFrame", "renderImpl", "", "setFrame", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.h.b.e */
public class C37898e extends C1786a {
    private static final String TAG = TAG;
    public static final C9608a eZX = new C9608a();
    private int eZM;
    private int eZN;
    private int eZO;
    private int eZP;
    private int eZQ;
    private int eZR;
    private int eZS;
    private int eZT;
    private ByteBuffer eZU;
    private ByteBuffer eZV;
    protected byte[] eZW = new byte[0];

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.h.b.e$a */
    public static final class C9608a {
        private C9608a() {
        }

        public /* synthetic */ C9608a(byte b) {
            this();
        }
    }

    public C37898e(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        AppMethodBeat.m2504i(13109);
        C26386a c26386a = C42175b.fad;
        this.eZO = C26386a.m41980U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
        if (this.eZO == 0) {
            C4990ab.m7412e(TAG, "checkInit, load program failed!");
        }
        this.eZQ = GLES20.glGetAttribLocation(this.eZO, "a_position");
        this.eZP = GLES20.glGetAttribLocation(this.eZO, "a_texCoord");
        this.eZR = GLES20.glGetUniformLocation(this.eZO, "y_texture");
        this.eZS = GLES20.glGetUniformLocation(this.eZO, "uv_texture");
        this.eZT = GLES20.glGetUniformLocation(this.eZO, "uMatrix");
        c26386a = C42175b.fad;
        this.eZM = C26386a.m41982Vh();
        c26386a = C42175b.fad;
        this.eZN = C26386a.m41982Vh();
        AppMethodBeat.m2505o(13109);
    }

    /* renamed from: M */
    public final void mo5332M(byte[] bArr) {
        AppMethodBeat.m2504i(13107);
        C25052j.m39376p(bArr, "frame");
        this.eZW = bArr;
        AppMethodBeat.m2505o(13107);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:29:0x005c, code skipped:
            if (r2.capacity() != ((r12.eYW * r12.eYX) / 2)) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Vf */
    public void mo5334Vf() {
        AppMethodBeat.m2504i(13108);
        if (!(this.eZO == 0 || this.eZM == -1 || this.eZN == -1 || this.eYY <= 0 || this.eYZ <= 0)) {
            if (((this.eZW.length == 0 ? 1 : 0) == 0 ? 1 : 0) != 0) {
                ByteBuffer byteBuffer;
                if (!(this.eZU == null || this.eZV == null)) {
                    byteBuffer = this.eZU;
                    if (byteBuffer == null) {
                        C25052j.dWJ();
                    }
                    if (byteBuffer.capacity() == this.eYW * this.eYX) {
                        byteBuffer = this.eZV;
                        if (byteBuffer == null) {
                            C25052j.dWJ();
                        }
                    }
                }
                this.eZU = ByteBuffer.allocateDirect(this.eYW * this.eYX);
                this.eZV = ByteBuffer.allocateDirect((this.eYW * this.eYX) / 2);
                byteBuffer = this.eZU;
                if (byteBuffer == null) {
                    C25052j.dWJ();
                }
                byteBuffer.order(ByteOrder.nativeOrder());
                byteBuffer = this.eZV;
                if (byteBuffer == null) {
                    C25052j.dWJ();
                }
                byteBuffer.order(ByteOrder.nativeOrder());
                byteBuffer = this.eZU;
                if (byteBuffer == null) {
                    C25052j.dWJ();
                }
                byteBuffer.put(this.eZW, 0, this.eYW * this.eYX);
                byteBuffer = this.eZU;
                if (byteBuffer == null) {
                    C25052j.dWJ();
                }
                byteBuffer.position(0);
                byteBuffer = this.eZV;
                if (byteBuffer == null) {
                    C25052j.dWJ();
                }
                byteBuffer.put(this.eZW, this.eYW * this.eYX, (this.eYW * this.eYX) / 2);
                byteBuffer = this.eZV;
                if (byteBuffer == null) {
                    C25052j.dWJ();
                }
                byteBuffer.position(0);
                GLES20.glUseProgram(this.eZO);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.eZM);
                GLES20.glTexImage2D(3553, 0, 6409, this.eYW, this.eYX, 0, 6409, GLType.GL_UNSIGNED_BYTE, this.eZU);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 10497.0f);
                GLES20.glTexParameterf(3553, 10243, 10497.0f);
                GLES20.glUniform1i(this.eZR, 0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, this.eZN);
                GLES20.glTexImage2D(3553, 0, 6410, this.eYW / 2, this.eYX / 2, 0, 6410, GLType.GL_UNSIGNED_BYTE, this.eZV);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 10497.0f);
                GLES20.glTexParameterf(3553, 10243, 10497.0f);
                GLES20.glUniform1i(this.eZS, 1);
                GLES20.glUniformMatrix4fv(this.eZT, 1, false, this.eZm, 0);
                this.eZi.position(0);
                GLES20.glVertexAttribPointer(this.eZQ, 2, 5126, false, 0, this.eZi);
                GLES20.glEnableVertexAttribArray(this.eZQ);
                this.eZh.position(0);
                GLES20.glVertexAttribPointer(this.eZP, 2, 5126, false, 0, this.eZh);
                GLES20.glEnableVertexAttribArray(this.eZP);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.eZQ);
                GLES20.glDisableVertexAttribArray(this.eZP);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glUseProgram(0);
            }
        }
        AppMethodBeat.m2505o(13108);
    }

    static {
        AppMethodBeat.m2504i(13110);
        AppMethodBeat.m2505o(13110);
    }
}
