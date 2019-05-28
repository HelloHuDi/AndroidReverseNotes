package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.ui.MMActivity;

public class WxaLuckyMoneyCompleteUI extends WxaLuckyMoneyBaseUI implements b {
    private Button nsJ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42050);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(42050);
    }

    public final void initView() {
        AppMethodBeat.i(42051);
        this.nsJ = (Button) findViewById(R.id.flw);
        this.nsJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42049);
                WxaLuckyMoneyCompleteUI.this.setResult(0, null);
                WxaLuckyMoneyCompleteUI.this.finish();
                AppMethodBeat.o(42049);
            }
        });
        AppMethodBeat.o(42051);
    }

    public void onBackPressed() {
        AppMethodBeat.i(42052);
        setResult(0, null);
        finish();
        AppMethodBeat.o(42052);
    }

    public final int getLayoutId() {
        return R.layout.b86;
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void Qf(String str) {
    }

    public final void bKV() {
    }
}
