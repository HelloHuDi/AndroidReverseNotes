package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoUtils {
    private static bg a = null;

    private static void a(Context context) {
        DexLoader dexLoader = null;
        AppMethodBeat.i(64628);
        synchronized (TbsVideoUtils.class) {
            try {
                if (a == null) {
                    o.a(true).a(context, false, false, null);
                    bi a = o.a(true).a();
                    if (a != null) {
                        dexLoader = a.b();
                    }
                    if (dexLoader != null) {
                        a = new bg(dexLoader);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(64628);
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        AppMethodBeat.i(64629);
        a(context);
        if (a != null) {
            a.a(context, str);
        }
        AppMethodBeat.o(64629);
    }

    public static String getCurWDPDecodeType(Context context) {
        AppMethodBeat.i(64630);
        a(context);
        String a;
        if (a != null) {
            a = a.a(context);
            AppMethodBeat.o(64630);
            return a;
        }
        a = "";
        AppMethodBeat.o(64630);
        return a;
    }
}
