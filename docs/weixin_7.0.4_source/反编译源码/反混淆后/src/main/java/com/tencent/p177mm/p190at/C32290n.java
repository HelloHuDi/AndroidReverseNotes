package com.tencent.p177mm.p190at;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p178a.C1170b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C34830g.C21671a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.at.n */
public class C32290n {
    private static C32290n fFN;
    ConcurrentHashMap<Long, C32288d> fFL = new ConcurrentHashMap();
    public C32287c fFM = new C32287c();
    public ConcurrentHashMap<Long, C32289e> fFO = new ConcurrentHashMap();
    private ArrayList<Long> fFP = new ArrayList();
    ArrayList<C32289e> fFQ = new ArrayList();

    /* renamed from: com.tencent.mm.at.n$a */
    public static class C9030a {
        static C7306ak cbT;
        private ReentrantLock cbR = new ReentrantLock();
        private Condition cbS = this.cbR.newCondition();
        int fDC;
        C9031a fFR;

        /* renamed from: com.tencent.mm.at.n$a$a */
        public static class C9031a {
            String fDK;
            PString fFU;
            PString fFV;
            PString fFW;
            PString fFX;
        }

        public C9030a() {
            AppMethodBeat.m2504i(78358);
            AppMethodBeat.m2505o(78358);
        }

