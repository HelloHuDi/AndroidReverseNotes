package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22582aa;
import com.tencent.p177mm.plugin.wallet_core.p749c.C40094l;
import com.tencent.p177mm.plugin.wallet_core.p749c.C46361p;
import com.tencent.p177mm.pluginsdk.model.app.C46493an;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI */
public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements OnClickListener {
    private ListView tKR;
    private ArrayList<C22582aa> tKS = null;
    private C35511r tKT = null;
    private C22582aa tKU;
    private C22582aa tKV;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI$1 */
    class C226161 implements OnItemClickListener {
        C226161() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47680);
            C22582aa Hz = WalletSwitchWalletCurrencyUI.this.tKT.mo56252Hz(i);
            WalletSwitchWalletCurrencyUI.this.tKV = WalletSwitchWalletCurrencyUI.this.tKT.tKX;
            if (Hz != null && (WalletSwitchWalletCurrencyUI.this.tKV == null || !WalletSwitchWalletCurrencyUI.this.tKV.field_wallet_tpa_country.equals(Hz.field_wallet_tpa_country))) {
                WalletSwitchWalletCurrencyUI.this.tKU = Hz;
                WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = WalletSwitchWalletCurrencyUI.this;
                String str = Hz.field_wallet_tpa_country;
                C4990ab.m7416i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(str)));
                walletSwitchWalletCurrencyUI.mo39970a(new C46361p(str), true, false);
            }
            AppMethodBeat.m2505o(47680);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47681);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ftv);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.tKS = C14241r.cPL().cRg();
        if (this.tKS == null || this.tKS.size() == 0) {
            C4990ab.m7416i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            m47053nq(true);
        } else {
            C4990ab.m7416i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            m47053nq(false);
        }
        initView();
        setResult(0);
        AppMethodBeat.m2505o(47681);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47682);
        this.tKR = (ListView) findViewById(2131829072);
        this.tKT = new C35511r(this, this.tKS);
        this.tKR.setAdapter(this.tKT);
        if (this.tKS != null && this.tKS.size() > 0) {
            this.tKT.mData = this.tKS;
            this.tKT.notifyDataSetChanged();
        }
        this.tKR.setOnItemClickListener(new C226161());
        AppMethodBeat.m2505o(47682);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47683);
        if (c1207m instanceof C40094l) {
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.tKS = C14241r.cPL().cRg();
                this.tKT.mData = this.tKS;
                this.tKT.notifyDataSetChanged();
                AppMethodBeat.m2505o(47683);
                return true;
            }
            C4990ab.m7412e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.tKS == null) {
                C4990ab.m7412e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                AppMethodBeat.m2505o(47683);
                return false;
            }
            C4990ab.m7412e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            AppMethodBeat.m2505o(47683);
            return true;
        } else if ((c1207m instanceof C46361p) && i == 0 && i2 == 0) {
            this.tKU.field_wallet_selected = 1;
            C4990ab.m7416i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.tKU.field_wallet_type + " " + this.tKU.field_wallet_tpa_country_mask);
            C46493an.dhQ().reset();
            C14241r.cPL().mo10103c(this.tKU, new String[0]);
            C22582aa c22582aa = this.tKT.tKX;
            if (c22582aa != null) {
                c22582aa.field_wallet_selected = 0;
                C14241r.cPL().mo10103c(c22582aa, new String[0]);
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(339975, Integer.valueOf(this.tKU.field_wallet_type));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(this.tKU.field_wallet_tpa_country_mask));
            if (C1853r.m3832YN()) {
                C14241r.cPD();
                C14241r.m22433B(this, null);
            }
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(47683);
            return true;
        } else {
            AppMethodBeat.m2505o(47683);
            return false;
        }
    }

    public final int getLayoutId() {
        return 2130971176;
    }

    /* renamed from: nq */
    private void m47053nq(boolean z) {
        AppMethodBeat.m2504i(47684);
        C4990ab.m7416i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(z)));
        mo39970a(new C40094l(), z, false);
        AppMethodBeat.m2505o(47684);
    }

    public void onClick(View view) {
    }
}
