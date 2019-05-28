package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends g {
    public int duk;
    public String egd;
    public String[] ege;
    public String[] egf;
    public int egg;
    public int egh;
    public int egi;
    public int fileType;
    public String host;
    public boolean isColdSnsData;
    public String referer;
    public String signalQuality;
    public String snsCipherKey;
    public String snsScene;
    public String url;

    public e() {
        this.snsCipherKey = "";
        this.duk = -1;
        this.egi = -1;
        this.fileType = 0;
        this.egv = true;
    }

    public String toString() {
        AppMethodBeat.i(128594);
        String format = String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[]{this.field_mediaId, this.url, this.host, this.referer, this.egd, h(this.ege), h(this.egf), Integer.valueOf(this.egg), Integer.valueOf(this.egh), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene});
        AppMethodBeat.o(128594);
        return format;
    }

    private static String h(String[] strArr) {
        AppMethodBeat.i(128595);
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "";
            AppMethodBeat.o(128595);
            return str;
        }
        str = "";
        for (String str2 : strArr) {
            str = str + str2 + ",";
        }
        AppMethodBeat.o(128595);
        return str;
    }
}
