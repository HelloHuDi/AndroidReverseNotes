package com.tencent.mm.at;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n {
    private static n fFN;
    ConcurrentHashMap<Long, d> fFL = new ConcurrentHashMap();
    public c fFM = new c();
    public ConcurrentHashMap<Long, e> fFO = new ConcurrentHashMap();
    private ArrayList<Long> fFP = new ArrayList();
    ArrayList<e> fFQ = new ArrayList();

    public static class a {
        static ak cbT;
        private ReentrantLock cbR = new ReentrantLock();
        private Condition cbS = this.cbR.newCondition();
        int fDC;
        a fFR;

        public static class a {
            String fDK;
            PString fFU;
            PString fFV;
            PString fFW;
            PString fFX;
        }

        public a() {
            AppMethodBeat.i(78358);
            AppMethodBeat.o(78358);
        }

        public static a a(final e eVar) {
            AppMethodBeat.i(78359);
            synchronized (a.class) {
                try {
                    if (cbT == null) {
                        HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                        handlerThread.start();
                        cbT = new ak(handlerThread.getLooper());
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(78359);
                }
            }
            a aVar = new a();
            eVar.fGl = aVar;
            cbT.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78357);
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    a aVar = new a();
                    aVar.fFU = new PString();
                    aVar.fFV = new PString();
                    aVar.fFW = new PString();
                    aVar.fFX = new PString();
                    aVar.fDK = o.ahl().a(eVar.fGc, f.sh(eVar.fGc), eVar.fDC, true, aVar.fFU, aVar.fFV, aVar.fFW, aVar.fFX, eVar.fGe, eVar.fGj);
                    a.this.cbR.lock();
                    try {
                        a.this.fFR = aVar;
                        a.this.cbS.signal();
                        ab.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", eVar.fGc, Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                    } finally {
                        a.this.cbR.unlock();
                        AppMethodBeat.o(78357);
                    }
                }
            });
            aVar.fDC = eVar.fDC;
            return aVar;
        }

        public final a ahe() {
            AppMethodBeat.i(78360);
            this.cbR.lock();
            while (this.fFR == null) {
                try {
                    ab.i("MicroMsg.SendImgSpeeder", "getResult await");
                    this.cbS.await();
                } catch (Exception e) {
                    this.cbR.unlock();
                } catch (Throwable th) {
                    this.cbR.unlock();
                    AppMethodBeat.o(78360);
                }
            }
            this.cbR.unlock();
            a aVar = this.fFR;
            AppMethodBeat.o(78360);
            return aVar;
        }
    }

    static class b {
        com.tencent.mm.a.b fFY;
        String fFZ;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class c {
        public LinkedList<b> fGa = new LinkedList();
        public LinkedList<b> fGb = new LinkedList();

        public c() {
            AppMethodBeat.i(78361);
            AppMethodBeat.o(78361);
        }

        public static b st(String str) {
            AppMethodBeat.i(78363);
            b bVar = new b();
            if (bo.isNullOrNil(str)) {
                bVar.fFZ = g.agW();
            } else {
                bVar.fFZ = str;
            }
            String sm = o.ahl().sm(bVar.fFZ);
            if (sv(sm)) {
                bVar.fFY = new com.tencent.mm.a.b(sm);
                AppMethodBeat.o(78363);
                return bVar;
            }
            AppMethodBeat.o(78363);
            return null;
        }

        public static b su(String str) {
            AppMethodBeat.i(78364);
            b bVar = new b();
            if (bo.isNullOrNil(str)) {
                bVar.fFZ = g.agW();
            } else {
                bVar.fFZ = str;
            }
            String sl = o.ahl().sl(bVar.fFZ);
            if (sv(sl)) {
                bVar.fFY = new com.tencent.mm.a.b(sl);
                AppMethodBeat.o(78364);
                return bVar;
            }
            AppMethodBeat.o(78364);
            return null;
        }

        private static boolean sv(String str) {
            AppMethodBeat.i(78365);
            if (com.tencent.mm.vfs.e.asZ(str) > 0) {
                ab.e("MicroMsg.SendImgSpeeder", "file has exist %s", str);
                AppMethodBeat.o(78365);
                return false;
            }
            AppMethodBeat.o(78365);
            return true;
        }

        public final synchronized b lF(int i) {
            b bVar = null;
            synchronized (this) {
                AppMethodBeat.i(78366);
                if (i == 1) {
                    if (this.fGa.size() > 0) {
                        bVar = (b) this.fGa.remove();
                        ahg();
                    } else {
                        bVar = st(null);
                    }
                } else if (i == 2) {
                    if (this.fGb.size() > 0) {
                        bVar = (b) this.fGb.remove();
                        ahh();
                    } else {
                        bVar = su(null);
                    }
                }
                ahf();
                AppMethodBeat.o(78366);
            }
            return bVar;
        }

        private synchronized void ahg() {
            AppMethodBeat.i(78367);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.fGa.size(); i++) {
                stringBuilder.append(((b) this.fGa.get(i)).fFZ);
                if (i != this.fGa.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            ab.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", stringBuilder.toString());
            g.RP().Ry().set(348176, stringBuilder.toString());
            AppMethodBeat.o(78367);
        }

        private synchronized void ahh() {
            AppMethodBeat.i(78368);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.fGb.size(); i++) {
                stringBuilder.append(((b) this.fGb.get(i)).fFZ);
                if (i != this.fGb.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            ab.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", stringBuilder.toString());
            g.RP().Ry().set(348177, stringBuilder.toString());
            AppMethodBeat.o(78368);
        }

        public final synchronized void ahf() {
            int i = 0;
            synchronized (this) {
                AppMethodBeat.i(78362);
                int size = this.fGa.size();
                if (size <= 0) {
                    int i2 = 5 - size;
                    for (size = 0; size < i2; size++) {
                        this.fGa.add(st(null));
                    }
                    ab.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", Integer.valueOf(i2), Integer.valueOf(this.fGa.size()));
                    ahg();
                }
                size = this.fGb.size();
                if (size <= 0) {
                    size = 5 - size;
                    while (i < size) {
                        this.fGb.add(su(null));
                        i++;
                    }
                    ahh();
                    ab.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", Integer.valueOf(size), Integer.valueOf(this.fGb.size()));
                }
                AppMethodBeat.o(78362);
            }
        }
    }

    public static class d {
        public long cET;
        public long xb;
    }

    public static class e {
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
        com.tencent.mm.a.b fGj;
        com.tencent.mm.a.b fGk;
        a fGl;
        String toUserName;

        public static e a(String str, int i, int i2, int i3, String str2, String str3, PString pString, PInt pInt, PInt pInt2, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2) {
            AppMethodBeat.i(78369);
            e eVar = new e();
            eVar.fGc = str;
            eVar.fDC = i;
            eVar.cvd = i2;
            eVar.cDW = i3;
            eVar.fGd = str2;
            eVar.fGg = pString;
            eVar.fGi = pInt2;
            eVar.fGh = pInt;
            eVar.fGe = str3;
            eVar.fGk = bVar2;
            eVar.fGj = bVar;
            if (n.fFN.ahc()) {
                a.a(eVar);
            }
            AppMethodBeat.o(78369);
            return eVar;
        }
    }

    public n() {
        AppMethodBeat.i(78370);
        AppMethodBeat.o(78370);
    }

    public static n ahb() {
        AppMethodBeat.i(78371);
        if (fFN == null) {
            synchronized (n.class) {
                try {
                    if (fFN == null) {
                        fFN = new n();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78371);
                    }
                }
            }
        }
        n nVar = fFN;
        AppMethodBeat.o(78371);
        return nVar;
    }

    public final ArrayList<String> sq(String str) {
        AppMethodBeat.i(78372);
        ArrayList arrayList = new ArrayList();
        if (!bo.isNullOrNil(str)) {
            for (e eVar : this.fFO.values()) {
                if (str.equals(eVar.toUserName)) {
                    arrayList.add(eVar.fGc);
                }
            }
        }
        AppMethodBeat.o(78372);
        return arrayList;
    }

    public final ArrayList<Integer> sr(String str) {
        AppMethodBeat.i(78373);
        Collection<e> values = this.fFO.values();
        for (e eVar : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            eVar.fGf = o.ahl().a(eVar.fGc, eVar.fDC, eVar.cvd, eVar.cDW, pString, pInt, pInt2, eVar.fGd, eVar.fGe, eVar.cvx, eVar.fGj, eVar.fGk, eVar.fGl);
            bi jf = ((j) g.K(j.class)).bOr().jf(eVar.cvx);
            if (bo.isNullOrNil(jf.field_imgPath)) {
                jf.jv(pString.value);
                jf.hZ(pInt.value);
                jf.ia(pInt2.value);
                ((j) g.K(j.class)).bOr().a(eVar.cvx, jf);
            }
        }
        if (!bo.isNullOrNil(str)) {
            for (e eVar2 : values) {
                if (!str.equals(eVar2.toUserName)) {
                    this.fFO.remove(Long.valueOf(eVar2.cvx));
                    this.fFP.remove(Long.valueOf(eVar2.cvx));
                    ab.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", str, eVar2.toUserName);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fFP.size()) {
                arrayList.add(Integer.valueOf((int) ((e) this.fFO.get(this.fFP.get(i2))).fGf));
                i = i2 + 1;
            } else {
                this.fFO.clear();
                this.fFP.clear();
                ab.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", Integer.valueOf(arrayList.size()));
                AppMethodBeat.o(78373);
                return arrayList;
            }
        }
    }

    public final boolean fL(long j) {
        AppMethodBeat.i(78374);
        boolean containsKey = this.fFL.containsKey(Long.valueOf(j));
        AppMethodBeat.o(78374);
        return containsKey;
    }

    public final d fM(long j) {
        AppMethodBeat.i(78375);
        d dVar = (d) this.fFL.get(Long.valueOf(j));
        AppMethodBeat.o(78375);
        return dVar;
    }

    /* JADX WARNING: Missing block: B:12:0x0068, code skipped:
            if (r19.equalsIgnoreCase(r2.toUserName) == false) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ArrayList<String> arrayList, boolean z, int i, int i2, String str) {
        e eVar;
        String str2;
        AppMethodBeat.i(78376);
        ab.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", Integer.valueOf(arrayList.size()), Boolean.valueOf(z), Integer.valueOf(i), str);
        Iterator it = this.fFQ.iterator();
        while (it.hasNext()) {
            eVar = (e) it.next();
            if (arrayList.contains(eVar.fGc) && (bo.isNullOrNil(eVar.toUserName) || eVar.toUserName.equalsIgnoreCase(str))) {
                if (!bo.isNullOrNil(str)) {
                }
                eVar.fDC = h(eVar.fGc, str, z);
            }
            it.remove();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            Iterator it3 = this.fFQ.iterator();
            while (it3.hasNext()) {
                eVar = (e) it3.next();
                if (eVar.fGc.equals(str3)) {
                    arrayList2.add(eVar);
                }
            }
        }
        this.fFQ.clear();
        this.fFQ.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        if (arrayList.size() == 9) {
            com.tencent.mm.plugin.report.service.g.BN(18);
        } else if (arrayList.size() == 1) {
            boolean isWifi = at.isWifi(ah.getContext());
            com.tencent.mm.plugin.report.service.g.BN(25);
            if (isWifi) {
                if (r.g((String) arrayList.get(0), str, z)) {
                    com.tencent.mm.plugin.report.service.g.BN(23);
                } else {
                    com.tencent.mm.plugin.report.service.g.BN(21);
                }
            }
        } else {
            com.tencent.mm.plugin.report.service.g.BN(24);
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            str2 = (String) it4.next();
            if (str2 == null || str2.equals("") || !com.tencent.mm.vfs.e.ct(str2)) {
                ab.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
            } else if (com.tencent.mm.sdk.platformtools.r.amo(str2)) {
                ab.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", str2, Long.valueOf(com.tencent.mm.vfs.e.asZ(str2)));
            } else if (!ss(str2)) {
                arrayList3.add(str2);
            }
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            a(i, i2, (String) it5.next(), str, z);
        }
        ArrayList arrayList4 = new ArrayList();
        long iV = g.RP().eJN.iV(Thread.currentThread().getId());
        ((j) g.K(j.class)).bOr().QW("SendImgSpeeder");
        Object obj = 1;
        int i3 = 0;
        while (i3 < this.fFQ.size()) {
            e eVar2 = (e) this.fFQ.get(i3);
            if (com.tencent.mm.sdk.platformtools.r.amo(eVar2.fGc)) {
                ab.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
            } else {
                obj = null;
                bi biVar = new bi();
                biVar.setType(t.nL(str));
                biVar.ju(str);
                biVar.hO(1);
                biVar.setStatus(1);
                biVar.jv(eVar2.fGg.value);
                biVar.hZ(eVar2.fGh.value);
                biVar.ia(eVar2.fGi.value);
                str2 = bh.aae();
                if (!(str2 == null || str2.equals(biVar.dqJ)) || (str2 == null && biVar.dqJ != null)) {
                    biVar.ix(str2);
                }
                com.tencent.mm.l.a.a.KG().g(biVar);
                biVar.eJ(bf.oC(biVar.field_talker));
                arrayList4.add(biVar);
                long Z = ((j) g.K(j.class)).bOr().Z(biVar);
                if (Z <= 0) {
                    ab.e("MicroMsg.SendImgSpeeder", "insert error! %s", str);
                } else {
                    eVar2.cvx = Z;
                    this.fFO.put(Long.valueOf(eVar2.cvx), eVar2);
                    this.fFP.add(Long.valueOf(eVar2.cvx));
                }
            }
            i3++;
            obj = obj;
        }
        this.fFQ.clear();
        if (iV > 0) {
            g.RP().eJN.mB(iV);
        }
        if (obj != null) {
            ((j) g.K(j.class)).bOr().QX("SendImgSpeeder");
        }
        AppMethodBeat.o(78376);
    }

    private boolean ss(String str) {
        AppMethodBeat.i(78377);
        Iterator it = this.fFQ.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).fGc.equals(str)) {
                AppMethodBeat.o(78377);
                return true;
            }
        }
        AppMethodBeat.o(78377);
        return false;
    }

    public final boolean ahc() {
        AppMethodBeat.i(78378);
        if (this.fFQ.size() <= 0 || com.tencent.mm.plugin.report.service.g.a.cgs().pYi > 2) {
            AppMethodBeat.o(78378);
            return true;
        }
        ab.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        AppMethodBeat.o(78378);
        return false;
    }

    public final void a(int i, int i2, String str, String str2, boolean z) {
        AppMethodBeat.i(78379);
        if (ss(str)) {
            AppMethodBeat.o(78379);
            return;
        }
        int h = h(str, str2, z);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        com.tencent.mm.a.b bVar = null;
        com.tencent.mm.a.b bVar2 = null;
        String str3 = null;
        String str4 = null;
        if (ahc()) {
            b lF = this.fFM.lF(1);
            b lF2 = this.fFM.lF(2);
            bVar = lF.fFY;
            bVar2 = lF2.fFY;
            str3 = lF2.fFZ;
            str4 = lF.fFZ;
        }
        o.ahl().a(str, h, pString, pInt, pInt2, i2, str3);
        e a = e.a(str, h, i, i2, str3, str4, pString, pInt, pInt2, bVar, bVar2);
        a.toUserName = str2;
        this.fFQ.add(a);
        ab.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", str, str2);
        AppMethodBeat.o(78379);
    }

    private static int h(String str, String str2, boolean z) {
        AppMethodBeat.i(78380);
        if (r.g(str, str2, z)) {
            AppMethodBeat.o(78380);
            return 1;
        }
        AppMethodBeat.o(78380);
        return 0;
    }
}
