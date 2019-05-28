package com.tencent.mm.plugin.wallet.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class s implements at {
    private int cQG = 0;
    private int tnA = 0;
    private r tnB = new r();
    private y tnC = new y();
    private k tnD = new k();
    private b tnE = new b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(45848);
            int intValue;
            if (bo.g(obj, 0) == 339975) {
                g.RQ();
                intValue = ((Integer) g.RP().Ry().get(339975, Integer.valueOf(0))).intValue();
                if (intValue != s.this.tnA) {
                    an.dhQ().reset();
                    s.this.tnA = intValue;
                }
                AppMethodBeat.o(45848);
                return;
            }
            if (a.USERINFO_WALLET_REGION_TYPE_INT_SYNC.equals(obj)) {
                g.RQ();
                intValue = ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue != s.this.cQG) {
                    an.dhQ().reset();
                    s.this.cQG = intValue;
                }
            }
            AppMethodBeat.o(45848);
        }
    };
    private c tnF = new c<uj>() {
        {
            AppMethodBeat.i(45849);
            this.xxI = uj.class.getName().hashCode();
            AppMethodBeat.o(45849);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(45850);
            com.tencent.mm.wallet_core.a.a((Activity) ((uj) bVar).cQB.context, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
            AppMethodBeat.o(45850);
            return false;
        }
    };
    private o tnG = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, e.a aVar) {
            AppMethodBeat.i(45851);
            if ("paymsg".equals(str) && PayuSecureEncrypt.ENCRYPT_VERSION_HASH.equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
                Object obj = (String) map.get(".sysmsg.paymsg.NewTagBankSerial");
                Object obj2 = (String) map.get(".sysmsg.paymsg.WalletRedDotWording");
                ab.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", Integer.valueOf(bo.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0)), Integer.valueOf(bo.getInt((String) map.get(".sysmsg.paymsg.BankCardRedDot"), 0)), obj);
                if (bo.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0) == 1) {
                    com.tencent.mm.x.c.PK().b(a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, true);
                } else {
                    com.tencent.mm.x.c.PK().b(a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, false);
                }
                if (r3 == 1) {
                    com.tencent.mm.x.c.PK().b(a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, true);
                } else {
                    com.tencent.mm.x.c.PK().b(a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, false);
                }
                if (!bo.isNullOrNil(obj2)) {
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, obj2);
                }
                if (!bo.isNullOrNil(obj)) {
                    g.RQ();
                    String str2 = (String) g.RP().Ry().get(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "");
                    if (!bo.isNullOrNil(str2)) {
                        obj = str2 + "," + obj;
                    }
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, obj);
                }
            }
            AppMethodBeat.o(45851);
        }
    };
    private l tnH = new l();

    static {
        AppMethodBeat.i(45859);
        com.tencent.mm.wallet_core.a.g("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        com.tencent.mm.wallet_core.a.g("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
        AppMethodBeat.o(45859);
    }

    public s() {
        AppMethodBeat.i(45852);
        File file = new File(com.tencent.mm.plugin.wallet_core.d.b.cRb());
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.o(45852);
    }

    public static s cNC() {
        AppMethodBeat.i(45853);
        s sVar = (s) q.Y(s.class);
        AppMethodBeat.o(45853);
        return sVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(45854);
        g.RQ();
        this.tnA = ((Integer) g.RP().Ry().get(339975, Integer.valueOf(0))).intValue();
        g.RQ();
        this.cQG = ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.tnG);
        com.tencent.mm.sdk.b.a.xxA.c(this.tnB);
        com.tencent.mm.sdk.b.a.xxA.c(this.tnC);
        com.tencent.mm.sdk.b.a.xxA.c(this.tnD);
        this.tnF.dnU();
        this.tnH.dnU();
        g.RQ();
        g.RP().Ry().a(this.tnE);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE);
        AppMethodBeat.o(45854);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(45855);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.tnG);
        com.tencent.mm.sdk.b.a.xxA.d(this.tnB);
        com.tencent.mm.sdk.b.a.xxA.d(this.tnC);
        com.tencent.mm.sdk.b.a.xxA.d(this.tnD);
        this.tnF.dead();
        this.tnH.dead();
        g.RQ();
        g.RP().Ry().b(this.tnE);
        AppMethodBeat.o(45855);
    }

    public static ak cND() {
        AppMethodBeat.i(45856);
        ak cPI = r.cPI();
        AppMethodBeat.o(45856);
        return cPI;
    }

    public static String agi() {
        AppMethodBeat.i(45857);
        g.RQ();
        String str = (String) g.RP().Ry().get(6, null);
        String Ps = av.Ps(str);
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(45857);
            return str;
        }
        str = str.substring(Ps.length() + 1);
        AppMethodBeat.o(45857);
        return str;
    }

    public static String cNE() {
        AppMethodBeat.i(45858);
        g.RQ();
        String str = (String) g.RP().Ry().get(6, null);
        if (bo.isNullOrNil(str)) {
            str = "";
        } else {
            str = av.Ps(str.replace("+", ""));
        }
        if (bo.isNullOrNil(str)) {
            if (com.tencent.mm.model.r.YM()) {
                str = "27";
            } else {
                str = "86";
            }
        }
        AppMethodBeat.o(45858);
        return str;
    }
}
