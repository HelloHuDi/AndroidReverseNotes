package com.tencent.p177mm.p203bg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C37750kc;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.bg.e */
public final class C17981e {
    /* renamed from: bH */
    public static boolean m28296bH(Context context) {
        AppMethodBeat.m2504i(78814);
        boolean bH = C35973a.m59177bH(context);
        AppMethodBeat.m2505o(78814);
        return bH;
    }

    /* renamed from: a */
    public static C5653c m28295a(Context context, int i, final Runnable runnable) {
        AppMethodBeat.m2504i(78818);
        C5652a c5652a = new C5652a(context);
        c5652a.mo11446PV(C25738R.string.f9238tz);
        c5652a.mo11450PZ(i);
        c5652a.mo11453Qc(C25738R.string.f9151r4).mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(78812);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.m2505o(78812);
            }
        });
        c5652a.mo11482rc(true);
        c5652a.mo11478f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(78813);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.m2505o(78813);
            }
        });
        C5653c aMb = c5652a.aMb();
        aMb.show();
        AppMethodBeat.m2505o(78818);
        return aMb;
    }

    public static boolean akI() {
        AppMethodBeat.m2504i(78815);
        C37750kc c37750kc = new C37750kc();
        c37750kc.cFw.action = 2;
        C4879a.xxA.mo10055m(c37750kc);
        boolean z = c37750kc.cFx.cFy;
        AppMethodBeat.m2505o(78815);
        return z;
    }

    public static boolean akJ() {
        AppMethodBeat.m2504i(78816);
        if (C32337g.fUs == null || !C32337g.fUs.akv()) {
            AppMethodBeat.m2505o(78816);
            return false;
        }
        AppMethodBeat.m2505o(78816);
        return true;
    }

    public static boolean akK() {
        AppMethodBeat.m2504i(78817);
        if (C25859d.fUu == null || !C25859d.fUu.akL()) {
            AppMethodBeat.m2505o(78817);
            return false;
        }
        AppMethodBeat.m2505o(78817);
        return true;
    }
}
