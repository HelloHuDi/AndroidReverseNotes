package com.tencent.p177mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.f */
public final class C30006f {
    String hxH;
    public int kNb;
    int lqQ = 3;
    String mFilePath;
    public long mStartTime = System.currentTimeMillis();
    public String mUrl;
    String uWo;
    public String uWp;
    String uWq;
    public String uWr;
    public long uWs;
    boolean uWt;
    int uWu = C1625i.sHCENCODEVIDEOTIMEOUT;
    int uWv = C1625i.sHCENCODEVIDEOTIMEOUT;
    boolean uWw = true;
    C40395a uWx;
    public String uWy;

    public C30006f(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, boolean z, C40395a c40395a) {
        AppMethodBeat.m2504i(63448);
        this.uWo = str;
        this.kNb = i;
        this.uWp = str2;
        this.uWq = str3;
        this.uWr = str4;
        this.mUrl = str6;
        this.mFilePath = str7;
        this.uWs = j;
        this.hxH = str8;
        this.uWt = z;
        this.uWx = c40395a;
        this.uWy = str5;
        AppMethodBeat.m2505o(63448);
    }
}
