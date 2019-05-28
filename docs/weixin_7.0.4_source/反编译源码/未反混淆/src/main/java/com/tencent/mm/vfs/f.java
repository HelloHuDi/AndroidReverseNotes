package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class f extends FilterOutputStream {
    public f(b bVar) {
        super(e.a(bVar.mUri, bVar.dMA(), false));
        AppMethodBeat.i(54664);
        AppMethodBeat.o(54664);
    }
}
