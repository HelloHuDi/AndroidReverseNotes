package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class d extends FilterInputStream {
    public d(String str) {
        super(e.openRead(str));
        AppMethodBeat.i(54623);
        AppMethodBeat.o(54623);
    }

    public d(b bVar) {
        super(e.b(bVar.mUri, bVar.dMA()));
        AppMethodBeat.i(54624);
        AppMethodBeat.o(54624);
    }
}
