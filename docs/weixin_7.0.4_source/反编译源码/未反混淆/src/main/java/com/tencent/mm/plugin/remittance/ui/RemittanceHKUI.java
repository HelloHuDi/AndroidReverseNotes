package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.e;

public class RemittanceHKUI extends RemittanceBaseUI {
    private int pWj;
    private String pWk;
    private String pWl;
    private String pWm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45074);
        super.onCreate(bundle);
        nf(1529);
        nf(1257);
        this.pWj = getIntent().getIntExtra("hk_currency", 0);
        this.pWk = getIntent().getStringExtra("hk_currencyuint");
        this.pWl = getIntent().getStringExtra("hk_notice");
        this.pWm = getIntent().getStringExtra("hk_notice_url");
        this.kGa.setTitleText(this.pWk);
        this.pRk.setText(this.pWk);
        AppMethodBeat.o(45074);
    }

    public void onDestroy() {
        AppMethodBeat.i(45075);
        super.onDestroy();
        ng(1529);
        ng(1257);
        AppMethodBeat.o(45075);
    }

    public final void cfz() {
    }

    public final void a(String str, int i, String str2, String str3, String str4, String str5, String str6, fw fwVar) {
        AppMethodBeat.i(45076);
        ab.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
        int i2 = 0;
        if (this.pQY == 33) {
            i2 = 1;
        }
        a(new q(Math.round(this.pQV * 100.0d), this.edV, this.kux, this.pRu, this.eeO, this.pRb, this.pWj, i2), true, false);
        AppMethodBeat.o(45076);
    }

    public final void cfG() {
        AppMethodBeat.i(45078);
        if (!bo.isNullOrNil(this.pWl)) {
            TextView textView = (TextView) findViewById(R.id.a2f);
            textView.setText(this.pWl);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45073);
                    ab.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
                    if (!bo.isNullOrNil(RemittanceHKUI.this.pWm)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", RemittanceHKUI.this.pWm);
                        intent.putExtra("showShare", false);
                        d.b(RemittanceHKUI.this.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(45073);
                }
            });
        }
        AppMethodBeat.o(45078);
    }

    public final void cfA() {
        int i;
        AppMethodBeat.i(45079);
        ab.d("MicroMsg.RemittanceHKUI", "do scene cancel");
        if (this.pQY == 33) {
            i = 1;
        } else {
            i = 0;
        }
        a(new p(this.edV, this.pRb, this.pWj, ((long) this.pQV) * 100, i), false, false);
        AppMethodBeat.o(45079);
    }

    public final void b(int i, int i2, String str, m mVar, boolean z) {
        AppMethodBeat.i(45080);
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            if (i != 0 || i2 != 0) {
                h.b(this.mController.ylL, str, "", false);
                AppMethodBeat.o(45080);
                return;
            } else if (bo.isNullOrNil(qVar.pPf)) {
                ab.e("MicroMsg.RemittanceHKUI", "empty payurl");
                AppMethodBeat.o(45080);
                return;
            } else {
                e.a(this.mController.ylL, qVar.pPf, false, 4);
                AppMethodBeat.o(45080);
                return;
            }
        }
        super.b(i, i2, str, mVar, z);
        AppMethodBeat.o(45080);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45081);
        if (i == 4 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(45081);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cfM() {
    }

    public final void cfC() {
        AppMethodBeat.i(45077);
        t.makeText(this.mController.ylL, getString(R.string.dpr, new Object[]{this.pWk}), 0).show();
        AppMethodBeat.o(45077);
    }
}
