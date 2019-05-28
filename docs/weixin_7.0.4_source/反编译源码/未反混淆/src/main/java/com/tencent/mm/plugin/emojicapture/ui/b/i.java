package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bu.b;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010E\u001a\u00020\t2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010G\u001a\u00020\tJ\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020\tJ\b\u0010J\u001a\u00020\tH\u0002J@\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020'2\b\b\u0002\u0010M\u001a\u00020'2\b\b\u0002\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020\u00032\b\b\u0002\u0010P\u001a\u00020\u00032\b\b\u0002\u0010Q\u001a\u00020\u0003H\u0002J\b\u0010R\u001a\u00020\tH\u0002J\u0010\u0010S\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0003H\u0002J\b\u0010T\u001a\u0004\u0018\u00010AJ\u0006\u0010U\u001a\u00020\tJ\u0012\u0010\u0014\u001a\u00020\t2\b\u0010V\u001a\u0004\u0018\u00010AH\u0016J\u000e\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u0003J\u0006\u0010Y\u001a\u00020\tJ\b\u0010Z\u001a\u00020\tH\u0002J\u000e\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u0003J\u0016\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020'2\u0006\u0010_\u001a\u00020'J\u001a\u0010`\u001a\u00020\t2\u0006\u0010L\u001a\u00020'2\b\b\u0002\u0010Q\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "removeBgEnable", "", "(Z)V", "TAG", "", "afterDrawCallback", "Lkotlin/Function0;", "", "canDraw", "cubeArray", "", "kotlin.jvm.PlatformType", "cubeBuffer", "Ljava/nio/FloatBuffer;", "frameTimestamp", "", "init", "isDrawing", "onFrameAvailable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pts", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "ptFaceDetector", "Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "ptFaceFrame", "Lcom/tencent/filter/Frame;", "ptSegment", "Lcom/tencent/ttpic/PTSegment;", "removeBackground", "getRemoveBgEnable", "()Z", "renderAttributePosition", "", "renderAttributeTextureCoord", "renderProgramId", "renderUniformCalcRoundCorner", "renderUniformExternalTexture", "renderUniformNormalTexture", "renderUniformRadius", "renderUniformSize", "renderUniformUseNormalTexture", "segmentInit", "segmentOutputTexture", "sizeBuff", "stickerOutTexture", "textureCoordArray", "textureCoordBuff", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureFramebuffer", "toTextureOutputTexture", "toTextureProgramId", "toTextureUniformExternalTexture", "videoPlayRenderDepthBuffer", "videoPlayRenderFramebuffer", "videoPlayRenderOutputTexture", "videoPlayRenderTextureSize", "videoPlaySurface", "Landroid/graphics/SurfaceTexture;", "videoPlayTexture", "viewHeight", "viewWidth", "afterDraw", "callback", "checkInit", "currentFrameTimestamp", "drawFrame", "drawImpl", "drawVideoContent", "videoTexture", "drawWidth", "drawHeight", "externalTarget", "calcRoundCorner", "verticalFlip", "drawWithRemoveBackground", "drawWithStickerAndRemoveBackground", "getVideoPlaySurface", "initSegment", "surfaceTexture", "pauseDraw", "pause", "release", "releaseSegment", "setRemoveBackground", "remove", "setViewSize", "width", "height", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class i implements OnFrameAvailableListener {
    public final String TAG = "MicroMsg.EmojiVideoPlayTextureRenderer";
    public boolean eNa;
    public FloatBuffer eZh;
    public FloatBuffer eZi;
    public float[] gLB;
    public float[] gLC;
    public boolean gLJ;
    public boolean gLv;
    public int iZn;
    public int iZo;
    public boolean ljd;
    public final boolean llN;
    public int lpX;
    public int lpY;
    public int lpZ;
    public int lpg;
    public int lph;
    public int lpi;
    public int lpj;
    public b lpo;
    public PTSegment lpp;
    public h lpq;
    public int lpr;
    public int lqa;
    public int lqb;
    public int lqc;
    public int lqd;
    public int lqe;
    public int lqf;
    public int lqg;
    public int lqh;
    public int lqi;
    public final int lqj;
    private FloatBuffer lqk;
    public SurfaceTexture lql;
    public a<y> lqm;
    public a.f.a.b<? super Long, y> lqn;
    private long lqo;
    public boolean lqp;

    public i(boolean z) {
        AppMethodBeat.i(3180);
        this.llN = z;
        c.a aVar = c.lhw;
        this.lqj = c.lht;
        float[] fArr = c.eZY;
        this.gLB = Arrays.copyOf(fArr, fArr.length);
        fArr = c.eZZ;
        this.gLC = Arrays.copyOf(fArr, fArr.length);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZi = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(this.gLC.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZh = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.lqk = asFloatBuffer;
        this.lqo = -1;
        AppMethodBeat.o(3180);
    }

    public final void dY(int i, int i2) {
        this.iZn = i;
        this.iZo = i2;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        long timestamp;
        AppMethodBeat.i(3176);
        this.gLJ = true;
        if (surfaceTexture instanceof SurfaceTexture) {
            timestamp = surfaceTexture.getTimestamp();
        } else {
            timestamp = -1;
        }
        this.lqo = timestamp;
        a.f.a.b bVar = this.lqn;
        if (bVar != null) {
            bVar.am(Long.valueOf(this.lqo));
            AppMethodBeat.o(3176);
            return;
        }
        AppMethodBeat.o(3176);
    }

    public final void release() {
        AppMethodBeat.i(3178);
        if (this.eNa) {
            this.eNa = false;
            ab.i(this.TAG, "release: ".concat(String.valueOf(this)));
            try {
                GLES20.glDeleteTextures(3, new int[]{this.lpX, this.lqi, this.lpr}, 0);
                GLES20.glDeleteProgram(this.lpY);
                GLES20.glDeleteProgram(this.lpg);
                GLES20.glDeleteFramebuffers(1, new int[]{this.lqh}, 0);
                bok();
                SurfaceTexture surfaceTexture = this.lql;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                h hVar = this.lpq;
                if (hVar == null) {
                    j.avw("ptFaceFrame");
                }
                hVar.clear();
                AppMethodBeat.o(3178);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "release error " + e.getMessage(), new Object[0]);
                AppMethodBeat.o(3178);
                return;
            }
        }
        AppMethodBeat.o(3178);
    }

    private final void bok() {
        AppMethodBeat.i(3179);
        ab.i(this.TAG, "releaseSegment: ".concat(String.valueOf(this)));
        try {
            this.lqp = false;
            PTSegment pTSegment = this.lpp;
            if (pTSegment != null) {
                pTSegment.destroy();
            }
            b bVar = this.lpo;
            if (bVar != null) {
                bVar.destroy();
            }
            GamePlaySDK.getInstance().clear();
            PTModule.getInstance().destroy();
            this.lpp = null;
            this.lpo = null;
            AppMethodBeat.o(3179);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "release segment error", new Object[0]);
            d dVar = d.lhz;
            d.bnj();
            AppMethodBeat.o(3179);
        }
    }

    public static /* synthetic */ void a(i iVar, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(3177);
        if (!(i == 0 || iVar.lpY == 0)) {
            int i4;
            GLES20.glUseProgram(iVar.lpY);
            iVar.eZi.position(0);
            GLES20.glVertexAttribPointer(iVar.lqa, 2, 5126, false, 0, iVar.eZi);
            GLES20.glEnableVertexAttribArray(iVar.lqa);
            iVar.eZh.position(0);
            iVar.eZh.put(c.eZZ);
            iVar.eZh.position(0);
            GLES20.glVertexAttribPointer(iVar.lpZ, 2, 5126, false, 0, iVar.eZh);
            GLES20.glEnableVertexAttribArray(iVar.lpZ);
            GLES20.glActiveTexture(33984);
            if (z) {
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
                GLES20.glUniform1i(iVar.lqb, 0);
                GLES20.glUniform1i(iVar.lqc, 2);
            } else {
                GLES20.glBindTexture(3553, i);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9728);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glUniform1i(iVar.lqc, 0);
                GLES20.glUniform1i(iVar.lqb, 2);
            }
            int i5 = iVar.lqg;
            if (z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            GLES20.glUniform1i(i5, i4);
            i4 = iVar.lqe;
            c.a aVar = c.lhw;
            GLES20.glUniform1f(i4, ((float) Math.max(i2, i3)) * 0.06666667f);
            GLES20.glUniform1i(iVar.lqf, 1);
            iVar.lqk.position(0);
            if (i2 > 0 && i3 > 0) {
                iVar.lqk.put((float) i2);
                iVar.lqk.put((float) i3);
                iVar.lqk.position(0);
            }
            GLES20.glUniform2fv(iVar.lqd, 1, iVar.lqk);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(iVar.lqa);
            GLES20.glDisableVertexAttribArray(iVar.lpZ);
            GLES20.glBindTexture(5890, 0);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
            GLES20.glUseProgram(0);
        }
        AppMethodBeat.o(3177);
    }
}