        /* renamed from: a */
        public static C9030a m16346a(final C32289e c32289e) {
            AppMethodBeat.m2504i(78359);
            synchronized (C9030a.class) {
                try {
                    if (cbT == null) {
                        HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                        handlerThread.start();
                        cbT = new C7306ak(handlerThread.getLooper());
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(78359);
                }
            }
            C9030a c9030a = new C9030a();
            c32289e.fGl = c9030a;
            cbT.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(78357);
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    C9031a c9031a = new C9031a();
                    c9031a.fFU = new PString();
                    c9031a.fFV = new PString();
                    c9031a.fFW = new PString();
                    c9031a.fFX = new PString();
                    c9031a.fDK = C32291o.ahl().mo73090a(c32289e.fGc, C37478f.m63230sh(c32289e.fGc), c32289e.fDC, true, c9031a.fFU, c9031a.fFV, c9031a.fFW, c9031a.fFX, c32289e.fGe, c32289e.fGj);
                    C9030a.this.cbR.lock();
                    try {
                        C9030a.this.fFR = c9031a;
                        C9030a.this.cbS.signal();
                        C4990ab.m7417i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", c32289e.fGc, Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                    } finally {
                        C9030a.this.cbR.unlock();
                        AppMethodBeat.m2505o(78357);
                    }
                }
            });
            c9030a.fDC = c32289e.fDC;
            return c9030a;
        }

        public final C9031a ahe() {
            AppMethodBeat.m2504i(78360);
            this.cbR.lock();
            while (this.fFR == null) {
                try {
                    C4990ab.m7416i("MicroMsg.SendImgSpeeder", "getResult await");
                    this.cbS.await();
                } catch (Exception e) {
                    this.cbR.unlock();
                } catch (Throwable th) {
                    this.cbR.unlock();
                    AppMethodBeat.m2505o(78360);
                }
            }
            this.cbR.unlock();
            C9031a c9031a = this.fFR;
            AppMethodBeat.m2505o(78360);
            return c9031a;
        }
    }

    /* renamed from: com.tencent.mm.at.n$b */
    static class C32286b {
        C1170b fFY;
        String fFZ;

        private C32286b() {
        }

        /* synthetic */ C32286b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.at.n$c */
    public static class C32287c {
        public LinkedList<C32286b> fGa = new LinkedList();
        public LinkedList<C32286b> fGb = new LinkedList();

        public C32287c() {
            AppMethodBeat.m2504i(78361);
            AppMethodBeat.m2505o(78361);
        }

        /* renamed from: st */
        public static C32286b m52719st(String str) {
            AppMethodBeat.m2504i(78363);
            C32286b c32286b = new C32286b();
            if (C5046bo.isNullOrNil(str)) {
                c32286b.fFZ = C45160g.agW();
            } else {
                c32286b.fFZ = str;
            }
            String sm = C32291o.ahl().mo73122sm(c32286b.fFZ);
            if (C32287c.m52721sv(sm)) {
                c32286b.fFY = new C1170b(sm);
                AppMethodBeat.m2505o(78363);
                return c32286b;
            }
            AppMethodBeat.m2505o(78363);
            return null;
        }

        /* renamed from: su */
        public static C32286b m52720su(String str) {
            AppMethodBeat.m2504i(78364);
            C32286b c32286b = new C32286b();
            if (C5046bo.isNullOrNil(str)) {
                c32286b.fFZ = C45160g.agW();
            } else {
                c32286b.fFZ = str;
            }
            String sl = C32291o.ahl().mo73121sl(c32286b.fFZ);
            if (C32287c.m52721sv(sl)) {
                c32286b.fFY = new C1170b(sl);
                AppMethodBeat.m2505o(78364);
                return c32286b;
            }
            AppMethodBeat.m2505o(78364);
            return null;
        }

        /* renamed from: sv */
        private static boolean m52721sv(String str) {
            AppMethodBeat.m2504i(78365);
            if (C5730e.asZ(str) > 0) {
                C4990ab.m7413e("MicroMsg.SendImgSpeeder", "file has exist %s", str);
                AppMethodBeat.m2505o(78365);
                return false;
            }
            AppMethodBeat.m2505o(78365);
            return true;
        }

        /* renamed from: lF */
        public final synchronized C32286b mo52995lF(int i) {
            C32286b c32286b = null;
            synchronized (this) {
                AppMethodBeat.m2504i(78366);
                if (i == 1) {
                    if (this.fGa.size() > 0) {
                        c32286b = (C32286b) this.fGa.remove();
                        ahg();
                    } else {
                        c32286b = C32287c.m52719st(null);
                    }
                } else if (i == 2) {
                    if (this.fGb.size() > 0) {
                        c32286b = (C32286b) this.fGb.remove();
                        ahh();
                    } else {
                        c32286b = C32287c.m52720su(null);
                    }
                }
                ahf();
                AppMethodBeat.m2505o(78366);
            }
            return c32286b;
        }

        private synchronized void ahg() {
            AppMethodBeat.m2504i(78367);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.fGa.size(); i++) {
                stringBuilder.append(((C32286b) this.fGa.get(i)).fFZ);
                if (i != this.fGa.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            C4990ab.m7411d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", stringBuilder.toString());
            C1720g.m3536RP().mo5239Ry().set(348176, stringBuilder.toString());
            AppMethodBeat.m2505o(78367);
        }

        private synchronized void ahh() {
            AppMethodBeat.m2504i(78368);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.fGb.size(); i++) {
                stringBuilder.append(((C32286b) this.fGb.get(i)).fFZ);
                if (i != this.fGb.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            C4990ab.m7411d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", stringBuilder.toString());
            C1720g.m3536RP().mo5239Ry().set(348177, stringBuilder.toString());
            AppMethodBeat.m2505o(78368);
        }

        public final synchronized void ahf() {
            int i = 0;
            synchronized (this) {
                AppMethodBeat.m2504i(78362);
                int size = this.fGa.size();
                if (size <= 0) {
                    int i2 = 5 - size;
                    for (size = 0; size < i2; size++) {
                        this.fGa.add(C32287c.m52719st(null));
                    }
                    C4990ab.m7417i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", Integer.valueOf(i2), Integer.valueOf(this.fGa.size()));
                    ahg();
                }
                size = this.fGb.size();
                if (size <= 0) {
                    size = 5 - size;
                    while (i < size) {
                        this.fGb.add(C32287c.m52720su(null));
                        i++;
                    }
                    ahh();
                    C4990ab.m7417i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", Integer.valueOf(size), Integer.valueOf(this.fGb.size()));
                }
                AppMethodBeat.m2505o(78362);
            }
        }
    }

    /* renamed from: com.tencent.mm.at.n$d */
    public static class C32288d {
        public long cET;
        /* renamed from: xb */
        public long f15015xb;
    }

    /* renamed from: com.tencent.mm.at.n$e */
    public static class C32289e {
        int cDW;
        int cvd;
        long cvx;
        int fDC;
        String fGc;
        String fGd;
        String fGe;
        long fGf;
        PString fGg;
        PInt fGh;
        PInt fGi;
        C1170b fGj;
        C1170b fGk;
        C9030a fGl;
        String toUserName;

        /* renamed from: a */
        public static C32289e m52723a(String str, int i, int i2, int i3, String str2, String str3, PString pString, PInt pInt, PInt pInt2, C1170b c1170b, C1170b c1170b2) {
            AppMethodBeat.m2504i(78369);
            C32289e c32289e = new C32289e();
            c32289e.fGc = str;
            c32289e.fDC = i;
            c32289e.cvd = i2;
            c32289e.cDW = i3;
            c32289e.fGd = str2;
            c32289e.fGg = pString;
            c32289e.fGi = pInt2;
            c32289e.fGh = pInt;
            c32289e.fGe = str3;
            c32289e.fGk = c1170b2;
            c32289e.fGj = c1170b;
            if (C32290n.fFN.ahc()) {
                C9030a.m16346a(c32289e);
            }
            AppMethodBeat.m2505o(78369);
            return c32289e;
        }
    }

    public C32290n() {
        AppMethodBeat.m2504i(78370);
        AppMethodBeat.m2505o(78370);
    }

    public static C32290n ahb() {
        AppMethodBeat.m2504i(78371);
        if (fFN == null) {
            synchronized (C32290n.class) {
                try {
                    if (fFN == null) {
                        fFN = new C32290n();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78371);
                    }
                }
            }
        }
        C32290n c32290n = fFN;
        AppMethodBeat.m2505o(78371);
        return c32290n;
    }

    /* renamed from: sq */
    public final ArrayList<String> mo53001sq(String str) {
        AppMethodBeat.m2504i(78372);
        ArrayList arrayList = new ArrayList();
        if (!C5046bo.isNullOrNil(str)) {
            for (C32289e c32289e : this.fFO.values()) {
                if (str.equals(c32289e.toUserName)) {
                    arrayList.add(c32289e.fGc);
                }
            }
        }
        AppMethodBeat.m2505o(78372);
        return arrayList;
    }

    /* renamed from: sr */
    public final ArrayList<Integer> mo53002sr(String str) {
        AppMethodBeat.m2504i(78373);
        Collection<C32289e> values = this.fFO.values();
        for (C32289e c32289e : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            c32289e.fGf = C32291o.ahl().mo73078a(c32289e.fGc, c32289e.fDC, c32289e.cvd, c32289e.cDW, pString, pInt, pInt2, c32289e.fGd, c32289e.fGe, c32289e.cvx, c32289e.fGj, c32289e.fGk, c32289e.fGl);
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c32289e.cvx);
            if (C5046bo.isNullOrNil(jf.field_imgPath)) {
                jf.mo14795jv(pString.value);
                jf.mo14784hZ(pInt.value);
                jf.mo14786ia(pInt2.value);
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c32289e.cvx, jf);
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            for (C32289e c32289e2 : values) {
                if (!str.equals(c32289e2.toUserName)) {
                    this.fFO.remove(Long.valueOf(c32289e2.cvx));
                    this.fFP.remove(Long.valueOf(c32289e2.cvx));
                    C4990ab.m7413e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", str, c32289e2.toUserName);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fFP.size()) {
                arrayList.add(Integer.valueOf((int) ((C32289e) this.fFO.get(this.fFP.get(i2))).fGf));
                i = i2 + 1;
            } else {
                this.fFO.clear();
                this.fFP.clear();
                C4990ab.m7417i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", Integer.valueOf(arrayList.size()));
                AppMethodBeat.m2505o(78373);
                return arrayList;
            }
        }
    }

    /* renamed from: fL */
    public final boolean mo52999fL(long j) {
        AppMethodBeat.m2504i(78374);
        boolean containsKey = this.fFL.containsKey(Long.valueOf(j));
        AppMethodBeat.m2505o(78374);
        return containsKey;
    }

    /* renamed from: fM */
    public final C32288d mo53000fM(long j) {
        AppMethodBeat.m2504i(78375);
        C32288d c32288d = (C32288d) this.fFL.get(Long.valueOf(j));
        AppMethodBeat.m2505o(78375);
        return c32288d;
    }

    /* JADX WARNING: Missing block: B:12:0x0068, code skipped:
            if (r19.equalsIgnoreCase(r2.toUserName) == false) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo52997a(ArrayList<String> arrayList, boolean z, int i, int i2, String str) {
        C32289e c32289e;
        String str2;
        AppMethodBeat.m2504i(78376);
        C4990ab.m7417i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", Integer.valueOf(arrayList.size()), Boolean.valueOf(z), Integer.valueOf(i), str);
        Iterator it = this.fFQ.iterator();
        while (it.hasNext()) {
            c32289e = (C32289e) it.next();
            if (arrayList.contains(c32289e.fGc) && (C5046bo.isNullOrNil(c32289e.toUserName) || c32289e.toUserName.equalsIgnoreCase(str))) {
                if (!C5046bo.isNullOrNil(str)) {
                }
                c32289e.fDC = C32290n.m52724h(c32289e.fGc, str, z);
            }
            it.remove();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            Iterator it3 = this.fFQ.iterator();
            while (it3.hasNext()) {
                c32289e = (C32289e) it3.next();
                if (c32289e.fGc.equals(str3)) {
                    arrayList2.add(c32289e);
                }
            }
        }
        this.fFQ.clear();
        this.fFQ.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        if (arrayList.size() == 9) {
            C34830g.m57194BN(18);
        } else if (arrayList.size() == 1) {
            boolean isWifi = C5023at.isWifi(C4996ah.getContext());
            C34830g.m57194BN(25);
            if (isWifi) {
                if (C1853r.m3854g((String) arrayList.get(0), str, z)) {
                    C34830g.m57194BN(23);
                } else {
                    C34830g.m57194BN(21);
                }
            }
        } else {
            C34830g.m57194BN(24);
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            str2 = (String) it4.next();
            if (str2 == null || str2.equals("") || !C5730e.m8628ct(str2)) {
                C4990ab.m7410d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
            } else if (C5063r.amo(str2)) {
                C4990ab.m7417i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", str2, Long.valueOf(C5730e.asZ(str2)));
            } else if (!m52725ss(str2)) {
                arrayList3.add(str2);
            }
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            mo52996a(i, i2, (String) it5.next(), str, z);
        }
        ArrayList arrayList4 = new ArrayList();
        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15242QW("SendImgSpeeder");
        Object obj = 1;
        int i3 = 0;
        while (i3 < this.fFQ.size()) {
            C32289e c32289e2 = (C32289e) this.fFQ.get(i3);
            if (C5063r.amo(c32289e2.fGc)) {
                C4990ab.m7416i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
            } else {
                obj = null;
                C7620bi c7620bi = new C7620bi();
                c7620bi.setType(C1855t.m3926nL(str));
                c7620bi.mo14794ju(str);
                c7620bi.mo14781hO(1);
                c7620bi.setStatus(1);
                c7620bi.mo14795jv(c32289e2.fGg.value);
                c7620bi.mo14784hZ(c32289e2.fGh.value);
                c7620bi.mo14786ia(c32289e2.fGi.value);
                str2 = C1831bh.aae();
                if (!(str2 == null || str2.equals(c7620bi.dqJ)) || (str2 == null && c7620bi.dqJ != null)) {
                    c7620bi.mo14791ix(str2);
                }
                C26350a.m41930KG().mo35238g(c7620bi);
                c7620bi.mo14775eJ(C1829bf.m3756oC(c7620bi.field_talker));
                arrayList4.add(c7620bi);
                long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                if (Z <= 0) {
                    C4990ab.m7413e("MicroMsg.SendImgSpeeder", "insert error! %s", str);
                } else {
                    c32289e2.cvx = Z;
                    this.fFO.put(Long.valueOf(c32289e2.cvx), c32289e2);
                    this.fFP.add(Long.valueOf(c32289e2.cvx));
                }
            }
            i3++;
            obj = obj;
        }
        this.fFQ.clear();
        if (iV > 0) {
            C1720g.m3536RP().eJN.mo15640mB(iV);
        }
        if (obj != null) {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX("SendImgSpeeder");
        }
        AppMethodBeat.m2505o(78376);
    }

    /* renamed from: ss */
    private boolean m52725ss(String str) {
        AppMethodBeat.m2504i(78377);
        Iterator it = this.fFQ.iterator();
        while (it.hasNext()) {
            if (((C32289e) it.next()).fGc.equals(str)) {
                AppMethodBeat.m2505o(78377);
                return true;
            }
        }
        AppMethodBeat.m2505o(78377);
        return false;
    }

    public final boolean ahc() {
        AppMethodBeat.m2504i(78378);
        if (this.fFQ.size() <= 0 || C21671a.cgs().pYi > 2) {
            AppMethodBeat.m2505o(78378);
            return true;
        }
        C4990ab.m7416i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        AppMethodBeat.m2505o(78378);
        return false;
    }

    /* renamed from: a */
    public final void mo52996a(int i, int i2, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(78379);
        if (m52725ss(str)) {
            AppMethodBeat.m2505o(78379);
            return;
        }
        int h = C32290n.m52724h(str, str2, z);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        C1170b c1170b = null;
        C1170b c1170b2 = null;
        String str3 = null;
        String str4 = null;
        if (ahc()) {
            C32286b lF = this.fFM.mo52995lF(1);
            C32286b lF2 = this.fFM.mo52995lF(2);
            c1170b = lF.fFY;
            c1170b2 = lF2.fFY;
            str3 = lF2.fFZ;
            str4 = lF.fFZ;
        }
        C32291o.ahl().mo73089a(str, h, pString, pInt, pInt2, i2, str3);
        C32289e a = C32289e.m52723a(str, h, i, i2, str3, str4, pString, pInt, pInt2, c1170b, c1170b2);
        a.toUserName = str2;
        this.fFQ.add(a);
        C4990ab.m7417i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", str, str2);
        AppMethodBeat.m2505o(78379);
    }

    /* renamed from: h */
    private static int m52724h(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(78380);
        if (C1853r.m3854g(str, str2, z)) {
            AppMethodBeat.m2505o(78380);
            return 1;
        }
        AppMethodBeat.m2505o(78380);
        return 0;
    }
}
