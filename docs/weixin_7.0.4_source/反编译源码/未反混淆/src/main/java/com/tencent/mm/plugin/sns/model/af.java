package com.tencent.mm.plugin.sns.model;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.at;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.lucky.a.l;
import com.tencent.mm.plugin.sns.p;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.ai;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class af implements at, j {
    public static boolean qKD = true;
    private static int qKE = 0;
    private static int qKF = 0;
    private static int qKK;
    private static int qKL;
    private static String qLl = "";
    protected static HashMap<Integer, d> qLm = new HashMap();
    private static ak qLu;
    private static int qLv = 103;
    private static Point qLw = new Point();
    private h eJN;
    private byte[] eMl = new byte[0];
    private ak handler = new ak(Looper.getMainLooper());
    private c oMA = new c<kd>() {
        {
            AppMethodBeat.i(36467);
            this.xxI = kd.class.getName().hashCode();
            AppMethodBeat.o(36467);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36468);
            kd kdVar = (kd) bVar;
            if (kdVar instanceof kd) {
                switch (kdVar.cFz.action) {
                    case -6:
                        List<n> bo = af.cnF().bo(kdVar.cFz.cFB.fKm, r.Yz().equals(kdVar.cFz.cFB.fKm));
                        kdVar.cFA.cAV = new ArrayList();
                        for (n cqu : bo) {
                            kdVar.cFA.cAV.add(g.a(af.getAccPath(), cqu.cqu(), 8));
                        }
                        break;
                    case -5:
                        o cnF = af.cnF();
                        Cursor a = cnF.bSd.a("select *,rowid from SnsInfo where type = 4 AND  (sourceType & 2 != 0 ) " + o.rfn, null, 2);
                        ArrayList<n> arrayList = new ArrayList();
                        while (a.moveToNext()) {
                            n nVar = new n();
                            nVar.d(a);
                            arrayList.add(nVar);
                        }
                        a.close();
                        kdVar.cFA.cAV = new ArrayList();
                        for (n cqu2 : arrayList) {
                            kdVar.cFA.cAV.add(g.a(af.getAccPath(), cqu2.cqu(), 1));
                        }
                        break;
                }
            }
            AppMethodBeat.o(36468);
            return false;
        }
    };
    private a qKG;
    private a qKH;
    private a qKI;
    private a qKJ;
    private s qKM;
    private o qKN;
    private f qKO;
    private com.tencent.mm.plugin.sns.storage.d qKP;
    private y qKQ;
    private g qKR;
    private m qKS;
    private k qKT;
    private u qKU;
    private ad qKV;
    private am.a qKW;
    private b qKX;
    private aw qKY;
    private ai qKZ;
    private p qLA;
    private com.tencent.mm.plugin.sns.h qLB;
    private com.tencent.mm.plugin.sns.g qLC;
    private com.tencent.mm.plugin.sns.m qLD;
    private com.tencent.mm.plugin.sns.j qLE;
    private com.tencent.mm.plugin.sns.b qLF;
    private com.tencent.mm.plugin.sns.c qLG;
    private com.tencent.mm.plugin.sns.f qLH;
    private c qLI = new c<mp>() {
        {
            AppMethodBeat.i(36421);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(36421);
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            AppMethodBeat.i(36422);
            int i = com.tencent.mm.m.g.Nu().getInt("SnsHEVCSwitch", 0);
            int i2 = com.tencent.mm.m.g.Nu().getInt("SnsWXPCSwitch", 0);
            boolean z2 = i == 1;
            if (i2 != 1) {
                z = false;
            }
            Editor edit = ar.s(ah.getContext(), "sp_sns_dynswitch_stg", 4).edit();
            edit.putBoolean("sw_use_vcodec_img", z2);
            edit.putBoolean("sw_use_wxpc_img", z);
            edit.commit();
            AppMethodBeat.o(36422);
            return false;
        }
    };
    private c qLJ = new c<com.tencent.mm.g.a.f>() {
        {
            AppMethodBeat.i(36423);
            this.xxI = com.tencent.mm.g.a.f.class.getName().hashCode();
            AppMethodBeat.o(36423);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36424);
            String str = ((com.tencent.mm.g.a.f) bVar).crT.crU;
            if (!bo.isNullOrNil(str)) {
                a.XB(str);
            }
            AppMethodBeat.o(36424);
            return false;
        }
    };
    private c qLK = new c<co>() {
        {
            AppMethodBeat.i(36425);
            this.xxI = co.class.getName().hashCode();
            AppMethodBeat.o(36425);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36426);
            com.tencent.mm.kernel.g.RQ();
            String str = com.tencent.mm.kernel.g.RP().cachePath;
            com.tencent.mm.kernel.g.RQ();
            String str2 = com.tencent.mm.kernel.g.RP().eJL;
            ab.i("MicroMsg.SnsCore", "dump %s", str2);
            str = str + "SnsMicroMsg.db";
            e.deleteFile(str2 + "sns.dump");
            e.y(str, str2 + "sns.dump");
            AppMethodBeat.o(36426);
            return false;
        }
    };
    private c qLL = new c<sk>() {
        {
            AppMethodBeat.i(36428);
            this.xxI = sk.class.getName().hashCode();
            AppMethodBeat.o(36428);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36429);
            final sk skVar = (sk) bVar;
            if (skVar.cOH.czE != 9 && skVar.cOH.czE == 7) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36427);
                        int i = (int) skVar.cOH.cOJ;
                        k cnK = af.cnK();
                        String concat = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= ".concat(String.valueOf(i));
                        ab.i("MicroMsg.SnsCommentStorage", "updateToread ".concat(String.valueOf(concat)));
                        ab.i("MicroMsg.SnsCore", "update msg read ".concat(String.valueOf(cnK.fni.hY("SnsComment", concat))));
                        u.cna();
                        AppMethodBeat.o(36427);
                    }
                });
            }
            AppMethodBeat.o(36429);
            return false;
        }
    };
    private c qLM = new c<ib>() {
        {
            AppMethodBeat.i(36430);
            this.xxI = ib.class.getName().hashCode();
            AppMethodBeat.o(36430);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36431);
            ((ib) bVar).cDa.isResume = af.cnM().csu();
            AppMethodBeat.o(36431);
            return false;
        }
    };
    private c qLN = new c<hf>() {
        {
            AppMethodBeat.i(36432);
            this.xxI = hf.class.getName().hashCode();
            AppMethodBeat.o(36432);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36433);
            ((hf) bVar).cBZ.cCa = af.cnF().cmn();
            AppMethodBeat.o(36433);
            return false;
        }
    };
    private c qLO = new c<lj>() {
        {
            AppMethodBeat.i(36434);
            this.xxI = lj.class.getName().hashCode();
            AppMethodBeat.o(36434);
        }

        private static boolean a(lj ljVar) {
            AppMethodBeat.i(36435);
            ArrayList arrayList = ljVar.cHj.cCa;
            o cnF = af.cnF();
            h Ru = af.Ru();
            long iV = Ru.iV(-1);
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    n DK = cnF.DK((int) longValue);
                    if (DK != null) {
                        DK.field_localFlag |= 64;
                        ab.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", Long.valueOf(longValue));
                        cnF.b((int) longValue, DK);
                    }
                }
                return false;
            } finally {
                Ru.mB(iV);
                AppMethodBeat.o(36435);
            }
        }
    };
    private c qLP = new c<ox>() {
        {
            AppMethodBeat.i(36438);
            this.xxI = ox.class.getName().hashCode();
            AppMethodBeat.o(36438);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36439);
            final long j = (long) ((ox) bVar).cLl.cLm;
            ab.d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", Long.valueOf(j));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36437);
                    aj.CY((int) j);
                    af.cnB().cmp();
                    com.tencent.mm.sdk.b.a.xxA.m(new tw());
                    AppMethodBeat.o(36437);
                }
            });
            AppMethodBeat.o(36439);
            return false;
        }
    };
    private c qLQ = new c<rc>() {
        {
            AppMethodBeat.i(36440);
            this.xxI = rc.class.getName().hashCode();
            AppMethodBeat.o(36440);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36441);
            af.a(af.this);
            AppMethodBeat.o(36441);
            return false;
        }
    };
    private c qLR = new c<of>() {
        {
            AppMethodBeat.i(36442);
            this.xxI = of.class.getName().hashCode();
            AppMethodBeat.o(36442);
        }

        private static boolean a(of ofVar) {
            AppMethodBeat.i(36443);
            try {
                SnsAdClick snsAdClick = ofVar.cKy.cKz;
                com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(snsAdClick.cND);
                if (ku == null) {
                    AppMethodBeat.o(36443);
                    return false;
                }
                com.tencent.mm.plugin.sns.storage.a cqr;
                n cqB = ku.cqB();
                if (snsAdClick.cvd == 2) {
                    cqr = cqB.cqr();
                } else {
                    cqr = cqB.cqq();
                }
                if (cqr != null) {
                    com.tencent.mm.ai.m cVar;
                    if (snsAdClick.cvd == 2) {
                        ab.i("MicroMsg.SnsCore", "at_friend_detail report ad click");
                        cVar = new com.tencent.mm.plugin.sns.a.b.c(snsAdClick.cND, cqr.hnw, snsAdClick.fPZ, snsAdClick.fQa, snsAdClick.fPY, "", cqB.crf(), cqB.cqu().rjC, snsAdClick.fQf, cqB.crd().cqy(), cqB.crd().cqz());
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RO().eJo.a(cVar, 0);
                    } else {
                        ab.i("MicroMsg.SnsCore", "report ad click");
                        cVar = new com.tencent.mm.plugin.sns.a.b.c(snsAdClick.cND, cqr.hnw, snsAdClick.fPZ, snsAdClick.fQa, snsAdClick.fPY, "", cqB.crf(), cqB.cqu().rjC, snsAdClick.fQf, cqB.crd().cqw(), cqB.crd().cqx());
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RO().eJo.a(cVar, 0);
                    }
                    AppMethodBeat.o(36443);
                    return true;
                }
                AppMethodBeat.o(36443);
                return false;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsCore", e, "report ad click error", new Object[0]);
            }
        }
    };
    private c qLS = new c<og>() {
        {
            AppMethodBeat.i(36445);
            this.xxI = og.class.getName().hashCode();
            AppMethodBeat.o(36445);
        }

        private static boolean a(og ogVar) {
            AppMethodBeat.i(36446);
            try {
                SnsAdClick snsAdClick = ogVar.cKA.cKz;
                com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(snsAdClick.cND);
                if (ku == null) {
                    AppMethodBeat.o(36446);
                    return false;
                }
                com.tencent.mm.plugin.sns.storage.a cqr;
                n cqB = ku.cqB();
                if (snsAdClick.cvd == 2) {
                    cqr = cqB.cqr();
                } else {
                    cqr = cqB.cqq();
                }
                if (cqr != null) {
                    if (snsAdClick.cvd == 2) {
                        ab.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
                    } else {
                        ab.i("MicroMsg.SnsCore", "report ad h5 load");
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(16972, Long.valueOf(snsAdClick.cND), Integer.valueOf(snsAdClick.fPY), cqr.qPj, Integer.valueOf(cqB.cre()), cqB.cqu().rjC, ogVar.cKA.url, Integer.valueOf(ogVar.cKA.cKB), Integer.valueOf(ogVar.cKA.errorCode), Long.valueOf(ogVar.cKA.timestamp));
                    AppMethodBeat.o(36446);
                    return true;
                }
                AppMethodBeat.o(36446);
                return false;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsCore", e, "report load ad h5 error", new Object[0]);
            }
        }
    };
    private c qLT = new c<cp>() {
        {
            AppMethodBeat.i(36448);
            this.xxI = cp.class.getName().hashCode();
            AppMethodBeat.o(36448);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36449);
            af.cnS();
            AppMethodBeat.o(36449);
            return false;
        }
    };
    private c qLU = new c<cn>() {
        {
            AppMethodBeat.i(36450);
            this.xxI = cn.class.getName().hashCode();
            AppMethodBeat.o(36450);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36451);
            com.tencent.mm.plugin.sns.g.e.YB("100004");
            com.tencent.mm.plugin.sns.g.e.YB("100007");
            AppMethodBeat.o(36451);
            return false;
        }
    };
    private c qLV = new c<tk>() {
        {
            AppMethodBeat.i(36452);
            this.xxI = tk.class.getName().hashCode();
            AppMethodBeat.o(36452);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36453);
            ab.i("MicroMsg.SnsCore", "triger snslogmgr try report");
            af.cnz().cmh();
            AppMethodBeat.o(36453);
            return false;
        }
    };
    private c qLW = new c<qz>() {
        {
            AppMethodBeat.i(36454);
            this.xxI = qz.class.getName().hashCode();
            AppMethodBeat.o(36454);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36455);
            aj.cnY();
            af.cnF().bSd.hY("SnsInfo", "delete from SnsInfo");
            af.cnJ().YU("@__weixintimtline");
            AppMethodBeat.o(36455);
            return false;
        }
    };
    private c qLX = new c<ol>() {
        {
            AppMethodBeat.i(36456);
            this.xxI = ol.class.getName().hashCode();
            AppMethodBeat.o(36456);
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x00d0=Splitter:B:14:0x00d0, B:27:0x0230=Splitter:B:27:0x0230} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean a(ol olVar) {
            AppMethodBeat.i(36457);
            SnsAdClick snsAdClick = olVar.cKM.cKz;
            try {
                if (olVar.cKM.cKN == 1) {
                    if (snsAdClick.fQb == 1) {
                        i cnz;
                        int i;
                        int i2;
                        int cqs;
                        Object[] objArr;
                        Object[] objArr2;
                        com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(snsAdClick.cND);
                        Object[] objArr3;
                        if (ku == null || !ku.coX()) {
                            cnz = af.cnz();
                            i = 13155;
                            objArr3 = new Object[7];
                            objArr3[0] = Long.valueOf(snsAdClick.cND);
                            objArr3[1] = ku.cqq().qPj;
                            objArr3[2] = Integer.valueOf(snsAdClick.fPY);
                            objArr3[3] = Long.valueOf(snsAdClick.startTime);
                            objArr3[4] = Long.valueOf(System.currentTimeMillis());
                            i2 = 5;
                            if (ku != null) {
                                cqs = ku.cqs();
                                objArr = objArr3;
                                objArr2 = objArr3;
                            } else {
                                cqs = -1;
                                objArr = objArr3;
                                objArr2 = objArr3;
                            }
                        } else {
                            cnz = af.cnz();
                            i = 14647;
                            objArr3 = new Object[7];
                            objArr3[0] = Long.valueOf(snsAdClick.cND);
                            objArr3[1] = ku.cqq().qPj;
                            objArr3[2] = Integer.valueOf(snsAdClick.fPY);
                            objArr3[3] = Long.valueOf(snsAdClick.startTime);
                            objArr3[4] = Long.valueOf(System.currentTimeMillis());
                            i2 = 5;
                            cqs = ku.cqs();
                            objArr = objArr3;
                            objArr2 = objArr3;
                        }
                        objArr[i2] = Integer.valueOf(cqs);
                        objArr2[6] = "";
                        cnz.e(i, objArr2);
                        com.tencent.mm.modelsns.b lZ = com.tencent.mm.modelsns.b.lZ(750);
                        lZ.tx(snsAdClick.cND).tx(ku.cqq().qPj).mb(snsAdClick.fPY).tx(snsAdClick.startTime).tx(System.currentTimeMillis());
                        lZ.ajK();
                    } else {
                        com.tencent.mm.plugin.sns.storage.e ku2 = af.cnI().ku(snsAdClick.cND);
                        String str = (com.tencent.mm.plugin.sns.a.b.f.a(snsAdClick.cND, snsAdClick, ku2.cqq().qPj, Integer.valueOf(snsAdClick.fPY), Long.valueOf(snsAdClick.startTime), Long.valueOf(System.currentTimeMillis())) + String.format(",%s", new Object[]{snsAdClick.fQc})) + String.format(",%s", new Object[]{((System.currentTimeMillis() - snsAdClick.startTime) - snsAdClick.fQe)});
                        if (ku2 == null || !ku2.coX()) {
                            af.cnz().e(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_READ_FAILED, str);
                        } else {
                            af.cnz().e(14643, str);
                        }
                        com.tencent.mm.modelsns.b lZ2 = com.tencent.mm.modelsns.b.lZ(733);
                        lZ2.tx(snsAdClick.cND).tx(ku2.cqq().qPj).mb(snsAdClick.fPY).tx(snsAdClick.startTime).tx(System.currentTimeMillis());
                        lZ2.ajK();
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsCore", e, "report ad click error", new Object[0]);
            }
            AppMethodBeat.o(36457);
            return false;
        }
    };
    private c qLY = new c<rt>() {
        {
            AppMethodBeat.i(36459);
            this.xxI = rt.class.getName().hashCode();
            AppMethodBeat.o(36459);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36461);
            boolean cnT = AnonymousClass25.cnT();
            AppMethodBeat.o(36461);
            return cnT;
        }

        private static boolean cnT() {
            AppMethodBeat.i(36460);
            com.tencent.mm.plugin.sns.lucky.a.g.cmv();
            ac.a aVar = ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKFULLSCREEN_STRING_SYNC;
            com.tencent.mm.plugin.sns.h.i iVar = new com.tencent.mm.plugin.sns.h.i();
            try {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(aVar, new String(iVar.toByteArray(), Charset.forName("ISO-8859-1")));
            } catch (IOException e) {
                ab.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
            }
            AppMethodBeat.o(36460);
            return false;
        }
    };
    private c qLZ = new c<bm>() {
        {
            AppMethodBeat.i(36462);
            this.xxI = bm.class.getName().hashCode();
            AppMethodBeat.o(36462);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36463);
            m cnJ = af.cnJ();
            System.currentTimeMillis();
            boolean hY = cnJ.bSd.hY("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';");
            ab.i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", "update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(hY));
            AppMethodBeat.o(36463);
            return false;
        }
    };
    private com.tencent.mm.plugin.sns.g.c qLa;
    private com.tencent.mm.plugin.sns.g.g qLb;
    private q qLc;
    private i qLd;
    private ao qLe = new ao();
    private boolean qLf = false;
    private boolean qLg = true;
    private w qLh = new w();
    private boolean qLi = false;
    private byte[] qLj = new byte[0];
    private String qLk;
    private com.tencent.mm.plugin.sns.d qLn;
    private com.tencent.mm.plugin.sns.f.a qLo;
    private ar qLp;
    private com.tencent.mm.plugin.sns.lucky.a.f qLq = new com.tencent.mm.plugin.sns.lucky.a.f();
    private com.tencent.mm.plugin.sns.lucky.a.j qLr = new com.tencent.mm.plugin.sns.lucky.a.j();
    private com.tencent.mm.plugin.sns.lucky.a.d qLs = new com.tencent.mm.plugin.sns.lucky.a.d();
    private l qLt = new l();
    private com.tencent.mm.plugin.sns.n qLx;
    private com.tencent.mm.plugin.sns.k qLy;
    private com.tencent.mm.plugin.sns.e qLz;
    private c qMa = new c<lr>() {
        {
            AppMethodBeat.i(36464);
            this.xxI = lr.class.getName().hashCode();
            AppMethodBeat.o(36464);
        }

        public final /* synthetic */ boolean a(b bVar) {
            String j;
            AppMethodBeat.i(36465);
            lr lrVar = (lr) bVar;
            if (lrVar.cHv.cvd == 1) {
                j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.cqn().j(lrVar.cHv.pageId, lrVar.cHv.cvq, lrVar.cHv.cHx, lrVar.cHv.cHy);
            } else {
                j = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.cqn().n(bo.anl(lrVar.cHv.pageId), lrVar.cHv.cHx, lrVar.cHv.cHy);
            }
            lrVar.cHw.cHz = j;
            AppMethodBeat.o(36465);
            return false;
        }
    };
    private boolean qMb = false;
    private c qMc = new c<rl>() {
        {
            AppMethodBeat.i(36469);
            this.xxI = rl.class.getName().hashCode();
            AppMethodBeat.o(36469);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36470);
            rl rlVar = (rl) bVar;
            if (rlVar instanceof rl) {
                com.tencent.mm.plugin.sns.lucky.a.b.kT(rlVar.cNu.key);
            }
            AppMethodBeat.o(36470);
            return false;
        }
    };
    private c qMd = new c<ow>() {
        {
            AppMethodBeat.i(36472);
            this.xxI = ow.class.getName().hashCode();
            AppMethodBeat.o(36472);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36473);
            ow owVar = (ow) bVar;
            final ArrayList arrayList = owVar.cLi.cLj;
            final String str = owVar.cLi.cLk;
            ab.i("MicroMsg.SnsCore", "ResendSnsByUpdateXmlEvent, try resend sns");
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36471);
                    am.e(arrayList, str);
                    AppMethodBeat.o(36471);
                }
            });
            AppMethodBeat.o(36473);
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.sns.model.af$4 */
    class AnonymousClass4 extends com.tencent.mm.memory.e.a {
        final int qMg = 120;

        AnonymousClass4(com.tencent.mm.memory.c cVar) {
            cVar.getClass();
            super();
            AppMethodBeat.i(36415);
            AppMethodBeat.o(36415);
        }

        public final long Xb() {
            return 10485760;
        }

        public final int Xc() {
            return -1;
        }

        public final /* synthetic */ Comparable Xa() {
            AppMethodBeat.i(36416);
            Integer valueOf = Integer.valueOf(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 120) * com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 120));
            AppMethodBeat.o(36416);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$5 */
    class AnonymousClass5 extends com.tencent.mm.memory.e.a {
        AnonymousClass5(com.tencent.mm.memory.o oVar) {
            oVar.getClass();
            super();
            AppMethodBeat.i(36417);
            AppMethodBeat.o(36417);
        }

        public final long Xb() {
            return -1;
        }

        public final int Xc() {
            return 3;
        }

        public final /* synthetic */ Comparable Xa() {
            AppMethodBeat.i(36418);
            com.tencent.mm.memory.o.b bVar = new com.tencent.mm.memory.o.b(320, 240);
            AppMethodBeat.o(36418);
            return bVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$6 */
    class AnonymousClass6 extends com.tencent.mm.memory.e.a {
        AnonymousClass6(com.tencent.mm.memory.g gVar) {
            gVar.getClass();
            super();
            AppMethodBeat.i(36419);
            AppMethodBeat.o(36419);
        }

        public final long Xb() {
            return 0;
        }

        public final int Xc() {
            return 5;
        }

        public final /* synthetic */ Comparable Xa() {
            AppMethodBeat.i(36420);
            Integer valueOf = Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(36420);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(36524);
        qLm.put(Integer.valueOf("CanvasInfo".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.sns.storage.d.fnj;
            }
        });
        qLm.put(Integer.valueOf("UxCanvasInfo".hashCode()), new d() {
            public final String[] Af() {
                return y.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return s.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        qLm.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return f.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return m.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return u.fnj;
            }
        });
        qLm.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return q.fnj;
            }
        });
        AppMethodBeat.o(36524);
    }

    public static String getAccPath() {
        AppMethodBeat.i(36474);
        com.tencent.mm.kernel.g.RN().QU();
        com.tencent.mm.kernel.g.RQ();
        String str = com.tencent.mm.kernel.g.RP().eJM;
        AppMethodBeat.o(36474);
        return str;
    }

    public static String cnk() {
        AppMethodBeat.i(36475);
        com.tencent.mm.kernel.g.RQ();
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, null);
        AppMethodBeat.o(36475);
        return str;
    }

    public static int cnl() {
        AppMethodBeat.i(36476);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN();
        int QF = com.tencent.mm.kernel.a.QF();
        AppMethodBeat.o(36476);
        return QF;
    }

    public static h Ru() {
        AppMethodBeat.i(36477);
        h hVar = cnm().eJN;
        AppMethodBeat.o(36477);
        return hVar;
    }

    private static af cnm() {
        AppMethodBeat.i(36478);
        af afVar = (af) com.tencent.mm.model.q.Y(af.class);
        if (!afVar.qLi) {
            synchronized (afVar.qLj) {
                try {
                    if (!afVar.qLi) {
                        ab.i("MicroMsg.SnsCore", "onAccInit because bug!");
                        afVar.bz(true);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(36478);
                    }
                }
            }
        }
        if (afVar.qLf) {
            synchronized (afVar.eMl) {
                try {
                    ab.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + afVar.hashCode());
                    if (afVar.qLf) {
                        afVar.qLg = false;
                        w wVar = afVar.qLh;
                        HashMap hashMap = qLm;
                        if (wVar.rfK) {
                            ab.i("MicroMsg.TrimSnsDb", "pass hasTrim");
                        } else {
                            com.tencent.mm.kernel.g.RQ();
                            if (com.tencent.mm.kernel.g.RN().QY()) {
                                int i = bo.getInt(com.tencent.mm.m.g.Nu().getValue("AndroidCleanSnsDb"), 0);
                                ab.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
                                if (i <= 0) {
                                    com.tencent.mm.kernel.g.RQ();
                                    String str = com.tencent.mm.kernel.g.RP().cachePath;
                                    if (e.ct(str + "SnsMicroMsg2.db.ini")) {
                                        w.Zq(str);
                                        e.deleteFile(str + "SnsMicroMsg2.db.ini");
                                    }
                                    SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
                                    if (bo.fp(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                        ab.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                                    } else {
                                        sharedPreferences.edit().putLong("check_trim_time", bo.anT()).commit();
                                        wVar.rfK = true;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        int On = com.tencent.mm.q.a.On();
                                        if (On == 1 || On == 2) {
                                            ab.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                        } else {
                                            if (e.ct(str + "sns_mark.ini")) {
                                                if (bo.gb(e.ata(str + "sns_mark.ini")) < 2592000000L) {
                                                    ab.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                                    w.Zq(str);
                                                } else {
                                                    e.deleteFile(str + "sns_mark.ini");
                                                }
                                            }
                                            long asZ = e.asZ(str + "SnsMicroMsg.db");
                                            ab.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(asZ)));
                                            if (asZ < 52428800) {
                                                ab.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                            } else {
                                                e.atc(str + "sns_mark.ini");
                                                String str2 = str + "SnsMicroMsg2.db";
                                                h hVar = new h();
                                                com.tencent.mm.model.b bVar;
                                                if (hVar.b(str2, null, false)) {
                                                    h hVar2 = new h();
                                                    if (hVar2.b(str + "SnsMicroMsg.db", hashMap, true)) {
                                                        long currentTimeMillis2;
                                                        long currentTimeMillis3 = System.currentTimeMillis();
                                                        if (w.a(hVar2, hVar)) {
                                                            currentTimeMillis2 = System.currentTimeMillis();
                                                            str2 = "snsExtInfo3";
                                                            w.a(hVar2, hVar, str2);
                                                            ab.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + hVar.hY("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                            str2 = "SnsComment";
                                                            w.a(hVar2, hVar, str2);
                                                            ab.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + hVar.hY("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                            str2 = "SnsInfo";
                                                            w.a(hVar2, hVar, str2);
                                                            ab.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + hVar.hY("", "insert into " + str2 + " select * from old." + str2 + " where  (sourceType & 2 != 0 ) " + o.rfn + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                            boolean hY = hVar.hY("", "update snsExtinfo3 set md5 = '', faults = '';");
                                                            ab.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Boolean.valueOf(hY));
                                                            hVar.hY("", "DETACH DATABASE old");
                                                            On = 1;
                                                        } else {
                                                            On = -1;
                                                        }
                                                        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis3;
                                                        ab.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(On)), Long.valueOf(currentTimeMillis2));
                                                        hVar2.closeDB();
                                                        hVar.closeDB();
                                                        if (On >= 0) {
                                                            com.tencent.mm.kernel.g.RQ();
                                                            String str3 = com.tencent.mm.kernel.g.RP().cachePath;
                                                            e.deleteFile(str3 + "SnsMicroMsg.db");
                                                            ab.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(e.h(str3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
                                                            e.deleteFile(str3 + "SnsMicroMsg.db-shm");
                                                            e.deleteFile(str3 + "SnsMicroMsg.db-wal");
                                                            e.deleteFile(str3 + "SnsMicroMsg.db.ini");
                                                            e.y("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                            e.deleteFile(str3 + "SnsMicroMsg2.db.ini");
                                                            e.deleteFile(str3 + "SnsMicroMsg2.db");
                                                            e.deleteFile(str3 + "sns_mark.ini");
                                                        }
                                                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                        ab.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", Integer.valueOf(On), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis4 - currentTimeMillis2));
                                                        ab.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                                    } else {
                                                        bVar = new com.tencent.mm.model.b((byte) 0);
                                                        AppMethodBeat.o(36478);
                                                        throw bVar;
                                                    }
                                                }
                                                bVar = new com.tencent.mm.model.b((byte) 0);
                                                AppMethodBeat.o(36478);
                                                throw bVar;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (afVar.eJN == null) {
                            afVar.eJN = new h();
                            com.tencent.mm.kernel.g.RQ();
                            if (!afVar.eJN.b(com.tencent.mm.kernel.g.RP().cachePath + "SnsMicroMsg.db", qLm, true)) {
                                Object sQLiteException = new SQLiteException("sns db init failed");
                                throw sQLiteException;
                            }
                        }
                        afVar.qLf = false;
                        ab.i("MicroMsg.SnsCore", "resetdb done");
                    }
                } finally {
                    AppMethodBeat.o(36478);
                }
            }
        }
        AppMethodBeat.o(36478);
        return afVar;
    }

    public static boolean cnn() {
        AppMethodBeat.i(36479);
        cnm();
        if (com.tencent.mm.kernel.g.RN().QY()) {
            AppMethodBeat.o(36479);
            return false;
        }
        AppMethodBeat.o(36479);
        return true;
    }

    public af() {
        AppMethodBeat.i(36480);
        ab.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        if (this.qKI == null) {
            this.qKI = com.tencent.mm.sdk.g.c.d.a("SnsCore_CDNDownload_handler", new LinkedBlockingQueue());
        }
        if (this.qKH == null) {
            this.qKH = com.tencent.mm.sdk.g.c.d.a("SnsCore_thumbDecode_handler", new LinkedBlockingQueue());
        }
        if (this.qKG == null) {
            this.qKG = com.tencent.mm.sdk.g.c.d.anP("SnsCore#File");
        }
        if (this.qKJ == null) {
            this.qKJ = com.tencent.mm.sdk.g.c.d.anP("SnsCore#Task");
        }
        int largeMemoryClass = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        if (largeMemoryClass > 256) {
            if (VERSION.SDK_INT == 24 || VERSION.SDK_INT == 25) {
                largeMemoryClass = 3;
            } else {
                largeMemoryClass = 6;
            }
        } else if (largeMemoryClass > 128) {
            largeMemoryClass = 4;
        } else {
            largeMemoryClass = 2;
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36414);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_timeline_item_photo_one3", largeMemoryClass, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_timeline_imagesline_one", largeMemoryClass, R.id.ehw, R.layout.awt, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_timeline_imagesline1", largeMemoryClass, R.id.ehw, R.layout.awq, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_timeline_imagesline2", largeMemoryClass, R.id.ehw, R.layout.awr, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_timeline_imagesline3", largeMemoryClass, R.id.ehw, R.layout.aws, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_media_sub_item2", largeMemoryClass, R.id.ehw, R.layout.avr, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_media_sight_item", largeMemoryClass, R.id.ehw, R.layout.avp, R.id.en5, 0);
                com.tencent.mm.kiss.a.b.SM().a("R.layout.sns_hb_reward_item", largeMemoryClass, R.id.ehw, R.layout.ava, R.id.en5, 0);
                AppMethodBeat.o(36414);
            }
        }, 3000);
        AppMethodBeat.o(36480);
    }

    public static ak cno() {
        AppMethodBeat.i(36481);
        if (qLu == null) {
            qLu = new ak("MicroMsg.SnsCore#WorkingHandler");
        }
        ak akVar = qLu;
        AppMethodBeat.o(36481);
        return akVar;
    }

    public static a cnp() {
        AppMethodBeat.i(36482);
        a aVar = cnm().qKI;
        AppMethodBeat.o(36482);
        return aVar;
    }

    public static a cnq() {
        AppMethodBeat.i(36483);
        a aVar = cnm().qKH;
        AppMethodBeat.o(36483);
        return aVar;
    }

    protected static a cnr() {
        AppMethodBeat.i(36484);
        a aVar = cnm().qKG;
        AppMethodBeat.o(36484);
        return aVar;
    }

    public static a cns() {
        AppMethodBeat.i(36485);
        a aVar = cnm().qKJ;
        AppMethodBeat.o(36485);
        return aVar;
    }

    public static ak bCo() {
        AppMethodBeat.i(36486);
        ak akVar = cnm().handler;
        AppMethodBeat.o(36486);
        return akVar;
    }

    public static String getAccSnsPath() {
        AppMethodBeat.i(36487);
        String accSnsPath = ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
        AppMethodBeat.o(36487);
        return accSnsPath;
    }

    public static String getAccSnsTmpPath() {
        AppMethodBeat.i(36488);
        String accSnsTmpPath = ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
        AppMethodBeat.o(36488);
        return accSnsTmpPath;
    }

    public static bd cnt() {
        AppMethodBeat.i(36489);
        com.tencent.mm.kernel.g.RQ();
        bd XM = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM();
        AppMethodBeat.o(36489);
        return XM;
    }

    public static s cnu() {
        AppMethodBeat.i(36490);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKM == null) {
            cnm().qKM = new s(cnm().eJN);
        }
        s sVar = cnm().qKM;
        AppMethodBeat.o(36490);
        return sVar;
    }

    public static am.a cnv() {
        AppMethodBeat.i(36491);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKW == null) {
            cnm().qKW = new am.a();
            com.tencent.mm.plugin.sns.b.n.qFC = cnm().qKW;
        }
        am.a aVar = cnm().qKW;
        AppMethodBeat.o(36491);
        return aVar;
    }

    public static com.tencent.mm.plugin.sns.g.c cnw() {
        AppMethodBeat.i(36492);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qLa == null) {
            cnm().qLa = new com.tencent.mm.plugin.sns.g.c();
        }
        com.tencent.mm.plugin.sns.g.c cVar = cnm().qLa;
        AppMethodBeat.o(36492);
        return cVar;
    }

    public static com.tencent.mm.plugin.sns.g.g cnx() {
        AppMethodBeat.i(36493);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qLb == null) {
            cnm().qLb = new com.tencent.mm.plugin.sns.g.g();
        }
        com.tencent.mm.plugin.sns.g.g gVar = cnm().qLb;
        AppMethodBeat.o(36493);
        return gVar;
    }

    public static q cny() {
        AppMethodBeat.i(36494);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qLc == null) {
            cnm().qLc = new q(cnm().eJN);
        }
        q qVar = cnm().qLc;
        AppMethodBeat.o(36494);
        return qVar;
    }

    public static i cnz() {
        AppMethodBeat.i(36495);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qLd == null) {
            cnm().qLd = new i();
        }
        i iVar = cnm().qLd;
        AppMethodBeat.o(36495);
        return iVar;
    }

    public static b cnA() {
        AppMethodBeat.i(36496);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKX == null) {
            cnm().qKX = new b();
        }
        b bVar = cnm().qKX;
        AppMethodBeat.o(36496);
        return bVar;
    }

    public static aw cnB() {
        AppMethodBeat.i(36497);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKY == null) {
            cnm().qKY = new aw();
            com.tencent.mm.plugin.sns.b.n.qFw = cnm().qKY;
        }
        aw awVar = cnm().qKY;
        AppMethodBeat.o(36497);
        return awVar;
    }

    public static g cnC() {
        AppMethodBeat.i(36498);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKR == null) {
            cnm().qKR = new g();
            com.tencent.mm.plugin.sns.b.n.qFx = cnm().qKR;
        }
        g gVar = cnm().qKR;
        AppMethodBeat.o(36498);
        return gVar;
    }

    public static ar cnD() {
        AppMethodBeat.i(36499);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qLp == null) {
            cnm().qLp = new ar();
        }
        ar arVar = cnm().qLp;
        AppMethodBeat.o(36499);
        return arVar;
    }

    public static ad cnE() {
        AppMethodBeat.i(36500);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKV == null) {
            af cnm = cnm();
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.RQ();
            cnm.qKV = new ad(stringBuilder.append(com.tencent.mm.kernel.g.RP().cachePath).append("snsAsyncQueue.data").toString());
        }
        ad adVar = cnm().qKV;
        AppMethodBeat.o(36500);
        return adVar;
    }

    public static o cnF() {
        AppMethodBeat.i(36501);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKN == null) {
            cnm().qKN = new o(cnm().eJN);
            com.tencent.mm.plugin.sns.b.n.qFD = cnm().qKN;
        }
        o oVar = cnm().qKN;
        AppMethodBeat.o(36501);
        return oVar;
    }

    public static com.tencent.mm.plugin.sns.storage.d cnG() {
        AppMethodBeat.i(36502);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKP == null) {
            cnm().qKP = new com.tencent.mm.plugin.sns.storage.d(cnm().eJN);
        }
        com.tencent.mm.plugin.sns.storage.d dVar = cnm().qKP;
        AppMethodBeat.o(36502);
        return dVar;
    }

    public static y cnH() {
        AppMethodBeat.i(36503);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKQ == null) {
            cnm().qKQ = new y(cnm().eJN);
        }
        y yVar = cnm().qKQ;
        AppMethodBeat.o(36503);
        return yVar;
    }

    public static f cnI() {
        AppMethodBeat.i(36504);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKO == null) {
            cnm().qKO = new f(cnm().eJN);
        }
        f fVar = cnm().qKO;
        AppMethodBeat.o(36504);
        return fVar;
    }

    public static m cnJ() {
        AppMethodBeat.i(36505);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKS == null) {
            cnm().qKS = new m(cnm().eJN, new ah());
            com.tencent.mm.plugin.sns.b.n.qFy = cnm().qKS;
        }
        m mVar = cnm().qKS;
        AppMethodBeat.o(36505);
        return mVar;
    }

    public static k cnK() {
        AppMethodBeat.i(36506);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKT == null) {
            cnm().qKT = new k(cnm().eJN);
            com.tencent.mm.plugin.sns.b.n.qFz = cnm().qKT;
        }
        k kVar = cnm().qKT;
        AppMethodBeat.o(36506);
        return kVar;
    }

    public static u cnL() {
        AppMethodBeat.i(36507);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKU == null) {
            cnm().qKU = new u(cnm().eJN);
            com.tencent.mm.plugin.sns.b.n.qFA = cnm().qKU;
        }
        u uVar = cnm().qKU;
        AppMethodBeat.o(36507);
        return uVar;
    }

    public static ai cnM() {
        AppMethodBeat.i(36508);
        com.tencent.mm.kernel.g.RN().QU();
        if (cnm().qKZ == null) {
            cnm().qKZ = new ai();
        }
        ai aiVar = cnm().qKZ;
        AppMethodBeat.o(36508);
        return aiVar;
    }

    public static int cnN() {
        int i;
        AppMethodBeat.i(36509);
        if (bPg().y < bPg().x) {
            i = bPg().y;
        } else {
            i = bPg().x - com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), qLv);
        }
        i /= 3;
        qKK = i;
        if (i <= 10) {
            ab.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
            AppMethodBeat.o(36509);
            return 150;
        }
        i = qKK;
        AppMethodBeat.o(36509);
        return i;
    }

    public static int cnO() {
        AppMethodBeat.i(36510);
        if (qKL <= 0) {
            qKL = 200;
            qKL = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), qKL);
        }
        int i = qKL;
        AppMethodBeat.o(36510);
        return i;
    }

    private static Point bPg() {
        AppMethodBeat.i(36511);
        WindowManager windowManager = (WindowManager) ah.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        qLw.x = displayMetrics.widthPixels;
        qLw.y = displayMetrics.heightPixels;
        Point point = qLw;
        AppMethodBeat.o(36511);
        return point;
    }

    public static boolean cnP() {
        boolean z;
        AppMethodBeat.i(36512);
        SharedPreferences s = ar.s(ah.getContext(), "sp_sns_dynswitch_stg", 4);
        if (s.contains("st_sw_use_vcodec_img")) {
            z = s.getBoolean("st_sw_use_vcodec_img", false);
            ab.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", Boolean.valueOf(z));
        } else {
            z = s.getBoolean("sw_use_vcodec_img", false);
            ab.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", Boolean.valueOf(z));
        }
        AppMethodBeat.o(36512);
        return z;
    }

    public static boolean cnQ() {
        boolean z;
        AppMethodBeat.i(36513);
        SharedPreferences s = ar.s(ah.getContext(), "sp_sns_dynswitch_stg", 4);
        if (s.contains("st_sw_use_wxpc_img")) {
            z = s.getBoolean("st_sw_use_wxpc_img", false);
            ab.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", Boolean.valueOf(z));
        } else {
            z = s.getBoolean("sw_use_wxpc_img", false);
            ab.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", Boolean.valueOf(z));
        }
        AppMethodBeat.o(36513);
        return z;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(36514);
        com.tencent.mm.ai.f cnz = cnz();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1802, cnz);
        ao aoVar = this.qLe;
        com.tencent.mm.sdk.b.a.xxA.d(aoVar.qML);
        com.tencent.mm.sdk.b.a.xxA.d(aoVar.qMM);
        com.tencent.mm.sdk.b.a.xxA.d(aoVar.qMN);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLZ);
        com.tencent.mm.sdk.b.a.xxA.d(this.qMa);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLY);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLX);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLM);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLK);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLL);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLN);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLO);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLP);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLA);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLB);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLR);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLT);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLx);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLy);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLz);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLC);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLD);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLE);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLF);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLG);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLH);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLn);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLU);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLV);
        com.tencent.mm.sdk.b.a.xxA.d(this.oMA);
        com.tencent.mm.sdk.b.a.xxA.d(this.qMc);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLW);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLI);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLJ);
        com.tencent.mm.sdk.b.a.xxA.d(this.qMd);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLS);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e.qVH;
        if (aVar.qVA) {
            try {
                ah.getContext().unregisterReceiver(aVar.qVz);
                aVar.qVA = false;
            } catch (IllegalArgumentException e) {
                ab.e("MicroMsg.AdDownloadApkMgr", "unregister install receiver exception", e.getMessage());
            }
        }
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(aVar.qVE);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewYearSNSCtrl2016", this.qLq, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewYearSNSTips2016", this.qLr, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewYearSNSAmountLevelCtrl2016", this.qLs, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("SnsAd", this.qLt, true);
        cnz = cnB();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(207, cnz);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(209, cnz);
        af afVar = (af) com.tencent.mm.model.q.Y(af.class);
        if (afVar != null) {
            ab.d("MicroMsg.SnsCore", "SnsCore close db");
            if (afVar.eJN != null) {
                afVar.eJN.closeDB();
                afVar.eJN = null;
            }
            if (afVar.qKI != null) {
                afVar.qKI.reset();
            }
            if (afVar.qKH != null) {
                afVar.qKH.reset();
            }
            if (afVar.qKG != null) {
                afVar.qKG.reset();
            }
            if (afVar.qKJ != null) {
                afVar.qKJ.reset();
            }
        }
        b.b bVar = this.qLo;
        cnA().b(bVar);
        com.tencent.mm.sdk.b.a.xxA.d(bVar.qGl);
        ap.aon();
        com.tencent.mm.memory.g.fdE.WY();
        com.tencent.mm.memory.c.fdx.WY();
        com.tencent.mm.memory.o.fdT.WY();
        ar cnD = cnD();
        cnD.qMW = null;
        cnD.fWa = null;
        cnD.qMY.clear();
        cnD.qMX.clear();
        synchronized (cnD.qMZ) {
            try {
                cnD.qMZ.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36514);
            }
        }
        com.tencent.mm.sdk.b.a.xxA.d(cnD.qNa);
        com.tencent.mm.sdk.b.a.xxA.d(cnD.qMM);
        com.tencent.mm.sdk.b.a.xxA.d(cnD.qMN);
        com.tencent.mm.plugin.sns.e.a.destroy();
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(36515);
        ab.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.qLi);
        if (this.qLi) {
            AppMethodBeat.o(36515);
            return;
        }
        this.qLi = true;
        this.qLf = true;
        e.tf(getAccPath() + "sfs");
        this.qLk = getAccSnsPath();
        checkDir();
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.qLq, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.qLr, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.qLs, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("SnsAd", this.qLt, true);
        com.tencent.mm.plugin.sns.b.n.qFw = cnB();
        com.tencent.mm.plugin.sns.b.n.qFx = cnC();
        com.tencent.mm.plugin.sns.b.n.qFy = cnJ();
        com.tencent.mm.plugin.sns.b.n.qFz = cnK();
        com.tencent.mm.plugin.sns.b.n.qFA = cnL();
        com.tencent.mm.plugin.sns.b.n.qFC = cnv();
        com.tencent.mm.plugin.sns.b.n.qFB = this;
        com.tencent.mm.plugin.sns.b.n.qFD = cnF();
        com.tencent.mm.sdk.b.a.xxA.c(this.qLZ);
        com.tencent.mm.sdk.b.a.xxA.c(this.qMa);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLM);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLK);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLL);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLN);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLO);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLP);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLR);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLT);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLU);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLV);
        com.tencent.mm.sdk.b.a.xxA.c(this.qMd);
        this.qLx = new com.tencent.mm.plugin.sns.n();
        this.qLy = new com.tencent.mm.plugin.sns.k();
        this.qLz = new com.tencent.mm.plugin.sns.e();
        this.qLA = new p();
        this.qLB = new com.tencent.mm.plugin.sns.h();
        this.qLC = new com.tencent.mm.plugin.sns.g();
        this.qLD = new com.tencent.mm.plugin.sns.m();
        this.qLE = new com.tencent.mm.plugin.sns.j();
        this.qLF = new com.tencent.mm.plugin.sns.b();
        this.qLG = new com.tencent.mm.plugin.sns.c();
        this.qLH = new com.tencent.mm.plugin.sns.f();
        com.tencent.mm.sdk.b.a.xxA.c(this.qLY);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLX);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLA);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLx);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLy);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLz);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLB);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLC);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLD);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLE);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLF);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLG);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLH);
        com.tencent.mm.sdk.b.a.xxA.c(this.oMA);
        this.qLn = new com.tencent.mm.plugin.sns.d();
        com.tencent.mm.sdk.b.a.xxA.c(this.qLn);
        com.tencent.mm.sdk.b.a.xxA.c(this.qMc);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLI);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLJ);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLW);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLS);
        cnz().start();
        cnB().start();
        this.qLe.start();
        this.qLo = new com.tencent.mm.plugin.sns.f.a();
        ap.init();
        com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.fQs;
        com.tencent.mm.modelsns.c.ajL();
        if (com.tencent.mm.memory.l.Xg()) {
            com.tencent.mm.memory.c cVar2 = com.tencent.mm.memory.c.fdx;
            com.tencent.mm.memory.c cVar3 = com.tencent.mm.memory.c.fdx;
            cVar3.getClass();
            cVar2.a((com.tencent.mm.memory.e.a) new AnonymousClass4(cVar3));
        }
        com.tencent.mm.memory.o oVar = com.tencent.mm.memory.o.fdT;
        com.tencent.mm.memory.o oVar2 = com.tencent.mm.memory.o.fdT;
        oVar2.getClass();
        oVar.a((com.tencent.mm.memory.e.a) new AnonymousClass5(oVar2));
        com.tencent.mm.memory.g gVar = com.tencent.mm.memory.g.fdE;
        com.tencent.mm.memory.g gVar2 = com.tencent.mm.memory.g.fdE;
        gVar2.getClass();
        gVar.a((com.tencent.mm.memory.e.a) new AnonymousClass6(gVar2));
        cnD();
        com.tencent.mm.plugin.sns.e.a.init();
        AppMethodBeat.o(36515);
    }

    private static void checkDir() {
        AppMethodBeat.i(36516);
        e.tf(((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath());
        e.tf(((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath());
        AppMethodBeat.o(36516);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(36517);
        e.tf(getAccPath() + "sfs");
        checkDir();
        AppMethodBeat.o(36517);
    }

    public final void a(com.tencent.mm.model.ar arVar) {
        AppMethodBeat.i(36518);
        u.a(arVar);
        AppMethodBeat.o(36518);
    }

    public final void b(com.tencent.mm.model.ar arVar) {
        AppMethodBeat.i(36519);
        u.b(arVar);
        AppMethodBeat.o(36519);
    }

    public static String cnR() {
        AppMethodBeat.i(36520);
        if (bo.isNullOrNil(qLl)) {
            Iterator it = com.tencent.mm.sdk.platformtools.bd.dpo().iterator();
            while (it.hasNext()) {
                com.tencent.mm.sdk.platformtools.bd.a aVar = (com.tencent.mm.sdk.platformtools.bd.a) it.next();
                if (com.tencent.mm.compatible.util.e.eSl.equals(aVar.xBt)) {
                    qLl = aVar.xBu;
                    break;
                }
            }
            ab.i("MicroMsg.SnsCore", "get filesys " + qLl);
        }
        String bc = bo.bc(qLl, "");
        AppMethodBeat.o(36520);
        return bc;
    }

    static /* synthetic */ void cnS() {
        int i;
        int i2;
        int i3;
        AppMethodBeat.i(36522);
        ab.i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        o cnF = cnF();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = cnF.bSd.a("select count(*) from SnsInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        ab.i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        s cnu = cnu();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor a2 = cnu.fni.a("select count(*) from SnsMedia", null, 2);
        if (a2.moveToFirst()) {
            i2 = a2.getInt(0);
        } else {
            i2 = 0;
        }
        a2.close();
        ab.i("MicroMsg.snsMediaStorage", "media table count %d passed %d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        m cnJ = cnJ();
        currentTimeMillis2 = System.currentTimeMillis();
        a = cnJ.bSd.a("select count(*) from snsExtInfo3", null, 2);
        if (a.moveToFirst()) {
            i3 = a.getInt(0);
        } else {
            i3 = 0;
        }
        a.close();
        ab.i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        stringBuffer.append(" snscount ".concat(String.valueOf(i)));
        stringBuffer.append(" mediacount ".concat(String.valueOf(i2)));
        stringBuffer.append(" extcount ".concat(String.valueOf(i3)));
        ab.i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
        AppMethodBeat.o(36522);
    }
}
