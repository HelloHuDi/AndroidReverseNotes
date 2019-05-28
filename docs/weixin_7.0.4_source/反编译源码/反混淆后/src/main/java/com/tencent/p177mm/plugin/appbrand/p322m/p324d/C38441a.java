package com.tencent.p177mm.plugin.appbrand.p322m.p324d;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C27279r.C27280a;
import com.tencent.p177mm.plugin.appbrand.C27279r.C27281b;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e.C38438a;
import com.tencent.p177mm.plugin.appbrand.p322m.p1229b.C42628b;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.appbrand.m.d.a */
public final class C38441a extends C42627e {
    private C27281b iqj;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.d.a$1 */
    class C271941 implements C27281b {
        C271941() {
        }

        public final void auh() {
            AppMethodBeat.m2504i(102204);
            C4990ab.m7416i("MicroMsg.ProxyAppBrandServiceOnInitListener", "onRuntimeReady");
            C6750i runtime = C38441a.this.gMN.getRuntime();
            if (runtime == null) {
                IllegalStateException illegalStateException = new IllegalStateException("onRuntimeReady runtime null");
                AppMethodBeat.m2505o(102204);
                throw illegalStateException;
            }
            HashMap hashMap = new HashMap();
            C33491e xY = ((C25697b) runtime).mo43488xY();
            if (xY == null) {
                C4990ab.m7420w("MicroMsg.ProxyAppBrandServiceOnInitListener", "fillPermissionBytes controller null");
            } else {
                Vector aKw = xY.aKw();
                if (aKw == null) {
                    C4990ab.m7416i("MicroMsg.ProxyAppBrandServiceOnInitListener", "fillPermissionBytes getPermissionBytes null");
                } else {
                    hashMap.put("fg", aKw.elementAt(0));
                    hashMap.put("bg", aKw.elementAt(1));
                }
            }
            hashMap.put("state", Integer.valueOf(runtime.gNN.gWy.awz().ordinal()));
            hashMap.put("wxaData", C42628b.m75493y(runtime));
            C38441a.this.mo68067D(hashMap);
            AppMethodBeat.m2505o(102204);
        }
    }

    public C38441a(C38438a c38438a, C38492q c38492q) {
        super(c38438a, c38492q);
    }

    public final void aIV() {
        AppMethodBeat.m2504i(102205);
        this.iqj = new C271941();
        C27280a.gPN.mo44965a(this.gMN, this.iqj);
        AppMethodBeat.m2505o(102205);
    }

    public final int getType() {
        return 1;
    }

    public final void removeListener() {
        AppMethodBeat.m2504i(102206);
        C27280a.gPN.mo44966b(this.gMN, this.iqj);
        AppMethodBeat.m2505o(102206);
    }
}
