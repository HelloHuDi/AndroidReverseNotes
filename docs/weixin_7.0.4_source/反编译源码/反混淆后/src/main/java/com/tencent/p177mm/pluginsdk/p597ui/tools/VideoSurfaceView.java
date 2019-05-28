package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView */
public class VideoSurfaceView extends SurfaceView implements C14979e {
    private boolean eif;
    private MediaPlayer ieC;
    OnPreparedListener ieD;
    OnVideoSizeChangedListener ieE;
    private OnCompletionListener ieF;
    private OnErrorListener ieI;
    private boolean ief;
    private C14981a llE;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private SurfaceHolder swG;
    private String vvD;
    private boolean vvE;
    Callback vvF;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView$3 */
    class C149733 implements OnCompletionListener {
        C149733() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(70442);
            if (VideoSurfaceView.this.llE != null) {
                VideoSurfaceView.this.llE.mo8554dG(VideoSurfaceView.this.ieC.getCurrentPosition(), VideoSurfaceView.this.ieC.getDuration());
                VideoSurfaceView.this.llE.mo8553EA();
            }
            AppMethodBeat.m2505o(70442);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView$1 */
    class C233461 implements OnVideoSizeChangedListener {
        C233461() {
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(70440);
            VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            C4990ab.m7418v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.this.mVideoWidth + " , " + VideoSurfaceView.this.mVideoHeight + " )");
            VideoSurfaceView.m47728c(VideoSurfaceView.this);
            AppMethodBeat.m2505o(70440);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView$2 */
    class C301462 implements OnPreparedListener {
        C301462() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(70441);
            VideoSurfaceView.this.vvE = true;
            if (VideoSurfaceView.this.llE != null) {
                VideoSurfaceView.this.llE.mo8557pL();
            }
            VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            VideoSurfaceView.m47728c(VideoSurfaceView.this);
            if (VideoSurfaceView.this.mVideoWidth == 0 || VideoSurfaceView.this.mVideoHeight == 0) {
                if (VideoSurfaceView.this.ief) {
                    VideoSurfaceView.this.ieC.start();
                    VideoSurfaceView.this.ief = false;
                }
            } else if (VideoSurfaceView.this.ief) {
                VideoSurfaceView.this.ieC.start();
                VideoSurfaceView.this.ief = false;
                AppMethodBeat.m2505o(70441);
                return;
            }
            AppMethodBeat.m2505o(70441);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView$5 */
    class C301475 implements Callback {
        C301475() {
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.m2504i(70444);
            C4990ab.m7417i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (VideoSurfaceView.this.ieC != null && VideoSurfaceView.this.vvE && VideoSurfaceView.this.mVideoWidth == i2 && VideoSurfaceView.this.mVideoHeight == i3) {
                VideoSurfaceView.this.ieC.start();
            }
            AppMethodBeat.m2505o(70444);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(70445);
            C4990ab.m7416i("MicroMsg.VideoSurfaceView", "on surface created");
            VideoSurfaceView.this.swG = surfaceHolder;
            VideoSurfaceView.m47735j(VideoSurfaceView.this);
            AppMethodBeat.m2505o(70445);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(70446);
            C4990ab.m7416i("MicroMsg.VideoSurfaceView", "on surface destroyed");
            VideoSurfaceView.this.swG = null;
            if (VideoSurfaceView.this.ieC != null) {
                VideoSurfaceView.this.llE.mo8554dG(VideoSurfaceView.this.ieC.getCurrentPosition(), VideoSurfaceView.this.ieC.getDuration());
                VideoSurfaceView.this.ieC.reset();
                VideoSurfaceView.this.ieC.release();
                VideoSurfaceView.this.ieC = null;
            }
            AppMethodBeat.m2505o(70446);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView$4 */
    class C301484 implements OnErrorListener {
        C301484() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(70443);
            C4990ab.m7410d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
            if (VideoSurfaceView.this.llE != null) {
                VideoSurfaceView.this.llE.onError(i, i2);
            }
            AppMethodBeat.m2505o(70443);
            return true;
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m47735j(VideoSurfaceView videoSurfaceView) {
        AppMethodBeat.m2504i(70462);
        videoSurfaceView.bnS();
        AppMethodBeat.m2505o(70462);
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(70447);
        this.swG = null;
        this.ieC = null;
        this.ieE = new C233461();
        this.ieD = new C301462();
        this.ieF = new C149733();
        this.ieI = new C301484();
        this.vvF = new C301475();
        this.eif = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vvF);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        AppMethodBeat.m2505o(70447);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(70448);
        this.vvD = str;
        this.ief = false;
        bnS();
        requestLayout();
        AppMethodBeat.m2505o(70448);
    }

    public String getVideoPath() {
        return this.vvD;
    }

    public final void stop() {
        AppMethodBeat.m2504i(70449);
        if (this.ieC != null) {
            this.ieC.stop();
            this.ieC.release();
            this.ieC = null;
        }
        AppMethodBeat.m2505o(70449);
    }

    private void bnS() {
        AppMethodBeat.m2504i(70450);
        if (this.vvD == null || this.swG == null) {
            AppMethodBeat.m2505o(70450);
            return;
        }
        if (this.ieC != null) {
            this.ieC.stop();
            this.ieC.release();
            this.ieC = null;
        }
        try {
            this.ieC = new C45289k();
            this.ieC.setOnPreparedListener(this.ieD);
            this.ieC.setOnVideoSizeChangedListener(this.ieE);
            this.vvE = false;
            C4990ab.m7418v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
            this.mDuration = -1;
            this.ieC.setOnCompletionListener(this.ieF);
            this.ieC.setOnErrorListener(this.ieI);
            this.ieC.setDataSource(this.vvD);
            this.ieC.setDisplay(this.swG);
            this.ieC.setAudioStreamType(3);
            this.ieC.setScreenOnWhilePlaying(true);
            this.ieC.prepareAsync();
            this.mVideoHeight = this.ieC.getVideoHeight();
            this.mVideoWidth = this.ieC.getVideoWidth();
            setMute(this.eif);
            AppMethodBeat.m2505o(70450);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoSurfaceView", e, "prepare async error %s", e.getMessage());
            if (this.llE != null) {
                this.llE.onError(-1, -1);
            }
            AppMethodBeat.m2505o(70450);
        }
    }

    public final void pause() {
        AppMethodBeat.m2504i(70451);
        if (this.ieC != null && this.vvE && this.ieC.isPlaying()) {
            this.ieC.pause();
        }
        this.ief = false;
        AppMethodBeat.m2505o(70451);
    }

    public int getDuration() {
        AppMethodBeat.m2504i(70452);
        int i;
        if (this.ieC == null || !this.vvE) {
            this.mDuration = -1;
            i = this.mDuration;
            AppMethodBeat.m2505o(70452);
            return i;
        } else if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.m2505o(70452);
            return i;
        } else {
            this.mDuration = this.ieC.getDuration();
            i = this.mDuration;
            AppMethodBeat.m2505o(70452);
            return i;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(70453);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.m2505o(70453);
            return 0;
        }
        int currentPosition = this.ieC.getCurrentPosition();
        AppMethodBeat.m2505o(70453);
        return currentPosition;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(70454);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.m2505o(70454);
            return false;
        }
        boolean isPlaying = this.ieC.isPlaying();
        AppMethodBeat.m2505o(70454);
        return isPlaying;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(70455);
        if (this.ieC != null) {
            this.ieC.setLooping(z);
        }
        AppMethodBeat.m2505o(70455);
    }

