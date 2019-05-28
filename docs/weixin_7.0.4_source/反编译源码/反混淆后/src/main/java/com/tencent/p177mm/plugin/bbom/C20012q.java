package com.tencent.p177mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C25974j;
import com.tencent.p177mm.booter.C37620m;
import com.tencent.p177mm.booter.C45271l;
import com.tencent.p177mm.booter.C9183h;
import com.tencent.p177mm.booter.C9185i;
import com.tencent.p177mm.booter.C9186k;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C32826m;
import com.tencent.p177mm.modelsimple.C45451ad;
import com.tencent.p177mm.modelstat.C18692g.C18693a;
import com.tencent.p177mm.modelstat.C42223k;
import com.tencent.p177mm.modelstat.C42225q;
import com.tencent.p177mm.p1186bq.C18114a;
import com.tencent.p177mm.p1186bq.C25993b;
import com.tencent.p177mm.p1186bq.C25994c;
import com.tencent.p177mm.p230g.p231a.C26214pb;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.report.p499b.C34829d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.axd;
import com.tencent.p177mm.protocal.protobuf.bat;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.bbom.q */
public final class C20012q extends C4884c<C6523mp> {
    public C20012q() {
        AppMethodBeat.m2504i(18322);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(18322);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        int h;
        int h2;
        String trim;
        axd axd;
        long anT;
        long c;
        AppMethodBeat.m2504i(18323);
        if (C26417a.flw != null) {
            C26417a.flw.mo37870Zv();
        }
        Object obj = (C9638aw.m17179RK() && !C9638aw.m17178QT() && (C1853r.m3829YK() & 16) == 0) ? 1 : null;
        if (obj != null && C9185i.m16686Iv()) {
            bat bat;
            C9638aw.m17190ZK();
            C7580z Ry = C18628c.m29072Ry();
            h = C42252ah.m74624h((Integer) Ry.get(67073, null));
            int h3 = C42252ah.m74624h((Integer) Ry.get(67074, null));
            int h4 = C42252ah.m74624h((Integer) Ry.get(67075, null));
            h2 = C42252ah.m74624h((Integer) Ry.get(67076, null));
            C9638aw.m17190ZK();
            C6977h XO = C18628c.m29080XO();
            int cA = XO.mo15316cA("medianote", 1);
            int cA2 = XO.mo15316cA("medianote", 3);
            int cA3 = XO.mo15316cA("medianote", 34);
            int cA4 = XO.mo15316cA("medianote", 43);
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
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(66817, Long.valueOf(C42252ah.anT()));
        }
        C18114a.run();
        C9638aw.m17190ZK();
        boolean f = C42252ah.m74620f((Boolean) C18628c.m29072Ry().get(67841, null));
        if (!(C38033l.apS() == C38034a.SUCC || C38033l.apS() == C38034a.SUCC_UNLOAD)) {
            f = false;
        }
        if (f) {
            C4990ab.m7410d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List vX = C32923a.getAddrUploadStg().mo34093vX("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + C5046bo.m7586vA("") + "\" )");
            C4990ab.m7410d("MicroMsg.PostTaskUpdateCtRemark", "list " + vX.size());
            h2 = 0;
            while (true) {
                int i = h2;
                if (i >= vX.size()) {
                    break;
                }
                String username = ((C18817a) vX.get(i)).getUsername();
                trim = ((C18817a) vX.get(i)).apA().trim();
                if (!(username == null || username.equals("") || trim == null || trim.equals(""))) {
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(username);
                    if (C7486a.m12942jh(aoO.field_type) && (aoO.field_conRemark == null || aoO.field_conRemark.equals(""))) {
                        C4990ab.m7410d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        C1855t.m3887b(aoO, trim);
                    }
                }
                h2 = i + 1;
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(67841, Boolean.FALSE);
        }
        C4990ab.m7410d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        C37907bv.aaq().aar();
        LinkedList linkedList = new LinkedList();
        h = C5046bo.m7512a((Integer) C9638aw.m17188ZI().get(19), 0);
        for (h2 = 0; h2 < h; h2++) {
            axd = new axd();
            axd.pXC = 31;
            axd.pXM = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            linkedList.add(axd);
        }
        h = C5046bo.m7512a((Integer) C9638aw.m17188ZI().get(20), 0);
        for (h2 = 0; h2 < h; h2++) {
            axd = new axd();
            axd.pXC = 31;
            axd.pXM = "1";
            linkedList.add(axd);
        }
        if (linkedList.size() > 0) {
            C37907bv.m64019b(linkedList);
            C9638aw.m17188ZI().set(19, Integer.valueOf(0));
            C9638aw.m17188ZI().set(20, Integer.valueOf(0));
        }
        C37620m.run();
        C9183h.run();
        if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
            if (C5046bo.isNullOrNil(C25994c.dlR())) {
                C1831bh.m3771oG("ver" + C7243d.vxo);
            } else {
                C9638aw.m17190ZK();
                if (C5046bo.m7549fp(C5046bo.m7514a((Long) C18628c.m29072Ry().get(77833, null), 0)) * 1000 >= 604800000) {
                    C7060h.pYm.mo8381e(10719, C25994c.dlN(), C25994c.dlO(), C25994c.dlP(), C25994c.getRomInfo(), C25994c.dlQ(), "", C25994c.dlR());
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(77833, Long.valueOf(C5046bo.anT()));
                    C4990ab.m7410d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
            anT = C5046bo.anT();
            C9638aw.m17190ZK();
            if (C5046bo.m7514a((Long) C18628c.m29072Ry().get(331777, null), 0) < anT) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(331777, Long.valueOf(anT + 259200));
                C34829d.cgi();
            }
            C34829d.m57192u(3, 0, "");
        }
        C25993b.run();
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            c = C5046bo.m7534c((Long) C18628c.m29072Ry().get(74, null));
            if (10010 == C1947ae.giz && C1947ae.giA > 0) {
                c = C5046bo.anT() - ((long) C1947ae.giA);
                C4990ab.m7411d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", Integer.valueOf(C1947ae.giA), Long.valueOf(c));
                C1947ae.giA = 0;
            }
            anT = C5046bo.anT();
            C4990ab.m7411d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", Long.valueOf(anT), Long.valueOf(c), Long.valueOf(anT - c));
            if ((anT - c) * 1000 >= 86400000) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(74, Long.valueOf(anT));
                if (C42225q.aks() == null) {
                    C4990ab.m7412e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    anT = (C5046bo.anU() / 86400000) - 1;
                    C42223k md = C42225q.aks().mo51241md((int) anT);
                    if (md == null || md.fSZ != ((int) anT)) {
                        String str = "MicroMsg.PostTaskReportDataFlow";
                        String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(md == null ? -1 : md.fSZ);
                        objArr[1] = Long.valueOf(anT);
                        C4990ab.m7413e(str, str2, objArr);
                    } else if (C42225q.akq() == null) {
                        C4990ab.m7412e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        C18693a aki = C42225q.akq().aki();
                        if (aki == null) {
                            C4990ab.m7420w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            aki = new C18693a();
                        }
                        C4990ab.m7417i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", Long.valueOf(anT), Integer.valueOf(md.fSZ), Integer.valueOf(md.fTl), Integer.valueOf(md.fTx), Integer.valueOf(md.fTk), Integer.valueOf(md.fTw), Integer.valueOf(md.fTj), Integer.valueOf(md.fTv), Integer.valueOf(md.fTi), Integer.valueOf(md.fTu), Integer.valueOf(aki.fSU), Integer.valueOf(aki.cuu), aki.ispName, aki.extraInfo);
                        C7060h.pYm.mo8381e(10900, Long.valueOf((anT * 86400000) / 1000), Integer.valueOf(md.fTl), Integer.valueOf(md.fTx), Integer.valueOf(md.fTk), Integer.valueOf(md.fTw), Integer.valueOf(md.fTj), Integer.valueOf(md.fTv), Integer.valueOf(md.fTi), Integer.valueOf(md.fTu), Integer.valueOf(aki.fSU), Integer.valueOf(aki.cuu), aki.ispName, aki.extraInfo);
                    }
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        }
        C45451ad.run();
        C9638aw.m17190ZK();
        if (C42252ah.m74623gb(C42252ah.m74610c((Long) C18628c.m29072Ry().get(282881, null))) > 172800000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(282881, Long.valueOf(C42252ah.anU()));
            C4879a.xxA.mo10055m(new C26214pb());
        }
        if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
            anT = C5046bo.anT();
            C9638aw.m17190ZK();
            if (C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, null), 0) < anT) {
                c = 604800 + anT;
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, Long.valueOf(c));
                trim = C1853r.m3846Yz();
                if (!TextUtils.isEmpty(trim)) {
                    C9638aw.m17182Rg().mo14541a(new C32826m(trim), 0);
                }
            }
        }
        if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
            anT = C5046bo.anT();
            C9638aw.m17190ZK();
            if (C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, null), 0) < anT) {
                c = (C5046bo.dpC() / 1000) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, Long.valueOf(c));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        C7060h.pYm.mo8381e(11921, Integer.valueOf(1));
                    } else if (defaultAdapter.getState() == 10) {
                        C7060h.pYm.mo8381e(11921, Integer.valueOf(0));
                    }
                }
            }
        }
        C9186k.run();
        C45271l.run();
        C25974j.run();
        AppMethodBeat.m2505o(18323);
        return false;
    }
}
