package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.la;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public final class a implements com.tencent.mm.model.bz.a {
    c ssn = new c<la>() {
        {
            AppMethodBeat.i(25187);
            this.xxI = la.class.getName().hashCode();
            AppMethodBeat.o(25187);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(25188);
            la laVar = (la) bVar;
            if (!(laVar instanceof la)) {
                AppMethodBeat.o(25188);
            } else if (laVar.cGS.params == null || laVar.cGS.cGT == null || !"bizjd".equals(laVar.cGS.cGT)) {
                AppMethodBeat.o(25188);
            } else {
                String bc = bo.bc(laVar.cGS.params.getString("activity_id"), "");
                String bc2 = bo.bc(laVar.cGS.params.getString("jump_url"), "");
                h.pYm.e(11179, bc2, c.cDr().cDw().ssr, Integer.valueOf(4));
                b cDw = c.cDr().cDw();
                if (!(cDw == null || cDw.ssr == null || !cDw.ssr.equals(bc))) {
                    c.cDr().cDv();
                    c.cDr().cDu();
                }
                com.tencent.mm.sdk.b.a.xxA.d(a.this.ssn);
                AppMethodBeat.o(25188);
            }
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(25190);
        AppMethodBeat.o(25190);
    }

    public final void a(com.tencent.mm.ai.e.a aVar) {
        int i = 0;
        AppMethodBeat.i(25191);
        ab.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(25191);
            return;
        }
        final b bVar = new b();
        bVar.YH(aa.a(cmVar.vED));
        ab.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bo.bc(bVar.ssq, ""));
        if (bo.isNullOrNil(bVar.ssq)) {
            ab.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (bo.isNullOrNil(bVar.ssr)) {
            ab.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!bVar.a(c.cDr().cDw())) {
            ab.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!c.cDz()) {
            ab.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
        } else if (bVar.ssq.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            cmVar.vEH = null;
            if (bo.isNullOrNil(bVar.ssB) || bo.isNullOrNil(bVar.jumpUrl) || bo.isNullOrNil(bVar.ssC) || bo.isNullOrNil(bVar.ssD) || bo.isNullOrNil(bVar.ssA)) {
                ab.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (bVar.bxX()) {
                ab.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                c cDr = c.cDr();
                String str = bVar.ssr;
                if (!bo.isNullOrNil(str)) {
                    i = cDr.ssG.containsKey(str);
                }
                if (i != 0) {
                    ab.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + bVar.ssr);
                } else if (bVar.a(c.cDr().cDw())) {
                    c cDr2 = c.cDr();
                    String str2 = bVar.ssr;
                    if (!bo.isNullOrNil(str2)) {
                        cDr2.ssG.put(str2, Integer.valueOf(1));
                    }
                    ab.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + bVar.ssr);
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(25189);
                            a aVar = a.this;
                            b bVar = bVar;
                            aw.ZK();
                            int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(15, Integer.valueOf(0))).intValue();
                            String dn;
                            if (aw.Rg().foreground && 1 == intValue) {
                                JDRemindDialog.a(ah.getContext(), bVar.ssB, bVar.ssC, bVar.ssD, c.dn(bVar.jumpUrl, 5), bVar.ssr);
                                h.pYm.e(11178, dn, c.cDr().cDw().ssr, Integer.valueOf(5));
                                AppMethodBeat.o(25189);
                                return;
                            }
                            dn = c.dn(bVar.jumpUrl, 4);
                            Bundle bundle = new Bundle();
                            bundle.putString("activity_id", bVar.ssr);
                            bundle.putString("jump_url", dn);
                            ((aq) aw.getNotification()).a(37, ah.getContext().getString(R.string.t0), bVar.ssA, dn, "bizjd", bundle);
                            com.tencent.mm.sdk.b.a.xxA.c(aVar.ssn);
                            h.pYm.e(11178, dn, c.cDr().cDw().ssr, Integer.valueOf(4));
                            AppMethodBeat.o(25189);
                        }
                    });
                } else {
                    ab.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                }
            }
            c.b(bVar);
        } else if (bVar.ssq.equals("1")) {
            c.b(bVar);
        } else if (bVar.ssq.equals("2")) {
            c.b(bVar);
            h.pYm.e(11178, bVar.jumpUrl, bVar.ssr, Integer.valueOf(3));
        }
        aw.ZK();
        com.tencent.mm.model.c.Ry().dsb();
        AppMethodBeat.o(25191);
    }
}
