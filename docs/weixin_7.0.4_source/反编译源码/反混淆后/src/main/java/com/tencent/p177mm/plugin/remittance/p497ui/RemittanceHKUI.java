package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.remittance.model.C13049q;
import com.tencent.p177mm.plugin.remittance.model.C28870p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceHKUI */
public class RemittanceHKUI extends RemittanceBaseUI {
    private int pWj;
    private String pWk;
    private String pWl;
    private String pWm;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceHKUI$1 */
    class C396201 implements OnClickListener {
        C396201() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45073);
            C4990ab.m7416i("MicroMsg.RemittanceHKUI", "hy: on click banner");
            if (!C5046bo.isNullOrNil(RemittanceHKUI.this.pWm)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", RemittanceHKUI.this.pWm);
                intent.putExtra("showShare", false);
                C25985d.m41467b(RemittanceHKUI.this.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(45073);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45074);
        super.onCreate(bundle);
        mo39992nf(1529);
        mo39992nf(1257);
        this.pWj = getIntent().getIntExtra("hk_currency", 0);
        this.pWk = getIntent().getStringExtra("hk_currencyuint");
        this.pWl = getIntent().getStringExtra("hk_notice");
        this.pWm = getIntent().getStringExtra("hk_notice_url");
        this.kGa.setTitleText(this.pWk);
        this.pRk.setText(this.pWk);
        AppMethodBeat.m2505o(45074);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45075);
        super.onDestroy();
        mo39993ng(1529);
        mo39993ng(1257);
        AppMethodBeat.m2505o(45075);
    }

    public final void cfz() {
    }

    /* renamed from: a */
    public final void mo37144a(String str, int i, String str2, String str3, String str4, String str5, String str6, C37719fw c37719fw) {
        AppMethodBeat.m2504i(45076);
        C4990ab.m7410d("MicroMsg.RemittanceHKUI", "do scene gen pay");
        int i2 = 0;
        if (this.pQY == 33) {
            i2 = 1;
        }
        mo39970a(new C13049q(Math.round(this.pQV * 100.0d), this.edV, this.kux, this.pRu, this.eeO, this.pRb, this.pWj, i2), true, false);
        AppMethodBeat.m2505o(45076);
    }

    public final void cfG() {
        AppMethodBeat.m2504i(45078);
        if (!C5046bo.isNullOrNil(this.pWl)) {
            TextView textView = (TextView) findViewById(2131821634);
            textView.setText(this.pWl);
            textView.setOnClickListener(new C396201());
        }
        AppMethodBeat.m2505o(45078);
    }

    public final void cfA() {
        int i;
        AppMethodBeat.m2504i(45079);
        C4990ab.m7410d("MicroMsg.RemittanceHKUI", "do scene cancel");
        if (this.pQY == 33) {
            i = 1;
        } else {
            i = 0;
        }
        mo39970a(new C28870p(this.edV, this.pRb, this.pWj, ((long) this.pQV) * 100, i), false, false);
        AppMethodBeat.m2505o(45079);
    }

    /* renamed from: b */
    public final void mo24300b(int i, int i2, String str, C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(45080);
        if (c1207m instanceof C13049q) {
            C13049q c13049q = (C13049q) c1207m;
            if (i != 0 || i2 != 0) {
                C30379h.m48461b(this.mController.ylL, str, "", false);
                AppMethodBeat.m2505o(45080);
                return;
            } else if (C5046bo.isNullOrNil(c13049q.pPf)) {
                C4990ab.m7412e("MicroMsg.RemittanceHKUI", "empty payurl");
                AppMethodBeat.m2505o(45080);
                return;
            } else {
                C36391e.m59984a(this.mController.ylL, c13049q.pPf, false, 4);
                AppMethodBeat.m2505o(45080);
                return;
            }
        }
        super.mo24300b(i, i2, str, c1207m, z);
        AppMethodBeat.m2505o(45080);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45081);
        if (i == 4 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(45081);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cfM() {
    }

    public final void cfC() {
        AppMethodBeat.m2504i(45077);
        C23639t.makeText(this.mController.ylL, getString(C25738R.string.dpr, new Object[]{this.pWk}), 0).show();
        AppMethodBeat.m2505o(45077);
    }
}
