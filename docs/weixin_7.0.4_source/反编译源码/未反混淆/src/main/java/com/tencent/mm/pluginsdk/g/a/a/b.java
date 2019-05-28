package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.av;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.g;
import com.tencent.mm.pluginsdk.g.a.c.h;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b {
    private final d uov;
    private final Set<b> vdO;
    private final k vdP;

    public static final class c {
        private static final b veg = new b();

        static {
            AppMethodBeat.i(79485);
            AppMethodBeat.o(79485);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.b$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ int nWD;
        final /* synthetic */ int nWE;
        final /* synthetic */ String val$filePath;
        final /* synthetic */ int veb;
        final /* synthetic */ boolean vec;

        AnonymousClass8(int i, int i2, String str, int i3, boolean z) {
            this.nWD = i;
            this.nWE = i2;
            this.val$filePath = str;
            this.veb = i3;
            this.vec = z;
        }

        public final void run() {
            AppMethodBeat.i(79476);
            bf bfVar = new bf();
            bfVar.cus.cut = this.nWD;
            bfVar.cus.cuu = this.nWE;
            bfVar.cus.filePath = this.val$filePath;
            bfVar.cus.cuv = this.veb;
            bfVar.cus.cuw = this.vec;
            com.tencent.mm.sdk.b.a.xxA.m(bfVar);
            AppMethodBeat.o(79476);
        }
    }

    public static final class a implements g {
        private final com.tencent.mm.model.bz.a unU = new com.tencent.mm.model.bz.a() {
            public final void a(com.tencent.mm.ai.e.a aVar) {
                AppMethodBeat.i(79479);
                String a = aa.a(aVar.eAB.vED);
                if (bo.isNullOrNil(a)) {
                    ab.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
                    AppMethodBeat.o(79479);
                    return;
                }
                ab.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(a)));
                if (!bo.isNullOrNil(a)) {
                    Map z = br.z(a, "sysmsg");
                    j.z(0, 0);
                    String str = "MicroMsg.CheckResUpdateNewXmlParser";
                    String str2 = "parsed values.size = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = z == null ? BuildConfig.COMMAND : String.valueOf(z.size());
                    ab.i(str, str2, objArr);
                    if (z == null) {
                        j.z(0, 30);
                    } else {
                        j.z(0, 31);
                    }
                    if (z != null && z.size() > 0 && bo.nullAsNil((String) z.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                        e.k(".sysmsg", "delete", z);
                        e.k(".sysmsg", "cache", z);
                        e.k(".sysmsg", "decrypt", z);
                    }
                }
                AppMethodBeat.o(79479);
            }
        };
        private final com.tencent.mm.sdk.b.c ved = new com.tencent.mm.sdk.b.c<mp>() {
            {
                AppMethodBeat.i(79477);
                this.xxI = mp.class.getName().hashCode();
                AppMethodBeat.o(79477);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(79478);
                if (com.tencent.mm.kernel.g.RN().QY()) {
                    com.tencent.mm.kernel.g.RN();
                    if (!com.tencent.mm.kernel.a.QT()) {
                        long anT = bo.anT();
                        long a = bo.a((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, null), 0);
                        if (a != 0 && a < anT) {
                            p.aVi();
                        }
                    }
                }
                AppMethodBeat.o(79478);
                return false;
            }
        };
        private final h vee = new h();

        public a() {
            AppMethodBeat.i(79481);
            AppMethodBeat.o(79481);
        }

        public final void cYt() {
            AppMethodBeat.i(79482);
            com.tencent.mm.sdk.b.a.xxA.c(this.ved);
            ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("resourcemgr", this.unU, true);
            com.tencent.mm.kernel.g.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(79480);
                    p.aVi();
                    AppMethodBeat.o(79480);
                }
            }, 10000);
            AppMethodBeat.o(79482);
        }

        public final void onAccountRelease() {
            AppMethodBeat.i(79483);
            com.tencent.mm.sdk.b.a.xxA.d(this.ved);
            ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("resourcemgr", this.unU, true);
            AppMethodBeat.o(79483);
        }

        public final String awa() {
            return "CheckResUpdate";
        }

        public final com.tencent.mm.pluginsdk.g.a.c.n.a c(l lVar) {
            AppMethodBeat.i(79484);
            if (lVar instanceof c) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
                com.tencent.mm.pluginsdk.g.a.c.n.a dVar = new d((c) lVar);
                AppMethodBeat.o(79484);
                return dVar;
            }
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
            AppMethodBeat.o(79484);
            return null;
        }

        public final h cYu() {
            return this.vee;
        }
    }

    public interface b {
        boolean die();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    /* Access modifiers changed, original: final */
    public final Set<b> dic() {
        Set<b> newSetFromMap;
        AppMethodBeat.i(79486);
        synchronized (this.vdO) {
            try {
                newSetFromMap = Collections.newSetFromMap(new android.support.v4.f.a(this.vdO.size()));
                newSetFromMap.addAll(this.vdO);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79486);
            }
        }
        return newSetFromMap;
    }

    public final void as(int i, int i2, int i3) {
        AppMethodBeat.i(79488);
        f(i, i2, i3, true);
        AppMethodBeat.o(79488);
    }

    public static b did() {
        AppMethodBeat.i(139136);
        b dif = c.veg;
        AppMethodBeat.o(139136);
        return dif;
    }

    private b() {
        AppMethodBeat.i(79490);
        this.vdO = Collections.newSetFromMap(new android.support.v4.f.a(i.vep.length));
        this.vdP = new k();
        this.uov = new d() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(79469);
                ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(str)));
                s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(str);
                if (ajg == null) {
                    AppMethodBeat.o(79469);
                    return;
                }
                j.z(ajg.field_reportId, 10);
                j.z(ajg.field_reportId, 15);
                if ((!ajg.field_fileCompress || ajg.field_fileEncrypt) && ajg.field_fileUpdated) {
                    j.a(ajg.field_resType, ajg.field_subType, ajg.field_url, bo.getInt(ajg.field_fileVersion, 0), ajg.field_maxRetryTimes > ajg.field_retryTimes ? com.tencent.mm.pluginsdk.g.a.a.j.a.RETRY_SUCC : com.tencent.mm.pluginsdk.g.a.a.j.a.SUCC, true, bo.nullAsNil(ajg.field_groupId2).equals("NewXml"), false, ajg.field_sampleId);
                }
                if (ajg.field_fileCompress || ajg.field_fileEncrypt) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                    b.this.b(ajg);
                    AppMethodBeat.o(79469);
                    return;
                }
                com.tencent.mm.sdk.b.b bfVar = new bf();
                bfVar.cus.filePath = ajg.field_filePath;
                bfVar.cus.cuw = ajg.field_fileUpdated;
                bfVar.cus.cuv = bo.getInt(ajg.field_fileVersion, 0);
                bfVar.cus.cut = ajg.field_resType;
                bfVar.cus.cuu = ajg.field_subType;
                com.tencent.mm.sdk.b.a.xxA.a(bfVar, com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.handler.getLooper());
                ajg.field_fileUpdated = false;
                com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                AppMethodBeat.o(79469);
            }

            public final void b(String str, m mVar) {
                AppMethodBeat.i(79470);
                i.aiY(str);
                s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(str);
                if (ajg == null) {
                    AppMethodBeat.o(79470);
                    return;
                }
                int i = 1;
                if (!(mVar == null || mVar.vfo == null)) {
                    if (mVar.vfo instanceof com.tencent.mm.pluginsdk.g.a.b.a) {
                        j.z(ajg.field_reportId, 7);
                        i = 0;
                    } else if (mVar.vfo instanceof com.tencent.mm.pluginsdk.g.a.b.c) {
                        j.z(ajg.field_reportId, 16);
                        i = 0;
                    }
                }
                if (i != 0) {
                    j.z(ajg.field_reportId, 11);
                }
                j.z(ajg.field_reportId, 44);
                j.a(ajg.field_resType, ajg.field_subType, ajg.field_url, bo.getInt(ajg.field_fileVersion, 0), com.tencent.mm.pluginsdk.g.a.a.j.a.FAIL, false, "NewXml".equalsIgnoreCase(ajg.field_groupId2), false, ajg.field_sampleId);
                AppMethodBeat.o(79470);
            }

            public final String awa() {
                return "CheckResUpdate";
            }

            public final void aeQ(String str) {
                boolean ajc;
                AppMethodBeat.i(79471);
                q diy = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA;
                if (diy.hrm) {
                    ajc = diy.vfy.ajc(str);
                } else {
                    ajc = false;
                }
                if (!ajc) {
                    i.aiY(str);
                }
                AppMethodBeat.o(79471);
            }
        };
        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.b("CheckResUpdate", this.uov);
        AppMethodBeat.o(79490);
    }

    public static void Ky(int i) {
        AppMethodBeat.i(79491);
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", Integer.valueOf(i));
        com.tencent.mm.kernel.g.RN();
        boolean QX = com.tencent.mm.kernel.a.QX();
        boolean equals = av.fly.T("login_user_name", "").equals("");
        if (QX || !equals) {
            com.tencent.mm.kernel.g.RO().eJo.a(new m(i), 0);
            AppMethodBeat.o(79491);
            return;
        }
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
        AppMethodBeat.o(79491);
    }

    /* Access modifiers changed, original: final */
    public final void b(s sVar) {
        AppMethodBeat.i(79493);
        ab.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + sVar.field_urlKey);
        k kVar = this.vdP;
        if (kVar.ajd(sVar.field_urlKey)) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
            AppMethodBeat.o(79493);
            return;
        }
        kVar.a(a.a(sVar));
        AppMethodBeat.o(79493);
    }

    static void c(s sVar) {
        AppMethodBeat.i(79494);
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", sVar.field_urlKey);
        k.g(sVar);
        AppMethodBeat.o(79494);
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, bsw bsw, boolean z) {
        AppMethodBeat.i(79495);
        final String gN = i.gN(i, bsw.wOI);
        if (bsw.wUV == null) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            AppMethodBeat.o(79495);
            return;
        }
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bsw.wOI), Integer.valueOf(bsw.wUV.wVf));
        j.z((long) bsw.wUX, 3);
        final int i2 = bsw.wUV.wVf;
        final int i3 = bsw.wOI;
        final int i4 = bsw.wUX;
        final String str = bsw.wUY;
        final int i5 = i;
        final boolean z2 = z;
        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79472);
                s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(gN);
                int i = i5;
                int i2 = i3;
                int i3 = i2;
                int i4 = i4;
                String str = str;
                boolean z = z2;
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(ajg)));
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", Integer.valueOf(i3));
                boolean z2 = false;
                if (ajg == null) {
                    j.z((long) i4, 47);
                    j.z((long) i4, 22);
                    z2 = true;
                } else if (bo.getInt(ajg.field_fileVersion, 0) <= i3) {
                    z2 = true;
                } else {
                    j.z(ajg.field_reportId, 47);
                    j.z(ajg.field_reportId, 22);
                }
                String gN = i.gN(i, i2);
                String aiX = i.aiX(gN);
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", Boolean.valueOf(z2), aiX);
                if (z2) {
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.AH(gN);
                    c.veg.g(i, i2, 2, z);
                    if ((((com.tencent.mm.pluginsdk.g.a.d.a.ajj(aiX) & 1) & com.tencent.mm.pluginsdk.g.a.d.a.ajj(aiX + ".decompressed")) & com.tencent.mm.pluginsdk.g.a.d.a.ajj(aiX + ".decrypted")) != 0) {
                        if (ajg != null) {
                            j.z(ajg.field_reportId, 21);
                            j.a(ajg.field_resType, ajg.field_subType, i3, z, ajg.field_sampleId);
                        }
                    } else if (ajg != null) {
                        j.z(ajg.field_reportId, 22);
                        j.z(ajg.field_reportId, 47);
                    }
                    if (ajg == null) {
                        s sVar = new s();
                        sVar.field_urlKey = gN;
                        sVar.field_resType = i;
                        sVar.field_subType = i2;
                        sVar.field_deleted = true;
                        sVar.field_fileVersion = String.valueOf(i3);
                        sVar.field_reportId = (long) i4;
                        sVar.field_sampleId = str;
                        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(sVar);
                        AppMethodBeat.o(79472);
                        return;
                    }
                    ajg.field_deleted = true;
                    ajg.field_fileVersion = String.valueOf(i3);
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                }
                AppMethodBeat.o(79472);
            }
        });
        AppMethodBeat.o(79495);
    }

    /* Access modifiers changed, original: final */
    public final void b(int i, bsw bsw, boolean z) {
        AppMethodBeat.i(79496);
        final String gN = i.gN(i, bsw.wOI);
        if (bsw.wUV == null) {
            ab.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", gN);
            AppMethodBeat.o(79496);
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
        ab.i(str2, str3, objArr);
        if (bsw.wUV.wVh != null) {
            Iterator it = bsw.wUV.wVh.iterator();
            while (it.hasNext()) {
                bzu bzu = (bzu) it.next();
                ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", Integer.valueOf(bzu.Version), bzu.wYR.dlY());
            }
        }
        j.mc((long) bsw.wUX);
        if (!z) {
            j.z((long) bsw.wUX, 1);
        }
        if (bsw.vQW != 0 && ((long) bsw.vQW) <= bo.anT()) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", gN, Integer.valueOf(bsw.vQW), Integer.valueOf(bsw.wUV.wVf));
            j.z((long) bsw.wUX, 14);
            j.z((long) bsw.wUX, 44);
            j.a(i, bsw.wOI, bsw.wUV.Url, bsw.wUV.wVf, com.tencent.mm.pluginsdk.g.a.a.j.a.FILE_EXPIRED, false, z, false, bsw.wUY);
            AppMethodBeat.o(79496);
        } else if (bo.isNullOrNil(bsw.wUV.Url) && bsw.wUV.wdt == null) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
            AppMethodBeat.o(79496);
        } else {
            com.tencent.mm.pluginsdk.g.a.a.g.a aVar = new com.tencent.mm.pluginsdk.g.a.a.g.a(bsw.wUV.Url);
            aVar.aja(gN);
            aVar.cut = i;
            aVar.cuu = bsw.wOI;
            aVar.md((long) bsw.vQW);
            aVar.cuv = bsw.wUV.wVf;
            aVar.ajb(bsw.wUV.wdO);
            aVar.vei = a.KA(bsw.wUV.wVg);
            aVar.vej = a.Kz(bsw.wUV.wVg);
            aVar.vdK = (long) bsw.wUX;
            aVar.vdL = bsw.wUY;
            aVar.KH(bsw.wUZ > 0 ? bsw.wUZ : 3);
            aVar.vek = bsw.vek;
            aVar.KG(bsw.wVa);
            aVar.cuA = z;
            if (!bo.ek(bsw.wUV.wVh)) {
                aVar.vdH = ((bzu) bsw.wUV.wVh.get(0)).wYR.wR;
            }
            if (!(bsw.wUW == null || bo.isNullOrNil(bsw.wUW.wVe))) {
                aVar.vdF = bsw.wUW.wVe;
                aVar.vdG = bsw.wUW.wVd;
            }
            if (bsw.wUV.wdt != null && bsw.wUV.wdt.wR.length > 0) {
                aVar.veh = bsw.wUV.wdt.toByteArray();
            }
            aVar.vdI = bsw.wUV.wVi;
            aVar.fileSize = (long) bsw.wUV.FileSize;
            aVar.KI(bsw.wxG);
            final g dii = aVar.dii();
            ab.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", dii.toString());
            com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(79473);
                    s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(gN);
                    g gVar = dii;
                    if (ajg == null) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
                    } else {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", ajg.field_urlKey, ajg.field_url, Long.valueOf(ajg.field_contentLength), Boolean.valueOf(ajg.field_deleted), ajg.field_eccSignature, Long.valueOf(ajg.field_expireTime), Boolean.valueOf(ajg.field_fileCompress), Boolean.valueOf(ajg.field_fileEncrypt), ajg.field_filePath, Boolean.valueOf(ajg.field_fileUpdated), ajg.field_fileVersion, ajg.field_groupId2, Integer.valueOf(ajg.field_keyVersion), Boolean.valueOf(bo.isNullOrNil(ajg.field_encryptKey)), Integer.valueOf(ajg.field_maxRetryTimes), Integer.valueOf(ajg.field_retryTimes), ajg.field_sampleId, Integer.valueOf(ajg.field_status));
                        ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", ajg.field_encryptKey);
                    }
                    s dih;
                    if (ajg != null && ajg.field_deleted && gVar.aiW(ajg.field_fileVersion) <= 0) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", ajg.field_fileVersion, gVar.veW);
                        AppMethodBeat.o(79473);
                    } else if (ajg == null) {
                        dih = gVar.dih();
                        dih.field_fileUpdated = true;
                        dih.field_needRetry = true;
                        if (bo.isNullOrNil(dih.field_encryptKey)) {
                            dih.field_keyVersion = -1;
                        }
                        ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(dih)));
                        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(dih);
                        c.veg.g(gVar.cut, gVar.cuu, 0, gVar.cuA);
                        a.a(true, true, dih, gVar);
                        AppMethodBeat.o(79473);
                    } else {
                        ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
                        ajg.field_networkType = gVar.networkType;
                        if (bo.isNullOrNil(ajg.field_originalMd5)) {
                            ajg.field_originalMd5 = gVar.vdI;
                        }
                        if (gVar.aiW(ajg.field_fileVersion) > 0) {
                            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                            dih = gVar.dih();
                            if (ajg.field_keyVersion >= gVar.vdG) {
                                dih.field_keyVersion = ajg.field_keyVersion;
                                dih.field_encryptKey = ajg.field_encryptKey;
                            }
                            dih.field_fileUpdated = true;
                            dih.field_needRetry = true;
                            dih.field_deleted = false;
                            com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(dih);
                            c.veg.g(gVar.cut, gVar.cuu, 0, gVar.cuA);
                            com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.AH(gVar.vdC);
                            a.a(false, true, dih, gVar);
                            AppMethodBeat.o(79473);
                        } else if (gVar.aiW(ajg.field_fileVersion) == 0 && !ajg.field_needRetry) {
                            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(ajg.field_resType), Integer.valueOf(ajg.field_subType), ajg.field_fileVersion);
                            AppMethodBeat.o(79473);
                        } else if (ajg.field_status == 2 || ajg.field_status == 1 || ajg.field_status == 0) {
                            long ek = com.tencent.mm.pluginsdk.g.a.d.a.ek(ajg.field_filePath);
                            if (ajg.field_contentLength > ek) {
                                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(ajg.field_contentLength), Long.valueOf(ek));
                                if (0 == ek) {
                                    c.veg.g(gVar.cut, gVar.cuu, 0, gVar.cuA);
                                    a.a(false, true, ajg, gVar);
                                    AppMethodBeat.o(79473);
                                    return;
                                }
                                a.a(true, false, ajg, gVar);
                                AppMethodBeat.o(79473);
                            } else if (bo.nullAsNil(com.tencent.mm.a.g.cz(i.aiX(gVar.vdC))).equals(ajg.field_md5)) {
                                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", ajg.field_urlKey);
                                ajg.field_status = 2;
                                ajg.field_contentLength = com.tencent.mm.pluginsdk.g.a.d.a.ek(ajg.field_filePath);
                                ajg.field_fileUpdated = false;
                                ajg.field_reportId = gVar.vdK;
                                com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                                j.z(ajg.field_reportId, 13);
                                j.z(ajg.field_reportId, 44);
                                j.a(ajg.field_resType, ajg.field_subType, ajg.field_url, bo.getInt(ajg.field_fileVersion, 0), com.tencent.mm.pluginsdk.g.a.a.j.a.FILE_LATEST, true, "NewXml".equalsIgnoreCase(ajg.field_groupId2), true, ajg.field_sampleId);
                                if (gVar.vei || gVar.vej) {
                                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", gVar.vdC);
                                    b.a(ajg, false, false);
                                    AppMethodBeat.o(79473);
                                    return;
                                }
                                c.veg.e(gVar.cut, gVar.cuu, i.aiX(gVar.vdC), bo.getInt(gVar.veW, 0));
                                AppMethodBeat.o(79473);
                            } else {
                                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                                a.a(false, true, ajg, gVar);
                                AppMethodBeat.o(79473);
                            }
                        } else {
                            if (ajg.field_status == 4 || ajg.field_status == 3) {
                                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", ajg.field_urlKey);
                                a.a(false, true, ajg, gVar);
                            }
                            AppMethodBeat.o(79473);
                        }
                    }
                }
            });
            AppMethodBeat.o(79496);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, bsw bsw, boolean z, boolean z2) {
        AppMethodBeat.i(79497);
        final String gN = i.gN(i, bsw.wOI);
        if (bsw.wUW == null) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
            AppMethodBeat.o(79497);
        } else if (bo.isNullOrNil(bsw.wUW.wVe)) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
            AppMethodBeat.o(79497);
        } else {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bsw.wOI), Integer.valueOf(bsw.wUW.wVd));
            ab.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", bsw.wUW.wVe);
            j.z((long) bsw.wUX, 4);
            final String str = bsw.wUV.wVi;
            final String str2 = bsw.wUW.wVe;
            final int i2 = bsw.wUW.wVd;
            final int i3 = bsw.wUX;
            final String str3 = bsw.wUY;
            final boolean z3 = z2;
            AnonymousClass6 anonymousClass6 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(79474);
                    s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(gN);
                    String str = str;
                    String str2 = str2;
                    int i = i2;
                    int i2 = i3;
                    String str3 = str3;
                    boolean z = z3;
                    if (ajg == null) {
                        ajg = new s();
                        ajg.field_keyVersion = i;
                        ajg.field_encryptKey = str2;
                        ajg.field_reportId = (long) i2;
                        ajg.field_sampleId = str3;
                        ajg.field_originalMd5 = str;
                        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                        j.z((long) i2, 51);
                        j.z((long) i2, 45);
                        AppMethodBeat.o(79474);
                    } else if (ajg.field_keyVersion < i) {
                        ajg.field_keyVersion = i;
                        ajg.field_encryptKey = str2;
                        ajg.field_reportId = (long) i2;
                        ajg.field_sampleId = str3;
                        if (bo.isNullOrNil(ajg.field_originalMd5)) {
                            ajg.field_originalMd5 = str;
                        }
                        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                        b.a(ajg, true, z);
                        AppMethodBeat.o(79474);
                    } else {
                        if (z && ajg.field_keyVersion == i) {
                            b.a(ajg, true, true);
                        }
                        AppMethodBeat.o(79474);
                    }
                }
            };
            if (z2) {
                anonymousClass6.run();
                AppMethodBeat.o(79497);
                return;
            }
            com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.R(anonymousClass6);
            AppMethodBeat.o(79497);
        }
    }

    public final void f(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(79487);
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79467);
                s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(i.gN(i4, i5));
                if (ajg != null && (-1 == i6 || String.valueOf(i6).equals(ajg.field_fileVersion))) {
                    boolean z;
                    if (z2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    ajg.field_needRetry = z;
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                }
                AppMethodBeat.o(79467);
            }
        });
        AppMethodBeat.o(79487);
    }

    public static String gM(int i, int i2) {
        AppMethodBeat.i(79492);
        s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(i.gN(i, i2));
        if (ajg == null) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(79492);
            return null;
        }
        ab.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", Boolean.valueOf(ajg.field_deleted), ajg.field_filePath, ajg.field_md5, Boolean.valueOf(ajg.field_fileCompress), Boolean.valueOf(ajg.field_fileEncrypt), ajg.field_originalMd5);
        if (ajg.field_fileCompress || ajg.field_fileEncrypt) {
            String str;
            if (ajg.field_fileCompress) {
                str = ajg.field_filePath + ".decompressed";
            } else if (ajg.field_fileEncrypt) {
                str = ajg.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(79492);
                return null;
            } else if (bo.isNullOrNil(ajg.field_originalMd5) || !bo.nullAsNil(com.tencent.mm.a.g.cz(str)).equals(ajg.field_originalMd5)) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(79492);
                return null;
            } else {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.o(79492);
                return str;
            }
        } else if (ajg.field_deleted || bo.isNullOrNil(ajg.field_filePath) || !bo.nullAsNil(com.tencent.mm.a.g.cz(ajg.field_filePath)).equals(ajg.field_md5)) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(79492);
            return null;
        } else {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", Integer.valueOf(i), Integer.valueOf(i2), ajg.field_filePath);
            String str2 = ajg.field_filePath;
            AppMethodBeat.o(79492);
            return str2;
        }
    }

    /* Access modifiers changed, original: final */
    public final void e(int i, int i2, String str, int i3) {
        AppMethodBeat.i(79498);
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final int i6 = i3;
        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79475);
                b bVar = b.this;
                int i = i4;
                int i2 = i5;
                String str = str2;
                int i3 = i6;
                s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(i.gN(i, i2));
                if (ajg == null) {
                    AppMethodBeat.o(79475);
                    return;
                }
                boolean z = ajg.field_fileUpdated;
                ajg.field_fileUpdated = false;
                com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                if (i3 == bo.getInt(ajg.field_fileVersion, 0)) {
                    if (com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.handler == null) {
                        ab.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
                        AppMethodBeat.o(79475);
                        return;
                    }
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.handler.post(new AnonymousClass8(i, i2, str, i3, z));
                }
                AppMethodBeat.o(79475);
            }
        });
        AppMethodBeat.o(79498);
    }

    /* Access modifiers changed, original: final */
    public final void g(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(79499);
        if (com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.handler == null) {
            ab.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
            AppMethodBeat.o(79499);
            return;
        }
        final int i4 = i3;
        final int i5 = i;
        final int i6 = i2;
        final boolean z2 = z;
        com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79468);
                bh bhVar = new bh();
                bhVar.cuB.cuy = i4;
                bhVar.cuB.cut = i5;
                bhVar.cuB.cuu = i6;
                bhVar.cuB.cuA = z2;
                com.tencent.mm.sdk.b.a.xxA.m(bhVar);
                AppMethodBeat.o(79468);
            }
        });
        AppMethodBeat.o(79499);
    }
}
