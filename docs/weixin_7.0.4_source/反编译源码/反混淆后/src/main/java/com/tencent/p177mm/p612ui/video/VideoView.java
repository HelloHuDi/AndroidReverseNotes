package com.tencent.p177mm.p612ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.ui.video.VideoView */
public class VideoView extends SurfaceView {
    private OnCompletionListener fZE;
    private OnErrorListener fZF;
    public MediaPlayer ieC;
    OnPreparedListener ieD;
    OnVideoSizeChangedListener ieE;
    private OnCompletionListener ieF;
    private OnErrorListener ieI;
    private OnBufferingUpdateListener ieJ;
    public boolean ief;
    private Context mContext;
    private int mDuration;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private SurfaceHolder swG;
    private String vvD;
    public boolean vvE;
    Callback vvF;
    private OnPreparedListener zLk;
    private int zLl;
    private int zLm;
    private C5617a zLn;

    /* renamed from: com.tencent.mm.ui.video.VideoView$a */
    public interface C5617a {
    }

    /* renamed from: com.tencent.mm.ui.video.VideoView$6 */
    class C159746 implements Callback {
        C159746() {
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.m2504i(35288);
            VideoView.this.mSurfaceWidth = i2;
            VideoView.this.mSurfaceHeight = i3;
            if (VideoView.this.ieC != null && VideoView.this.vvE && VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3) {
                if (VideoView.this.zLm != 0) {
                    VideoView.this.ieC.seekTo(VideoView.this.zLm);
                    VideoView.this.zLm = 0;
                }
                VideoView.this.ieC.start();
            }
            AppMethodBeat.m2505o(35288);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(35289);
            VideoView.this.swG = surfaceHolder;
            VideoView.m24281q(VideoView.this);
            AppMethodBeat.m2505o(35289);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(35290);
            VideoView.this.swG = null;
            if (VideoView.this.ieC != null) {
                VideoView.this.ieC.reset();
                VideoView.this.ieC.release();
                VideoView.this.ieC = null;
            }
            AppMethodBeat.m2505o(35290);
        }
    }

    /* renamed from: com.tencent.mm.ui.video.VideoView$1 */
    class C159751 implements OnVideoSizeChangedListener {
        C159751() {
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(35283);
            VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            C4990ab.m7418v("MicroMsg.VideoView", "on size change size:( " + VideoView.this.mVideoWidth + " , " + VideoView.this.mVideoHeight + " )");
            VideoView.this.dKx();
            if (VideoView.this.mVideoWidth != 0) {
                VideoView.this.mVideoHeight;
            }
            AppMethodBeat.m2505o(35283);
        }
    }

    /* renamed from: com.tencent.mm.ui.video.VideoView$5 */
    class C159765 implements OnBufferingUpdateListener {
        C159765() {
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            AppMethodBeat.m2504i(35287);
            VideoView.this.zLl = i;
            AppMethodBeat.m2505o(35287);
        }
    }

