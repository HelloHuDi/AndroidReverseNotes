package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class DefaultMediaHTTPService implements IMediaHTTPService {
    private static final String TAG = "DefaultMediaHTTPService";

    public IMediaHTTPConnection makeHTTPConnection() {
        AppMethodBeat.i(104799);
        Logger.d(TAG, "makeHTTPConnection");
        DefaultMediaHTTPConnection defaultMediaHTTPConnection = new DefaultMediaHTTPConnection();
        AppMethodBeat.o(104799);
        return defaultMediaHTTPConnection;
    }
}
