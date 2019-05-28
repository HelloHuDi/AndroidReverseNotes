package com.tencent.p177mm.plugin.sns.p518k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C43558b;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.sns.p518k.C3877c.C3878a;
import com.tencent.p177mm.plugin.sns.p518k.C3877c.C3879b;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b.C43587b;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C21992j;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.app.C16025a.C16026a;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.tencent.mm.plugin.sns.k.a */
public final class C34939a extends C16025a implements C1202f {
    String igi;
    protected volatile C3890a rCU;
    public volatile C43587b rEB;
    private C39729a rNm;
    boolean rjn;
    String ryC;
    boolean ryD;
    int ryE;

    /* renamed from: com.tencent.mm.plugin.sns.k.a$1 */
    class C349401 extends C16026a<C3879b> {
        C349401() {
            super();
        }

        public final /* synthetic */ Object aoq() {
            AppMethodBeat.m2504i(40530);
            C4990ab.m7417i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", C3879b.class);
            C3879b cvD = C34939a.cvD();
            AppMethodBeat.m2505o(40530);
            return cvD;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.k.a$2 */
    class C349412 extends C16026a<C3878a> {
        C349412() {
            super();
        }

        public final /* synthetic */ Object aoq() {
            C7486a aoO;
            AppMethodBeat.m2504i(40531);
            C4990ab.m7417i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", C3878a.class);
            C34939a c34939a = C34939a.this;
            C3878a c3878a = new C3878a();
            c34939a.ryE = c34939a.zXe.getIntExtra("sns_source", 0);
            c34939a.igi = c34939a.zXe.getStringExtra("sns_userName");
            if (c34939a.igi == null) {
                c34939a.igi = "";
            }
            C1720g.m3537RQ();
            c34939a.ryD = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c34939a.igi);
            c34939a.ryC = C1853r.m3846Yz();
            c34939a.rjn = c34939a.ryC.equals(c34939a.igi);
            C7309bd cnt = C13373af.cnt();
            String bc = C5046bo.m7532bc(c34939a.zXe.getStringExtra("sns_signature"), "");
            String bc2 = C5046bo.m7532bc(c34939a.zXe.getStringExtra("sns_nickName"), "");
            if (c34939a.igi == null || c34939a.igi.equals("")) {
                aoO = cnt.aoO(c34939a.ryC);
            } else {
                aoO = cnt.aoO(c34939a.igi);
            }
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                bc = aoO.signature;
                bc2 = aoO.mo16706Oi();
                C4990ab.m7417i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", aoO.field_username, Integer.valueOf((int) aoO.ewQ), bc2);
            }
            c3878a.igi = c34939a.igi;
            c3878a.ryC = c34939a.ryC;
            c3878a.ryD = c34939a.ryD;
            c3878a.rjn = c34939a.rjn;
            c3878a.ryE = c34939a.ryE;
            c3878a.gHT = bc2;
            c3878a.mSignature = bc;
            AppMethodBeat.m2505o(40531);
            return c3878a;
        }
    }

    /* renamed from: a */
    public final void mo55524a(C39729a c39729a) {
        AppMethodBeat.m2504i(40532);
        this.rCU = C13373af.cnv();
        C3878a c3878a = (C3878a) mo28391x(C3878a.class);
        this.rNm = c39729a;
        this.rCU.mo8617a(1, c3878a.igi, this.rNm);
        AppMethodBeat.m2505o(40532);
    }

    public final C3890a cnv() {
        return this.rCU;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(40533);
        super.onCreate();
        mo28387a(C3879b.class, (C16026a) new C349401());
        mo28387a(C3878a.class, (C16026a) new C349412());
        C4990ab.m7417i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", this);
        C43558b cnA = C13373af.cnA();
        synchronized (cnA.eHH) {
            try {
                cnA.qHH.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(40533);
            }
        }
        C13373af.cnA();
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(40534);
        C4990ab.m7417i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", this);
        C1720g.m3537RQ();
        if (!(!C1720g.m3534RN().mo5161QY() || this.rCU == null || this.rNm == null)) {
            this.rCU.mo8619a(this.rNm, 1);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(40534);
    }

    static C3879b cvD() {
        Long l;
        AppMethodBeat.m2504i(40535);
        C3879b c3879b = new C3879b();
        Cursor cqF = C13373af.cnK().cqF();
        int count = cqF.getCount();
        String str = "";
        if (count > 0) {
            cqF.moveToFirst();
            C21992j c21992j = new C21992j();
            c21992j.mo8995d(cqF);
            try {
                str = ((can) new can().parseFrom(c21992j.field_curActionBuf)).wPm;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
        }
        cqF.close();
        String[] split = ((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, (Object) "")).split("&");
        ArrayList arrayList = new ArrayList();
        for (int i = 2; i < split.length; i++) {
            long j = C5046bo.getLong(split[i], 0);
            if (j != 0) {
                arrayList.add(Long.valueOf(j));
            }
        }
        Collections.reverse(arrayList);
        if (arrayList.size() > 0) {
            l = (Long) arrayList.get(0);
        } else {
            l = null;
        }
        C21991i.m33618h(l);
        c3879b.rNt = count;
        c3879b.rNs = str;
        c3879b.rNu = arrayList;
        AppMethodBeat.m2505o(40535);
        return c3879b;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40536);
        C4990ab.m7417i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m.toString());
        AppMethodBeat.m2505o(40536);
    }

    /* renamed from: f */
    public final void mo55526f(String str, boolean z, int i) {
        AppMethodBeat.m2504i(40537);
        this.rCU.mo8618a(1, str, z, i);
        AppMethodBeat.m2505o(40537);
    }

    /* renamed from: g */
    public final void mo55527g(String str, boolean z, int i) {
        AppMethodBeat.m2504i(40538);
        this.rCU.mo8620b(1, str, z, i);
        AppMethodBeat.m2505o(40538);
    }
}
