package com.google.android.gms.iid;

import javax.annotation.concurrent.GuardedBy;

abstract class zzai {
    @GuardedBy("SdkFlagFactory.class")
    private static zzai zzcy;

    zzai() {
    }

    static synchronized zzai zzw() {
        zzai zzai;
        synchronized (zzai.class) {
            if (zzcy == null) {
                zzcy = new zzac();
            }
            zzai = zzcy;
        }
        return zzai;
    }

    public abstract zzaj<Boolean> zzd(String str, boolean z);
}
