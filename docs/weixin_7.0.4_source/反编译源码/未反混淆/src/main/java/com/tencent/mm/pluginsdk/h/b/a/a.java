package com.tencent.mm.pluginsdk.h.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public final class a {
    public static boolean b(String str, Context context, boolean z) {
        AppMethodBeat.i(27458);
        o.all();
        boolean c = c(t.uh(str), context, z);
        AppMethodBeat.o(27458);
        return c;
    }

    public static boolean c(String str, Context context, boolean z) {
        AppMethodBeat.i(27459);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(27459);
            return false;
        } else if (context == null) {
            AppMethodBeat.o(27459);
            return false;
        } else {
            Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(268435456);
            addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
            addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 3);
            File file = new File(str);
            if (z) {
                k.a(context, addFlags, file, "video/quicktime");
            } else {
                k.a(context, addFlags, file, "video/*");
            }
            if (bo.k(context, addFlags)) {
                context.startActivity(addFlags);
                AppMethodBeat.o(27459);
                return true;
            }
            AppMethodBeat.o(27459);
            return false;
        }
    }
}
