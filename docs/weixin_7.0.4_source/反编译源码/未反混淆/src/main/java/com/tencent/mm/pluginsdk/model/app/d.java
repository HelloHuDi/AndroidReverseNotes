package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d implements f {
    public Map<Integer, Set<t>> ftE = new HashMap();

    public d() {
        AppMethodBeat.i(79237);
        g.RO().eJo.a(452, (f) this);
        AppMethodBeat.o(79237);
    }

    public final void a(int i, t tVar) {
        AppMethodBeat.i(79238);
        if (!this.ftE.containsKey(Integer.valueOf(i))) {
            this.ftE.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.ftE.get(Integer.valueOf(i))).contains(tVar)) {
            ((Set) this.ftE.get(Integer.valueOf(i))).add(tVar);
        }
        AppMethodBeat.o(79238);
    }

    public final void b(int i, t tVar) {
        AppMethodBeat.i(79239);
        if (this.ftE.get(Integer.valueOf(i)) != null) {
            ((Set) this.ftE.get(Integer.valueOf(i))).remove(tVar);
        }
        AppMethodBeat.o(79239);
    }

    public static void a(int i, x xVar) {
        AppMethodBeat.i(79240);
        g.RO().eJo.a(new y(i, xVar), 0);
        AppMethodBeat.o(79240);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(79241);
        if (mVar instanceof y) {
            y yVar = (y) mVar;
            Set set = (Set) this.ftE.get(Integer.valueOf(yVar.vco));
            if (set != null && set.size() > 0) {
                HashSet<t> hashSet = new HashSet();
                hashSet.addAll(set);
                for (t tVar : hashSet) {
                    if (tVar != null && set.contains(tVar)) {
                        tVar.a(i, i2, str, yVar.vcp);
                    }
                }
            }
            AppMethodBeat.o(79241);
            return;
        }
        ab.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
        AppMethodBeat.o(79241);
    }
}
