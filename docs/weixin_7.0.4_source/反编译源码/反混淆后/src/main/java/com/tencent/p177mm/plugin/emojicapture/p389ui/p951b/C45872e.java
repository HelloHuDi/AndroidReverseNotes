package com.tencent.p177mm.plugin.emojicapture.p389ui.p951b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p206bu.C1333b;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27808c.C20448a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u0002052\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u000202J\u0006\u0010?\u001a\u000205J\u0012\u0010@\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\"\u0010C\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0006H\u0016J\u001c\u0010F\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0006\u0010I\u001a\u000205J\u0010\u0010J\u001a\u0002052\b\u0010K\u001a\u0004\u0018\u00010\u0015J\u000e\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020\u0019J\u0010\u0010N\u001a\u0002052\u0006\u00109\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n %*\u0004\u0018\u00010$0$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n %*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "()V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "inputTextureHeight", "inputTextureWidth", "isInit", "", "matrix", "", "ptFaceDetector", "Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "ptFaceFrame", "Lcom/tencent/filter/Frame;", "ptSegment", "Lcom/tencent/ttpic/PTSegment;", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "segOutputTexture", "sizeBuffer", "stickerOutTexture", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureFramebuffer", "toTextureOutputTexture", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "changeVideoFilter", "", "path", "drawBlendContent", "useNormalVideoTexture", "videoTexture", "drawWithRemoveBackground", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.e */
public final class C45872e implements Renderer {
    final String TAG = "MicroMsg.EmojiCaptureMixRenderer";
    boolean bZi;
    int eZA;
    int eZB;
    int eZC;
    int eZD;
    private final FloatBuffer eZE;
    final FloatBuffer eZi;
    public int eZr;
    public int eZs;
    public Bitmap eZt;
    int eZu;
    int eZv;
    int eZw;
    int eZx;
    int eZy;
    int eZz;
    boolean ljd;
    int lpc;
    SurfaceTexture lpd;
    int lpe;
    int lpf;
    int lpg;
    int lph;
    int lpi;
    int lpj;
    int lpk;
    int lpl;
    final int lpm = 640;
    int lpn;
    C1333b lpo = new C1333b();
    PTSegment lpp = new PTSegment();
    C41672h lpq;
    int lpr;
    final FloatBuffer lps;
    public ByteBuffer lpt;
    private final float[] matrix;

