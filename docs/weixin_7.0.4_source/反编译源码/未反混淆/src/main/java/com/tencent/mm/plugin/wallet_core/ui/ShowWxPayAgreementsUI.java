package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowWxPayAgreementsUI extends MMActivity {
    private String content;
    private MMWebView tDY;
    private TextView tDZ;
    private TextView tEa;
    private int type;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47134);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(47134);
    }

    public final void initView() {
        AppMethodBeat.i(47135);
        h.pYm.e(15236, Integer.valueOf(1));
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.cg, R.anim.s);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.tDY = MMWebView.a.g(this, this.mController.contentView);
        this.tDY.getSettings().setJavaScriptEnabled(true);
        this.tDZ = (TextView) findViewById(R.id.edg);
        this.tEa = (TextView) findViewById(R.id.edh);
        this.content = getIntent().getStringExtra("agreement_content");
        this.tEa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47132);
                h.pYm.e(15236, Integer.valueOf(2));
                ShowWxPayAgreementsUI.this.setResult(-1);
                ShowWxPayAgreementsUI.this.finish();
                AppMethodBeat.o(47132);
            }
        });
        this.tDZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47133);
                h.pYm.e(15236, Integer.valueOf(3));
                ShowWxPayAgreementsUI.this.finish();
                AppMethodBeat.o(47133);
            }
        });
        this.tDY.setWebViewClient(new g(this));
        this.tDY.loadData(this.content, "text/html; charset=UTF-8", null);
        AppMethodBeat.o(47135);
    }

    public final int getLayoutId() {
        return R.layout.at1;
    }

    public void finish() {
        AppMethodBeat.i(47136);
        ab.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.ce);
        AppMethodBeat.o(47136);
    }

    public void onResume() {
        AppMethodBeat.i(47137);
        super.onResume();
        AppMethodBeat.o(47137);
    }

    public void onPause() {
        AppMethodBeat.i(47138);
        super.onPause();
        AppMethodBeat.o(47138);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47139);
        if (i == 4) {
            AppMethodBeat.o(47139);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(47139);
        return onKeyDown;
    }
}
