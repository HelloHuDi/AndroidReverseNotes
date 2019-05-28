package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.FileDescriptor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView */
public class VideoTextureView extends MMTextureView implements C14979e {
    protected long bfp;
    protected long bgY;
    private boolean eif;
    private boolean fVc;
    /* renamed from: fd */
    protected FileDescriptor f17241fd;
    private MediaPlayer ieC;
    OnPreparedListener ieD;
    OnVideoSizeChangedListener ieE;
    private OnCompletionListener ieF;
    private OnErrorListener ieI;
    private boolean ief;
    private int ieu;
    private int iev;
    private long llC;
    private C14981a llE;
    private C14978d llH;
    private boolean llL;
    private boolean llM;
    private int mDuration;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private float speed;
    private long startTime;
    private String vvD;
    private boolean vvE;
    private C14983b vvH;
    private long vvI;
    private int vvJ;
    private OnSeekCompleteListener vvK;
    private OnBufferingUpdateListener vvL;
    private OnInfoListener vvM;
    private boolean vvN;
    private boolean vvq;
    private C14980e vvr;
    private C14982c vvs;
    SurfaceTextureListener vvt;
    private C40489r vvu;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$6 */
    class C47676 implements OnInfoListener {
        C47676() {
        }

        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(118014);
            C4990ab.m7411d("MicroMsg.VideoTextureView", "onInfo [%d %d]", Integer.valueOf(i), Integer.valueOf(i2));
            if (VideoTextureView.this.vvH != null) {
                VideoTextureView.this.vvH.mo27219gO(i, i2);
            }
            AppMethodBeat.m2505o(118014);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$7 */
    class C47687 implements OnCompletionListener {
        C47687() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(118015);
            C4990ab.m7416i("MicroMsg.VideoTextureView", "video on completion");
            VideoTextureView.this.vvI = C5046bo.anT();
            if (VideoTextureView.this.llE != null) {
                VideoTextureView.this.llE.mo8553EA();
            }
            AppMethodBeat.m2505o(118015);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$8 */
    class C47698 implements OnErrorListener {
        C47698() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(118016);
            C4990ab.m7420w("MicroMsg.VideoTextureView", "Error: " + i + "," + i2);
            if (VideoTextureView.this.llE != null) {
                VideoTextureView.this.llE.onError(i, i2);
            }
            AppMethodBeat.m2505o(118016);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$9 */
    class C149749 implements SurfaceTextureListener {
        C149749() {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(118017);
            C4990ab.m7410d("MicroMsg.VideoTextureView", "on surface texture updated");
            if (VideoTextureView.this.llM) {
                if (VideoTextureView.this.ieC != null) {
                    VideoTextureView.this.ieC.pause();
                    if (VideoTextureView.this.eif) {
                        VideoTextureView.this.ieC.setVolume(0.0f, 0.0f);
                    } else {
                        VideoTextureView.this.ieC.setVolume(1.0f, 1.0f);
                    }
                }
                VideoTextureView.this.llM = false;
            }
            if (VideoTextureView.this.llC > 0 && VideoTextureView.this.vvr != null) {
                VideoTextureView.this.vvr.bQL();
                VideoTextureView.this.vvr = null;
            }
            VideoTextureView.this.llC = System.currentTimeMillis();
            if (VideoTextureView.this.vvN) {
                C4990ab.m7417i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()));
                if (VideoTextureView.this.ieC != null) {
                    VideoTextureView.this.ieC.pause();
                    VideoTextureView.this.setMute(VideoTextureView.this.eif);
                }
                VideoTextureView.this.vvN = false;
            }
            AppMethodBeat.m2505o(118017);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(118018);
            C4990ab.m7416i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
            if (VideoTextureView.this.ieC != null && VideoTextureView.this.vvE && VideoTextureView.this.mVideoWidth == i && VideoTextureView.this.mVideoHeight == i2) {
                VideoTextureView.this.ieC.start();
            }
            AppMethodBeat.m2505o(118018);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(118019);
            C4990ab.m7417i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.this.vvE));
            VideoTextureView.this.mSurface = null;
            if (VideoTextureView.this.ieC == null || !VideoTextureView.this.vvE) {
                VideoTextureView.m79353t(VideoTextureView.this);
                VideoTextureView.this.llL = false;
            } else if (VideoTextureView.this.isPlaying()) {
                VideoTextureView.this.llL = true;
                VideoTextureView.this.ieC.pause();
            }
            AppMethodBeat.m2505o(118019);
            return false;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(118020);
            VideoTextureView.this.ieu = i;
            VideoTextureView.this.iev = i2;
            VideoTextureView.this.dAh();
            VideoTextureView.this.mSurface = new Surface(surfaceTexture);
            C4990ab.m7417i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoTextureView.this.vvE), Integer.valueOf(VideoTextureView.this.mSurface.hashCode()));
            if (VideoTextureView.this.ieC == null || !VideoTextureView.this.vvE) {
                VideoTextureView.m79355v(VideoTextureView.this);
            } else {
                VideoTextureView.this.ieC.setSurface(VideoTextureView.this.mSurface);
                if (VideoTextureView.this.llL) {
                    VideoTextureView.this.ieC.start();
                } else {
                    VideoTextureView.this.llM = true;
                    VideoTextureView.this.ieC.setVolume(0.0f, 0.0f);
                    VideoTextureView.this.ieC.start();
                }
                VideoTextureView.this.llL = false;
            }
            if (VideoTextureView.this.llH != null) {
                VideoTextureView.this.llH.akY();
            }
            AppMethodBeat.m2505o(118020);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$2 */
    class C358872 implements OnVideoSizeChangedListener {
        C358872() {
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(118010);
            try {
                if (mediaPlayer != VideoTextureView.this.ieC) {
                    C4990ab.m7421w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", mediaPlayer, VideoTextureView.this.ieC);
                    AppMethodBeat.m2505o(118010);
                    return;
                }
                VideoTextureView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoTextureView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                C4990ab.m7416i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.this.mVideoWidth + " , " + VideoTextureView.this.mVideoHeight + " )");
                if (VideoTextureView.this.llE != null) {
                    VideoTextureView.this.llE.mo8555dH(VideoTextureView.this.mVideoWidth, VideoTextureView.this.mVideoHeight);
                }
                VideoTextureView.m79338e(VideoTextureView.this);
                AppMethodBeat.m2505o(118010);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$3 */
    class C358883 implements OnPreparedListener {
        C358883() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(118011);
            if (mediaPlayer == VideoTextureView.this.ieC || mediaPlayer == null) {
                int videoHeight;
                VideoTextureView.this.vvE = true;
                VideoTextureView.this.mVideoWidth = mediaPlayer != null ? mediaPlayer.getVideoWidth() : 0;
                VideoTextureView videoTextureView = VideoTextureView.this;
                if (mediaPlayer != null) {
                    videoHeight = mediaPlayer.getVideoHeight();
                } else {
                    videoHeight = 0;
                }
                videoTextureView.mVideoHeight = videoHeight;
                C4990ab.m7417i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(VideoTextureView.this.mVideoWidth), Integer.valueOf(VideoTextureView.this.mVideoHeight), Boolean.valueOf(VideoTextureView.this.ief));
                VideoTextureView.m79338e(VideoTextureView.this);
                if (VideoTextureView.this.mVideoWidth == 0 || VideoTextureView.this.mVideoHeight == 0) {
                    if (VideoTextureView.this.ief) {
                        VideoTextureView.this.ieC.start();
                        VideoTextureView.this.ief = false;
                        VideoTextureView.this.ieC.setLooping(VideoTextureView.this.fVc);
                    }
                } else if (VideoTextureView.this.ief) {
                    VideoTextureView.this.ieC.start();
                    VideoTextureView.this.ieC.setLooping(VideoTextureView.this.fVc);
                    VideoTextureView.this.ief = false;
                }
                if (VideoTextureView.this.llE != null) {
                    VideoTextureView.this.llE.mo8557pL();
                }
                AppMethodBeat.m2505o(118011);
                return;
            }
            C4990ab.m7421w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, VideoTextureView.this.ieC);
            VideoTextureView.m79326a(VideoTextureView.this, mediaPlayer);
            AppMethodBeat.m2505o(118011);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$4 */
    class C358894 implements OnSeekCompleteListener {
        C358894() {
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(118012);
            int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
            C4990ab.m7417i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(currentPosition), Boolean.valueOf(VideoTextureView.this.ief), Boolean.valueOf(VideoTextureView.this.llM));
            if (!VideoTextureView.this.ief) {
                VideoTextureView.this.pause();
            } else if (VideoTextureView.this.llM) {
                AppMethodBeat.m2505o(118012);
                return;
            } else {
                VideoTextureView.this.start();
            }
            if (VideoTextureView.this.vvs != null) {
                VideoTextureView.this.vvs.mo9067cU(VideoTextureView.this.ief);
            }
            VideoTextureView.this.llC = 0;
            AppMethodBeat.m2505o(118012);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoTextureView$5 */
    class C440935 implements OnBufferingUpdateListener {
        C440935() {
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            AppMethodBeat.m2504i(118013);
            C4990ab.m7411d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", Integer.valueOf(i));
            VideoTextureView.this.vvJ = i;
            AppMethodBeat.m2505o(118013);
        }
    }

    /* renamed from: t */
    static /* synthetic */ void m79353t(VideoTextureView videoTextureView) {
        AppMethodBeat.m2504i(118043);
        videoTextureView.dlC();
        AppMethodBeat.m2505o(118043);
    }

    /* renamed from: v */
    static /* synthetic */ void m79355v(VideoTextureView videoTextureView) {
        AppMethodBeat.m2504i(118044);
        videoTextureView.bnS();
        AppMethodBeat.m2505o(118044);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(118021);
        this.mSurface = null;
        this.ieC = null;
        this.startTime = 0;
        this.vvI = 0;
        this.ieu = 0;
        this.iev = 0;
        this.vvJ = 0;
        this.fVc = false;
        this.vvq = false;
        this.ieE = new C358872();
        this.ieD = new C358883();
        this.vvK = new C358894();
        this.vvL = new C440935();
        this.vvM = new C47676();
        this.ieF = new C47687();
        this.ieI = new C47698();
        this.llC = 0;
        this.llL = false;
        this.llM = false;
        this.vvN = false;
        this.vvt = new C149749();
        this.eif = false;
        this.vvu = new C40489r();
        this.speed = -1.0f;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.vvt);
        setFocusable(true);
        setFocusableInTouchMode(true);
        AppMethodBeat.m2505o(118021);
    }

    public void setOneTimeVideoTextureUpdateCallback(C14980e c14980e) {
        this.vvr = c14980e;
    }

    public void setOnSeekCompleteCallback(C14982c c14982c) {
        this.vvs = c14982c;
    }

    public void setOnInfoCallback(C14983b c14983b) {
        this.vvH = c14983b;
    }

    public void setOnSurfaceCallback(C14978d c14978d) {
        this.llH = c14978d;
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(118022);
        this.vvD = str;
        this.ief = false;
        bnS();
        requestLayout();
        AppMethodBeat.m2505o(118022);
    }

    public String getVideoPath() {
        return this.vvD;
    }

    public int getDownloadPercent() {
        return this.vvJ;
    }

    public final void stop() {
        long j;
        AppMethodBeat.m2504i(118023);
        long j2 = this.vvI > 0 ? this.vvI - this.startTime : 2147483647L;
        long anT = C5046bo.anT() - this.startTime;
        if (j2 > anT) {
            j = anT;
        } else {
            j = j2;
        }
        int i = ((int) j) * 1000;
        if (i > getDuration()) {
            i = getDuration();
        }
        C4990ab.m7417i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(anT), Long.valueOf(j2));
        if (this.llE != null) {
            this.llE.mo8554dG(i, getDuration());
        }
        dlC();
        this.vvu.reset();
        try {
            if (this.mSurface != null && this.vvE) {
                SurfaceTexture surfaceTexture = getSurfaceTexture();
                if (surfaceTexture != null) {
                    C4990ab.m7417i("MicroMsg.VideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                    egl10.eglInitialize(eglGetDisplay, null);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                    eglCreateWindowSurface = EGL10.EGL_NO_SURFACE;
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    egl10.eglTerminate(eglGetDisplay);
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "release surface", new Object[0]);
        }
        this.vvD = "";
        this.vvJ = 0;
        this.vvE = false;
        this.ief = false;
        this.llC = 0;
        AppMethodBeat.m2505o(118023);
    }

    private void dlC() {
        boolean z = true;
        AppMethodBeat.m2504i(118024);
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.vvE);
        if (this.ieC != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (this.ieC != null) {
            this.ieC.setOnErrorListener(null);
            this.ieC.setOnVideoSizeChangedListener(null);
            try {
                this.ieC.stop();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "stop media player error", new Object[0]);
            }
            try {
                this.ieC.reset();
                this.ieC.release();
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.VideoTextureView", e2, "reset media player error", new Object[0]);
            }
        }
        this.ieC = null;
        AppMethodBeat.m2505o(118024);
    }

    private void bnS() {
        AppMethodBeat.m2504i(118025);
        if ((!C5046bo.isNullOrNil(this.vvD) || (this.f17241fd != null && this.f17241fd.valid())) && this.mSurface != null) {
            dlC();
            C4990ab.m7417i("MicroMsg.VideoTextureView", "%d open video %s", Integer.valueOf(hashCode()), this.vvD);
            try {
                this.ieC = new C45289k();
                this.ieC.setOnPreparedListener(this.ieD);
                this.ieC.setOnVideoSizeChangedListener(this.ieE);
                this.vvE = false;
                C4990ab.m7418v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.vvJ = 0;
                this.ieC.setOnCompletionListener(this.ieF);
                this.ieC.setOnErrorListener(this.ieI);
                this.ieC.setOnSeekCompleteListener(this.vvK);
                this.ieC.setOnBufferingUpdateListener(this.vvL);
                this.ieC.setOnInfoListener(this.vvM);
                if (!C5046bo.isNullOrNil(this.vvD)) {
                    this.ieC.setDataSource(this.vvD);
                } else if (this.f17241fd != null) {
                    this.ieC.setDataSource(this.f17241fd, this.bfp, this.bgY);
                }
                this.ieC.setSurface(this.mSurface);
                this.ieC.setAudioStreamType(3);
                this.ieC.setScreenOnWhilePlaying(true);
                this.ieC.prepareAsync();
                this.mVideoHeight = this.ieC.getVideoHeight();
                this.mVideoWidth = this.ieC.getVideoWidth();
                setMute(this.eif);
                mo69821as(this.speed);
                C4990ab.m7417i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", Integer.valueOf(hashCode()), Integer.valueOf(this.ieC.hashCode()));
                AppMethodBeat.m2505o(118025);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "prepare async error path", new Object[0]);
                if (this.llE != null) {
                    this.llE.onError(-1, -1);
                }
                AppMethodBeat.m2505o(118025);
                return;
            }
        }
        AppMethodBeat.m2505o(118025);
    }

    public final void bPd() {
        AppMethodBeat.m2504i(118026);
        if (this.ieC != null && this.vvE && this.mSurface != null && this.mSurface.isValid()) {
            C4990ab.m7417i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()));
            this.vvN = true;
            this.ieC.setVolume(0.0f, 0.0f);
            this.ieC.start();
        }
        AppMethodBeat.m2505o(118026);
    }

    public final void pause() {
        AppMethodBeat.m2504i(118027);
        if (this.ieC != null && this.vvE && this.ieC.isPlaying()) {
            C4990ab.m7410d("MicroMsg.VideoTextureView", "pause video.");
            this.ieC.pause();
        }
        this.ief = false;
        AppMethodBeat.m2505o(118027);
    }

    public int getDuration() {
        AppMethodBeat.m2504i(118028);
        int i;
        if (this.ieC == null || !this.vvE) {
            this.mDuration = -1;
            i = this.mDuration;
            AppMethodBeat.m2505o(118028);
            return i;
        } else if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.m2505o(118028);
            return i;
        } else {
            this.mDuration = this.ieC.getDuration();
            i = this.mDuration;
            AppMethodBeat.m2505o(118028);
            return i;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(118029);
        if (this.ieC != null && this.vvE) {
            int currentPosition = this.ieC.getCurrentPosition();
            AppMethodBeat.m2505o(118029);
            return currentPosition;
        } else if (this.ieC == null) {
            AppMethodBeat.m2505o(118029);
            return -1;
        } else {
            AppMethodBeat.m2505o(118029);
            return 0;
        }
    }

    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.m2504i(118030);
        if (this.ieC == null || !this.vvE || this.llM) {
            z = false;
        } else {
            z = this.ieC.isPlaying();
        }
        C4990ab.m7411d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.llM), Boolean.valueOf(this.vvE));
        AppMethodBeat.m2505o(118030);
        return z;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(118031);
        if (this.ieC != null) {
            this.ieC.setLooping(z);
        }
        this.fVc = true;
        AppMethodBeat.m2505o(118031);
    }

    public void setVideoCallback(C14981a c14981a) {
        this.llE = c14981a;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        AppMethodBeat.m2504i(118032);
        if (this.mSurface == null) {
            C4990ab.m7421w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.llL = true;
            this.ief = true;
            AppMethodBeat.m2505o(118032);
            return false;
        }
        this.startTime = this.startTime == 0 ? C5046bo.anT() : this.startTime;
        C4990ab.m7417i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", Long.valueOf(this.startTime), Boolean.valueOf(this.vvE), Boolean.valueOf(this.llM));
        if (this.ieC != null && this.vvE) {
            if (this.llM) {
                this.llM = false;
                setMute(this.eif);
            }
            this.ieC.start();
            this.ief = true;
            AppMethodBeat.m2505o(118032);
            return true;
        } else if (this.ieC == null && this.vvE) {
            this.ief = true;
            bnS();
            requestLayout();
            AppMethodBeat.m2505o(118032);
            return true;
        } else {
            this.ief = true;
            AppMethodBeat.m2505o(118032);
            return false;
        }
    }

    /* renamed from: w */
    public final boolean mo27377w(Context context, boolean z) {
        AppMethodBeat.m2504i(118033);
        boolean start = start();
        AppMethodBeat.m2505o(118033);
        return start;
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(118034);
        if (this.ieC != null) {
            this.ieC.seekTo((int) d);
            this.ief = true;
            C4990ab.m7410d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.ieC.getCurrentPosition());
        }
        AppMethodBeat.m2505o(118034);
    }

    /* renamed from: d */
    public final void mo27356d(double d, boolean z) {
        AppMethodBeat.m2504i(118035);
        mo9052B(d);
        this.ief = z;
        AppMethodBeat.m2505o(118035);
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
        AppMethodBeat.m2504i(118036);
        C4990ab.m7417i("MicroMsg.VideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.eif = z;
        if (this.ieC != null) {
            if (this.eif) {
                this.ieC.setVolume(0.0f, 0.0f);
                AppMethodBeat.m2505o(118036);
                return;
            }
            this.ieC.setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.m2505o(118036);
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(118037);
        this.vvu.setScaleType(c35873d);
        requestLayout();
        AppMethodBeat.m2505o(118037);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(118038);
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.m2505o(118038);
            return;
        }
        this.vvu.mo64033I(VideoTextureView.getDefaultSize(1, i), VideoTextureView.getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.vvu.iew, this.vvu.iex);
        AppMethodBeat.m2505o(118038);
    }

    /* renamed from: as */
    public final boolean mo69821as(float f) {
        AppMethodBeat.m2504i(118039);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(118039);
            return false;
        }
        this.speed = f;
        if (C1443d.m3068iW(23)) {
            boolean bj = m79332bj(this.speed);
            AppMethodBeat.m2505o(118039);
            return bj;
        }
        AppMethodBeat.m2505o(118039);
        return false;
    }

    /* renamed from: bj */
    private boolean m79332bj(float f) {
        AppMethodBeat.m2504i(118040);
        if (VERSION.SDK_INT >= 23) {
            try {
                if (this.ieC != null && C1443d.m3068iW(23)) {
                    PlaybackParams playbackParams = this.ieC.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.ieC.setPlaybackParams(playbackParams.setSpeed(f));
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "%s handle play rate error", Integer.valueOf(hashCode()));
                AppMethodBeat.m2505o(118040);
                return false;
            }
        }
        AppMethodBeat.m2505o(118040);
        return true;
    }

    /* renamed from: e */
    static /* synthetic */ void m79338e(VideoTextureView videoTextureView) {
        AppMethodBeat.m2504i(118041);
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(118041);
    }
}
