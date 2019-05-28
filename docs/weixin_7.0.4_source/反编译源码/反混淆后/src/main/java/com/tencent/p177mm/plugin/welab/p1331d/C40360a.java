package com.tencent.p177mm.plugin.welab.p1331d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.welab.d.a */
public final class C40360a extends C7563j<C23169a> {
    private C4927e bSd;

    /* renamed from: a */
    public final /* synthetic */ boolean mo10099a(C4925c c4925c) {
        AppMethodBeat.m2504i(80583);
        boolean d = m69195d((C23169a) c4925c);
        AppMethodBeat.m2505o(80583);
        return d;
    }

    public C40360a(C4927e c4927e) {
        super(c4927e, C23169a.ccO, "LabAppInfo", null);
        this.bSd = c4927e;
    }

    public final List<C23169a> dds() {
        AppMethodBeat.m2504i(80579);
        Cursor baR = baR();
        ArrayList arrayList = new ArrayList();
        while (baR.moveToNext()) {
            C23169a c23169a = new C23169a();
            c23169a.mo8995d(baR);
            arrayList.add(c23169a);
        }
        baR.close();
        AppMethodBeat.m2505o(80579);
        return arrayList;
    }

    /* renamed from: ee */
    public final void mo63727ee(List<C23169a> list) {
        long iV;
        AppMethodBeat.m2504i(80580);
        C7480h c7480h = null;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            iV = c7480h2.mo15639iV(-1);
            c7480h = c7480h2;
        } else {
            iV = 0;
        }
        for (C23169a c : list) {
            mo63725c(c);
        }
        if (c7480h != null) {
            c7480h.mo15640mB(iV);
        }
        AppMethodBeat.m2505o(80580);
    }

    /* renamed from: c */
    public final void mo63725c(C23169a c23169a) {
        AppMethodBeat.m2504i(80581);
        if (!m69195d(c23169a)) {
            mo10101b((C4925c) c23169a);
        }
        AppMethodBeat.m2505o(80581);
    }

    /* renamed from: d */
    private boolean m69195d(C23169a c23169a) {
        AppMethodBeat.m2504i(80582);
        C23169a c23169a2 = new C23169a();
        c23169a2.field_LabsAppId = c23169a.field_LabsAppId;
        mo10102b((C4925c) c23169a2, new String[0]);
        if (c23169a.field_expId != c23169a2.field_expId || c23169a.field_sequence >= c23169a2.field_sequence) {
            boolean a = super.mo10099a(c23169a);
            AppMethodBeat.m2505o(80582);
            return a;
        }
        C4990ab.m7416i("LabAppInfoStorage", "sequence old origin.seq " + c23169a2.field_sequence + " old.seq " + c23169a.field_sequence);
        AppMethodBeat.m2505o(80582);
        return false;
    }
}
