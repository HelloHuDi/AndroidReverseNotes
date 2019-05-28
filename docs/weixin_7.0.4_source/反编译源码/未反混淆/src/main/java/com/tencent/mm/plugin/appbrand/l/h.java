package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l.g.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h {
    String hvr;
    int ioJ;
    Map<String, String> ioM;
    ArrayList<String> ioN;
    int ioO = 15;
    HttpURLConnection ioQ = null;
    String ioR;
    Map<String, String> ioX;
    a ioY;
    public volatile boolean isRunning = false;
    String mFileName;
    String mFilepath;
    String mMimeType;
    String mName;
    String mUrl;
    private long startTime;

    h(String str, String str2, String str3, String str4, int i, String str5, a aVar) {
        AppMethodBeat.i(108178);
        this.mFilepath = str;
        this.mUrl = str2;
        this.ioY = aVar;
        this.mName = str3;
        this.mFileName = str4;
        this.ioJ = i;
        this.mMimeType = str5;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(108178);
    }

    public final int aID() {
        AppMethodBeat.i(108179);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.o(108179);
        return currentTimeMillis;
    }
}
