package com.tencent.mm.plugin.appbrand.jsapi.u.b.b;

import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

public abstract class b implements c {
    protected OnInfoListener ieL;
    protected OnErrorListener ieM;
    protected OnPreparedListener ieN;
    protected OnCompletionListener ieO;
    protected OnSeekCompleteListener ieP;
    protected OnBufferingUpdateListener ieQ;
    protected OnVideoSizeChangedListener ieR;
    int mCurrentState = 0;

    public final int getState() {
        return this.mCurrentState;
    }

    public final void setOnInfoListener(OnInfoListener onInfoListener) {
        this.ieL = onInfoListener;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener) {
        this.ieM = onErrorListener;
    }

    public final void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.ieN = onPreparedListener;
    }

    public final void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.ieO = onCompletionListener;
    }

    public final void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.ieP = onSeekCompleteListener;
    }

    public final void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.ieQ = onBufferingUpdateListener;
    }

    public final void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.ieR = onVideoSizeChangedListener;
    }
}
