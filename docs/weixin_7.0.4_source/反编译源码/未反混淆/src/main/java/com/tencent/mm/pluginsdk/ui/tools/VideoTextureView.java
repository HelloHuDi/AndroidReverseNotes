package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.b;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView extends MMTextureView implements e {
    protected long bfp;
    protected long bgY;
    private boolean eif;
    private boolean fVc;
    protected FileDescriptor fd;
    private MediaPlayer ieC;
    OnPreparedListener ieD;
    OnVideoSizeChangedListener ieE;
    private OnCompletionListener ieF;
    private OnErrorListener ieI;
    private boolean ief;
    private int ieu;
    private int iev;
    private long llC;
    private a llE;
    private d llH;
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
    private b vvH;
    private long vvI;
    private int vvJ;
    private OnSeekCompleteListener vvK;
    private OnBufferingUpdateListener vvL;
    private OnInfoListener vvM;
    private boolean vvN;
    private boolean vvq;
    private e vvr;
    private c vvs;
    SurfaceTextureListener vvt;
    private r vvu;

    static /* synthetic */ void t(VideoTextureView videoTextureView) {
        AppMethodBeat.i(118043);
        videoTextureView.dlC();
        AppMethodBeat.o(118043);
    }

    static /* synthetic */ void v(VideoTextureView videoTextureView) {
        AppMethodBeat.i(118044);
        videoTextureView.bnS();
        AppMethodBeat.o(118044);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(118021);
        this.mSurface = null;
        this.ieC = null;
        this.startTime = 0;
        this.vvI = 0;
        this.ieu = 0;
        this.iev = 0;
        this.vvJ = 0;
        this.fVc = false;
        this.vvq = false;
        this.ieE = new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(118010);
                try {
                    if (mediaPlayer != VideoTextureView.this.ieC) {
                        ab.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", mediaPlayer, VideoTextureView.this.ieC);
                        AppMethodBeat.o(118010);
                        return;
                    }
                    VideoTextureView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                    VideoTextureView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                    ab.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.this.mVideoWidth + " , " + VideoTextureView.this.mVideoHeight + " )");
                    if (VideoTextureView.this.llE != null) {
                        VideoTextureView.this.llE.dH(VideoTextureView.this.mVideoWidth, VideoTextureView.this.mVideoHeight);
                    }
                    VideoTextureView.e(VideoTextureView.this);
                    AppMethodBeat.o(118010);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
        };
        this.ieD = new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(118011);
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
                    ab.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(VideoTextureView.this.mVideoWidth), Integer.valueOf(VideoTextureView.this.mVideoHeight), Boolean.valueOf(VideoTextureView.this.ief));
                    VideoTextureView.e(VideoTextureView.this);
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
                        VideoTextureView.this.llE.pL();
                    }
                    AppMethodBeat.o(118011);
                    return;
                }
                ab.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, VideoTextureView.this.ieC);
                VideoTextureView.a(VideoTextureView.this, mediaPlayer);
                AppMethodBeat.o(118011);
            }
        };
        this.vvK = new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(118012);
                int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
                ab.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(currentPosition), Boolean.valueOf(VideoTextureView.this.ief), Boolean.valueOf(VideoTextureView.this.llM));
                if (!VideoTextureView.this.ief) {
                    VideoTextureView.this.pause();
                } else if (VideoTextureView.this.llM) {
                    AppMethodBeat.o(118012);
                    return;
                } else {
                    VideoTextureView.this.start();
                }
                if (VideoTextureView.this.vvs != null) {
                    VideoTextureView.this.vvs.cU(VideoTextureView.this.ief);
                }
                VideoTextureView.this.llC = 0;
                AppMethodBeat.o(118012);
            }
        };
        this.vvL = new OnBufferingUpdateListener() {
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                AppMethodBeat.i(118013);
                ab.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", Integer.valueOf(i));
                VideoTextureView.this.vvJ = i;
                AppMethodBeat.o(118013);
            }
        };
        this.vvM = new OnInfoListener() {
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(118014);
                ab.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", Integer.valueOf(i), Integer.valueOf(i2));
                if (VideoTextureView.this.vvH != null) {
                    VideoTextureView.this.vvH.gO(i, i2);
                }
                AppMethodBeat.o(118014);
                return false;
            }
        };
        this.ieF = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(118015);
                ab.i("MicroMsg.VideoTextureView", "video on completion");
                VideoTextureView.this.vvI = bo.anT();
                if (VideoTextureView.this.llE != null) {
                    VideoTextureView.this.llE.EA();
                }
                AppMethodBeat.o(118015);
            }
        };
        this.ieI = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(118016);
                ab.w("MicroMsg.VideoTextureView", "Error: " + i + "," + i2);
                if (VideoTextureView.this.llE != null) {
                    VideoTextureView.this.llE.onError(i, i2);
                }
                AppMethodBeat.o(118016);
                return true;
            }
        };
        this.llC = 0;
        this.llL = false;
        this.llM = false;
        this.vvN = false;
        this.vvt = new SurfaceTextureListener() {
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(118017);
                ab.d("MicroMsg.VideoTextureView", "on surface texture updated");
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
                    ab.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()));
                    if (VideoTextureView.this.ieC != null) {
                        VideoTextureView.this.ieC.pause();
                        VideoTextureView.this.setMute(VideoTextureView.this.eif);
                    }
                    VideoTextureView.this.vvN = false;
                }
                AppMethodBeat.o(118017);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(118018);
                ab.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
                if (VideoTextureView.this.ieC != null && VideoTextureView.this.vvE && VideoTextureView.this.mVideoWidth == i && VideoTextureView.this.mVideoHeight == i2) {
                    VideoTextureView.this.ieC.start();
                }
                AppMethodBeat.o(118018);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(118019);
                ab.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.this.vvE));
                VideoTextureView.this.mSurface = null;
                if (VideoTextureView.this.ieC == null || !VideoTextureView.this.vvE) {
                    VideoTextureView.t(VideoTextureView.this);
                    VideoTextureView.this.llL = false;
                } else if (VideoTextureView.this.isPlaying()) {
                    VideoTextureView.this.llL = true;
                    VideoTextureView.this.ieC.pause();
                }
                AppMethodBeat.o(118019);
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                AppMethodBeat.i(118020);
                VideoTextureView.this.ieu = i;
                VideoTextureView.this.iev = i2;
                VideoTextureView.this.dAh();
                VideoTextureView.this.mSurface = new Surface(surfaceTexture);
                ab.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoTextureView.this.vvE), Integer.valueOf(VideoTextureView.this.mSurface.hashCode()));
                if (VideoTextureView.this.ieC == null || !VideoTextureView.this.vvE) {
                    VideoTextureView.v(VideoTextureView.this);
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
                AppMethodBeat.o(118020);
            }
        };
        this.eif = false;
        this.vvu = new r();
        this.speed = -1.0f;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.vvt);
        setFocusable(true);
        setFocusableInTouchMode(true);
        AppMethodBeat.o(118021);
    }

    public void setOneTimeVideoTextureUpdateCallback(e eVar) {
        this.vvr = eVar;
    }

    public void setOnSeekCompleteCallback(c cVar) {
        this.vvs = cVar;
    }

    public void setOnInfoCallback(b bVar) {
        this.vvH = bVar;
    }

    public void setOnSurfaceCallback(d dVar) {
        this.llH = dVar;
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(118022);
        this.vvD = str;
        this.ief = false;
        bnS();
        requestLayout();
        AppMethodBeat.o(118022);
    }

    public String getVideoPath() {
        return this.vvD;
    }

    public int getDownloadPercent() {
        return this.vvJ;
    }

    public final void stop() {
        long j;
        AppMethodBeat.i(118023);
        long j2 = this.vvI > 0 ? this.vvI - this.startTime : 2147483647L;
        long anT = bo.anT() - this.startTime;
        if (j2 > anT) {
            j = anT;
        } else {
            j = j2;
        }
        int i = ((int) j) * 1000;
        if (i > getDuration()) {
            i = getDuration();
        }
        ab.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(anT), Long.valueOf(j2));
        if (this.llE != null) {
            this.llE.dG(i, getDuration());
        }
        dlC();
        this.vvu.reset();
        try {
            if (this.mSurface != null && this.vvE) {
                SurfaceTexture surfaceTexture = getSurfaceTexture();
                if (surfaceTexture != null) {
                    ab.i("MicroMsg.VideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
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
            ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "release surface", new Object[0]);
        }
        this.vvD = "";
        this.vvJ = 0;
        this.vvE = false;
        this.ief = false;
        this.llC = 0;
        AppMethodBeat.o(118023);
    }

    private void dlC() {
        boolean z = true;
        AppMethodBeat.i(118024);
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.vvE);
        if (this.ieC != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.ieC != null) {
            this.ieC.setOnErrorListener(null);
            this.ieC.setOnVideoSizeChangedListener(null);
            try {
                this.ieC.stop();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "stop media player error", new Object[0]);
            }
            try {
                this.ieC.reset();
                this.ieC.release();
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.VideoTextureView", e2, "reset media player error", new Object[0]);
            }
        }
        this.ieC = null;
        AppMethodBeat.o(118024);
    }

    private void bnS() {
        AppMethodBeat.i(118025);
        if ((!bo.isNullOrNil(this.vvD) || (this.fd != null && this.fd.valid())) && this.mSurface != null) {
            dlC();
            ab.i("MicroMsg.VideoTextureView", "%d open video %s", Integer.valueOf(hashCode()), this.vvD);
            try {
                this.ieC = new k();
                this.ieC.setOnPreparedListener(this.ieD);
                this.ieC.setOnVideoSizeChangedListener(this.ieE);
                this.vvE = false;
                ab.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.vvJ = 0;
                this.ieC.setOnCompletionListener(this.ieF);
                this.ieC.setOnErrorListener(this.ieI);
                this.ieC.setOnSeekCompleteListener(this.vvK);
                this.ieC.setOnBufferingUpdateListener(this.vvL);
                this.ieC.setOnInfoListener(this.vvM);
                if (!bo.isNullOrNil(this.vvD)) {
                    this.ieC.setDataSource(this.vvD);
                } else if (this.fd != null) {
                    this.ieC.setDataSource(this.fd, this.bfp, this.bgY);
                }
                this.ieC.setSurface(this.mSurface);
                this.ieC.setAudioStreamType(3);
                this.ieC.setScreenOnWhilePlaying(true);
                this.ieC.prepareAsync();
                this.mVideoHeight = this.ieC.getVideoHeight();
                this.mVideoWidth = this.ieC.getVideoWidth();
                setMute(this.eif);
                as(this.speed);
                ab.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", Integer.valueOf(hashCode()), Integer.valueOf(this.ieC.hashCode()));
                AppMethodBeat.o(118025);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "prepare async error path", new Object[0]);
                if (this.llE != null) {
                    this.llE.onError(-1, -1);
                }
                AppMethodBeat.o(118025);
                return;
            }
        }
        AppMethodBeat.o(118025);
    }

    public final void bPd() {
        AppMethodBeat.i(118026);
        if (this.ieC != null && this.vvE && this.mSurface != null && this.mSurface.isValid()) {
            ab.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()));
            this.vvN = true;
            this.ieC.setVolume(0.0f, 0.0f);
            this.ieC.start();
        }
        AppMethodBeat.o(118026);
    }

    public final void pause() {
        AppMethodBeat.i(118027);
        if (this.ieC != null && this.vvE && this.ieC.isPlaying()) {
            ab.d("MicroMsg.VideoTextureView", "pause video.");
            this.ieC.pause();
        }
        this.ief = false;
        AppMethodBeat.o(118027);
    }

    public int getDuration() {
        AppMethodBeat.i(118028);
        int i;
        if (this.ieC == null || !this.vvE) {
            this.mDuration = -1;
            i = this.mDuration;
            AppMethodBeat.o(118028);
            return i;
        } else if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.o(118028);
            return i;
        } else {
            this.mDuration = this.ieC.getDuration();
            i = this.mDuration;
            AppMethodBeat.o(118028);
            return i;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(118029);
        if (this.ieC != null && this.vvE) {
            int currentPosition = this.ieC.getCurrentPosition();
            AppMethodBeat.o(118029);
            return currentPosition;
        } else if (this.ieC == null) {
            AppMethodBeat.o(118029);
            return -1;
        } else {
            AppMethodBeat.o(118029);
            return 0;
        }
    }

    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.i(118030);
        if (this.ieC == null || !this.vvE || this.llM) {
            z = false;
        } else {
            z = this.ieC.isPlaying();
        }
        ab.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.llM), Boolean.valueOf(this.vvE));
        AppMethodBeat.o(118030);
        return z;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(118031);
        if (this.ieC != null) {
            this.ieC.setLooping(z);
        }
        this.fVc = true;
        AppMethodBeat.o(118031);
    }

    public void setVideoCallback(a aVar) {
        this.llE = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        AppMethodBeat.i(118032);
        if (this.mSurface == null) {
            ab.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.llL = true;
            this.ief = true;
            AppMethodBeat.o(118032);
            return false;
        }
        this.startTime = this.startTime == 0 ? bo.anT() : this.startTime;
        ab.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", Long.valueOf(this.startTime), Boolean.valueOf(this.vvE), Boolean.valueOf(this.llM));
        if (this.ieC != null && this.vvE) {
            if (this.llM) {
                this.llM = false;
                setMute(this.eif);
            }
            this.ieC.start();
            this.ief = true;
            AppMethodBeat.o(118032);
            return true;
        } else if (this.ieC == null && this.vvE) {
            this.ief = true;
            bnS();
            requestLayout();
            AppMethodBeat.o(118032);
            return true;
        } else {
            this.ief = true;
            AppMethodBeat.o(118032);
            return false;
        }
    }

    public final boolean w(Context context, boolean z) {
        AppMethodBeat.i(118033);
        boolean start = start();
        AppMethodBeat.o(118033);
        return start;
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    public final void B(double d) {
        AppMethodBeat.i(118034);
        if (this.ieC != null) {
            this.ieC.seekTo((int) d);
            this.ief = true;
            ab.d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.ieC.getCurrentPosition());
        }
        AppMethodBeat.o(118034);
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(118035);
        B(d);
        this.ief = z;
        AppMethodBeat.o(118035);
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
        AppMethodBeat.i(118036);
        ab.i("MicroMsg.VideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.eif = z;
        if (this.ieC != null) {
            if (this.eif) {
                this.ieC.setVolume(0.0f, 0.0f);
                AppMethodBeat.o(118036);
                return;
            }
            this.ieC.setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.o(118036);
    }

    public void setScaleType(h.d dVar) {
        AppMethodBeat.i(118037);
        this.vvu.setScaleType(dVar);
        requestLayout();
        AppMethodBeat.o(118037);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(118038);
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.o(118038);
            return;
        }
        this.vvu.I(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.vvu.iew, this.vvu.iex);
        AppMethodBeat.o(118038);
    }

    public final boolean as(float f) {
        AppMethodBeat.i(118039);
        if (f <= 0.0f) {
            AppMethodBeat.o(118039);
            return false;
        }
        this.speed = f;
        if (com.tencent.mm.compatible.util.d.iW(23)) {
            boolean bj = bj(this.speed);
            AppMethodBeat.o(118039);
            return bj;
        }
        AppMethodBeat.o(118039);
        return false;
    }

    private boolean bj(float f) {
        AppMethodBeat.i(118040);
        if (VERSION.SDK_INT >= 23) {
            try {
                if (this.ieC != null && com.tencent.mm.compatible.util.d.iW(23)) {
                    PlaybackParams playbackParams = this.ieC.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.ieC.setPlaybackParams(playbackParams.setSpeed(f));
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VideoTextureView", e, "%s handle play rate error", Integer.valueOf(hashCode()));
                AppMethodBeat.o(118040);
                return false;
            }
        }
        AppMethodBeat.o(118040);
        return true;
    }

    static /* synthetic */ void e(VideoTextureView videoTextureView) {
        AppMethodBeat.i(118041);
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
        AppMethodBeat.o(118041);
    }
}
