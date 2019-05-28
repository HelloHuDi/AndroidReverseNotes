package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public interface p {

    public static class a {
        public static b vav;

        public static b dgQ() {
            AppMethodBeat.i(27227);
            if (vav == null) {
                ab.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
                vav = new com.tencent.mm.pluginsdk.a.c();
            }
            b bVar = vav;
            AppMethodBeat.o(27227);
            return bVar;
        }
    }

    public static class d {
        public static g dgR() {
            return n.qFD;
        }
    }

    public interface b {
        int cjL();

        void cjM();

        boolean cjN();

        void cjO();

        void cjP();

        boolean cjQ();
    }

    public interface c {

        public interface a {
            String cUp();

            void cUq();

            boolean cUr();
        }
    }

    public static class e {
        public static a vaw;
    }
}
