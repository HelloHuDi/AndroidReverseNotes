package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class c implements at, b {
    private com.tencent.mm.sdk.b.c ecA = new com.tencent.mm.sdk.b.c<hv>() {
        {
            AppMethodBeat.i(25201);
            this.xxI = hv.class.getName().hashCode();
            AppMethodBeat.o(25201);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25202);
            hv hvVar = (hv) bVar;
            if (hvVar != null && (hvVar instanceof hv)) {
                hvVar.cCO.url = c.this.cDA();
            }
            AppMethodBeat.o(25202);
            return false;
        }
    };
    private a ssE = null;
    private b ssF = null;
    Map<String, Integer> ssG = new HashMap();

    public final /* synthetic */ a cDB() {
        AppMethodBeat.i(25219);
        b cDw = cDw();
        AppMethodBeat.o(25219);
        return cDw;
    }

    public c() {
        AppMethodBeat.i(25204);
        ab.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bo.dpG());
        AppMethodBeat.o(25204);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(25206);
        ab.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.ssE == null) {
            this.ssE = new a();
        }
        aw.getSysCmdMsgExtension().a("jd", this.ssE, true);
        com.tencent.mm.sdk.b.a.xxA.c(this.ecA);
        AppMethodBeat.o(25206);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(25207);
        ab.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.ssE != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.ssE.ssn);
            aw.getSysCmdMsgExtension().b("jd", this.ssE, true);
        }
        this.ssG.clear();
        this.ssE = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.ecA);
        AppMethodBeat.o(25207);
    }

    public final boolean cDs() {
        AppMethodBeat.i(25208);
        aw.ZK();
        boolean equals = "1".equals((String) com.tencent.mm.model.c.Ry().get(327939, (Object) ""));
        AppMethodBeat.o(25208);
        return equals;
    }

    public final boolean cDt() {
        AppMethodBeat.i(25209);
        aw.ZK();
        boolean equals = "1".equals((String) com.tencent.mm.model.c.Ry().get(327938, (Object) ""));
        AppMethodBeat.o(25209);
        return equals;
    }

    public final void cDu() {
        AppMethodBeat.i(25210);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(327938, (Object) "");
        AppMethodBeat.o(25210);
    }

    public final void cDv() {
        AppMethodBeat.i(25211);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(327939, (Object) "");
        AppMethodBeat.o(25211);
    }

    public final b cDw() {
        AppMethodBeat.i(25212);
        if (this.ssF == null) {
            this.ssF = b.cDj();
        }
        b bVar = this.ssF;
        AppMethodBeat.o(25212);
        return bVar;
    }

    public static void b(b bVar) {
        AppMethodBeat.i(25213);
        g.RN().QU();
        c cDr = cDr();
        if (cDr.ssF == null) {
            cDr.ssF = b.cDj();
        }
        ab.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", cDr.ssF.SY(), bVar.SY());
        if (bVar.a(cDr.ssF)) {
            if (!bo.isNullOrNil(bVar.ssu) || bVar.sst) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(327939, (Object) "1");
            }
            if (bVar.sss) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(327938, (Object) "1");
            } else {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(327938, (Object) "");
            }
            cDr.ssF = bVar;
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(327942, bVar.cJh);
            cDr.cDx();
            AppMethodBeat.o(25213);
            return;
        }
        ab.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
        AppMethodBeat.o(25213);
    }

    private void cDx() {
        AppMethodBeat.i(25214);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25203);
                com.tencent.mm.sdk.b.a.xxA.m(new iw());
                AppMethodBeat.o(25203);
            }
        });
        AppMethodBeat.o(25214);
    }

    public final void cDy() {
        AppMethodBeat.i(25215);
        if (aw.RK() && (cDr().cDs() || cDr().cDt())) {
            b cDw = cDr().cDw();
            if ((!bo.isNullOrNil(cDw.ssu) || cDw.sst) && cDw.bxX()) {
                ab.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                cDr().cDu();
                cDr().cDv();
                cDr().cDx();
            }
        }
        AppMethodBeat.o(25215);
    }

    public static String dn(String str, int i) {
        AppMethodBeat.i(25216);
        if (-1 == str.indexOf(35)) {
            if (-1 == str.indexOf(63)) {
                str = str + "?wc_scene=" + i;
            } else {
                str = str + "&wc_scene=" + i;
            }
        }
        AppMethodBeat.o(25216);
        return str;
    }

    public static boolean cDz() {
        AppMethodBeat.i(25217);
        String value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigName");
        String value2 = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigIconUrl");
        String value3 = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigJumpUrl");
        if (bo.isNullOrNil(value) || bo.isNullOrNil(value2) || bo.isNullOrNil(value3)) {
            AppMethodBeat.o(25217);
            return false;
        }
        AppMethodBeat.o(25217);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String cDA() {
        int i = 1;
        AppMethodBeat.i(25218);
        String value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigJumpUrl");
        if (bo.isNullOrNil(value)) {
            AppMethodBeat.o(25218);
            return null;
        }
        int i2;
        int i3;
        String dn;
        b cDw = cDw();
        if (cDs()) {
            if (!cDw.bxX() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(cDw.ssq) && !bo.isNullOrNil(cDw.jumpUrl)) {
                ab.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", cDw.jumpUrl);
                value = cDw.jumpUrl;
                i2 = 6;
                if (cDw.ssw < System.currentTimeMillis() / 1000) {
                }
                if (i3 != 0) {
                }
                dn = dn(value, i2);
                AppMethodBeat.o(25218);
                return dn;
            } else if (cDw.sst) {
                i2 = 2;
                if ("2".equals(cDw.ssq) && !bo.isNullOrNil(cDw.jumpUrl)) {
                    if (cDw.ssw < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (cDw.ssx == 0 || cDw.ssx >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = cDw.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                dn = dn(value, i2);
                AppMethodBeat.o(25218);
                return dn;
            }
        }
        i2 = 1;
        if (cDw.ssw < System.currentTimeMillis() / 1000) {
        }
        if (i3 != 0) {
        }
        dn = dn(value, i2);
        AppMethodBeat.o(25218);
        return dn;
    }

    public static c cDr() {
        AppMethodBeat.i(25205);
        c cVar = (c) f.vdy;
        if (cVar == null) {
            cVar = new c();
            f.vdy = cVar;
        }
        AppMethodBeat.o(25205);
        return cVar;
    }
}
