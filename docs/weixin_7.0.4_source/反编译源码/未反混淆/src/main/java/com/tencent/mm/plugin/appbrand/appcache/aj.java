package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public enum aj {
    ;

    public enum a {
        public static final a gTL = null;
        public static final a gTM = null;
        public static final a gTN = null;
        private static final /* synthetic */ a[] gTO = null;

        private a(String str, int i) {
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(129415);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(129415);
            return aVar;
        }

        public static a[] values() {
            AppMethodBeat.i(129414);
            a[] aVarArr = (a[]) gTO.clone();
            AppMethodBeat.o(129414);
            return aVarArr;
        }

        static {
            AppMethodBeat.i(129416);
            gTL = new a("CGI", 0);
            gTM = new a("NewXml", 1);
            gTN = new a("Launch", 2);
            gTO = new a[]{gTL, gTM, gTN};
            AppMethodBeat.o(129416);
        }
    }

    public static void dC(final boolean z) {
        AppMethodBeat.i(129419);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129412);
                if (z) {
                    ab.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, Long.valueOf(bo.anT() - 1));
                }
                aj.access$000();
                AppMethodBeat.o(129412);
            }
        }, "WxaCommLibVersionChecker");
        AppMethodBeat.o(129419);
    }

    private static void a(int i, cwk cwk, a aVar) {
        AppMethodBeat.i(129420);
        if (f.auV() != null) {
            PInt pInt = new PInt();
            f.auV().a(cwk, pInt);
            boolean z = f.auV().au("@LibraryAppId", 0) == cwk.version ? as.p(true, true).first == com.tencent.mm.plugin.appbrand.appcache.as.a.gUM : false;
            ab.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(cwk.version), Integer.valueOf(cwk.wPu), cwk.cvZ, cwk.url);
            if (z) {
                if (i <= 0 || bo.isNullOrNil(cwk.cDL)) {
                    t.gTk.E(-1, null);
                } else {
                    t.gTk.E(i, cwk.cDL);
                }
                t.gTk.dy(true);
                aa aaVar = new aa();
                aaVar.field_key = "@LibraryAppId";
                aaVar.field_version = cwk.version;
                if (!f.ava().b((c) aaVar, "key", "version")) {
                    aaVar.field_updateTime = bo.anT();
                    aaVar.field_scene = aVar.ordinal() + 1;
                    f.ava().b((c) aaVar);
                }
            }
            if (cwk.wPu > 0 && pInt.value > 0) {
                h.pN(2);
            }
            AppMethodBeat.o(129420);
            return;
        }
        ab.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
        AppMethodBeat.o(129420);
    }

    public static void a(int i, bmm bmm) {
        AppMethodBeat.i(129421);
        if (bmm != null) {
            cwk cwk = new cwk();
            cwk.url = bmm.url;
            cwk.cvZ = bmm.cvZ;
            cwk.version = bmm.version;
            cwk.wPu = bmm.wPu;
            cwk.xsd = bmm.wPt ? 1 : 0;
            cwk.cDL = bmm.cDL;
            a(i, cwk, a.gTN);
        }
        AppMethodBeat.o(129421);
    }

    public static void a(cwk cwk) {
        AppMethodBeat.i(129422);
        a(-1, cwk, a.gTM);
        AppMethodBeat.o(129422);
    }
}
