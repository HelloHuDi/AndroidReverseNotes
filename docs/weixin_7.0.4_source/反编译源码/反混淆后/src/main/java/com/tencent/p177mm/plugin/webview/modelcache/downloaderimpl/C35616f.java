package com.tencent.p177mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f */
public final class C35616f {
    public final long aHW;
    public final String appId;
    public final String bqF;
    public final String cSx;
    public final String cSy;
    public final int cSz;
    public final Exception exception;
    public final String filePath;
    public final String url;
    public final String version;

    public C35616f(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, long j, Exception exception) {
        this.url = str;
        this.filePath = str2;
        this.version = str3;
        this.appId = str4;
        this.cSx = str5;
        this.cSy = str6;
        this.cSz = i;
        this.bqF = str7;
        this.aHW = j;
        this.exception = exception;
    }

    public final String toString() {
        AppMethodBeat.m2504i(6909);
        String str = "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.cSx + '\'' + ", packageId='" + this.cSy + '\'' + ", cacheType=" + this.cSz + ", contentType='" + this.bqF + '\'' + ", contentLength=" + this.aHW + ", exception=" + this.exception + '}';
        AppMethodBeat.m2505o(6909);
        return str;
    }
}
