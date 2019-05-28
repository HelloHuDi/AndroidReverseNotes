package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {

    public enum d {
        OK,
        FAIL,
        CANCEL;

        static {
            AppMethodBeat.o(87007);
        }
    }

    public interface a {
        void b(d dVar);
    }

    public interface b {
        void a(d dVar);
    }

    public static class c implements a {
        public final boolean aIy() {
            return false;
        }

        public final String CC(String str) {
            return "__APP__";
        }

        public void a(String str, boolean z, b bVar, a aVar) {
            AppMethodBeat.i(87003);
            if (bVar != null) {
                bVar.a(d.OK);
            }
            AppMethodBeat.o(87003);
        }

        public final void a(String str, boolean z, b bVar) {
            AppMethodBeat.i(87004);
            a(str, z, bVar, null);
            AppMethodBeat.o(87004);
        }
    }

    String CC(String str);

    void a(String str, boolean z, b bVar);

    void a(String str, boolean z, b bVar, a aVar);

    boolean aIy();
}
