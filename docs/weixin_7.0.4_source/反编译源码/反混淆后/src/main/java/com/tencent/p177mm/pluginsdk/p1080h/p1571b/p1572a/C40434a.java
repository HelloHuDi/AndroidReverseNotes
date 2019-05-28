package com.tencent.p177mm.pluginsdk.p1080h.p1571b.p1572a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.h.b.a.a */
public final class C40434a {
    /* renamed from: b */
    public static boolean m69348b(String str, Context context, boolean z) {
        AppMethodBeat.m2504i(27458);
        C37961o.all();
        boolean c = C40434a.m69349c(C9720t.m17303uh(str), context, z);
        AppMethodBeat.m2505o(27458);
        return c;
    }

    /* renamed from: c */
    public static boolean m69349c(String str, Context context, boolean z) {
        AppMethodBeat.m2504i(27459);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(27459);
            return false;
        } else if (context == null) {
            AppMethodBeat.m2505o(27459);
            return false;
        } else {
            Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(268435456);
            addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
            addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 3);
            File file = new File(str);
            if (z) {
                C15429k.m23713a(context, addFlags, file, "video/quicktime");
            } else {
                C15429k.m23713a(context, addFlags, file, "video/*");
            }
            if (C5046bo.m7572k(context, addFlags)) {
                context.startActivity(addFlags);
                AppMethodBeat.m2505o(27459);
                return true;
            }
            AppMethodBeat.m2505o(27459);
            return false;
        }
    }
}
