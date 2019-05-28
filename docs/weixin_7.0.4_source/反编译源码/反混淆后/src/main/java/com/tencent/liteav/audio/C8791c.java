package com.tencent.liteav.audio;

import com.tencent.liteav.basic.p811g.C25648a;

/* renamed from: com.tencent.liteav.audio.c */
public interface C8791c {
    void onPlayAudioInfoChanged(C25648a c25648a, C25648a c25648a2);

    void onPlayError(int i, String str);

    void onPlayJitterStateNotify(int i);

    void onPlayPcmData(byte[] bArr, long j);
}
