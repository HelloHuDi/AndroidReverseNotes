package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements OnClickListener {
    private ListView tKR;
    private ArrayList<aa> tKS = null;
    private r tKT = null;
    private aa tKU;
    private aa tKV;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47681);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ftv);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.tKS = r.cPL().cRg();
        if (this.tKS == null || this.tKS.size() == 0) {
            ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            nq(true);
        } else {
            ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            nq(false);
        }
        initView();
        setResult(0);
        AppMethodBeat.o(47681);
    }

    public final void initView() {
        AppMethodBeat.i(47682);
        this.tKR = (ListView) findViewById(R.id.fhi);
        this.tKT = new r(this, this.tKS);
        this.tKR.setAdapter(this.tKT);
        if (this.tKS != null && this.tKS.size() > 0) {
            this.tKT.mData = this.tKS;
            this.tKT.notifyDataSetChanged();
        }
        this.tKR.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(47680);
                aa Hz = WalletSwitchWalletCurrencyUI.this.tKT.Hz(i);
                WalletSwitchWalletCurrencyUI.this.tKV = WalletSwitchWalletCurrencyUI.this.tKT.tKX;
                if (Hz != null && (WalletSwitchWalletCurrencyUI.this.tKV == null || !WalletSwitchWalletCurrencyUI.this.tKV.field_wallet_tpa_country.equals(Hz.field_wallet_tpa_country))) {
                    WalletSwitchWalletCurrencyUI.this.tKU = Hz;
                    WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = WalletSwitchWalletCurrencyUI.this;
                    String str = Hz.field_wallet_tpa_country;
                    ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(str)));
                    walletSwitchWalletCurrencyUI.a(new p(str), true, false);
                }
                AppMethodBeat.o(47680);
            }
        });
        AppMethodBeat.o(47682);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47683);
        if (mVar instanceof l) {
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.tKS = r.cPL().cRg();
                this.tKT.mData = this.tKS;
                this.tKT.notifyDataSetChanged();
                AppMethodBeat.o(47683);
                return true;
            }
            ab.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.tKS == null) {
                ab.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                AppMethodBeat.o(47683);
                return false;
            }
            ab.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            AppMethodBeat.o(47683);
            return true;
        } else if ((mVar instanceof p) && i == 0 && i2 == 0) {
            this.tKU.field_wallet_selected = 1;
            ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.tKU.field_wallet_type + " " + this.tKU.field_wallet_tpa_country_mask);
            an.dhQ().reset();
            r.cPL().c(this.tKU, new String[0]);
            aa aaVar = this.tKT.tKX;
            if (aaVar != null) {
                aaVar.field_wallet_selected = 0;
                r.cPL().c(aaVar, new String[0]);
            }
            g.RQ();
            g.RP().Ry().set(339975, Integer.valueOf(this.tKU.field_wallet_type));
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(this.tKU.field_wallet_tpa_country_mask));
            if (com.tencent.mm.model.r.YN()) {
                r.cPD();
                r.B(this, null);
            }
            setResult(-1);
            finish();
            AppMethodBeat.o(47683);
            return true;
        } else {
            AppMethodBeat.o(47683);
            return false;
        }
    }

    public final int getLayoutId() {
        return R.layout.b6c;
    }

    private void nq(boolean z) {
        AppMethodBeat.i(47684);
        ab.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(z)));
        a(new l(), z, false);
        AppMethodBeat.o(47684);
    }

    public void onClick(View view) {
    }
}
