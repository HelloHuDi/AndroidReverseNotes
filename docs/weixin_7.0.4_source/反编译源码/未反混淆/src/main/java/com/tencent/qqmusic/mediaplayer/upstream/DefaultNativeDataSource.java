package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public class DefaultNativeDataSource implements INativeDataSource {
    private final AudioType audioType;
    private final long nativeInstance;

    public DefaultNativeDataSource(long j, AudioType audioType) {
        this.nativeInstance = j;
        this.audioType = audioType;
    }

    public long getNativeInstance() {
        return this.nativeInstance;
    }

    public AudioType getAudioType() {
        return this.audioType;
    }

    public String toString() {
        return "DefaultNativeDataSource";
    }
}
