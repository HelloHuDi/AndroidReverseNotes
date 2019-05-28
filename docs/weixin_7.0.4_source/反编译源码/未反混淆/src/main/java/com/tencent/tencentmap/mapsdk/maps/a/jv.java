package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class jv {
    private LruCache<String, Bitmap> a;
    private Set<SoftReference<Bitmap>> b;
    private final float c = 0.2f;

    public jv(int i) {
        AppMethodBeat.i(100128);
        a(i);
        AppMethodBeat.o(100128);
    }

    private void a(int i) {
        AppMethodBeat.i(100129);
        int min = Math.min(i, (int) (0.2f * ((float) Runtime.getRuntime().maxMemory())));
        if (VERSION.SDK_INT >= 11) {
            this.b = new HashSet();
        }
        this.a = new LruCache<String, Bitmap>(min) {
            /* Access modifiers changed, original: protected|synthetic */
            public /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(100127);
                a(z, (String) obj, (Bitmap) obj2, (Bitmap) obj3);
                AppMethodBeat.o(100127);
            }

            /* Access modifiers changed, original: protected|synthetic */
            public /* synthetic */ int sizeOf(Object obj, Object obj2) {
                AppMethodBeat.i(100126);
                int a = a((String) obj, (Bitmap) obj2);
                AppMethodBeat.o(100126);
                return a;
            }

            /* Access modifiers changed, original: protected */
            public int a(String str, Bitmap bitmap) {
                AppMethodBeat.i(100124);
                int a = jv.this.a(bitmap);
                AppMethodBeat.o(100124);
                return a;
            }

            /* Access modifiers changed, original: protected */
            public void a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                AppMethodBeat.i(100125);
                if (VERSION.SDK_INT >= 11) {
                    synchronized (jv.this) {
                        try {
                            jv.this.b.add(new SoftReference(bitmap));
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(100125);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(100125);
            }
        };
        AppMethodBeat.o(100129);
    }

    public int a(Bitmap bitmap) {
        AppMethodBeat.i(100130);
        int allocationByteCount;
        if (VERSION.SDK_INT >= 19) {
            allocationByteCount = bitmap.getAllocationByteCount();
            AppMethodBeat.o(100130);
            return allocationByteCount;
        } else if (VERSION.SDK_INT >= 12) {
            allocationByteCount = bitmap.getByteCount();
            AppMethodBeat.o(100130);
            return allocationByteCount;
        } else {
            allocationByteCount = bitmap.getRowBytes() * bitmap.getHeight();
            AppMethodBeat.o(100130);
            return allocationByteCount;
        }
    }

    public Bitmap a() {
        Bitmap bitmap;
        AppMethodBeat.i(100131);
        synchronized (this) {
            try {
                if (!(this.b == null || this.b.isEmpty())) {
                    Iterator it = this.b.iterator();
                    while (it.hasNext()) {
                        bitmap = (Bitmap) ((SoftReference) it.next()).get();
                        if (bitmap != null && bitmap.isMutable()) {
                            it.remove();
                            break;
                        }
                        it.remove();
                    }
                }
                bitmap = null;
            } finally {
                AppMethodBeat.o(100131);
            }
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        AppMethodBeat.i(100132);
        Bitmap bitmap = null;
        if (this.a != null) {
            bitmap = (Bitmap) this.a.get(str);
        }
        AppMethodBeat.o(100132);
        return bitmap;
    }

    public void a(String str, Bitmap bitmap) {
        AppMethodBeat.i(100133);
        if (str == null || bitmap == null) {
            AppMethodBeat.o(100133);
            return;
        }
        this.a.put(str, bitmap);
        AppMethodBeat.o(100133);
    }

    public void b() {
        AppMethodBeat.i(100134);
        if (this.a != null) {
            this.a.evictAll();
        }
        AppMethodBeat.o(100134);
    }

    public void c() {
        AppMethodBeat.i(100135);
        this.a.evictAll();
        this.b.clear();
        this.a = null;
        this.b = null;
        AppMethodBeat.o(100135);
    }
}
