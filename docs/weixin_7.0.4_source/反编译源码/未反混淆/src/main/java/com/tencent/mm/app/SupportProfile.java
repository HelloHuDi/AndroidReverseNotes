package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile extends e {
    protected static String bWa = "";

    public final void onCreate() {
        AppMethodBeat.i(15401);
        bWa = ah.getProcessName();
        ClassLoader classLoader = SupportProfile.class.getClassLoader();
        a.bk(ah.getContext());
        l.a(new c() {
            public final void b(String str, Throwable th) {
                AppMethodBeat.i(15400);
                h.pYm.a(637, 0, 1, false);
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.o(15400);
            }
        });
        t tVar = new t(d.bo(this.app.getBaseContext()));
        tVar.jE("SUPPORT");
        ae.ghN = bo.a(tVar.jF(".com.tencent.mm.debug.test.display_errcode"), false);
        ae.ghO = bo.a(tVar.jF(".com.tencent.mm.debug.test.display_msgstate"), false);
        ae.ghP = bo.a(tVar.jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ae.ghQ = bo.a(tVar.jF(".com.tencent.mm.debug.test.network.force_touch"), false);
        ae.ghR = bo.a(tVar.jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ae.ghS = bo.a(tVar.jF(".com.tencent.mm.debug.test.crashIsExit"), false);
        ae.ghW = bo.a(tVar.jF(".com.tencent.mm.debug.test.album_show_info"), false);
        ae.ghX = bo.a(tVar.jF(".com.tencent.mm.debug.test.location_help"), false);
        ae.gia = bo.a(tVar.jF(".com.tencent.mm.debug.test.force_soso"), false);
        ae.gib = bo.a(tVar.jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ae.gic = bo.a(tVar.jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ae.gid = bo.a(tVar.jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ae.gig = bo.a(tVar.jF(".com.tencent.mm.debug.test.filterfpnp"), false);
        ae.gih = bo.a(tVar.jF(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bo.a(tVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ae.gie = a;
        if (a != 4 && ae.gie > 0) {
            ab.xIC = ae.gie;
            com.tencent.mm.sdk.platformtools.ab.e("SetupSupportDebugger", "cdn thread num " + ae.gie);
        }
        ae.gif = bo.a(tVar.jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        ae.gix = bo.a(tVar.jF(".com.tencent.mm.debug.forcex5webview"), false);
        ae.giu = bo.bc(tVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        com.tencent.mm.sdk.platformtools.ab.d("SetupSupportDebugger", "Test.jsapiPermission = " + ae.giu);
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.Lw(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bo.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.eSg = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxk = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxm = String.valueOf(string);
                b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eSg).append(" ").append(b.dnP());
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.ab.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vxn).append(" new: ").append(a);
            com.tencent.mm.protocal.d.vxn = (long) a;
        } catch (Exception e3) {
            com.tencent.mm.sdk.platformtools.ab.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            tVar.ecL.ebO = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            com.tencent.mm.sdk.platformtools.ab.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bo.a(tVar.jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bo.a(tVar.jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bo.a(tVar.jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bo.a(tVar.jF(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            com.tencent.mm.sdk.platformtools.ab.i("SetupSupportDebugger", "no debugger was got");
        }
        l.cT(bWa);
        a.cP(bWa);
        k.a("wcdb", classLoader);
        k.a("commonimgdec", classLoader);
        k.a("wechatcommon", classLoader);
        k.a(com.tencent.mm.sdk.a.xxo, classLoader);
        k.a("FFmpeg", classLoader);
        k.a("wechatpack", classLoader);
        int Lw = m.Lw();
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", Integer.valueOf(Lw >> 12));
            k.a("wechatsight_v7a", classLoader);
            if ((Lw >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.qwW = 3;
                com.tencent.mm.plugin.sight.base.b.qwY = 3;
                com.tencent.mm.plugin.sight.base.b.qwZ = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.qwW = 1;
                com.tencent.mm.plugin.sight.base.b.qwY = 1;
                com.tencent.mm.plugin.sight.base.b.qwZ = 640000;
            }
        } else {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SupportProfile", "load wechatsight");
            k.a("wechatsight", classLoader);
            Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
            com.tencent.mm.plugin.sight.base.b.qwW = 1;
            com.tencent.mm.plugin.sight.base.b.qwY = 1;
            com.tencent.mm.plugin.sight.base.b.qwZ = 640000;
        }
        a.bk(ah.getContext());
        q.Bz();
        MMActivity.initLanguage(this.app.getBaseContext());
        AppMethodBeat.o(15401);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        AppMethodBeat.i(15402);
        super.onTrimMemory(i);
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", Integer.valueOf(i));
        AppMethodBeat.o(15402);
    }
}