    public void setVideoCallback(C14981a c14981a) {
        this.llE = c14981a;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        AppMethodBeat.m2504i(70456);
        if (this.ieC == null || !this.vvE) {
            this.ief = true;
        } else {
            this.ieC.start();
            this.ief = false;
        }
        AppMethodBeat.m2505o(70456);
        return true;
    }

    /* renamed from: w */
    public final boolean mo27377w(Context context, boolean z) {
        AppMethodBeat.m2504i(70457);
        boolean start = start();
        AppMethodBeat.m2505o(70457);
        return start;
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(70458);
        if (this.ieC != null) {
            C4990ab.m7410d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(d)));
            this.ieC.seekTo((int) d);
            start();
        }
        AppMethodBeat.m2505o(70458);
    }

    public void setPlayProgressCallback(boolean z) {
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(70459);
        this.eif = z;
        if (this.ieC != null) {
            if (this.eif) {
                this.ieC.setVolume(0.0f, 0.0f);
                AppMethodBeat.m2505o(70459);
                return;
            }
            this.ieC.setVolume(0.5f, 0.5f);
        }
        AppMethodBeat.m2505o(70459);
    }

    /* renamed from: d */
    public final void mo27356d(double d, boolean z) {
        AppMethodBeat.m2504i(70460);
        mo9052B(d);
        AppMethodBeat.m2505o(70460);
    }

    public void setOneTimeVideoTextureUpdateCallback(C14980e c14980e) {
    }

    public void setOnSeekCompleteCallback(C14982c c14982c) {
    }

    public void setOnInfoCallback(C14983b c14983b) {
    }

    public void setOnSurfaceCallback(C14978d c14978d) {
    }

    /* renamed from: c */
    static /* synthetic */ void m47728c(VideoSurfaceView videoSurfaceView) {
        AppMethodBeat.m2504i(70461);
        if (videoSurfaceView.mVideoHeight == 0 || videoSurfaceView.mVideoWidth == 0) {
            AppMethodBeat.m2505o(70461);
            return;
        }
        int i;
        int i2 = videoSurfaceView.mVideoWidth;
        int i3 = videoSurfaceView.mVideoHeight;
        C4990ab.m7418v("MicroMsg.VideoSurfaceView", "video size before:" + i2 + "   " + i3);
        C4990ab.m7418v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
        int width = videoSurfaceView.getWidth();
        int height = videoSurfaceView.getHeight();
        if (width <= 0) {
            i = i2;
        } else {
            i = width;
        }
        if (height <= 0) {
            width = i3;
        } else {
            width = height;
        }
        float f = (((float) i) * 1.0f) / ((float) i2);
        float f2 = (((float) width) * 1.0f) / ((float) i3);
        LayoutParams layoutParams = (LayoutParams) videoSurfaceView.getLayoutParams();
        if (f > f2) {
            layoutParams.width = (int) (((float) i2) * f2);
            layoutParams.height = width;
        } else {
            layoutParams.width = i;
            layoutParams.height = (int) (((float) i3) * f);
        }
        layoutParams.addRule(13);
        videoSurfaceView.setLayoutParams(layoutParams);
        C4990ab.m7418v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.ieC.getVideoWidth() + "   " + videoSurfaceView.ieC.getVideoHeight());
        C4990ab.m7418v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        AppMethodBeat.m2505o(70461);
    }
}
