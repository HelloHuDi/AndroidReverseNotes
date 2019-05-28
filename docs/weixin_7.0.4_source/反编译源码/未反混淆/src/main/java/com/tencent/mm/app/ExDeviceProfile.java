package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class ExDeviceProfile extends e {
    public static final String ceo = (ah.getPackageName() + ":exdevice");

    static {
        AppMethodBeat.i(15379);
        AppMethodBeat.o(15379);
    }

    public final void onCreate() {
        AppMethodBeat.i(15377);
        ab.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        d bo = d.bo(this.app.getBaseContext());
        a.bk(ah.getContext());
        l.cT(ceo);
        q qVar = new q(bo);
        qVar.jE("EXDEVICE");
        ae.ghN = bo.a(qVar.jF(".com.tencent.mm.debug.test.display_errcode"), false);
        ae.ghO = bo.a(qVar.jF(".com.tencent.mm.debug.test.display_msgstate"), false);
        ae.ghP = bo.a(qVar.jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ae.ghQ = bo.a(qVar.jF(".com.tencent.mm.debug.test.network.force_touch"), false);
        ae.ghR = bo.a(qVar.jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ae.ghS = bo.a(qVar.jF(".com.tencent.mm.debug.test.crashIsExit"), false);
        ae.ghW = bo.a(qVar.jF(".com.tencent.mm.debug.test.album_show_info"), false);
        ae.ghX = bo.a(qVar.jF(".com.tencent.mm.debug.test.location_help"), false);
        ae.gia = bo.a(qVar.jF(".com.tencent.mm.debug.test.force_soso"), false);
        ae.gib = bo.a(qVar.jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ae.gic = bo.a(qVar.jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ae.gid = bo.a(qVar.jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ae.gig = bo.a(qVar.jF(".com.tencent.mm.debug.test.filterfpnp"), false);
        ae.gih = bo.a(qVar.jF(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bo.a(qVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ae.gie = a;
        if (a != 4 && ae.gie > 0) {
            com.tencent.mm.storage.ab.xIC = ae.gie;
            ab.e("MicroMsg.ExdDebugger", "cdn thread num " + ae.gie);
        }
        ae.gif = bo.a(qVar.jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(qVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.Lw(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            ab.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = qVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bo.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.eSg = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxk = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxm = String.valueOf(string);
                b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eSg).append(" ").append(b.dnP());
            }
        } catch (Exception e2) {
            ab.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(qVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vxn).append(" new: ").append(a);
            com.tencent.mm.protocal.d.vxn = (long) a;
        } catch (Exception e3) {
            ab.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bo.a(qVar.jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bo.a(qVar.jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bo.a(qVar.jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bo.a(qVar.jF(".com.tencent.mm.debug.report.useraction"), false);
            c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e4) {
            ab.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        ae.giu = bo.bc(qVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        ab.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ae.giu);
        ae.giv = bo.bc(qVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        ab.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ae.giv);
        ae.giw = bo.a(qVar.jF(".com.tencent.mm.debug.skiploadurlcheck"), false);
        ab.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ae.giw);
        q.Bz();
        AppMethodBeat.o(15377);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(15378);
        ab.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
        AppMethodBeat.o(15378);
    }

    public String toString() {
        return ceo;
    }
}
