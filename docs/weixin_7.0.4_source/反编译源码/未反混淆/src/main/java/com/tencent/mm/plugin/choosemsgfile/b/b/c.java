package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;

public class c extends a<l> {
    private final long mTimeStamp;

    public c(g gVar, long j) {
        super(gVar);
        this.mTimeStamp = j;
    }

    public final long getTimeStamp() {
        return this.mTimeStamp;
    }

    public final int getType() {
        return 0;
    }

    public void a(l lVar, int i) {
        AppMethodBeat.i(54292);
        if (i == this.kuj.getItemCount() - 1 || b.hb(this.kuj.ts(i + 1).getTimeStamp()) != b.hb(this.mTimeStamp)) {
            lVar.gnf.setVisibility(8);
            AppMethodBeat.o(54292);
            return;
        }
        lVar.gnf.setVisibility(0);
        lVar.gnf.setText(b.ha(this.mTimeStamp));
        if (this.kuj.bfz()) {
            lVar.kuE.setVisibility(0);
            AppMethodBeat.o(54292);
            return;
        }
        lVar.kuE.setVisibility(8);
        AppMethodBeat.o(54292);
    }
}
