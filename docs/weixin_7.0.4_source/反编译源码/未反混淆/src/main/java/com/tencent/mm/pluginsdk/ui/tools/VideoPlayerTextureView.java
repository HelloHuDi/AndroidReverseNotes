package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView extends MMTextureView implements e {
    protected boolean VN;
    protected long bfp;
    protected long bgY;
    protected boolean eif;
    protected FileDescriptor fd;
    protected i llA;
    protected boolean llB;
    protected long llC;
    protected boolean llD;
    protected a llE;
    protected d llH;
    protected boolean llI;
    protected boolean llJ;
    protected boolean llK;
    protected boolean llL;
    protected boolean llM;
    protected c llO;
    protected Surface mSurface;
    protected int mVideoHeight;
    protected int mVideoWidth;
    protected b orK;
    protected String path;
    protected int vvp;
    protected boolean vvq;
    protected e vvr;
    private e.c vvs;
    private SurfaceTextureListener vvt;
    protected r vvu;

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(117988);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vvp = 0;
        this.VN = false;
        this.llB = true;
        this.llC = 0;
        this.vvq = false;
        this.llD = false;
        this.llI = false;
        this.llJ = false;
        this.llK = false;
        this.llL = false;
        this.llM = false;
        this.llO = new c() {
            public final void pL() {
                AppMethodBeat.i(117979);
                ab.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath());
                VideoPlayerTextureView.this.VN = true;
                VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.eif);
                if (VideoPlayerTextureView.this.llE != null) {
                    VideoPlayerTextureView.this.llE.pL();
                }
                VideoPlayerTextureView.this.requestLayout();
                AppMethodBeat.o(117979);
            }

            public final void EA() {
                AppMethodBeat.i(117980);
                if (VideoPlayerTextureView.this.llE != null) {
                    VideoPlayerTextureView.this.llE.EA();
                }
                AppMethodBeat.o(117980);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(117981);
                if (VideoPlayerTextureView.this.llE != null) {
                    VideoPlayerTextureView.this.llE.onError(i, i2);
                }
                AppMethodBeat.o(117981);
            }

            public final void bnT() {
                AppMethodBeat.i(117982);
                if (VideoPlayerTextureView.this.vvs != null) {
                    VideoPlayerTextureView.this.vvs.cU(VideoPlayerTextureView.this.llB);
                }
                if (VideoPlayerTextureView.this.llB) {
                    if (VideoPlayerTextureView.this.llA != null) {
                        ab.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", VideoPlayerTextureView.this.llA.aZm());
                        VideoPlayerTextureView.this.llA.start();
                    }
                    AppMethodBeat.o(117982);
                    return;
                }
                ab.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
                VideoPlayerTextureView.this.llB = true;
                AppMethodBeat.o(117982);
            }

            public final void S(int i, int i2, int i3) {
                AppMethodBeat.i(117983);
                ab.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                VideoPlayerTextureView.this.vvu.reset();
                VideoPlayerTextureView.this.vvp = i3;
                VideoPlayerTextureView.this.mVideoWidth = i;
                VideoPlayerTextureView.this.mVideoHeight = i2;
                VideoPlayerTextureView.this.dlB();
                if (VideoPlayerTextureView.this.llE != null) {
                    VideoPlayerTextureView.this.llE.dH(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
                }
                AppMethodBeat.o(117983);
            }
        };
        this.vvt = new SurfaceTextureListener() {
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(117984);
                VideoPlayerTextureView.this.b(surfaceTexture, i, i2);
                AppMethodBeat.o(117984);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(117985);
                ab.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
                VideoPlayerTextureView.this.dlB();
                AppMethodBeat.o(117985);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(117986);
                ab.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode()));
                VideoPlayerTextureView.this.mSurface = null;
                VideoPlayerTextureView.this.llL = false;
                VideoPlayerTextureView.this.llM = false;
                if (VideoPlayerTextureView.this.llA == null) {
                    VideoPlayerTextureView.this.llL = false;
                } else if (VideoPlayerTextureView.this.isPlaying()) {
                    VideoPlayerTextureView.this.llL = true;
                    VideoPlayerTextureView.this.llA.pause();
                }
                AppMethodBeat.o(117986);
                return false;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(117987);
                VideoPlayerTextureView.this.i(surfaceTexture);
                AppMethodBeat.o(117987);
            }
        };
        this.vvu = new r();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.vvt);
        setFocusable(true);
        setFocusableInTouchMode(true);
        AppMethodBeat.o(117988);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(138351);
        if (this.mSurface != null && this.mSurface.isValid()) {
            this.mSurface.release();
        }
        AppMethodBeat.o(138351);
    }

    public void setOneTimeVideoTextureUpdateCallback(e eVar) {
        this.vvr = eVar;
    }

    public void setOnSeekCompleteCallback(e.c cVar) {
        this.vvs = cVar;
    }

    public void setOnInfoCallback(e.b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
        this.llH = dVar;
    }

    public void setIOnlineCache(b bVar) {
        this.orK = bVar;
    }

    public void setNeedResetExtractor(boolean z) {
        AppMethodBeat.i(117989);
        this.llI = z;
        if (this.llA != null) {
            this.llA.setNeedResetExtractor(z);
        }
        AppMethodBeat.o(117989);
    }

    public void setIsOnlineVideoType(boolean z) {
        AppMethodBeat.i(117990);
        this.llJ = z;
        if (this.llA != null) {
            this.llA.setIsOnlineVideoType(z);
        }
        AppMethodBeat.o(117990);
    }

    public void setUseMp4Extrator(boolean z) {
        if (this.llA != null) {
            this.llK = z;
        }
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(117991);
        if (this.llA != null) {
            boolean isPlaying = this.llA.isPlaying();
            AppMethodBeat.o(117991);
            return isPlaying;
        }
        AppMethodBeat.o(117991);
        return false;
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(117992);
        ab.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        bnS();
        requestLayout();
        AppMethodBeat.o(117992);
    }

    public final void dlA() {
        AppMethodBeat.i(117993);
        ab.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", Integer.valueOf(hashCode()));
        if (this.llA != null) {
            i iVar = this.llA;
            if (iVar.orX != null) {
                iVar.orX.bPc();
            }
        }
        AppMethodBeat.o(117993);
    }

    public String getVideoPath() {
        return this.path;
    }

    public void setOpenWithNoneSurface(boolean z) {
        this.llD = z;
    }

    public boolean start() {
        AppMethodBeat.i(117994);
        String str;
        String str2;
        Object[] objArr;
        if (this.llA == null || !this.VN) {
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
            objArr[2] = Boolean.valueOf(this.VN);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(117994);
            return false;
        }
        str = "MicroMsg.VideoPlayerTextureView";
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.llM);
        objArr[2] = Boolean.valueOf(this.llL);
        objArr[3] = Boolean.valueOf(this.mSurface != null);
        ab.i(str, str2, objArr);
        if (this.mSurface == null) {
            this.llL = true;
            AppMethodBeat.o(117994);
            return true;
        } else if (this.llM) {
            this.llL = true;
            this.llM = false;
            setMute(this.eif);
            AppMethodBeat.o(117994);
            return true;
        } else {
            this.llA.start();
            AppMethodBeat.o(117994);
            return true;
        }
    }

    public final boolean w(Context context, boolean z) {
        AppMethodBeat.i(117995);
        boolean start = start();
        AppMethodBeat.o(117995);
        return start;
    }

    public void stop() {
        AppMethodBeat.i(117996);
        ab.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", Integer.valueOf(hashCode()), bo.dpG());
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
        this.VN = false;
        this.path = null;
        this.fd = null;
        this.llC = 0;
        AppMethodBeat.o(117996);
    }

    public void pause() {
        AppMethodBeat.i(117997);
        if (this.llA != null && this.llA.isPlaying()) {
            this.llA.pause();
        }
        this.llL = false;
        AppMethodBeat.o(117997);
    }

    public final void onDetach() {
    }

    public void setLoop(boolean z) {
    }

    public void setVideoCallback(a aVar) {
        this.llE = aVar;
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(117998);
        if (this.llA != null) {
            int bPb = this.llA.bPb();
            AppMethodBeat.o(117998);
            return bPb;
        }
        AppMethodBeat.o(117998);
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

    public void B(double d) {
        AppMethodBeat.i(117999);
        if (this.llA != null) {
            this.llA.yI((int) d);
        }
        AppMethodBeat.o(117999);
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(118000);
        this.llB = z;
        B(d);
        AppMethodBeat.o(118000);
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
        AppMethodBeat.i(118001);
        this.eif = z;
        if (this.llA != null) {
            ab.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z));
            this.llA.setMute(z);
        }
        AppMethodBeat.o(118001);
    }

    /* Access modifiers changed, original: protected */
    public void bnS() {
        AppMethodBeat.i(118002);
        ab.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", Integer.valueOf(hashCode()), this.path, this.mSurface);
        if (this.llA != null) {
            this.llA.orY = null;
            this.llA.orX.stop();
            this.llA.release();
            this.llA = null;
        }
        if ((!bo.isNullOrNil(this.path) || (this.fd != null && this.fd.valid())) && this.mSurface != null) {
            try {
                this.VN = false;
                this.llA = new i(Looper.getMainLooper());
                if (!bo.isNullOrNil(this.path)) {
                    this.llA.setPath(this.path);
                } else if (this.fd != null && this.fd.valid()) {
                    i iVar = this.llA;
                    iVar.orX.osg.a(this.fd, this.bfp, this.bgY);
                }
                this.llA.setIOnlineCache(this.orK);
                this.llA.setNeedResetExtractor(this.llI);
                this.llA.setIsOnlineVideoType(this.llJ);
                this.llA.orY = this.llO;
                this.llA.setSurface(this.mSurface);
                this.llA.iU(this.llK);
                if (this.mSurface != null) {
                    this.llA.prepare();
                    AppMethodBeat.o(118002);
                    return;
                }
                if (this.llD) {
                    this.llA.prepare();
                }
                AppMethodBeat.o(118002);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "prepare async error %s", e.getMessage());
                if (this.llE != null) {
                    this.llE.onError(-1, -1);
                }
                AppMethodBeat.o(118002);
                return;
            }
        }
        ab.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
        AppMethodBeat.o(118002);
    }

    public final void bPd() {
        AppMethodBeat.i(118003);
        if (!(this.llA == null || !this.VN || this.mSurface == null)) {
            ab.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", Integer.valueOf(hashCode()));
            i iVar = this.llA;
            if (iVar.orX != null) {
                iVar.orX.bPd();
            }
        }
        AppMethodBeat.o(118003);
    }

    /* Access modifiers changed, original: protected */
    public void b(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(118004);
        ab.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.llL));
        try {
            dAh();
            this.mSurface = new Surface(surfaceTexture);
            if (this.llA == null || !this.VN) {
                bnS();
            } else {
                this.llA.f(this.mSurface);
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
            AppMethodBeat.o(118004);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
            AppMethodBeat.o(118004);
        }
    }

    /* Access modifiers changed, original: protected */
    public void i(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(118005);
        if (this.llM && this.llC > 0 && this.llA != null) {
            this.llA.pause();
            this.llA.setMute(this.eif);
            this.llM = false;
        }
        if (this.llC > 0 && this.vvr != null) {
            ab.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
            this.vvr.bQL();
            this.vvr = null;
        }
        this.llC = System.currentTimeMillis();
        AppMethodBeat.o(118005);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dlB() {
        AppMethodBeat.i(118006);
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(118006);
    }

    public void setScaleType(h.d dVar) {
        AppMethodBeat.i(118007);
        this.vvu.setScaleType(dVar);
        requestLayout();
        AppMethodBeat.o(118007);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(118008);
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.o(118008);
            return;
        }
        this.vvu.I(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
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
        AppMethodBeat.o(118008);
    }
}
