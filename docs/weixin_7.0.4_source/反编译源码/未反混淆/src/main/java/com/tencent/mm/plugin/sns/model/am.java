package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.m.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class am {
    private static final int qMw = g.Nu().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);

    public static class a implements f, h {
        public static int qMx = -1;
        private Map<com.tencent.mm.plugin.sns.b.h.a, String> ftE = new HashMap();
        private int qMA = 0;
        public long qMB = 0;
        private LinkedList<String> qMC = new LinkedList();
        public Map<String, ArrayList<b>> qMD = new HashMap();
        public Map<String, Integer> qME = new HashMap();
        private Map<String, Long> qMy = new HashMap();
        private Map<String, Integer> qMz = new HashMap();

        public a() {
            AppMethodBeat.i(36572);
            AppMethodBeat.o(36572);
        }

        public final void j(String str, ArrayList<b> arrayList) {
            AppMethodBeat.i(36573);
            this.qMD.put(str, arrayList);
            AppMethodBeat.o(36573);
        }

        public final ArrayList<b> Yb(String str) {
            AppMethodBeat.i(36574);
            if (this.qME.containsKey(str)) {
                this.qME.put(str, Integer.valueOf(((Integer) this.qME.get(str)).intValue() + 1));
            } else {
                this.qME.put(str, Integer.valueOf(0));
            }
            ArrayList arrayList = (ArrayList) this.qMD.get(str);
            AppMethodBeat.o(36574);
            return arrayList;
        }

        public final Intent e(Intent intent, String str) {
            AppMethodBeat.i(36575);
            intent.putExtra("sns_userName", str);
            if (this.qMC == null || !this.qMC.contains(str)) {
                AppMethodBeat.o(36575);
            } else {
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                AppMethodBeat.o(36575);
            }
            return intent;
        }

        public final void a(int i, String str, com.tencent.mm.plugin.sns.b.h.a aVar) {
            AppMethodBeat.i(36576);
            ab.i("MicroMsg.SnsService", "startServer " + i + " " + aVar);
            af.cnE().ecX = r.Yz();
            af.cnE().cnf();
            af.cnB().cmp();
            if (this.ftE.isEmpty()) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(211, (f) this);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(212, (f) this);
            }
            if (!this.ftE.containsKey(aVar)) {
                if (i == 1) {
                    this.ftE.put(aVar, "@__weixintimtline");
                } else if (i == 2 || i == 3) {
                    this.ftE.put(aVar, str);
                } else if (i == 4) {
                    this.ftE.put(aVar, "@__classify_timeline");
                } else if (i == 5) {
                    this.ftE.put(aVar, "");
                } else {
                    this.ftE.put(aVar, "");
                }
            }
            switch (i) {
                case 1:
                    this.qMB = 0;
                    this.qMA = cod();
                    y.XP("@__weixintimtline");
                    break;
                case 2:
                    synchronized (this.qMy) {
                        try {
                            this.qMy.put(str, Long.valueOf(0));
                        } finally {
                            while (true) {
                                AppMethodBeat.o(36576);
                                break;
                            }
                        }
                    }
                    synchronized (this.qMz) {
                        try {
                            if (!this.qMz.containsKey(str)) {
                                this.qMz.put(str, Integer.valueOf(cod()));
                            }
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(36576);
                                break;
                            }
                        }
                    }
                    aa.XS(str);
                    this.qMC.add(str);
                    return;
            }
            AppMethodBeat.o(36576);
        }

        public final boolean a(com.tencent.mm.plugin.sns.b.h.a aVar, int i) {
            AppMethodBeat.i(36577);
            ab.d("MicroMsg.SnsService", "closeServer");
            this.ftE.remove(aVar);
            if (i == 2 && this.qMC.size() > 0) {
                this.qMC.removeLast();
            }
            if (this.ftE.isEmpty()) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.b(211, (f) this);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.b(212, (f) this);
                an.release();
                n.release();
                new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36571);
                        a.a(a.this);
                        AppMethodBeat.o(36571);
                    }
                }, 5000);
                aj.cnW();
                ab.i("MicroMsg.SnsService", "close finish");
            }
            AppMethodBeat.o(36577);
            return true;
        }

        public final void b(int i, String str, boolean z, int i2) {
            AppMethodBeat.i(36578);
            if (ae.gig) {
                AppMethodBeat.o(36578);
                return;
            }
            synchronized (this.qMy) {
                try {
                    ab.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", str, Integer.valueOf(i), Long.valueOf(this.qMB), this.qMy);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(36578);
                }
            }
            if (i == 2) {
                if (aa.XR(str)) {
                    long j = 0;
                    synchronized (this.qMy) {
                        try {
                            if (this.qMy.containsKey(str)) {
                                j = ((Long) this.qMy.get(str)).longValue();
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(36578);
                        }
                    }
                    if (j == 0) {
                        aa.XS(str);
                        return;
                    }
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.a(new aa(str, j, z, i2), 0);
                    AppMethodBeat.o(36578);
                }
            } else if (i != 1) {
                if (i != 3 && i == 4) {
                    if (!n.XO("@__classify_timeline")) {
                        AppMethodBeat.o(36578);
                        return;
                    } else if (this.qMB == 0) {
                        n.XP("@__classify_timeline");
                        AppMethodBeat.o(36578);
                        return;
                    } else {
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RO().eJo.a(new n(""), 0);
                    }
                }
                AppMethodBeat.o(36578);
            } else if (!y.XO("@__weixintimtline")) {
                AppMethodBeat.o(36578);
            } else if (this.qMB == 0) {
                y.XP("@__weixintimtline");
                AppMethodBeat.o(36578);
            } else {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new y(this.qMB), 0);
                AppMethodBeat.o(36578);
            }
        }

        public final void a(int i, String str, boolean z, int i2) {
            AppMethodBeat.i(36579);
            if (ae.gig) {
                AppMethodBeat.o(36579);
                return;
            }
            ab.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", Integer.valueOf(i), str);
            if (i == 2) {
                if (aa.XR(str)) {
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.a(new aa(str, 0, z, i2), 0);
                    AppMethodBeat.o(36579);
                    return;
                }
                AppMethodBeat.o(36579);
            } else if (i != 1) {
                if (i != 3 && i == 4) {
                    if (n.XO("@__classify_timeline")) {
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RO().eJo.a(new n(""), 0);
                    } else {
                        AppMethodBeat.o(36579);
                        return;
                    }
                }
                AppMethodBeat.o(36579);
            } else if (y.XO("@__weixintimtline")) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(68377, (Object) "");
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new y(0), 0);
                AppMethodBeat.o(36579);
            } else {
                AppMethodBeat.o(36579);
            }
        }

        public final int Yc(String str) {
            int intValue;
            AppMethodBeat.i(36580);
            synchronized (this.qMz) {
                try {
                    if (this.qMz.containsKey(str)) {
                        intValue = ((Integer) this.qMz.get(str)).intValue();
                        if (intValue <= 0) {
                            intValue = i.cmr();
                        }
                    } else {
                        intValue = i.cmr();
                        AppMethodBeat.o(36580);
                        return intValue;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(36580);
                }
            }
            return intValue;
        }

        public final int cod() {
            AppMethodBeat.i(36581);
            int i;
            if (this.qMA > 0) {
                i = this.qMA;
                AppMethodBeat.o(36581);
                return i;
            }
            i = i.cmr();
            AppMethodBeat.o(36581);
            return i;
        }

        public final void B(long j, int i) {
            AppMethodBeat.i(36582);
            ab.d("MicroMsg.SnsService", "setTimeLastId %d", Long.valueOf(j));
            if (i > 0) {
                this.qMA = i;
                i.CN(i);
            }
            if (j == 0) {
                AppMethodBeat.o(36582);
                return;
            }
            this.qMB = j;
            AppMethodBeat.o(36582);
        }

        public static int coe() {
            AppMethodBeat.i(36583);
            int i;
            if (qMx != -1) {
                i = qMx;
                AppMethodBeat.o(36583);
                return i;
            }
            i = i.cmq();
            qMx = i;
            AppMethodBeat.o(36583);
            return i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            Object obj;
            AppMethodBeat.i(36584);
            ab.i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType());
            if (!((i == 4 && i2 == 207) || (i == 4 && i2 == 203))) {
                if (i == 4 && (i2 == 2001 || i2 == 2004 || i2 == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS)) {
                    obj = 1;
                    if (obj != null) {
                    }
                } else if (i == 4 && (i2 == 2001 || i2 == 2003)) {
                    obj = 1;
                    if (obj != null) {
                    }
                } else if (!(i == 0 && i2 == 0)) {
                    obj = null;
                    if (obj != null) {
                        AppMethodBeat.o(36584);
                        return;
                    }
                    int i3;
                    switch (mVar.getType()) {
                        case 211:
                            y yVar = (y) mVar;
                            B(yVar.qIY, yVar.qJa);
                            i3 = yVar.qJb;
                            if (qMx != i3) {
                                i.CM(i3);
                            }
                            qMx = i3;
                            break;
                        case 212:
                            aa aaVar = (aa) mVar;
                            String str2 = aaVar.userName;
                            long j = aaVar.qIY;
                            i3 = aaVar.qJa;
                            if (i3 > 0) {
                                synchronized (this.qMz) {
                                    try {
                                        this.qMz.put(str2, Integer.valueOf(i3));
                                    } catch (Throwable th) {
                                        while (true) {
                                            AppMethodBeat.o(36584);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (j != 0) {
                                synchronized (this.qMy) {
                                    try {
                                        this.qMy.put(str2, Long.valueOf(j));
                                    } catch (Throwable th2) {
                                        AppMethodBeat.o(36584);
                                    }
                                }
                                break;
                            }
                            break;
                    }
                    if (mVar.getType() == 212 || mVar.getType() == 211) {
                        d dVar = (d) mVar;
                        Iterator it = new ArrayList(this.ftE.keySet()).iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.sns.b.h.a aVar = (com.tencent.mm.plugin.sns.b.h.a) it.next();
                            if (this.ftE.containsKey(aVar)) {
                                String str3 = (String) this.ftE.get(aVar);
                                if (dVar.getUserName().equals(str3)) {
                                    ab.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(str3)));
                                    String jW = dVar.cmQ() == 0 ? "" : i.jW(dVar.cmQ());
                                    boolean cmN;
                                    boolean cmR;
                                    boolean z;
                                    if (dVar.cmM()) {
                                        boolean cmO = dVar.cmO();
                                        cmN = dVar.cmN();
                                        cmR = dVar.cmR();
                                        z = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003 || i2 == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || i2 == 203);
                                        aVar.a(cmO, cmN, jW, cmR, z, i2, dVar.cmS(), dVar.cmT());
                                    } else {
                                        cmN = dVar.cmN();
                                        cmR = dVar.cmP();
                                        if (i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003 || i2 == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || i2 == 203)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        aVar.a(cmN, jW, cmR, z, i2, dVar.cmS(), dVar.cmT());
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(36584);
                    return;
                }
            }
            obj = 1;
            if (obj != null) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void Yd(String str) {
            AppMethodBeat.i(36585);
            ad cnE = af.cnE();
            if (bo.isNullOrNil(cnE.ecX)) {
                cnE.ecX = r.Yz();
            }
            String str2 = cnE.ecX;
            n YS = com.tencent.mm.plugin.sns.storage.h.YS(str);
            try {
                cbf cbf = (cbf) new cbf().parseFrom(YS.field_attrBuf);
                Iterator it = cbf.xaq.iterator();
                while (it.hasNext()) {
                    cat cat = (cat) it.next();
                    if (cat.vHl.equals(str2)) {
                        cbf.xaq.remove(cat);
                        cbf.xao--;
                        YS.field_attrBuf = cbf.toByteArray();
                        if (YS.DI(32)) {
                            af.cnI().a(YS.crd());
                        } else {
                            af.cnF().B(YS);
                        }
                        if (af.cnE().ko(v.Zm(str))) {
                            if (YS.DI(32)) {
                                Object obj;
                                com.tencent.mm.plugin.sns.storage.a cqq = YS.cqq();
                                if (cqq == null) {
                                    obj = "";
                                } else {
                                    String obj2 = cqq.hnw;
                                }
                                ((c) com.tencent.mm.kernel.g.K(c.class)).a(11855, YS.cre(), Integer.valueOf(0), obj2, Integer.valueOf(YS.cre()));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RO().eJo.a(new r(v.Zm(str), 7), 0);
                                AppMethodBeat.o(36585);
                                return;
                            }
                            com.tencent.mm.kernel.g.RQ();
                            com.tencent.mm.kernel.g.RO().eJo.a(new r(v.Zm(str), 5), 0);
                        }
                        AppMethodBeat.o(36585);
                    }
                }
            } catch (Exception e) {
            }
            if (af.cnE().ko(v.Zm(str))) {
            }
            AppMethodBeat.o(36585);
        }

        private static cat b(n nVar, int i, String str, cat cat, int i2, int i3) {
            AppMethodBeat.i(36588);
            can can = new can();
            can.ncM = str;
            can.pcX = (int) (bo.anU() / 1000);
            can.wZD = r.YB();
            can.wPm = r.Yz();
            can.vFH = 0;
            can.wZE = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(nVar.field_userName);
            can.wel = nVar.field_userName;
            can.jCt = i;
            can.wZL = i2;
            if (nVar.DI(32)) {
                can.wZI = cat == null ? 0 : cat.wZJ;
            } else {
                can.wZF = cat == null ? 0 : cat.wZG;
            }
            can can2 = new can();
            can2.wPm = cat == null ? "" : cat.vHl;
            if (!bo.isNullOrNil(can2.wPm)) {
                can2.wZD = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(can2.wPm);
            }
            cao cao = new cao();
            cao.vQE = nVar.field_snsId;
            cao.wZN = can;
            cao.wZO = can2;
            String str2 = "";
            if (nVar.DI(32)) {
                com.tencent.mm.plugin.sns.storage.a cqr;
                Object obj;
                if (i3 == 2) {
                    cqr = nVar.cqr();
                } else {
                    cqr = nVar.cqq();
                }
                if (cqr == null) {
                    obj = "";
                } else {
                    String obj2 = cqr.hnw;
                }
                str2 = cqr == null ? "" : cqr.qPj;
                if (can.jCt == 7) {
                    ((c) com.tencent.mm.kernel.g.K(c.class)).a(11855, nVar.cre(), Integer.valueOf(1), obj2, Integer.valueOf(nVar.cre()));
                } else if (can.jCt == 8) {
                    ((c) com.tencent.mm.kernel.g.K(c.class)).a(11855, nVar.cre(), Integer.valueOf(2), obj2, Integer.valueOf(nVar.cre()));
                }
                e crd = nVar.crd();
                if (crd != null) {
                    if (crd.field_firstControlTime == 0) {
                        crd.field_firstControlTime = can.pcX;
                        af.cnI().b(crd.field_snsId, crd);
                    }
                    bs cqv = crd.cqv();
                    if (i3 == 2) {
                        if (cqv != null) {
                            cao.wZN.vFa = cqv.vDZ;
                            if (cqv.vDZ != null) {
                                ab.i("MicroMsg.SnsService", "atFriend remindInfo aid %d", Integer.valueOf(cqv.vDZ.wTz));
                                if (cqv.vDZ.wTz == 0) {
                                    com.tencent.mm.plugin.report.service.h.pYm.k(955, 9, 1);
                                }
                            } else {
                                com.tencent.mm.plugin.report.service.h.pYm.k(955, 7, 1);
                            }
                        } else {
                            ab.i("MicroMsg.SnsService", "remindInfo group is null!");
                            com.tencent.mm.plugin.report.service.h.pYm.k(955, 5, 1);
                        }
                    } else if (d.fF(i2, 8)) {
                        if (cqv != null) {
                            cao.wZN.vFa = cqv.vDY;
                            if (cqv.vDY != null) {
                                ab.i("MicroMsg.SnsService", "timeline remindInfo aid %d", Integer.valueOf(cqv.vDY.wTz));
                                if (cqv.vDY.wTz == 0) {
                                    com.tencent.mm.plugin.report.service.h.pYm.k(955, 8, 1);
                                }
                            } else {
                                com.tencent.mm.plugin.report.service.h.pYm.k(955, 6, 1);
                            }
                        } else {
                            ab.i("MicroMsg.SnsService", "remindInfo group is null!");
                            com.tencent.mm.plugin.report.service.h.pYm.k(955, 5, 1);
                        }
                    }
                }
            }
            String x = com.tencent.mm.a.g.x((bo.yz()).getBytes());
            if (nVar.DI(32)) {
                x = "_AD_TAG_".concat(String.valueOf(x));
            }
            if (!af.cnE().a(x, cao)) {
                ab.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ad.XT(x)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new k(cao, x, str2), 0);
            } else {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new o(cao, x), 0);
            }
            AppMethodBeat.o(36588);
            return null;
        }

        public static cat a(n nVar, int i, String str, String str2, int i2) {
            AppMethodBeat.i(36589);
            can can = new can();
            can.ncM = str;
            can.pcX = (int) (bo.anU() / 1000);
            can.wZD = r.YB();
            can.wPm = r.Yz();
            can.vFH = i2;
            can.wZE = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(nVar.field_userName);
            can.wel = nVar.field_userName;
            can.jCt = i;
            if (nVar.DI(32)) {
                can.wZI = 0;
            } else {
                can.wZF = 0;
            }
            can can2 = new can();
            can2.wPm = str2;
            if (!bo.isNullOrNil(can2.wPm)) {
                can2.wZD = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(can2.wPm);
            }
            cao cao = new cao();
            cao.vQE = nVar.field_snsId;
            cao.wZN = can;
            cao.wZO = can2;
            String str3 = "";
            if (nVar.DI(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a cqq = nVar.cqq();
                if (cqq == null) {
                    obj = "";
                } else {
                    String obj2 = cqq.hnw;
                }
                str3 = cqq == null ? "" : cqq.qPj;
                if (can.jCt == 7) {
                    ((c) com.tencent.mm.kernel.g.K(c.class)).a(11855, nVar.cre(), Integer.valueOf(1), obj2, Integer.valueOf(nVar.cre()));
                } else if (can.jCt == 8) {
                    ((c) com.tencent.mm.kernel.g.K(c.class)).a(11855, nVar.cre(), Integer.valueOf(2), obj2, Integer.valueOf(nVar.cre()));
                }
            }
            String x = com.tencent.mm.a.g.x((bo.yz()).getBytes());
            if (nVar.DI(32)) {
                x = "_AD_TAG_".concat(String.valueOf(x));
            }
            if (!af.cnE().a(x, cao, str3)) {
                ab.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ad.XT(x)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new k(cao, x, str3), 0);
            } else {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(new o(cao, x), 0);
            }
            AppMethodBeat.o(36589);
            return null;
        }

        public static void a(String str, int i, String str2, n nVar, int i2) {
            AppMethodBeat.i(36590);
            if (i == 3 || i == 5) {
                can can = new can();
                can.ncM = str2;
                can.pcX = (int) (System.currentTimeMillis() / 1000);
                can.wZD = r.YB();
                can.wPm = r.Yz();
                can.vFH = i2;
                can.wZE = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(str);
                can.wel = str;
                can.jCt = i;
                cao cao = new cao();
                cao.vQE = nVar.field_snsId;
                cao.wZN = can;
                cao.wZO = new can();
                String x = com.tencent.mm.a.g.x((bo.yz()).getBytes());
                long j = nVar.field_snsId;
                try {
                    ab.v("MicroMsg.SnsService", "comment stg inserted");
                    j jVar = new j();
                    jVar.field_talker = str;
                    jVar.field_snsID = j;
                    jVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                    jVar.field_curActionBuf = can.toByteArray();
                    jVar.field_type = i;
                    jVar.field_isSend = true;
                    jVar.field_isRead = (short) 1;
                    af.cnK().b((com.tencent.mm.sdk.e.c) jVar);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsService", e, "", new Object[0]);
                }
                af.cnE().a(x, cao);
                AppMethodBeat.o(36590);
                return;
            }
            AppMethodBeat.o(36590);
        }

        public final void WZ(String str) {
            AppMethodBeat.i(36591);
            String accSnsPath = af.getAccSnsPath();
            String str2 = str + "bg_";
            String str3 = str + "tbg_";
            if (com.tencent.mm.vfs.e.ct(str2)) {
                com.tencent.mm.vfs.e.deleteFile(an.fZ(accSnsPath, str) + str3);
                com.tencent.mm.vfs.e.h(an.fZ(accSnsPath, str), str2, str3);
            }
            AppMethodBeat.o(36591);
        }

        public static cat a(n nVar, int i, String str, int i2) {
            AppMethodBeat.i(36586);
            cat b = b(nVar, i, str, null, 0, i2);
            AppMethodBeat.o(36586);
            return b;
        }

        public static cat a(n nVar, int i, String str, cat cat, int i2, int i3) {
            AppMethodBeat.i(36587);
            cat b = b(nVar, i, str, cat, i2, i3);
            AppMethodBeat.o(36587);
            return b;
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(36592);
            if (!af.cnn() && aVar.ftE.isEmpty()) {
                af.cnC().cmV();
                ab.d("MicroMsg.SnsService", "clean sns cache");
            }
            AppMethodBeat.o(36592);
        }
    }

    public static void e(ArrayList<String> arrayList, String str) {
        AppMethodBeat.i(36593);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(36593);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i = bo.getInt((String) it.next(), 0);
            if (i != 0) {
                n DK = af.cnF().DK(i);
                if (DK != null) {
                    TimeLineObject cqu = DK.cqu();
                    if (!(cqu == null || cqu.xfI == null || cqu.xfI.wbJ != 26)) {
                        cqu.xfI.wbM = str;
                        af.cnF().b(i, DK);
                        ox oxVar = new ox();
                        oxVar.cLl.cLm = i;
                        com.tencent.mm.sdk.b.a.xxA.m(oxVar);
                    }
                }
            }
        }
        AppMethodBeat.o(36593);
    }

    static {
        AppMethodBeat.i(36596);
        AppMethodBeat.o(36596);
    }

    public static boolean coc() {
        boolean z;
        AppMethodBeat.i(36594);
        com.tencent.mm.kernel.g.RQ();
        int intValue = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(0))).intValue();
        ab.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", Integer.valueOf(intValue), Integer.valueOf(qMw));
        if (intValue < qMw) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(intValue + 1));
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.o(36594);
        return z;
    }

    /* JADX WARNING: Missing block: B:5:0x0039, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isEqual(com.tencent.d.f.e.bytesToHexString(r3.digest()), "2A281593D71DF33374E6124E9106DF08") != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean eO(Context context) {
        boolean z = true;
        AppMethodBeat.i(36595);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
            if (packageInfo != null) {
                byte[] toByteArray = packageInfo.signatures[0].toByteArray();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
            }
        } catch (Exception e) {
            ab.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", e.getMessage());
        }
        z = false;
        AppMethodBeat.o(36595);
        return z;
    }
}
