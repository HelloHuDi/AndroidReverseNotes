package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.ay */
public final class C13635ay {

    /* renamed from: com.tencent.mm.plugin.sns.ui.ay$1 */
    static class C136361 implements OnDismissListener {
        C136361() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(39833);
            C1720g.m3537RQ();
            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68385, null), 0) + 1;
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(68385, Integer.valueOf(a));
            AppMethodBeat.m2505o(39833);
        }
    }

    /* renamed from: b */
    public static void m21867b(Context context, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(39834);
        C5652a c5652a = new C5652a(context);
        c5652a.mo11446PV(C25738R.string.eqm);
        c5652a.asE(context.getString(C25738R.string.eqn) + "\n\n" + context.getString(C25738R.string.eqo));
        c5652a.mo11453Qc(C25738R.string.g0z).mo11457a(onClickListener);
        c5652a.mo11458a(new C136361());
        c5652a.aMb().show();
        AppMethodBeat.m2505o(39834);
    }
}
