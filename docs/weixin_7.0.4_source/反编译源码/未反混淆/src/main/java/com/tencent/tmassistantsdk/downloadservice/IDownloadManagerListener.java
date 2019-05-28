package com.tencent.tmassistantsdk.downloadservice;

public interface IDownloadManagerListener {
    void OnDownloadProgressChanged(String str, long j, long j2);

    void OnDownloadStateChanged(String str, int i, int i2, String str2, boolean z, boolean z2);
}
