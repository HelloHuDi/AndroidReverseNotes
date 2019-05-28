package com.tencent.p177mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.welab.p1072a.C17001c;
import com.tencent.p177mm.plugin.welab.p1072a.C35733b;
import com.tencent.p177mm.plugin.welab.p1072a.C40359a;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14714c;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14715d;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.plugin.welab.p1331d.C40360a;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p753b.C35734b;
import com.tencent.p177mm.plugin.welab.p753b.C7232a;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.welab.PluginWelab */
public class PluginWelab extends C7597f implements C18523a, C9562c, C26346d, C40359a {
    private C23168b uLM = new C23168b();
    private boolean uLN;

    /* renamed from: com.tencent.mm.plugin.welab.PluginWelab$1 */
    class C46641 implements C19933a {
        C46641() {
        }

        /* renamed from: a */
        public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
            AppMethodBeat.m2504i(80516);
            C29974a.ddj();
            C29974a.m47420Z(PluginWelab.this.uLN, !z);
            AppMethodBeat.m2505o(80516);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.PluginWelab$2 */
    class C357322 implements C1366d {
        C357322() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(80517);
            String[] strArr = new String[]{C7563j.m13217a(C23169a.ccO, "LabAppInfo")};
            AppMethodBeat.m2505o(80517);
            return strArr;
        }
    }

    public PluginWelab() {
        AppMethodBeat.m2504i(80518);
        AppMethodBeat.m2505o(80518);
    }

    public void installed() {
        AppMethodBeat.m2504i(80519);
        alias(C40359a.class);
        AppMethodBeat.m2505o(80519);
    }

    public void dependency() {
        AppMethodBeat.m2504i(80520);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(80520);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(80521);
        if (c1681g.mo5181SG()) {
            C4990ab.m7418v("PluginWelab", "configure");
            C1720g.m3543a(C14715d.class, new C6625e(new C29975c()));
            C1720g.m3543a(C7232a.class, new C6625e(new C35734b()));
            ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(new C46641());
            AppMethodBeat.m2505o(80521);
            return;
        }
        AppMethodBeat.m2505o(80521);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(80522);
        C4990ab.m7418v("PluginWelab", "execute");
        AppMethodBeat.m2505o(80522);
    }

    public String toString() {
        return "plugin-welab";
    }

    public void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(80523);
        C4990ab.m7418v("PluginWelab", "onDataBaseOpened");
        C29974a.ddj().uLQ = new C40360a(c7480h);
        AppMethodBeat.m2505o(80523);
    }

    public void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(80524);
        C4990ab.m7418v("PluginWelab", "onAccountInitialized");
        C4996ah.getContext();
        C1720g.m3542a(C23167a.class, new C35733b());
        C1720g.m3542a(C14714c.class, new C17001c());
        this.uLN = c1705c.eKe;
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("newabtestlabs", this.uLM, true);
        AppMethodBeat.m2505o(80524);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(80525);
        C4990ab.m7418v("PluginWelab", "onAccountRelease");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("newabtestlabs", this.uLM, true);
        AppMethodBeat.m2505o(80525);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(80526);
        C4990ab.m7418v("PluginWelab", "collectDatabaseFactory");
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new C357322());
        AppMethodBeat.m2505o(80526);
        return hashMap;
    }
}
