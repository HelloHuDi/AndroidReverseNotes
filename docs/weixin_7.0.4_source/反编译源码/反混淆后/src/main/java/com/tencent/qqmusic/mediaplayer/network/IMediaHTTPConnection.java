package com.tencent.qqmusic.mediaplayer.network;

import java.net.URL;
import java.util.Map;

public interface IMediaHTTPConnection {
    boolean connect(URL url, Map<String, String> map);

    void disconnect();

    String getMIMEType();

    long getSize();

    String getUri();

    int readAt(long j, byte[] bArr, int i, int i2);
}
