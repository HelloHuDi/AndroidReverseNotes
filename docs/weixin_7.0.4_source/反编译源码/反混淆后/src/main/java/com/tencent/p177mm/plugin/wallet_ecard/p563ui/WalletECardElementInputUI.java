package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardSelectUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI */
public class WalletECardElementInputUI extends WalletECardBaseUI {
    private Button gEZ;
    private WalletFormView tFS;
    private ElementQuery tvu;

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI$2 */
    class C143392 implements OnClickListener {
        C143392() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48139);
            C4990ab.m7417i("MicroMsg.WalletECardElementInputUI", "goto next: %s", WalletECardElementInputUI.this.tvu.pbn);
            WalletECardElementInputUI.this.dOE().mo9366p(WalletECardElementInputUI.this.tvu);
            AppMethodBeat.m2505o(48139);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI$1 */
    class C226861 implements OnClickListener {
        C226861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48138);
            Bundle bundle = new Bundle();
            bundle.putInt("key_support_bankcard", WalletECardElementInputUI.this.mBundle.getInt("key_support_bankcard", 3));
            bundle.putInt("key_bind_scene", WalletECardElementInputUI.this.mBundle.getInt("key_bind_scene", -1));
            if (!C5046bo.isNullOrNil(WalletECardElementInputUI.this.tFS.getText())) {
                bundle.putString("key_bank_type", WalletECardElementInputUI.this.tvu.pbn);
                bundle.putInt("key_bankcard_type", WalletECardElementInputUI.this.tvu.tyE);
            }
            C40931c aE = C24143a.m37112aE(WalletECardElementInputUI.this);
            if (aE != null) {
                aE.mo64562a(WalletECardElementInputUI.this, WalletCardSelectUI.class, bundle, 1);
            }
            AppMethodBeat.m2505o(48138);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48140);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.b89);
        initView();
        m34426cu();
        AppMethodBeat.m2505o(48140);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48141);
        this.tFS = (WalletFormView) findViewById(2131823369);
        this.tFS.setOnClickListener(new C226861());
        this.gEZ = (Button) findViewById(2131822846);
        this.gEZ.setOnClickListener(new C143392());
        AppMethodBeat.m2505o(48141);
    }

    /* renamed from: cu */
    private void m34426cu() {
        AppMethodBeat.m2504i(48142);
        if (this.tvu == null) {
            this.tvu = new ElementQuery();
        }
        if (C5046bo.isNullOrNil(this.tvu.nuL)) {
            this.tFS.setText("");
            AppMethodBeat.m2505o(48142);
        } else if (!C5046bo.isNullOrNil(this.tvu.tyF)) {
            this.tFS.setText(this.tvu.nuL + " " + this.tvu.tyF);
            AppMethodBeat.m2505o(48142);
        } else if (2 == this.tvu.tyE) {
            this.tFS.setText(this.tvu.nuL + " " + getString(C25738R.string.fdu));
            AppMethodBeat.m2505o(48142);
        } else {
            this.tFS.setText(this.tvu.nuL + " " + getString(C25738R.string.fed));
            AppMethodBeat.m2505o(48142);
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130969310;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48143);
        C4990ab.m7416i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(48143);
            return;
        }
        switch (i) {
            case 1:
                this.tvu = (ElementQuery) intent.getParcelableExtra("elemt_query");
                m34426cu();
                AppMethodBeat.m2505o(48143);
                return;
            default:
                super.onActivityResult(i, i2, intent);
                AppMethodBeat.m2505o(48143);
                return;
        }
    }
}
