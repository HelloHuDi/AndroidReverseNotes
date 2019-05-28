package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard thJ;
    private TextView uZA;
    private TextView uZB;
    private String uZz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.b6o;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48738);
        super.onCreate(bundle);
        setMMTitle((int) R.string.f_h);
        initView();
        AppMethodBeat.o(48738);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(48739);
        this.thJ = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        this.uZz = this.mBundle.getString("key_repayment_url");
        if (this.thJ == null) {
            AppMethodBeat.o(48739);
            return;
        }
        this.uZA = (TextView) findViewById(R.id.fi4);
        this.uZA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48736);
                e.n(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.uZz, false);
                AppMethodBeat.o(48736);
            }
        });
        this.uZB = (TextView) findViewById(R.id.f7q);
        this.uZB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48737);
                a.j(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.mBundle);
                AppMethodBeat.o(48737);
            }
        });
        this.uZB.setVisibility(this.mBundle.getBoolean("key_can_unbind", true) ? 0 : 8);
        AppMethodBeat.o(48739);
    }
}
