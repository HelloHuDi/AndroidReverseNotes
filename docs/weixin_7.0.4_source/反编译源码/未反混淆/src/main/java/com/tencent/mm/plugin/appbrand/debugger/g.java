package com.tencent.mm.plugin.appbrand.debugger;

import a.f;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.b.e;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class g implements com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(g.class), "handler", "getHandler()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;"))};
    private final f hjk = i.g(a.hjl);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<e> {
        public static final a hjl = new a();

        static {
            AppMethodBeat.i(134597);
            AppMethodBeat.o(134597);
        }

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134596);
            e eVar = new e();
            AppMethodBeat.o(134596);
            return eVar;
        }
    }

    static {
        AppMethodBeat.i(134598);
        AppMethodBeat.o(134598);
    }

    public g() {
        AppMethodBeat.i(134600);
        AppMethodBeat.o(134600);
    }

    public final String name() {
        return "MockScanCodeUrl";
    }

    public final void A(Intent intent) {
        AppMethodBeat.i(134599);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra != null) {
                ((e) this.hjk.getValue()).a(ah.getContext(), stringExtra, 1011, new Bundle());
                AppMethodBeat.o(134599);
                return;
            }
        }
        AppMethodBeat.o(134599);
    }
}
