package com.tencent.tmassistantsdk.downloadclient;

public interface IAssistantOnActionListener {
    void onActionResult(byte[] bArr);

    void onDownloadSDKServiceInvalid();
}
