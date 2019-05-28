package com.tencent.p177mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p711c.C37854g;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.storage.g */
public final class C36003g extends C7563j<C37854g> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C37854g.m63864Hm(), "AddContactAntispamTicket")};
    private C7480h fni;
    SparseArray<String> xHR = new SparseArray();

    /* renamed from: com.tencent.mm.storage.g$a */
    public static class C15441a extends C37854g {
        /* renamed from: Ag */
        public final C4924a mo4635Ag() {
            AppMethodBeat.m2504i(80274);
            C4924a Hm = C37854g.m63864Hm();
            AppMethodBeat.m2505o(80274);
            return Hm;
        }
    }

    static {
        AppMethodBeat.m2504i(80280);
        AppMethodBeat.m2505o(80280);
    }

    public C36003g(C4927e c4927e) {
        super(c4927e, C37854g.m63864Hm(), "AddContactAntispamTicket", null);
        AppMethodBeat.m2504i(80275);
        this.fni = (C7480h) c4927e;
        AppMethodBeat.m2505o(80275);
    }

    /* renamed from: x */
    public final void mo56748x(String str, int i, String str2) {
        AppMethodBeat.m2504i(80276);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80276);
            return;
        }
        C15441a c15441a = new C15441a();
        c15441a.field_userName = str;
        c15441a.field_scene = i;
        c15441a.field_ticket = str2;
        mo10099a(c15441a);
        mo56747ia(str, str2);
        AppMethodBeat.m2505o(80276);
    }

    /* renamed from: en */
    public final void mo56746en(List<C37854g> list) {
        AppMethodBeat.m2504i(80277);
        if (list.size() == 0) {
            AppMethodBeat.m2505o(80277);
            return;
        }
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        for (C37854g a : list) {
            mo10099a(a);
        }
        this.fni.mo15640mB(iV);
        AppMethodBeat.m2505o(80277);
    }

    /* renamed from: ia */
    public final void mo56747ia(String str, String str2) {
        AppMethodBeat.m2504i(80278);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80278);
            return;
        }
        this.xHR.put(str.hashCode(), str2);
        AppMethodBeat.m2505o(80278);
    }

    public final String aoh(String str) {
        AppMethodBeat.m2504i(80279);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80279);
            return null;
        }
        String str2 = (String) this.xHR.get(str.hashCode());
        if (C5046bo.isNullOrNil(str2)) {
            C15441a c15441a = new C15441a();
            c15441a.field_userName = str;
            if (mo10102b((C4925c) c15441a, "userName")) {
                mo56747ia(c15441a.field_userName, c15441a.field_ticket);
                str2 = c15441a.field_ticket;
                AppMethodBeat.m2505o(80279);
                return str2;
            }
            AppMethodBeat.m2505o(80279);
            return null;
        }
        AppMethodBeat.m2505o(80279);
        return str2;
    }
}
