package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32521bh;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C23236j.C23237a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C30039i.C30038a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C40424f.C35785b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C40424f.C4712a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C46488g.C40425a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C40427c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C4713a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n.C30044a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35790d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35792l;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4721g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4722h;
import com.tencent.p177mm.protocal.protobuf.bsw;
import com.tencent.p177mm.protocal.protobuf.bzu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.b */
public final class C14839b {
    private final C35790d uov;
    private final Set<C14851b> vdO;
    private final C30040k vdP;

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$3 */
    class C148423 implements C35790d {
        C148423() {
        }

        /* renamed from: a */
        public final void mo9626a(String str, C40432m c40432m) {
            AppMethodBeat.m2504i(79469);
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(str)));
            C44049s ajg = C14857a.vfA.ajg(str);
            if (ajg == null) {
                AppMethodBeat.m2505o(79469);
                return;
            }
            C23236j.m35639z(ajg.field_reportId, 10);
            C23236j.m35639z(ajg.field_reportId, 15);
            if ((!ajg.field_fileCompress || ajg.field_fileEncrypt) && ajg.field_fileUpdated) {
                C23236j.m35637a(ajg.field_resType, ajg.field_subType, ajg.field_url, C5046bo.getInt(ajg.field_fileVersion, 0), ajg.field_maxRetryTimes > ajg.field_retryTimes ? C23237a.RETRY_SUCC : C23237a.SUCC, true, C5046bo.nullAsNil(ajg.field_groupId2).equals("NewXml"), false, ajg.field_sampleId);
            }
            if (ajg.field_fileCompress || ajg.field_fileEncrypt) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                C14839b.this.mo27149b(ajg);
                AppMethodBeat.m2505o(79469);
                return;
            }
            C4883b c32519bf = new C32519bf();
            c32519bf.cus.filePath = ajg.field_filePath;
            c32519bf.cus.cuw = ajg.field_fileUpdated;
            c32519bf.cus.cuv = C5046bo.getInt(ajg.field_fileVersion, 0);
            c32519bf.cus.cut = ajg.field_resType;
            c32519bf.cus.cuu = ajg.field_subType;
            C4879a.xxA.mo10048a(c32519bf, C14857a.vfA.handler.getLooper());
            ajg.field_fileUpdated = false;
            C14857a.vfA.mo27179h(ajg);
            AppMethodBeat.m2505o(79469);
        }

        /* renamed from: b */
        public final void mo9629b(String str, C40432m c40432m) {
            AppMethodBeat.m2504i(79470);
            C30039i.aiY(str);
            C44049s ajg = C14857a.vfA.ajg(str);
            if (ajg == null) {
                AppMethodBeat.m2505o(79470);
                return;
            }
            int i = 1;
            if (!(c40432m == null || c40432m.vfo == null)) {
                if (c40432m.vfo instanceof C4713a) {
                    C23236j.m35639z(ajg.field_reportId, 7);
                    i = 0;
                } else if (c40432m.vfo instanceof C40427c) {
                    C23236j.m35639z(ajg.field_reportId, 16);
                    i = 0;
                }
            }
            if (i != 0) {
                C23236j.m35639z(ajg.field_reportId, 11);
            }
            C23236j.m35639z(ajg.field_reportId, 44);
            C23236j.m35637a(ajg.field_resType, ajg.field_subType, ajg.field_url, C5046bo.getInt(ajg.field_fileVersion, 0), C23237a.FAIL, false, "NewXml".equalsIgnoreCase(ajg.field_groupId2), false, ajg.field_sampleId);
            AppMethodBeat.m2505o(79470);
        }

        public final String awa() {
            return "CheckResUpdate";
        }

        public final void aeQ(String str) {
            boolean ajc;
            AppMethodBeat.m2504i(79471);
            C14856q diy = C14857a.vfA;
            if (diy.hrm) {
                ajc = diy.vfy.ajc(str);
            } else {
                ajc = false;
            }
            if (!ajc) {
                C30039i.aiY(str);
            }
            AppMethodBeat.m2505o(79471);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$c */
    public static final class C14845c {
        private static final C14839b veg = new C14839b();

        static {
            AppMethodBeat.m2504i(79485);
            AppMethodBeat.m2505o(79485);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$8 */
    class C148488 implements Runnable {
        final /* synthetic */ int nWD;
        final /* synthetic */ int nWE;
        final /* synthetic */ String val$filePath;
        final /* synthetic */ int veb;
        final /* synthetic */ boolean vec;

        C148488(int i, int i2, String str, int i3, boolean z) {
            this.nWD = i;
            this.nWE = i2;
            this.val$filePath = str;
            this.veb = i3;
            this.vec = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(79476);
            C32519bf c32519bf = new C32519bf();
            c32519bf.cus.cut = this.nWD;
            c32519bf.cus.cuu = this.nWE;
            c32519bf.cus.filePath = this.val$filePath;
            c32519bf.cus.cuv = this.veb;
            c32519bf.cus.cuw = this.vec;
            C4879a.xxA.mo10055m(c32519bf);
            AppMethodBeat.m2505o(79476);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$a */
    public static final class C14849a implements C4721g {
        private final C1837a unU = new C148372();
        private final C4884c ved = new C148501();
        private final C40426h vee = new C40426h();

        /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$a$2 */
        class C148372 implements C1837a {
            C148372() {
            }

            /* renamed from: a */
            public final void mo5414a(C1197a c1197a) {
                AppMethodBeat.m2504i(79479);
                String a = C1946aa.m4148a(c1197a.eAB.vED);
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7420w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
                    AppMethodBeat.m2505o(79479);
                    return;
                }
                C4990ab.m7410d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(a)));
                if (!C5046bo.isNullOrNil(a)) {
                    Map z = C5049br.m7595z(a, "sysmsg");
                    C23236j.m35639z(0, 0);
                    String str = "MicroMsg.CheckResUpdateNewXmlParser";
                    String str2 = "parsed values.size = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = z == null ? BuildConfig.COMMAND : String.valueOf(z.size());
                    C4990ab.m7417i(str, str2, objArr);
                    if (z == null) {
                        C23236j.m35639z(0, 30);
                    } else {
                        C23236j.m35639z(0, 31);
                    }
                    if (z != null && z.size() > 0 && C5046bo.nullAsNil((String) z.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                        C44045e.m79169k(".sysmsg", "delete", z);
                        C44045e.m79169k(".sysmsg", "cache", z);
                        C44045e.m79169k(".sysmsg", "decrypt", z);
                    }
                }
                AppMethodBeat.m2505o(79479);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$a$3 */
        class C148383 implements Runnable {
            C148383() {
            }

            public final void run() {
                AppMethodBeat.m2504i(79480);
                C44048p.aVi();
                AppMethodBeat.m2505o(79480);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$a$1 */
        class C148501 extends C4884c<C6523mp> {
            C148501() {
                AppMethodBeat.m2504i(79477);
                this.xxI = C6523mp.class.getName().hashCode();
                AppMethodBeat.m2505o(79477);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(79478);
                if (C1720g.m3534RN().mo5161QY()) {
                    C1720g.m3534RN();
                    if (!C1668a.m3393QT()) {
                        long anT = C5046bo.anT();
                        long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, null), 0);
                        if (a != 0 && a < anT) {
                            C44048p.aVi();
                        }
                    }
                }
                AppMethodBeat.m2505o(79478);
                return false;
            }
        }

        public C14849a() {
            AppMethodBeat.m2504i(79481);
            AppMethodBeat.m2505o(79481);
        }

        public final void cYt() {
            AppMethodBeat.m2504i(79482);
            C4879a.xxA.mo10052c(this.ved);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("resourcemgr", this.unU, true);
            C1720g.m3539RS().mo10310m(new C148383(), 10000);
            AppMethodBeat.m2505o(79482);
        }

        public final void onAccountRelease() {
            AppMethodBeat.m2504i(79483);
            C4879a.xxA.mo10053d(this.ved);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("resourcemgr", this.unU, true);
            AppMethodBeat.m2505o(79483);
        }

        public final String awa() {
            return "CheckResUpdate";
        }

        /* renamed from: c */
        public final C30044a mo9622c(C35792l c35792l) {
            AppMethodBeat.m2504i(79484);
            if (c35792l instanceof C14852c) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
                C30044a c14853d = new C14853d((C14852c) c35792l);
                AppMethodBeat.m2505o(79484);
                return c14853d;
            }
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
            AppMethodBeat.m2505o(79484);
            return null;
        }

        public final C4722h cYu() {
            return this.vee;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$b */
    public interface C14851b {
        boolean die();
    }

    /* synthetic */ C14839b(byte b) {
        this();
    }

    /* Access modifiers changed, original: final */
    public final Set<C14851b> dic() {
        Set<C14851b> newSetFromMap;
        AppMethodBeat.m2504i(79486);
        synchronized (this.vdO) {
            try {
                newSetFromMap = Collections.newSetFromMap(new C6197a(this.vdO.size()));
                newSetFromMap.addAll(this.vdO);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79486);
            }
        }
        return newSetFromMap;
    }

    /* renamed from: as */
    public final void mo27147as(int i, int i2, int i3) {
        AppMethodBeat.m2504i(79488);
        mo27152f(i, i2, i3, true);
        AppMethodBeat.m2505o(79488);
    }

    public static C14839b did() {
        AppMethodBeat.m2504i(139136);
        C14839b dif = C14845c.veg;
        AppMethodBeat.m2505o(139136);
        return dif;
    }

    private C14839b() {
        AppMethodBeat.m2504i(79490);
        this.vdO = Collections.newSetFromMap(new C6197a(C30039i.vep.length));
        this.vdP = new C30040k();
        this.uov = new C148423();
        C14857a.vfA.mo27177b("CheckResUpdate", this.uov);
        AppMethodBeat.m2505o(79490);
    }

    /* renamed from: Ky */
    public static void m23095Ky(int i) {
        AppMethodBeat.m2504i(79491);
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", Integer.valueOf(i));
        C1720g.m3534RN();
        boolean QX = C1668a.m3395QX();
        boolean equals = C6665av.fly.mo5292T("login_user_name", "").equals("");
        if (QX || !equals) {
            C1720g.m3535RO().eJo.mo14541a(new C44796m(i), 0);
            AppMethodBeat.m2505o(79491);
            return;
        }
        C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
        AppMethodBeat.m2505o(79491);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo27149b(C44049s c44049s) {
        AppMethodBeat.m2504i(79493);
        C4990ab.m7410d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + c44049s.field_urlKey);
        C30040k c30040k = this.vdP;
        if (c30040k.ajd(c44049s.field_urlKey)) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
            AppMethodBeat.m2505o(79493);
            return;
        }
        c30040k.mo48267a(C14836a.m23093a(c44049s));
        AppMethodBeat.m2505o(79493);
    }

    /* renamed from: c */
    static void m23096c(C44049s c44049s) {
        AppMethodBeat.m2504i(79494);
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", c44049s.field_urlKey);
        C30040k.m47550g(c44049s);
        AppMethodBeat.m2505o(79494);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo27145a(int i, bsw bsw, boolean z) {
        AppMethodBeat.m2504i(79495);
        final String gN = C30039i.m47549gN(i, bsw.wOI);
        if (bsw.wUV == null) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            AppMethodBeat.m2505o(79495);
            return;
        }
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bsw.wOI), Integer.valueOf(bsw.wUV.wVf));
        C23236j.m35639z((long) bsw.wUX, 3);
        final int i2 = bsw.wUV.wVf;
        final int i3 = bsw.wOI;
        final int i4 = bsw.wUX;
        final String str = bsw.wUY;
        final int i5 = i;
        final boolean z2 = z;
        C14857a.vfA.mo27173R(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(79472);
                C44049s ajg = C14857a.vfA.ajg(gN);
                int i = i5;
                int i2 = i3;
                int i3 = i2;
                int i4 = i4;
                String str = str;
                boolean z = z2;
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(ajg)));
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", Integer.valueOf(i3));
                boolean z2 = false;
                if (ajg == null) {
                    C23236j.m35639z((long) i4, 47);
                    C23236j.m35639z((long) i4, 22);
                    z2 = true;
                } else if (C5046bo.getInt(ajg.field_fileVersion, 0) <= i3) {
                    z2 = true;
                } else {
                    C23236j.m35639z(ajg.field_reportId, 47);
                    C23236j.m35639z(ajg.field_reportId, 22);
                }
                String gN = C30039i.m47549gN(i, i2);
                String aiX = C30039i.aiX(gN);
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", Boolean.valueOf(z2), aiX);
                if (z2) {
                    C14857a.vfA.mo27172AH(gN);
                    C14845c.veg.mo27153g(i, i2, 2, z);
                    if ((((C40433a.ajj(aiX) & 1) & C40433a.ajj(aiX + ".decompressed")) & C40433a.ajj(aiX + ".decrypted")) != 0) {
                        if (ajg != null) {
                            C23236j.m35639z(ajg.field_reportId, 21);
                            C23236j.m35634a(ajg.field_resType, ajg.field_subType, i3, z, ajg.field_sampleId);
                        }
                    } else if (ajg != null) {
                        C23236j.m35639z(ajg.field_reportId, 22);
                        C23236j.m35639z(ajg.field_reportId, 47);
                    }
                    if (ajg == null) {
                        C44049s c44049s = new C44049s();
                        c44049s.field_urlKey = gN;
                        c44049s.field_resType = i;
                        c44049s.field_subType = i2;
                        c44049s.field_deleted = true;
                        c44049s.field_fileVersion = String.valueOf(i3);
                        c44049s.field_reportId = (long) i4;
                        c44049s.field_sampleId = str;
                        C14857a.vfA.mo27179h(c44049s);
                        AppMethodBeat.m2505o(79472);
                        return;
                    }
                    ajg.field_deleted = true;
                    ajg.field_fileVersion = String.valueOf(i3);
                    C14857a.vfA.mo27179h(ajg);
                }
                AppMethodBeat.m2505o(79472);
            }
        });
        AppMethodBeat.m2505o(79495);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo27148b(int i, bsw bsw, boolean z) {
        AppMethodBeat.m2504i(79496);
        final String gN = C30039i.m47549gN(i, bsw.wOI);
        if (bsw.wUV == null) {
            C4990ab.m7413e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", gN);
            AppMethodBeat.m2505o(79496);
            return;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdateHelper";
        String str3 = "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bsw.wOI);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(bsw.wUV.wVf);
        if (bsw.wUV.wVh == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(bsw.wUV.wVh.size());
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(bsw.wUX);
        objArr[6] = bsw.wUY;
        objArr[7] = bsw.wUV.Url;
        objArr[8] = bsw.wUV.wdt;
        C4990ab.m7417i(str2, str3, objArr);
        if (bsw.wUV.wVh != null) {
            Iterator it = bsw.wUV.wVh.iterator();
            while (it.hasNext()) {
                bzu bzu = (bzu) it.next();
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", Integer.valueOf(bzu.Version), bzu.wYR.dlY());
            }
        }
        C23236j.m35638mc((long) bsw.wUX);
        if (!z) {
            C23236j.m35639z((long) bsw.wUX, 1);
        }
        if (bsw.vQW != 0 && ((long) bsw.vQW) <= C5046bo.anT()) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", gN, Integer.valueOf(bsw.vQW), Integer.valueOf(bsw.wUV.wVf));
            C23236j.m35639z((long) bsw.wUX, 14);
            C23236j.m35639z((long) bsw.wUX, 44);
            C23236j.m35637a(i, bsw.wOI, bsw.wUV.Url, bsw.wUV.wVf, C23237a.FILE_EXPIRED, false, z, false, bsw.wUY);
            AppMethodBeat.m2505o(79496);
        } else if (C5046bo.isNullOrNil(bsw.wUV.Url) && bsw.wUV.wdt == null) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
            AppMethodBeat.m2505o(79496);
        } else {
            C40425a c40425a = new C40425a(bsw.wUV.Url);
            c40425a.aja(gN);
            c40425a.cut = i;
            c40425a.cuu = bsw.wOI;
            c40425a.mo27171md((long) bsw.vQW);
            c40425a.cuv = bsw.wUV.wVf;
            c40425a.ajb(bsw.wUV.wdO);
            c40425a.vei = C30038a.m47546KA(bsw.wUV.wVg);
            c40425a.vej = C30038a.m47548Kz(bsw.wUV.wVg);
            c40425a.vdK = (long) bsw.wUX;
            c40425a.vdL = bsw.wUY;
            c40425a.mo27167KH(bsw.wUZ > 0 ? bsw.wUZ : 3);
            c40425a.vek = bsw.vek;
            c40425a.mo27166KG(bsw.wVa);
            c40425a.cuA = z;
            if (!C5046bo.m7548ek(bsw.wUV.wVh)) {
                c40425a.vdH = ((bzu) bsw.wUV.wVh.get(0)).wYR.f1226wR;
            }
            if (!(bsw.wUW == null || C5046bo.isNullOrNil(bsw.wUW.wVe))) {
                c40425a.vdF = bsw.wUW.wVe;
                c40425a.vdG = bsw.wUW.wVd;
            }
            if (bsw.wUV.wdt != null && bsw.wUV.wdt.f1226wR.length > 0) {
                c40425a.veh = bsw.wUV.wdt.toByteArray();
            }
            c40425a.vdI = bsw.wUV.wVi;
            c40425a.fileSize = (long) bsw.wUV.FileSize;
            c40425a.mo27168KI(bsw.wxG);
            final C46488g dii = c40425a.dii();
            C4990ab.m7411d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", dii.toString());
            C14857a.vfA.mo27173R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(79473);
                    C44049s ajg = C14857a.vfA.ajg(gN);
                    C46488g c46488g = dii;
                    if (ajg == null) {
                        C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
                    } else {
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", ajg.field_urlKey, ajg.field_url, Long.valueOf(ajg.field_contentLength), Boolean.valueOf(ajg.field_deleted), ajg.field_eccSignature, Long.valueOf(ajg.field_expireTime), Boolean.valueOf(ajg.field_fileCompress), Boolean.valueOf(ajg.field_fileEncrypt), ajg.field_filePath, Boolean.valueOf(ajg.field_fileUpdated), ajg.field_fileVersion, ajg.field_groupId2, Integer.valueOf(ajg.field_keyVersion), Boolean.valueOf(C5046bo.isNullOrNil(ajg.field_encryptKey)), Integer.valueOf(ajg.field_maxRetryTimes), Integer.valueOf(ajg.field_retryTimes), ajg.field_sampleId, Integer.valueOf(ajg.field_status));
                        C4990ab.m7411d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", ajg.field_encryptKey);
                    }
                    C44049s dih;
                    if (ajg != null && ajg.field_deleted && c46488g.aiW(ajg.field_fileVersion) <= 0) {
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", ajg.field_fileVersion, c46488g.veW);
                        AppMethodBeat.m2505o(79473);
                    } else if (ajg == null) {
                        dih = c46488g.dih();
                        dih.field_fileUpdated = true;
                        dih.field_needRetry = true;
                        if (C5046bo.isNullOrNil(dih.field_encryptKey)) {
                            dih.field_keyVersion = -1;
                        }
                        C4990ab.m7410d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(dih)));
                        C14857a.vfA.mo27179h(dih);
                        C14845c.veg.mo27153g(c46488g.cut, c46488g.cuu, 0, c46488g.cuA);
                        C4712a.m7064a(true, true, dih, c46488g);
                        AppMethodBeat.m2505o(79473);
                    } else {
                        C4990ab.m7410d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
                        ajg.field_networkType = c46488g.networkType;
                        if (C5046bo.isNullOrNil(ajg.field_originalMd5)) {
                            ajg.field_originalMd5 = c46488g.vdI;
                        }
                        if (c46488g.aiW(ajg.field_fileVersion) > 0) {
                            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                            dih = c46488g.dih();
                            if (ajg.field_keyVersion >= c46488g.vdG) {
                                dih.field_keyVersion = ajg.field_keyVersion;
                                dih.field_encryptKey = ajg.field_encryptKey;
                            }
                            dih.field_fileUpdated = true;
                            dih.field_needRetry = true;
                            dih.field_deleted = false;
                            C14857a.vfA.mo27179h(dih);
                            C14845c.veg.mo27153g(c46488g.cut, c46488g.cuu, 0, c46488g.cuA);
                            C14857a.vfA.mo27172AH(c46488g.vdC);
                            C4712a.m7064a(false, true, dih, c46488g);
                            AppMethodBeat.m2505o(79473);
                        } else if (c46488g.aiW(ajg.field_fileVersion) == 0 && !ajg.field_needRetry) {
                            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(ajg.field_resType), Integer.valueOf(ajg.field_subType), ajg.field_fileVersion);
                            AppMethodBeat.m2505o(79473);
                        } else if (ajg.field_status == 2 || ajg.field_status == 1 || ajg.field_status == 0) {
                            long ek = C40433a.m69347ek(ajg.field_filePath);
                            if (ajg.field_contentLength > ek) {
                                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(ajg.field_contentLength), Long.valueOf(ek));
                                if (0 == ek) {
                                    C14845c.veg.mo27153g(c46488g.cut, c46488g.cuu, 0, c46488g.cuA);
                                    C4712a.m7064a(false, true, ajg, c46488g);
                                    AppMethodBeat.m2505o(79473);
                                    return;
                                }
                                C4712a.m7064a(true, false, ajg, c46488g);
                                AppMethodBeat.m2505o(79473);
                            } else if (C5046bo.nullAsNil(C1178g.m2587cz(C30039i.aiX(c46488g.vdC))).equals(ajg.field_md5)) {
                                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", ajg.field_urlKey);
                                ajg.field_status = 2;
                                ajg.field_contentLength = C40433a.m69347ek(ajg.field_filePath);
                                ajg.field_fileUpdated = false;
                                ajg.field_reportId = c46488g.vdK;
                                C14857a.vfA.mo27179h(ajg);
                                C23236j.m35639z(ajg.field_reportId, 13);
                                C23236j.m35639z(ajg.field_reportId, 44);
                                C23236j.m35637a(ajg.field_resType, ajg.field_subType, ajg.field_url, C5046bo.getInt(ajg.field_fileVersion, 0), C23237a.FILE_LATEST, true, "NewXml".equalsIgnoreCase(ajg.field_groupId2), true, ajg.field_sampleId);
                                if (c46488g.vei || c46488g.vej) {
                                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", c46488g.vdC);
                                    C35785b.m58651a(ajg, false, false);
                                    AppMethodBeat.m2505o(79473);
                                    return;
                                }
                                C14845c.veg.mo27151e(c46488g.cut, c46488g.cuu, C30039i.aiX(c46488g.vdC), C5046bo.getInt(c46488g.veW, 0));
                                AppMethodBeat.m2505o(79473);
                            } else {
                                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                                C4712a.m7064a(false, true, ajg, c46488g);
                                AppMethodBeat.m2505o(79473);
                            }
                        } else {
                            if (ajg.field_status == 4 || ajg.field_status == 3) {
                                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", ajg.field_urlKey);
                                C4712a.m7064a(false, true, ajg, c46488g);
                            }
                            AppMethodBeat.m2505o(79473);
                        }
                    }
                }
            });
            AppMethodBeat.m2505o(79496);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo27146a(int i, bsw bsw, boolean z, boolean z2) {
        AppMethodBeat.m2504i(79497);
        final String gN = C30039i.m47549gN(i, bsw.wOI);
        if (bsw.wUW == null) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
            AppMethodBeat.m2505o(79497);
        } else if (C5046bo.isNullOrNil(bsw.wUW.wVe)) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
            AppMethodBeat.m2505o(79497);
        } else {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bsw.wOI), Integer.valueOf(bsw.wUW.wVd));
            C4990ab.m7411d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", bsw.wUW.wVe);
            C23236j.m35639z((long) bsw.wUX, 4);
            final String str = bsw.wUV.wVi;
            final String str2 = bsw.wUW.wVe;
            final int i2 = bsw.wUW.wVd;
            final int i3 = bsw.wUX;
            final String str3 = bsw.wUY;
            final boolean z3 = z2;
            C148466 c148466 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(79474);
                    C44049s ajg = C14857a.vfA.ajg(gN);
                    String str = str;
                    String str2 = str2;
                    int i = i2;
                    int i2 = i3;
                    String str3 = str3;
                    boolean z = z3;
                    if (ajg == null) {
                        ajg = new C44049s();
                        ajg.field_keyVersion = i;
                        ajg.field_encryptKey = str2;
                        ajg.field_reportId = (long) i2;
                        ajg.field_sampleId = str3;
                        ajg.field_originalMd5 = str;
                        C14857a.vfA.mo27179h(ajg);
                        C23236j.m35639z((long) i2, 51);
                        C23236j.m35639z((long) i2, 45);
                        AppMethodBeat.m2505o(79474);
                    } else if (ajg.field_keyVersion < i) {
                        ajg.field_keyVersion = i;
                        ajg.field_encryptKey = str2;
                        ajg.field_reportId = (long) i2;
                        ajg.field_sampleId = str3;
                        if (C5046bo.isNullOrNil(ajg.field_originalMd5)) {
                            ajg.field_originalMd5 = str;
                        }
                        C14857a.vfA.mo27179h(ajg);
                        C35785b.m58651a(ajg, true, z);
                        AppMethodBeat.m2505o(79474);
                    } else {
                        if (z && ajg.field_keyVersion == i) {
                            C35785b.m58651a(ajg, true, true);
                        }
                        AppMethodBeat.m2505o(79474);
                    }
                }
            };
            if (z2) {
                c148466.run();
                AppMethodBeat.m2505o(79497);
                return;
            }
            C14857a.vfA.mo27173R(c148466);
            AppMethodBeat.m2505o(79497);
        }
    }

    /* renamed from: f */
    public final void mo27152f(int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(79487);
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        C14857a.vfA.mo27173R(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(79467);
                C44049s ajg = C14857a.vfA.ajg(C30039i.m47549gN(i4, i5));
                if (ajg != null && (-1 == i6 || String.valueOf(i6).equals(ajg.field_fileVersion))) {
                    boolean z;
                    if (z2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    ajg.field_needRetry = z;
                    C14857a.vfA.mo27179h(ajg);
                }
                AppMethodBeat.m2505o(79467);
            }
        });
        AppMethodBeat.m2505o(79487);
    }

    /* renamed from: gM */
    public static String m23097gM(int i, int i2) {
        AppMethodBeat.m2504i(79492);
        C44049s ajg = C14857a.vfA.ajg(C30039i.m47549gN(i, i2));
        if (ajg == null) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(79492);
            return null;
        }
        C4990ab.m7419v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", Boolean.valueOf(ajg.field_deleted), ajg.field_filePath, ajg.field_md5, Boolean.valueOf(ajg.field_fileCompress), Boolean.valueOf(ajg.field_fileEncrypt), ajg.field_originalMd5);
        if (ajg.field_fileCompress || ajg.field_fileEncrypt) {
            String str;
            if (ajg.field_fileCompress) {
                str = ajg.field_filePath + ".decompressed";
            } else if (ajg.field_fileEncrypt) {
                str = ajg.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(79492);
                return null;
            } else if (C5046bo.isNullOrNil(ajg.field_originalMd5) || !C5046bo.nullAsNil(C1178g.m2587cz(str)).equals(ajg.field_originalMd5)) {
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(79492);
                return null;
            } else {
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.m2505o(79492);
                return str;
            }
        } else if (ajg.field_deleted || C5046bo.isNullOrNil(ajg.field_filePath) || !C5046bo.nullAsNil(C1178g.m2587cz(ajg.field_filePath)).equals(ajg.field_md5)) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(79492);
            return null;
        } else {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", Integer.valueOf(i), Integer.valueOf(i2), ajg.field_filePath);
            String str2 = ajg.field_filePath;
            AppMethodBeat.m2505o(79492);
            return str2;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo27151e(int i, int i2, String str, int i3) {
        AppMethodBeat.m2504i(79498);
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final int i6 = i3;
        C14857a.vfA.mo27173R(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(79475);
                C14839b c14839b = C14839b.this;
                int i = i4;
                int i2 = i5;
                String str = str2;
                int i3 = i6;
                C44049s ajg = C14857a.vfA.ajg(C30039i.m47549gN(i, i2));
                if (ajg == null) {
                    AppMethodBeat.m2505o(79475);
                    return;
                }
                boolean z = ajg.field_fileUpdated;
                ajg.field_fileUpdated = false;
                C14857a.vfA.mo27179h(ajg);
                if (i3 == C5046bo.getInt(ajg.field_fileVersion, 0)) {
                    if (C14857a.vfA.handler == null) {
                        C4990ab.m7414f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
                        AppMethodBeat.m2505o(79475);
                        return;
                    }
                    C14857a.vfA.handler.post(new C148488(i, i2, str, i3, z));
                }
                AppMethodBeat.m2505o(79475);
            }
        });
        AppMethodBeat.m2505o(79498);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final void mo27153g(int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(79499);
        if (C14857a.vfA.handler == null) {
            C4990ab.m7414f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
            AppMethodBeat.m2505o(79499);
            return;
        }
        final int i4 = i3;
        final int i5 = i;
        final int i6 = i2;
        final boolean z2 = z;
        C14857a.vfA.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(79468);
                C32521bh c32521bh = new C32521bh();
                c32521bh.cuB.cuy = i4;
                c32521bh.cuB.cut = i5;
                c32521bh.cuB.cuu = i6;
                c32521bh.cuB.cuA = z2;
                C4879a.xxA.mo10055m(c32521bh);
                AppMethodBeat.m2505o(79468);
            }
        });
        AppMethodBeat.m2505o(79499);
    }
}
