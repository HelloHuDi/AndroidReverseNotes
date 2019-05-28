package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ar implements a {
    boolean fVW;
    boolean fVX;
    f fWa;
    c qMM;
    c qMN;
    ay qMW;
    LinkedList<ay> qMX;
    Map<String, ay> qMY;
    LinkedList<n> qMZ;
    c qNa;

    public ar() {
        AppMethodBeat.i(36657);
        this.qMX = null;
        this.qMY = null;
        this.fWa = null;
        this.qMZ = null;
        this.fVW = false;
        this.fVX = false;
        this.qNa = new c<lp>() {
            {
                AppMethodBeat.i(36653);
                this.xxI = lp.class.getName().hashCode();
                AppMethodBeat.o(36653);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(36654);
                lp lpVar = (lp) bVar;
                if (ar.this.qMW != null && bo.isEqual(ar.this.qMW.fUL, lpVar.cHq.cHr)) {
                    if (lpVar.cHq.retCode != 0) {
                        ar.this.col();
                    } else if (lpVar.cHq.cAd == 4 || lpVar.cHq.cAd == 6) {
                        ar.a(ar.this);
                    }
                }
                AppMethodBeat.o(36654);
                return false;
            }
        };
        this.qMM = new c<e>() {
            {
                AppMethodBeat.i(36655);
                this.xxI = e.class.getName().hashCode();
                AppMethodBeat.o(36655);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(36656);
                e eVar = (e) bVar;
                if (eVar.crS.className.equals("SnsTimeLineUI")) {
                    ar.this.fVX = eVar.crS.active;
                    ab.d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", Boolean.valueOf(ar.this.fVX));
                    if (ar.this.fVX || ar.this.fVW) {
                        ar.this.coi();
                    }
                    i aln = o.aln();
                    aln.fVX = ar.this.fVX;
                    if (aln.fVX) {
                        aln.stopDownload();
                    }
                }
                AppMethodBeat.o(36656);
                return false;
            }
        };
        this.qMN = new c<av>() {
            {
                AppMethodBeat.i(36645);
                this.xxI = av.class.getName().hashCode();
                AppMethodBeat.o(36645);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(36646);
                av avVar = (av) bVar;
                ar.this.fVW = avVar.ctX.ctY;
                ab.d("MicroMsg.SnsVideoService", "set isInChatting:%b", Boolean.valueOf(ar.this.fVW));
                if (ar.this.fVX || ar.this.fVW) {
                    ar.this.coi();
                }
                if (!(ar.this.fVW || ar.this.fVX)) {
                    ar.this.coj();
                }
                i aln = o.aln();
                aln.fVW = ar.this.fVW;
                if (aln.fVW) {
                    aln.stopDownload();
                } else {
                    aln.ald();
                }
                AppMethodBeat.o(36646);
                return false;
            }
        };
        this.qMW = null;
        this.qMX = new LinkedList();
        this.qMY = new HashMap();
        this.qMZ = new LinkedList();
        com.tencent.mm.sdk.b.a.xxA.c(this.qNa);
        com.tencent.mm.sdk.b.a.xxA.c(this.qMM);
        com.tencent.mm.sdk.b.a.xxA.c(this.qMN);
        AppMethodBeat.o(36657);
    }

    public final void coi() {
        AppMethodBeat.i(36658);
        ab.d("MicroMsg.SnsVideoService", "%d stop preload %s", Integer.valueOf(hashCode()), bo.dpG());
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36644);
                if (ar.this.fWa != null) {
                    ar.this.fWa.stop();
                }
                ar.this.fWa = null;
                AppMethodBeat.o(36644);
            }
        });
        AppMethodBeat.o(36658);
    }

    /* Access modifiers changed, original: final */
    public final void coj() {
        AppMethodBeat.i(36659);
        g.RS().aa(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:94:0x02ea A:{Catch:{ all -> 0x0326, Exception -> 0x032f }} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                LinkedList linkedList;
                AppMethodBeat.i(36647);
                if (ar.this.qMW != null) {
                    AppMethodBeat.o(36647);
                } else if (!ar.this.qMX.isEmpty()) {
                    AppMethodBeat.o(36647);
                } else if (ar.this.fWa != null) {
                    AppMethodBeat.o(36647);
                } else if (ar.this.fVW || ar.this.fVX) {
                    AppMethodBeat.o(36647);
                } else {
                    ar arVar;
                    String cqU;
                    String D;
                    n nVar;
                    n nVar2 = null;
                    h hVar = null;
                    PBool pBool = new PBool();
                    PInt pInt = new PInt();
                    PString pString = new PString();
                    synchronized (ar.this.qMZ) {
                        try {
                            Iterator it = ar.this.qMZ.iterator();
                            while (it.hasNext()) {
                                Object obj;
                                int i;
                                nVar2 = (n) it.next();
                                ar arVar2 = ar.this;
                                if (nVar2 == null) {
                                    pBool.value = true;
                                    obj = null;
                                } else if (bo.fp((long) nVar2.field_createTime) >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                    pBool.value = true;
                                    obj = null;
                                } else if (o.aln().cX(false)) {
                                    pBool.value = true;
                                    obj = null;
                                } else {
                                    cbf p = aj.p(nVar2);
                                    if (p == null || p.xaF == null) {
                                        ab.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                                        pBool.value = true;
                                        obj = null;
                                    } else {
                                        ab.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", Integer.valueOf(arVar2.hashCode()), nVar2.cqU(), Integer.valueOf(p.xaF.wOd), Integer.valueOf(p.xaF.wOe), p.xaF.wOf);
                                        if (p.xaF.wOd <= 0) {
                                            ab.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", Integer.valueOf(arVar2.hashCode()));
                                            pBool.value = true;
                                            obj = null;
                                        } else {
                                            pString.value = p.vQE;
                                            pInt.value = p.xaF.wOd;
                                            if (!com.tencent.mm.modelcontrol.b.rR(p.xaF.wOf)) {
                                                if (at.isWifi(ah.getContext())) {
                                                    i = p.xaF.wOe & 1;
                                                } else if (at.is4G(ah.getContext())) {
                                                    i = p.xaF.wOe & 2;
                                                } else if (at.is3G(ah.getContext())) {
                                                    i = p.xaF.wOe & 4;
                                                } else {
                                                    pBool.value = false;
                                                    obj = null;
                                                }
                                                if (i > 0) {
                                                    pBool.value = false;
                                                    obj = 1;
                                                }
                                            }
                                            pBool.value = false;
                                            obj = null;
                                        }
                                    }
                                }
                                arVar = pBool.value;
                                if (arVar == true) {
                                    it.remove();
                                }
                                if (obj != null) {
                                    i = pInt.value;
                                    String str = pString.value;
                                    if (nVar2 == null) {
                                        hVar = null;
                                    } else {
                                        bau bau = (bau) nVar2.cqu().xfI.wbK.get(0);
                                        cqU = nVar2.cqU();
                                        String a = aq.a(cqU, bau);
                                        String str2;
                                        if (bo.isNullOrNil(a)) {
                                            boolean tf = com.tencent.mm.vfs.e.tf(aq.Yg(bau.Id));
                                            D = aq.D(bau);
                                            s Yh = aq.Yh(cqU);
                                            if (Yh == null) {
                                                aq.dd(cqU, 30);
                                            } else {
                                                aq.c(Yh, 30);
                                            }
                                            ab.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", D, Boolean.valueOf(tf));
                                            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(bau.Id);
                                            aVar.qJh = bau;
                                            az dtl = az.dtl();
                                            dtl.oyB = nVar2.field_createTime;
                                            aVar.qNW = dtl;
                                            aVar.qNU = true;
                                            aVar.url = bau.Url;
                                            aVar.qNT = false;
                                            com.tencent.mm.modelvideo.n.alj();
                                            o.alm();
                                            dtl = aVar.qNW;
                                            arVar = aVar.url;
                                            hVar = com.tencent.mm.al.e.a(dtl, arVar, D, aq.ug(cqU), 2);
                                            if (hVar == null) {
                                                hVar = null;
                                            } else {
                                                arVar = bau.wFc;
                                                hVar.cdx = arVar;
                                                hVar.field_preloadRatio = i;
                                                hVar.cFc = str;
                                                str2 = nVar2.field_userName;
                                                hVar.egE = str2;
                                                hVar.cEV = str2;
                                            }
                                        } else {
                                            ab.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", a);
                                            str2 = bau.wFc;
                                            long asZ = com.tencent.mm.vfs.e.asZ(a);
                                            int i2 = 3;
                                            o.aln().a(str2, 3, asZ, nVar2.field_userName, "", 0, "", bau.Url, str);
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 147, 1, false);
                                            hVar = null;
                                        }
                                    }
                                    if (hVar != null) {
                                        break;
                                    }
                                    it.remove();
                                } else {
                                    nVar2 = null;
                                }
                            }
                            nVar = nVar2;
                        } catch (Throwable th) {
                            AppMethodBeat.o(36647);
                        }
                    }
                    if (nVar == null || hVar == null) {
                        AppMethodBeat.o(36647);
                        return;
                    }
                    String e = null;
                    if (hVar != null) {
                        try {
                            ar.this.fWa = new f(hVar, nVar.cqU());
                            f fVar = ar.this.fWa;
                            arVar = ar.this;
                            if (fVar.a(arVar) < 0) {
                                e = "MicroMsg.SnsVideoService";
                                cqU = "%s curr preload task do scene error.";
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cqU = "MicroMsg.SnsVideoService";
                            nVar = "";
                            return;
                        } finally {
                            linkedList = 36647;
                            AppMethodBeat.o(36647);
                        }
                    } else {
                        boolean e3 = true;
                    }
                    if (e3 != null) {
                        linkedList = ar.this.qMZ;
                        synchronized (linkedList) {
                            arVar = ar.this.qMZ.iterator();
                            if (!arVar.hasNext()) {
                                nVar2 = (n) arVar.next();
                                if (nVar2 != null && bo.isEqual(nVar2.cqU(), r4.cqU())) {
                                    e3 = "MicroMsg.SnsVideoService";
                                    D = "%d find sns info[%s], remove now";
                                }
                                if (arVar.hasNext()) {
                                }
                            }
                            AppMethodBeat.o(36647);
                            return;
                        }
                    }
                    AppMethodBeat.o(36647);
                }
            }
        });
        AppMethodBeat.o(36659);
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        AppMethodBeat.i(36660);
        if (fVar == null) {
            ab.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            AppMethodBeat.o(36660);
            return;
        }
        if (this.fWa != fVar) {
            ab.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        ab.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.alc(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36648);
                String str = fVar.cwT;
                synchronized (ar.this.qMZ) {
                    try {
                        Iterator it = ar.this.qMZ.iterator();
                        while (it.hasNext()) {
                            n nVar = (n) it.next();
                            if (nVar != null && bo.isEqual(str, nVar.cqU())) {
                                ab.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", Integer.valueOf(ar.this.hashCode()), str);
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(36648);
                    }
                }
                o.aln().cW(false);
                if (ar.this.fWa != null) {
                    ar.this.fWa.fVC = null;
                }
                ar.this.fWa = null;
                ar.this.cok();
                ar.this.coj();
                AppMethodBeat.o(36648);
            }
        });
        AppMethodBeat.o(36660);
    }

    /* Access modifiers changed, original: final */
    public final boolean cok() {
        int i;
        AppMethodBeat.i(36661);
        long yz = bo.yz();
        ab.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(bo.anT() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("SnSPreLoadVideoExpiredTime", 1)) * TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC)));
        List<s> v = o.all().v(130, r0);
        if (v == null || v.isEmpty()) {
            AppMethodBeat.o(36661);
            return false;
        }
        int i2 = 0;
        for (s sVar : v) {
            if (sVar != null) {
                try {
                    int i3;
                    String D = aq.D((bau) af.cnF().YT(aq.Yf(sVar.getFileName())).cqu().xfI.wbK.get(0));
                    if (!bo.isNullOrNil(D)) {
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(D);
                        if (bVar.exists()) {
                            long length = bVar.length();
                            ab.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", sVar.getFileName(), Long.valueOf(length), Integer.valueOf(sVar.cFa), Long.valueOf(sVar.fXb), D);
                            if (length > 0 && length <= ((long) sVar.cFa)) {
                                bVar.delete();
                                i3 = i2 + 1;
                                sVar.cFa = 0;
                                sVar.bJt = 1;
                                u.f(sVar);
                                i2 = i3;
                            }
                        }
                    }
                    i3 = i2;
                    try {
                        sVar.cFa = 0;
                        sVar.bJt = 1;
                        u.f(sVar);
                        i2 = i3;
                    } catch (Exception e) {
                        i = i3;
                        i2 = i;
                    }
                } catch (Exception e2) {
                    i = i2;
                    i2 = i;
                }
            }
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(354, 145, (long) i2, false);
        ab.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(v.size()), Integer.valueOf(i2), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(36661);
        return false;
    }

    public final boolean a(bau bau, int i, String str, boolean z, final boolean z2, int i2) {
        int i3 = 0;
        AppMethodBeat.i(36662);
        if (bau.wEG == 2) {
            ab.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            AppMethodBeat.o(36662);
            return false;
        }
        final ay ayVar = new ay();
        ayVar.fUL = aq.be(i, bau.Url);
        ayVar.cNr = bau;
        ayVar.fDG = i;
        ayVar.cwT = str;
        if (z) {
            i3 = 1;
        }
        ayVar.egD = i3;
        ayVar.egF = i2;
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                String str;
                AppMethodBeat.i(36650);
                n YT = af.cnF().YT(ayVar.cwT);
                ay ayVar = ayVar;
                if (YT != null) {
                    str = YT.field_userName;
                } else {
                    str = "";
                }
                ayVar.qNS = str;
                ab.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", Boolean.valueOf(z2), ayVar);
                if (z2) {
                    ar.this.qMX.offerFirst(ayVar);
                } else {
                    ar.this.qMX.offerLast(ayVar);
                }
                ar.this.qMY.put(ayVar.fUL, ayVar);
                AppMethodBeat.o(36650);
            }
        });
        if (z2) {
            col();
        }
        AppMethodBeat.o(36662);
        return true;
    }

    public final boolean s(final String str, final Object[] objArr) {
        AppMethodBeat.i(36663);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36663);
            return false;
        }
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36649);
                o.alm().m(str, objArr);
                if (ar.this.qMW != null && bo.isEqual(ar.this.qMW.fUL, str)) {
                    ar.a(ar.this);
                }
                ar.this.qMX.remove((ay) ar.this.qMY.get(str));
                AppMethodBeat.o(36649);
            }
        });
        AppMethodBeat.o(36663);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void col() {
        AppMethodBeat.i(36664);
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                boolean z = true;
                AppMethodBeat.i(36651);
                if (ar.this.qMX.isEmpty()) {
                    ab.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
                    AppMethodBeat.o(36651);
                    return;
                }
                ay ayVar = (ay) ar.this.qMX.poll();
                if (ayVar == null) {
                    ab.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", Integer.valueOf(ar.this.qMX.size()));
                    AppMethodBeat.o(36651);
                    return;
                }
                if (ar.this.qMW == null || !ayVar.fUL.equals(ar.this.qMW.fUL)) {
                    z = false;
                }
                ar.this.a(ayVar, z);
                AppMethodBeat.o(36651);
            }
        });
        AppMethodBeat.o(36664);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(ay ayVar, boolean z) {
        AppMethodBeat.i(36665);
        if (bo.isNullOrNil(aq.a(ayVar.cwT, ayVar.cNr))) {
            boolean tf = com.tencent.mm.vfs.e.tf(aq.Yg(ayVar.cNr.Id));
            String D = aq.D(ayVar.cNr);
            s Yh = aq.Yh(ayVar.cwT);
            if (Yh == null) {
                aq.dd(ayVar.cwT, ayVar.egF);
            } else {
                aq.c(Yh, ayVar.egF);
            }
            ab.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", D, Boolean.valueOf(tf));
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(ayVar.cNr.Id);
            aVar.qJh = ayVar.cNr;
            az dtl = az.dtl();
            dtl.oyB = ayVar.fDG;
            aVar.qNW = dtl;
            aVar.qNU = true;
            aVar.url = ayVar.cNr.Url;
            aVar.qNT = false;
            com.tencent.mm.modelvideo.n.alj();
            o.alm();
            h a = com.tencent.mm.al.e.a(aVar.qNW, aVar.url, D, aq.ug(ayVar.cwT), ayVar.egD);
            if (a == null) {
                AppMethodBeat.o(36665);
                return false;
            }
            D = ayVar.qNS;
            a.egE = D;
            a.cEV = D;
            try {
                cbf p = aj.p(af.cnF().YT(ayVar.cwT));
                if (p != null) {
                    a.cFc = p.vQE;
                    a.egI = p.xaF.wOd;
                }
            } catch (Exception e) {
            }
            this.qMW = ayVar;
            this.qMW.fUL = a.field_mediaId;
            ab.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", this.qMW.fUL, Boolean.valueOf(z));
            o.alm().a(a, z);
            AppMethodBeat.o(36665);
            return true;
        }
        ab.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", ayVar.fUL, ayVar.cwT, aq.a(ayVar.cwT, ayVar.cNr));
        AppMethodBeat.o(36665);
        return false;
    }

    static /* synthetic */ void a(ar arVar) {
        AppMethodBeat.i(36666);
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36652);
                if (ar.this.qMW != null) {
                    ab.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", ar.this.qMW.fUL);
                    ar.this.qMY.remove(ar.this.qMW.fUL);
                }
                ar.this.qMW = null;
                ar.this.col();
                AppMethodBeat.o(36652);
            }
        });
        AppMethodBeat.o(36666);
    }
}
