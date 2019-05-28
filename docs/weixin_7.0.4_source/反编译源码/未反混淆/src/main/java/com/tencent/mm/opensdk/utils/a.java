package com.tencent.mm.opensdk.utils;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static int a(Bundle bundle, String str) {
        int i = -1;
        AppMethodBeat.i(128072);
        if (bundle == null) {
            AppMethodBeat.o(128072);
        } else {
            try {
                i = bundle.getInt(str, -1);
            } catch (Exception e) {
                Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            }
            AppMethodBeat.o(128072);
        }
        return i;
    }

    public static String b(Bundle bundle, String str) {
        String str2 = null;
        AppMethodBeat.i(128073);
        if (bundle == null) {
            AppMethodBeat.o(128073);
        } else {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            }
            AppMethodBeat.o(128073);
        }
        return str2;
    }
}
