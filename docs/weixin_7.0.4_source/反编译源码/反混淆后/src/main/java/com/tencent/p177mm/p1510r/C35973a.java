package com.tencent.p177mm.p1510r;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.model.C9634ae;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p230g.p231a.C37750kc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.r.a */
public final class C35973a {
    private static C9634ae cfL;

    /* renamed from: bH */
    public static boolean m59177bH(Context context) {
        AppMethodBeat.m2504i(77695);
        if (C35973a.m59176Oo()) {
            C4990ab.m7416i("MicroMsg.DeviceOccupy", "isMultiTalking");
            Toast.makeText(context, C25738R.string.d2p, 0).show();
            AppMethodBeat.m2505o(77695);
            return true;
        }
        AppMethodBeat.m2505o(77695);
        return false;
    }

    /* renamed from: Oo */
    public static boolean m59176Oo() {
        AppMethodBeat.m2504i(77696);
        C37750kc c37750kc = new C37750kc();
        c37750kc.cFw.action = 1;
        C4879a.xxA.mo10055m(c37750kc);
        boolean z = c37750kc.cFx.cFy;
        AppMethodBeat.m2505o(77696);
        return z;
    }

    /* renamed from: bI */
    public static boolean m59178bI(Context context) {
        AppMethodBeat.m2504i(77697);
        C18411uh c18411uh = new C18411uh();
        C4879a.xxA.mo10055m(c18411uh);
        if (c18411uh.cQt.cQv) {
            C4990ab.m7416i("MicroMsg.DeviceOccupy", "isCameraUsing");
            Toast.makeText(context, C35973a.m59180l(context, c18411uh.cQt.cQu), 0).show();
        }
        boolean z = c18411uh.cQt.cQv;
        AppMethodBeat.m2505o(77697);
        return z;
    }

    /* renamed from: bJ */
    public static boolean m59179bJ(Context context) {
        AppMethodBeat.m2504i(77698);
        C18411uh c18411uh = new C18411uh();
        C4879a.xxA.mo10055m(c18411uh);
        if (c18411uh.cQt.cQw) {
            C4990ab.m7416i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            Toast.makeText(context, C35973a.m59180l(context, c18411uh.cQt.cQu), 0).show();
        }
        boolean z = c18411uh.cQt.cQw;
        AppMethodBeat.m2505o(77698);
        return z;
    }

    /* renamed from: l */
    private static String m59180l(Context context, boolean z) {
        AppMethodBeat.m2504i(77699);
        String string;
        if (z) {
            string = context.getString(C25738R.string.ac4);
            AppMethodBeat.m2505o(77699);
            return string;
        }
        string = context.getString(C25738R.string.ac5);
        AppMethodBeat.m2505o(77699);
        return string;
    }

    /* renamed from: Cc */
    public static C9634ae m59175Cc() {
        AppMethodBeat.m2504i(77700);
        if (cfL == null) {
            cfL = C1321a.m2829Ib();
        }
        C9634ae c9634ae = cfL;
        AppMethodBeat.m2505o(77700);
        return c9634ae;
    }
}
