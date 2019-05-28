package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell.C38172a;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C33433e;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.debugger.g */
public final class C38173g implements C38172a {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C38173g.class), "handler", "getHandler()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;"))};
    private final C44856f hjk = C17344i.m26854g(C38174a.hjl);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.g$a */
    static final class C38174a extends C25053k implements C31214a<C33433e> {
        public static final C38174a hjl = new C38174a();

        static {
            AppMethodBeat.m2504i(134597);
            AppMethodBeat.m2505o(134597);
        }

        C38174a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134596);
            C33433e c33433e = new C33433e();
            AppMethodBeat.m2505o(134596);
            return c33433e;
        }
    }

    static {
        AppMethodBeat.m2504i(134598);
        AppMethodBeat.m2505o(134598);
    }

    public C38173g() {
        AppMethodBeat.m2504i(134600);
        AppMethodBeat.m2505o(134600);
    }

    public final String name() {
        return "MockScanCodeUrl";
    }

    /* renamed from: A */
    public final void mo21580A(Intent intent) {
        AppMethodBeat.m2504i(134599);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra != null) {
                ((C33433e) this.hjk.getValue()).mo22103a(C4996ah.getContext(), stringExtra, 1011, new Bundle());
                AppMethodBeat.m2505o(134599);
                return;
            }
        }
        AppMethodBeat.m2505o(134599);
    }
}
