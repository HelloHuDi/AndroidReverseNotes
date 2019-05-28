package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class o {
    public static b rQN;
    public long key;

    public static class a {
        private static a rQO;
        private Map<Long, o> rQP = new HashMap();

        public a() {
            AppMethodBeat.i(56493);
            AppMethodBeat.o(56493);
        }

        public static a cxg() {
            AppMethodBeat.i(56494);
            if (rQO == null) {
                rQO = new a();
            }
            a aVar = rQO;
            AppMethodBeat.o(56494);
            return aVar;
        }

        public final void a(long j, o oVar) {
            AppMethodBeat.i(56495);
            this.rQP.put(Long.valueOf(j), oVar);
            AppMethodBeat.o(56495);
        }

        public final o kW(long j) {
            AppMethodBeat.i(56496);
            o oVar = (o) this.rQP.remove(Long.valueOf(j));
            AppMethodBeat.o(56496);
            return oVar;
        }
    }

    public interface b {
        long c(List<String> list, Map<String, ArrayList<Long>> map);

        long i(List<String> list, String str);
    }

    public o(long j) {
        this.key = j;
    }
}
