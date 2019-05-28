package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.bmm;
import com.tencent.p177mm.protocal.protobuf.cwj;
import com.tencent.p177mm.protocal.protobuf.cwk;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.TbsDownloadConfig;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.aj */
public enum C10068aj {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aj$a */
    public enum C10069a {
        public static final C10069a gTL = null;
        public static final C10069a gTM = null;
        public static final C10069a gTN = null;
        private static final /* synthetic */ C10069a[] gTO = null;

        private C10069a(String str, int i) {
        }

        public static C10069a valueOf(String str) {
            AppMethodBeat.m2504i(129415);
            C10069a c10069a = (C10069a) Enum.valueOf(C10069a.class, str);
            AppMethodBeat.m2505o(129415);
            return c10069a;
        }

        public static C10069a[] values() {
            AppMethodBeat.m2504i(129414);
            C10069a[] c10069aArr = (C10069a[]) gTO.clone();
            AppMethodBeat.m2505o(129414);
            return c10069aArr;
        }

        static {
            AppMethodBeat.m2504i(129416);
            gTL = new C10069a("CGI", 0);
            gTM = new C10069a("NewXml", 1);
            gTN = new C10069a("Launch", 2);
            gTO = new C10069a[]{gTL, gTM, gTN};
            AppMethodBeat.m2505o(129416);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.aj$2 */
    static class C100712 implements C1224a {
        C100712() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(129413);
            C7060h.pYm.mo8378a(368, 40, 1, false);
            if (C1720g.m3531RK()) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, Long.valueOf(TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + C5046bo.anT()));
            }
            if (i == 0 && i2 == 0) {
                try {
                    C10068aj.m17653b(((cwj) c7472b.fsG.fsP).version, (cwk) c7472b.fsH.fsP, C10069a.gTL);
                } catch (RuntimeException e) {
                    C4990ab.m7413e("MicroMsg.WxaCommLibVersionChecker", "onResp, e %s", e);
                }
                AppMethodBeat.m2505o(129413);
                return 0;
            }
            C4990ab.m7413e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(129413);
            return 0;
        }
    }

    /* renamed from: dC */
    public static void m17654dC(final boolean z) {
        AppMethodBeat.m2504i(129419);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(129412);
                if (z) {
                    C4990ab.m7416i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, Long.valueOf(C5046bo.anT() - 1));
                }
                C10068aj.access$000();
                AppMethodBeat.m2505o(129412);
            }
        }, "WxaCommLibVersionChecker");
        AppMethodBeat.m2505o(129419);
    }

    /* renamed from: a */
    private static void m17651a(int i, cwk cwk, C10069a c10069a) {
        AppMethodBeat.m2504i(129420);
        if (C42340f.auV() != null) {
            PInt pInt = new PInt();
            C42340f.auV().mo60845a(cwk, pInt);
            boolean z = C42340f.auV().mo60853au("@LibraryAppId", 0) == cwk.version ? C19035as.m29614p(true, true).first == C19036a.gUM : false;
            C4990ab.m7417i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(cwk.version), Integer.valueOf(cwk.wPu), cwk.cvZ, cwk.url);
            if (z) {
                if (i <= 0 || C5046bo.isNullOrNil(cwk.cDL)) {
                    C42360t.gTk.mo67865E(-1, null);
                } else {
                    C42360t.gTk.mo67865E(i, cwk.cDL);
                }
                C42360t.gTk.mo67866dy(true);
                C24683aa c24683aa = new C24683aa();
                c24683aa.field_key = "@LibraryAppId";
                c24683aa.field_version = cwk.version;
                if (!C42340f.ava().mo10102b((C4925c) c24683aa, "key", "version")) {
                    c24683aa.field_updateTime = C5046bo.anT();
                    c24683aa.field_scene = c10069a.ordinal() + 1;
                    C42340f.ava().mo10101b((C4925c) c24683aa);
                }
            }
            if (cwk.wPu > 0 && pInt.value > 0) {
                C45694h.m84430pN(2);
            }
            AppMethodBeat.m2505o(129420);
            return;
        }
        C4990ab.m7412e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
        AppMethodBeat.m2505o(129420);
    }

    /* renamed from: a */
    public static void m17650a(int i, bmm bmm) {
        AppMethodBeat.m2504i(129421);
        if (bmm != null) {
            cwk cwk = new cwk();
            cwk.url = bmm.url;
            cwk.cvZ = bmm.cvZ;
            cwk.version = bmm.version;
            cwk.wPu = bmm.wPu;
            cwk.xsd = bmm.wPt ? 1 : 0;
            cwk.cDL = bmm.cDL;
            C10068aj.m17651a(i, cwk, C10069a.gTN);
        }
        AppMethodBeat.m2505o(129421);
    }

    /* renamed from: a */
    public static void m17652a(cwk cwk) {
        AppMethodBeat.m2504i(129422);
        C10068aj.m17651a(-1, cwk, C10069a.gTM);
        AppMethodBeat.m2505o(129422);
    }
}
