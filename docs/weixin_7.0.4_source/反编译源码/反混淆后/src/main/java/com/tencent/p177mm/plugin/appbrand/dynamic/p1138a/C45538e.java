package com.tencent.p177mm.plugin.appbrand.dynamic.p1138a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C18651l;
import com.tencent.p177mm.modelappbrand.C18651l.C18650a;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.C42423b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p770ui.WxaWidgetDebugUI;
import com.tencent.p177mm.plugin.appbrand.wxawidget.console.C45731e;
import com.tencent.p177mm.sdk.p599a.C4872b;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.e */
public final class C45538e implements C18651l {
    boolean hmn;

    /* renamed from: e */
    public final void mo33915e(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(10761);
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String bL = WxaWidgetInitializer.m42771bL(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra("id", bL);
        context.startActivity(intent);
        AppMethodBeat.m2505o(10761);
    }

    /* renamed from: bT */
    public final void mo33913bT(Context context) {
        AppMethodBeat.m2504i(10762);
        C45731e.m84498dr(context);
        AppMethodBeat.m2505o(10762);
    }

    /* renamed from: kR */
    public final boolean mo33916kR(int i) {
        AppMethodBeat.m2504i(10763);
        boolean kR = C33097a.m54089kR(i);
        AppMethodBeat.m2505o(10763);
        return kR;
    }

    /* renamed from: a */
    public final boolean mo33909a(String str, C18650a c18650a) {
        AppMethodBeat.m2504i(10764);
        boolean c = C42423b.m75144c(str, c18650a);
        AppMethodBeat.m2505o(10764);
        return c;
    }

    /* renamed from: b */
    public final boolean mo33912b(String str, C18650a c18650a) {
        AppMethodBeat.m2504i(10765);
        boolean d = C42423b.m75145d(str, c18650a);
        AppMethodBeat.m2505o(10765);
        return d;
    }

    /* renamed from: cA */
    public final void mo33914cA(boolean z) {
        this.hmn = z;
    }

    public final boolean abE() {
        return this.hmn;
    }

    public final boolean abF() {
        AppMethodBeat.m2504i(10766);
        boolean dnO = C4872b.dnO();
        AppMethodBeat.m2505o(10766);
        return dnO;
    }
}
