package com.google.android.gms.common.internal;

import android.support.p057v4.p065f.C0408g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze extends C0408g<K, V> {
    private final /* synthetic */ ExpirableLruCache zzss;

    zze(ExpirableLruCache expirableLruCache, int i) {
        this.zzss = expirableLruCache;
        super(i);
    }

    public final V create(K k) {
        AppMethodBeat.m2504i(89863);
        Object create = this.zzss.create(k);
        AppMethodBeat.m2505o(89863);
        return create;
    }

    public final void entryRemoved(boolean z, K k, V v, V v2) {
        AppMethodBeat.m2504i(89864);
        this.zzss.entryRemoved(z, k, v, v2);
        synchronized (this.zzss.mLock) {
            if (v2 == null) {
                try {
                    if (ExpirableLruCache.zzb(this.zzss)) {
                        this.zzss.zzsq.remove(k);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(89864);
                    }
                }
            }
            if (v2 == null && ExpirableLruCache.zzd(this.zzss)) {
                this.zzss.zzsr.remove(k);
            }
        }
        AppMethodBeat.m2505o(89864);
    }

    public final int sizeOf(K k, V v) {
        AppMethodBeat.m2504i(89862);
        int sizeOf = this.zzss.sizeOf(k, v);
        AppMethodBeat.m2505o(89862);
        return sizeOf;
    }
}
