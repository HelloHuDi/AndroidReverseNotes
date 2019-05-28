package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI extends WalletECardBaseUI {
    private Button gEZ;
    private WalletFormView tFS;
    private ElementQuery tvu;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48140);
        super.onCreate(bundle);
        setMMTitle((int) R.string.b89);
        initView();
        cu();
        AppMethodBeat.o(48140);
    }

    public final void initView() {
        AppMethodBeat.i(48141);
        this.tFS = (WalletFormView) findViewById(R.id.bbc);
        this.tFS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48138);
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletECardElementInputUI.this.mBundle.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletECardElementInputUI.this.mBundle.getInt("key_bind_scene", -1));
                if (!bo.isNullOrNil(WalletECardElementInputUI.this.tFS.getText())) {
                    bundle.putString("key_bank_type", WalletECardElementInputUI.this.tvu.pbn);
                    bundle.putInt("key_bankcard_type", WalletECardElementInputUI.this.tvu.tyE);
                }
                c aE = a.aE(WalletECardElementInputUI.this);
                if (aE != null) {
                    aE.a(WalletECardElementInputUI.this, WalletCardSelectUI.class, bundle, 1);
                }
                AppMethodBeat.o(48138);
            }
        });
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48139);
                ab.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", WalletECardElementInputUI.this.tvu.pbn);
                WalletECardElementInputUI.this.dOE().p(WalletECardElementInputUI.this.tvu);
                AppMethodBeat.o(48139);
            }
        });
        AppMethodBeat.o(48141);
    }

    private void cu() {
        AppMethodBeat.i(48142);
        if (this.tvu == null) {
            this.tvu = new ElementQuery();
        }
        if (bo.isNullOrNil(this.tvu.nuL)) {
            this.tFS.setText("");
            AppMethodBeat.o(48142);
        } else if (!bo.isNullOrNil(this.tvu.tyF)) {
            this.tFS.setText(this.tvu.nuL + " " + this.tvu.tyF);
            AppMethodBeat.o(48142);
        } else if (2 == this.tvu.tyE) {
            this.tFS.setText(this.tvu.nuL + " " + getString(R.string.fdu));
            AppMethodBeat.o(48142);
        } else {
            this.tFS.setText(this.tvu.nuL + " " + getString(R.string.fed));
            AppMethodBeat.o(48142);
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.t3;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48143);
        ab.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(48143);
            return;
        }
        switch (i) {
            case 1:
                this.tvu = (ElementQuery) intent.getParcelableExtra("elemt_query");
                cu();
                AppMethodBeat.o(48143);
                return;
            default:
                super.onActivityResult(i, i2, intent);
                AppMethodBeat.o(48143);
                return;
        }
    }
}
