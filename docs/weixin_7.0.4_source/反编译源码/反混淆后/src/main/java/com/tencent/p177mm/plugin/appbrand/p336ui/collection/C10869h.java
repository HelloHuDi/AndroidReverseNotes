package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.widget.p1236f.C38592c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.h */
public final class C10869h {
    /* renamed from: a */
    public static boolean m18573a(boolean z, Context context, String str, int i) {
        AppMethodBeat.m2504i(133322);
        if (z) {
            try {
                if (((C10118af) C1720g.m3528K(C10118af.class)).mo21473aD(str, i)) {
                    new C38592c(context).mo61377F(context.getResources().getString(C25738R.string.f9067oc)).show();
                    AppMethodBeat.m2505o(133322);
                    return true;
                }
                C10869h.m18574r(context, z);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", str, Integer.valueOf(i), Boolean.valueOf(z), e);
                C10869h.m18574r(context, z);
            }
        } else {
            int aC = ((C10118af) C1720g.m3528K(C10118af.class)).mo21472aC(str, i);
            C5653c a;
            if (aC == 0) {
                new C38592c(context).mo61377F(context.getResources().getString(C25738R.string.f9066ob)).show();
                AppMethodBeat.m2505o(133322);
                return true;
            } else if (aC == -2) {
                aC = ((C10118af) C1720g.m3528K(C10118af.class)).awY();
                a = C30379h.m48443a(context, context.getResources().getString(C25738R.string.f8875ht, new Object[]{Integer.valueOf(aC)}), "", context.getResources().getString(C25738R.string.f9187s6), null);
                if (a != null) {
                    a.setCanceledOnTouchOutside(false);
                    a.mo11498qZ(true);
                }
            } else if (aC == -3) {
                a = C30379h.m48443a(context, context.getResources().getString(C25738R.string.f8836gh), "", context.getResources().getString(C25738R.string.f9187s6), null);
                if (a != null) {
                    a.setCanceledOnTouchOutside(false);
                    a.mo11498qZ(true);
                }
            } else {
                C10869h.m18574r(context, z);
            }
        }
        AppMethodBeat.m2505o(133322);
        return false;
    }

    /* renamed from: r */
    private static void m18574r(final Context context, final boolean z) {
        AppMethodBeat.m2504i(133323);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                CharSequence string;
                AppMethodBeat.m2504i(133321);
                Context context = context;
                if (z) {
                    string = context.getString(C25738R.string.f8862hf);
                } else {
                    string = context.getString(C25738R.string.f8860hd);
                }
                Toast.makeText(context, string, 0).show();
                AppMethodBeat.m2505o(133321);
            }
        });
        AppMethodBeat.m2505o(133323);
    }
}
