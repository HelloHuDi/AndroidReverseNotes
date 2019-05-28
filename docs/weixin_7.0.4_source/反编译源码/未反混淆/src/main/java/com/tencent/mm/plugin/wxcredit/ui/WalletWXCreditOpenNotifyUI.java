package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6p;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48742);
        super.onCreate(bundle);
        g.RQ();
        g.RP().Ry().set(196658, Boolean.FALSE);
        initView();
        AppMethodBeat.o(48742);
    }

    public final void initView() {
        int i = 0;
        AppMethodBeat.i(48743);
        setMMTitle((int) R.string.fx0);
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48740);
                WalletWXCreditOpenNotifyUI.this.setResult(-1);
                WalletWXCreditOpenNotifyUI.this.finish();
                AppMethodBeat.o(48740);
                return true;
            }
        });
        ((TextView) findViewById(R.id.fhp)).setText(e.G(this.mBundle.getDouble("key_total_amount")));
        Button button = (Button) findViewById(R.id.ay8);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48741);
                Bundle bundle = new Bundle();
                bundle.putParcelable("key_bankcard", WalletWXCreditOpenNotifyUI.this.mBundle.getParcelable("key_bankcard"));
                a.a(WalletWXCreditOpenNotifyUI.this, b.class, bundle);
                AppMethodBeat.o(48741);
            }
        });
        if (!this.mBundle.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
        AppMethodBeat.o(48743);
    }
}
