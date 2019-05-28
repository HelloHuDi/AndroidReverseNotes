package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.hardcoder.i;
import com.tencent.mm.pluginsdk.g.a.c.f.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l implements b {
    private final String filePath;
    private final String groupId;
    protected volatile int iSW = 15000;
    private final String method;
    final int networkType;
    final int priority;
    public final String url;
    public final String vdC;
    final int vdM;
    private final String veW;
    protected final Map<String, String> vfl = new HashMap();
    protected volatile int vfm = i.sHCENCODEVIDEOTIMEOUT;
    protected volatile int vfn = 15000;

    public l(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        this.vdC = str;
        this.filePath = str2;
        this.veW = str3;
        this.groupId = str4;
        this.url = str5;
        this.method = str6;
        this.vdM = i;
        this.networkType = i2;
        this.priority = Math.max(i3, 0);
    }

    public boolean dig() {
        return false;
    }

    public String awa() {
        return this.groupId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public final String dib() {
        return this.vdC;
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.vfl.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.vfl);
    }

    public final void setConnectTimeout(int i) {
        this.iSW = i;
    }

    public final int getConnectTimeout() {
        return this.iSW;
    }

    public final void setReadTimeout(int i) {
        this.vfm = i;
    }

    public final int getReadTimeout() {
        return this.vfm;
    }

    public final int diu() {
        return this.vfn;
    }
}
