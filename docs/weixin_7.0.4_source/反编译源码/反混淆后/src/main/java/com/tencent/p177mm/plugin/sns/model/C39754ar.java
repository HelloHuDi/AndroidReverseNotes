package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C32837f;
import com.tencent.p177mm.modelvideo.C32837f.C18706a;
import com.tencent.p177mm.modelvideo.C32847i;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p230g.p231a.C32594lp;
import com.tencent.p177mm.p230g.p231a.C41969av;
import com.tencent.p177mm.p230g.p231a.C9326e;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.model.p519a.C46216a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.model.ar */
public final class C39754ar implements C18706a {
    boolean fVW;
    boolean fVX;
    C32837f fWa;
    C4884c qMM;
    C4884c qMN;
    C43557ay qMW;
    LinkedList<C43557ay> qMX;
    Map<String, C43557ay> qMY;
    LinkedList<C46236n> qMZ;
    C4884c qNa;

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$8 */
    class C38948 implements Runnable {
        C38948() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36652);
            if (C39754ar.this.qMW != null) {
                C4990ab.m7417i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", C39754ar.this.qMW.fUL);
                C39754ar.this.qMY.remove(C39754ar.this.qMW.fUL);
            }
            C39754ar.this.qMW = null;
            C39754ar.this.col();
            AppMethodBeat.m2505o(36652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$7 */
    class C219167 implements Runnable {
        C219167() {
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(36651);
            if (C39754ar.this.qMX.isEmpty()) {
                C4990ab.m7416i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
                AppMethodBeat.m2505o(36651);
                return;
            }
            C43557ay c43557ay = (C43557ay) C39754ar.this.qMX.poll();
            if (c43557ay == null) {
                C4990ab.m7421w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", Integer.valueOf(C39754ar.this.qMX.size()));
                AppMethodBeat.m2505o(36651);
                return;
            }
            if (C39754ar.this.qMW == null || !c43557ay.fUL.equals(C39754ar.this.qMW.fUL)) {
                z = false;
            }
            C39754ar.this.mo62850a(c43557ay, z);
            AppMethodBeat.m2505o(36651);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$10 */
    class C2904610 extends C4884c<C9326e> {
        C2904610() {
            AppMethodBeat.m2504i(36655);
            this.xxI = C9326e.class.getName().hashCode();
            AppMethodBeat.m2505o(36655);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36656);
            C9326e c9326e = (C9326e) c4883b;
            if (c9326e.crS.className.equals("SnsTimeLineUI")) {
                C39754ar.this.fVX = c9326e.crS.active;
                C4990ab.m7411d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", Boolean.valueOf(C39754ar.this.fVX));
                if (C39754ar.this.fVX || C39754ar.this.fVW) {
                    C39754ar.this.coi();
                }
                C32847i aln = C37961o.aln();
                aln.fVX = C39754ar.this.fVX;
                if (aln.fVX) {
                    aln.stopDownload();
                }
            }
            AppMethodBeat.m2505o(36656);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$9 */
    class C349589 extends C4884c<C32594lp> {
        C349589() {
            AppMethodBeat.m2504i(36653);
            this.xxI = C32594lp.class.getName().hashCode();
            AppMethodBeat.m2505o(36653);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36654);
            C32594lp c32594lp = (C32594lp) c4883b;
            if (C39754ar.this.qMW != null && C5046bo.isEqual(C39754ar.this.qMW.fUL, c32594lp.cHq.cHr)) {
                if (c32594lp.cHq.retCode != 0) {
                    C39754ar.this.col();
                } else if (c32594lp.cHq.cAd == 4 || c32594lp.cHq.cAd == 6) {
                    C39754ar.m67991a(C39754ar.this);
                }
            }
            AppMethodBeat.m2505o(36654);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$2 */
    class C397522 extends C4884c<C41969av> {
        C397522() {
            AppMethodBeat.m2504i(36645);
            this.xxI = C41969av.class.getName().hashCode();
            AppMethodBeat.m2505o(36645);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36646);
            C41969av c41969av = (C41969av) c4883b;
            C39754ar.this.fVW = c41969av.ctX.ctY;
            C4990ab.m7411d("MicroMsg.SnsVideoService", "set isInChatting:%b", Boolean.valueOf(C39754ar.this.fVW));
            if (C39754ar.this.fVX || C39754ar.this.fVW) {
                C39754ar.this.coi();
            }
            if (!(C39754ar.this.fVW || C39754ar.this.fVX)) {
                C39754ar.this.coj();
            }
            C32847i aln = C37961o.aln();
            aln.fVW = C39754ar.this.fVW;
            if (aln.fVW) {
                aln.stopDownload();
            } else {
                aln.ald();
            }
            AppMethodBeat.m2505o(36646);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$3 */
    class C397533 implements Runnable {
        C397533() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:94:0x02ea A:{Catch:{ all -> 0x0326, Exception -> 0x032f }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            LinkedList linkedList;
            AppMethodBeat.m2504i(36647);
            if (C39754ar.this.qMW != null) {
                AppMethodBeat.m2505o(36647);
            } else if (!C39754ar.this.qMX.isEmpty()) {
                AppMethodBeat.m2505o(36647);
            } else if (C39754ar.this.fWa != null) {
                AppMethodBeat.m2505o(36647);
            } else if (C39754ar.this.fVW || C39754ar.this.fVX) {
                AppMethodBeat.m2505o(36647);
            } else {
                C39754ar c39754ar;
                String cqU;
                String D;
                C46236n c46236n;
                C46236n c46236n2 = null;
                C44686h c44686h = null;
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                PString pString = new PString();
                synchronized (C39754ar.this.qMZ) {
                    try {
                        Iterator it = C39754ar.this.qMZ.iterator();
                        while (it.hasNext()) {
                            Object obj;
                            int i;
                            c46236n2 = (C46236n) it.next();
                            C39754ar c39754ar2 = C39754ar.this;
                            if (c46236n2 == null) {
                                pBool.value = true;
                                obj = null;
                            } else if (C5046bo.m7549fp((long) c46236n2.field_createTime) >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                pBool.value = true;
                                obj = null;
                            } else if (C37961o.aln().mo53415cX(false)) {
                                pBool.value = true;
                                obj = null;
                            } else {
                                cbf p = C34955aj.m57408p(c46236n2);
                                if (p == null || p.xaF == null) {
                                    C4990ab.m7416i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                                    pBool.value = true;
                                    obj = null;
                                } else {
                                    C4990ab.m7417i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", Integer.valueOf(c39754ar2.hashCode()), c46236n2.cqU(), Integer.valueOf(p.xaF.wOd), Integer.valueOf(p.xaF.wOe), p.xaF.wOf);
                                    if (p.xaF.wOd <= 0) {
                                        C4990ab.m7417i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", Integer.valueOf(c39754ar2.hashCode()));
                                        pBool.value = true;
                                        obj = null;
                                    } else {
                                        pString.value = p.vQE;
                                        pInt.value = p.xaF.wOd;
                                        if (!C45448b.m83719rR(p.xaF.wOf)) {
                                            if (C5023at.isWifi(C4996ah.getContext())) {
                                                i = p.xaF.wOe & 1;
                                            } else if (C5023at.is4G(C4996ah.getContext())) {
                                                i = p.xaF.wOe & 2;
                                            } else if (C5023at.is3G(C4996ah.getContext())) {
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
                            c39754ar = pBool.value;
                            if (c39754ar == true) {
                                it.remove();
                            }
                            if (obj != null) {
                                i = pInt.value;
                                String str = pString.value;
                                if (c46236n2 == null) {
                                    c44686h = null;
                                } else {
                                    bau bau = (bau) c46236n2.cqu().xfI.wbK.get(0);
                                    cqU = c46236n2.cqU();
                                    String a = C34957aq.m57415a(cqU, bau);
                                    String str2;
                                    if (C5046bo.isNullOrNil(a)) {
                                        boolean tf = C5730e.m8643tf(C34957aq.m57413Yg(bau.f17915Id));
                                        D = C34957aq.m57411D(bau);
                                        C26493s Yh = C34957aq.m57414Yh(cqU);
                                        if (Yh == null) {
                                            C34957aq.m57418dd(cqU, 30);
                                        } else {
                                            C34957aq.m57417c(Yh, 30);
                                        }
                                        C4990ab.m7417i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", D, Boolean.valueOf(tf));
                                        C46216a c46216a = new C46216a(bau.f17915Id);
                                        c46216a.qJh = bau;
                                        C44222az dtl = C44222az.dtl();
                                        dtl.oyB = c46236n2.field_createTime;
                                        c46216a.qNW = dtl;
                                        c46216a.qNU = true;
                                        c46216a.url = bau.Url;
                                        c46216a.qNT = false;
                                        C45459n.alj();
                                        C37961o.alm();
                                        dtl = c46216a.qNW;
                                        c39754ar = c46216a.url;
                                        c44686h = C45150e.m83024a(dtl, c39754ar, D, C34957aq.m57420ug(cqU), 2);
                                        if (c44686h == null) {
                                            c44686h = null;
                                        } else {
                                            c39754ar = bau.wFc;
                                            c44686h.cdx = c39754ar;
                                            c44686h.field_preloadRatio = i;
                                            c44686h.cFc = str;
                                            str2 = c46236n2.field_userName;
                                            c44686h.egE = str2;
                                            c44686h.cEV = str2;
                                        }
                                    } else {
                                        C4990ab.m7417i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", a);
                                        str2 = bau.wFc;
                                        long asZ = C5730e.asZ(a);
                                        int i2 = 3;
                                        C37961o.aln().mo53412a(str2, 3, asZ, c46236n2.field_userName, "", 0, "", bau.Url, str);
                                        C7060h.pYm.mo8378a(354, 147, 1, false);
                                        c44686h = null;
                                    }
                                }
                                if (c44686h != null) {
                                    break;
                                }
                                it.remove();
                            } else {
                                c46236n2 = null;
                            }
                        }
                        c46236n = c46236n2;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(36647);
                    }
                }
                if (c46236n == null || c44686h == null) {
                    AppMethodBeat.m2505o(36647);
                    return;
                }
                String e = null;
                if (c44686h != null) {
                    try {
                        C39754ar.this.fWa = new C32837f(c44686h, c46236n.cqU());
                        C32837f c32837f = C39754ar.this.fWa;
                        c39754ar = C39754ar.this;
                        if (c32837f.mo53406a(c39754ar) < 0) {
                            e = "MicroMsg.SnsVideoService";
                            cqU = "%s curr preload task do scene error.";
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cqU = "MicroMsg.SnsVideoService";
                        c46236n = "";
                        return;
                    } finally {
                        linkedList = 36647;
                        AppMethodBeat.m2505o(36647);
                    }
                } else {
                    boolean e3 = true;
                }
                if (e3 != null) {
                    linkedList = C39754ar.this.qMZ;
                    synchronized (linkedList) {
                        c39754ar = C39754ar.this.qMZ.iterator();
                        if (!c39754ar.hasNext()) {
                            c46236n2 = (C46236n) c39754ar.next();
                            if (c46236n2 != null && C5046bo.isEqual(c46236n2.cqU(), r4.cqU())) {
                                e3 = "MicroMsg.SnsVideoService";
                                D = "%d find sns info[%s], remove now";
                            }
                            if (c39754ar.hasNext()) {
                            }
                        }
                        AppMethodBeat.m2505o(36647);
                        return;
                    }
                }
                AppMethodBeat.m2505o(36647);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ar$1 */
    class C397551 implements Runnable {
        C397551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36644);
            if (C39754ar.this.fWa != null) {
                C39754ar.this.fWa.stop();
            }
            C39754ar.this.fWa = null;
            AppMethodBeat.m2505o(36644);
        }
    }

    public C39754ar() {
        AppMethodBeat.m2504i(36657);
        this.qMX = null;
        this.qMY = null;
        this.fWa = null;
        this.qMZ = null;
        this.fVW = false;
        this.fVX = false;
        this.qNa = new C349589();
        this.qMM = new C2904610();
        this.qMN = new C397522();
        this.qMW = null;
        this.qMX = new LinkedList();
        this.qMY = new HashMap();
        this.qMZ = new LinkedList();
        C4879a.xxA.mo10052c(this.qNa);
        C4879a.xxA.mo10052c(this.qMM);
        C4879a.xxA.mo10052c(this.qMN);
        AppMethodBeat.m2505o(36657);
    }

    public final void coi() {
        AppMethodBeat.m2504i(36658);
        C4990ab.m7411d("MicroMsg.SnsVideoService", "%d stop preload %s", Integer.valueOf(hashCode()), C5046bo.dpG());
        C1720g.m3539RS().mo10302aa(new C397551());
        AppMethodBeat.m2505o(36658);
    }

    /* Access modifiers changed, original: final */
    public final void coj() {
        AppMethodBeat.m2504i(36659);
        C1720g.m3539RS().mo10302aa(new C397533());
        AppMethodBeat.m2505o(36659);
    }

    /* renamed from: a */
    public final void mo33970a(final C32837f c32837f, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(36660);
        if (c32837f == null) {
            C4990ab.m7413e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(36660);
            return;
        }
        if (this.fWa != c32837f) {
            C4990ab.m7421w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        C4990ab.m7417i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), c32837f.alc(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36648);
                String str = c32837f.cwT;
                synchronized (C39754ar.this.qMZ) {
                    try {
                        Iterator it = C39754ar.this.qMZ.iterator();
                        while (it.hasNext()) {
                            C46236n c46236n = (C46236n) it.next();
                            if (c46236n != null && C5046bo.isEqual(str, c46236n.cqU())) {
                                C4990ab.m7417i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", Integer.valueOf(C39754ar.this.hashCode()), str);
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(36648);
                    }
                }
                C37961o.aln().mo53414cW(false);
                if (C39754ar.this.fWa != null) {
                    C39754ar.this.fWa.fVC = null;
                }
                C39754ar.this.fWa = null;
                C39754ar.this.cok();
                C39754ar.this.coj();
                AppMethodBeat.m2505o(36648);
            }
        });
        AppMethodBeat.m2505o(36660);
    }

    /* Access modifiers changed, original: final */
    public final boolean cok() {
        int i;
        AppMethodBeat.m2504i(36661);
        long yz = C5046bo.m7588yz();
        C4990ab.m7417i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(C5046bo.anT() - (((long) ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("SnSPreLoadVideoExpiredTime", 1)) * TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC)));
        List<C26493s> v = C37961o.all().mo21064v(130, r0);
        if (v == null || v.isEmpty()) {
            AppMethodBeat.m2505o(36661);
            return false;
        }
        int i2 = 0;
        for (C26493s c26493s : v) {
            if (c26493s != null) {
                try {
                    int i3;
                    String D = C34957aq.m57411D((bau) C13373af.cnF().mo62918YT(C34957aq.m57412Yf(c26493s.getFileName())).cqu().xfI.wbK.get(0));
                    if (!C5046bo.isNullOrNil(D)) {
                        C5728b c5728b = new C5728b(D);
                        if (c5728b.exists()) {
                            long length = c5728b.length();
                            C4990ab.m7417i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", c26493s.getFileName(), Long.valueOf(length), Integer.valueOf(c26493s.cFa), Long.valueOf(c26493s.fXb), D);
                            if (length > 0 && length <= ((long) c26493s.cFa)) {
                                c5728b.delete();
                                i3 = i2 + 1;
                                c26493s.cFa = 0;
                                c26493s.bJt = 1;
                                C26494u.m42253f(c26493s);
                                i2 = i3;
                            }
                        }
                    }
                    i3 = i2;
                    try {
                        c26493s.cFa = 0;
                        c26493s.bJt = 1;
                        C26494u.m42253f(c26493s);
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
        C7060h.pYm.mo8378a(354, 145, (long) i2, false);
        C4990ab.m7417i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(v.size()), Integer.valueOf(i2), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(36661);
        return false;
    }

    /* renamed from: a */
    public final boolean mo62851a(bau bau, int i, String str, boolean z, final boolean z2, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(36662);
        if (bau.wEG == 2) {
            C4990ab.m7420w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            AppMethodBeat.m2505o(36662);
            return false;
        }
        final C43557ay c43557ay = new C43557ay();
        c43557ay.fUL = C34957aq.m57416be(i, bau.Url);
        c43557ay.cNr = bau;
        c43557ay.fDG = i;
        c43557ay.cwT = str;
        if (z) {
            i3 = 1;
        }
        c43557ay.egD = i3;
        c43557ay.egF = i2;
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                String str;
                AppMethodBeat.m2504i(36650);
                C46236n YT = C13373af.cnF().mo62918YT(c43557ay.cwT);
                C43557ay c43557ay = c43557ay;
                if (YT != null) {
                    str = YT.field_userName;
                } else {
                    str = "";
                }
                c43557ay.qNS = str;
                C4990ab.m7417i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", Boolean.valueOf(z2), c43557ay);
                if (z2) {
                    C39754ar.this.qMX.offerFirst(c43557ay);
                } else {
                    C39754ar.this.qMX.offerLast(c43557ay);
                }
                C39754ar.this.qMY.put(c43557ay.fUL, c43557ay);
                AppMethodBeat.m2505o(36650);
            }
        });
        if (z2) {
            col();
        }
        AppMethodBeat.m2505o(36662);
        return true;
    }

    /* renamed from: s */
    public final boolean mo62856s(final String str, final Object[] objArr) {
        AppMethodBeat.m2504i(36663);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36663);
            return false;
        }
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36649);
                C37961o.alm().mo73064m(str, objArr);
                if (C39754ar.this.qMW != null && C5046bo.isEqual(C39754ar.this.qMW.fUL, str)) {
                    C39754ar.m67991a(C39754ar.this);
                }
                C39754ar.this.qMX.remove((C43557ay) C39754ar.this.qMY.get(str));
                AppMethodBeat.m2505o(36649);
            }
        });
        AppMethodBeat.m2505o(36663);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void col() {
        AppMethodBeat.m2504i(36664);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C219167());
        AppMethodBeat.m2505o(36664);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo62850a(C43557ay c43557ay, boolean z) {
        AppMethodBeat.m2504i(36665);
        if (C5046bo.isNullOrNil(C34957aq.m57415a(c43557ay.cwT, c43557ay.cNr))) {
            boolean tf = C5730e.m8643tf(C34957aq.m57413Yg(c43557ay.cNr.f17915Id));
            String D = C34957aq.m57411D(c43557ay.cNr);
            C26493s Yh = C34957aq.m57414Yh(c43557ay.cwT);
            if (Yh == null) {
                C34957aq.m57418dd(c43557ay.cwT, c43557ay.egF);
            } else {
                C34957aq.m57417c(Yh, c43557ay.egF);
            }
            C4990ab.m7417i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", D, Boolean.valueOf(tf));
            C46216a c46216a = new C46216a(c43557ay.cNr.f17915Id);
            c46216a.qJh = c43557ay.cNr;
            C44222az dtl = C44222az.dtl();
            dtl.oyB = c43557ay.fDG;
            c46216a.qNW = dtl;
            c46216a.qNU = true;
            c46216a.url = c43557ay.cNr.Url;
            c46216a.qNT = false;
            C45459n.alj();
            C37961o.alm();
            C44686h a = C45150e.m83024a(c46216a.qNW, c46216a.url, D, C34957aq.m57420ug(c43557ay.cwT), c43557ay.egD);
            if (a == null) {
                AppMethodBeat.m2505o(36665);
                return false;
            }
            D = c43557ay.qNS;
            a.egE = D;
            a.cEV = D;
            try {
                cbf p = C34955aj.m57408p(C13373af.cnF().mo62918YT(c43557ay.cwT));
                if (p != null) {
                    a.cFc = p.vQE;
                    a.egI = p.xaF.wOd;
                }
            } catch (Exception e) {
            }
            this.qMW = c43557ay;
            this.qMW.fUL = a.field_mediaId;
            C4990ab.m7417i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", this.qMW.fUL, Boolean.valueOf(z));
            C37961o.alm().mo73060a(a, z);
            AppMethodBeat.m2505o(36665);
            return true;
        }
        C4990ab.m7417i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", c43557ay.fUL, c43557ay.cwT, C34957aq.m57415a(c43557ay.cwT, c43557ay.cNr));
        AppMethodBeat.m2505o(36665);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m67991a(C39754ar c39754ar) {
        AppMethodBeat.m2504i(36666);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C38948());
        AppMethodBeat.m2505o(36666);
    }
}
