package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class g {
    private static String nWB = null;
    private static c<bf> nWC = new c<bf>() {
        {
            AppMethodBeat.i(42278);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(42278);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(42279);
            bf bfVar = (bf) bVar;
            if (bfVar.cus != null && bfVar.cus.cut == 53) {
                ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(bfVar.cus.cut), Integer.valueOf(bfVar.cus.cuu), bfVar.cus.filePath);
                if (!bo.isNullOrNil(bfVar.cus.filePath) && e.ct(bfVar.cus.filePath)) {
                    g.Y(bfVar.cus.filePath, bfVar.cus.cut, bfVar.cus.cuu);
                }
            }
            AppMethodBeat.o(42279);
            return false;
        }
    };

    static {
        AppMethodBeat.i(42285);
        AppMethodBeat.o(42285);
    }

    public static void aon() {
        AppMethodBeat.i(42281);
        ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
        a.xxA.d(nWC);
        AppMethodBeat.o(42281);
    }

    public static void bLs() {
        AppMethodBeat.i(42282);
        File file = new File(com.tencent.mm.loader.j.b.eSn + "wallet/luckyMoneyEffect/");
        ab.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
        if (file.isDirectory() && file.exists()) {
            ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", Boolean.valueOf(e.N(file.getPath(), true)));
        }
        AppMethodBeat.o(42282);
    }

    static /* synthetic */ void Y(final String str, final int i, final int i2) {
        AppMethodBeat.i(42283);
        ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "start saveEffectResource %s %s %s", str, Integer.valueOf(i), Integer.valueOf(i2));
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(42280);
                g.Z(str, i, i2);
                AppMethodBeat.o(42280);
            }
        }, "LuckMoneyEffectResourceMgr_saveEffectResource");
        AppMethodBeat.o(42283);
    }

    static /* synthetic */ void Z(String str, int i, int i2) {
        AppMethodBeat.i(42284);
        try {
            long yz = bo.yz();
            ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "on saveEffectResource: %s %s %s %s", str, Integer.valueOf(i), Integer.valueOf(i2), nWB + i2);
            e.iu(str, r2);
            ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "saveEffectResource used %s", Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(42284);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "saveEffectResourceImpl error: %s", e.getMessage());
            AppMethodBeat.o(42284);
        }
    }
}
