package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class StreamingRequest {
    public final Map<String, String> headers;
    public final Uri uri;

    public StreamingRequest(Uri uri, Map<String, String> map) {
        this.uri = uri;
        this.headers = map;
    }

    public String toString() {
        AppMethodBeat.i(105509);
        String str = "StreamingRequest{uri='" + this.uri + '\'' + ", headers=" + this.headers + '}';
        AppMethodBeat.o(105509);
        return str;
    }
}
