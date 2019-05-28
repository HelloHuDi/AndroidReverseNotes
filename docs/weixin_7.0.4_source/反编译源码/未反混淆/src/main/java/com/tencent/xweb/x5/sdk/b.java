package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.xweb.x5.sdk.f.a;

public interface b {
    boolean a(Context context, boolean z, boolean z2, a aVar);

    boolean isDownloadForeground();

    boolean isDownloading();

    boolean jA(Context context);

    void startDownload(Context context, boolean z);

    void stopDownload();
}
