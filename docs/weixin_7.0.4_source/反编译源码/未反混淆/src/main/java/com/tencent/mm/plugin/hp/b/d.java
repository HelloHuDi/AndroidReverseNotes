package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.v;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.tinker.lib.e.a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d implements at {
    private final c<az> kXG = new c<az>() {
        {
            AppMethodBeat.i(90584);
            this.xxI = az.class.getName().hashCode();
            AppMethodBeat.o(90584);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(90585);
            az azVar = (az) bVar;
            if (d.this.ntC) {
                int i;
                Context context = ah.getContext();
                String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_after_install", "");
                com.tencent.tinker.lib.e.d dVar = a.iX(context).ABJ;
                String str = dVar == null ? "" : dVar.ABO;
                ab.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isAfterInstallDialogHaveShow currentVersion :%s tinkerVersion:%s", string, str);
                if (bo.isNullOrNil(string) || bo.isNullOrNil(str) || !(bo.isNullOrNil(string) || bo.isNullOrNil(str) || !string.equalsIgnoreCase(str))) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    str = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                    azVar.cuh.cui = true;
                    azVar.cuh.bzH = str;
                    if (!bo.isNullOrNil(str)) {
                        a.wV(2);
                    }
                    context = ah.getContext();
                    String string2 = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                    if (!TextUtils.isEmpty(string2)) {
                        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_after_install", string2).apply();
                    }
                }
                d.this.ntC = false;
            }
            AppMethodBeat.o(90585);
            return false;
        }
    };
    private boolean ntC = true;
    private final h ntD = new h();
    private final c<cq> ntE = new c<cq>() {
        {
            AppMethodBeat.i(90586);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(90586);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(90587);
            g.el(ah.getContext());
            com.tinkerboots.sdk.a.dWj().SG(g.em(ah.getContext()));
            AppMethodBeat.o(90587);
            return false;
        }
    };
    private final f ntF = new f();
    private final c<bi> ntG = new c<bi>() {
        {
            AppMethodBeat.i(90588);
            this.xxI = bi.class.getName().hashCode();
            AppMethodBeat.o(90588);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(90589);
            com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.hp.c.b(), 0);
            AppMethodBeat.o(90589);
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(90590);
        AppMethodBeat.o(90590);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(90591);
        com.tencent.mm.pluginsdk.cmd.b.a(new g(), "//tinker");
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("prconfignotify", this.ntD, true);
        com.tencent.mm.sdk.b.a.xxA.c(this.kXG);
        this.ntE.dnU();
        com.tencent.mm.sdk.b.a.xxA.c(this.ntF);
        com.tencent.mm.sdk.b.a.xxA.c(this.ntG);
        ab.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        g.el(ah.getContext());
        try {
            long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= 3600000) {
                ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", Integer.valueOf(Calendar.getInstance().get(11)));
                if (Calendar.getInstance().get(11) == 0) {
                    currentTimeMillis = (currentTimeMillis - (((long) g.em(ah.getContext())) * 3600000)) + (((long) new Random().nextInt(60)) * 60000);
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                    ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", Integer.valueOf(r4), Long.valueOf(currentTimeMillis), Long.valueOf(longValue));
                } else {
                    com.tinkerboots.sdk.a.dWj().rF(true);
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                    ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue));
                }
            } else {
                com.tinkerboots.sdk.a.dWj().rF(false);
                ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            f.iT(currentTimeMillis);
        } catch (Exception e) {
            ab.printErrStackTrace("Tinker.SubCoreHotpatch", e, "", new Object[0]);
        }
        v.a.cfp.BG();
        AppMethodBeat.o(90591);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(90592);
        com.tencent.mm.pluginsdk.cmd.b.N("//tinker");
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("prconfignotify", this.ntD, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.kXG);
        this.ntE.dead();
        com.tencent.mm.sdk.b.a.xxA.d(this.ntF);
        com.tencent.mm.sdk.b.a.xxA.d(this.ntG);
        ab.d("Tinker.SubCoreHotpatch", "onAccountRelease");
        AppMethodBeat.o(90592);
    }
}
