package com.tencent.tmassistantsdk.downloadservice.taskmanager;

public interface IServiceDownloadTaskManagerListener {
    void OnDownloadProgressChanged(String str, String str2, long j, long j2);

    void OnDownloadStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2);
}
