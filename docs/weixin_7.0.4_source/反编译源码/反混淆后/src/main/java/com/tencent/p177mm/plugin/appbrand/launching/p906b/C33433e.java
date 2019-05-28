package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C10590a.C10593a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "Lcom/tencent/mm/plugin/appbrand/launching/links/AbsLinkOpener;", "()V", "handleResult", "", "url", "", "parsed", "Landroid/net/Uri;", "scene", "", "statExtras", "Landroid/os/Bundle;", "result", "Lcom/tencent/mm/plugin/appbrand/launching/links/AbsLinkOpener$HandleResult;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.e */
public final class C33433e extends C10590a {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo22104a(String str, Uri uri, C10593a c10593a) {
        AppMethodBeat.m2504i(134718);
        C25052j.m39376p(c10593a, "result");
        C4990ab.m7416i("MicroMsg.AppBrand.DebugCmdLinkOpener", "handleResult url[" + str + "], result[" + c10593a.name() + ']');
        AppMethodBeat.m2505o(134718);
    }
}
