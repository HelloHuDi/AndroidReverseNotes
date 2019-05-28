package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tencent.mm.sdk.platformtools.ae */
public class C4993ae<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    public final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public C4993ae(int i) {
        AppMethodBeat.m2504i(52033);
        if (i <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.m2505o(52033);
            throw illegalArgumentException;
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
        AppMethodBeat.m2505o(52033);
    }

    /* renamed from: aj */
    public final synchronized boolean mo10274aj(K k) {
        boolean containsKey;
        AppMethodBeat.m2504i(52034);
        containsKey = this.map.containsKey(k);
        AppMethodBeat.m2505o(52034);
        return containsKey;
    }

    /* renamed from: ak */
    public final synchronized boolean mo10275ak(K k) {
        boolean z;
        AppMethodBeat.m2504i(52035);
        if (get(k) != null) {
            z = true;
            AppMethodBeat.m2505o(52035);
        } else {
            z = false;
            AppMethodBeat.m2505o(52035);
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:12:0x0040, code skipped:
            r1 = create(r8);
     */
    /* JADX WARNING: Missing block: B:13:0x0044, code skipped:
            if (r1 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:14:0x0046, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52036);
     */
    /* JADX WARNING: Missing block: B:19:0x0050, code skipped:
            monitor-enter(r7);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            r7.createCount++;
            r0 = r7.map.put(r8, r1);
     */
    /* JADX WARNING: Missing block: B:22:0x005d, code skipped:
            if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:23:0x005f, code skipped:
            r7.map.put(r8, r0);
     */
    /* JADX WARNING: Missing block: B:24:0x0064, code skipped:
            monitor-exit(r7);
     */
    /* JADX WARNING: Missing block: B:25:0x0065, code skipped:
            if (r0 == null) goto L_0x007e;
     */
    /* JADX WARNING: Missing block: B:26:0x0067, code skipped:
            entryRemoved(false, r8, r1, r0);
     */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            r7.size += safeSizeOf(r8, r1);
     */
    /* JADX WARNING: Missing block: B:30:0x007a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52036);
     */
    /* JADX WARNING: Missing block: B:31:0x007e, code skipped:
            trimToSize(r7.maxSize);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52036);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K k) {
        V v;
        AppMethodBeat.m2504i(52036);
        if (k == null) {
            C4990ab.m7413e("MicroMsg.LruMap", "key == null %s", C5046bo.dpG().toString());
            AppMethodBeat.m2505o(52036);
            return null;
        }
        synchronized (this) {
            try {
                v = this.map.get(k);
                if (v != null) {
                    this.hitCount++;
                } else {
                    this.missCount++;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(52036);
            }
        }
        return r0;
        return v;
    }

    public final V put(K k, V v) {
        AppMethodBeat.m2504i(52037);
        if (k == null || v == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null || value == null");
            AppMethodBeat.m2505o(52037);
            throw nullPointerException;
        }
        Object put;
        synchronized (this) {
            try {
                this.putCount++;
                this.size += safeSizeOf(k, v);
                put = this.map.put(k, v);
                if (put != null) {
                    this.size -= safeSizeOf(k, put);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(52037);
                }
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        AppMethodBeat.m2505o(52037);
        return put;
    }

    public void trimToSize(int i) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(52038);
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                try {
                    if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                        illegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                        AppMethodBeat.m2505o(52038);
                    } else if (this.size <= i || this.map.isEmpty()) {
                    } else {
                        Entry entry = (Entry) this.map.entrySet().iterator().next();
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    }
                } finally {
                    AppMethodBeat.m2505o(52038);
                }
            }
            entryRemoved(true, key, value, null);
        }
        illegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
        AppMethodBeat.m2505o(52038);
        throw illegalStateException;
    }

    public final V remove(K k) {
        AppMethodBeat.m2504i(52039);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.m2505o(52039);
            throw nullPointerException;
        }
        Object remove;
        synchronized (this) {
            try {
                remove = this.map.remove(k);
                if (remove != null) {
                    this.size -= safeSizeOf(k, remove);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(52039);
                }
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        AppMethodBeat.m2505o(52039);
        return remove;
    }

    /* Access modifiers changed, original: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    /* Access modifiers changed, original: protected */
    public V create(K k) {
        return null;
    }

    private int safeSizeOf(K k, V v) {
        AppMethodBeat.m2504i(52040);
        int sizeOf = sizeOf(k, v);
        if (sizeOf < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Negative size: " + k + "=" + v);
            AppMethodBeat.m2505o(52040);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(52040);
        return sizeOf;
    }

    /* Access modifiers changed, original: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        AppMethodBeat.m2504i(52041);
        linkedHashMap = new LinkedHashMap(this.map);
        AppMethodBeat.m2505o(52041);
        return linkedHashMap;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(52042);
            int i2 = this.hitCount + this.missCount;
            if (i2 != 0) {
                i = (this.hitCount * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
            AppMethodBeat.m2505o(52042);
        }
        return format;
    }

    public final Set<K> keySet() {
        AppMethodBeat.m2504i(138960);
        Set keySet = this.map.keySet();
        AppMethodBeat.m2505o(138960);
        return keySet;
    }
}
