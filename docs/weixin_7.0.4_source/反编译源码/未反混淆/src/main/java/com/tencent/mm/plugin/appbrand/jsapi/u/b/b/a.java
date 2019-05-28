package com.tencent.mm.plugin.appbrand.jsapi.u.b.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends b {
    int ieB;
    MediaPlayer ieC = new k();
    private OnPreparedListener ieD = new OnPreparedListener() {
        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(117426);
            a.this.mCurrentState = 2;
            if (a.this.ieN != null) {
                a.this.ieN.onPrepared(a.this.ieC);
            }
            int i = a.this.ieB;
            if (i != 0) {
                a.this.seekTo(i);
                a.this.ieB = 0;
            }
            if (a.this.ief) {
                a.this.start();
            }
            AppMethodBeat.o(117426);
        }
    };
    private OnVideoSizeChangedListener ieE = new OnVideoSizeChangedListener() {
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.i(117427);
            if (a.this.ieR != null) {
                a.this.ieR.onVideoSizeChanged(mediaPlayer, i, i2);
            }
            AppMethodBeat.o(117427);
        }
    };
    private OnCompletionListener ieF = new OnCompletionListener() {
        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(117428);
            a.this.mCurrentState = 6;
            if (a.this.ieO != null) {
                a.this.ieO.onCompletion(mediaPlayer);
            }
            AppMethodBeat.o(117428);
        }
    };
    private OnInfoListener ieG = new OnInfoListener() {
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.i(117429);
            if (a.this.ieL != null) {
                a.this.ieL.onInfo(mediaPlayer, i, i2);
            }
            AppMethodBeat.o(117429);
            return true;
        }
    };
    private OnSeekCompleteListener ieH = new OnSeekCompleteListener() {
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(117430);
            if (a.this.ieP != null) {
                a.this.ieP.onSeekComplete(mediaPlayer);
            }
            AppMethodBeat.o(117430);
        }
    };
    private OnErrorListener ieI = new OnErrorListener() {
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.i(117431);
            if (a.this.ieM != null) {
                a.this.ieM.onError(mediaPlayer, i, i2);
            }
            AppMethodBeat.o(117431);
            return true;
        }
    };
    private OnBufferingUpdateListener ieJ = new OnBufferingUpdateListener() {
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            AppMethodBeat.i(117432);
            if (a.this.ieQ != null) {
                a.this.ieQ.onBufferingUpdate(mediaPlayer, i);
            }
            AppMethodBeat.o(117432);
        }
    };
    boolean ief;

    public a() {
        AppMethodBeat.i(117433);
        AppMethodBeat.o(117433);
    }

    private boolean aGO() {
        return this.ieC != null;
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.i(117435);
        try {
            if (aGO()) {
                this.ieC.setSurface(surface);
            }
            AppMethodBeat.o(117435);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSurface fail", Integer.valueOf(hashCode()), e);
            oN(-12);
            AppMethodBeat.o(117435);
        }
    }

    private void setVolume(float f, float f2) {
        AppMethodBeat.i(117436);
        try {
            if (aGO()) {
                this.ieC.setVolume(f, f2);
            }
            AppMethodBeat.o(117436);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setVolume fail", Integer.valueOf(hashCode()), e);
            oN(-13);
            AppMethodBeat.o(117436);
        }
    }

    public final boolean at(float f) {
        AppMethodBeat.i(117437);
        if (f <= 0.0f) {
            AppMethodBeat.o(117437);
            return false;
        }
        try {
            if (!aGO() || VERSION.SDK_INT < 23) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", Integer.valueOf(hashCode()), Integer.valueOf(VERSION.SDK_INT));
                AppMethodBeat.o(117437);
                return false;
            }
            PlaybackParams playbackParams = this.ieC.getPlaybackParams();
            playbackParams.setSpeed(f);
            if (this.ieC.isPlaying()) {
                this.ieC.setPlaybackParams(playbackParams);
            } else {
                this.ieC.setPlaybackParams(playbackParams);
                this.ieC.pause();
            }
            AppMethodBeat.o(117437);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSpeed fail", Integer.valueOf(hashCode()), e);
            oN(-14);
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(117438);
        if (aGO()) {
            if (z) {
                setVolume(0.0f, 0.0f);
                AppMethodBeat.o(117438);
                return;
            }
            setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.o(117438);
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.i(117439);
        try {
            if (aGO()) {
                this.ieC.setLooping(z);
            }
            AppMethodBeat.o(117439);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setLooping fail", Integer.valueOf(hashCode()), e);
            oN(-10);
            AppMethodBeat.o(117439);
        }
    }

    public final void oM(int i) {
        if (i > 0) {
            this.ieB = i;
        }
    }

    public final void eu(boolean z) {
        this.ief = z;
    }

    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.i(117440);
        try {
            if (aGO() && this.mCurrentState != -1) {
                z = this.ieC.isPlaying();
                AppMethodBeat.o(117440);
                return z;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s isPlaying fail", Integer.valueOf(hashCode()), e);
            oN(-9);
        }
        AppMethodBeat.o(117440);
        return z;
    }

    public final int getCurrentPosition() {
        int i = 0;
        AppMethodBeat.i(117441);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                i = this.ieC.getCurrentPosition();
                AppMethodBeat.o(117441);
                return i;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getCurrentPosition fail", Integer.valueOf(hashCode()), e);
            oN(-15);
        }
        AppMethodBeat.o(117441);
        return i;
    }

    public final int getDuration() {
        int i = 0;
        AppMethodBeat.i(117442);
        try {
            if (!(!aGO() || this.mCurrentState == -1 || this.mCurrentState == 1 || this.mCurrentState == 0)) {
                i = this.ieC.getDuration();
                AppMethodBeat.o(117442);
                return i;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getDuration fail", Integer.valueOf(hashCode()), e);
            oN(-16);
        }
        AppMethodBeat.o(117442);
        return i;
    }

    public final int getVideoWidth() {
        int i = 0;
        AppMethodBeat.i(117443);
        try {
            if (aGO()) {
                i = this.ieC.getVideoWidth();
                AppMethodBeat.o(117443);
                return i;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getVideoWidth fail", Integer.valueOf(hashCode()), e);
            oN(-17);
        }
        AppMethodBeat.o(117443);
        return i;
    }

    public final int getVideoHeight() {
        int i = 0;
        AppMethodBeat.i(117444);
        try {
            if (aGO()) {
                i = this.ieC.getVideoHeight();
                AppMethodBeat.o(117444);
                return i;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getVideoHeight fail", Integer.valueOf(hashCode()), e);
            oN(-18);
        }
        AppMethodBeat.o(117444);
        return i;
    }

    public final void prepareAsync() {
        AppMethodBeat.i(117445);
        try {
            if (aGO()) {
                this.ieC.prepareAsync();
            }
            AppMethodBeat.o(117445);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s prepareAsync fail", Integer.valueOf(hashCode()), e);
            oN(-6);
            AppMethodBeat.o(117445);
        }
    }

    public final void start() {
        AppMethodBeat.i(117446);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                this.ieC.start();
                this.mCurrentState = 3;
            }
            AppMethodBeat.o(117446);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s start fail", Integer.valueOf(hashCode()), e);
            oN(-1);
            AppMethodBeat.o(117446);
        }
    }

    public final void pause() {
        AppMethodBeat.i(117447);
        try {
            if (aGO()) {
                this.ieC.pause();
                this.mCurrentState = 4;
            }
            AppMethodBeat.o(117447);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s pause fail", Integer.valueOf(hashCode()), e);
            oN(-2);
            AppMethodBeat.o(117447);
        }
    }

    public final void seekTo(int i) {
        AppMethodBeat.i(117448);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                this.ieC.seekTo(i);
            }
            AppMethodBeat.o(117448);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s seekTo fail", Integer.valueOf(hashCode()), e);
            oN(-3);
            AppMethodBeat.o(117448);
        }
    }

    public final void stop() {
        AppMethodBeat.i(117449);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                this.ieC.stop();
                this.mCurrentState = 5;
            }
            AppMethodBeat.o(117449);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s stop fail", Integer.valueOf(hashCode()), e);
            oN(-4);
            AppMethodBeat.o(117449);
        }
    }

    public final void reset() {
        AppMethodBeat.i(117450);
        try {
            if (aGO()) {
                this.ieC.reset();
                this.mCurrentState = 0;
            }
            AppMethodBeat.o(117450);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s reset fail", Integer.valueOf(hashCode()), e);
            oN(-7);
            AppMethodBeat.o(117450);
        }
    }

    public final void release() {
        AppMethodBeat.i(117451);
        try {
            if (aGO()) {
                aGP();
                this.ieC.release();
                this.mCurrentState = -2;
            }
            AppMethodBeat.o(117451);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s release fail", Integer.valueOf(hashCode()), e);
            oN(-8);
            AppMethodBeat.o(117451);
        }
    }

    private void aGP() {
        AppMethodBeat.i(117452);
        if (this.ieC == null) {
            AppMethodBeat.o(117452);
            return;
        }
        this.ieC.setOnInfoListener(null);
        this.ieC.setOnErrorListener(null);
        this.ieC.setOnPreparedListener(null);
        this.ieC.setOnCompletionListener(null);
        this.ieC.setOnSeekCompleteListener(null);
        this.ieC.setOnBufferingUpdateListener(null);
        this.ieC.setOnVideoSizeChangedListener(null);
        AppMethodBeat.o(117452);
    }

    private void oN(int i) {
        AppMethodBeat.i(117453);
        if (this.ieI != null) {
            this.ieI.onError(this.ieC, -1024, i);
        }
        AppMethodBeat.o(117453);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.i(117434);
        try {
            if (this.ieC == null) {
                this.ieC = new k();
            } else {
                stop();
                reset();
                aGP();
            }
            this.ieC.setScreenOnWhilePlaying(true);
            this.ieC.setAudioStreamType(3);
            this.ieC.setOnInfoListener(this.ieG);
            this.ieC.setOnErrorListener(this.ieI);
            this.ieC.setOnPreparedListener(this.ieD);
            this.ieC.setOnCompletionListener(this.ieF);
            this.ieC.setOnSeekCompleteListener(this.ieH);
            this.ieC.setOnVideoSizeChangedListener(this.ieE);
            this.ieC.setOnBufferingUpdateListener(this.ieJ);
            if (aGO()) {
                this.ieC.setDataSource(str);
                this.mCurrentState = 1;
            }
            AppMethodBeat.o(117434);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setDataSource fail", Integer.valueOf(hashCode()), e);
            oN(-11);
            AppMethodBeat.o(117434);
        }
    }
}
