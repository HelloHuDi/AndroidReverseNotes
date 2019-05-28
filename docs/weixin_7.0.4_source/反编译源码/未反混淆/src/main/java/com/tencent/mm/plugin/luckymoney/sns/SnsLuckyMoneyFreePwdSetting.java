package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.view.d;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f iFE;
    protected CheckBoxPreference obA;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    private static void xU(int i) {
        AppMethodBeat.i(42498);
        rl rlVar = new rl();
        rlVar.cNu.key = i;
        rlVar.cNu.value = 1;
        rlVar.cNu.cNv = true;
        a.xxA.m(rlVar);
        AppMethodBeat.o(42498);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42499);
        super.onCreate(bundle);
        initView();
        xU(116);
        AppMethodBeat.o(42499);
    }

    public void onResume() {
        AppMethodBeat.i(42501);
        bMg();
        super.onResume();
        AppMethodBeat.o(42501);
    }

    private void bMg() {
        boolean z = true;
        AppMethodBeat.i(42502);
        if (com.tencent.mm.plugin.luckymoney.sns.b.a.bMi() != 1) {
            z = false;
        }
        this.obA.uOT = z;
        this.ehZ.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bMj())) {
            ab.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.obA.setTitle((int) R.string.cr1);
        } else {
            ab.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bMj());
            this.obA.setTitle((CharSequence) com.tencent.mm.plugin.luckymoney.sns.b.a.bMj());
        }
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bMk())) {
            ab.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.obA.setSummary((int) R.string.cr0);
        } else {
            ab.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bMk());
            this.obA.setSummary((CharSequence) com.tencent.mm.plugin.luckymoney.sns.b.a.bMk());
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.o(42502);
    }

    public void onDestroy() {
        AppMethodBeat.i(42504);
        super.onDestroy();
        AppMethodBeat.o(42504);
    }

    public final boolean f(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42505);
        if (mVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
            ab.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                xU(d.MIC_AVROUND_BLUR);
                ab.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                bMg();
            } else if (((com.tencent.mm.plugin.luckymoney.sns.a.a) mVar).obS == 1) {
                ab.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                xU(d.MIC_AVROUND_BLUR);
                iI(true);
            } else {
                iI(false);
                xU(118);
                ab.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        AppMethodBeat.o(42505);
        return false;
    }

    public final int JC() {
        return R.xml.cd;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(42506);
        if ("open_sns_pay_pref".equals(preference.mKey)) {
            if (this.obA.isChecked() || com.tencent.mm.plugin.luckymoney.sns.b.a.bMi() != 1) {
                xU(120);
                com.tencent.mm.wallet_core.a.a((Activity) this, a.class, null, null);
            } else {
                dOM().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
                xU(d.MIC_ALPHA_ADJUST_REAL);
            }
        }
        AppMethodBeat.o(42506);
        return false;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(42507);
        super.onNewIntent(intent);
        AppMethodBeat.o(42507);
    }

    public final void initView() {
        AppMethodBeat.i(42500);
        this.iFE = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42497);
                SnsLuckyMoneyFreePwdSetting.this.finish();
                AppMethodBeat.o(42497);
                return false;
            }
        });
        setMMTitle((int) R.string.cr4);
        this.obA = (CheckBoxPreference) this.iFE.aqO("open_sns_pay_pref");
        bMg();
        AppMethodBeat.o(42500);
    }

    private void iI(boolean z) {
        AppMethodBeat.i(42503);
        this.ehZ.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.obA.uOT = z;
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.o(42503);
    }
}
