package com.tencent.p177mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19133c;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c.C2242a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C42554c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C45610a;
import com.tencent.p177mm.plugin.appbrand.page.C45665r;
import com.tencent.p177mm.plugin.appbrand.report.model.C2445j;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.a */
public final class C33489a extends C19133c {
    private final C41243o iwd;
    private final C33327h iwe;
    private final C45610a iwf = new C45610a();

    public C33489a(C41243o c41243o, C33327h c33327h) {
        super(c41243o, c33327h, c41243o.mo43488xY());
        AppMethodBeat.m2504i(132501);
        this.iwd = c41243o;
        this.iwe = c33327h;
        AppMethodBeat.m2505o(132501);
    }

    /* renamed from: a */
    public final boolean mo6123a(C45608m c45608m, String str, int i, C2242a c2242a) {
        String str2;
        AppMethodBeat.m2504i(132502);
        C45610a c45610a = this.iwf;
        C33327h c33327h = this.iwe;
        C45665r atJ = this.iwd.atJ();
        if (atJ == null || atJ.getCurrentPage() == null) {
            str2 = "";
        } else {
            str2 = atJ.getCurrentPage().getCurrentUrl();
        }
        if (!C2445j.m4681DD(c45608m.getName())) {
            C42554c c42554c = new C42554c(c33327h, c45608m, str, C5046bo.m7588yz(), str2);
            synchronized (c45610a.hVp) {
                try {
                    c45610a.hVp.put(i, c42554c);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(132502);
                    }
                }
            }
        }
        boolean a = super.mo6123a(c45608m, str, i, c2242a);
        AppMethodBeat.m2505o(132502);
        return a;
    }

    /* renamed from: D */
    public final void mo6120D(int i, String str) {
        AppMethodBeat.m2504i(132503);
        super.mo6120D(i, str);
        this.iwf.mo73396W(i, str);
        AppMethodBeat.m2505o(132503);
    }

    /* renamed from: a */
    public final void mo6122a(C45608m c45608m, String str, int i, String str2) {
        AppMethodBeat.m2504i(132504);
        super.mo6122a(c45608m, str, i, str2);
        if (!TextUtils.isEmpty(str2)) {
            if ((C5058f.IS_FLAVOR_RED || C7243d.vxs || C7243d.vxr) && "fail:internal error invalid js component".equals(str2)) {
                ClassCastException classCastException = new ClassCastException(String.format("Mismatch api(%s) component", new Object[]{c45608m.getName()}));
                AppMethodBeat.m2505o(132504);
                throw classCastException;
            }
            this.iwf.mo73396W(i, str2);
        }
        AppMethodBeat.m2505o(132504);
    }
}
