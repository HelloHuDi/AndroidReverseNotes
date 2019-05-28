package com.google.android.gms.common.internal;

import android.support.p057v4.p065f.C0408g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExpirableLruCache<K, V> {
    public static int TIME_UNSET = -1;
    private final Object mLock = new Object();
    private final C0408g<K, V> zzsn;
    private final long zzso;
    private final long zzsp;
    private HashMap<K, Long> zzsq;
    private HashMap<K, Long> zzsr;

    public ExpirableLruCache(int i, long j, long j2, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(89594);
        this.zzso = TimeUnit.NANOSECONDS.convert(j, timeUnit);
        this.zzsp = TimeUnit.NANOSECONDS.convert(j2, timeUnit);
        boolean z = zzct() || zzcu();
        Preconditions.checkArgument(z, "ExpirableLruCache has both access and write expiration negative");
        this.zzsn = new zze(this, i);
        if (zzct()) {
            this.zzsq = new HashMap();
        }
        if (zzcu()) {
            this.zzsr = new HashMap();
        }
        AppMethodBeat.m2505o(89594);
    }

    private final boolean zza(K k) {
        AppMethodBeat.m2504i(89601);
        long nanoTime = System.nanoTime();
        if (zzct() && this.zzsq.containsKey(k) && nanoTime - ((Long) this.zzsq.get(k)).longValue() > this.zzso) {
            AppMethodBeat.m2505o(89601);
            return true;
        } else if (zzcu() && this.zzsr.containsKey(k) && nanoTime - ((Long) this.zzsr.get(k)).longValue() > this.zzsp) {
            AppMethodBeat.m2505o(89601);
            return true;
        } else {
            AppMethodBeat.m2505o(89601);
            return false;
        }
    }

    static /* synthetic */ boolean zzb(ExpirableLruCache expirableLruCache) {
        AppMethodBeat.m2504i(89602);
        boolean zzct = expirableLruCache.zzct();
        AppMethodBeat.m2505o(89602);
        return zzct;
    }

    private final boolean zzct() {
        return this.zzso >= 0;
    }

    private final boolean zzcu() {
        return this.zzsp >= 0;
    }

    static /* synthetic */ boolean zzd(ExpirableLruCache expirableLruCache) {
        AppMethodBeat.m2504i(89603);
        boolean zzcu = expirableLruCache.zzcu();
        AppMethodBeat.m2505o(89603);
        return zzcu;
    }

    /* Access modifiers changed, original: protected */
    public V create(K k) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public void evictAll() {
        AppMethodBeat.m2504i(89600);
        this.zzsn.evictAll();
        AppMethodBeat.m2505o(89600);
    }

    public V get(K k) {
        V v;
        AppMethodBeat.m2504i(89596);
        synchronized (this.mLock) {
            try {
                if (zza((Object) k)) {
                    this.zzsn.remove(k);
                }
                v = this.zzsn.get(k);
                if (v != null && this.zzso > 0) {
                    this.zzsq.put(k, Long.valueOf(System.nanoTime()));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(89596);
            }
        }
        return v;
    }

    public V put(K k, V v) {
        AppMethodBeat.m2504i(89595);
        if (zzcu()) {
            long nanoTime = System.nanoTime();
            synchronized (this.mLock) {
                try {
                    this.zzsr.put(k, Long.valueOf(nanoTime));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(89595);
                    }
                }
            }
        }
        Object put = this.zzsn.put(k, v);
        AppMethodBeat.m2505o(89595);
        return put;
    }

    public V remove(K k) {
        AppMethodBeat.m2504i(89597);
        Object remove = this.zzsn.remove(k);
        AppMethodBeat.m2505o(89597);
        return remove;
    }

    public void removeExpired() {
        AppMethodBeat.m2504i(89598);
        for (Object next : this.zzsn.snapshot().keySet()) {
            synchronized (this.mLock) {
                try {
                    if (zza(next)) {
                        this.zzsn.remove(next);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(89598);
                }
            }
        }
        AppMethodBeat.m2505o(89598);
    }

    /* Access modifiers changed, original: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public Map<K, V> snapshot() {
        AppMethodBeat.m2504i(89599);
        removeExpired();
        Map snapshot = this.zzsn.snapshot();
        AppMethodBeat.m2505o(89599);
        return snapshot;
    }
}
