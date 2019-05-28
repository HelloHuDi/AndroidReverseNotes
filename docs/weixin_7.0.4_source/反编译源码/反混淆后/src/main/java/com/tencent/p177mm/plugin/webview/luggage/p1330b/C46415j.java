package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C14492ap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.j */
public final class C46415j extends C43884a {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.b.j$1 */
    class C297811 extends C17817c {
        C297811() {
        }

        public final String name() {
            return "menu:share:appmessage";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            return null;
        }
    }

    public C46415j() {
        super(1);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6442);
        if (c24905d.mo23981wD(21)) {
            c44273l.mo70049a(this.f17231id, context.getString(C25738R.string.dhh), (int) C1318a.bottomsheet_icon_transmit);
        }
        AppMethodBeat.m2505o(6442);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6443);
        C14492ap.m22691IF(0);
        c24905d.cWN().aen("sendAppMessage");
        c24905d.bPN.mo52826a(new C297811());
        C7060h.pYm.mo15419k(982, 9, 1);
        AppMethodBeat.m2505o(6443);
    }
}
