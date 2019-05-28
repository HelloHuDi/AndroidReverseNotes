package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;

public final class AppBrandNearbyEmptyUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.cj;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(132993);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(132993);
            return;
        }
        this.mController.contentView.setBackgroundColor(-855310);
        xE(-855310);
        setMMTitle((int) R.string.l5);
        ta(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(132992);
                AppBrandNearbyEmptyUI.this.onBackPressed();
                AppMethodBeat.o(132992);
                return true;
            }
        });
        p.b(this);
        TextView textView = (TextView) findViewById(R.id.s1);
        TextView textView2 = (TextView) findViewById(R.id.s2);
        l lVar;
        switch (getIntent().getIntExtra("extra_enter_reason", 0)) {
            case 0:
                lVar = new l();
                lVar.iBL = b.TOP_ENTRANCE_IN_DESKTOP;
                lVar.iBP = a.EMPTY_PAGE;
                lVar.IF();
                break;
            case 1:
                textView.setText(R.string.l4);
                textView2.setText(R.string.l3);
                lVar = new l();
                lVar.iBL = b.TOP_ENTRANCE_IN_DESKTOP;
                lVar.iBP = a.LBS_NOT_ALLOW;
                lVar.IF();
                break;
            default:
                finish();
                AppMethodBeat.o(132993);
                return;
        }
        setResult(-1);
        AppMethodBeat.o(132993);
    }
}
