package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {

    public interface a {
        void gj(int i);
    }

    public static int aV(Context context) {
        int i = 0;
        AppMethodBeat.i(115028);
        if (context == null) {
            AppMethodBeat.o(115028);
        } else {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
                AppMethodBeat.o(115028);
            } catch (Throwable th) {
                AppMethodBeat.o(115028);
            }
        }
        return i;
    }

    public static int aW(Context context) {
        int i = 0;
        AppMethodBeat.i(115029);
        if (context == null) {
            AppMethodBeat.o(115029);
        } else {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 3072);
                AppMethodBeat.o(115029);
            } catch (Throwable th) {
                AppMethodBeat.o(115029);
            }
        }
        return i;
    }

    public static void e(Context context, String str, String str2) {
        AppMethodBeat.i(115030);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            String string = sharedPreferences.getString("crashlist", "");
            Editor edit = sharedPreferences.edit();
            edit.putString("crashlist", string + ";" + str + "," + str2);
            edit.commit();
            AppMethodBeat.o(115030);
        } catch (Throwable th) {
            AppMethodBeat.o(115030);
        }
    }
}
