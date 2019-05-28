package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;

/* renamed from: com.tencent.mm.plugin.record.ui.e */
public final class C34803e extends C3706h implements C43427d {
    int fromScene = 0;

    public C34803e(Context context, C3709a c3709a) {
        super(context, c3709a);
    }

    /* renamed from: a */
    public final void mo8328a(C28837a c28837a) {
        AppMethodBeat.m2504i(24222);
        this.pKs = c28837a;
        this.pJZ.clear();
        this.pJZ.addAll(c28837a.pJZ);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(24222);
    }

    /* renamed from: d */
    public final void mo8331d(C43438b c43438b) {
        c43438b.dataType = 0;
        c43438b.fromScene = this.fromScene;
        c43438b.cvx = ((C39580f) this.pKs).cvx;
        c43438b.cKa = ((C39580f) this.pKs).cKa;
    }

    /* renamed from: a */
    public final void mo25051a(int i, C34792i c34792i) {
        AppMethodBeat.m2504i(24223);
        ceP();
        AppMethodBeat.m2505o(24223);
    }
}
