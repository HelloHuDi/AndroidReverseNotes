package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.f.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class PatchProfile extends e {
    public static final String ceo = (ah.getPackageName() + ":patch");

    static {
        AppMethodBeat.i(15391);
        AppMethodBeat.o(15391);
    }

    public final void onCreate() {
        int intValue;
        AppMethodBeat.i(15390);
        long currentTimeMillis = System.currentTimeMillis();
        r rVar = new r(d.bo(this.app.getBaseContext()));
        rVar.jE("PATCH");
        try {
            intValue = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.Lw(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e) {
            ab.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = rVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bo.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.eSg = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxk = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.vxm = String.valueOf(string);
                b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eSg).append(" ").append(b.dnP());
            }
        } catch (Exception e2) {
            ab.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            intValue = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vxn).append(" new: ").append(intValue);
            com.tencent.mm.protocal.d.vxn = (long) intValue;
        } catch (Exception e3) {
            ab.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean a = bo.a(rVar.jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = bo.a(rVar.jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = bo.a(rVar.jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = bo.a(rVar.jF(".com.tencent.mm.debug.report.useraction"), false);
            c.a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e4) {
            ab.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        a.bk(ah.getContext());
        l.cT(ceo);
        q.Bz();
        ab.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
        ab.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(15390);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ceo;
    }
}
