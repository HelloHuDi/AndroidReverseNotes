package com.tencent.magicbrush.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"LongLogTag"})
public class a {
    private static volatile a bUq = null;
    public b bUr = new a(this, (byte) 0);

    public interface b {
        Bitmap bK(int i, int i2);

        void init();
    }

    class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void init() {
            AppMethodBeat.i(115984);
            c.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
            AppMethodBeat.o(115984);
        }

        public final Bitmap bK(int i, int i2) {
            AppMethodBeat.i(115985);
            c.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            AppMethodBeat.o(115985);
            return createBitmap;
        }
    }

    public static a yJ() {
        AppMethodBeat.i(115986);
        a aVar;
        if (bUq == null) {
            synchronized (a.class) {
                try {
                    if (bUq == null) {
                        bUq = new a();
                    }
                    aVar = bUq;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(115986);
                }
            }
            return aVar;
        }
        aVar = bUq;
        AppMethodBeat.o(115986);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(115987);
        this.bUr.init();
        AppMethodBeat.o(115987);
    }
}
