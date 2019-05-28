package com.tencent.tmassistantsdk.downloadclient;

public interface ITMAssistantDownloadSDKClientListener {
    void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2);

    void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2);

    void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient);
}
