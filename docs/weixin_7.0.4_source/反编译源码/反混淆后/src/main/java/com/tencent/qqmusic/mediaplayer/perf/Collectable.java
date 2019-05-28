package com.tencent.qqmusic.mediaplayer.perf;

public interface Collectable {
    void accept(ErrorUploadCollector errorUploadCollector);

    void accept(PlayerInfoCollector playerInfoCollector);
}
