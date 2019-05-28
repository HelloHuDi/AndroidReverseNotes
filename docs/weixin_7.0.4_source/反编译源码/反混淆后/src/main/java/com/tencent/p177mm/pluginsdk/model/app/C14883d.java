package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.pluginsdk.model.app.d */
public final class C14883d implements C1202f {
    public Map<Integer, Set<C14887t>> ftE = new HashMap();

    public C14883d() {
        AppMethodBeat.m2504i(79237);
        C1720g.m3535RO().eJo.mo14539a(452, (C1202f) this);
        AppMethodBeat.m2505o(79237);
    }

    /* renamed from: a */
    public final void mo27202a(int i, C14887t c14887t) {
        AppMethodBeat.m2504i(79238);
        if (!this.ftE.containsKey(Integer.valueOf(i))) {
            this.ftE.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.ftE.get(Integer.valueOf(i))).contains(c14887t)) {
            ((Set) this.ftE.get(Integer.valueOf(i))).add(c14887t);
        }
        AppMethodBeat.m2505o(79238);
    }

    /* renamed from: b */
    public final void mo27203b(int i, C14887t c14887t) {
        AppMethodBeat.m2504i(79239);
        if (this.ftE.get(Integer.valueOf(i)) != null) {
            ((Set) this.ftE.get(Integer.valueOf(i))).remove(c14887t);
        }
        AppMethodBeat.m2505o(79239);
    }

    /* renamed from: a */
    public static void m23149a(int i, C40442x c40442x) {
        AppMethodBeat.m2504i(79240);
        C1720g.m3535RO().eJo.mo14541a(new C44061y(i, c40442x), 0);
        AppMethodBeat.m2505o(79240);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(79241);
        if (c1207m instanceof C44061y) {
            C44061y c44061y = (C44061y) c1207m;
            Set set = (Set) this.ftE.get(Integer.valueOf(c44061y.vco));
            if (set != null && set.size() > 0) {
                HashSet<C14887t> hashSet = new HashSet();
                hashSet.addAll(set);
                for (C14887t c14887t : hashSet) {
                    if (c14887t != null && set.contains(c14887t)) {
                        c14887t.mo9876a(i, i2, str, c44061y.vcp);
                    }
                }
            }
            AppMethodBeat.m2505o(79241);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
        AppMethodBeat.m2505o(79241);
    }
}
