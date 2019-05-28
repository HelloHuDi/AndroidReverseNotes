package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.arh;
import com.tencent.p177mm.protocal.protobuf.ari;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.l */
public class C19109l {
    private static volatile C19109l gZk;
    public final Set<C19110b> gZl = new HashSet();
    public volatile ari gZm = null;
    public final Object mLock = new Object();

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.l$1 */
    class C67411 implements C1224a {
        C67411() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(129557);
            if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof ari)) {
                C19109l.m29724a(C19109l.this, (ari) c7472b.fsH.fsP);
            } else {
                C4990ab.m7413e("MicroMsg.AppBrandLauncherListWAGameLogic", "doRequest() cgi return errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C19109l.m29724a(C19109l.this, null);
            }
            AppMethodBeat.m2505o(129557);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.l$c */
    public enum C10128c {
        WXAPP(1),
        H5(2);
        
        private int bTx;

        static {
            AppMethodBeat.m2505o(129565);
        }

        private C10128c(int i) {
            this.bTx = i;
        }

        /* renamed from: nz */
        public static C10128c m17740nz(int i) {
            AppMethodBeat.m2504i(129564);
            for (C10128c c10128c : C10128c.values()) {
                if (i == c10128c.bTx) {
                    AppMethodBeat.m2505o(129564);
                    return c10128c;
                }
            }
            AppMethodBeat.m2505o(129564);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.l$b */
    public interface C19110b {
        void axk();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.l$a */
    public enum C19111a {
        FORCE_OFF(0),
        FORCE_ON(1);
        
        int bTx;

        static {
            AppMethodBeat.m2505o(129561);
        }

        private C19111a(int i) {
            this.bTx = i;
        }

        /* renamed from: ny */
        public static C19111a m29725ny(int i) {
            AppMethodBeat.m2504i(129560);
            for (C19111a c19111a : C19111a.values()) {
                if (c19111a.bTx == i) {
                    AppMethodBeat.m2505o(129560);
                    return c19111a;
                }
            }
            AppMethodBeat.m2505o(129560);
            return null;
        }
    }

    public C19109l() {
        AppMethodBeat.m2504i(129566);
        AppMethodBeat.m2505o(129566);
    }

    public static C19109l axj() {
        AppMethodBeat.m2504i(129567);
        if (gZk == null) {
            synchronized (C19109l.class) {
                try {
                    if (gZk == null) {
                        gZk = new C19109l();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(129567);
                    }
                }
            }
        }
        C19109l c19109l = gZk;
        AppMethodBeat.m2505o(129567);
        return c19109l;
    }

    public final void refresh() {
        AppMethodBeat.m2504i(129568);
        this.gZm = null;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1841;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxagame";
        c1196a.fsJ = new arh();
        c1196a.fsK = new ari();
        C1226w.m2654a(c1196a.acD(), new C67411());
        AppMethodBeat.m2505o(129568);
    }

    public static boolean enabled() {
        AppMethodBeat.m2504i(129569);
        if (C1720g.m3531RK()) {
            C5141c ll = C18624c.abi().mo17131ll("100328");
            if (ll.isValid()) {
                C19111a ny = C19111a.m29725ny(C5046bo.getInt((String) ll.dru().get("isOpenGameEntry"), 0));
                if (ny != null && ny == C19111a.FORCE_ON) {
                    AppMethodBeat.m2505o(129569);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(129569);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m29724a(C19109l c19109l, ari ari) {
        AppMethodBeat.m2504i(129570);
        if (C1720g.m3531RK()) {
            c19109l.gZm = ari;
            LinkedList linkedList = null;
            synchronized (c19109l.mLock) {
                try {
                    if (c19109l.gZl.size() != 0) {
                        linkedList = new LinkedList(c19109l.gZl);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(129570);
                    }
                }
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((C19110b) it.next()).axk();
                }
            }
        }
        AppMethodBeat.m2505o(129570);
    }
}
