package com.tencent.p177mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.app.f */
public final class C1255f {

    /* renamed from: com.tencent.mm.app.f$a */
    public interface C1254a {
        /* renamed from: gj */
        void mo4540gj(int i);
    }

    /* renamed from: aV */
    public static int m2693aV(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(115028);
        if (context == null) {
            AppMethodBeat.m2505o(115028);
        } else {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
                AppMethodBeat.m2505o(115028);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(115028);
            }
        }
        return i;
    }

    /* renamed from: aW */
    public static int m2694aW(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(115029);
        if (context == null) {
            AppMethodBeat.m2505o(115029);
        } else {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 3072);
                AppMethodBeat.m2505o(115029);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(115029);
            }
        }
        return i;
    }

    /* renamed from: e */
    public static void m2695e(Context context, String str, String str2) {
        AppMethodBeat.m2504i(115030);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            String string = sharedPreferences.getString("crashlist", "");
            Editor edit = sharedPreferences.edit();
            edit.putString("crashlist", string + ";" + str + "," + str2);
            edit.commit();
            AppMethodBeat.m2505o(115030);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(115030);
        }
    }
}
