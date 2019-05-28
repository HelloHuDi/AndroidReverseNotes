package com.tencent.p177mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42053rl;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.luckymoney.sns.p1487b.C34458a;
import com.tencent.p177mm.plugin.luckymoney.sns.p989a.C12435a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletPreferenceUI;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting */
public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected C15541f iFE;
    protected CheckBoxPreference obA;

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting$1 */
    class C284321 implements OnMenuItemClickListener {
        C284321() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42497);
            SnsLuckyMoneyFreePwdSetting.this.finish();
            AppMethodBeat.m2505o(42497);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: xU */
    private static void m67005xU(int i) {
        AppMethodBeat.m2504i(42498);
        C42053rl c42053rl = new C42053rl();
        c42053rl.cNu.key = i;
        c42053rl.cNu.value = 1;
        c42053rl.cNu.cNv = true;
        C4879a.xxA.mo10055m(c42053rl);
        AppMethodBeat.m2505o(42498);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42499);
        super.onCreate(bundle);
        initView();
        SnsLuckyMoneyFreePwdSetting.m67005xU(116);
        AppMethodBeat.m2505o(42499);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42501);
        bMg();
        super.onResume();
        AppMethodBeat.m2505o(42501);
    }

    private void bMg() {
        boolean z = true;
        AppMethodBeat.m2504i(42502);
        if (C34458a.bMi() != 1) {
            z = false;
        }
        this.obA.uOT = z;
        this.ehZ.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(C34458a.bMj())) {
            C4990ab.m7416i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.obA.setTitle((int) C25738R.string.cr1);
        } else {
            C4990ab.m7416i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + C34458a.bMj());
            this.obA.setTitle((CharSequence) C34458a.bMj());
        }
        if (TextUtils.isEmpty(C34458a.bMk())) {
            C4990ab.m7416i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.obA.setSummary((int) C25738R.string.cr0);
        } else {
            C4990ab.m7416i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + C34458a.bMk());
            this.obA.setSummary((CharSequence) C34458a.bMk());
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.m2505o(42502);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42504);
        super.onDestroy();
        AppMethodBeat.m2505o(42504);
    }

    /* renamed from: f */
    public final boolean mo24791f(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42505);
        if (c1207m instanceof C12435a) {
            C4990ab.m7416i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                SnsLuckyMoneyFreePwdSetting.m67005xU(C31128d.MIC_AVROUND_BLUR);
                C4990ab.m7416i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                bMg();
            } else if (((C12435a) c1207m).obS == 1) {
                C4990ab.m7416i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                SnsLuckyMoneyFreePwdSetting.m67005xU(C31128d.MIC_AVROUND_BLUR);
                m67004iI(true);
            } else {
                m67004iI(false);
                SnsLuckyMoneyFreePwdSetting.m67005xU(118);
                C4990ab.m7416i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        AppMethodBeat.m2505o(42505);
        return false;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8565cd;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(42506);
        if ("open_sns_pay_pref".equals(preference.mKey)) {
            if (this.obA.isChecked() || C34458a.bMi() != 1) {
                SnsLuckyMoneyFreePwdSetting.m67005xU(120);
                C24143a.m37106a((Activity) this, C41292a.class, null, null);
            } else {
                dOM().mo49367a(new C12435a(0, "", ""), true, 1);
                SnsLuckyMoneyFreePwdSetting.m67005xU(C31128d.MIC_ALPHA_ADJUST_REAL);
            }
        }
        AppMethodBeat.m2505o(42506);
        return false;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(42507);
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(42507);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42500);
        this.iFE = this.yCw;
        setBackBtn(new C284321());
        setMMTitle((int) C25738R.string.cr4);
        this.obA = (CheckBoxPreference) this.iFE.aqO("open_sns_pay_pref");
        bMg();
        AppMethodBeat.m2505o(42500);
    }

    /* renamed from: iI */
    private void m67004iI(boolean z) {
        AppMethodBeat.m2504i(42503);
        this.ehZ.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.obA.uOT = z;
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.m2505o(42503);
    }
}
