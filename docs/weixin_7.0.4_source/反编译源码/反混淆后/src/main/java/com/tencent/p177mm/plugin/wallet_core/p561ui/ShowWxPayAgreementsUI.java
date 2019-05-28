package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI */
public class ShowWxPayAgreementsUI extends MMActivity {
    private String content;
    private MMWebView tDY;
    private TextView tDZ;
    private TextView tEa;
    private int type;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI$1 */
    class C43981 implements OnClickListener {
        C43981() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47132);
            C7060h.pYm.mo8381e(15236, Integer.valueOf(2));
            ShowWxPayAgreementsUI.this.setResult(-1);
            ShowWxPayAgreementsUI.this.finish();
            AppMethodBeat.m2505o(47132);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI$2 */
    class C43992 implements OnClickListener {
        C43992() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47133);
            C7060h.pYm.mo8381e(15236, Integer.valueOf(3));
            ShowWxPayAgreementsUI.this.finish();
            AppMethodBeat.m2505o(47133);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47134);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(47134);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47135);
        C7060h.pYm.mo8381e(15236, Integer.valueOf(1));
        getSupportActionBar().hide();
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8293s);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.tDY = C30798a.m49143g(this, this.mController.contentView);
        this.tDY.getSettings().setJavaScriptEnabled(true);
        this.tDZ = (TextView) findViewById(2131827553);
        this.tEa = (TextView) findViewById(2131827554);
        this.content = getIntent().getStringExtra("agreement_content");
        this.tEa.setOnClickListener(new C43981());
        this.tDZ.setOnClickListener(new C43992());
        this.tDY.setWebViewClient(new C43816g(this));
        this.tDY.loadData(this.content, "text/html; charset=UTF-8", null);
        AppMethodBeat.m2505o(47135);
    }

    public final int getLayoutId() {
        return 2130970680;
    }

    public void finish() {
        AppMethodBeat.m2504i(47136);
        C4990ab.m7416i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(47136);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47137);
        super.onResume();
        AppMethodBeat.m2505o(47137);
    }

    public void onPause() {
        AppMethodBeat.m2504i(47138);
        super.onPause();
        AppMethodBeat.m2505o(47138);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47139);
        if (i == 4) {
            AppMethodBeat.m2505o(47139);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(47139);
        return onKeyDown;
    }
}
