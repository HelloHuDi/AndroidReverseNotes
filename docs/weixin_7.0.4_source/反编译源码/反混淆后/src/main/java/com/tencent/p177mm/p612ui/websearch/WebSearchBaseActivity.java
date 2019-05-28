package com.tencent.p177mm.p612ui.websearch;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.ui.websearch.WebSearchBaseActivity */
public abstract class WebSearchBaseActivity extends CustomStatusBarMMActivity {

    /* renamed from: com.tencent.mm.ui.websearch.WebSearchBaseActivity$1 */
    class C240821 implements OnMenuItemClickListener {
        C240821() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35380);
            WebSearchBaseActivity.this.finish();
            AppMethodBeat.m2505o(35380);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dxZ();
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(C25738R.color.a5q));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.a5q)));
        }
        setBackBtn(new C240821());
    }

    /* Access modifiers changed, original: protected|final */
    public final int getStatusBarColor() {
        return getResources().getColor(C25738R.color.a5q);
    }
}
