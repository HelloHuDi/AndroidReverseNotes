package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C32292p.C32293a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C14199h;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C35451f;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22586aj;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.protocal.protobuf.byh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI */
public class WalletBalancePrivacyUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private Dialog gnn;
    private CheckBoxPreference tqR;
    private WalletBalancePrivacyMMHeaderPreference tqS;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI$1 */
    class C142011 implements OnMenuItemClickListener {
        C142011() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46211);
            WalletBalancePrivacyUI.this.finish();
            AppMethodBeat.m2505o(46211);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI$3 */
    class C142023 implements OnClickListener {
        C142023() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46213);
            WalletBalancePrivacyUI.this.finish();
            AppMethodBeat.m2505o(46213);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI$2 */
    class C142032 implements OnClickListener {
        C142032() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46212);
            WalletBalancePrivacyUI.this.finish();
            AppMethodBeat.m2505o(46212);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46214);
        super.onCreate(bundle);
        dyb();
        initView();
        AppMethodBeat.m2505o(46214);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46215);
        super.onResume();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2635, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2554, (C1202f) this);
        AppMethodBeat.m2505o(46215);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8575co;
    }

    public final void initView() {
        AppMethodBeat.m2504i(46217);
        setMMTitle("");
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        setBackGroundColorResource(C25738R.color.f11677d4);
        setBackBtn(new C142011());
        if (this.nDp != null) {
            int dimensionPixelSize = this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.f9806g9);
            this.nDp.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.nDp.setBackgroundColor(getResources().getColor(C25738R.color.f11677d4));
        }
        this.ehK = this.yCw;
        if (this.ehK != null) {
            this.ehK.removeAll();
        }
        this.gnn = C30901g.m49318b(this, false, null);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C35451f(), 0);
        AppMethodBeat.m2505o(46217);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(46218);
        C4990ab.m7416i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        if (c1207m instanceof C35451f) {
            if (i == 0 && i2 == 0) {
                boolean z2;
                C4990ab.m7416i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
                C35451f c35451f = (C35451f) c1207m;
                if (this.ehK == null || c35451f == null || c35451f.cOm() == null || c35451f.cOm().wRj == null) {
                    z2 = false;
                } else {
                    C4990ab.m7417i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", c35451f.cOm().wRj.xpB, c35451f.cOm().wRj.title, c35451f.cOm().wRj.xhW, c35451f.cOm().wRj.xpC, Integer.valueOf(c35451f.cOm().wRi));
                    this.ehK.addPreferencesFromResource(C25738R.xml.f8575co);
                    this.tqS = (WalletBalancePrivacyMMHeaderPreference) this.ehK.aqO("wallet_balance_privacy_header");
                    this.tqS.cIY = c35451f.cOm().wRj.xpB;
                    this.tqS.title = c35451f.cOm().wRj.title;
                    this.tqR = (CheckBoxPreference) this.ehK.aqO("wallet_banlance_privacy_cb");
                    this.tqR.yDf = false;
                    this.tqR.setTitle((CharSequence) c35451f.cOm().wRj.xhW);
                    this.tqR.setSummary((CharSequence) c35451f.cOm().wRj.xpC);
                    this.tqR.uOT = C5046bo.m7563gW(c35451f.cOm().wRi, 1);
                    this.ehK.notifyDataSetChanged();
                    z2 = true;
                }
                if (this.gnn != null && this.gnn.isShowing()) {
                    this.gnn.dismiss();
                }
                if (!z2) {
                    C30379h.m48448a((Context) this, getString(C25738R.string.fs6), "", false, new C142032());
                }
            } else {
                C4990ab.m7416i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
                if (this.gnn != null && this.gnn.isShowing()) {
                    this.gnn.dismiss();
                }
                C30379h.m48448a((Context) this, getString(C25738R.string.fs6), "", false, new C142023());
            }
        }
        if (c1207m instanceof C14199h) {
            String str2;
            if (i == 0 && i2 == 0) {
                int i3 = ((C14199h) c1207m).cOn().wRi;
                if (this.tqR == null) {
                    this.tqR = (CheckBoxPreference) this.ehK.aqO("wallet_banlance_privacy_cb");
                }
                str2 = "MicroMsg.WalletBalancePrivacyUI";
                String str3 = "success set balance privacy detail:%s switchState:%s";
                Object[] objArr = new Object[2];
                objArr[0] = this.tqR != null ? Boolean.valueOf(this.tqR.isChecked()) : BuildConfig.COMMAND;
                objArr[1] = Integer.valueOf(i3);
                C4990ab.m7417i(str2, str3, objArr);
                C22586aj cRh = C14241r.cPE().cRh();
                cRh.field_wallet_entrance_balance_switch_state = ((C14199h) c1207m).cOn().wRi;
                C14241r.cPE().mo38098b(cRh);
                C14241r.cPI().tCV = new C29629ai(cRh.field_switchConfig, cRh.field_wallet_entrance_balance_switch_state);
                if (this.tqR != null) {
                    CheckBoxPreference checkBoxPreference = this.tqR;
                    if (i3 != 1) {
                        z = false;
                    }
                    checkBoxPreference.mo74839qg(z);
                }
                AppMethodBeat.m2505o(46218);
                return;
            }
            byh byh;
            C23639t.makeText(this, getString(C25738R.string.fs1), 1).show();
            if (this.tqR == null) {
                this.tqR.mo74839qg(!this.tqR.isChecked());
            }
            String str4 = "MicroMsg.WalletBalancePrivacyUI";
            str2 = "fail set balance privacy %s";
            Object[] objArr2 = new Object[1];
            C14199h c14199h = (C14199h) c1207m;
            if (c14199h.tqz == null) {
                byh = new byh();
            } else {
                byh = c14199h.tqz;
            }
            objArr2[0] = Integer.valueOf(byh.wXF);
            C4990ab.m7417i(str4, str2, objArr2);
        }
        AppMethodBeat.m2505o(46218);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46219);
        super.onDestroy();
        if (this.tqS != null) {
            WalletBalancePrivacyMMHeaderPreference walletBalancePrivacyMMHeaderPreference = this.tqS;
            for (Entry entry : walletBalancePrivacyMMHeaderPreference.tqO.entrySet()) {
                C32291o.aho().mo53005b((String) entry.getKey(), (C32293a) entry.getValue());
            }
            walletBalancePrivacyMMHeaderPreference.tqO.clear();
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2635, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2554, (C1202f) this);
        AppMethodBeat.m2505o(46219);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(46216);
        if (C5046bo.isEqual(preference.mKey, "wallet_banlance_privacy_cb")) {
            C4990ab.m7417i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", Boolean.valueOf(((CheckBoxPreference) preference).isChecked()));
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C14199h(((CheckBoxPreference) preference).isChecked()), 0);
        }
        AppMethodBeat.m2505o(46216);
        return false;
    }
}
