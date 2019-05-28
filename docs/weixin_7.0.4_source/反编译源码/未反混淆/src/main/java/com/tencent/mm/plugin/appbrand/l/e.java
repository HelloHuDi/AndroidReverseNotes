package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l.d.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    String bOr;
    String hvr;
    int ioJ;
    byte[] ioK;
    a ioL;
    Map<String, String> ioM;
    ArrayList<String> ioN;
    int ioO = 15;
    String ioP;
    HttpURLConnection ioQ;
    String ioR;
    String mUrl;
    private long startTime;

    public e(String str, byte[] bArr, int i, a aVar, String str2) {
        AppMethodBeat.i(108159);
        this.mUrl = str;
        this.ioK = bArr;
        this.ioL = aVar;
        this.ioJ = i;
        this.bOr = str2;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(108159);
    }

    public final int aID() {
        AppMethodBeat.i(108160);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.o(108160);
        return currentTimeMillis;
    }

    public final long getDataSize() {
        if (this.ioK != null) {
            return (long) this.ioK.length;
        }
        return 0;
    }
}
