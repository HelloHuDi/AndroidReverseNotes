package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bu.b;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.ui.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u0002052\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u000202J\u0006\u0010?\u001a\u000205J\u0012\u0010@\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\"\u0010C\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0006H\u0016J\u001c\u0010F\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0006\u0010I\u001a\u000205J\u0010\u0010J\u001a\u0002052\b\u0010K\u001a\u0004\u0018\u00010\u0015J\u000e\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020\u0019J\u0010\u0010N\u001a\u0002052\u0006\u00109\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n %*\u0004\u0018\u00010$0$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n %*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "()V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "inputTextureHeight", "inputTextureWidth", "isInit", "", "matrix", "", "ptFaceDetector", "Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "ptFaceFrame", "Lcom/tencent/filter/Frame;", "ptSegment", "Lcom/tencent/ttpic/PTSegment;", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "segOutputTexture", "sizeBuffer", "stickerOutTexture", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureFramebuffer", "toTextureOutputTexture", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "changeVideoFilter", "", "path", "drawBlendContent", "useNormalVideoTexture", "videoTexture", "drawWithRemoveBackground", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class e implements Renderer {
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
    b lpo = new b();
    PTSegment lpp = new PTSegment();
    h lpq;
    int lpr;
    final FloatBuffer lps;
    public ByteBuffer lpt;
    private final float[] matrix;

    public e() {
        AppMethodBeat.i(3171);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(c.eZY.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZi = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(c.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.lps = asFloatBuffer;
        this.eZE = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.matrix = new float[16];
        this.lpt = ByteBuffer.allocate((this.eZr * this.eZs) * 4);
        AppMethodBeat.o(3171);
    }

    public final void onDrawFrame(GL10 gl10) {
        d dVar;
        AppMethodBeat.i(3167);
        try {
            long yz = bo.yz();
            a aVar = c.loN;
            a.Vj();
            SurfaceTexture surfaceTexture = this.lpd;
            if (surfaceTexture == null) {
                j.avw("videoDecodeSurfaceTexture");
            }
            surfaceTexture.updateTexImage();
            boolean z = this.ljd;
            aVar = c.loN;
            h hVar = this.lpq;
            if (hVar == null) {
                j.avw("ptFaceFrame");
            }
            int wE = hVar.wE();
            h hVar2 = this.lpq;
            if (hVar2 == null) {
                j.avw("ptFaceFrame");
            }
            int textureId = hVar2.getTextureId();
            h hVar3 = this.lpq;
            if (hVar3 == null) {
                j.avw("ptFaceFrame");
            }
            int i = hVar3.width;
            h hVar4 = this.lpq;
            if (hVar4 == null) {
                j.avw("ptFaceFrame");
            }
            a.y(wE, textureId, i, hVar4.height);
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
                this.lps.put(c.faa);
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
            aVar = c.loN;
            a.Vj();
            GLES20.glViewport(0, 0, this.lpm, this.lpm);
            hVar = this.lpq;
            if (hVar == null) {
                j.avw("ptFaceFrame");
            }
            if (z) {
                b bVar = this.lpo;
                hVar3 = this.lpq;
                if (hVar3 == null) {
                    j.avw("ptFaceFrame");
                }
                PTFaceAttr a = bVar.a(hVar3, false, true, true);
                if (a != null) {
                    if (a.getOrigFrame() != null) {
                        hVar3 = a.getOrigFrame();
                        j.o(hVar3, "faceAttr.origFrame");
                    } else {
                        hVar3 = hVar;
                    }
                    try {
                        hVar = this.lpp.segTexture(a, hVar3, 0.015f, this.lpm, this.lpm);
                        j.o(hVar, "ptSegment.segTexture(fac…xtureSize, toTextureSize)");
                    } catch (Exception e) {
                        dVar = d.lhz;
                        d.bni();
                        hVar = hVar3;
                    }
                    a aVar2 = c.loN;
                    a.Vj();
                }
            }
            GLES20.glFinish();
            GLES20.glViewport(0, 0, this.eZr, this.eZs);
            wE = hVar.getTextureId();
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
            this.lps.put(c.eZZ);
            this.lps.position(0);
            GLES20.glVertexAttribPointer(this.eZx, 2, 5126, false, 0, this.lps);
            GLES20.glEnableVertexAttribArray(this.eZx);
            this.eZE.put((float) this.eZr);
            this.eZE.put((float) this.eZs);
            this.eZE.position(0);
            GLES20.glUniform2fv(this.lpe, 1, this.eZE);
            wE = this.lpf;
            c.a aVar3 = c.lhw;
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
            ab.i(this.TAG, "draw frame used " + bo.az(yz) + "ms");
            AppMethodBeat.o(3167);
        } catch (Exception e2) {
            ab.printErrStackTrace(this.TAG, e2, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
            dVar = d.lhz;
            d.bnc();
            AppMethodBeat.o(3167);
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AppMethodBeat.i(3168);
        ab.i(this.TAG, "onSurfaceChanged, width:" + i + ", height:" + i2);
        this.eZr = i;
        this.eZs = i2;
        this.lpt = ByteBuffer.allocate((this.eZr * this.eZs) * 4);
        AppMethodBeat.o(3168);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(3169);
        ab.i(this.TAG, "onSurfaceCreated");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glDisable(2929);
        AppMethodBeat.o(3169);
    }

    public final SurfaceTexture boh() {
        AppMethodBeat.i(3170);
        SurfaceTexture surfaceTexture = this.lpd;
        if (surfaceTexture == null) {
            j.avw("videoDecodeSurfaceTexture");
        }
        AppMethodBeat.o(3170);
        return surfaceTexture;
    }
}
