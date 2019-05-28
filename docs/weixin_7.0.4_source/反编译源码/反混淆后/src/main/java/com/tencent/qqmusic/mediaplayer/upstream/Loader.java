package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public interface Loader {

    public interface Listener {
        void onLoadCancelled(boolean z);

        void onLoadCompleted();

        void onLoadError(IOException iOException);

        void onLoadProgress(long j, long j2);
    }

    public interface Factory {
        Loader createLoader(Listener listener);
    }

    void cancelLoading();

    long getUpstreamSize();

    boolean isLoading();

    void prepare();

    void shutdown();

    void startLoading(Chunk chunk);
}
