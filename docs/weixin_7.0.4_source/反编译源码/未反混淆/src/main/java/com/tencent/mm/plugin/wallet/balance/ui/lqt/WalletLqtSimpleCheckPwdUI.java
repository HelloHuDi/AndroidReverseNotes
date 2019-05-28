package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(1)
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView nrZ;
    private r tlb;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String string;
        AppMethodBeat.i(45711);
        super.onCreate(bundle);
        if (com.tencent.mm.model.r.YM()) {
            string = getString(R.string.fdg);
        } else {
            string = getString(R.string.fdf);
        }
        setMMTitle(string);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45709);
                WalletLqtSimpleCheckPwdUI.this.finish();
                AppMethodBeat.o(45709);
                return false;
            }
        });
        ((TextView) findViewById(R.id.f55)).setText(R.string.fdd);
        this.nrZ = (EditHintPasswdView) findViewById(R.id.cfs);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.nrZ);
        this.nrZ.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(45710);
                if (z) {
                    WalletLqtSimpleCheckPwdUI.this.tlb = new r(WalletLqtSimpleCheckPwdUI.this.nrZ.getText(), 7, WalletLqtSimpleCheckPwdUI.this.cNH());
                    WalletLqtSimpleCheckPwdUI.this.a(WalletLqtSimpleCheckPwdUI.this.tlb, true, false);
                }
                AppMethodBeat.o(45710);
            }
        });
        e(this.nrZ, 0, false);
        AppMethodBeat.o(45711);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45712);
        ab.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof r) {
            if (i == 0 && i2 == 0) {
                String text = this.nrZ.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(45712);
                return true;
            } else if (this.nrZ != null) {
                this.nrZ.cey();
            }
        }
        AppMethodBeat.o(45712);
        return false;
    }

    public final void wU(int i) {
        AppMethodBeat.i(45713);
        super.wU(i);
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        AppMethodBeat.o(45713);
    }

    public final int getLayoutId() {
        return R.layout.b4x;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
