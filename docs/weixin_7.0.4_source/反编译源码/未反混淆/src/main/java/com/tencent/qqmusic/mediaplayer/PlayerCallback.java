package com.tencent.qqmusic.mediaplayer;

interface PlayerCallback {
    void playThreadStart(CorePlayer corePlayer);

    void playerEnded(CorePlayer corePlayer);

    void playerException(CorePlayer corePlayer, int i, int i2, int i3);

    void playerPaused(CorePlayer corePlayer);

    void playerPrepared(CorePlayer corePlayer);

    void playerSeekCompletion(CorePlayer corePlayer, int i);

    void playerStarted(CorePlayer corePlayer);

    void playerStopped(CorePlayer corePlayer);
}
