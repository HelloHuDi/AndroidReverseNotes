package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.Map;

public class HttpDataSource implements IDataSource {
    private final Map<String, String> headers;
    private IMediaHTTPConnection mediaHTTPConnection;
    private final IMediaHTTPService service;
    private final Uri uri;

    public HttpDataSource(Uri uri, Map<String, String> map, IMediaHTTPService iMediaHTTPService) {
        this.uri = uri;
        this.headers = map;
        this.service = iMediaHTTPService;
    }

    public void open() {
        AppMethodBeat.m2504i(104549);
        this.mediaHTTPConnection = this.service.makeHTTPConnection();
        this.mediaHTTPConnection.connect(new URL(this.uri.toString()), this.headers);
        AppMethodBeat.m2505o(104549);
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(104550);
        int i3 = 0;
        do {
            int i4 = i + i3;
            int readAt = this.mediaHTTPConnection.readAt(((long) i3) + j, bArr, i4, i2 - i4);
            if (readAt >= 0) {
                if (readAt == 0) {
                    break;
                }
                i3 += readAt;
            } else {
                AppMethodBeat.m2505o(104550);
                return readAt;
            }
        } while (i3 < i2);
        AppMethodBeat.m2505o(104550);
        return i3;
    }

    public long getSize() {
        AppMethodBeat.m2504i(104551);
        long size = this.mediaHTTPConnection.getSize();
        AppMethodBeat.m2505o(104551);
        return size;
    }

    public AudioType getAudioType() {
        AppMethodBeat.m2504i(104552);
        AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.m2505o(104552);
        return audioFormat;
    }

    public void close() {
        AppMethodBeat.m2504i(104553);
        if (this.mediaHTTPConnection != null) {
            this.mediaHTTPConnection.disconnect();
        }
        AppMethodBeat.m2505o(104553);
    }
}
