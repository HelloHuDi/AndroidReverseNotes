package com.tencent.p177mm.p235i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.i.e */
public class C26325e extends C42130g {
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

    public C26325e() {
        this.snsCipherKey = "";
        this.duk = -1;
        this.egi = -1;
        this.fileType = 0;
        this.egv = true;
    }

    public String toString() {
        AppMethodBeat.m2504i(128594);
        String format = String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[]{this.field_mediaId, this.url, this.host, this.referer, this.egd, C26325e.m41896h(this.ege), C26325e.m41896h(this.egf), Integer.valueOf(this.egg), Integer.valueOf(this.egh), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene});
        AppMethodBeat.m2505o(128594);
        return format;
    }

    /* renamed from: h */
    private static String m41896h(String[] strArr) {
        AppMethodBeat.m2504i(128595);
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "";
            AppMethodBeat.m2505o(128595);
            return str;
        }
        str = "";
        for (String str2 : strArr) {
            str = str + str2 + ",";
        }
        AppMethodBeat.m2505o(128595);
        return str;
    }
}
