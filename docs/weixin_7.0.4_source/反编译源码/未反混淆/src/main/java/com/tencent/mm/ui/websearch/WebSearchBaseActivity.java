package com.tencent.mm.ui.websearch;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public abstract class WebSearchBaseActivity extends CustomStatusBarMMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dxZ();
        ta(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.color.a5q));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a5q)));
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35380);
                WebSearchBaseActivity.this.finish();
                AppMethodBeat.o(35380);
                return true;
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final int getStatusBarColor() {
        return getResources().getColor(R.color.a5q);
    }
}
