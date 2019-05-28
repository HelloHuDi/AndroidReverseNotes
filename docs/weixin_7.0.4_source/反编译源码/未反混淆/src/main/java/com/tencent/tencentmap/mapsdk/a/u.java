package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class u extends s {
    private static Map<String, s> b = new HashMap();

    static {
        AppMethodBeat.i(98282);
        AppMethodBeat.o(98282);
    }

    public static s a(Context context, String str) {
        s uVar;
        AppMethodBeat.i(98278);
        if (StringUtil.isEmpty(str)) {
            w a = w.a(context);
            AppMethodBeat.o(98278);
            return a;
        }
        if (b.get(str) == null) {
            synchronized (u.class) {
                try {
                    if (b.get(str) == null) {
                        uVar = new u(context, str);
                        b.put(str, uVar);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(98278);
                }
            }
        }
        uVar = (s) b.get(str);
        AppMethodBeat.o(98278);
        return uVar;
        return uVar;
    }

    private u(Context context, String str) {
        AppMethodBeat.i(98279);
        this.a = context.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_".concat(String.valueOf(str)), 0);
        AppMethodBeat.o(98279);
    }

    public static void a(Context context) {
        AppMethodBeat.i(98280);
        try {
            for (File file : new File(context.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles()) {
                if (file.getName().startsWith("Tencent_MapSDK_SUB_CONFIG")) {
                    file.delete();
                }
            }
            AppMethodBeat.o(98280);
        } catch (Exception e) {
            AppMethodBeat.o(98280);
        }
    }

    public static void c() {
        AppMethodBeat.i(98281);
        if (b != null) {
            b.clear();
        }
        AppMethodBeat.o(98281);
    }
}
