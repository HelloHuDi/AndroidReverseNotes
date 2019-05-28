package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

public final class g extends InputStreamReader {
    public g(String str) {
        super(e.openRead(str));
        AppMethodBeat.i(54665);
        AppMethodBeat.o(54665);
    }

    public g(b bVar) {
        super(e.b(bVar.mUri, bVar.dMA()));
        AppMethodBeat.i(54666);
        AppMethodBeat.o(54666);
    }
}
