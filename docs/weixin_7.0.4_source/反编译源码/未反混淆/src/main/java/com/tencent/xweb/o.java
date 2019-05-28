package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public final class o {
    public boolean AMD;
    public String mEncoding;
    public InputStream mInputStream;
    public String mMimeType;
    public String mReasonPhrase;
    public Map<String, String> mResponseHeaders;
    public int mStatusCode;

    public o(String str, String str2, InputStream inputStream) {
        this.mStatusCode = 200;
        this.AMD = false;
        this.mMimeType = str;
        this.mEncoding = str2;
        this.mInputStream = inputStream;
        this.AMD = false;
    }

    public o(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        AppMethodBeat.i(3833);
        this.mStatusCode = i;
        this.mReasonPhrase = str3;
        this.mResponseHeaders = map;
        this.AMD = true;
        AppMethodBeat.o(3833);
    }
}
