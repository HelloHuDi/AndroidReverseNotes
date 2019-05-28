package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo extends LocalUsageInfo {
    public final String appName;
    public final int bQe;
    public final String csl;
    public final String euD;
    public final int gVs;
    public final String hac;
    public final boolean had;
    public final long updateTime;

    public AppBrandRecentTaskInfo(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, long j, long j2, boolean z, long j3) {
        super(str2, str3, i2, i3, str4, str5, str6, z, j, j2);
        this.euD = str;
        this.csl = str2;
        this.appName = str4;
        this.hac = str6;
        this.bQe = i;
        this.gVs = i2;
        this.had = z;
        this.updateTime = j3;
    }

    public final boolean xy() {
        return this.bQe == 4;
    }
}
