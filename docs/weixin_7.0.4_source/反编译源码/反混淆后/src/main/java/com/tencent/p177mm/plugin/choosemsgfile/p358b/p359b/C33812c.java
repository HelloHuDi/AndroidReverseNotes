package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.c */
public class C33812c extends C11376a<C46904l> {
    private final long mTimeStamp;

    public C33812c(C33817g c33817g, long j) {
        super(c33817g);
        this.mTimeStamp = j;
    }

    public final long getTimeStamp() {
        return this.mTimeStamp;
    }

    public final int getType() {
        return 0;
    }

    /* renamed from: a */
    public void mo6917a(C46904l c46904l, int i) {
        AppMethodBeat.m2504i(54292);
        if (i == this.kuj.getItemCount() - 1 || C42887b.m76166hb(this.kuj.mo54375ts(i + 1).getTimeStamp()) != C42887b.m76166hb(this.mTimeStamp)) {
            c46904l.gnf.setVisibility(8);
            AppMethodBeat.m2505o(54292);
            return;
        }
        c46904l.gnf.setVisibility(0);
        c46904l.gnf.setText(C42887b.m76165ha(this.mTimeStamp));
        if (this.kuj.bfz()) {
            c46904l.kuE.setVisibility(0);
            AppMethodBeat.m2505o(54292);
            return;
        }
        c46904l.kuE.setVisibility(8);
        AppMethodBeat.m2505o(54292);
    }
}
