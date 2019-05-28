package com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g.C11384b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g.C33816a;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.C42890a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.a */
public abstract class C38788a extends C41523a implements C33817g {
    static C11384b kuW;
    protected List<C11376a> iJL;
    private C42890a kuT;
    private boolean kuU = C1720g.m3536RP().isSDCardAvailable();
    C33816a kuV;

    public final C42890a bfy() {
        return this.kuT;
    }

    public C38788a(C42890a c42890a, List<C11376a> list) {
        this.kuT = c42890a;
        this.iJL = list;
    }

    public final int getItemViewType(int i) {
        return mo54375ts(i).getType();
    }

    /* renamed from: a */
    public final void mo27742a(C41531v c41531v, int i, List list) {
        mo54375ts(i);
        super.mo27742a(c41531v, i, list);
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        if (this.kuU) {
            mo54375ts(i).mo6912a(c41531v, i);
            return;
        }
        C4990ab.m7413e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", Boolean.valueOf(this.kuU));
    }

    public final int getItemCount() {
        return this.iJL.size();
    }

    /* renamed from: ts */
    public final C11376a mo54375ts(int i) {
        if (this.iJL == null || this.iJL.size() <= i) {
            return null;
        }
        return (C11376a) this.iJL.get(i);
    }

    /* renamed from: a */
    public final void mo54371a(boolean z, C11376a c11376a, C41531v c41531v) {
        if (this.kuV != null) {
            this.kuV.mo23128a(z, c11376a, c41531v);
        }
    }

    public boolean bfz() {
        return false;
    }
}
