package com.google.android.gms.common.internal;

public class GmsServiceEndpoint {
    private final String mPackageName;
    private final int zztq;
    private final String zzue;
    private final boolean zzuf;

    public GmsServiceEndpoint(String str, String str2, boolean z, int i) {
        this.mPackageName = str;
        this.zzue = str2;
        this.zzuf = z;
        this.zztq = i;
    }

    /* Access modifiers changed, original: final */
    public final int getBindFlags() {
        return this.zztq;
    }

    /* Access modifiers changed, original: final */
    public final String getPackageName() {
        return this.mPackageName;
    }

    /* Access modifiers changed, original: final */
    public final String zzcw() {
        return this.zzue;
    }
}
