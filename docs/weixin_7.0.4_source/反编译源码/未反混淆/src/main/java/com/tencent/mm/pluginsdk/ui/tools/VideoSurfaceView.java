package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.b;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;

public class VideoSurfaceView extends SurfaceView implements e {
    private boolean eif;
    private MediaPlayer ieC;
    OnPreparedListener ieD;
    OnVideoSizeChangedListener ieE;
    private OnCompletionListener ieF;
    private OnErrorListener ieI;
    private boolean ief;
    private a llE;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private SurfaceHolder swG;
    private String vvD;
    private boolean vvE;
    Callback vvF;

    static /* synthetic */ void j(VideoSurfaceView videoSurfaceView) {
        AppMethodBeat.i(70462);
        videoSurfaceView.bnS();
        AppMethodBeat.o(70462);
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(70447);
        this.swG = null;
        this.ieC = null;
        this.ieE = new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(70440);
                VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                ab.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.this.mVideoWidth + " , " + VideoSurfaceView.this.mVideoHeight + " )");
                VideoSurfaceView.c(VideoSurfaceView.this);
                AppMethodBeat.o(70440);
            }
        };
        this.ieD = new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(70441);
                VideoSurfaceView.this.vvE = true;
                if (VideoSurfaceView.this.llE != null) {
                    VideoSurfaceView.this.llE.pL();
                }
                VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                VideoSurfaceView.c(VideoSurfaceView.this);
                if (VideoSurfaceView.this.mVideoWidth == 0 || VideoSurfaceView.this.mVideoHeight == 0) {
                    if (VideoSurfaceView.this.ief) {
                        VideoSurfaceView.this.ieC.start();
                        VideoSurfaceView.this.ief = false;
                    }
                } else if (VideoSurfaceView.this.ief) {
                    VideoSurfaceView.this.ieC.start();
                    VideoSurfaceView.this.ief = false;
                    AppMethodBeat.o(70441);
                    return;
                }
                AppMethodBeat.o(70441);
            }
        };
        this.ieF = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(70442);
                if (VideoSurfaceView.this.llE != null) {
                    VideoSurfaceView.this.llE.dG(VideoSurfaceView.this.ieC.getCurrentPosition(), VideoSurfaceView.this.ieC.getDuration());
                    VideoSurfaceView.this.llE.EA();
                }
                AppMethodBeat.o(70442);
            }
        };
        this.ieI = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(70443);
                ab.d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
                if (VideoSurfaceView.this.llE != null) {
                    VideoSurfaceView.this.llE.onError(i, i2);
                }
                AppMethodBeat.o(70443);
                return true;
            }
        };
        this.vvF = new Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                AppMethodBeat.i(70444);
                ab.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (VideoSurfaceView.this.ieC != null && VideoSurfaceView.this.vvE && VideoSurfaceView.this.mVideoWidth == i2 && VideoSurfaceView.this.mVideoHeight == i3) {
                    VideoSurfaceView.this.ieC.start();
                }
                AppMethodBeat.o(70444);
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(70445);
                ab.i("MicroMsg.VideoSurfaceView", "on surface created");
                VideoSurfaceView.this.swG = surfaceHolder;
                VideoSurfaceView.j(VideoSurfaceView.this);
                AppMethodBeat.o(70445);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(70446);
                ab.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
                VideoSurfaceView.this.swG = null;
                if (VideoSurfaceView.this.ieC != null) {
                    VideoSurfaceView.this.llE.dG(VideoSurfaceView.this.ieC.getCurrentPosition(), VideoSurfaceView.this.ieC.getDuration());
                    VideoSurfaceView.this.ieC.reset();
                    VideoSurfaceView.this.ieC.release();
                    VideoSurfaceView.this.ieC = null;
                }
                AppMethodBeat.o(70446);
            }
        };
        this.eif = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vvF);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        AppMethodBeat.o(70447);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(70448);
        this.vvD = str;
        this.ief = false;
        bnS();
        requestLayout();
        AppMethodBeat.o(70448);
    }

    public String getVideoPath() {
        return this.vvD;
    }

    public final void stop() {
        AppMethodBeat.i(70449);
        if (this.ieC != null) {
            this.ieC.stop();
            this.ieC.release();
            this.ieC = null;
        }
        AppMethodBeat.o(70449);
    }

    private void bnS() {
        AppMethodBeat.i(70450);
        if (this.vvD == null || this.swG == null) {
            AppMethodBeat.o(70450);
            return;
        }
        if (this.ieC != null) {
            this.ieC.stop();
            this.ieC.release();
            this.ieC = null;
        }
        try {
            this.ieC = new k();
            this.ieC.setOnPreparedListener(this.ieD);
            this.ieC.setOnVideoSizeChangedListener(this.ieE);
            this.vvE = false;
            ab.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
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
            AppMethodBeat.o(70450);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoSurfaceView", e, "prepare async error %s", e.getMessage());
            if (this.llE != null) {
                this.llE.onError(-1, -1);
            }
            AppMethodBeat.o(70450);
        }
    }

    public final void pause() {
        AppMethodBeat.i(70451);
        if (this.ieC != null && this.vvE && this.ieC.isPlaying()) {
            this.ieC.pause();
        }
        this.ief = false;
        AppMethodBeat.o(70451);
    }

    public int getDuration() {
        AppMethodBeat.i(70452);
        int i;
        if (this.ieC == null || !this.vvE) {
            this.mDuration = -1;
            i = this.mDuration;
            AppMethodBeat.o(70452);
            return i;
        } else if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.o(70452);
            return i;
        } else {
            this.mDuration = this.ieC.getDuration();
            i = this.mDuration;
            AppMethodBeat.o(70452);
            return i;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(70453);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.o(70453);
            return 0;
        }
        int currentPosition = this.ieC.getCurrentPosition();
        AppMethodBeat.o(70453);
        return currentPosition;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(70454);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.o(70454);
            return false;
        }
        boolean isPlaying = this.ieC.isPlaying();
        AppMethodBeat.o(70454);
        return isPlaying;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(70455);
        if (this.ieC != null) {
            this.ieC.setLooping(z);
        }
        AppMethodBeat.o(70455);
    }

    public void setVideoCallback(a aVar) {
        this.llE = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        AppMethodBeat.i(70456);
        if (this.ieC == null || !this.vvE) {
            this.ief = true;
        } else {
            this.ieC.start();
            this.ief = false;
        }
        AppMethodBeat.o(70456);
        return true;
    }

    public final boolean w(Context context, boolean z) {
        AppMethodBeat.i(70457);
        boolean start = start();
        AppMethodBeat.o(70457);
        return start;
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    public final void B(double d) {
        AppMethodBeat.i(70458);
        if (this.ieC != null) {
            ab.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(d)));
            this.ieC.seekTo((int) d);
            start();
        }
        AppMethodBeat.o(70458);
    }

    public void setPlayProgressCallback(boolean z) {
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(70459);
        this.eif = z;
        if (this.ieC != null) {
            if (this.eif) {
                this.ieC.setVolume(0.0f, 0.0f);
                AppMethodBeat.o(70459);
                return;
            }
            this.ieC.setVolume(0.5f, 0.5f);
        }
        AppMethodBeat.o(70459);
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(70460);
        B(d);
        AppMethodBeat.o(70460);
    }

    public void setOneTimeVideoTextureUpdateCallback(e eVar) {
    }

    public void setOnSeekCompleteCallback(c cVar) {
    }

    public void setOnInfoCallback(b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
    }

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        AppMethodBeat.i(70461);
        if (videoSurfaceView.mVideoHeight == 0 || videoSurfaceView.mVideoWidth == 0) {
            AppMethodBeat.o(70461);
            return;
        }
        int i;
        int i2 = videoSurfaceView.mVideoWidth;
        int i3 = videoSurfaceView.mVideoHeight;
        ab.v("MicroMsg.VideoSurfaceView", "video size before:" + i2 + "   " + i3);
        ab.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
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
        ab.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.ieC.getVideoWidth() + "   " + videoSurfaceView.ieC.getVideoHeight());
        ab.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        AppMethodBeat.o(70461);
    }
}
