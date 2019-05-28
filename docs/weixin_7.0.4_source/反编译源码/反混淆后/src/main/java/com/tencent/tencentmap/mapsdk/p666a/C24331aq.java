package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.a.aq */
public class C24331aq {
    /* renamed from: a */
    private C24329a<String, Bitmap> f4594a;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aq$a */
    static class C24329a<K, V> {
        /* renamed from: a */
        byte[] f4590a = new byte[0];
        /* renamed from: b */
        private LinkedHashMap<K, V> f4591b;
        /* renamed from: c */
        private int f4592c;

        public C24329a(int i) {
            AppMethodBeat.m2504i(100574);
            this.f4592c = i;
            this.f4591b = new LinkedHashMap<K, V>(((int) Math.ceil((double) (((float) i) / 0.75f))) + 1, 0.75f, true) {
                /* Access modifiers changed, original: protected */
                public boolean removeEldestEntry(Entry<K, V> entry) {
                    AppMethodBeat.m2504i(100573);
                    if (size() > C24329a.this.f4592c) {
                        AppMethodBeat.m2505o(100573);
                        return true;
                    }
                    AppMethodBeat.m2505o(100573);
                    return false;
                }
            };
            AppMethodBeat.m2505o(100574);
        }

        /* renamed from: a */
        public V mo40415a(K k) {
            V v;
            AppMethodBeat.m2504i(100575);
            synchronized (this.f4590a) {
                try {
                    v = this.f4591b.get(k);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(100575);
                }
            }
            return v;
        }

        /* renamed from: a */
        public void mo40417a(K k, V v) {
            AppMethodBeat.m2504i(100576);
            synchronized (this.f4590a) {
                try {
                    this.f4591b.put(k, v);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(100576);
                }
            }
        }

        /* renamed from: a */
        public void mo40416a() {
            AppMethodBeat.m2504i(100577);
            synchronized (this.f4590a) {
                try {
                    this.f4591b.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(100577);
                }
            }
        }
    }

    public C24331aq(int i) {
        AppMethodBeat.m2504i(100578);
        this.f4594a = new C24329a(i);
        AppMethodBeat.m2505o(100578);
    }

    /* renamed from: a */
    public void mo40420a() {
        AppMethodBeat.m2504i(100579);
        this.f4594a.mo40416a();
        AppMethodBeat.m2505o(100579);
    }

    /* renamed from: a */
    public void mo40421a(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(100580);
        this.f4594a.mo40417a(str, bitmap);
        AppMethodBeat.m2505o(100580);
    }

    /* renamed from: a */
    public Bitmap mo40419a(String str) {
        AppMethodBeat.m2504i(100581);
        Bitmap bitmap = (Bitmap) this.f4594a.mo40415a((Object) str);
        AppMethodBeat.m2505o(100581);
        return bitmap;
    }
}
