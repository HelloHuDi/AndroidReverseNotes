package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {
    public static final a bPT = new a() {
        public final void a(c cVar) {
            AppMethodBeat.i(90857);
            cVar.a(b.PASS);
            AppMethodBeat.o(90857);
        }

        public final void a(String str, c cVar) {
            AppMethodBeat.i(90858);
            cVar.a(b.PASS);
            AppMethodBeat.o(90858);
        }
    };
    public static final a bPU = new a() {
        public final void a(c cVar) {
            AppMethodBeat.i(90859);
            cVar.a(b.REJECT);
            AppMethodBeat.o(90859);
        }

        public final void a(String str, c cVar) {
            AppMethodBeat.i(90860);
            cVar.a(b.REJECT);
            AppMethodBeat.o(90860);
        }
    };

    void a(c cVar);

    void a(String str, c cVar);
}
