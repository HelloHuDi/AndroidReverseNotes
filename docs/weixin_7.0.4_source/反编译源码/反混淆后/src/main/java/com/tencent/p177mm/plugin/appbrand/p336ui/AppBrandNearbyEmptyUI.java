package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.report.model.C10721l;
import com.tencent.p177mm.plugin.appbrand.report.model.C10721l.C10720b;
import com.tencent.p177mm.plugin.appbrand.report.model.C10721l.C10722a;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI */
public final class AppBrandNearbyEmptyUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI$1 */
    class C273201 implements OnMenuItemClickListener {
        C273201() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(132992);
            AppBrandNearbyEmptyUI.this.onBackPressed();
            AppMethodBeat.m2505o(132992);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968696;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132993);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(132993);
            return;
        }
        this.mController.contentView.setBackgroundColor(-855310);
        mo17446xE(-855310);
        setMMTitle((int) C25738R.string.f8969l5);
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new C273201());
        C42698p.m75626b(this);
        TextView textView = (TextView) findViewById(2131821237);
        TextView textView2 = (TextView) findViewById(2131821238);
        C10721l c10721l;
        switch (getIntent().getIntExtra("extra_enter_reason", 0)) {
            case 0:
                c10721l = new C10721l();
                c10721l.iBL = C10720b.TOP_ENTRANCE_IN_DESKTOP;
                c10721l.iBP = C10722a.EMPTY_PAGE;
                c10721l.mo22274IF();
                break;
            case 1:
                textView.setText(C25738R.string.f8968l4);
                textView2.setText(C25738R.string.f8967l3);
                c10721l = new C10721l();
                c10721l.iBL = C10720b.TOP_ENTRANCE_IN_DESKTOP;
                c10721l.iBP = C10722a.LBS_NOT_ALLOW;
                c10721l.mo22274IF();
                break;
            default:
                finish();
                AppMethodBeat.m2505o(132993);
                return;
        }
        setResult(-1);
        AppMethodBeat.m2505o(132993);
    }
}
