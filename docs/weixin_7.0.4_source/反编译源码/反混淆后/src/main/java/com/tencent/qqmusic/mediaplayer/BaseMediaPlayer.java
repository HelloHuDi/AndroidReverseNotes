package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import java.io.FileDescriptor;

public abstract class BaseMediaPlayer {
    private static final String TAG = "BaseMediaPlayer";
    private long duration = 0;
    private boolean isPaused = false;
    private long startTime = 0;

    public abstract void TransferStateTo(int i);

    public abstract void addAudioListener(IAudioListener iAudioListener);

    public abstract SeekTable createSeekTable();

    public abstract void flush();

    public abstract AudioInformation getCurrentAudioInformation();

    public abstract long getCurrentPosition();

    public abstract long getCurrentPositionFromFile();

    public abstract int getDuration();

    public abstract int getPlayerState();

    public abstract int getSessionId();

    public abstract boolean isPlaying();

    public abstract boolean isSoftDecoder();

    public abstract void pause();

    public abstract void prepare();

    public abstract void prepareAsync();

    public abstract void release();

    public abstract void removeAudioListener(IAudioListener iAudioListener);

    public abstract void reset();

    public abstract void seekTo(int i);

    public abstract void setAudioStreamType(int i);

    public abstract void setDataSource(Context context, Uri uri);

    public abstract void setDataSource(Context context, UriLoader uriLoader);

    public abstract void setDataSource(TrackInfo trackInfo);

    public abstract void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri);

    public abstract void setDataSource(IDataSourceFactory iDataSourceFactory);

    public abstract void setDataSource(FileDescriptor fileDescriptor);

    public abstract void setDataSource(String str);

    public abstract void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback);

    public abstract void setVolume(float f, float f2);

    public abstract void setWakeMode(Context context, int i);

    public abstract void start();

    public abstract void stop();

    public long getCurPlayTime() {
        if (this.startTime <= 0) {
            return 0;
        }
        if (this.isPaused) {
            return this.duration;
        }
        return (this.duration + SystemClock.elapsedRealtime()) - this.startTime;
    }

    /* Access modifiers changed, original: protected */
    public void notifyStartPlaySong() {
        this.isPaused = false;
        this.startTime = SystemClock.elapsedRealtime();
    }

    /* Access modifiers changed, original: protected */
    public void notifyPauseSong() {
        this.isPaused = true;
        if (this.startTime > 0) {
            this.duration += SystemClock.elapsedRealtime() - this.startTime;
        }
    }
}
