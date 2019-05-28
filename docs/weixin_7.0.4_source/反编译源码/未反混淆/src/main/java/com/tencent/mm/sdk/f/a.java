package com.tencent.mm.sdk.f;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Locale;

public final class a {
    public static void a(String str, Context context) {
        AppMethodBeat.i(65356);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(65356);
            return;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", e.asY(str)));
        ab.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", str);
        AppMethodBeat.o(65356);
    }

    public static String RL(String str) {
        AppMethodBeat.i(65357);
        String str2 = com.tencent.mm.compatible.util.e.euR + String.format(Locale.US, "%s%d.%s", new Object[]{"mmexport", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.o(65357);
        return str2;
    }

    public static String dlz() {
        AppMethodBeat.i(65358);
        String str = com.tencent.mm.compatible.util.e.euR;
        str = str.substring(str.indexOf("tencent/MicroMsg"));
        AppMethodBeat.o(65358);
        return str;
    }
}
