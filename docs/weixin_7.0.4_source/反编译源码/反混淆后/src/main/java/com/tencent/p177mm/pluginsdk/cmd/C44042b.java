package com.tencent.p177mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.pluginsdk.cmd.b */
public final class C44042b {
    private static final HashMap<String, C44041a> vaE = new HashMap();
    private static final HashMap<String, C44043a> vaF = new HashMap();
    private static final Pattern vaG = Pattern.compile(" +");

    /* renamed from: com.tencent.mm.pluginsdk.cmd.b$a */
    static class C44043a {
        String cSD;
        int vaH;
        C44041a vaI;

        C44043a() {
        }
    }

    static {
        AppMethodBeat.m2504i(79203);
        AppMethodBeat.m2505o(79203);
    }

    /* renamed from: a */
    public static void m79163a(C44041a c44041a, String... strArr) {
        AppMethodBeat.m2504i(79199);
        synchronized (vaE) {
            try {
                for (Object put : strArr) {
                    vaE.put(put, c44041a);
                    C4990ab.m7417i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", put);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79199);
            }
        }
    }

    /* renamed from: N */
    public static void m79162N(String... strArr) {
        AppMethodBeat.m2504i(79200);
        synchronized (vaE) {
            try {
                for (Object remove : strArr) {
                    vaE.remove(remove);
                    C4990ab.m7417i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", remove);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79200);
            }
        }
    }

    /* renamed from: B */
    public static boolean m79161B(Context context, String str, String str2) {
        C44041a c44041a;
        AppMethodBeat.m2504i(79201);
        String[] split = vaG.split(str);
        synchronized (vaE) {
            try {
                c44041a = (C44041a) vaE.get(split[0]);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79201);
            }
        }
        if (c44041a != null) {
            C4990ab.m7417i("MicroMsg.UnifiedCommandProcessor", "Command: %s", split[0]);
            boolean a = c44041a.mo7165a(context, split, str2);
            return a;
        }
        AppMethodBeat.m2505o(79201);
        return false;
    }

    static List<C44043a> dgV() {
        List<C44043a> arrayList;
        AppMethodBeat.m2504i(79202);
        synchronized (vaF) {
            try {
                arrayList = new ArrayList(vaF.values());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79202);
            }
        }
        return arrayList;
    }
}
