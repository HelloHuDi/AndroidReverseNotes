package com.tencent.p177mm.plugin.emojicapture.p389ui.p951b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p206bu.C1333b;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010E\u001a\u00020\t2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010G\u001a\u00020\tJ\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020\tJ\b\u0010J\u001a\u00020\tH\u0002J@\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020'2\b\b\u0002\u0010M\u001a\u00020'2\b\b\u0002\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020\u00032\b\b\u0002\u0010P\u001a\u00020\u00032\b\b\u0002\u0010Q\u001a\u00020\u0003H\u0002J\b\u0010R\u001a\u00020\tH\u0002J\u0010\u0010S\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0003H\u0002J\b\u0010T\u001a\u0004\u0018\u00010AJ\u0006\u0010U\u001a\u00020\tJ\u0012\u0010\u0014\u001a\u00020\t2\b\u0010V\u001a\u0004\u0018\u00010AH\u0016J\u000e\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u0003J\u0006\u0010Y\u001a\u00020\tJ\b\u0010Z\u001a\u00020\tH\u0002J\u000e\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u0003J\u0016\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020'2\u0006\u0010_\u001a\u00020'J\u001a\u0010`\u001a\u00020\t2\u0006\u0010L\u001a\u00020'2\b\b\u0002\u0010Q\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "removeBgEnable", "", "(Z)V", "TAG", "", "afterDrawCallback", "Lkotlin/Function0;", "", "canDraw", "cubeArray", "", "kotlin.jvm.PlatformType", "cubeBuffer", "Ljava/nio/FloatBuffer;", "frameTimestamp", "", "init", "isDrawing", "onFrameAvailable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pts", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "ptFaceDetector", "Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "ptFaceFrame", "Lcom/tencent/filter/Frame;", "ptSegment", "Lcom/tencent/ttpic/PTSegment;", "removeBackground", "getRemoveBgEnable", "()Z", "renderAttributePosition", "", "renderAttributeTextureCoord", "renderProgramId", "renderUniformCalcRoundCorner", "renderUniformExternalTexture", "renderUniformNormalTexture", "renderUniformRadius", "renderUniformSize", "renderUniformUseNormalTexture", "segmentInit", "segmentOutputTexture", "sizeBuff", "stickerOutTexture", "textureCoordArray", "textureCoordBuff", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureFramebuffer", "toTextureOutputTexture", "toTextureProgramId", "toTextureUniformExternalTexture", "videoPlayRenderDepthBuffer", "videoPlayRenderFramebuffer", "videoPlayRenderOutputTexture", "videoPlayRenderTextureSize", "videoPlaySurface", "Landroid/graphics/SurfaceTexture;", "videoPlayTexture", "viewHeight", "viewWidth", "afterDraw", "callback", "checkInit", "currentFrameTimestamp", "drawFrame", "drawImpl", "drawVideoContent", "videoTexture", "drawWidth", "drawHeight", "externalTarget", "calcRoundCorner", "verticalFlip", "drawWithRemoveBackground", "drawWithStickerAndRemoveBackground", "getVideoPlaySurface", "initSegment", "surfaceTexture", "pauseDraw", "pause", "release", "releaseSegment", "setRemoveBackground", "remove", "setViewSize", "width", "height", "simpleDrawVideoContent", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.i */
public final class C38919i implements OnFrameAvailableListener {
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
    public C1333b lpo;
    public PTSegment lpp;
    public C41672h lpq;
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
    public C31214a<C37091y> lqm;
    public C17126b<? super Long, C37091y> lqn;
    private long lqo;
    public boolean lqp;

    public C38919i(boolean z) {
        AppMethodBeat.m2504i(3180);
        this.llN = z;
        C11617a c11617a = C34006c.lhw;
        this.lqj = C34006c.lht;
        float[] fArr = C27808c.eZY;
        this.gLB = Arrays.copyOf(fArr, fArr.length);
        fArr = C27808c.eZZ;
        this.gLC = Arrays.copyOf(fArr, fArr.length);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZi = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(this.gLC.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZh = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.lqk = asFloatBuffer;
        this.lqo = -1;
        AppMethodBeat.m2505o(3180);
    }

    /* renamed from: dY */
    public final void mo61808dY(int i, int i2) {
        this.iZn = i;
        this.iZo = i2;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        long timestamp;
        AppMethodBeat.m2504i(3176);
        this.gLJ = true;
        if (surfaceTexture instanceof SurfaceTexture) {
            timestamp = surfaceTexture.getTimestamp();
        } else {
            timestamp = -1;
        }
        this.lqo = timestamp;
        C17126b c17126b = this.lqn;
        if (c17126b != null) {
            c17126b.mo50am(Long.valueOf(this.lqo));
            AppMethodBeat.m2505o(3176);
            return;
        }
        AppMethodBeat.m2505o(3176);
    }

    public final void release() {
        AppMethodBeat.m2504i(3178);
        if (this.eNa) {
            this.eNa = false;
            C4990ab.m7416i(this.TAG, "release: ".concat(String.valueOf(this)));
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
                C41672h c41672h = this.lpq;
                if (c41672h == null) {
                    C25052j.avw("ptFaceFrame");
                }
                c41672h.clear();
                AppMethodBeat.m2505o(3178);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "release error " + e.getMessage(), new Object[0]);
                AppMethodBeat.m2505o(3178);
                return;
            }
        }
        AppMethodBeat.m2505o(3178);
    }

    private final void bok() {
        AppMethodBeat.m2504i(3179);
        C4990ab.m7416i(this.TAG, "releaseSegment: ".concat(String.valueOf(this)));
        try {
            this.lqp = false;
            PTSegment pTSegment = this.lpp;
            if (pTSegment != null) {
                pTSegment.destroy();
            }
            C1333b c1333b = this.lpo;
            if (c1333b != null) {
                c1333b.destroy();
            }
            GamePlaySDK.getInstance().clear();
            PTModule.getInstance().destroy();
            this.lpp = null;
            this.lpo = null;
            AppMethodBeat.m2505o(3179);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "release segment error", new Object[0]);
            C34007d c34007d = C34007d.lhz;
            C34007d.bnj();
            AppMethodBeat.m2505o(3179);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m66063a(C38919i c38919i, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(3177);
        if (!(i == 0 || c38919i.lpY == 0)) {
            int i4;
            GLES20.glUseProgram(c38919i.lpY);
            c38919i.eZi.position(0);
            GLES20.glVertexAttribPointer(c38919i.lqa, 2, 5126, false, 0, c38919i.eZi);
            GLES20.glEnableVertexAttribArray(c38919i.lqa);
            c38919i.eZh.position(0);
            c38919i.eZh.put(C27808c.eZZ);
            c38919i.eZh.position(0);
            GLES20.glVertexAttribPointer(c38919i.lpZ, 2, 5126, false, 0, c38919i.eZh);
            GLES20.glEnableVertexAttribArray(c38919i.lpZ);
            GLES20.glActiveTexture(33984);
            if (z) {
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
                GLES20.glUniform1i(c38919i.lqb, 0);
                GLES20.glUniform1i(c38919i.lqc, 2);
            } else {
                GLES20.glBindTexture(3553, i);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9728);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glUniform1i(c38919i.lqc, 0);
                GLES20.glUniform1i(c38919i.lqb, 2);
            }
            int i5 = c38919i.lqg;
            if (z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            GLES20.glUniform1i(i5, i4);
            i4 = c38919i.lqe;
            C11617a c11617a = C34006c.lhw;
            GLES20.glUniform1f(i4, ((float) Math.max(i2, i3)) * 0.06666667f);
            GLES20.glUniform1i(c38919i.lqf, 1);
            c38919i.lqk.position(0);
            if (i2 > 0 && i3 > 0) {
                c38919i.lqk.put((float) i2);
                c38919i.lqk.put((float) i3);
                c38919i.lqk.position(0);
            }
            GLES20.glUniform2fv(c38919i.lqd, 1, c38919i.lqk);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(c38919i.lqa);
            GLES20.glDisableVertexAttribArray(c38919i.lpZ);
            GLES20.glBindTexture(5890, 0);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
            GLES20.glUseProgram(0);
        }
        AppMethodBeat.m2505o(3177);
    }
}
