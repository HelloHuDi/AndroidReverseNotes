package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback;
import java.util.concurrent.TimeUnit;

public class DummyUriLoader implements UriLoader {
    private final Uri uri;

    public DummyUriLoader() {
        this(null);
    }

    public DummyUriLoader(Uri uri) {
        this.uri = uri;
    }

    public void startLoading(int i, TimeUnit timeUnit, Callback callback) {
        AppMethodBeat.i(104580);
        if (this.uri == null) {
            callback.onSucceed(null);
            AppMethodBeat.o(104580);
            return;
        }
        callback.onSucceed(new StreamingRequest(this.uri, null));
        AppMethodBeat.o(104580);
    }

    public boolean isLoading() {
        return false;
    }

    public void cancelLoading() {
    }
}
