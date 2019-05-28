package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.r */
public final class C27279r {
    private Map<Integer, List<C27281b>> gPL;
    private Map<Integer, Integer> gPM;

    /* renamed from: com.tencent.mm.plugin.appbrand.r$a */
    public static class C27280a {
        public static C27279r gPN = new C27279r();

        static {
            AppMethodBeat.m2504i(86773);
            AppMethodBeat.m2505o(86773);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.r$b */
    public interface C27281b {
        void auh();
    }

    /* synthetic */ C27279r(byte b) {
        this();
    }

    private C27279r() {
        AppMethodBeat.m2504i(86774);
        this.gPL = new HashMap();
        this.gPM = new HashMap();
        AppMethodBeat.m2505o(86774);
    }

    /* renamed from: d */
    private void m43310d(int i, List<C27281b> list) {
        int i2 = 0;
        AppMethodBeat.m2504i(86778);
        if (this.gPM.isEmpty()) {
            AppMethodBeat.m2505o(86778);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify pending : %d", Integer.valueOf(i));
        if (this.gPM.containsKey(Integer.valueOf(i))) {
            this.gPM.remove(Integer.valueOf(i));
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    ((C27281b) list.get(i3)).auh();
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.m2505o(86778);
                    return;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "not in pending notify");
        AppMethodBeat.m2505o(86778);
    }

    /* renamed from: a */
    public final synchronized void mo44965a(C38492q c38492q, C27281b c27281b) {
        AppMethodBeat.m2504i(86775);
        int hashCode = c38492q.hashCode();
        C4990ab.m7417i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "addListener service:%d", Integer.valueOf(hashCode));
        List list = (List) this.gPL.get(Integer.valueOf(hashCode));
        if (list == null) {
            list = new ArrayList();
            this.gPL.put(Integer.valueOf(hashCode), list);
        }
        list.add(c27281b);
        m43310d(hashCode, list);
        AppMethodBeat.m2505o(86775);
    }

    /* renamed from: b */
    public final synchronized void mo44966b(C38492q c38492q, C27281b c27281b) {
        AppMethodBeat.m2504i(86776);
        int hashCode = c38492q.hashCode();
        C4990ab.m7417i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "removeListener service:%d", Integer.valueOf(hashCode));
        List list = (List) this.gPL.get(Integer.valueOf(hashCode));
        if (list == null) {
            AppMethodBeat.m2505o(86776);
        } else {
            list.remove(c27281b);
            if (list.isEmpty()) {
                this.gPL.remove(Integer.valueOf(hashCode));
            }
            AppMethodBeat.m2505o(86776);
        }
    }

    /* renamed from: a */
    public final synchronized void mo44964a(C38492q c38492q) {
        AppMethodBeat.m2504i(86777);
        int hashCode = c38492q.hashCode();
        C4990ab.m7417i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify service:%d", Integer.valueOf(hashCode));
        List list = (List) this.gPL.get(Integer.valueOf(hashCode));
        if (list == null) {
            C4990ab.m7416i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify listenerList empty");
            this.gPM.put(Integer.valueOf(hashCode), Integer.valueOf(1));
            AppMethodBeat.m2505o(86777);
        } else {
            for (hashCode = 0; hashCode < list.size(); hashCode++) {
                ((C27281b) list.get(hashCode)).auh();
            }
            AppMethodBeat.m2505o(86777);
        }
    }
}
