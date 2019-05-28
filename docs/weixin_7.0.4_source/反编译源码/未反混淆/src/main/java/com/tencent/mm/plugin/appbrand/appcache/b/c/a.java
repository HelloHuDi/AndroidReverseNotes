package com.tencent.mm.plugin.appbrand.appcache.b.c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.g;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.xwalk.core.XWalkEnvironment;

public enum a {
    ;
    
    public static final a gWm = null;
    public static final a gWn = null;
    public static final a gWo = null;
    public static final a gWp = null;

    public static class a<_Key> extends SparseIntArray {
        public final void e(_Key _key, int i) {
            AppMethodBeat.i(129495);
            super.put(_key.hashCode(), i);
            AppMethodBeat.o(129495);
        }

        private int bn(_Key _key) {
            AppMethodBeat.i(129496);
            if (_key == null) {
                AppMethodBeat.o(129496);
                return -1;
            }
            int i = super.get(_key.hashCode(), -1);
            AppMethodBeat.o(129496);
            return i;
        }

        public final int get(_Key _key) {
            AppMethodBeat.i(129497);
            int bn = bn(_key);
            AppMethodBeat.o(129497);
            return bn;
        }
    }

    private a(String str) {
    }

    static {
        gWm = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
            {
                AppMethodBeat.i(129491);
                e(d.class, 20);
                e(c.class, 40);
                e(e.class, 80);
                e(g.class, 100);
                e(f.class, 120);
                e(h.class, 150);
                e(b.class, 160);
                AppMethodBeat.o(129491);
            }
        };
        gWn = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
            {
                AppMethodBeat.i(129492);
                e(d.class, 21);
                e(c.class, 41);
                e(e.class, 81);
                e(g.class, 101);
                e(f.class, 121);
                e(h.class, 151);
                e(b.class, 161);
                AppMethodBeat.o(129492);
            }
        };
        gWo = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
            {
                AppMethodBeat.i(129493);
                e(d.class, 22);
                e(c.class, 42);
                e(e.class, 82);
                e(g.class, 102);
                e(f.class, 122);
                e(h.class, 152);
                e(b.class, ErrorCode.STARTDOWNLOAD_3);
                AppMethodBeat.o(129493);
            }
        };
        gWp = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
            {
                AppMethodBeat.i(129494);
                e(d.class, 23);
                e(c.class, 43);
                e(e.class, 83);
                e(g.class, 103);
                e(f.class, 123);
                e(h.class, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
                e(b.class, ErrorCode.STARTDOWNLOAD_4);
                AppMethodBeat.o(129494);
            }
        };
        AppMethodBeat.o(129502);
    }

    public static void cO(int i, int i2) {
        AppMethodBeat.i(139124);
        z((long) i, (long) i2);
        AppMethodBeat.o(139124);
    }

    public static void z(long j, long j2) {
        AppMethodBeat.i(129501);
        if (j2 < 0) {
            ab.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", Long.valueOf(j), Long.valueOf(j2));
            AppMethodBeat.o(129501);
            return;
        }
        if (j > 0) {
            com.tencent.mm.plugin.report.service.h.pYm.k(j, j2, 1);
            com.tencent.mm.plugin.report.service.h.pYm.e(15272, Long.valueOf(j), Long.valueOf(j2));
        }
        if (843 != j) {
            com.tencent.mm.plugin.report.service.h.pYm.k(843, j2, 1);
            com.tencent.mm.plugin.report.service.h.pYm.e(15272, Integer.valueOf(843), Long.valueOf(j2));
        }
        AppMethodBeat.o(129501);
    }
}
