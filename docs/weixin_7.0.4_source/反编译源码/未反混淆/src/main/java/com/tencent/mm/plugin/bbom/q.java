package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.j;
import com.tencent.mm.booter.m;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.g;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.LinkedList;
import java.util.List;

public final class q extends c<mp> {
    public q() {
        AppMethodBeat.i(18322);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(18322);
    }

    public final /* synthetic */ boolean a(b bVar) {
        int h;
        int h2;
        String trim;
        axd axd;
        long anT;
        long c;
        AppMethodBeat.i(18323);
        if (a.flw != null) {
            a.flw.Zv();
        }
        Object obj = (aw.RK() && !aw.QT() && (r.YK() & 16) == 0) ? 1 : null;
        if (obj != null && i.Iv()) {
            bat bat;
            aw.ZK();
            z Ry = com.tencent.mm.model.c.Ry();
            h = ah.h((Integer) Ry.get(67073, null));
            int h3 = ah.h((Integer) Ry.get(67074, null));
            int h4 = ah.h((Integer) Ry.get(67075, null));
            h2 = ah.h((Integer) Ry.get(67076, null));
            aw.ZK();
            h XO = com.tencent.mm.model.c.XO();
            int cA = XO.cA("medianote", 1);
            int cA2 = XO.cA("medianote", 3);
            int cA3 = XO.cA("medianote", 34);
            int cA4 = XO.cA("medianote", 43);
            if (cA - h > 0) {
                bat bat2 = new bat();
                bat2.wEE = cA - h;
                bat2.wEF = 1;
                Ry.set(67073, Integer.valueOf(cA));
            }
            if (cA2 - h3 > 0) {
                bat = new bat();
                bat.wEE = cA2 - h3;
                bat.wEF = 3;
                Ry.set(67074, Integer.valueOf(cA2));
            }
            if (cA3 - h4 > 0) {
                bat = new bat();
                bat.wEE = cA3 - h4;
                bat.wEF = 34;
                Ry.set(67075, Integer.valueOf(cA3));
            }
            if (cA4 - h2 > 0) {
                bat = new bat();
                bat.wEE = cA4 - h2;
                bat.wEF = 43;
                Ry.set(67076, Integer.valueOf(cA4));
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(66817, Long.valueOf(ah.anT()));
        }
        com.tencent.mm.bq.a.run();
        aw.ZK();
        boolean f = ah.f((Boolean) com.tencent.mm.model.c.Ry().get(67841, null));
        if (!(l.apS() == l.a.SUCC || l.apS() == l.a.SUCC_UNLOAD)) {
            f = false;
        }
        if (f) {
            ab.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List vX = com.tencent.mm.plugin.account.a.getAddrUploadStg().vX("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + bo.vA("") + "\" )");
            ab.d("MicroMsg.PostTaskUpdateCtRemark", "list " + vX.size());
            h2 = 0;
            while (true) {
                int i = h2;
                if (i >= vX.size()) {
                    break;
                }
                String username = ((com.tencent.mm.plugin.account.friend.a.a) vX.get(i)).getUsername();
                trim = ((com.tencent.mm.plugin.account.friend.a.a) vX.get(i)).apA().trim();
                if (!(username == null || username.equals("") || trim == null || trim.equals(""))) {
                    aw.ZK();
                    ad aoO = com.tencent.mm.model.c.XM().aoO(username);
                    if (com.tencent.mm.n.a.jh(aoO.field_type) && (aoO.field_conRemark == null || aoO.field_conRemark.equals(""))) {
                        ab.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        t.b(aoO, trim);
                    }
                }
                h2 = i + 1;
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(67841, Boolean.FALSE);
        }
        ab.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        bv.aaq().aar();
        LinkedList linkedList = new LinkedList();
        h = bo.a((Integer) aw.ZI().get(19), 0);
        for (h2 = 0; h2 < h; h2++) {
            axd = new axd();
            axd.pXC = 31;
            axd.pXM = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            linkedList.add(axd);
        }
        h = bo.a((Integer) aw.ZI().get(20), 0);
        for (h2 = 0; h2 < h; h2++) {
            axd = new axd();
            axd.pXC = 31;
            axd.pXM = "1";
            linkedList.add(axd);
        }
        if (linkedList.size() > 0) {
            bv.b(linkedList);
            aw.ZI().set(19, Integer.valueOf(0));
            aw.ZI().set(20, Integer.valueOf(0));
        }
        m.run();
        com.tencent.mm.booter.h.run();
        if (aw.RK() && !aw.QT()) {
            if (bo.isNullOrNil(com.tencent.mm.bq.c.dlR())) {
                bh.oG("ver" + d.vxo);
            } else {
                aw.ZK();
                if (bo.fp(bo.a((Long) com.tencent.mm.model.c.Ry().get(77833, null), 0)) * 1000 >= 604800000) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(10719, com.tencent.mm.bq.c.dlN(), com.tencent.mm.bq.c.dlO(), com.tencent.mm.bq.c.dlP(), com.tencent.mm.bq.c.getRomInfo(), com.tencent.mm.bq.c.dlQ(), "", com.tencent.mm.bq.c.dlR());
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(77833, Long.valueOf(bo.anT()));
                    ab.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (aw.RK() && !aw.QT()) {
            anT = bo.anT();
            aw.ZK();
            if (bo.a((Long) com.tencent.mm.model.c.Ry().get(331777, null), 0) < anT) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(331777, Long.valueOf(anT + 259200));
                com.tencent.mm.plugin.report.b.d.cgi();
            }
            com.tencent.mm.plugin.report.b.d.u(3, 0, "");
        }
        com.tencent.mm.bq.b.run();
        if (aw.RK()) {
            aw.ZK();
            c = bo.c((Long) com.tencent.mm.model.c.Ry().get(74, null));
            if (10010 == ae.giz && ae.giA > 0) {
                c = bo.anT() - ((long) ae.giA);
                ab.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", Integer.valueOf(ae.giA), Long.valueOf(c));
                ae.giA = 0;
            }
            anT = bo.anT();
            ab.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", Long.valueOf(anT), Long.valueOf(c), Long.valueOf(anT - c));
            if ((anT - c) * 1000 >= 86400000) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(74, Long.valueOf(anT));
                if (com.tencent.mm.modelstat.q.aks() == null) {
                    ab.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    anT = (bo.anU() / 86400000) - 1;
                    k md = com.tencent.mm.modelstat.q.aks().md((int) anT);
                    if (md == null || md.fSZ != ((int) anT)) {
                        String str = "MicroMsg.PostTaskReportDataFlow";
                        String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(md == null ? -1 : md.fSZ);
                        objArr[1] = Long.valueOf(anT);
                        ab.e(str, str2, objArr);
                    } else if (com.tencent.mm.modelstat.q.akq() == null) {
                        ab.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        g.a aki = com.tencent.mm.modelstat.q.akq().aki();
                        if (aki == null) {
                            ab.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            aki = new g.a();
                        }
                        ab.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", Long.valueOf(anT), Integer.valueOf(md.fSZ), Integer.valueOf(md.fTl), Integer.valueOf(md.fTx), Integer.valueOf(md.fTk), Integer.valueOf(md.fTw), Integer.valueOf(md.fTj), Integer.valueOf(md.fTv), Integer.valueOf(md.fTi), Integer.valueOf(md.fTu), Integer.valueOf(aki.fSU), Integer.valueOf(aki.cuu), aki.ispName, aki.extraInfo);
                        com.tencent.mm.plugin.report.service.h.pYm.e(10900, Long.valueOf((anT * 86400000) / 1000), Integer.valueOf(md.fTl), Integer.valueOf(md.fTx), Integer.valueOf(md.fTk), Integer.valueOf(md.fTw), Integer.valueOf(md.fTj), Integer.valueOf(md.fTv), Integer.valueOf(md.fTi), Integer.valueOf(md.fTu), Integer.valueOf(aki.fSU), Integer.valueOf(aki.cuu), aki.ispName, aki.extraInfo);
                    }
                }
            }
        } else {
            ab.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        }
        com.tencent.mm.modelsimple.ad.run();
        aw.ZK();
        if (ah.gb(ah.c((Long) com.tencent.mm.model.c.Ry().get(282881, null))) > 172800000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(282881, Long.valueOf(ah.anU()));
            com.tencent.mm.sdk.b.a.xxA.m(new pb());
        }
        if (aw.RK() && !aw.QT()) {
            anT = bo.anT();
            aw.ZK();
            if (bo.a((Long) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, null), 0) < anT) {
                c = 604800 + anT;
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, Long.valueOf(c));
                trim = r.Yz();
                if (!TextUtils.isEmpty(trim)) {
                    aw.Rg().a(new com.tencent.mm.modelsimple.m(trim), 0);
                }
            }
        }
        if (aw.RK() && !aw.QT()) {
            anT = bo.anT();
            aw.ZK();
            if (bo.a((Long) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, null), 0) < anT) {
                c = (bo.dpC() / 1000) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, Long.valueOf(c));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11921, Integer.valueOf(1));
                    } else if (defaultAdapter.getState() == 10) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11921, Integer.valueOf(0));
                    }
                }
            }
        }
        com.tencent.mm.booter.k.run();
        com.tencent.mm.booter.l.run();
        j.run();
        AppMethodBeat.o(18323);
        return false;
    }
}
