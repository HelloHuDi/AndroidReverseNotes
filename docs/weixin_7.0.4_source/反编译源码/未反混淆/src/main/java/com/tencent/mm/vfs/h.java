package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class h extends OutputStreamWriter {
    public h(String str) {
        super(e.L(str, false));
        AppMethodBeat.i(54667);
        AppMethodBeat.o(54667);
    }

    public h(b bVar) {
        super(e.a(bVar.mUri, bVar.dMA(), false));
        AppMethodBeat.i(54668);
        AppMethodBeat.o(54668);
    }
}
