package com.tencent.p177mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18357ox;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C21992j;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C23375bs;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.rtmp.TXLiveConstants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.model.am */
public final class C3889am {
    private static final int qMw = C26373g.m41964Nu().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);

    /* renamed from: com.tencent.mm.plugin.sns.model.am$a */
    public static class C3890a implements C1202f, C39728h {
        public static int qMx = -1;
        private Map<C39729a, String> ftE = new HashMap();
        private int qMA = 0;
        public long qMB = 0;
        private LinkedList<String> qMC = new LinkedList();
        public Map<String, ArrayList<C34937b>> qMD = new HashMap();
        public Map<String, Integer> qME = new HashMap();
        private Map<String, Long> qMy = new HashMap();
        private Map<String, Integer> qMz = new HashMap();

        /* renamed from: com.tencent.mm.plugin.sns.model.am$a$1 */
        class C38911 implements Runnable {
            C38911() {
            }

            public final void run() {
                AppMethodBeat.m2504i(36571);
                C3890a.m6185a(C3890a.this);
                AppMethodBeat.m2505o(36571);
            }
        }

        public C3890a() {
            AppMethodBeat.m2504i(36572);
            AppMethodBeat.m2505o(36572);
        }

        /* renamed from: j */
        public final void mo8623j(String str, ArrayList<C34937b> arrayList) {
            AppMethodBeat.m2504i(36573);
            this.qMD.put(str, arrayList);
            AppMethodBeat.m2505o(36573);
        }

        /* renamed from: Yb */
        public final ArrayList<C34937b> mo8615Yb(String str) {
            AppMethodBeat.m2504i(36574);
            if (this.qME.containsKey(str)) {
                this.qME.put(str, Integer.valueOf(((Integer) this.qME.get(str)).intValue() + 1));
            } else {
                this.qME.put(str, Integer.valueOf(0));
            }
            ArrayList arrayList = (ArrayList) this.qMD.get(str);
            AppMethodBeat.m2505o(36574);
            return arrayList;
        }

        /* renamed from: e */
        public final Intent mo8622e(Intent intent, String str) {
            AppMethodBeat.m2504i(36575);
            intent.putExtra("sns_userName", str);
            if (this.qMC == null || !this.qMC.contains(str)) {
                AppMethodBeat.m2505o(36575);
            } else {
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                AppMethodBeat.m2505o(36575);
            }
            return intent;
        }

        /* renamed from: a */
        public final void mo8617a(int i, String str, C39729a c39729a) {
            AppMethodBeat.m2504i(36576);
            C4990ab.m7416i("MicroMsg.SnsService", "startServer " + i + " " + c39729a);
            C13373af.cnE().ecX = C1853r.m3846Yz();
            C13373af.cnE().cnf();
            C13373af.cnB().cmp();
            if (this.ftE.isEmpty()) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(211, (C1202f) this);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(212, (C1202f) this);
            }
            if (!this.ftE.containsKey(c39729a)) {
                if (i == 1) {
                    this.ftE.put(c39729a, "@__weixintimtline");
                } else if (i == 2 || i == 3) {
                    this.ftE.put(c39729a, str);
                } else if (i == 4) {
                    this.ftE.put(c39729a, "@__classify_timeline");
                } else if (i == 5) {
                    this.ftE.put(c39729a, "");
                } else {
                    this.ftE.put(c39729a, "");
                }
            }
            switch (i) {
                case 1:
                    this.qMB = 0;
                    this.qMA = cod();
                    C46225y.m86451XP("@__weixintimtline");
                    break;
                case 2:
                    synchronized (this.qMy) {
                        try {
                            this.qMy.put(str, Long.valueOf(0));
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(36576);
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
                                AppMethodBeat.m2505o(36576);
                                break;
                            }
                        }
                    }
                    C46218aa.m86428XS(str);
                    this.qMC.add(str);
                    return;
            }
            AppMethodBeat.m2505o(36576);
        }

        /* renamed from: a */
        public final boolean mo8619a(C39729a c39729a, int i) {
            AppMethodBeat.m2504i(36577);
            C4990ab.m7410d("MicroMsg.SnsService", "closeServer");
            this.ftE.remove(c39729a);
            if (i == 2 && this.qMC.size() > 0) {
                this.qMC.removeLast();
            }
            if (this.ftE.isEmpty()) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14546b(211, (C1202f) this);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14546b(212, (C1202f) this);
                C3892an.release();
                C46236n.release();
                new C7306ak(Looper.getMainLooper()).postDelayed(new C38911(), 5000);
                C34955aj.cnW();
                C4990ab.m7416i("MicroMsg.SnsService", "close finish");
            }
            AppMethodBeat.m2505o(36577);
            return true;
        }

        /* renamed from: b */
        public final void mo8620b(int i, String str, boolean z, int i2) {
            AppMethodBeat.m2504i(36578);
            if (C1947ae.gig) {
                AppMethodBeat.m2505o(36578);
                return;
            }
            synchronized (this.qMy) {
                try {
                    C4990ab.m7411d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", str, Integer.valueOf(i), Long.valueOf(this.qMB), this.qMy);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(36578);
                }
            }
            if (i == 2) {
                if (C46218aa.m86427XR(str)) {
                    long j = 0;
                    synchronized (this.qMy) {
                        try {
                            if (this.qMy.containsKey(str)) {
                                j = ((Long) this.qMy.get(str)).longValue();
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(36578);
                        }
                    }
                    if (j == 0) {
                        C46218aa.m86428XS(str);
                        return;
                    }
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C46218aa(str, j, z, i2), 0);
                    AppMethodBeat.m2505o(36578);
                }
            } else if (i != 1) {
                if (i != 3 && i == 4) {
                    if (!C13429n.m21572XO("@__classify_timeline")) {
                        AppMethodBeat.m2505o(36578);
                        return;
                    } else if (this.qMB == 0) {
                        C13429n.m21573XP("@__classify_timeline");
                        AppMethodBeat.m2505o(36578);
                        return;
                    } else {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C13429n(""), 0);
                    }
                }
                AppMethodBeat.m2505o(36578);
            } else if (!C46225y.m86450XO("@__weixintimtline")) {
                AppMethodBeat.m2505o(36578);
            } else if (this.qMB == 0) {
                C46225y.m86451XP("@__weixintimtline");
                AppMethodBeat.m2505o(36578);
            } else {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C46225y(this.qMB), 0);
                AppMethodBeat.m2505o(36578);
            }
        }

        /* renamed from: a */
        public final void mo8618a(int i, String str, boolean z, int i2) {
            AppMethodBeat.m2504i(36579);
            if (C1947ae.gig) {
                AppMethodBeat.m2505o(36579);
                return;
            }
            C4990ab.m7411d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", Integer.valueOf(i), str);
            if (i == 2) {
                if (C46218aa.m86427XR(str)) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C46218aa(str, 0, z, i2), 0);
                    AppMethodBeat.m2505o(36579);
                    return;
                }
                AppMethodBeat.m2505o(36579);
            } else if (i != 1) {
                if (i != 3 && i == 4) {
                    if (C13429n.m21572XO("@__classify_timeline")) {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C13429n(""), 0);
                    } else {
                        AppMethodBeat.m2505o(36579);
                        return;
                    }
                }
                AppMethodBeat.m2505o(36579);
            } else if (C46225y.m86450XO("@__weixintimtline")) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(68377, (Object) "");
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C46225y(0), 0);
                AppMethodBeat.m2505o(36579);
            } else {
                AppMethodBeat.m2505o(36579);
            }
        }

        /* renamed from: Yc */
        public final int mo8616Yc(String str) {
            int intValue;
            AppMethodBeat.m2504i(36580);
            synchronized (this.qMz) {
                try {
                    if (this.qMz.containsKey(str)) {
                        intValue = ((Integer) this.qMz.get(str)).intValue();
                        if (intValue <= 0) {
                            intValue = C29036i.cmr();
                        }
                    } else {
                        intValue = C29036i.cmr();
                        AppMethodBeat.m2505o(36580);
                        return intValue;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(36580);
                }
            }
            return intValue;
        }

        public final int cod() {
            AppMethodBeat.m2504i(36581);
            int i;
            if (this.qMA > 0) {
                i = this.qMA;
                AppMethodBeat.m2505o(36581);
                return i;
            }
            i = C29036i.cmr();
            AppMethodBeat.m2505o(36581);
            return i;
        }

        /* renamed from: B */
        public final void mo8613B(long j, int i) {
            AppMethodBeat.m2504i(36582);
            C4990ab.m7411d("MicroMsg.SnsService", "setTimeLastId %d", Long.valueOf(j));
            if (i > 0) {
                this.qMA = i;
                C29036i.m46074CN(i);
            }
            if (j == 0) {
                AppMethodBeat.m2505o(36582);
                return;
            }
            this.qMB = j;
            AppMethodBeat.m2505o(36582);
        }

        public static int coe() {
            AppMethodBeat.m2504i(36583);
            int i;
            if (qMx != -1) {
                i = qMx;
                AppMethodBeat.m2505o(36583);
                return i;
            }
            i = C29036i.cmq();
            qMx = i;
            AppMethodBeat.m2505o(36583);
            return i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            Object obj;
            AppMethodBeat.m2504i(36584);
            C4990ab.m7416i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType());
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
                        AppMethodBeat.m2505o(36584);
                        return;
                    }
                    int i3;
                    switch (c1207m.getType()) {
                        case 211:
                            C46225y c46225y = (C46225y) c1207m;
                            mo8613B(c46225y.qIY, c46225y.qJa);
                            i3 = c46225y.qJb;
                            if (qMx != i3) {
                                C29036i.m46073CM(i3);
                            }
                            qMx = i3;
                            break;
                        case 212:
                            C46218aa c46218aa = (C46218aa) c1207m;
                            String str2 = c46218aa.userName;
                            long j = c46218aa.qIY;
                            i3 = c46218aa.qJa;
                            if (i3 > 0) {
                                synchronized (this.qMz) {
                                    try {
                                        this.qMz.put(str2, Integer.valueOf(i3));
                                    } catch (Throwable th) {
                                        while (true) {
                                            AppMethodBeat.m2505o(36584);
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
                                        AppMethodBeat.m2505o(36584);
                                    }
                                }
                                break;
                            }
                            break;
                    }
                    if (c1207m.getType() == 212 || c1207m.getType() == 211) {
                        C21918d c21918d = (C21918d) c1207m;
                        Iterator it = new ArrayList(this.ftE.keySet()).iterator();
                        while (it.hasNext()) {
                            C39729a c39729a = (C39729a) it.next();
                            if (this.ftE.containsKey(c39729a)) {
                                String str3 = (String) this.ftE.get(c39729a);
                                if (c21918d.getUserName().equals(str3)) {
                                    C4990ab.m7410d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(str3)));
                                    String jW = c21918d.cmQ() == 0 ? "" : C29036i.m46118jW(c21918d.cmQ());
                                    boolean cmN;
                                    boolean cmR;
                                    boolean z;
                                    if (c21918d.cmM()) {
                                        boolean cmO = c21918d.cmO();
                                        cmN = c21918d.cmN();
                                        cmR = c21918d.cmR();
                                        z = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003 || i2 == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || i2 == 203);
                                        c39729a.mo17657a(cmO, cmN, jW, cmR, z, i2, c21918d.cmS(), c21918d.cmT());
                                    } else {
                                        cmN = c21918d.cmN();
                                        cmR = c21918d.cmP();
                                        if (i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003 || i2 == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || i2 == 203)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        c39729a.mo17656a(cmN, jW, cmR, z, i2, c21918d.cmS(), c21918d.cmT());
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(36584);
                    return;
                }
            }
            obj = 1;
            if (obj != null) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Yd */
        public static void m6181Yd(String str) {
            AppMethodBeat.m2504i(36585);
            C21915ad cnE = C13373af.cnE();
            if (C5046bo.isNullOrNil(cnE.ecX)) {
                cnE.ecX = C1853r.m3846Yz();
            }
            String str2 = cnE.ecX;
            C46236n YS = C21990h.m33615YS(str);
            try {
                cbf cbf = (cbf) new cbf().parseFrom(YS.field_attrBuf);
                Iterator it = cbf.xaq.iterator();
                while (it.hasNext()) {
                    cat cat = (cat) it.next();
                    if (cat.vHl.equals(str2)) {
                        cbf.xaq.remove(cat);
                        cbf.xao--;
                        YS.field_attrBuf = cbf.toByteArray();
                        if (YS.mo74253DI(32)) {
                            C13373af.cnI().mo10099a(YS.crd());
                        } else {
                            C13373af.cnF().mo62912B(YS);
                        }
                        if (C13373af.cnE().mo37412ko(C35002v.m57483Zm(str))) {
                            if (YS.mo74253DI(32)) {
                                Object obj;
                                C21980a cqq = YS.cqq();
                                if (cqq == null) {
                                    obj = "";
                                } else {
                                    String obj2 = cqq.hnw;
                                }
                                ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, YS.cre(), Integer.valueOf(0), obj2, Integer.valueOf(YS.cre()));
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14541a(new C46224r(C35002v.m57483Zm(str), 7), 0);
                                AppMethodBeat.m2505o(36585);
                                return;
                            }
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(new C46224r(C35002v.m57483Zm(str), 5), 0);
                        }
                        AppMethodBeat.m2505o(36585);
                    }
                }
            } catch (Exception e) {
            }
            if (C13373af.cnE().mo37412ko(C35002v.m57483Zm(str))) {
            }
            AppMethodBeat.m2505o(36585);
        }

        /* renamed from: b */
        private static cat m6187b(C46236n c46236n, int i, String str, cat cat, int i2, int i3) {
            AppMethodBeat.m2504i(36588);
            can can = new can();
            can.ncM = str;
            can.pcX = (int) (C5046bo.anU() / 1000);
            can.wZD = C1853r.m3820YB();
            can.wPm = C1853r.m3846Yz();
            can.vFH = 0;
            can.wZE = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(c46236n.field_userName);
            can.wel = c46236n.field_userName;
            can.jCt = i;
            can.wZL = i2;
            if (c46236n.mo74253DI(32)) {
                can.wZI = cat == null ? 0 : cat.wZJ;
            } else {
                can.wZF = cat == null ? 0 : cat.wZG;
            }
            can can2 = new can();
            can2.wPm = cat == null ? "" : cat.vHl;
            if (!C5046bo.isNullOrNil(can2.wPm)) {
                can2.wZD = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(can2.wPm);
            }
            cao cao = new cao();
            cao.vQE = c46236n.field_snsId;
            cao.wZN = can;
            cao.wZO = can2;
            String str2 = "";
            if (c46236n.mo74253DI(32)) {
                C21980a cqr;
                Object obj;
                if (i3 == 2) {
                    cqr = c46236n.cqr();
                } else {
                    cqr = c46236n.cqq();
                }
                if (cqr == null) {
                    obj = "";
                } else {
                    String obj2 = cqr.hnw;
                }
                str2 = cqr == null ? "" : cqr.qPj;
                if (can.jCt == 7) {
                    ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, c46236n.cre(), Integer.valueOf(1), obj2, Integer.valueOf(c46236n.cre()));
                } else if (can.jCt == 8) {
                    ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, c46236n.cre(), Integer.valueOf(2), obj2, Integer.valueOf(c46236n.cre()));
                }
                C43570e crd = c46236n.crd();
                if (crd != null) {
                    if (crd.field_firstControlTime == 0) {
                        crd.field_firstControlTime = can.pcX;
                        C13373af.cnI().mo69172b(crd.field_snsId, crd);
                    }
                    C23375bs cqv = crd.cqv();
                    if (i3 == 2) {
                        if (cqv != null) {
                            cao.wZN.vFa = cqv.vDZ;
                            if (cqv.vDZ != null) {
                                C4990ab.m7417i("MicroMsg.SnsService", "atFriend remindInfo aid %d", Integer.valueOf(cqv.vDZ.wTz));
                                if (cqv.vDZ.wTz == 0) {
                                    C7060h.pYm.mo15419k(955, 9, 1);
                                }
                            } else {
                                C7060h.pYm.mo15419k(955, 7, 1);
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.SnsService", "remindInfo group is null!");
                            C7060h.pYm.mo15419k(955, 5, 1);
                        }
                    } else if (C39851d.m68264fF(i2, 8)) {
                        if (cqv != null) {
                            cao.wZN.vFa = cqv.vDY;
                            if (cqv.vDY != null) {
                                C4990ab.m7417i("MicroMsg.SnsService", "timeline remindInfo aid %d", Integer.valueOf(cqv.vDY.wTz));
                                if (cqv.vDY.wTz == 0) {
                                    C7060h.pYm.mo15419k(955, 8, 1);
                                }
                            } else {
                                C7060h.pYm.mo15419k(955, 6, 1);
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.SnsService", "remindInfo group is null!");
                            C7060h.pYm.mo15419k(955, 5, 1);
                        }
                    }
                }
            }
            String x = C1178g.m2591x((C5046bo.m7588yz()).getBytes());
            if (c46236n.mo74253DI(32)) {
                x = "_AD_TAG_".concat(String.valueOf(x));
            }
            if (!C13373af.cnE().mo37401a(x, cao)) {
                C4990ab.m7412e("MicroMsg.SnsService", "can not add Comment");
            } else if (C21915ad.m33476XT(x)) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C46223k(cao, x, str2), 0);
            } else {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C13430o(cao, x), 0);
            }
            AppMethodBeat.m2505o(36588);
            return null;
        }

        /* renamed from: a */
        public static cat m6184a(C46236n c46236n, int i, String str, String str2, int i2) {
            AppMethodBeat.m2504i(36589);
            can can = new can();
            can.ncM = str;
            can.pcX = (int) (C5046bo.anU() / 1000);
            can.wZD = C1853r.m3820YB();
            can.wPm = C1853r.m3846Yz();
            can.vFH = i2;
            can.wZE = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(c46236n.field_userName);
            can.wel = c46236n.field_userName;
            can.jCt = i;
            if (c46236n.mo74253DI(32)) {
                can.wZI = 0;
            } else {
                can.wZF = 0;
            }
            can can2 = new can();
            can2.wPm = str2;
            if (!C5046bo.isNullOrNil(can2.wPm)) {
                can2.wZD = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(can2.wPm);
            }
            cao cao = new cao();
            cao.vQE = c46236n.field_snsId;
            cao.wZN = can;
            cao.wZO = can2;
            String str3 = "";
            if (c46236n.mo74253DI(32)) {
                Object obj;
                C21980a cqq = c46236n.cqq();
                if (cqq == null) {
                    obj = "";
                } else {
                    String obj2 = cqq.hnw;
                }
                str3 = cqq == null ? "" : cqq.qPj;
                if (can.jCt == 7) {
                    ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, c46236n.cre(), Integer.valueOf(1), obj2, Integer.valueOf(c46236n.cre()));
                } else if (can.jCt == 8) {
                    ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, c46236n.cre(), Integer.valueOf(2), obj2, Integer.valueOf(c46236n.cre()));
                }
            }
            String x = C1178g.m2591x((C5046bo.m7588yz()).getBytes());
            if (c46236n.mo74253DI(32)) {
                x = "_AD_TAG_".concat(String.valueOf(x));
            }
            if (!C13373af.cnE().mo37402a(x, cao, str3)) {
                C4990ab.m7412e("MicroMsg.SnsService", "can not add Comment");
            } else if (C21915ad.m33476XT(x)) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C46223k(cao, x, str3), 0);
            } else {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C13430o(cao, x), 0);
            }
            AppMethodBeat.m2505o(36589);
            return null;
        }

        /* renamed from: a */
        public static void m6186a(String str, int i, String str2, C46236n c46236n, int i2) {
            AppMethodBeat.m2504i(36590);
            if (i == 3 || i == 5) {
                can can = new can();
                can.ncM = str2;
                can.pcX = (int) (System.currentTimeMillis() / 1000);
                can.wZD = C1853r.m3820YB();
                can.wPm = C1853r.m3846Yz();
                can.vFH = i2;
                can.wZE = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str);
                can.wel = str;
                can.jCt = i;
                cao cao = new cao();
                cao.vQE = c46236n.field_snsId;
                cao.wZN = can;
                cao.wZO = new can();
                String x = C1178g.m2591x((C5046bo.m7588yz()).getBytes());
                long j = c46236n.field_snsId;
                try {
                    C4990ab.m7418v("MicroMsg.SnsService", "comment stg inserted");
                    C21992j c21992j = new C21992j();
                    c21992j.field_talker = str;
                    c21992j.field_snsID = j;
                    c21992j.field_createTime = (int) (System.currentTimeMillis() / 1000);
                    c21992j.field_curActionBuf = can.toByteArray();
                    c21992j.field_type = i;
                    c21992j.field_isSend = true;
                    c21992j.field_isRead = (short) 1;
                    C13373af.cnK().mo10101b((C4925c) c21992j);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsService", e, "", new Object[0]);
                }
                C13373af.cnE().mo37401a(x, cao);
                AppMethodBeat.m2505o(36590);
                return;
            }
            AppMethodBeat.m2505o(36590);
        }

        /* renamed from: WZ */
        public final void mo8614WZ(String str) {
            AppMethodBeat.m2504i(36591);
            String accSnsPath = C13373af.getAccSnsPath();
            String str2 = str + "bg_";
            String str3 = str + "tbg_";
            if (C5730e.m8628ct(str2)) {
                C5730e.deleteFile(C3892an.m6198fZ(accSnsPath, str) + str3);
                C5730e.m8633h(C3892an.m6198fZ(accSnsPath, str), str2, str3);
            }
            AppMethodBeat.m2505o(36591);
        }

        /* renamed from: a */
        public static cat m6182a(C46236n c46236n, int i, String str, int i2) {
            AppMethodBeat.m2504i(36586);
            cat b = C3890a.m6187b(c46236n, i, str, null, 0, i2);
            AppMethodBeat.m2505o(36586);
            return b;
        }

        /* renamed from: a */
        public static cat m6183a(C46236n c46236n, int i, String str, cat cat, int i2, int i3) {
            AppMethodBeat.m2504i(36587);
            cat b = C3890a.m6187b(c46236n, i, str, cat, i2, i3);
            AppMethodBeat.m2505o(36587);
            return b;
        }

        /* renamed from: a */
        static /* synthetic */ void m6185a(C3890a c3890a) {
            AppMethodBeat.m2504i(36592);
            if (!C13373af.cnn() && c3890a.ftE.isEmpty()) {
                C13373af.cnC().cmV();
                C4990ab.m7410d("MicroMsg.SnsService", "clean sns cache");
            }
            AppMethodBeat.m2505o(36592);
        }
    }

    /* renamed from: e */
    public static void m6179e(ArrayList<String> arrayList, String str) {
        AppMethodBeat.m2504i(36593);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.m2505o(36593);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i = C5046bo.getInt((String) it.next(), 0);
            if (i != 0) {
                C46236n DK = C13373af.cnF().mo62914DK(i);
                if (DK != null) {
                    TimeLineObject cqu = DK.cqu();
                    if (!(cqu == null || cqu.xfI == null || cqu.xfI.wbJ != 26)) {
                        cqu.xfI.wbM = str;
                        C13373af.cnF().mo62928b(i, DK);
                        C18357ox c18357ox = new C18357ox();
                        c18357ox.cLl.cLm = i;
                        C4879a.xxA.mo10055m(c18357ox);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(36593);
    }

    static {
        AppMethodBeat.m2504i(36596);
        AppMethodBeat.m2505o(36596);
    }

    public static boolean coc() {
        boolean z;
        AppMethodBeat.m2504i(36594);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(0))).intValue();
        C4990ab.m7411d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", Integer.valueOf(intValue), Integer.valueOf(qMw));
        if (intValue < qMw) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(intValue + 1));
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.m2505o(36594);
        return z;
    }

    /* JADX WARNING: Missing block: B:5:0x0039, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isEqual(com.tencent.p127d.p135f.C8769e.bytesToHexString(r3.digest()), "2A281593D71DF33374E6124E9106DF08") != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: eO */
    public static boolean m6180eO(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(36595);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
            if (packageInfo != null) {
                byte[] toByteArray = packageInfo.signatures[0].toByteArray();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", e.getMessage());
        }
        z = false;
        AppMethodBeat.m2505o(36595);
        return z;
    }
}
