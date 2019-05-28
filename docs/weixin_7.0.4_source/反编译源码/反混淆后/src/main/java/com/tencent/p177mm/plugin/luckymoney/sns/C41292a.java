package com.tencent.p177mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42053rl;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.luckymoney.sns.p989a.C12435a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.luckymoney.sns.a */
public class C41292a extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(42491);
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.m2505o(42491);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(42492);
        mo8125b(activity, bundle);
        AppMethodBeat.m2505o(42492);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(42493);
        mo8125b(activity, null);
        AppMethodBeat.m2505o(42493);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(42494);
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        mo64564a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
        AppMethodBeat.m2505o(42494);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "LuckyFreePwdProcess";
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(42495);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C212121 c212121 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(42489);
                    if (c1207m instanceof C12435a) {
                        C4990ab.m7416i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
                        if (i == 0 && i2 == 0) {
                            C30379h.m48465bQ(this.hwd, this.hwd.getString(C25738R.string.cs_));
                            C41292a.m71923xT(121);
                            C41292a.this.mqu.putBoolean("is_open_sns_pay", true);
                            C41292a.this.mo8124a(this.hwd, 0, C41292a.this.mqu);
                        } else {
                            C30379h.m48465bQ(this.hwd, this.hwd.getString(C25738R.string.cs9));
                            C41292a.m71923xT(122);
                            C41292a.this.mo8127c(this.hwd, 0);
                        }
                        AppMethodBeat.m2505o(42489);
                        return true;
                    }
                    AppMethodBeat.m2505o(42489);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(42490);
                    this.Agm.mo49367a(new C12435a(1, (String) objArr[0], ""), true, 1);
                    AppMethodBeat.m2505o(42490);
                    return true;
                }
            };
            AppMethodBeat.m2505o(42495);
            return c212121;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(42495);
        return a;
    }

    /* renamed from: xT */
    static /* synthetic */ void m71923xT(int i) {
        AppMethodBeat.m2504i(42496);
        C42053rl c42053rl = new C42053rl();
        c42053rl.cNu.key = i;
        c42053rl.cNu.value = 1;
        c42053rl.cNu.cNv = true;
        C4879a.xxA.mo10055m(c42053rl);
        AppMethodBeat.m2505o(42496);
    }
}
