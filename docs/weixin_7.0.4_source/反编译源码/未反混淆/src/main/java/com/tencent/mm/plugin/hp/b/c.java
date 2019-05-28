package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.sdk.g.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends com.tencent.mm.sdk.b.c<ip> implements d {
    private static final String eSG = (e.eSj + "_temp.hp");
    private a ntB;

    static {
        AppMethodBeat.i(90583);
        AppMethodBeat.o(90583);
    }

    public c() {
        AppMethodBeat.i(90578);
        this.ntB = null;
        this.xxI = ip.class.getName().hashCode();
        AppMethodBeat.o(90578);
    }

    public static void OF(String str) {
        AppMethodBeat.i(90579);
        ab.w("Tinker.HotPatchApplyService", "hp_apply from file %s", str);
        com.tencent.mm.plugin.hp.tinker.d.OG(str);
        AppMethodBeat.o(90579);
    }

    public final void a(Runnable runnable, int i) {
    }

    public final void b(Runnable runnable, int i) {
        AppMethodBeat.i(90580);
        if (runnable == this.ntB) {
            ab.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", this.ntB.url, this.ntB.ghD, Boolean.valueOf(this.ntB.aAR));
            if (this.ntB.aAR) {
                b.wY(1);
            } else {
                b.wX(1);
                OF(this.ntB.ghD);
            }
            this.ntB = null;
        }
        AppMethodBeat.o(90580);
    }

    private boolean a(ip ipVar) {
        AppMethodBeat.i(90581);
        if (this.ntB != null) {
            ab.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
            AppMethodBeat.o(90581);
        } else if (1 == ipVar.cDI.cuy) {
            com.tencent.mm.plugin.hp.tinker.d.bGr();
            AppMethodBeat.o(90581);
        } else if (ipVar.cDI.cDN != null) {
            OF(ipVar.cDI.cDN);
            AppMethodBeat.o(90581);
        } else {
            b.wW(1);
            if (ipVar.cDI.cDL != null) {
                try {
                    byte[] decode = Base64.decode(ipVar.cDI.cDL, 0);
                    ipVar.cDI.cDL = new String(decode);
                } catch (Error e) {
                }
            }
            if (!bo.isNullOrNil(ipVar.cDI.cDL) && !bo.isNullOrNil(ipVar.cDI.cDM)) {
                ab.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", ipVar.cDI.cDL, ipVar.cDI.cDM);
                this.ntB = new a(ipVar.cDI.cDL, eSG, ipVar.cDI.cDM);
            } else if (bo.isNullOrNil(ipVar.cDI.cDJ) || bo.isNullOrNil(ipVar.cDI.cDK)) {
                AppMethodBeat.o(90581);
            }
            com.tencent.mm.sdk.g.d.xDG.a(this.ntB, "hp_apply_download", this);
            AppMethodBeat.o(90581);
        }
        return false;
    }
}
