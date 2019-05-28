package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.a.px;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import junit.framework.Assert;

public class PluginWebSearch extends f implements b, com.tencent.mm.kernel.api.a, c {
    private static HashMap<Integer, d> cbO = new HashMap();
    private com.tencent.mm.sdk.b.c gyU = new com.tencent.mm.sdk.b.c<bf>() {
        {
            AppMethodBeat.i(91308);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(91308);
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00dd  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00dd  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x013b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(bf bfVar) {
            Exception e;
            Throwable th;
            AppMethodBeat.i(91309);
            if (bfVar != null && bfVar.cus.cut == 27) {
                if (bfVar.cus.cuu == 2 && !PluginWebSearch.checkTopStoryTemplateFolderValid()) {
                    PluginWebSearch.access$100(bfVar.cus.cuu, 12);
                }
                String Ib = aa.Ib(bfVar.cus.cuu);
                String Ic = aa.Ic(bfVar.cus.cuu);
                int Id = aa.Id(bfVar.cus.cuu);
                if (!(bo.isNullOrNil(Ib) || bo.isNullOrNil(Ic))) {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bfVar.cus.filePath);
                    if (bVar.exists()) {
                        ab.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener callback to update %s", bVar.dME());
                        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(Ib, "temp");
                        com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(bVar2, Ic);
                        bVar2.mkdirs();
                        e.y(j.w(bVar.dMD()), j.w(bVar3.dMD()));
                        int hU = bo.hU(j.w(bVar3.dMD()), j.w(bVar2.dMD()));
                        int i = 1;
                        if (hU >= 0) {
                            Properties properties = new Properties();
                            Closeable dVar;
                            try {
                                dVar = new com.tencent.mm.vfs.d(new com.tencent.mm.vfs.b(bVar2, "config.conf"));
                                try {
                                    properties.load(dVar);
                                    bo.b(dVar);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                        bo.b(dVar);
                                        i = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                        e.N(j.w(bVar2.mUri), true);
                                        if (Id < i) {
                                        }
                                        AppMethodBeat.o(91309);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bo.b(dVar);
                                        AppMethodBeat.o(91309);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                dVar = null;
                                ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                bo.b(dVar);
                                i = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                e.N(j.w(bVar2.mUri), true);
                                if (Id < i) {
                                }
                                AppMethodBeat.o(91309);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                dVar = null;
                                bo.b(dVar);
                                AppMethodBeat.o(91309);
                                throw th;
                            }
                            i = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                        }
                        e.N(j.w(bVar2.mUri), true);
                        if (Id < i) {
                            PluginWebSearch.access$100(bfVar.cus.cuu, 9);
                            ab.i("MicroMsg.WebSearch.PluginWebSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bfVar.cus.cuu), Integer.valueOf(Id), Integer.valueOf(i));
                            PluginWebSearch.access$200(PluginWebSearch.this, bVar, bfVar.cus.cuu);
                        } else {
                            if (hU >= 0) {
                                PluginWebSearch.access$100(bfVar.cus.cuu, 13);
                            } else {
                                PluginWebSearch.access$100(bfVar.cus.cuu, 11);
                            }
                            ab.i("MicroMsg.WebSearch.PluginWebSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bfVar.cus.cuu), Integer.valueOf(Id), Integer.valueOf(i));
                        }
                    } else {
                        ab.e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                    }
                }
            }
            AppMethodBeat.o(91309);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c iDB = new com.tencent.mm.sdk.b.c<ji>() {
        {
            AppMethodBeat.i(91311);
            this.xxI = ji.class.getName().hashCode();
            AppMethodBeat.o(91311);
        }

        private boolean a(ji jiVar) {
            Exception e;
            int intValue;
            Throwable th;
            AppMethodBeat.i(91312);
            if (jiVar != null && jiVar.cEE.cut == 27) {
                com.tencent.mm.vfs.b bVar;
                if (jiVar.cEE.cuu == 1) {
                    com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(jiVar.cEE.filePath);
                    if (bVar2.exists()) {
                        ab.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener callback to update %s", bVar2.dME());
                        com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(aa.Ib(jiVar.cEE.cuu), "temp");
                        bVar = new com.tencent.mm.vfs.b(bVar3, aa.Ic(jiVar.cEE.cuu));
                        bVar3.mkdirs();
                        e.y(j.w(bVar2.dMD()), j.w(bVar.dMD()));
                        if (bo.hU(j.w(bVar.dMD()), j.w(bVar3.dMD())) >= 0) {
                            Properties properties = new Properties();
                            Closeable dVar;
                            try {
                                dVar = new com.tencent.mm.vfs.d(new com.tencent.mm.vfs.b(bVar3, "config.conf"));
                                try {
                                    properties.load(dVar);
                                    bo.b(dVar);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                        bo.b(dVar);
                                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                        e.N(j.w(bVar3.mUri), true);
                                        ab.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(aa.HV(0)), Integer.valueOf(intValue));
                                        PluginWebSearch.access$200(PluginWebSearch.this, bVar2, jiVar.cEE.cuu);
                                        AppMethodBeat.o(91312);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bo.b(dVar);
                                        AppMethodBeat.o(91312);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                dVar = null;
                                ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                bo.b(dVar);
                                intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                e.N(j.w(bVar3.mUri), true);
                                ab.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(aa.HV(0)), Integer.valueOf(intValue));
                                PluginWebSearch.access$200(PluginWebSearch.this, bVar2, jiVar.cEE.cuu);
                                AppMethodBeat.o(91312);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                dVar = null;
                                bo.b(dVar);
                                AppMethodBeat.o(91312);
                                throw th;
                            }
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                        } else {
                            intValue = 1;
                        }
                        e.N(j.w(bVar3.mUri), true);
                        ab.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(aa.HV(0)), Integer.valueOf(intValue));
                        PluginWebSearch.access$200(PluginWebSearch.this, bVar2, jiVar.cEE.cuu);
                    } else {
                        ab.e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                    }
                } else if (jiVar.cEE.cuu == 2) {
                    bVar = new com.tencent.mm.vfs.b(jiVar.cEE.filePath);
                    if (bVar.exists()) {
                        int HV = aa.HV(1);
                        PluginWebSearch.access$200(PluginWebSearch.this, bVar, jiVar.cEE.cuu);
                        ab.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(HV), Integer.valueOf(aa.HV(1)));
                    } else {
                        ab.e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                    }
                }
            }
            AppMethodBeat.o(91312);
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c kTy = new com.tencent.mm.sdk.b.c<bc>() {
        {
            AppMethodBeat.i(91305);
            this.xxI = bc.class.getName().hashCode();
            AppMethodBeat.o(91305);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(91306);
            PluginWebSearch.this.tZb;
            b.cUJ();
            AppMethodBeat.o(91306);
            return false;
        }
    };
    private o sAp = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(91314);
            if (!(map == null || str == null)) {
                if (str.equals("mmsearch_reddot_new")) {
                    int ank = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                    if (ank == 1) {
                        ab.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", "mmsearch_reddot_new", map.toString());
                        int ank2 = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                        String t = bo.t((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                        int ank3 = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                        int ank4 = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                        long anl = bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                        int ank5 = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                        int ank6 = bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                        String str2 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                        String str3 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                        long anl2 = bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                        am cVt = am.cVt();
                        com.tencent.mm.plugin.websearch.api.am.a aVar2 = null;
                        switch (ank) {
                            case 1:
                                aVar2 = cVt.uaS;
                                break;
                        }
                        if (aVar2 == null) {
                            aVar2 = new com.tencent.mm.plugin.websearch.api.am.a();
                        }
                        if (aVar2.timestamp < anl2) {
                            aVar2.id = t;
                            aVar2.uaW = ank3;
                            aVar2.uaU = ank;
                            aVar2.uaV = ank4;
                            aVar2.oak = anl;
                            aVar2.tZU = ank5;
                            aVar2.type = ank6;
                            aVar2.text = str2;
                            aVar2.cIY = str3;
                            aVar2.timestamp = anl2;
                            aVar2.clear = ank2;
                            aVar2.fJB = System.currentTimeMillis();
                        } else {
                            ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", Long.valueOf(anl2), Long.valueOf(aVar2.timestamp));
                        }
                        cVt.save();
                        com.tencent.mm.sdk.b.a.xxA.m(new px());
                    }
                }
            }
            AppMethodBeat.o(91314);
        }
    };
    private a tZa;
    private b tZb;

    class a implements Runnable {
        boolean tZd;

        a(boolean z) {
            this.tZd = z;
        }

        public final void run() {
            AppMethodBeat.i(91315);
            PluginWebSearch.access$300(PluginWebSearch.this, this.tZd);
            AppMethodBeat.o(91315);
        }
    }

    public PluginWebSearch() {
        AppMethodBeat.i(91316);
        AppMethodBeat.o(91316);
    }

    static /* synthetic */ void access$100(int i, int i2) {
        AppMethodBeat.i(91326);
        reportIdKey649ForLook(i, i2);
        AppMethodBeat.o(91326);
    }

    static /* synthetic */ void access$200(PluginWebSearch pluginWebSearch, com.tencent.mm.vfs.b bVar, int i) {
        AppMethodBeat.i(91327);
        pluginWebSearch.initTemplateFoldByResUpdate(bVar, i);
        AppMethodBeat.o(91327);
    }

    static /* synthetic */ void access$300(PluginWebSearch pluginWebSearch, boolean z) {
        AppMethodBeat.i(91328);
        pluginWebSearch.copyTemplateFile(z);
        AppMethodBeat.o(91328);
    }

    static {
        AppMethodBeat.i(91329);
        final String[] strArr = new String[]{com.tencent.mm.sdk.e.j.a(com.tencent.mm.plugin.websearch.widget.a.a.ccO, "WidgetSafeMode")};
        cbO.put(Integer.valueOf("WidgetSafeMode".hashCode()), new d() {
            public final String[] Af() {
                return strArr;
            }
        });
        AppMethodBeat.o(91329);
    }

    public void installed() {
        AppMethodBeat.i(91317);
        super.installed();
        AppMethodBeat.o(91317);
    }

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(91318);
        super.configure(gVar);
        this.tZa = new a();
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.b.b()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.j.class, new com.tencent.mm.kernel.c.e(this.tZa));
        com.tencent.mm.kernel.g.a(n.class, new com.tencent.mm.kernel.c.e(new c()));
        com.tencent.mm.kernel.g.a(h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
        com.tencent.mm.kernel.g.a(p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            this.tZb = new b();
            com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.tZb));
        }
        AppMethodBeat.o(91318);
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(91319);
        this.gyU.dnU();
        this.iDB.dnU();
        this.kTy.dnU();
        b.init();
        com.tencent.mm.sdk.g.d.post(new a(cVar.eKe), "CopySearchTemplateTask");
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.sAp);
        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            com.tencent.mm.kernel.g.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91307);
                    aa.lL(5000);
                    long Id = (long) aa.Id(1);
                    if (((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEBSEARCH_LAST_REPORT_H5VERSION_LONG, Long.valueOf(0))).longValue() != Id) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(17040, Integer.valueOf(2), Long.valueOf(Id));
                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEBSEARCH_LAST_REPORT_H5VERSION_LONG, Long.valueOf(Id));
                        com.tencent.mm.kernel.g.RP().Ry().dsb();
                    }
                    AppMethodBeat.o(91307);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(91319);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(91320);
        this.gyU.dead();
        this.iDB.dead();
        this.kTy.dead();
        ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.sAp);
        ai.uaA = null;
        AppMethodBeat.o(91320);
    }

    private void copyTemplateFile(boolean z) {
        int i;
        AppMethodBeat.i(91321);
        int[] iArr = new int[]{0, 1};
        String[] strArr = new String[2];
        for (i = 0; i < 2; i++) {
            strArr[i] = aa.Ia(iArr[i]);
        }
        Assert.assertEquals(2, 2);
        i = 0;
        while (i < 2) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(strArr[i]);
            ab.i("MicroMsg.WebSearch.PluginWebSearch", "copy to path %s, type %d", j.w(bVar.dMD()), Integer.valueOf(iArr[i]));
            aa.HZ(iArr[i]);
            int HV = aa.HV(iArr[i]);
            if (z) {
                ab.i("MicroMsg.WebSearch.PluginWebSearch", "need update assetVersion=%d currentVersion=%d type=%d", Integer.valueOf(aa.HT(iArr[i])), Integer.valueOf(HV), Integer.valueOf(iArr[i]));
                if (HV < aa.HT(iArr[i])) {
                    e.N(j.w(bVar.mUri), true);
                    aa.a(bVar, iArr[i]);
                }
            } else if (HV == 1 || aa.cVi()) {
                ab.i("MicroMsg.WebSearch.PluginWebSearch", "need init template");
                e.N(j.w(bVar.mUri), true);
                aa.a(bVar, iArr[i]);
            } else {
                ab.i("MicroMsg.WebSearch.PluginWebSearch", "currentVersion=%d", Integer.valueOf(HV));
            }
            if (iArr[i] == 0 && !aa.HS(iArr[i])) {
                ab.i("MicroMsg.WebSearch.PluginWebSearch", "copyTemplateFile check md5 fail, try once");
                e.N(j.w(bVar.mUri), true);
                aa.a(bVar, iArr[i], true);
            }
            i++;
        }
        e.N(j.w(new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.eSn, "fts").mUri), true);
        AppMethodBeat.o(91321);
    }

    private void initTemplateFoldByResUpdate(com.tencent.mm.vfs.b bVar, int i) {
        AppMethodBeat.i(91322);
        initTemplateFoldByResUpdate(bVar, i, false);
        AppMethodBeat.o(91322);
    }

    /* JADX WARNING: Missing block: B:35:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initTemplateFoldByResUpdate(com.tencent.mm.vfs.b bVar, int i, boolean z) {
        AppMethodBeat.i(91323);
        while (true) {
            String str = "";
            String str2 = "";
            int i2 = -1;
            switch (i) {
                case 1:
                    str = aa.Ia(0);
                    str2 = aa.HY(0);
                    i2 = 0;
                    break;
                case 2:
                    str = aa.Ia(1);
                    str2 = aa.HY(1);
                    i2 = 1;
                    break;
            }
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.w("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", Integer.valueOf(i), j.w(bVar.dMD()));
                AppMethodBeat.o(91323);
            } else {
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str);
                e.N(j.w(bVar2.mUri), true);
                bVar2.mkdirs();
                com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(bVar2, ".nomedia");
                if (!bVar3.exists()) {
                    try {
                        bVar3.createNewFile();
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, "create nomedia file error", new Object[0]);
                    }
                }
                bVar3 = new com.tencent.mm.vfs.b(str2);
                e.y(j.w(bVar.dMD()), j.w(bVar3.dMD()));
                int hU = bo.hU(j.w(bVar3.dMD()), bVar3.getParent());
                if (hU < 0) {
                    ab.e("MicroMsg.WebSearch.PluginWebSearch", "unzip fail, ret = " + hU + ", zipFilePath = " + j.w(bVar3.dMD()) + ", unzipPath = " + bVar3.getParent());
                } else {
                    switch (i) {
                        case 1:
                            aa.HZ(0);
                            hU = aa.HV(0);
                            break;
                        case 2:
                            aa.HZ(1);
                            hU = aa.HV(1);
                            break;
                        default:
                            hU = 1;
                            break;
                    }
                    com.tencent.mm.sdk.b.a.xxA.m(new ns());
                    ab.i("MicroMsg.WebSearch.PluginWebSearch", "Unzip Path%s version=%d", bVar3.getParent(), Integer.valueOf(hU));
                }
                if (z || i2 != 0 || aa.HS(i2)) {
                    AppMethodBeat.o(91323);
                } else {
                    ab.i("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate fail, try again , ftsTemplateFolder %s, type %d", bVar2, Integer.valueOf(i2));
                    z = true;
                }
            }
        }
        AppMethodBeat.o(91323);
    }

    private static void reportIdKey649ForLook(int i, int i2) {
        AppMethodBeat.i(91324);
        if (i == 2) {
            an.Il(i2);
        }
        AppMethodBeat.o(91324);
    }

    public static boolean checkTopStoryTemplateFolderValid() {
        AppMethodBeat.i(91325);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(aa.Ia(1));
        if (bVar.exists() && bVar.isDirectory()) {
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(bVar, aa.cUZ());
            com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(bVar, aa.cVa());
            if (bVar2.exists() && bVar3.exists()) {
                AppMethodBeat.o(91325);
                return true;
            }
            AppMethodBeat.o(91325);
            return false;
        }
        AppMethodBeat.o(91325);
        return false;
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return cbO;
    }
}
