package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.p468n.C34602i;
import com.tencent.p177mm.plugin.p468n.C39453c;
import com.tencent.p177mm.plugin.p468n.C43332b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.FileDescriptor;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView */
public class VideoPlayerTextureView extends MMTextureView implements C14979e {
    /* renamed from: VN */
    protected boolean f17239VN;
    protected long bfp;
    protected long bgY;
    protected boolean eif;
    /* renamed from: fd */
    protected FileDescriptor f17240fd;
    protected C34602i llA;
    protected boolean llB;
    protected long llC;
    protected boolean llD;
    protected C14981a llE;
    protected C14978d llH;
    protected boolean llI;
    protected boolean llJ;
    protected boolean llK;
    protected boolean llL;
    protected boolean llM;
    protected C39453c llO;
    protected Surface mSurface;
    protected int mVideoHeight;
    protected int mVideoWidth;
    protected C43332b orK;
    protected String path;
    protected int vvp;
    protected boolean vvq;
    protected C14980e vvr;
    private C14982c vvs;
    private SurfaceTextureListener vvt;
    protected C40489r vvu;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView$1 */
    class C233431 implements C39453c {
        C233431() {
        }

        /* renamed from: pL */
        public final void mo39086pL() {
            AppMethodBeat.m2504i(117979);
            C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath());
            VideoPlayerTextureView.this.f17239VN = true;
            VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.eif);
            if (VideoPlayerTextureView.this.llE != null) {
                VideoPlayerTextureView.this.llE.mo8557pL();
            }
            VideoPlayerTextureView.this.requestLayout();
            AppMethodBeat.m2505o(117979);
        }

        /* renamed from: EA */
        public final void mo39082EA() {
            AppMethodBeat.m2504i(117980);
            if (VideoPlayerTextureView.this.llE != null) {
                VideoPlayerTextureView.this.llE.mo8553EA();
            }
            AppMethodBeat.m2505o(117980);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(117981);
            if (VideoPlayerTextureView.this.llE != null) {
                VideoPlayerTextureView.this.llE.onError(i, i2);
            }
            AppMethodBeat.m2505o(117981);
        }

        public final void bnT() {
            AppMethodBeat.m2504i(117982);
            if (VideoPlayerTextureView.this.vvs != null) {
                VideoPlayerTextureView.this.vvs.mo9067cU(VideoPlayerTextureView.this.llB);
            }
            if (VideoPlayerTextureView.this.llB) {
                if (VideoPlayerTextureView.this.llA != null) {
                    C4990ab.m7411d("MicroMsg.VideoPlayerTextureView", "%s player seek done", VideoPlayerTextureView.this.llA.aZm());
                    VideoPlayerTextureView.this.llA.start();
                }
                AppMethodBeat.m2505o(117982);
                return;
            }
            C4990ab.m7410d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
            VideoPlayerTextureView.this.llB = true;
            AppMethodBeat.m2505o(117982);
        }

        /* renamed from: S */
        public final void mo39083S(int i, int i2, int i3) {
            AppMethodBeat.m2504i(117983);
            C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            VideoPlayerTextureView.this.vvu.reset();
            VideoPlayerTextureView.this.vvp = i3;
            VideoPlayerTextureView.this.mVideoWidth = i;
            VideoPlayerTextureView.this.mVideoHeight = i2;
            VideoPlayerTextureView.this.dlB();
            if (VideoPlayerTextureView.this.llE != null) {
                VideoPlayerTextureView.this.llE.mo8555dH(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
            }
            AppMethodBeat.m2505o(117983);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView$2 */
    class C440922 implements SurfaceTextureListener {
        C440922() {
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(117984);
            VideoPlayerTextureView.this.mo63189b(surfaceTexture, i, i2);
            AppMethodBeat.m2505o(117984);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(117985);
            C4990ab.m7411d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
            VideoPlayerTextureView.this.dlB();
            AppMethodBeat.m2505o(117985);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(117986);
            C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode()));
            VideoPlayerTextureView.this.mSurface = null;
            VideoPlayerTextureView.this.llL = false;
            VideoPlayerTextureView.this.llM = false;
            if (VideoPlayerTextureView.this.llA == null) {
                VideoPlayerTextureView.this.llL = false;
            } else if (VideoPlayerTextureView.this.isPlaying()) {
                VideoPlayerTextureView.this.llL = true;
                VideoPlayerTextureView.this.llA.pause();
            }
            AppMethodBeat.m2505o(117986);
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(117987);
            VideoPlayerTextureView.this.mo9053i(surfaceTexture);
            AppMethodBeat.m2505o(117987);
        }
    }

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(117988);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vvp = 0;
        this.f17239VN = false;
        this.llB = true;
        this.llC = 0;
        this.vvq = false;
        this.llD = false;
        this.llI = false;
        this.llJ = false;
        this.llK = false;
        this.llL = false;
        this.llM = false;
        this.llO = new C233431();
        this.vvt = new C440922();
        this.vvu = new C40489r();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.vvt);
        setFocusable(true);
        setFocusableInTouchMode(true);
        AppMethodBeat.m2505o(117988);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(138351);
        if (this.mSurface != null && this.mSurface.isValid()) {
            this.mSurface.release();
        }
        AppMethodBeat.m2505o(138351);
    }

    public void setOneTimeVideoTextureUpdateCallback(C14980e c14980e) {
        this.vvr = c14980e;
    }

    public void setOnSeekCompleteCallback(C14982c c14982c) {
        this.vvs = c14982c;
    }

    public void setOnInfoCallback(C14983b c14983b) {
    }

    public void setOnSurfaceCallback(C14978d c14978d) {
        this.llH = c14978d;
    }

    public void setIOnlineCache(C43332b c43332b) {
        this.orK = c43332b;
    }

    public void setNeedResetExtractor(boolean z) {
        AppMethodBeat.m2504i(117989);
        this.llI = z;
        if (this.llA != null) {
            this.llA.setNeedResetExtractor(z);
        }
        AppMethodBeat.m2505o(117989);
    }

    public void setIsOnlineVideoType(boolean z) {
        AppMethodBeat.m2504i(117990);
        this.llJ = z;
        if (this.llA != null) {
            this.llA.setIsOnlineVideoType(z);
        }
        AppMethodBeat.m2505o(117990);
    }

    public void setUseMp4Extrator(boolean z) {
        if (this.llA != null) {
            this.llK = z;
        }
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(117991);
        if (this.llA != null) {
            boolean isPlaying = this.llA.isPlaying();
            AppMethodBeat.m2505o(117991);
            return isPlaying;
        }
        AppMethodBeat.m2505o(117991);
        return false;
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(117992);
        C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        bnS();
        requestLayout();
        AppMethodBeat.m2505o(117992);
    }

    public final void dlA() {
        AppMethodBeat.m2504i(117993);
        C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d reset source ", Integer.valueOf(hashCode()));
        if (this.llA != null) {
            C34602i c34602i = this.llA;
            if (c34602i.orX != null) {
                c34602i.orX.bPc();
            }
        }
        AppMethodBeat.m2505o(117993);
    }

    public String getVideoPath() {
        return this.path;
    }

    public void setOpenWithNoneSurface(boolean z) {
        this.llD = z;
    }

    public boolean start() {
        AppMethodBeat.m2504i(117994);
        String str;
        String str2;
        Object[] objArr;
        if (this.llA == null || !this.f17239VN) {
            boolean z;
            str = "MicroMsg.VideoPlayerTextureView";
            str2 = "%d player is null[%b] or it prepared [%b]";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.llA == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.f17239VN);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(117994);
            return false;
        }
        str = "MicroMsg.VideoPlayerTextureView";
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.llM);
        objArr[2] = Boolean.valueOf(this.llL);
        objArr[3] = Boolean.valueOf(this.mSurface != null);
        C4990ab.m7417i(str, str2, objArr);
        if (this.mSurface == null) {
            this.llL = true;
            AppMethodBeat.m2505o(117994);
            return true;
        } else if (this.llM) {
            this.llL = true;
            this.llM = false;
            setMute(this.eif);
            AppMethodBeat.m2505o(117994);
            return true;
        } else {
            this.llA.start();
            AppMethodBeat.m2505o(117994);
            return true;
        }
    }

    /* renamed from: w */
    public final boolean mo27377w(Context context, boolean z) {
        AppMethodBeat.m2504i(117995);
        boolean start = start();
        AppMethodBeat.m2505o(117995);
        return start;
    }

    public void stop() {
        AppMethodBeat.m2504i(117996);
        C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", Integer.valueOf(hashCode()), C5046bo.dpG());
        if (this.llA != null) {
            this.llA.orY = null;
            this.llA.orX.stop();
            this.llA.release();
            this.llA = null;
        }
        this.vvp = 0;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vvu.reset();
        this.f17239VN = false;
        this.path = null;
        this.f17240fd = null;
        this.llC = 0;
        AppMethodBeat.m2505o(117996);
    }

    public void pause() {
        AppMethodBeat.m2504i(117997);
        if (this.llA != null && this.llA.isPlaying()) {
            this.llA.pause();
        }
        this.llL = false;
        AppMethodBeat.m2505o(117997);
    }

    public final void onDetach() {
    }

    public void setLoop(boolean z) {
    }

    public void setVideoCallback(C14981a c14981a) {
        this.llE = c14981a;
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(117998);
        if (this.llA != null) {
            int bPb = this.llA.bPb();
            AppMethodBeat.m2505o(117998);
            return bPb;
        }
        AppMethodBeat.m2505o(117998);
        return 0;
    }

    public int getDuration() {
        if (this.llA != null) {
            return (int) this.llA.orX.bfi;
        }
        return 0;
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    /* renamed from: B */
    public void mo9052B(double d) {
        AppMethodBeat.m2504i(117999);
        if (this.llA != null) {
            this.llA.mo55186yI((int) d);
        }
        AppMethodBeat.m2505o(117999);
    }

    /* renamed from: d */
    public final void mo27356d(double d, boolean z) {
        AppMethodBeat.m2504i(118000);
        this.llB = z;
        mo9052B(d);
        AppMethodBeat.m2505o(118000);
    }

    public void setPlayProgressCallback(boolean z) {
    }

    public long getLastSurfaceUpdateTime() {
        return this.llC;
    }

    public void setForceScaleFullScreen(boolean z) {
        this.vvq = z;
        this.vvu.vvq = this.vvq;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(118001);
        this.eif = z;
        if (this.llA != null) {
            C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z));
            this.llA.setMute(z);
        }
        AppMethodBeat.m2505o(118001);
    }

    /* Access modifiers changed, original: protected */
    public void bnS() {
        AppMethodBeat.m2504i(118002);
        C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", Integer.valueOf(hashCode()), this.path, this.mSurface);
        if (this.llA != null) {
            this.llA.orY = null;
            this.llA.orX.stop();
            this.llA.release();
            this.llA = null;
        }
        if ((!C5046bo.isNullOrNil(this.path) || (this.f17240fd != null && this.f17240fd.valid())) && this.mSurface != null) {
            try {
                this.f17239VN = false;
                this.llA = new C34602i(Looper.getMainLooper());
                if (!C5046bo.isNullOrNil(this.path)) {
                    this.llA.setPath(this.path);
                } else if (this.f17240fd != null && this.f17240fd.valid()) {
                    C34602i c34602i = this.llA;
                    c34602i.orX.osg.mo24679a(this.f17240fd, this.bfp, this.bgY);
                }
                this.llA.setIOnlineCache(this.orK);
                this.llA.setNeedResetExtractor(this.llI);
                this.llA.setIsOnlineVideoType(this.llJ);
                this.llA.orY = this.llO;
                this.llA.setSurface(this.mSurface);
                this.llA.mo55172iU(this.llK);
                if (this.mSurface != null) {
                    this.llA.prepare();
                    AppMethodBeat.m2505o(118002);
                    return;
                }
                if (this.llD) {
                    this.llA.prepare();
                }
                AppMethodBeat.m2505o(118002);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "prepare async error %s", e.getMessage());
                if (this.llE != null) {
                    this.llE.onError(-1, -1);
                }
                AppMethodBeat.m2505o(118002);
                return;
            }
        }
        C4990ab.m7421w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(118002);
    }

    public final void bPd() {
        AppMethodBeat.m2504i(118003);
        if (!(this.llA == null || !this.f17239VN || this.mSurface == null)) {
            C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", Integer.valueOf(hashCode()));
            C34602i c34602i = this.llA;
            if (c34602i.orX != null) {
                c34602i.orX.bPd();
            }
        }
        AppMethodBeat.m2505o(118003);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo63189b(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(118004);
        C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.llL));
        try {
            dAh();
            this.mSurface = new Surface(surfaceTexture);
            if (this.llA == null || !this.f17239VN) {
                bnS();
            } else {
                this.llA.mo55170f(this.mSurface);
                if (this.llL) {
                    this.llA.start();
                } else {
                    this.llM = true;
                    this.llC = 0;
                    this.llA.setMute(true);
                    this.llA.start();
                }
                this.llL = false;
            }
            dlB();
            if (this.llH != null) {
                this.llH.akY();
            }
            AppMethodBeat.m2505o(118004);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
            AppMethodBeat.m2505o(118004);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: i */
    public void mo9053i(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(118005);
        if (this.llM && this.llC > 0 && this.llA != null) {
            this.llA.pause();
            this.llA.setMute(this.eif);
            this.llM = false;
        }
        if (this.llC > 0 && this.vvr != null) {
            C4990ab.m7417i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
            this.vvr.bQL();
            this.vvr = null;
        }
        this.llC = System.currentTimeMillis();
        AppMethodBeat.m2505o(118005);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dlB() {
        AppMethodBeat.m2504i(118006);
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(118006);
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(118007);
        this.vvu.setScaleType(c35873d);
        requestLayout();
        AppMethodBeat.m2505o(118007);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(118008);
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.m2505o(118008);
            return;
        }
        this.vvu.mo64033I(VideoPlayerTextureView.getDefaultSize(1, i), VideoPlayerTextureView.getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        int i3 = this.vvu.iew;
        int i4 = this.vvu.iex;
        if (this.vvp == 90 || this.vvp == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            float f = ((float) i3) / 2.0f;
            float f2 = ((float) i4) / 2.0f;
            float f3 = ((float) i4) / ((float) i3);
            if (!(getScaleX() == 1.0f && getScaleY() == 1.0f)) {
                matrix.setScale(getScaleX(), getScaleY(), f, f2);
            }
            matrix.postRotate((float) this.vvp, f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
        }
        setMeasuredDimension(i3, i4);
        AppMethodBeat.m2505o(118008);
    }
}
