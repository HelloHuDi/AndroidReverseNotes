package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.WxaLuckyMoneyBaseUI;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI */
public class WxaLuckyMoneyCompleteUI extends WxaLuckyMoneyBaseUI implements C28402b {
    private Button nsJ;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI$1 */
    class C284001 implements OnClickListener {
        C284001() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42049);
            WxaLuckyMoneyCompleteUI.this.setResult(0, null);
            WxaLuckyMoneyCompleteUI.this.finish();
            AppMethodBeat.m2505o(42049);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42050);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(42050);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42051);
        this.nsJ = (Button) findViewById(2131829234);
        this.nsJ.setOnClickListener(new C284001());
        AppMethodBeat.m2505o(42051);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42052);
        setResult(0, null);
        finish();
        AppMethodBeat.m2505o(42052);
    }

    public final int getLayoutId() {
        return 2130971243;
    }

    public final MMActivity bKU() {
        return this;
    }

    /* renamed from: Qf */
    public final void mo24264Qf(String str) {
    }

    public final void bKV() {
    }
}
