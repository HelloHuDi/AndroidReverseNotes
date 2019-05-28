package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.a.u */
public class C41355u extends C41027s {
    /* renamed from: b */
    private static Map<String, C41027s> f16586b = new HashMap();

    static {
        AppMethodBeat.m2504i(98282);
        AppMethodBeat.m2505o(98282);
    }

    /* renamed from: a */
    public static C41027s m72123a(Context context, String str) {
        C41027s c41355u;
        AppMethodBeat.m2504i(98278);
        if (StringUtil.isEmpty(str)) {
            C31016w a = C31016w.m49806a(context);
            AppMethodBeat.m2505o(98278);
            return a;
        }
        if (f16586b.get(str) == null) {
            synchronized (C41355u.class) {
                try {
                    if (f16586b.get(str) == null) {
                        c41355u = new C41355u(context, str);
                        f16586b.put(str, c41355u);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(98278);
                }
            }
        }
        c41355u = (C41027s) f16586b.get(str);
        AppMethodBeat.m2505o(98278);
        return c41355u;
        return c41355u;
    }

    private C41355u(Context context, String str) {
        AppMethodBeat.m2504i(98279);
        this.f16426a = context.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_".concat(String.valueOf(str)), 0);
        AppMethodBeat.m2505o(98279);
    }

    /* renamed from: a */
    public static void m72124a(Context context) {
        AppMethodBeat.m2504i(98280);
        try {
            for (File file : new File(context.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles()) {
                if (file.getName().startsWith("Tencent_MapSDK_SUB_CONFIG")) {
                    file.delete();
                }
            }
            AppMethodBeat.m2505o(98280);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98280);
        }
    }

    /* renamed from: c */
    public static void m72125c() {
        AppMethodBeat.m2504i(98281);
        if (f16586b != null) {
            f16586b.clear();
        }
        AppMethodBeat.m2505o(98281);
    }
}