    /* renamed from: com.tencent.mm.ui.video.VideoView$2 */
    class C159772 implements OnPreparedListener {
        C159772() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(35284);
            VideoView.this.vvE = true;
            if (VideoView.this.zLk != null) {
                VideoView.this.zLk.onPrepared(VideoView.this.ieC);
            }
            VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            VideoView.this.dKx();
            if (VideoView.this.mVideoWidth == 0 || VideoView.this.mVideoHeight == 0) {
                if (VideoView.this.zLm != 0) {
                    VideoView.this.ieC.seekTo(VideoView.this.zLm);
                    VideoView.this.zLm = 0;
                }
                if (VideoView.this.ief) {
                    VideoView.this.ieC.start();
                    VideoView.this.ief = false;
                }
            } else {
                if (VideoView.this.ief) {
                    VideoView.this.ieC.start();
                    VideoView.this.ief = false;
                }
                if (VideoView.this.mSurfaceWidth == VideoView.this.mVideoWidth && VideoView.this.mSurfaceHeight == VideoView.this.mVideoHeight) {
                    if (VideoView.this.zLm != 0) {
                        VideoView.this.ieC.seekTo(VideoView.this.zLm);
                        VideoView.this.zLm = 0;
                    }
                    if (VideoView.this.ief || VideoView.this.isPlaying() || VideoView.this.zLm != 0 || VideoView.this.getCurrentPosition() > 0) {
                    }
                }
            }
            if (VideoView.this.ieC.isPlaying() && VideoView.this.zLn != null) {
                VideoView.this.zLn;
                VideoView.this.vvD;
            }
            AppMethodBeat.m2505o(35284);
        }
    }

    /* renamed from: com.tencent.mm.ui.video.VideoView$4 */
    class C159784 implements OnErrorListener {
        C159784() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(35286);
            C4990ab.m7410d("MicroMsg.VideoView", "Error: " + i + "," + i2);
            if (VideoView.this.fZF == null || !VideoView.this.fZF.onError(VideoView.this.ieC, i, i2)) {
                VideoView.this.getWindowToken();
                AppMethodBeat.m2505o(35286);
            } else {
                AppMethodBeat.m2505o(35286);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.video.VideoView$3 */
    class C159793 implements OnCompletionListener {
        C159793() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(35285);
            if (VideoView.this.fZE != null) {
                VideoView.this.fZE.onCompletion(VideoView.this.ieC);
            }
            AppMethodBeat.m2505o(35285);
        }
    }

    /* renamed from: q */
    static /* synthetic */ void m24281q(VideoView videoView) {
        AppMethodBeat.m2504i(35303);
        videoView.bnS();
        AppMethodBeat.m2505o(35303);
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public final void dKx() {
        AppMethodBeat.m2504i(35291);
        if (this.mVideoHeight == 0 || this.mVideoWidth == 0) {
            AppMethodBeat.m2505o(35291);
            return;
        }
        int i;
        int i2 = this.mVideoWidth;
        int i3 = this.mVideoHeight;
        C4990ab.m7418v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
        C4990ab.m7418v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
        int width = getWidth();
        int height = getHeight();
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
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (f > f2) {
            layoutParams.width = (int) (((float) i2) * f2);
            layoutParams.height = width;
        } else {
            layoutParams.width = i;
            layoutParams.height = (int) (((float) i3) * f);
        }
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        invalidate();
        C4990ab.m7418v("MicroMsg.VideoView", "video size after:" + this.ieC.getVideoWidth() + "   " + this.ieC.getVideoHeight());
        C4990ab.m7418v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        AppMethodBeat.m2505o(35291);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(35292);
        this.mContext = context;
        dKy();
        AppMethodBeat.m2505o(35292);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(35293);
        this.swG = null;
        this.ieC = null;
        this.ieE = new C159751();
        this.ieD = new C159772();
        this.ieF = new C159793();
        this.ieI = new C159784();
        this.ieJ = new C159765();
        this.vvF = new C159746();
        this.mContext = context;
        dKy();
        AppMethodBeat.m2505o(35293);
    }

    private void dKy() {
        AppMethodBeat.m2504i(35294);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vvF);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        AppMethodBeat.m2505o(35294);
    }

    public void setVideoURI(String str) {
        AppMethodBeat.m2504i(35295);
        this.vvD = str;
        this.ief = false;
        this.zLm = 0;
        bnS();
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(35295);
    }

    public String getVideoURI() {
        return this.vvD;
    }

    public void setLooping(boolean z) {
        AppMethodBeat.m2504i(35296);
        if (this.ieC != null) {
            this.ieC.setLooping(z);
        }
        AppMethodBeat.m2505o(35296);
    }

    public final void stopPlayback() {
        AppMethodBeat.m2504i(35297);
        if (this.ieC != null) {
            this.ieC.stop();
            this.ieC.release();
            this.ieC = null;
        }
        AppMethodBeat.m2505o(35297);
    }

    public int getVideoTimeLeft() {
        AppMethodBeat.m2504i(35298);
        if (this.ieC == null) {
            AppMethodBeat.m2505o(35298);
            return 0;
        }
        int duration = this.ieC.getDuration() - this.ieC.getCurrentPosition();
        AppMethodBeat.m2505o(35298);
        return duration;
    }

    private void bnS() {
        AppMethodBeat.m2504i(35299);
        if (this.vvD == null || this.swG == null) {
            AppMethodBeat.m2505o(35299);
            return;
        }
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        this.mContext.sendBroadcast(intent);
        if (this.ieC != null) {
            this.ieC.reset();
            this.ieC.release();
            this.ieC = null;
        }
        try {
            this.ieC = new C45289k();
            this.ieC.setOnPreparedListener(this.ieD);
            this.ieC.setOnVideoSizeChangedListener(this.ieE);
            this.vvE = false;
            C4990ab.m7418v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
            this.mDuration = -1;
            this.ieC.setOnCompletionListener(this.ieF);
            this.ieC.setOnErrorListener(this.ieI);
            this.ieC.setOnBufferingUpdateListener(this.ieJ);
            this.zLl = 0;
            this.ieC.setDataSource(this.vvD);
            this.ieC.setDisplay(this.swG);
            this.ieC.setAudioStreamType(3);
            this.ieC.setScreenOnWhilePlaying(true);
            this.ieC.prepareAsync();
            this.mVideoHeight = this.ieC.getVideoHeight();
            this.mVideoWidth = this.ieC.getVideoWidth();
            AppMethodBeat.m2505o(35299);
        } catch (IOException e) {
            AppMethodBeat.m2505o(35299);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.m2505o(35299);
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.zLk = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.fZE = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.fZF = onErrorListener;
    }

    public int getDuration() {
        AppMethodBeat.m2504i(35300);
        int i;
        if (this.ieC == null || !this.vvE) {
            this.mDuration = -1;
            i = this.mDuration;
            AppMethodBeat.m2505o(35300);
            return i;
        } else if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.m2505o(35300);
            return i;
        } else {
            this.mDuration = this.ieC.getDuration();
            i = this.mDuration;
            AppMethodBeat.m2505o(35300);
            return i;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(35301);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.m2505o(35301);
            return 0;
        }
        int currentPosition = this.ieC.getCurrentPosition();
        AppMethodBeat.m2505o(35301);
        return currentPosition;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(35302);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.m2505o(35302);
            return false;
        }
        boolean isPlaying = this.ieC.isPlaying();
        AppMethodBeat.m2505o(35302);
        return isPlaying;
    }

    public int getBufferPercentage() {
        if (this.ieC != null) {
            return this.zLl;
        }
        return 0;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public void setVideoViewIm(C5617a c5617a) {
        this.zLn = c5617a;
    }
}
