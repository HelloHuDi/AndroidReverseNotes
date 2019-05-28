package com.tencent.p177mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.story.api.o */
public abstract class C39864o {
    public static C35173b rQN;
    public long key;

    /* renamed from: com.tencent.mm.plugin.story.api.o$a */
    public static class C35172a {
        private static C35172a rQO;
        private Map<Long, C39864o> rQP = new HashMap();

        public C35172a() {
            AppMethodBeat.m2504i(56493);
            AppMethodBeat.m2505o(56493);
        }

        public static C35172a cxg() {
            AppMethodBeat.m2504i(56494);
            if (rQO == null) {
                rQO = new C35172a();
            }
            C35172a c35172a = rQO;
            AppMethodBeat.m2505o(56494);
            return c35172a;
        }

        /* renamed from: a */
        public final void mo55834a(long j, C39864o c39864o) {
            AppMethodBeat.m2504i(56495);
            this.rQP.put(Long.valueOf(j), c39864o);
            AppMethodBeat.m2505o(56495);
        }

        /* renamed from: kW */
        public final C39864o mo55835kW(long j) {
            AppMethodBeat.m2504i(56496);
            C39864o c39864o = (C39864o) this.rQP.remove(Long.valueOf(j));
            AppMethodBeat.m2505o(56496);
            return c39864o;
        }
    }

    /* renamed from: com.tencent.mm.plugin.story.api.o$b */
    public interface C35173b {
        /* renamed from: c */
        long mo55836c(List<String> list, Map<String, ArrayList<Long>> map);

        /* renamed from: i */
        long mo55837i(List<String> list, String str);
    }

    public C39864o(long j) {
        this.key = j;
    }
}
