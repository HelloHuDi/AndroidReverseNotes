package com.tencent.p177mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C24657r;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.app.PatchProfile */
public final class PatchProfile extends C1439e {
    public static final String ceo = (C4996ah.getPackageName() + ":patch");

    static {
        AppMethodBeat.m2504i(15391);
        AppMethodBeat.m2505o(15391);
    }

    public final void onCreate() {
        int intValue;
        AppMethodBeat.m2504i(15390);
        long currentTimeMillis = System.currentTimeMillis();
        C24657r c24657r = new C24657r(C1326d.m2839bo(this.app.getBaseContext()));
        c24657r.mo33553jE("PATCH");
        try {
            intValue = Integer.decode(c24657r.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            C7243d.m12106Lw(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = c24657r.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!C5046bo.isNullOrNil(string)) {
                C7243d.eSg = "android-".concat(String.valueOf(string));
                C7243d.vxk = "android-".concat(String.valueOf(string));
                C7243d.vxm = String.valueOf(string);
                C4872b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(C7243d.eSg).append(" ").append(C4872b.dnP());
            }
        } catch (Exception e2) {
            C4990ab.m7416i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            intValue = Integer.decode(c24657r.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(C7243d.vxn).append(" new: ").append(intValue);
            C7243d.vxn = (long) intValue;
        } catch (Exception e3) {
            C4990ab.m7416i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean a = C5046bo.m7517a(c24657r.mo33554jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = C5046bo.m7517a(c24657r.mo33554jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = C5046bo.m7517a(c24657r.mo33554jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = C5046bo.m7517a(c24657r.mo33554jF(".com.tencent.mm.debug.report.useraction"), false);
            C3730c.m6036a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e4) {
            C4990ab.m7416i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        C1523a.m3164bk(C4996ah.getContext());
        C25794l.m41016cT(ceo);
        C1266q.m2719Bz();
        C4990ab.m7416i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
        C4990ab.m7416i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(15390);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ceo;
    }
}
