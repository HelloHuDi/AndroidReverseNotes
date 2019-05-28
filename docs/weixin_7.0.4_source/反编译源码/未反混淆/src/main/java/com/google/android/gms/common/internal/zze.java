package com.google.android.gms.common.internal;

import android.support.v4.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze extends g<K, V> {
    private final /* synthetic */ ExpirableLruCache zzss;

    zze(ExpirableLruCache expirableLruCache, int i) {
        this.zzss = expirableLruCache;
        super(i);
    }

    public final V create(K k) {
        AppMethodBeat.i(89863);
        Object create = this.zzss.create(k);
        AppMethodBeat.o(89863);
        return create;
    }

    public final void entryRemoved(boolean z, K k, V v, V v2) {
        AppMethodBeat.i(89864);
        this.zzss.entryRemoved(z, k, v, v2);
        synchronized (this.zzss.mLock) {
            if (v2 == null) {
                try {
                    if (ExpirableLruCache.zzb(this.zzss)) {
                        this.zzss.zzsq.remove(k);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(89864);
                    }
                }
            }
            if (v2 == null && ExpirableLruCache.zzd(this.zzss)) {
                this.zzss.zzsr.remove(k);
            }
        }
        AppMethodBeat.o(89864);
    }

    public final int sizeOf(K k, V v) {
        AppMethodBeat.i(89862);
        int sizeOf = this.zzss.sizeOf(k, v);
        AppMethodBeat.o(89862);
        return sizeOf;
    }
}
