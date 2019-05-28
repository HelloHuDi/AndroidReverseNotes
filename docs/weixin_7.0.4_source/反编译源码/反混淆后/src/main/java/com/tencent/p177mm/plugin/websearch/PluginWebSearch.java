package com.tencent.p177mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18347ns;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32622px;
import com.tencent.p177mm.p230g.p231a.C37743ji;
import com.tencent.p177mm.p230g.p231a.C9298bc;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.plugin.websearch.api.C22758p;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.api.C4514am;
import com.tencent.p177mm.plugin.websearch.api.C4514am.C4515a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46402e;
import com.tencent.p177mm.plugin.websearch.p1063b.C40196b;
import com.tencent.p177mm.plugin.websearch.widget.C40200b;
import com.tencent.p177mm.plugin.websearch.widget.C46408c;
import com.tencent.p177mm.plugin.websearch.widget.p577a.C4534a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C40922d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch */
public class PluginWebSearch extends C7597f implements C1655b, C1669a, C9562c {
    private static HashMap<Integer, C1366d> cbO = new HashMap();
    private C4884c gyU = new C355654();
    private C4884c iDB = new C297325();
    private final C4884c kTy = new C355642();
    private C3473o sAp = new C227466();
    private C46399a tZa;
    private C41329b tZb;

