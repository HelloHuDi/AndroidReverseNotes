package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    long geE = 0;
    long kCh = bo.yz();
    long otF = bo.yz();
    private String tag = "default";
    long value = 0;

    public b(String str) {
        AppMethodBeat.i(76460);
        this.tag = str;
        AppMethodBeat.o(76460);
    }

    public final void jl(long j) {
        AppMethodBeat.i(76461);
        if (this.geE == 0) {
            this.kCh = bo.yz();
        }
        this.value += j;
        this.geE++;
        this.otF = bo.yz();
        AppMethodBeat.o(76461);
    }

    public final String getValue() {
        AppMethodBeat.i(76462);
        String str = "";
        String str2;
        if (this.geE == 0) {
            str2 = "";
            AppMethodBeat.o(76462);
            return str2;
        }
        double d = ((double) (this.otF - this.kCh)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        str2 = String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[]{str, this.tag, Long.valueOf(this.geE), Double.valueOf(d), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.geE)), Double.valueOf((((double) this.geE) * 1.0d) / d), Double.valueOf((1.0d * ((double) this.value)) / d), Long.valueOf(this.kCh), Long.valueOf(this.otF), Long.valueOf(this.otF - this.kCh)});
        AppMethodBeat.o(76462);
        return str2;
    }

    public final String bPk() {
        AppMethodBeat.i(76463);
        String str;
        if (this.geE == 0) {
            str = "";
            AppMethodBeat.o(76463);
            return str;
        }
        double d = ((double) (this.otF - this.kCh)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        str = ((1.0d * ((double) this.geE)) / d);
        AppMethodBeat.o(76463);
        return str;
    }

    public final void reset() {
        this.value = 0;
        this.geE = 0;
    }
}
