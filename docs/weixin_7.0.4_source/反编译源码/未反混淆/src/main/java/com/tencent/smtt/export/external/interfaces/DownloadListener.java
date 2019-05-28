package com.tencent.smtt.export.external.interfaces;

public interface DownloadListener {
    void onDownloadStart(String str, String str2, String str3, String str4, long j);

    void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7);

    void onDownloadVideo(String str, long j, int i);
}
