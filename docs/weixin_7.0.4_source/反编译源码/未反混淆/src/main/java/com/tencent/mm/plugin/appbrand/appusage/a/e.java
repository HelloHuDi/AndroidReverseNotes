package com.tencent.mm.plugin.appbrand.appusage.a;

import a.f.b.j;
import a.l;
import a.y;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, dWq = {"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ a.f.a.a hbA;

        a(a.f.a.a aVar) {
            this.hbA = aVar;
        }

        public final void run() {
            AppMethodBeat.i(134593);
            this.hbA.invoke();
            AppMethodBeat.o(134593);
        }
    }

    public static final void d(a.f.a.a<y> aVar) {
        AppMethodBeat.i(134594);
        j.p(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        m.aNS().aa(new a(aVar));
        AppMethodBeat.o(134594);
    }
}
