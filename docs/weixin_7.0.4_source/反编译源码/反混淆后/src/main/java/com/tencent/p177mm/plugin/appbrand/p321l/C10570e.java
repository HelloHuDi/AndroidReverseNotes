package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p321l.C33422d.C27148a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.l.e */
public final class C10570e {
    String bOr;
    String hvr;
    int ioJ;
    byte[] ioK;
    C27148a ioL;
    Map<String, String> ioM;
    ArrayList<String> ioN;
    int ioO = 15;
    String ioP;
    HttpURLConnection ioQ;
    String ioR;
    String mUrl;
    private long startTime;

    public C10570e(String str, byte[] bArr, int i, C27148a c27148a, String str2) {
        AppMethodBeat.m2504i(108159);
        this.mUrl = str;
        this.ioK = bArr;
        this.ioL = c27148a;
        this.ioJ = i;
        this.bOr = str2;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(108159);
    }

    public final int aID() {
        AppMethodBeat.m2504i(108160);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.m2505o(108160);
        return currentTimeMillis;
    }

    public final long getDataSize() {
        if (this.ioK != null) {
            return (long) this.ioK.length;
        }
        return 0;
    }
}
