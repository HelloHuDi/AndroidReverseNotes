package com.tencent.p177mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C24656q;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C15430ab;

/* renamed from: com.tencent.mm.app.ExDeviceProfile */
public class ExDeviceProfile extends C1439e {
    public static final String ceo = (C4996ah.getPackageName() + ":exdevice");

    static {
        AppMethodBeat.m2504i(15379);
        AppMethodBeat.m2505o(15379);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(15377);
        C4990ab.m7416i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        C1326d bo = C1326d.m2839bo(this.app.getBaseContext());
        C1523a.m3164bk(C4996ah.getContext());
        C25794l.m41016cT(ceo);
        C24656q c24656q = new C24656q(bo);
        c24656q.mo33553jE("EXDEVICE");
        C1947ae.ghN = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.display_errcode"), false);
        C1947ae.ghO = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.display_msgstate"), false);
        C1947ae.ghP = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        C1947ae.ghQ = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.network.force_touch"), false);
        C1947ae.ghR = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        C1947ae.ghS = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.crashIsExit"), false);
        C1947ae.ghW = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.album_show_info"), false);
        C1947ae.ghX = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.location_help"), false);
        C1947ae.gia = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.force_soso"), false);
        C1947ae.gib = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        C1947ae.gic = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        C1947ae.gid = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        C1947ae.gig = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.filterfpnp"), false);
        C1947ae.gih = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.testForPull"), false);
        int a = C5046bo.m7512a(c24656q.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        C1947ae.gie = a;
        if (a != 4 && C1947ae.gie > 0) {
            C15430ab.xIC = C1947ae.gie;
            C4990ab.m7412e("MicroMsg.ExdDebugger", "cdn thread num " + C1947ae.gie);
        }
        C1947ae.gif = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(c24656q.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            C7243d.m12106Lw(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = c24656q.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!C5046bo.isNullOrNil(string)) {
                C7243d.eSg = "android-".concat(String.valueOf(string));
                C7243d.vxk = "android-".concat(String.valueOf(string));
                C7243d.vxm = String.valueOf(string);
                C4872b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(C7243d.eSg).append(" ").append(C4872b.dnP());
            }
        } catch (Exception e2) {
            C4990ab.m7416i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(c24656q.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(C7243d.vxn).append(" new: ").append(a);
            C7243d.vxn = (long) a;
        } catch (Exception e3) {
            C4990ab.m7416i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean a2 = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.report.useraction"), false);
            C3730c.m6036a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e4) {
            C4990ab.m7416i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        C1947ae.giu = C5046bo.m7532bc(c24656q.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        C4990ab.m7410d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + C1947ae.giu);
        C1947ae.giv = C5046bo.m7532bc(c24656q.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        C4990ab.m7410d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + C1947ae.giv);
        C1947ae.giw = C5046bo.m7517a(c24656q.mo33554jF(".com.tencent.mm.debug.skiploadurlcheck"), false);
        C4990ab.m7410d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + C1947ae.giw);
        C1266q.m2719Bz();
        AppMethodBeat.m2505o(15377);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(15378);
        C4990ab.m7410d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
        AppMethodBeat.m2505o(15378);
    }

    public String toString() {
        return ceo;
    }
}
