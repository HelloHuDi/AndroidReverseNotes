package com.tencent.magicbrush.p1456b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"LongLogTag"})
/* renamed from: com.tencent.magicbrush.b.a */
public class C32195a {
    private static volatile C32195a bUq = null;
    public C32194b bUr = new C32196a(this, (byte) 0);

    /* renamed from: com.tencent.magicbrush.b.a$b */
    public interface C32194b {
        /* renamed from: bK */
        Bitmap mo52851bK(int i, int i2);

        void init();
    }

    /* renamed from: com.tencent.magicbrush.b.a$a */
    class C32196a implements C32194b {
        private C32196a() {
        }

        /* synthetic */ C32196a(C32195a c32195a, byte b) {
            this();
        }

        public final void init() {
            AppMethodBeat.m2504i(115984);
            C17837c.m27916i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
            AppMethodBeat.m2505o(115984);
        }

        /* renamed from: bK */
        public final Bitmap mo52851bK(int i, int i2) {
            AppMethodBeat.m2504i(115985);
            C17837c.m27916i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            AppMethodBeat.m2505o(115985);
            return createBitmap;
        }
    }

    /* renamed from: yJ */
    public static C32195a m52520yJ() {
        AppMethodBeat.m2504i(115986);
        C32195a c32195a;
        if (bUq == null) {
            synchronized (C32195a.class) {
                try {
                    if (bUq == null) {
                        bUq = new C32195a();
                    }
                    c32195a = bUq;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(115986);
                }
            }
            return c32195a;
        }
        c32195a = bUq;
        AppMethodBeat.m2505o(115986);
        return c32195a;
    }

    private C32195a() {
        AppMethodBeat.m2504i(115987);
        this.bUr.init();
        AppMethodBeat.m2505o(115987);
    }
}
