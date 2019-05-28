package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ extends MMWizardActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13772);
        super.onCreate(bundle);
        AppMethodBeat.o(13772);
    }

    public void onDestroy() {
        AppMethodBeat.i(13773);
        super.onDestroy();
        AppMethodBeat.o(13773);
    }

    public void onResume() {
        AppMethodBeat.i(13774);
        super.onResume();
        initView();
        AppMethodBeat.o(13774);
    }

    public final int getLayoutId() {
        return R.layout.az7;
    }

    public final void initView() {
        AppMethodBeat.i(13775);
        setMMTitle((int) R.string.ey9);
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13771);
                SuccUnbindQQ.a(SuccUnbindQQ.this);
                AppMethodBeat.o(13771);
                return true;
            }
        });
        AppMethodBeat.o(13775);
    }

    static /* synthetic */ void a(SuccUnbindQQ succUnbindQQ) {
        AppMethodBeat.i(13776);
        succUnbindQQ.Ni(1);
        AppMethodBeat.o(13776);
    }
}
