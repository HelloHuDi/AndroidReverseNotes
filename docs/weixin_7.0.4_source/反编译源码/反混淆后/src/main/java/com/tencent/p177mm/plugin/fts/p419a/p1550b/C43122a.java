package com.tencent.p177mm.plugin.fts.p419a.p1550b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.b.a */
final class C43122a {
    public List<C43122a> bnR;
    public int end;
    public C43122a mEO;
    public boolean mEP;
    public int start;

    public C43122a(int i, int i2, C43122a c43122a) {
        this.start = i;
        this.end = i2;
        this.mEO = c43122a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(114283);
        String format;
        if (this.mEO == null) {
            format = String.format("[%d,%d]", new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.end)});
            AppMethodBeat.m2505o(114283);
            return format;
        }
        format = String.format("%s [%d,%d]", new Object[]{this.mEO, Integer.valueOf(this.start), Integer.valueOf(this.end)});
        AppMethodBeat.m2505o(114283);
        return format;
    }
}
