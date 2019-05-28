package android.support.v4.f;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class g<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    /* JADX WARNING: Missing block: B:11:0x0023, code skipped:
            r1 = create(r5);
     */
    /* JADX WARNING: Missing block: B:12:0x0027, code skipped:
            if (r1 != null) goto L_0x002e;
     */
    /* JADX WARNING: Missing block: B:18:0x002e, code skipped:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            r4.createCount++;
            r0 = r4.map.put(r5, r1);
     */
    /* JADX WARNING: Missing block: B:21:0x003b, code skipped:
            if (r0 == null) goto L_0x004a;
     */
    /* JADX WARNING: Missing block: B:22:0x003d, code skipped:
            r4.map.put(r5, r0);
     */
    /* JADX WARNING: Missing block: B:23:0x0042, code skipped:
            monitor-exit(r4);
     */
    /* JADX WARNING: Missing block: B:24:0x0043, code skipped:
            if (r0 == null) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:25:0x0045, code skipped:
            entryRemoved(false, r5, r1, r0);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            r4.size += safeSizeOf(r5, r1);
     */
    /* JADX WARNING: Missing block: B:31:0x0057, code skipped:
            trimToSize(r4.maxSize);
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Object obj = this.map.get(k);
            if (obj != null) {
                this.hitCount++;
                return obj;
            }
            this.missCount++;
        }
    }

    public final V put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        Object put;
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: Missing block: B:9:0x0032, code skipped:
            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                    if (this.size <= i || this.map.isEmpty()) {
                    } else {
                        Entry entry = (Entry) this.map.entrySet().iterator().next();
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    }
                }
            }
            entryRemoved(true, key, value, null);
        }
    }

    public final V remove(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        Object remove;
        synchronized (this) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
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
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* Access modifiers changed, original: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
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
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.hitCount + this.missCount;
            if (i2 != 0) {
                i = (this.hitCount * 100) / i2;
            }
            format = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
        }
        return format;
    }
}
