package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b {
    private static final HashMap<String, a> vaE = new HashMap();
    private static final HashMap<String, a> vaF = new HashMap();
    private static final Pattern vaG = Pattern.compile(" +");

    static class a {
        String cSD;
        int vaH;
        a vaI;

        a() {
        }
    }

    static {
        AppMethodBeat.i(79203);
        AppMethodBeat.o(79203);
    }

    public static void a(a aVar, String... strArr) {
        AppMethodBeat.i(79199);
        synchronized (vaE) {
            try {
                for (Object put : strArr) {
                    vaE.put(put, aVar);
                    ab.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", put);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79199);
            }
        }
    }

    public static void N(String... strArr) {
        AppMethodBeat.i(79200);
        synchronized (vaE) {
            try {
                for (Object remove : strArr) {
                    vaE.remove(remove);
                    ab.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", remove);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79200);
            }
        }
    }

    public static boolean B(Context context, String str, String str2) {
        a aVar;
        AppMethodBeat.i(79201);
        String[] split = vaG.split(str);
        synchronized (vaE) {
            try {
                aVar = (a) vaE.get(split[0]);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79201);
            }
        }
        if (aVar != null) {
            ab.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", split[0]);
            boolean a = aVar.a(context, split, str2);
            return a;
        }
        AppMethodBeat.o(79201);
        return false;
    }

    static List<a> dgV() {
        List<a> arrayList;
        AppMethodBeat.i(79202);
        synchronized (vaF) {
            try {
                arrayList = new ArrayList(vaF.values());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79202);
            }
        }
        return arrayList;
    }
}