    /* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch$6 */
    class C227466 implements C3473o {
        C227466() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(91314);
            if (!(map == null || str == null)) {
                if (str.equals("mmsearch_reddot_new")) {
                    int ank = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                    if (ank == 1) {
                        C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", "mmsearch_reddot_new", map.toString());
                        int ank2 = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                        String t = C5046bo.m7584t((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                        int ank3 = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                        int ank4 = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                        long anl = C5046bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                        int ank5 = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                        int ank6 = C5046bo.ank((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                        String str2 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                        String str3 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                        long anl2 = C5046bo.anl((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                        C4514am cVt = C4514am.cVt();
                        C4515a c4515a = null;
                        switch (ank) {
                            case 1:
                                c4515a = cVt.uaS;
                                break;
                        }
                        if (c4515a == null) {
                            c4515a = new C4515a();
                        }
                        if (c4515a.timestamp < anl2) {
                            c4515a.f1288id = t;
                            c4515a.uaW = ank3;
                            c4515a.uaU = ank;
                            c4515a.uaV = ank4;
                            c4515a.oak = anl;
                            c4515a.tZU = ank5;
                            c4515a.type = ank6;
                            c4515a.text = str2;
                            c4515a.cIY = str3;
                            c4515a.timestamp = anl2;
                            c4515a.clear = ank2;
                            c4515a.fJB = System.currentTimeMillis();
                        } else {
                            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", Long.valueOf(anl2), Long.valueOf(c4515a.timestamp));
                        }
                        cVt.save();
                        C4879a.xxA.mo10055m(new C32622px());
                    }
                }
            }
            AppMethodBeat.m2505o(91314);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch$a */
    class C22747a implements Runnable {
        boolean tZd;

        C22747a(boolean z) {
            this.tZd = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(91315);
            PluginWebSearch.access$300(PluginWebSearch.this, this.tZd);
            AppMethodBeat.m2505o(91315);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch$5 */
    class C297325 extends C4884c<C37743ji> {
        C297325() {
            AppMethodBeat.m2504i(91311);
            this.xxI = C37743ji.class.getName().hashCode();
            AppMethodBeat.m2505o(91311);
        }

        /* renamed from: a */
        private boolean m47139a(C37743ji c37743ji) {
            Exception e;
            int intValue;
            Throwable th;
            AppMethodBeat.m2504i(91312);
            if (c37743ji != null && c37743ji.cEE.cut == 27) {
                C5728b c5728b;
                if (c37743ji.cEE.cuu == 1) {
                    C5728b c5728b2 = new C5728b(c37743ji.cEE.filePath);
                    if (c5728b2.exists()) {
                        C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener callback to update %s", c5728b2.dME());
                        C5728b c5728b3 = new C5728b(C46400aa.m87311Ib(c37743ji.cEE.cuu), "temp");
                        c5728b = new C5728b(c5728b3, C46400aa.m87312Ic(c37743ji.cEE.cuu));
                        c5728b3.mkdirs();
                        C5730e.m8644y(C5736j.m8649w(c5728b2.dMD()), C5736j.m8649w(c5728b.dMD()));
                        if (C5046bo.m7570hU(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b3.dMD())) >= 0) {
                            Properties properties = new Properties();
                            Closeable c40922d;
                            try {
                                c40922d = new C40922d(new C5728b(c5728b3, "config.conf"));
                                try {
                                    properties.load(c40922d);
                                    C5046bo.m7527b(c40922d);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                        C5046bo.m7527b(c40922d);
                                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                        C5730e.m8618N(C5736j.m8649w(c5728b3.mUri), true);
                                        C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(C46400aa.m87305HV(0)), Integer.valueOf(intValue));
                                        PluginWebSearch.access$200(PluginWebSearch.this, c5728b2, c37743ji.cEE.cuu);
                                        AppMethodBeat.m2505o(91312);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        C5046bo.m7527b(c40922d);
                                        AppMethodBeat.m2505o(91312);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                c40922d = null;
                                C4990ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                C5046bo.m7527b(c40922d);
                                intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                C5730e.m8618N(C5736j.m8649w(c5728b3.mUri), true);
                                C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(C46400aa.m87305HV(0)), Integer.valueOf(intValue));
                                PluginWebSearch.access$200(PluginWebSearch.this, c5728b2, c37743ji.cEE.cuu);
                                AppMethodBeat.m2505o(91312);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                c40922d = null;
                                C5046bo.m7527b(c40922d);
                                AppMethodBeat.m2505o(91312);
                                throw th;
                            }
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                        } else {
                            intValue = 1;
                        }
                        C5730e.m8618N(C5736j.m8649w(c5728b3.mUri), true);
                        C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(C46400aa.m87305HV(0)), Integer.valueOf(intValue));
                        PluginWebSearch.access$200(PluginWebSearch.this, c5728b2, c37743ji.cEE.cuu);
                    } else {
                        C4990ab.m7412e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                    }
                } else if (c37743ji.cEE.cuu == 2) {
                    c5728b = new C5728b(c37743ji.cEE.filePath);
                    if (c5728b.exists()) {
                        int HV = C46400aa.m87305HV(1);
                        PluginWebSearch.access$200(PluginWebSearch.this, c5728b, c37743ji.cEE.cuu);
                        C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(HV), Integer.valueOf(C46400aa.m87305HV(1)));
                    } else {
                        C4990ab.m7412e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                    }
                }
            }
            AppMethodBeat.m2505o(91312);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch$2 */
    class C355642 extends C4884c<C9298bc> {
        C355642() {
            AppMethodBeat.m2504i(91305);
            this.xxI = C9298bc.class.getName().hashCode();
            AppMethodBeat.m2505o(91305);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(91306);
            PluginWebSearch.this.tZb;
            C41329b.cUJ();
            AppMethodBeat.m2505o(91306);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch$4 */
    class C355654 extends C4884c<C32519bf> {
        C355654() {
            AppMethodBeat.m2504i(91308);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(91308);
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00dd  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00dd  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x013b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private boolean m58395a(C32519bf c32519bf) {
            Exception e;
            Throwable th;
            AppMethodBeat.m2504i(91309);
            if (c32519bf != null && c32519bf.cus.cut == 27) {
                if (c32519bf.cus.cuu == 2 && !PluginWebSearch.checkTopStoryTemplateFolderValid()) {
                    PluginWebSearch.access$100(c32519bf.cus.cuu, 12);
                }
                String Ib = C46400aa.m87311Ib(c32519bf.cus.cuu);
                String Ic = C46400aa.m87312Ic(c32519bf.cus.cuu);
                int Id = C46400aa.m87313Id(c32519bf.cus.cuu);
                if (!(C5046bo.isNullOrNil(Ib) || C5046bo.isNullOrNil(Ic))) {
                    C5728b c5728b = new C5728b(c32519bf.cus.filePath);
                    if (c5728b.exists()) {
                        C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener callback to update %s", c5728b.dME());
                        C5728b c5728b2 = new C5728b(Ib, "temp");
                        C5728b c5728b3 = new C5728b(c5728b2, Ic);
                        c5728b2.mkdirs();
                        C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b3.dMD()));
                        int hU = C5046bo.m7570hU(C5736j.m8649w(c5728b3.dMD()), C5736j.m8649w(c5728b2.dMD()));
                        int i = 1;
                        if (hU >= 0) {
                            Properties properties = new Properties();
                            Closeable c40922d;
                            try {
                                c40922d = new C40922d(new C5728b(c5728b2, "config.conf"));
                                try {
                                    properties.load(c40922d);
                                    C5046bo.m7527b(c40922d);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                        C5046bo.m7527b(c40922d);
                                        i = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                        C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                                        if (Id < i) {
                                        }
                                        AppMethodBeat.m2505o(91309);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        C5046bo.m7527b(c40922d);
                                        AppMethodBeat.m2505o(91309);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                c40922d = null;
                                C4990ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                C5046bo.m7527b(c40922d);
                                i = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                                if (Id < i) {
                                }
                                AppMethodBeat.m2505o(91309);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                c40922d = null;
                                C5046bo.m7527b(c40922d);
                                AppMethodBeat.m2505o(91309);
                                throw th;
                            }
                            i = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                        }
                        C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                        if (Id < i) {
                            PluginWebSearch.access$100(c32519bf.cus.cuu, 9);
                            C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(c32519bf.cus.cuu), Integer.valueOf(Id), Integer.valueOf(i));
                            PluginWebSearch.access$200(PluginWebSearch.this, c5728b, c32519bf.cus.cuu);
                        } else {
                            if (hU >= 0) {
                                PluginWebSearch.access$100(c32519bf.cus.cuu, 13);
                            } else {
                                PluginWebSearch.access$100(c32519bf.cus.cuu, 11);
                            }
                            C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(c32519bf.cus.cuu), Integer.valueOf(Id), Integer.valueOf(i));
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                    }
                }
            }
            AppMethodBeat.m2505o(91309);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.PluginWebSearch$3 */
    class C355673 implements Runnable {
        C355673() {
        }

        public final void run() {
            AppMethodBeat.m2504i(91307);
            C46400aa.m87339lL(5000);
            long Id = (long) C46400aa.m87313Id(1);
            if (((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEBSEARCH_LAST_REPORT_H5VERSION_LONG, Long.valueOf(0))).longValue() != Id) {
                C7060h.pYm.mo8381e(17040, Integer.valueOf(2), Long.valueOf(Id));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEBSEARCH_LAST_REPORT_H5VERSION_LONG, Long.valueOf(Id));
                C1720g.m3536RP().mo5239Ry().dsb();
            }
            AppMethodBeat.m2505o(91307);
        }
    }

    public PluginWebSearch() {
        AppMethodBeat.m2504i(91316);
        AppMethodBeat.m2505o(91316);
    }

    static /* synthetic */ void access$100(int i, int i2) {
        AppMethodBeat.m2504i(91326);
        PluginWebSearch.reportIdKey649ForLook(i, i2);
        AppMethodBeat.m2505o(91326);
    }

    static /* synthetic */ void access$200(PluginWebSearch pluginWebSearch, C5728b c5728b, int i) {
        AppMethodBeat.m2504i(91327);
        pluginWebSearch.initTemplateFoldByResUpdate(c5728b, i);
        AppMethodBeat.m2505o(91327);
    }

    static /* synthetic */ void access$300(PluginWebSearch pluginWebSearch, boolean z) {
        AppMethodBeat.m2504i(91328);
        pluginWebSearch.copyTemplateFile(z);
        AppMethodBeat.m2505o(91328);
    }

    static {
        AppMethodBeat.m2504i(91329);
        final String[] strArr = new String[]{C7563j.m13217a(C4534a.ccO, "WidgetSafeMode")};
        cbO.put(Integer.valueOf("WidgetSafeMode".hashCode()), new C1366d() {
            /* renamed from: Af */
            public final String[] mo4750Af() {
                return strArr;
            }
        });
        AppMethodBeat.m2505o(91329);
    }

    public void installed() {
        AppMethodBeat.m2504i(91317);
        super.installed();
        AppMethodBeat.m2505o(91317);
    }

    public void execute(C1681g c1681g) {
    }

    public void parallelsDependency() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(91318);
        super.configure(c1681g);
        this.tZa = new C46399a();
        C1720g.m3543a(C46402e.class, new C6625e(new C40196b()));
        C1720g.m3543a(C22757j.class, new C6625e(this.tZa));
        C1720g.m3543a(C43852n.class, new C6625e(new C29747c()));
        C1720g.m3543a(C29740h.class, new C6625e(new C40200b()));
        C1720g.m3543a(C22758p.class, new C6625e(new C46408c()));
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            this.tZb = new C41329b();
            C1720g.m3543a(C40193m.class, new C6625e(this.tZb));
        }
        AppMethodBeat.m2505o(91318);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(91319);
        this.gyU.dnU();
        this.iDB.dnU();
        this.kTy.dnU();
        C41329b.init();
        C7305d.post(new C22747a(c1705c.eKe), "CopySearchTemplateTask");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("mmsearch_reddot_new", this.sAp);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C1720g.m3539RS().mo10310m(new C355673(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(91319);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(91320);
        this.gyU.dead();
        this.iDB.dead();
        this.kTy.dead();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("mmsearch_reddot_new", this.sAp);
        C35573ai.uaA = null;
        AppMethodBeat.m2505o(91320);
    }

    private void copyTemplateFile(boolean z) {
        int i;
        AppMethodBeat.m2504i(91321);
        int[] iArr = new int[]{0, 1};
        String[] strArr = new String[2];
        for (i = 0; i < 2; i++) {
            strArr[i] = C46400aa.m87310Ia(iArr[i]);
        }
        Assert.assertEquals(2, 2);
        i = 0;
        while (i < 2) {
            C5728b c5728b = new C5728b(strArr[i]);
            C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "copy to path %s, type %d", C5736j.m8649w(c5728b.dMD()), Integer.valueOf(iArr[i]));
            C46400aa.m87309HZ(iArr[i]);
            int HV = C46400aa.m87305HV(iArr[i]);
            if (z) {
                C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "need update assetVersion=%d currentVersion=%d type=%d", Integer.valueOf(C46400aa.m87303HT(iArr[i])), Integer.valueOf(HV), Integer.valueOf(iArr[i]));
                if (HV < C46400aa.m87303HT(iArr[i])) {
                    C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true);
                    C46400aa.m87326a(c5728b, iArr[i]);
                }
            } else if (HV == 1 || C46400aa.cVi()) {
                C4990ab.m7416i("MicroMsg.WebSearch.PluginWebSearch", "need init template");
                C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true);
                C46400aa.m87326a(c5728b, iArr[i]);
            } else {
                C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "currentVersion=%d", Integer.valueOf(HV));
            }
            if (iArr[i] == 0 && !C46400aa.m87302HS(iArr[i])) {
                C4990ab.m7416i("MicroMsg.WebSearch.PluginWebSearch", "copyTemplateFile check md5 fail, try once");
                C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true);
                C46400aa.m87327a(c5728b, iArr[i], true);
            }
            i++;
        }
        C5730e.m8618N(C5736j.m8649w(new C5728b(C6457e.eSn, "fts").mUri), true);
        AppMethodBeat.m2505o(91321);
    }

    private void initTemplateFoldByResUpdate(C5728b c5728b, int i) {
        AppMethodBeat.m2504i(91322);
        initTemplateFoldByResUpdate(c5728b, i, false);
        AppMethodBeat.m2505o(91322);
    }

    /* JADX WARNING: Missing block: B:35:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initTemplateFoldByResUpdate(C5728b c5728b, int i, boolean z) {
        AppMethodBeat.m2504i(91323);
        while (true) {
            String str = "";
            String str2 = "";
            int i2 = -1;
            switch (i) {
                case 1:
                    str = C46400aa.m87310Ia(0);
                    str2 = C46400aa.m87308HY(0);
                    i2 = 0;
                    break;
                case 2:
                    str = C46400aa.m87310Ia(1);
                    str2 = C46400aa.m87308HY(1);
                    i2 = 1;
                    break;
            }
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                C4990ab.m7421w("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", Integer.valueOf(i), C5736j.m8649w(c5728b.dMD()));
                AppMethodBeat.m2505o(91323);
            } else {
                C5728b c5728b2 = new C5728b(str);
                C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                c5728b2.mkdirs();
                C5728b c5728b3 = new C5728b(c5728b2, ".nomedia");
                if (!c5728b3.exists()) {
                    try {
                        c5728b3.createNewFile();
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, "create nomedia file error", new Object[0]);
                    }
                }
                c5728b3 = new C5728b(str2);
                C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b3.dMD()));
                int hU = C5046bo.m7570hU(C5736j.m8649w(c5728b3.dMD()), c5728b3.getParent());
                if (hU < 0) {
                    C4990ab.m7412e("MicroMsg.WebSearch.PluginWebSearch", "unzip fail, ret = " + hU + ", zipFilePath = " + C5736j.m8649w(c5728b3.dMD()) + ", unzipPath = " + c5728b3.getParent());
                } else {
                    switch (i) {
                        case 1:
                            C46400aa.m87309HZ(0);
                            hU = C46400aa.m87305HV(0);
                            break;
                        case 2:
                            C46400aa.m87309HZ(1);
                            hU = C46400aa.m87305HV(1);
                            break;
                        default:
                            hU = 1;
                            break;
                    }
                    C4879a.xxA.mo10055m(new C18347ns());
                    C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "Unzip Path%s version=%d", c5728b3.getParent(), Integer.valueOf(hU));
                }
                if (z || i2 != 0 || C46400aa.m87302HS(i2)) {
                    AppMethodBeat.m2505o(91323);
                } else {
                    C4990ab.m7417i("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate fail, try again , ftsTemplateFolder %s, type %d", c5728b2, Integer.valueOf(i2));
                    z = true;
                }
            }
        }
        AppMethodBeat.m2505o(91323);
    }

    private static void reportIdKey649ForLook(int i, int i2) {
        AppMethodBeat.m2504i(91324);
        if (i == 2) {
            C14423an.m22640Il(i2);
        }
        AppMethodBeat.m2505o(91324);
    }

    public static boolean checkTopStoryTemplateFolderValid() {
        AppMethodBeat.m2504i(91325);
        C5728b c5728b = new C5728b(C46400aa.m87310Ia(1));
        if (c5728b.exists() && c5728b.isDirectory()) {
            C5728b c5728b2 = new C5728b(c5728b, C46400aa.cUZ());
            C5728b c5728b3 = new C5728b(c5728b, C46400aa.cVa());
            if (c5728b2.exists() && c5728b3.exists()) {
                AppMethodBeat.m2505o(91325);
                return true;
            }
            AppMethodBeat.m2505o(91325);
            return false;
        }
        AppMethodBeat.m2505o(91325);
        return false;
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        return cbO;
    }
}
