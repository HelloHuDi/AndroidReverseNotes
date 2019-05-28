package com.tencent.p177mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.model.b */
public final class C34547b {
    long geE = 0;
    long kCh = C5046bo.m7588yz();
    long otF = C5046bo.m7588yz();
    private String tag = "default";
    long value = 0;

    public C34547b(String str) {
        AppMethodBeat.m2504i(76460);
        this.tag = str;
        AppMethodBeat.m2505o(76460);
    }

    /* renamed from: jl */
    public final void mo55078jl(long j) {
        AppMethodBeat.m2504i(76461);
        if (this.geE == 0) {
            this.kCh = C5046bo.m7588yz();
        }
        this.value += j;
        this.geE++;
        this.otF = C5046bo.m7588yz();
        AppMethodBeat.m2505o(76461);
    }

    public final String getValue() {
        AppMethodBeat.m2504i(76462);
        String str = "";
        String str2;
        if (this.geE == 0) {
            str2 = "";
            AppMethodBeat.m2505o(76462);
            return str2;
        }
        double d = ((double) (this.otF - this.kCh)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        str2 = String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[]{str, this.tag, Long.valueOf(this.geE), Double.valueOf(d), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.geE)), Double.valueOf((((double) this.geE) * 1.0d) / d), Double.valueOf((1.0d * ((double) this.value)) / d), Long.valueOf(this.kCh), Long.valueOf(this.otF), Long.valueOf(this.otF - this.kCh)});
        AppMethodBeat.m2505o(76462);
        return str2;
    }

    public final String bPk() {
        AppMethodBeat.m2504i(76463);
        String str;
        if (this.geE == 0) {
            str = "";
            AppMethodBeat.m2505o(76463);
            return str;
        }
        double d = ((double) (this.otF - this.kCh)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        str = ((1.0d * ((double) this.geE)) / d);
        AppMethodBeat.m2505o(76463);
        return str;
    }

    public final void reset() {
        this.value = 0;
        this.geE = 0;
    }
}
