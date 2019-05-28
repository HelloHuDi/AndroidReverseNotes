package com.tencent.p177mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.p1596e.C41925b;
import com.tencent.p177mm.chatroom.p1596e.C45284c;
import com.tencent.p177mm.chatroom.p710c.C32437e;
import com.tencent.p177mm.chatroom.p710c.C32438g;
import com.tencent.p177mm.chatroom.p710c.C32439m;
import com.tencent.p177mm.chatroom.p710c.C32440n;
import com.tencent.p177mm.chatroom.p710c.C32441o;
import com.tencent.p177mm.chatroom.p710c.C6399h;
import com.tencent.p177mm.chatroom.p710c.C6400i;
import com.tencent.p177mm.chatroom.p710c.C6402k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p201az.C37498c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.bbr;
import com.tencent.p177mm.protocal.protobuf.bbs;
import com.tencent.p177mm.protocal.protobuf.bbu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.roomsdk.p1086a.p1340a.C23479a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C30263c;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C30267d;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C40603b;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.a */
public final class C9214a implements C23479a {
    public String TAG = "MicroMsg.DefaultChatRoom";

    /* renamed from: b */
    public final C46610a mo20636b(String str, List<String> list) {
        AppMethodBeat.m2504i(103859);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C32438g(str, list);
        AppMethodBeat.m2505o(103859);
        return pa;
    }

    /* renamed from: a */
    public final C46610a mo20633a(String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(103860);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C32437e(str, list, str2);
        AppMethodBeat.m2505o(103860);
        return pa;
    }

    /* renamed from: a */
    public final C46610a mo20632a(String str, List<String> list, int i) {
        AppMethodBeat.m2504i(103861);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C6399h(str, list, i);
        AppMethodBeat.m2505o(103861);
        return pa;
    }

    /* renamed from: c */
    public final C46610a mo20638c(String str, List<String> list) {
        AppMethodBeat.m2504i(103862);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C32439m(str, list);
        AppMethodBeat.m2505o(103862);
        return pa;
    }

    /* renamed from: a */
    public final C46610a mo20634a(String str, List<String> list, String str2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(103863);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C32439m(str, list, str2, c7620bi);
        AppMethodBeat.m2505o(103863);
        return pa;
    }

    /* renamed from: kd */
    public final C46610a mo20640kd(String str) {
        AppMethodBeat.m2504i(103864);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C6400i(str);
        AppMethodBeat.m2505o(103864);
        return pa;
    }

    /* renamed from: D */
    public final C46610a mo20626D(String str, int i) {
        AppMethodBeat.m2504i(103865);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C6402k(str, i);
        AppMethodBeat.m2505o(103865);
        return pa;
    }

    /* renamed from: L */
    public final C46610a mo20629L(String str, String str2) {
        AppMethodBeat.m2504i(103866);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C32440n(str, str2);
        AppMethodBeat.m2505o(103866);
        return pa;
    }

    /* renamed from: ke */
    public final C46610a mo20641ke(String str) {
        AppMethodBeat.m2504i(103867);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C37498c(str));
        C30263c pb = C46610a.m88144pb(true);
        pb.xvc = new C45284c((String) C1720g.m3536RP().mo5239Ry().get(2, null), str);
        AppMethodBeat.m2505o(103867);
        return pb;
    }

    /* renamed from: E */
    public final C46610a mo20627E(String str, int i) {
        AppMethodBeat.m2504i(103868);
        C30263c pb = C46610a.m88144pb(true);
        pb.xvc = new C41925b(str, i);
        AppMethodBeat.m2505o(103868);
        return pb;
    }

    /* renamed from: M */
    public final C46610a mo20630M(String str, String str2) {
        AppMethodBeat.m2504i(103869);
        C30263c pb = C46610a.m88144pb(true);
        bbu bbu = new bbu();
        bbu.vEi = new bts().alV(C5046bo.nullAsNil(str));
        bbu.wGe = new bts().alV(C5046bo.nullAsNil(str2));
        pb.xvc = new C3465a(27, bbu);
        AppMethodBeat.m2505o(103869);
        return pb;
    }

    /* renamed from: N */
    public final C46610a mo20631N(String str, String str2) {
        AppMethodBeat.m2504i(103870);
        C40603b pa = C46610a.m88143pa(true);
        pa.tRR = new C32441o(str, str2);
        AppMethodBeat.m2505o(103870);
        return pa;
    }

    /* renamed from: j */
    public final C46610a mo20639j(String str, String str2, String str3) {
        AppMethodBeat.m2504i(103871);
        C30263c pb = C46610a.m88144pb(true);
        bbr bbr = new bbr();
        bbr.vEf = str;
        bbr.jBB = str2;
        bbr.vXl = C5046bo.nullAsNil(str3);
        pb.xvc = new C3465a(48, bbr);
        AppMethodBeat.m2505o(103871);
        return pb;
    }

    /* renamed from: c */
    public final C46610a mo20637c(String str, String str2, boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(103872);
        C30263c pb = C46610a.m88144pb(true);
        bbs bbs = new bbs();
        bbs.vEf = str;
        bbs.jBB = str2;
        bbs.wGd = 1;
        if (!z) {
            i = 2;
        }
        bbs.pXD = i;
        pb.xvc = new C3465a(49, bbs);
        AppMethodBeat.m2505o(103872);
        return pb;
    }

    /* renamed from: a */
    public final void mo20635a(C7616ad c7616ad, boolean z) {
        AppMethodBeat.m2504i(103873);
        if (z) {
            C1855t.m3961r(c7616ad);
            AppMethodBeat.m2505o(103873);
            return;
        }
        C1855t.m3964u(c7616ad);
        AppMethodBeat.m2505o(103873);
    }

    /* renamed from: Ju */
    public final C30267d mo20628Ju() {
        AppMethodBeat.m2504i(103858);
        C30267d c30267d = new C30267d();
        AppMethodBeat.m2505o(103858);
        return c30267d;
    }
}
