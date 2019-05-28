package com.tencent.luggage.sdk.p819a.p820a;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.sdk.a.a.b */
public class C45126b extends C38492q {
    public /* synthetic */ C44709u getCurrentPageView() {
        AppMethodBeat.m2504i(101661);
        C37402a xV = mo34955xV();
        AppMethodBeat.m2505o(101661);
        return xV;
    }

    public /* synthetic */ C6750i getRuntime() {
        AppMethodBeat.m2504i(101660);
        C25697b xL = mo34954xL();
        AppMethodBeat.m2505o(101660);
        return xL;
    }

    /* renamed from: xV */
    public C37402a mo34955xV() {
        AppMethodBeat.m2504i(101657);
        C37402a c37402a = (C37402a) super.mo61196ac(C37402a.class);
        AppMethodBeat.m2505o(101657);
        return c37402a;
    }

    /* renamed from: xL */
    public C25697b mo34954xL() {
        AppMethodBeat.m2504i(101658);
        C25697b c25697b = (C25697b) super.getRuntime();
        AppMethodBeat.m2505o(101658);
        return c25697b;
    }

    /* renamed from: xW */
    public JSONObject mo21959xW() {
        AppMethodBeat.m2504i(101659);
        JSONObject xW = super.mo21959xW();
        mo21956b(xW, "appType", Integer.valueOf(mo34954xL().mo43491ya().bQe));
        AppMethodBeat.m2505o(101659);
        return xW;
    }

    /* renamed from: xX */
    public final boolean mo53815xX() {
        return true;
    }
}
