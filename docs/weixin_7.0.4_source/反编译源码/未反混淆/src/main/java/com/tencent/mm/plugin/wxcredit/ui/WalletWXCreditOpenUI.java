package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button gHn;
    private Bankcard tmw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6r;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48753);
        super.onCreate(bundle);
        this.tmw = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        initView();
        AppMethodBeat.o(48753);
    }

    public final void initView() {
        AppMethodBeat.i(48754);
        setMMTitle((int) R.string.fx9);
        ((CheckBox) findViewById(R.id.f9i)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(48750);
                WalletWXCreditOpenUI.this.gHn.setEnabled(z);
                AppMethodBeat.o(48750);
            }
        });
        findViewById(R.id.daa).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48751);
                e.a(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.this.tmw.field_bankcardType, WalletWXCreditOpenUI.this.tmw.field_bankName, true, false);
                AppMethodBeat.o(48751);
            }
        });
        this.gHn = (Button) findViewById(R.id.ay8);
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48752);
                WalletWXCreditOpenUI.this.dY();
                AppMethodBeat.o(48752);
            }
        });
        AppMethodBeat.o(48754);
    }
}
