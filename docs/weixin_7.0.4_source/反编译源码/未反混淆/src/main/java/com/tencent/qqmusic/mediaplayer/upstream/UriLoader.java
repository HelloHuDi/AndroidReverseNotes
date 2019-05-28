package com.tencent.qqmusic.mediaplayer.upstream;

import java.util.concurrent.TimeUnit;

public interface UriLoader {

    public interface Callback {
        void onCancelled();

        void onFailed(Throwable th);

        void onSucceed(StreamingRequest streamingRequest);
    }

    void cancelLoading();

    boolean isLoading();

    void startLoading(int i, TimeUnit timeUnit, Callback callback);
}
