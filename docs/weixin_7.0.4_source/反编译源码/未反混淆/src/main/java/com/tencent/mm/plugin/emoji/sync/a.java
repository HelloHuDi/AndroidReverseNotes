package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.sync.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class a<T extends c> {
    public BKGLoaderManager kXj;

    public a() {
        AppMethodBeat.i(53171);
        com.tencent.mm.plugin.emoji.sync.b.a aVar = new com.tencent.mm.plugin.emoji.sync.b.a();
        aVar.kXl = new b(aVar.kXk, aVar.kXk, new com.tencent.mm.at.a.e.a());
        a(new b(aVar));
        AppMethodBeat.o(53171);
    }

    private synchronized void a(b bVar) {
        AppMethodBeat.i(53172);
        if (this.kXj == null) {
            this.kXj = new BKGLoaderManager(bVar);
            AppMethodBeat.o(53172);
        } else {
            ab.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
            AppMethodBeat.o(53172);
        }
    }

    public final void z(ArrayList<c> arrayList) {
        AppMethodBeat.i(53173);
        this.kXj.bu(arrayList);
        AppMethodBeat.o(53173);
    }
}
