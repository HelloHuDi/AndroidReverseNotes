package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoUtils {
    /* renamed from: a */
    private static C30946bg f13865a = null;

    /* renamed from: a */
    private static void m49481a(Context context) {
        DexLoader dexLoader = null;
        AppMethodBeat.m2504i(64628);
        synchronized (TbsVideoUtils.class) {
            try {
                if (f13865a == null) {
                    C5818o.m8863a(true).mo12196a(context, false, false, null);
                    C30947bi a = C5818o.m8863a(true).mo12195a();
                    if (a != null) {
                        dexLoader = a.mo50067b();
                    }
                    if (dexLoader != null) {
                        f13865a = new C30946bg(dexLoader);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(64628);
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        AppMethodBeat.m2504i(64629);
        m49481a(context);
        if (f13865a != null) {
            f13865a.mo50062a(context, str);
        }
        AppMethodBeat.m2505o(64629);
    }

    public static String getCurWDPDecodeType(Context context) {
        AppMethodBeat.m2504i(64630);
        m49481a(context);
        String a;
        if (f13865a != null) {
            a = f13865a.mo50061a(context);
            AppMethodBeat.m2505o(64630);
            return a;
        }
        a = "";
        AppMethodBeat.m2505o(64630);
        return a;
    }
}
