package com.tencent.p177mm.plugin.appbrand.game.p895g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.game.g.b */
public final class C26892b {
    private static boolean hrA = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.g.b$2 */
    static class C102382 implements OnClickListener {
        C102382() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(130338);
            C26892b.hrA = false;
            AppMethodBeat.m2505o(130338);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.g.b$1 */
    static class C268911 implements OnClickListener {
        C268911() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(130337);
            C26892b.hrA = false;
            AppMethodBeat.m2505o(130337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.g.b$3 */
    static class C268933 implements OnClickListener {
        C268933() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(130339);
            C26892b.hrA = false;
            AppMethodBeat.m2505o(130339);
        }
    }

    /* renamed from: cH */
    public static void m42829cH(Context context) {
        AppMethodBeat.m2504i(130340);
        String str = C1427q.etl.epF;
        if (hrA) {
            C4990ab.m7416i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
            AppMethodBeat.m2505o(130340);
            return;
        }
        String string = C4996ah.getResources().getString(C25738R.string.f9268ux);
        String string2 = C4996ah.getResources().getString(C25738R.string.f9238tz);
        if (C5046bo.isNullOrNil(str)) {
            str = string;
        }
        C26907a.m42842a(context, str, string2, C4996ah.getResources().getString(C25738R.string.f9187s6), "", new C268911(), new C102382(), new C268933());
        hrA = true;
        AppMethodBeat.m2505o(130340);
    }
}