    public C45872e() {
        AppMethodBeat.m2504i(3171);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(C27808c.eZY.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZi = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(C27808c.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.lps = asFloatBuffer;
        this.eZE = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.matrix = new float[16];
        this.lpt = ByteBuffer.allocate((this.eZr * this.eZs) * 4);
        AppMethodBeat.m2505o(3171);
    }

    public final void onDrawFrame(GL10 gl10) {
        C34007d c34007d;
        AppMethodBeat.m2504i(3167);
        try {
            long yz = C5046bo.m7588yz();
            C20448a c20448a = C27808c.loN;
            C20448a.m31604Vj();
            SurfaceTexture surfaceTexture = this.lpd;
            if (surfaceTexture == null) {
                C25052j.avw("videoDecodeSurfaceTexture");
            }
            surfaceTexture.updateTexImage();
            boolean z = this.ljd;
            c20448a = C27808c.loN;
            C41672h c41672h = this.lpq;
            if (c41672h == null) {
                C25052j.avw("ptFaceFrame");
            }
            int wE = c41672h.mo67192wE();
            C41672h c41672h2 = this.lpq;
            if (c41672h2 == null) {
                C25052j.avw("ptFaceFrame");
            }
            int textureId = c41672h2.getTextureId();
            C41672h c41672h3 = this.lpq;
            if (c41672h3 == null) {
                C25052j.avw("ptFaceFrame");
            }
            int i = c41672h3.width;
            C41672h c41672h4 = this.lpq;
            if (c41672h4 == null) {
                C25052j.avw("ptFaceFrame");
            }
            C20448a.m31605y(wE, textureId, i, c41672h4.height);
            GLES20.glViewport(0, 0, this.lpm, this.lpm);
            wE = this.lpc;
            if (wE != 0) {
                GLES20.glUseProgram(this.lpg);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, wE);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071.0f);
                GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071.0f);
                GLES20.glUniform1i(this.lpj, 0);
                this.eZi.position(0);
                GLES20.glVertexAttribPointer(this.lph, 2, 5126, false, 0, this.eZi);
                GLES20.glEnableVertexAttribArray(this.lph);
                this.lps.position(0);
                this.lps.put(C27808c.faa);
                this.lps.position(0);
                GLES20.glVertexAttribPointer(this.lpi, 2, 5126, false, 0, this.lps);
                GLES20.glEnableVertexAttribArray(this.lpi);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.lph);
                GLES20.glDisableVertexAttribArray(this.lpi);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
                GLES20.glFinish();
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glFinish();
            c20448a = C27808c.loN;
            C20448a.m31604Vj();
            GLES20.glViewport(0, 0, this.lpm, this.lpm);
            c41672h = this.lpq;
            if (c41672h == null) {
                C25052j.avw("ptFaceFrame");
            }
            if (z) {
                C1333b c1333b = this.lpo;
                c41672h3 = this.lpq;
                if (c41672h3 == null) {
                    C25052j.avw("ptFaceFrame");
                }
                PTFaceAttr a = c1333b.mo4681a(c41672h3, false, true, true);
                if (a != null) {
                    if (a.getOrigFrame() != null) {
                        c41672h3 = a.getOrigFrame();
                        C25052j.m39375o(c41672h3, "faceAttr.origFrame");
                    } else {
                        c41672h3 = c41672h;
                    }
                    try {
                        c41672h = this.lpp.segTexture(a, c41672h3, 0.015f, this.lpm, this.lpm);
                        C25052j.m39375o(c41672h, "ptSegment.segTexture(fac…xtureSize, toTextureSize)");
                    } catch (Exception e) {
                        c34007d = C34007d.lhz;
                        C34007d.bni();
                        c41672h = c41672h3;
                    }
                    C20448a c20448a2 = C27808c.loN;
                    C20448a.m31604Vj();
                }
            }
            GLES20.glFinish();
            GLES20.glViewport(0, 0, this.eZr, this.eZs);
            wE = c41672h.getTextureId();
            GLES20.glViewport(0, 0, this.eZr, this.eZs);
            GLES20.glUseProgram(this.eZv);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, wE);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.eZz, 0);
            GLES20.glUniform1i(this.eZy, 2);
            GLES20.glUniform1i(this.eZC, 1);
            if (this.eZt != null) {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, this.eZu);
                GLUtils.texImage2D(3553, 0, this.eZt, 0);
                GLES20.glGenerateMipmap(3553);
                GLES20.glTexParameterf(3553, 10241, 9987.0f);
                GLES20.glTexParameterf(3553, 10240, 9987.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            GLES20.glUniform1i(this.eZA, 1);
            this.eZi.position(0);
            GLES20.glVertexAttribPointer(this.eZw, 2, 5126, false, 0, this.eZi);
            GLES20.glEnableVertexAttribArray(this.eZw);
            this.lps.position(0);
            this.lps.put(C27808c.eZZ);
            this.lps.position(0);
            GLES20.glVertexAttribPointer(this.eZx, 2, 5126, false, 0, this.lps);
            GLES20.glEnableVertexAttribArray(this.eZx);
            this.eZE.put((float) this.eZr);
            this.eZE.put((float) this.eZs);
            this.eZE.position(0);
            GLES20.glUniform2fv(this.lpe, 1, this.eZE);
            wE = this.lpf;
            C11617a c11617a = C34006c.lhw;
            GLES20.glUniform1f(wE, ((float) Math.max(this.eZr, this.eZs)) * 0.06666667f);
            Matrix.setIdentityM(this.matrix, 0);
            Matrix.scaleM(this.matrix, 0, 1.0f, -1.0f, 1.0f);
            GLES20.glUniformMatrix4fv(this.eZD, 1, false, this.matrix, 0);
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
            this.lpt.position(0);
            GLES20.glReadPixels(0, 0, this.eZr, this.eZr, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, this.lpt);
            GLES20.glUseProgram(0);
            C4990ab.m7416i(this.TAG, "draw frame used " + C5046bo.m7525az(yz) + "ms");
            AppMethodBeat.m2505o(3167);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace(this.TAG, e2, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
            c34007d = C34007d.lhz;
            C34007d.bnc();
            AppMethodBeat.m2505o(3167);
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AppMethodBeat.m2504i(3168);
        C4990ab.m7416i(this.TAG, "onSurfaceChanged, width:" + i + ", height:" + i2);
        this.eZr = i;
        this.eZs = i2;
        this.lpt = ByteBuffer.allocate((this.eZr * this.eZs) * 4);
        AppMethodBeat.m2505o(3168);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(3169);
        C4990ab.m7416i(this.TAG, "onSurfaceCreated");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glDisable(2929);
        AppMethodBeat.m2505o(3169);
    }

    public final SurfaceTexture boh() {
        AppMethodBeat.m2504i(3170);
        SurfaceTexture surfaceTexture = this.lpd;
        if (surfaceTexture == null) {
            C25052j.avw("videoDecodeSurfaceTexture");
        }
        AppMethodBeat.m2505o(3170);
        return surfaceTexture;
    }
}
