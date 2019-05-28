package com.bumptech.glide.c.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class d implements com.bumptech.glide.c.b.b.a.a {
    private final long aDc = 262144000;
    private final a aDd;

    public interface a {
        File mW();
    }

    public d(a aVar) {
        this.aDd = aVar;
    }

    public final a mU() {
        AppMethodBeat.i(91980);
        File mW = this.aDd.mW();
        if (mW == null) {
            AppMethodBeat.o(91980);
            return null;
        } else if (mW.mkdirs() || (mW.exists() && mW.isDirectory())) {
            a eVar = new e(mW, this.aDc);
            AppMethodBeat.o(91980);
            return eVar;
        } else {
            AppMethodBeat.o(91980);
            return null;
        }
    }
}
