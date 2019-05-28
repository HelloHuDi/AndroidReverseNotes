package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jv */
public class C24396jv {
    /* renamed from: a */
    private LruCache<String, Bitmap> f4756a;
    /* renamed from: b */
    private Set<SoftReference<Bitmap>> f4757b;
    /* renamed from: c */
    private final float f4758c = 0.2f;

    public C24396jv(int i) {
        AppMethodBeat.m2504i(100128);
        m37874a(i);
        AppMethodBeat.m2505o(100128);
    }

    /* renamed from: a */
    private void m37874a(int i) {
        AppMethodBeat.m2504i(100129);
        int min = Math.min(i, (int) (0.2f * ((float) Runtime.getRuntime().maxMemory())));
        if (VERSION.SDK_INT >= 11) {
            this.f4757b = new HashSet();
        }
        this.f4756a = new LruCache<String, Bitmap>(min) {
            /* Access modifiers changed, original: protected|synthetic */
            public /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                AppMethodBeat.m2504i(100127);
                mo40659a(z, (String) obj, (Bitmap) obj2, (Bitmap) obj3);
                AppMethodBeat.m2505o(100127);
            }

            /* Access modifiers changed, original: protected|synthetic */
            public /* synthetic */ int sizeOf(Object obj, Object obj2) {
                AppMethodBeat.m2504i(100126);
                int a = mo40658a((String) obj, (Bitmap) obj2);
                AppMethodBeat.m2505o(100126);
                return a;
            }

            /* Access modifiers changed, original: protected */
            /* renamed from: a */
            public int mo40658a(String str, Bitmap bitmap) {
                AppMethodBeat.m2504i(100124);
                int a = C24396jv.this.mo40652a(bitmap);
                AppMethodBeat.m2505o(100124);
                return a;
            }

            /* Access modifiers changed, original: protected */
            /* renamed from: a */
            public void mo40659a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                AppMethodBeat.m2504i(100125);
                if (VERSION.SDK_INT >= 11) {
                    synchronized (C24396jv.this) {
                        try {
                            C24396jv.this.f4757b.add(new SoftReference(bitmap));
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(100125);
                        }
                    }
                    return;
                }
                AppMethodBeat.m2505o(100125);
            }
        };
        AppMethodBeat.m2505o(100129);
    }

    /* renamed from: a */
    public int mo40652a(Bitmap bitmap) {
        AppMethodBeat.m2504i(100130);
        int allocationByteCount;
        if (VERSION.SDK_INT >= 19) {
            allocationByteCount = bitmap.getAllocationByteCount();
            AppMethodBeat.m2505o(100130);
            return allocationByteCount;
        } else if (VERSION.SDK_INT >= 12) {
            allocationByteCount = bitmap.getByteCount();
            AppMethodBeat.m2505o(100130);
            return allocationByteCount;
        } else {
            allocationByteCount = bitmap.getRowBytes() * bitmap.getHeight();
            AppMethodBeat.m2505o(100130);
            return allocationByteCount;
        }
    }

    /* renamed from: a */
    public Bitmap mo40653a() {
        Bitmap bitmap;
        AppMethodBeat.m2504i(100131);
        synchronized (this) {
            try {
                if (!(this.f4757b == null || this.f4757b.isEmpty())) {
                    Iterator it = this.f4757b.iterator();
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
                AppMethodBeat.m2505o(100131);
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    public Bitmap mo40654a(String str) {
        AppMethodBeat.m2504i(100132);
        Bitmap bitmap = null;
        if (this.f4756a != null) {
            bitmap = (Bitmap) this.f4756a.get(str);
        }
        AppMethodBeat.m2505o(100132);
        return bitmap;
    }

    /* renamed from: a */
    public void mo40655a(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(100133);
        if (str == null || bitmap == null) {
            AppMethodBeat.m2505o(100133);
            return;
        }
        this.f4756a.put(str, bitmap);
        AppMethodBeat.m2505o(100133);
    }

    /* renamed from: b */
    public void mo40656b() {
        AppMethodBeat.m2504i(100134);
        if (this.f4756a != null) {
            this.f4756a.evictAll();
        }
        AppMethodBeat.m2505o(100134);
    }

    /* renamed from: c */
    public void mo40657c() {
        AppMethodBeat.m2504i(100135);
        this.f4756a.evictAll();
        this.f4757b.clear();
        this.f4756a = null;
        this.f4757b = null;
        AppMethodBeat.m2505o(100135);
    }
}
