package com.tencent.p177mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.openim.p716b.C16542c;
import com.tencent.p177mm.openim.p716b.C32880k;
import com.tencent.p177mm.openim.p716b.C37975a;
import com.tencent.p177mm.openim.p716b.C6698d;
import com.tencent.p177mm.openim.p716b.C6699f;
import com.tencent.p177mm.openim.p716b.C9767e;
import com.tencent.p177mm.openim.p716b.C9769m;
import com.tencent.p177mm.openim.p876d.C18738b;
import com.tencent.p177mm.openim.p876d.C18739c;
import com.tencent.p177mm.openim.p876d.C42243d;
import com.tencent.p177mm.openim.p876d.C42244e;
import com.tencent.p177mm.openim.p876d.C45467g;
import com.tencent.p177mm.openim.p876d.C9774j;
import com.tencent.p177mm.openim.room.p266a.C18742b.C9777a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.roomsdk.p1086a.p1340a.C23479a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C30263c;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C30267d;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C40603b;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.openim.room.a */
public final class C24675a implements C23479a {
    /* renamed from: b */
    public final C46610a mo20636b(String str, List<String> list) {
        AppMethodBeat.m2504i(78949);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C16542c(C9777a.m17415an(list));
        AppMethodBeat.m2505o(78949);
        return pa;
    }

    /* renamed from: a */
    public final C46610a mo20633a(String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(78950);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C37975a(str, C9777a.m17415an(list), str2);
        AppMethodBeat.m2505o(78950);
        return pa;
    }

    /* renamed from: a */
    public final C46610a mo20632a(String str, List<String> list, int i) {
        AppMethodBeat.m2504i(78951);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C6698d(str, C9777a.m17415an(list));
        AppMethodBeat.m2505o(78951);
        return pa;
    }

    /* renamed from: c */
    public final C46610a mo20638c(String str, List<String> list) {
        AppMethodBeat.m2504i(78952);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C32880k(str, C9777a.m17415an(list));
        AppMethodBeat.m2505o(78952);
        return pa;
    }

    /* renamed from: a */
    public final C46610a mo20634a(String str, List<String> list, String str2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(78953);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C32880k(str, C9777a.m17415an(list));
        AppMethodBeat.m2505o(78953);
        return pa;
    }

    /* renamed from: kd */
    public final C46610a mo20640kd(String str) {
        AppMethodBeat.m2504i(78954);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C9767e(str);
        AppMethodBeat.m2505o(78954);
        return pa;
    }

    /* renamed from: D */
    public final C46610a mo20626D(String str, int i) {
        AppMethodBeat.m2504i(78955);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C6699f(str, i);
        AppMethodBeat.m2505o(78955);
        return pa;
    }

    /* renamed from: L */
    public final C46610a mo20629L(String str, String str2) {
        AppMethodBeat.m2504i(78956);
        C40603b pa = C46610a.m88143pa(false);
        pa.tRR = new C9769m(str2, str);
        AppMethodBeat.m2505o(78956);
        return pa;
    }

    /* renamed from: ke */
    public final C46610a mo20641ke(String str) {
        AppMethodBeat.m2504i(78957);
        C30263c pb = C46610a.m88144pb(false);
        pb.xvc = new C9774j(str);
        AppMethodBeat.m2505o(78957);
        return pb;
    }

    /* renamed from: E */
    public final C46610a mo20627E(String str, int i) {
        int i2;
        AppMethodBeat.m2504i(78958);
        C30263c pb = C46610a.m88144pb(false);
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        pb.xvc = new C18739c(str, i2);
        AppMethodBeat.m2505o(78958);
        return pb;
    }

    /* renamed from: M */
    public final C46610a mo20630M(String str, String str2) {
        AppMethodBeat.m2504i(78959);
        C30263c pb = C46610a.m88144pb(false);
        pb.xvc = new C45467g(str, str2);
        AppMethodBeat.m2505o(78959);
        return pb;
    }

    /* renamed from: N */
    public final C46610a mo20631N(String str, String str2) {
        AppMethodBeat.m2504i(78960);
        C30263c pb = C46610a.m88144pb(false);
        pb.xvc = new C18738b(str, str2);
        AppMethodBeat.m2505o(78960);
        return pb;
    }

    /* renamed from: j */
    public final C46610a mo20639j(String str, String str2, String str3) {
        AppMethodBeat.m2504i(78961);
        C30263c pb = C46610a.m88144pb(false);
        pb.xvc = new C42243d(str, str3);
        AppMethodBeat.m2505o(78961);
        return pb;
    }

    /* renamed from: c */
    public final C46610a mo20637c(String str, String str2, boolean z) {
        int i;
        AppMethodBeat.m2504i(78962);
        C30263c pb = C46610a.m88144pb(false);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        pb.xvc = new C42244e(str, i);
        AppMethodBeat.m2505o(78962);
        return pb;
    }

    /* renamed from: a */
    public final void mo20635a(C7616ad c7616ad, boolean z) {
        AppMethodBeat.m2504i(78963);
        if (z) {
            c7616ad.mo16676NB();
            if (C1855t.m3889e(c7616ad)) {
                c7616ad.mo14696hu(43);
                c7616ad.mo14704iC(C9790g.m17433vp(c7616ad.mo16706Oi()));
                c7616ad.mo14705iD(C9790g.m17432vo(c7616ad.mo16706Oi()));
                c7616ad.mo14707iF(C9790g.m17432vo(c7616ad.mo16707Oj()));
                c7616ad.mo14708iG(c7616ad.mo16707Oj());
            }
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(c7616ad.field_username, c7616ad);
            ((C37974a) C1720g.m3528K(C37974a.class)).mo60750vf(c7616ad.field_username);
            AppMethodBeat.m2505o(78963);
            return;
        }
        ((C37974a) C1720g.m3528K(C37974a.class)).mo60751vg(c7616ad.field_username);
        AppMethodBeat.m2505o(78963);
    }

    /* renamed from: Ju */
    public final C30267d mo20628Ju() {
        AppMethodBeat.m2504i(78948);
        C30267d c30267d = new C30267d();
        AppMethodBeat.m2505o(78948);
        return c30267d;
    }
}
