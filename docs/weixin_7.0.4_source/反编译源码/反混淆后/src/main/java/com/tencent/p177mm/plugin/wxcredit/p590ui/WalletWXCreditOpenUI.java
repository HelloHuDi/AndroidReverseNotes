package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI */
public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button gHn;
    private Bankcard tmw;

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI$1 */
    class C404131 implements OnCheckedChangeListener {
        C404131() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(48750);
            WalletWXCreditOpenUI.this.gHn.setEnabled(z);
            AppMethodBeat.m2505o(48750);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI$3 */
    class C404143 implements OnClickListener {
        C404143() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48752);
            WalletWXCreditOpenUI.this.mo39988dY();
            AppMethodBeat.m2505o(48752);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI$2 */
    class C440322 implements OnClickListener {
        C440322() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48751);
            C36391e.m59983a(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.this.tmw.field_bankcardType, WalletWXCreditOpenUI.this.tmw.field_bankName, true, false);
            AppMethodBeat.m2505o(48751);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971191;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48753);
        super.onCreate(bundle);
        this.tmw = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        initView();
        AppMethodBeat.m2505o(48753);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48754);
        setMMTitle((int) C25738R.string.fx9);
        ((CheckBox) findViewById(2131828739)).setOnCheckedChangeListener(new C404131());
        findViewById(2131826067).setOnClickListener(new C440322());
        this.gHn = (Button) findViewById(2131822846);
        this.gHn.setOnClickListener(new C404143());
        AppMethodBeat.m2505o(48754);
    }
}
