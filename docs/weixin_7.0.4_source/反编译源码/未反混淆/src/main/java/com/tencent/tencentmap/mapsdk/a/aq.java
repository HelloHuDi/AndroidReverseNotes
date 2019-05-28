package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class aq {
    private a<String, Bitmap> a;

    static class a<K, V> {
        byte[] a = new byte[0];
        private LinkedHashMap<K, V> b;
        private int c;

        public a(int i) {
            AppMethodBeat.i(100574);
            this.c = i;
            this.b = new LinkedHashMap<K, V>(((int) Math.ceil((double) (((float) i) / 0.75f))) + 1, 0.75f, true) {
                /* Access modifiers changed, original: protected */
                public boolean removeEldestEntry(Entry<K, V> entry) {
                    AppMethodBeat.i(100573);
                    if (size() > a.this.c) {
                        AppMethodBeat.o(100573);
                        return true;
                    }
                    AppMethodBeat.o(100573);
                    return false;
                }
            };
            AppMethodBeat.o(100574);
        }

        public V a(K k) {
            V v;
            AppMethodBeat.i(100575);
            synchronized (this.a) {
                try {
                    v = this.b.get(k);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(100575);
                }
            }
            return v;
        }

        public void a(K k, V v) {
            AppMethodBeat.i(100576);
            synchronized (this.a) {
                try {
                    this.b.put(k, v);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(100576);
                }
            }
        }

        public void a() {
            AppMethodBeat.i(100577);
            synchronized (this.a) {
                try {
                    this.b.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(100577);
                }
            }
        }
    }

    public aq(int i) {
        AppMethodBeat.i(100578);
        this.a = new a(i);
        AppMethodBeat.o(100578);
    }

    public void a() {
        AppMethodBeat.i(100579);
        this.a.a();
        AppMethodBeat.o(100579);
    }

    public void a(String str, Bitmap bitmap) {
        AppMethodBeat.i(100580);
        this.a.a(str, bitmap);
        AppMethodBeat.o(100580);
    }

    public Bitmap a(String str) {
        AppMethodBeat.i(100581);
        Bitmap bitmap = (Bitmap) this.a.a((Object) str);
        AppMethodBeat.o(100581);
        return bitmap;
    }
}
