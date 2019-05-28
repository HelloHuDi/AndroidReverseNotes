package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.g */
public final class C39321g {
    private static String nWB = null;
    private static C4884c<C32519bf> nWC = new C393201();

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.g$1 */
    static class C393201 extends C4884c<C32519bf> {
        C393201() {
            AppMethodBeat.m2504i(42278);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(42278);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(42279);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus != null && c32519bf.cus.cut == 53) {
                C4990ab.m7417i("MicroMsg.LuckMoneyEffectResourceMgr", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(c32519bf.cus.cut), Integer.valueOf(c32519bf.cus.cuu), c32519bf.cus.filePath);
                if (!C5046bo.isNullOrNil(c32519bf.cus.filePath) && C5730e.m8628ct(c32519bf.cus.filePath)) {
                    C39321g.m66997Y(c32519bf.cus.filePath, c32519bf.cus.cut, c32519bf.cus.cuu);
                }
            }
            AppMethodBeat.m2505o(42279);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(42285);
        AppMethodBeat.m2505o(42285);
    }

    public static void aon() {
        AppMethodBeat.m2504i(42281);
        C4990ab.m7416i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
        C4879a.xxA.mo10053d(nWC);
        AppMethodBeat.m2505o(42281);
    }

    public static void bLs() {
        AppMethodBeat.m2504i(42282);
        File file = new File(C1761b.eSn + "wallet/luckyMoneyEffect/");
        C4990ab.m7410d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
        if (file.isDirectory() && file.exists()) {
            C4990ab.m7417i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", Boolean.valueOf(C5730e.m8618N(file.getPath(), true)));
        }
        AppMethodBeat.m2505o(42282);
    }

    /* renamed from: Y */
    static /* synthetic */ void m66997Y(final String str, final int i, final int i2) {
        AppMethodBeat.m2504i(42283);
        C4990ab.m7417i("MicroMsg.LuckMoneyEffectResourceMgr", "start saveEffectResource %s %s %s", str, Integer.valueOf(i), Integer.valueOf(i2));
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(42280);
                C39321g.m66998Z(str, i, i2);
                AppMethodBeat.m2505o(42280);
            }
        }, "LuckMoneyEffectResourceMgr_saveEffectResource");
        AppMethodBeat.m2505o(42283);
    }

    /* renamed from: Z */
    static /* synthetic */ void m66998Z(String str, int i, int i2) {
        AppMethodBeat.m2504i(42284);
        try {
            long yz = C5046bo.m7588yz();
            C4990ab.m7417i("MicroMsg.LuckMoneyEffectResourceMgr", "on saveEffectResource: %s %s %s %s", str, Integer.valueOf(i), Integer.valueOf(i2), nWB + i2);
            C5730e.m8636iu(str, r2);
            C4990ab.m7417i("MicroMsg.LuckMoneyEffectResourceMgr", "saveEffectResource used %s", Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(42284);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "saveEffectResourceImpl error: %s", e.getMessage());
            AppMethodBeat.m2505o(42284);
        }
    }
}
