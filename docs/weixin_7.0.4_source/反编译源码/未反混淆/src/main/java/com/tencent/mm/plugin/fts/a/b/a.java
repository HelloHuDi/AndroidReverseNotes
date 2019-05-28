package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class a {
    public List<a> bnR;
    public int end;
    public a mEO;
    public boolean mEP;
    public int start;

    public a(int i, int i2, a aVar) {
        this.start = i;
        this.end = i2;
        this.mEO = aVar;
    }

    public final String toString() {
        AppMethodBeat.i(114283);
        String format;
        if (this.mEO == null) {
            format = String.format("[%d,%d]", new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.end)});
            AppMethodBeat.o(114283);
            return format;
        }
        format = String.format("%s [%d,%d]", new Object[]{this.mEO, Integer.valueOf(this.start), Integer.valueOf(this.end)});
        AppMethodBeat.o(114283);
        return format;
    }
}
