package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.p268aa.C38007a;
import com.tencent.p177mm.plugin.p268aa.p269a.C1955g;
import com.tencent.p177mm.plugin.p268aa.p269a.C24677j;
import com.tencent.p177mm.plugin.p268aa.p269a.C38002c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40561q;
import com.tencent.p177mm.protocal.protobuf.C40568s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;

/* renamed from: com.tencent.mm.plugin.aa.a.c.f */
public class C37996f extends C16025a {
    C38002c gmN = new C38002c();
    C1955g gmO = new C1955g();
    C24677j gmP = new C24677j();

    /* renamed from: com.tencent.mm.plugin.aa.a.c.f$1 */
    class C187741 implements C5681a<Void, C37441a<C40561q>> {
        final /* synthetic */ C5688b gmA;

        C187741(C5688b c5688b) {
            this.gmA = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40692);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.PaylistAAInteractor", "errType: %s, errCode: %s, retCode: %s, retMsg: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), Integer.valueOf(((C40561q) c37441a.fsy).kCl), ((C40561q) c37441a.fsy).kCm);
            this.gmA.resume();
            Void voidR = zXH;
            AppMethodBeat.m2505o(40692);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.f$2 */
    class C379972 implements C5681a<Void, C37441a<C40568s>> {
        final /* synthetic */ C5688b gmA;

        C379972(C5688b c5688b) {
            this.gmA = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40693);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C40568s c40568s = (C40568s) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", Integer.valueOf(c40568s.kCl), c40568s.kCm);
                if (c40568s.kCl == 0) {
                    C4990ab.m7416i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                    C38007a.gkF.mo38844BS();
                    this.gmA.mo11581B(Boolean.TRUE);
                    C7060h.pYm.mo8378a(407, 24, 1, false);
                } else {
                    if (c40568s.kCl <= 0 || C5046bo.isNullOrNil(c40568s.kCm)) {
                        this.gmA.mo11582cR(Boolean.FALSE);
                    } else {
                        this.gmA.mo11582cR(c40568s.kCm);
                    }
                    C7060h.pYm.mo8378a(407, 26, 1, false);
                }
            } else {
                this.gmA.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(407, 25, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40693);
            return voidR;
        }
    }

    public C37996f() {
        AppMethodBeat.m2504i(40694);
        AppMethodBeat.m2505o(40694);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(40695);
        super.onCreate();
        C1202f aof = this.gmN.aof();
        C4990ab.m7416i("MicroMsg.AAGetPaylistDetailLogic", "init");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1695, aof);
        aof = this.gmO.aol();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1629, aof);
        this.gmP.aoo().init();
        AppMethodBeat.m2505o(40695);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(40696);
        super.onDestroy();
        C1202f aof = this.gmN.aof();
        C4990ab.m7416i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1695, aof);
        aof = this.gmO.aol();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1629, aof);
        this.gmP.aoo().aon();
        AppMethodBeat.m2505o(40696);
    }

    /* renamed from: mJ */
    public final String mo60765mJ(String str) {
        AppMethodBeat.m2504i(40697);
        String displayName = ((C34530b) C1720g.m3528K(C34530b.class)).getDisplayName(str, this.zXe.getStringExtra("chatroom"));
        AppMethodBeat.m2505o(40697);
        return displayName;
    }
}
