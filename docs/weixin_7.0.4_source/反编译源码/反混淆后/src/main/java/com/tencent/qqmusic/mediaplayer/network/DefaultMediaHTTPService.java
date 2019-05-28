package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class DefaultMediaHTTPService implements IMediaHTTPService {
    private static final String TAG = "DefaultMediaHTTPService";

    public IMediaHTTPConnection makeHTTPConnection() {
        AppMethodBeat.m2504i(104799);
        Logger.m71020d(TAG, "makeHTTPConnection");
        DefaultMediaHTTPConnection defaultMediaHTTPConnection = new DefaultMediaHTTPConnection();
        AppMethodBeat.m2505o(104799);
        return defaultMediaHTTPConnection;
    }
}
