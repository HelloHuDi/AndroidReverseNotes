package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import java.util.Map.Entry;

public class WalletBalancePrivacyUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private Dialog gnn;
    private CheckBoxPreference tqR;
    private WalletBalancePrivacyMMHeaderPreference tqS;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46214);
        super.onCreate(bundle);
        dyb();
        initView();
        AppMethodBeat.o(46214);
    }

    public void onResume() {
        AppMethodBeat.i(46215);
        super.onResume();
        g.RQ();
        g.RO().eJo.a(2635, (f) this);
        g.RQ();
        g.RO().eJo.a(2554, (f) this);
        AppMethodBeat.o(46215);
    }

    public final int JC() {
        return R.xml.co;
    }

    public final void initView() {
        AppMethodBeat.i(46217);
        setMMTitle("");
        xE(getResources().getColor(R.color.d4));
        setBackGroundColorResource(R.color.d4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46211);
                WalletBalancePrivacyUI.this.finish();
                AppMethodBeat.o(46211);
                return true;
            }
        });
        if (this.nDp != null) {
            int dimensionPixelSize = this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.g9);
            this.nDp.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.nDp.setBackgroundColor(getResources().getColor(R.color.d4));
        }
        this.ehK = this.yCw;
        if (this.ehK != null) {
            this.ehK.removeAll();
        }
        this.gnn = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
        g.RQ();
        g.RO().eJo.a(new com.tencent.mm.plugin.wallet.pwd.a.f(), 0);
        AppMethodBeat.o(46217);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(46218);
        ab.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        if (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.f) {
            if (i == 0 && i2 == 0) {
                boolean z2;
                ab.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
                com.tencent.mm.plugin.wallet.pwd.a.f fVar = (com.tencent.mm.plugin.wallet.pwd.a.f) mVar;
                if (this.ehK == null || fVar == null || fVar.cOm() == null || fVar.cOm().wRj == null) {
                    z2 = false;
                } else {
                    ab.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", fVar.cOm().wRj.xpB, fVar.cOm().wRj.title, fVar.cOm().wRj.xhW, fVar.cOm().wRj.xpC, Integer.valueOf(fVar.cOm().wRi));
                    this.ehK.addPreferencesFromResource(R.xml.co);
                    this.tqS = (WalletBalancePrivacyMMHeaderPreference) this.ehK.aqO("wallet_balance_privacy_header");
                    this.tqS.cIY = fVar.cOm().wRj.xpB;
                    this.tqS.title = fVar.cOm().wRj.title;
                    this.tqR = (CheckBoxPreference) this.ehK.aqO("wallet_banlance_privacy_cb");
                    this.tqR.yDf = false;
                    this.tqR.setTitle((CharSequence) fVar.cOm().wRj.xhW);
                    this.tqR.setSummary((CharSequence) fVar.cOm().wRj.xpC);
                    this.tqR.uOT = bo.gW(fVar.cOm().wRi, 1);
                    this.ehK.notifyDataSetChanged();
                    z2 = true;
                }
                if (this.gnn != null && this.gnn.isShowing()) {
                    this.gnn.dismiss();
                }
                if (!z2) {
                    h.a((Context) this, getString(R.string.fs6), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46212);
                            WalletBalancePrivacyUI.this.finish();
                            AppMethodBeat.o(46212);
                        }
                    });
                }
            } else {
                ab.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
                if (this.gnn != null && this.gnn.isShowing()) {
                    this.gnn.dismiss();
                }
                h.a((Context) this, getString(R.string.fs6), "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46213);
                        WalletBalancePrivacyUI.this.finish();
                        AppMethodBeat.o(46213);
                    }
                });
            }
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.h) {
            String str2;
            if (i == 0 && i2 == 0) {
                int i3 = ((com.tencent.mm.plugin.wallet.pwd.a.h) mVar).cOn().wRi;
                if (this.tqR == null) {
                    this.tqR = (CheckBoxPreference) this.ehK.aqO("wallet_banlance_privacy_cb");
                }
                str2 = "MicroMsg.WalletBalancePrivacyUI";
                String str3 = "success set balance privacy detail:%s switchState:%s";
                Object[] objArr = new Object[2];
                objArr[0] = this.tqR != null ? Boolean.valueOf(this.tqR.isChecked()) : BuildConfig.COMMAND;
                objArr[1] = Integer.valueOf(i3);
                ab.i(str2, str3, objArr);
                aj cRh = r.cPE().cRh();
                cRh.field_wallet_entrance_balance_switch_state = ((com.tencent.mm.plugin.wallet.pwd.a.h) mVar).cOn().wRi;
                r.cPE().b(cRh);
                r.cPI().tCV = new ai(cRh.field_switchConfig, cRh.field_wallet_entrance_balance_switch_state);
                if (this.tqR != null) {
                    CheckBoxPreference checkBoxPreference = this.tqR;
                    if (i3 != 1) {
                        z = false;
                    }
                    checkBoxPreference.qg(z);
                }
                AppMethodBeat.o(46218);
                return;
            }
            byh byh;
            t.makeText(this, getString(R.string.fs1), 1).show();
            if (this.tqR == null) {
                this.tqR.qg(!this.tqR.isChecked());
            }
            String str4 = "MicroMsg.WalletBalancePrivacyUI";
            str2 = "fail set balance privacy %s";
            Object[] objArr2 = new Object[1];
            com.tencent.mm.plugin.wallet.pwd.a.h hVar = (com.tencent.mm.plugin.wallet.pwd.a.h) mVar;
            if (hVar.tqz == null) {
                byh = new byh();
            } else {
                byh = hVar.tqz;
            }
            objArr2[0] = Integer.valueOf(byh.wXF);
            ab.i(str4, str2, objArr2);
        }
        AppMethodBeat.o(46218);
    }

    public void onDestroy() {
        AppMethodBeat.i(46219);
        super.onDestroy();
        if (this.tqS != null) {
            WalletBalancePrivacyMMHeaderPreference walletBalancePrivacyMMHeaderPreference = this.tqS;
            for (Entry entry : walletBalancePrivacyMMHeaderPreference.tqO.entrySet()) {
                o.aho().b((String) entry.getKey(), (a) entry.getValue());
            }
            walletBalancePrivacyMMHeaderPreference.tqO.clear();
        }
        g.RQ();
        g.RO().eJo.b(2635, (f) this);
        g.RQ();
        g.RO().eJo.b(2554, (f) this);
        AppMethodBeat.o(46219);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(46216);
        if (bo.isEqual(preference.mKey, "wallet_banlance_privacy_cb")) {
            ab.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", Boolean.valueOf(((CheckBoxPreference) preference).isChecked()));
            g.RQ();
            g.RO().eJo.a(new com.tencent.mm.plugin.wallet.pwd.a.h(((CheckBoxPreference) preference).isChecked()), 0);
        }
        AppMethodBeat.o(46216);
        return false;
    }
}
