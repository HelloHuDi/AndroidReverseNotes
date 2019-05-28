package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;

@C5271a(1)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI */
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView nrZ;
    private C29619r tlb;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI$1 */
    class C354361 implements OnMenuItemClickListener {
        C354361() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45709);
            WalletLqtSimpleCheckPwdUI.this.finish();
            AppMethodBeat.m2505o(45709);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI$2 */
    class C354372 implements C30883a {
        C354372() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(45710);
            if (z) {
                WalletLqtSimpleCheckPwdUI.this.tlb = new C29619r(WalletLqtSimpleCheckPwdUI.this.nrZ.getText(), 7, WalletLqtSimpleCheckPwdUI.this.cNH());
                WalletLqtSimpleCheckPwdUI.this.mo39970a(WalletLqtSimpleCheckPwdUI.this.tlb, true, false);
            }
            AppMethodBeat.m2505o(45710);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String string;
        AppMethodBeat.m2504i(45711);
        super.onCreate(bundle);
        if (C1853r.m3831YM()) {
            string = getString(C25738R.string.fdg);
        } else {
            string = getString(C25738R.string.fdf);
        }
        setMMTitle(string);
        setBackBtn(new C354361());
        ((TextView) findViewById(2131828577)).setText(C25738R.string.fdd);
        this.nrZ = (EditHintPasswdView) findViewById(2131824902);
        C30890a.m49291a(this.nrZ);
        this.nrZ.setOnInputValidListener(new C354372());
        mo39989e(this.nrZ, 0, false);
        AppMethodBeat.m2505o(45711);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45712);
        C4990ab.m7411d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C29619r) {
            if (i == 0 && i2 == 0) {
                String text = this.nrZ.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(45712);
                return true;
            } else if (this.nrZ != null) {
                this.nrZ.cey();
            }
        }
        AppMethodBeat.m2505o(45712);
        return false;
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(45713);
        super.mo8137wU(i);
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        AppMethodBeat.m2505o(45713);
    }

    public final int getLayoutId() {
        return 2130971123;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
