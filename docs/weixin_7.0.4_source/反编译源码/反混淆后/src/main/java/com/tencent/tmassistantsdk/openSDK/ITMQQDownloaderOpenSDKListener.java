package com.tencent.tmassistantsdk.openSDK;

public interface ITMQQDownloaderOpenSDKListener {
    void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2);

    void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str);

    void OnQQDownloaderInvalid();

    void OnServiceFree();
}
