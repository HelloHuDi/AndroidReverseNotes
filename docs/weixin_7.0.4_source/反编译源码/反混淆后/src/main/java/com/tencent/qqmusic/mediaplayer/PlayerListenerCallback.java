package com.tencent.qqmusic.mediaplayer;

public interface PlayerListenerCallback {
    void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i);

    void onCompletion(BaseMediaPlayer baseMediaPlayer);

    void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3);

    void onPrepared(BaseMediaPlayer baseMediaPlayer);

    void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i);

    void onStarted(BaseMediaPlayer baseMediaPlayer);

    void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i);
}
