package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(42491);
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.o(42491);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(42492);
        b(activity, bundle);
        AppMethodBeat.o(42492);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(42493);
        b(activity, null);
        AppMethodBeat.o(42493);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(42494);
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
        AppMethodBeat.o(42494);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "LuckyFreePwdProcess";
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(42495);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(42489);
                    if (mVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
                        ab.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
                        if (i == 0 && i2 == 0) {
                            h.bQ(this.hwd, this.hwd.getString(R.string.cs_));
                            a.xT(121);
                            a.this.mqu.putBoolean("is_open_sns_pay", true);
                            a.this.a(this.hwd, 0, a.this.mqu);
                        } else {
                            h.bQ(this.hwd, this.hwd.getString(R.string.cs9));
                            a.xT(122);
                            a.this.c(this.hwd, 0);
                        }
                        AppMethodBeat.o(42489);
                        return true;
                    }
                    AppMethodBeat.o(42489);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(42490);
                    this.Agm.a(new com.tencent.mm.plugin.luckymoney.sns.a.a(1, (String) objArr[0], ""), true, 1);
                    AppMethodBeat.o(42490);
                    return true;
                }
            };
            AppMethodBeat.o(42495);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(42495);
        return a;
    }

    static /* synthetic */ void xT(int i) {
        AppMethodBeat.i(42496);
        rl rlVar = new rl();
        rlVar.cNu.key = i;
        rlVar.cNu.value = 1;
        rlVar.cNu.cNv = true;
        com.tencent.mm.sdk.b.a.xxA.m(rlVar);
        AppMethodBeat.o(42496);
    }
}
