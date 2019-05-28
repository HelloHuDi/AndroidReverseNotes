package com.tencent.p177mm.p1637bo;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p057v4.app.C0363v.C0358c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.bo.a */
public final class C45186a {
    private static String evP = "";

    /* renamed from: My */
    public static String m83261My() {
        AppMethodBeat.m2504i(89331);
        if (C5046bo.isNullOrNil(evP)) {
            evP = C1668a.m3382Mz().getString("message_channel_id", "message_channel_new_id");
        }
        String str = evP;
        AppMethodBeat.m2505o(89331);
        return str;
    }

    public static void aii(String str) {
        evP = str;
    }

    public static int bWV() {
        if (VERSION.SDK_INT < 19) {
            return C25738R.drawable.bdn;
        }
        return C25738R.drawable.bdo;
    }

    /* renamed from: bt */
    public static C0358c m83262bt(Context context, String str) {
        AppMethodBeat.m2504i(89332);
        C0358c c0358c = new C0358c(context, str);
        AppMethodBeat.m2505o(89332);
        return c0358c;
    }

    public static String dgM() {
        String str;
        AppMethodBeat.m2504i(89333);
        if (C1443d.m3068iW(26)) {
            Object obj;
            Time time = new Time();
            time.setToNow();
            int i = time.hour;
            int i2 = time.minute;
            C4996ah.getContext();
            if (C37885a.m63972bS(i, i2)) {
                obj = null;
            } else {
                C4990ab.m7420w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
                obj = 1;
            }
            if (obj != null) {
                str = "message_dnd_mode_channel_id";
                AppMethodBeat.m2505o(89333);
                return str;
            }
        }
        str = C45186a.m83261My();
        AppMethodBeat.m2505o(89333);
        return str;
    }
}
