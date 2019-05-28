package com.tencent.p177mm.plugin.wallet.p748a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18414uj;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.wallet.balance.C41322b;
import com.tencent.p177mm.plugin.wallet.pwd.C35452a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C35484y;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.pluginsdk.model.app.C46493an;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet.a.s */
public class C46332s implements C1816at {
    private int cQG = 0;
    private int tnA = 0;
    private C14102r tnB = new C14102r();
    private C35484y tnC = new C35484y();
    private C35393k tnD = new C35393k();
    private C4937b tnE = new C437561();
    private C4884c tnF = new C463312();
    private C3473o tnG = new C437573();
    private C35395l tnH = new C35395l();

    /* renamed from: com.tencent.mm.plugin.wallet.a.s$1 */
    class C437561 implements C4937b {
        C437561() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(45848);
            int intValue;
            if (C5046bo.m7550g(obj, 0) == 339975) {
                C1720g.m3537RQ();
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(339975, Integer.valueOf(0))).intValue();
                if (intValue != C46332s.this.tnA) {
                    C46493an.dhQ().reset();
                    C46332s.this.tnA = intValue;
                }
                AppMethodBeat.m2505o(45848);
                return;
            }
            if (C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC.equals(obj)) {
                C1720g.m3537RQ();
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue != C46332s.this.cQG) {
                    C46493an.dhQ().reset();
                    C46332s.this.cQG = intValue;
                }
            }
            AppMethodBeat.m2505o(45848);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.a.s$3 */
    class C437573 implements C3473o {
        C437573() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(45851);
            if ("paymsg".equals(str) && PayuSecureEncrypt.ENCRYPT_VERSION_HASH.equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
                Object obj = (String) map.get(".sysmsg.paymsg.NewTagBankSerial");
                Object obj2 = (String) map.get(".sysmsg.paymsg.WalletRedDotWording");
                C4990ab.m7417i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", Integer.valueOf(C5046bo.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0)), Integer.valueOf(C5046bo.getInt((String) map.get(".sysmsg.paymsg.BankCardRedDot"), 0)), obj);
                if (C5046bo.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0) == 1) {
                    C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, true);
                } else {
                    C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, false);
                }
                if (r3 == 1) {
                    C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, true);
                } else {
                    C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, false);
                }
                if (!C5046bo.isNullOrNil(obj2)) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, obj2);
                }
                if (!C5046bo.isNullOrNil(obj)) {
                    C1720g.m3537RQ();
                    String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "");
                    if (!C5046bo.isNullOrNil(str2)) {
                        obj = str2 + "," + obj;
                    }
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, obj);
                }
            }
            AppMethodBeat.m2505o(45851);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.a.s$2 */
    class C463312 extends C4884c<C18414uj> {
        C463312() {
            AppMethodBeat.m2504i(45849);
            this.xxI = C18414uj.class.getName().hashCode();
            AppMethodBeat.m2505o(45849);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(45850);
            C24143a.m37106a((Activity) ((C18414uj) c4883b).cQB.context, C41322b.class, null, null);
            AppMethodBeat.m2505o(45850);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(45859);
        C24143a.m37115g("ForgotPwdProcess", C35452a.class);
        C24143a.m37115g("BindCardProcess", C29615b.class);
        AppMethodBeat.m2505o(45859);
    }

    public C46332s() {
        AppMethodBeat.m2504i(45852);
        File file = new File(C46362b.cRb());
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.m2505o(45852);
    }

    public static C46332s cNC() {
        AppMethodBeat.m2504i(45853);
        C46332s c46332s = (C46332s) C7485q.m12925Y(C46332s.class);
        AppMethodBeat.m2505o(45853);
        return c46332s;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(45854);
        C1720g.m3537RQ();
        this.tnA = ((Integer) C1720g.m3536RP().mo5239Ry().get(339975, Integer.valueOf(0))).intValue();
        C1720g.m3537RQ();
        this.cQG = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("paymsg", this.tnG);
        C4879a.xxA.mo10052c(this.tnB);
        C4879a.xxA.mo10052c(this.tnC);
        C4879a.xxA.mo10052c(this.tnD);
        this.tnF.dnU();
        this.tnH.dnU();
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().mo10118a(this.tnE);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE);
        AppMethodBeat.m2505o(45854);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(45855);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("paymsg", this.tnG);
        C4879a.xxA.mo10053d(this.tnB);
        C4879a.xxA.mo10053d(this.tnC);
        C4879a.xxA.mo10053d(this.tnD);
        this.tnF.dead();
        this.tnH.dead();
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().mo10121b(this.tnE);
        AppMethodBeat.m2505o(45855);
    }

    public static C22587ak cND() {
        AppMethodBeat.m2504i(45856);
        C22587ak cPI = C14241r.cPI();
        AppMethodBeat.m2505o(45856);
        return cPI;
    }

    public static String agi() {
        AppMethodBeat.m2504i(45857);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        String Ps = C5025av.m7481Ps(str);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(45857);
            return str;
        }
        str = str.substring(Ps.length() + 1);
        AppMethodBeat.m2505o(45857);
        return str;
    }

    public static String cNE() {
        AppMethodBeat.m2504i(45858);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
        } else {
            str = C5025av.m7481Ps(str.replace("+", ""));
        }
        if (C5046bo.isNullOrNil(str)) {
            if (C1853r.m3831YM()) {
                str = "27";
            } else {
                str = "86";
            }
        }
        AppMethodBeat.m2505o(45858);
        return str;
    }
}
