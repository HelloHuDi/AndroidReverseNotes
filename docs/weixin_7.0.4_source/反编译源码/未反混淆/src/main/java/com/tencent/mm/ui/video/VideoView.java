package com.tencent.mm.ui.video;

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
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

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
    private a zLn;

    public interface a {
    }

    static /* synthetic */ void q(VideoView videoView) {
        AppMethodBeat.i(35303);
        videoView.bnS();
        AppMethodBeat.o(35303);
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public final void dKx() {
        AppMethodBeat.i(35291);
        if (this.mVideoHeight == 0 || this.mVideoWidth == 0) {
            AppMethodBeat.o(35291);
            return;
        }
        int i;
        int i2 = this.mVideoWidth;
        int i3 = this.mVideoHeight;
        ab.v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
        ab.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
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
        ab.v("MicroMsg.VideoView", "video size after:" + this.ieC.getVideoWidth() + "   " + this.ieC.getVideoHeight());
        ab.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        AppMethodBeat.o(35291);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(35292);
        this.mContext = context;
        dKy();
        AppMethodBeat.o(35292);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(35293);
        this.swG = null;
        this.ieC = null;
        this.ieE = new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(35283);
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                ab.v("MicroMsg.VideoView", "on size change size:( " + VideoView.this.mVideoWidth + " , " + VideoView.this.mVideoHeight + " )");
                VideoView.this.dKx();
                if (VideoView.this.mVideoWidth != 0) {
                    VideoView.this.mVideoHeight;
                }
                AppMethodBeat.o(35283);
            }
        };
        this.ieD = new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(35284);
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
                AppMethodBeat.o(35284);
            }
        };
        this.ieF = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(35285);
                if (VideoView.this.fZE != null) {
                    VideoView.this.fZE.onCompletion(VideoView.this.ieC);
                }
                AppMethodBeat.o(35285);
            }
        };
        this.ieI = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(35286);
                ab.d("MicroMsg.VideoView", "Error: " + i + "," + i2);
                if (VideoView.this.fZF == null || !VideoView.this.fZF.onError(VideoView.this.ieC, i, i2)) {
                    VideoView.this.getWindowToken();
                    AppMethodBeat.o(35286);
                } else {
                    AppMethodBeat.o(35286);
                }
                return true;
            }
        };
        this.ieJ = new OnBufferingUpdateListener() {
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                AppMethodBeat.i(35287);
                VideoView.this.zLl = i;
                AppMethodBeat.o(35287);
            }
        };
        this.vvF = new Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                AppMethodBeat.i(35288);
                VideoView.this.mSurfaceWidth = i2;
                VideoView.this.mSurfaceHeight = i3;
                if (VideoView.this.ieC != null && VideoView.this.vvE && VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3) {
                    if (VideoView.this.zLm != 0) {
                        VideoView.this.ieC.seekTo(VideoView.this.zLm);
                        VideoView.this.zLm = 0;
                    }
                    VideoView.this.ieC.start();
                }
                AppMethodBeat.o(35288);
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(35289);
                VideoView.this.swG = surfaceHolder;
                VideoView.q(VideoView.this);
                AppMethodBeat.o(35289);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(35290);
                VideoView.this.swG = null;
                if (VideoView.this.ieC != null) {
                    VideoView.this.ieC.reset();
                    VideoView.this.ieC.release();
                    VideoView.this.ieC = null;
                }
                AppMethodBeat.o(35290);
            }
        };
        this.mContext = context;
        dKy();
        AppMethodBeat.o(35293);
    }

    private void dKy() {
        AppMethodBeat.i(35294);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vvF);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        AppMethodBeat.o(35294);
    }

    public void setVideoURI(String str) {
        AppMethodBeat.i(35295);
        this.vvD = str;
        this.ief = false;
        this.zLm = 0;
        bnS();
        requestLayout();
        invalidate();
        AppMethodBeat.o(35295);
    }

    public String getVideoURI() {
        return this.vvD;
    }

    public void setLooping(boolean z) {
        AppMethodBeat.i(35296);
        if (this.ieC != null) {
            this.ieC.setLooping(z);
        }
        AppMethodBeat.o(35296);
    }

    public final void stopPlayback() {
        AppMethodBeat.i(35297);
        if (this.ieC != null) {
            this.ieC.stop();
            this.ieC.release();
            this.ieC = null;
        }
        AppMethodBeat.o(35297);
    }

    public int getVideoTimeLeft() {
        AppMethodBeat.i(35298);
        if (this.ieC == null) {
            AppMethodBeat.o(35298);
            return 0;
        }
        int duration = this.ieC.getDuration() - this.ieC.getCurrentPosition();
        AppMethodBeat.o(35298);
        return duration;
    }

    private void bnS() {
        AppMethodBeat.i(35299);
        if (this.vvD == null || this.swG == null) {
            AppMethodBeat.o(35299);
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
            this.ieC = new k();
            this.ieC.setOnPreparedListener(this.ieD);
            this.ieC.setOnVideoSizeChangedListener(this.ieE);
            this.vvE = false;
            ab.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
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
            AppMethodBeat.o(35299);
        } catch (IOException e) {
            AppMethodBeat.o(35299);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(35299);
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
        AppMethodBeat.i(35300);
        int i;
        if (this.ieC == null || !this.vvE) {
            this.mDuration = -1;
            i = this.mDuration;
            AppMethodBeat.o(35300);
            return i;
        } else if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.o(35300);
            return i;
        } else {
            this.mDuration = this.ieC.getDuration();
            i = this.mDuration;
            AppMethodBeat.o(35300);
            return i;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(35301);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.o(35301);
            return 0;
        }
        int currentPosition = this.ieC.getCurrentPosition();
        AppMethodBeat.o(35301);
        return currentPosition;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(35302);
        if (this.ieC == null || !this.vvE) {
            AppMethodBeat.o(35302);
            return false;
        }
        boolean isPlaying = this.ieC.isPlaying();
        AppMethodBeat.o(35302);
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

    public void setVideoViewIm(a aVar) {
        this.zLn = aVar;
    }
}
