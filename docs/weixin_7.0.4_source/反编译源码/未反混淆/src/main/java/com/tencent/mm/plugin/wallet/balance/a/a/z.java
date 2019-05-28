package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import java.util.HashMap;
import java.util.Map;

public final class z {
    public static int tgb = 123;
    public static int tgc = 456;
    public int accountType;
    public String cAa;
    public b glt;
    private x tgd = null;
    public y tge = null;
    public WalletLqtSaveFetchUI tgf = null;
    public String tgg;
    public int tgh;
    public int tgi;
    public String tgj;
    public Bankcard tgk;
    public Map<String, String> tgl = new HashMap();

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$3 */
    class AnonymousClass3 implements a<Void, bmo> {
        final /* synthetic */ Bankcard tgn;

        AnonymousClass3(Bankcard bankcard) {
            this.tgn = bankcard;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45309);
            bmo bmo = (bmo) obj;
            ab.i("MicroMsg.LqtSaveFetchLogic", "doSaveLqt, prepayid: %s", bmo.wPy);
            z.this.tgl.put(bmo.wPy, z.this.tgg);
            z.a(z.this, bmo.wPy, this.tgn);
            AppMethodBeat.o(45309);
            return null;
        }
    }

    public z() {
        AppMethodBeat.i(45318);
        AppMethodBeat.o(45318);
    }

    public z(x xVar, y yVar, WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(45319);
        this.tgd = xVar;
        this.tge = yVar;
        this.tgf = walletLqtSaveFetchUI;
        AppMethodBeat.o(45319);
    }

    static /* synthetic */ void a(z zVar, String str, Bankcard bankcard) {
        String str2;
        int i;
        AppMethodBeat.i(45320);
        if (bankcard == null) {
            bankcard = zVar.tgk;
        }
        zVar.glt = f.dMj();
        zVar.glt.dMi();
        WalletLqtSaveFetchUI walletLqtSaveFetchUI = zVar.tgf;
        if (bankcard != null) {
            str2 = bankcard.field_bindSerial;
        } else {
            str2 = "";
        }
        String str3 = "";
        if (zVar.accountType == 0) {
            i = 45;
        } else {
            i = 52;
        }
        h.a(walletLqtSaveFetchUI, str2, str, str3, i, tgb);
        AppMethodBeat.o(45320);
    }
}
