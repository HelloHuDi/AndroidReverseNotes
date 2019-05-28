package com.tencent.p177mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p230g.p231a.C42020la;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.subapp.jdbiz.a */
public final class C29389a implements C1837a {
    C4884c ssn = new C293901();

    /* renamed from: com.tencent.mm.plugin.subapp.jdbiz.a$1 */
    class C293901 extends C4884c<C42020la> {
        C293901() {
            AppMethodBeat.m2504i(25187);
            this.xxI = C42020la.class.getName().hashCode();
            AppMethodBeat.m2505o(25187);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25188);
            C42020la c42020la = (C42020la) c4883b;
            if (!(c42020la instanceof C42020la)) {
                AppMethodBeat.m2505o(25188);
            } else if (c42020la.cGS.params == null || c42020la.cGS.cGT == null || !"bizjd".equals(c42020la.cGS.cGT)) {
                AppMethodBeat.m2505o(25188);
            } else {
                String bc = C5046bo.m7532bc(c42020la.cGS.params.getString("activity_id"), "");
                String bc2 = C5046bo.m7532bc(c42020la.cGS.params.getString("jump_url"), "");
                C7060h.pYm.mo8381e(11179, bc2, C22337c.cDr().cDw().ssr, Integer.valueOf(4));
                C22336b cDw = C22337c.cDr().cDw();
                if (!(cDw == null || cDw.ssr == null || !cDw.ssr.equals(bc))) {
                    C22337c.cDr().cDv();
                    C22337c.cDr().cDu();
                }
                C4879a.xxA.mo10053d(C29389a.this.ssn);
                AppMethodBeat.m2505o(25188);
            }
            return false;
        }
    }

    public C29389a() {
        AppMethodBeat.m2504i(25190);
        AppMethodBeat.m2505o(25190);
    }

    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        int i = 0;
        AppMethodBeat.m2504i(25191);
        C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(25191);
            return;
        }
        final C22336b c22336b = new C22336b();
        c22336b.mo37878YH(C1946aa.m4148a(c7254cm.vED));
        C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + C5046bo.m7532bc(c22336b.ssq, ""));
        if (C5046bo.isNullOrNil(c22336b.ssq)) {
            C4990ab.m7412e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (C5046bo.isNullOrNil(c22336b.ssr)) {
            C4990ab.m7412e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!c22336b.mo37879a(C22337c.cDr().cDw())) {
            C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!C22337c.cDz()) {
            C4990ab.m7412e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
        } else if (c22336b.ssq.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            c7254cm.vEH = null;
            if (C5046bo.isNullOrNil(c22336b.ssB) || C5046bo.isNullOrNil(c22336b.jumpUrl) || C5046bo.isNullOrNil(c22336b.ssC) || C5046bo.isNullOrNil(c22336b.ssD) || C5046bo.isNullOrNil(c22336b.ssA)) {
                C4990ab.m7412e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (c22336b.bxX()) {
                C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                C22337c cDr = C22337c.cDr();
                String str = c22336b.ssr;
                if (!C5046bo.isNullOrNil(str)) {
                    i = cDr.ssG.containsKey(str);
                }
                if (i != 0) {
                    C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + c22336b.ssr);
                } else if (c22336b.mo37879a(C22337c.cDr().cDw())) {
                    C22337c cDr2 = C22337c.cDr();
                    String str2 = c22336b.ssr;
                    if (!C5046bo.isNullOrNil(str2)) {
                        cDr2.ssG.put(str2, Integer.valueOf(1));
                    }
                    C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + c22336b.ssr);
                    new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(25189);
                            C29389a c29389a = C29389a.this;
                            C22336b c22336b = c22336b;
                            C9638aw.m17190ZK();
                            int intValue = ((Integer) C18628c.m29072Ry().get(15, Integer.valueOf(0))).intValue();
                            String dn;
                            if (C9638aw.m17182Rg().foreground && 1 == intValue) {
                                JDRemindDialog.m86840a(C4996ah.getContext(), c22336b.ssB, c22336b.ssC, c22336b.ssD, C22337c.m34040dn(c22336b.jumpUrl, 5), c22336b.ssr);
                                C7060h.pYm.mo8381e(11178, dn, C22337c.cDr().cDw().ssr, Integer.valueOf(5));
                                AppMethodBeat.m2505o(25189);
                                return;
                            }
                            dn = C22337c.m34040dn(c22336b.jumpUrl, 4);
                            Bundle bundle = new Bundle();
                            bundle.putString("activity_id", c22336b.ssr);
                            bundle.putString("jump_url", dn);
                            ((C42184aq) C9638aw.getNotification()).mo27971a(37, C4996ah.getContext().getString(C25738R.string.f9209t0), c22336b.ssA, dn, "bizjd", bundle);
                            C4879a.xxA.mo10052c(c29389a.ssn);
                            C7060h.pYm.mo8381e(11178, dn, C22337c.cDr().cDw().ssr, Integer.valueOf(4));
                            AppMethodBeat.m2505o(25189);
                        }
                    });
                } else {
                    C4990ab.m7416i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                }
            }
            C22337c.m34039b(c22336b);
        } else if (c22336b.ssq.equals("1")) {
            C22337c.m34039b(c22336b);
        } else if (c22336b.ssq.equals("2")) {
            C22337c.m34039b(c22336b);
            C7060h.pYm.mo8381e(11178, c22336b.jumpUrl, c22336b.ssr, Integer.valueOf(3));
        }
        C9638aw.m17190ZK();
        C18628c.m29072Ry().dsb();
        AppMethodBeat.m2505o(25191);
    }
}
