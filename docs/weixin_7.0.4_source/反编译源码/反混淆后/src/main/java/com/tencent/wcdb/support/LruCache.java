package com.tencent.wcdb.support;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        AppMethodBeat.m2504i(12725);
        if (i <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.m2505o(12725);
            throw illegalArgumentException;
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
        AppMethodBeat.m2505o(12725);
    }

    public void resize(int i) {
        AppMethodBeat.m2504i(12726);
        if (i <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.m2505o(12726);
            throw illegalArgumentException;
        }
        synchronized (this) {
            try {
                this.maxSize = i;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12726);
            }
        }
        trimToSize(i);
    }

    /* JADX WARNING: Missing block: B:13:0x002e, code skipped:
            r1 = create(r6);
     */
    /* JADX WARNING: Missing block: B:14:0x0032, code skipped:
            if (r1 != null) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:15:0x0034, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12727);
     */
    /* JADX WARNING: Missing block: B:20:0x003f, code skipped:
            monitor-enter(r5);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            r5.createCount++;
            r0 = r5.map.put(r6, r1);
     */
    /* JADX WARNING: Missing block: B:23:0x004c, code skipped:
            if (r0 == null) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:24:0x004e, code skipped:
            r5.map.put(r6, r0);
     */
    /* JADX WARNING: Missing block: B:25:0x0053, code skipped:
            monitor-exit(r5);
     */
    /* JADX WARNING: Missing block: B:26:0x0054, code skipped:
            if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:27:0x0056, code skipped:
            entryRemoved(false, r6, r1, r0);
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            r5.size += safeSizeOf(r6, r1);
     */
    /* JADX WARNING: Missing block: B:31:0x006a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12727);
     */
    /* JADX WARNING: Missing block: B:32:0x006e, code skipped:
            trimToSize(r5.maxSize);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12727);
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
        AppMethodBeat.m2504i(12727);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.m2505o(12727);
            throw nullPointerException;
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
                AppMethodBeat.m2505o(12727);
            }
        }
        return v;
        return v;
    }

    public final V put(K k, V v) {
        AppMethodBeat.m2504i(12728);
        if (k == null || v == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null || value == null");
            AppMethodBeat.m2505o(12728);
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
                    AppMethodBeat.m2505o(12728);
                }
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        AppMethodBeat.m2505o(12728);
        return put;
    }

    /* JADX WARNING: Missing block: B:19:0x0051, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12729);
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int i) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(12729);
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                try {
                    if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                        illegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                        AppMethodBeat.m2505o(12729);
                    } else if (this.size <= i || this.map.isEmpty()) {
                    } else {
                        Entry entry;
                        if (this.map.entrySet().iterator().hasNext()) {
                            entry = (Entry) this.map.entrySet().iterator().next();
                        } else {
                            entry = null;
                        }
                        if (entry == null) {
                            break;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    }
                } finally {
                    AppMethodBeat.m2505o(12729);
                }
            }
            entryRemoved(true, key, value, null);
        }
        illegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
        AppMethodBeat.m2505o(12729);
        throw illegalStateException;
    }

    public final V remove(K k) {
        AppMethodBeat.m2504i(12730);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.m2505o(12730);
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
                    AppMethodBeat.m2505o(12730);
                }
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        AppMethodBeat.m2505o(12730);
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
        AppMethodBeat.m2504i(12731);
        int sizeOf = sizeOf(k, v);
        if (sizeOf < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Negative size: " + k + "=" + v);
            AppMethodBeat.m2505o(12731);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(12731);
        return sizeOf;
    }

    /* Access modifiers changed, original: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        AppMethodBeat.m2504i(12732);
        trimToSize(-1);
        AppMethodBeat.m2505o(12732);
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
        AppMethodBeat.m2504i(12733);
        linkedHashMap = new LinkedHashMap(this.map);
        AppMethodBeat.m2505o(12733);
        return linkedHashMap;
    }

    @SuppressLint({"DefaultLocale"})
    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(12734);
            int i2 = this.hitCount + this.missCount;
            if (i2 != 0) {
                i = (this.hitCount * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
            AppMethodBeat.m2505o(12734);
        }
        return format;
    }
}
