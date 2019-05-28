package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p321l.C42599g.C33423a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.l.h */
public final class C42600h {
    String hvr;
    int ioJ;
    Map<String, String> ioM;
    ArrayList<String> ioN;
    int ioO = 15;
    HttpURLConnection ioQ = null;
    String ioR;
    Map<String, String> ioX;
    C33423a ioY;
    public volatile boolean isRunning = false;
    String mFileName;
    String mFilepath;
    String mMimeType;
    String mName;
    String mUrl;
    private long startTime;

    C42600h(String str, String str2, String str3, String str4, int i, String str5, C33423a c33423a) {
        AppMethodBeat.m2504i(108178);
        this.mFilepath = str;
        this.mUrl = str2;
        this.ioY = c33423a;
        this.mName = str3;
        this.mFileName = str4;
        this.ioJ = i;
        this.mMimeType = str5;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(108178);
    }

    public final int aID() {
        AppMethodBeat.m2504i(108179);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.m2505o(108179);
        return currentTimeMillis;
    }
}
