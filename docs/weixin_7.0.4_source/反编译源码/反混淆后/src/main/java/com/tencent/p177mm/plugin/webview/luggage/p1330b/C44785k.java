package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42571f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.k */
public final class C44785k extends C43884a {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.b.k$1 */
    class C438851 extends C17817c {
        C438851() {
        }

        public final String name() {
            return "menu:share:timeline";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            return null;
        }
    }

    public C44785k() {
        super(2);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6444);
        if (c24905d.mo23981wD(23)) {
            c44273l.mo70049a(2, context.getString(C25738R.string.dhi), (int) C1318a.bottomsheet_icon_moment);
        }
        AppMethodBeat.m2505o(6444);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6445);
        c24905d.cWN().aen(C42571f.NAME);
        c24905d.bPN.mo52826a(new C438851());
        C7060h.pYm.mo15419k(982, 10, 1);
        AppMethodBeat.m2505o(6445);
    }
}
