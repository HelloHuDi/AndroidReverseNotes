package com.tencent.mm.bo;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.v.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    private static String evP = "";

    public static String My() {
        AppMethodBeat.i(89331);
        if (bo.isNullOrNil(evP)) {
            evP = com.tencent.mm.kernel.a.Mz().getString("message_channel_id", "message_channel_new_id");
        }
        String str = evP;
        AppMethodBeat.o(89331);
        return str;
    }

    public static void aii(String str) {
        evP = str;
    }

    public static int bWV() {
        if (VERSION.SDK_INT < 19) {
            return R.drawable.bdn;
        }
        return R.drawable.bdo;
    }

    public static c bt(Context context, String str) {
        AppMethodBeat.i(89332);
        c cVar = new c(context, str);
        AppMethodBeat.o(89332);
        return cVar;
    }

    public static String dgM() {
        String str;
        AppMethodBeat.i(89333);
        if (d.iW(26)) {
            Object obj;
            Time time = new Time();
            time.setToNow();
            int i = time.hour;
            int i2 = time.minute;
            ah.getContext();
            if (com.tencent.mm.m.a.bS(i, i2)) {
                obj = null;
            } else {
                ab.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
                obj = 1;
            }
            if (obj != null) {
                str = "message_dnd_mode_channel_id";
                AppMethodBeat.o(89333);
                return str;
            }
        }
        str = My();
        AppMethodBeat.o(89333);
        return str;
    }
}
