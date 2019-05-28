package com.tencent.mm.plugin.appbrand.jsapi.u.b.b;

import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;

public interface c {
    boolean at(float f);

    void eu(boolean z);

    int getCurrentPosition();

    int getDuration();

    int getState();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void oM(int i);

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(int i);

    void setDataSource(String str);

    void setLooping(boolean z);

    void setMute(boolean z);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setSurface(Surface surface);

    void start();

    void stop();
}
